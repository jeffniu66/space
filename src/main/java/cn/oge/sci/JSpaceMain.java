package cn.oge.sci;

import java.util.ArrayList;
import java.util.List;

import org.oge.common.decompress.model.MasterModel;
import org.oge.spacecacu.main.MainDeal;
import org.oge.spacecacu.model.SpaceNeed;
import org.oge.spacecacu.model.SpaceResult;

import cn.oge.kdm.service.dto.RTDataSet;
import cn.oge.sci.algorithm.OgeAlgUtils;
import cn.oge.sci.data.kdm.KdmDubboApi;
import cn.oge.sci.space.PersistBuilder;
import cn.oge.sci.space.SpaceHelper;
import cn.oge.sci.util.Constant;
import cn.oge.sci.util.KdmJsonUtils;
import cn.oge.sci.util.KdmUtils;
import cn.oge.sci.util.RestDataloader;
import cn.oge.sci.util.RtdsTimeHelper;

public class JSpaceMain {

	private static RtdsTimeHelper timeHelper;

	public static StatInfo calc(String[] kks, String host, int port, int dubboPort) {
		return calc(kks, host, port, dubboPort, null);
	}

	public static StatInfo calc1(String host, int port, int dubboPort, int[] enableFlags, String[][] kksArr) {
		String[] inKks = new String[12];
		List<String> outKksList = new ArrayList<String>();
		// 12个通道
		for (int i = 0; i < enableFlags.length; i++) {

			int flag = enableFlags[i];
			if (flag == 1) {
				inKks[i] = kksArr[i][0];
				outKksList.add(kksArr[i][1]);// 平均值
				outKksList.add(kksArr[i][2]);// 峰峰值
				outKksList.add(kksArr[i][3]);// 偏心量or偏心角
			} else {
				inKks[i] = null;
				outKksList.add("");// 平均值
				outKksList.add("");// 峰峰值
				outKksList.add("");// 偏心量or偏心角
			}

		}

		// ======================================
		// 最后三个Port端口：弯曲、盘车、转子镜板
		// --------------------------------------
		// [13] 弯曲量-偏心量与偏心角(3*2=6)
		// 上导、下导、水导
		// [14] 盘车量-偏心量与偏心角(4*2=8)
		// 上导盘车、下导盘车、上水导盘车、下水导盘车
		// [15] 转子镜板-偏心量与偏心角(3*2=6)
		// 转子回转、转子离心力、镜板
		int[] portSize = new int[] { 6, 8, 6 };
		for (int i = 0; i < portSize.length; i++) {
			int size = portSize[i];
			for (int j = 0; j < size; j++) {
				outKksList.add(kksArr[12 + i][j]);
			}
		}
		return calc(inKks, host, port, dubboPort, outKksList);
	}

	public static StatInfo calc(String[] kks, String host, int port, int dubboPort, List<String> kksList) {
		List<RTDataSet> rtdsList = null;
		try {
			rtdsList = RestDataloader.getSnapshot(kks, host, port);

			// 时间相关校验处理
			if (timeHelper == null) {
				timeHelper = new RtdsTimeHelper(rtdsList);
			} else {
				timeHelper.check(rtdsList);
			}

			if (!timeHelper.isValid()) {
				return new StatInfo(timeHelper.getErrorNo());
			}

			// 数据排序
			if (kks != null) {
				rtdsList = KdmUtils.sortRtds(rtdsList, kks);
			}

			MasterModel[] masterModels = OgeAlgUtils.getMasterModels(rtdsList);
			SpaceResult result = calc(masterModels);

			// 不进行保存动作
			if (kksList == null) {
				return new StatInfo(Constant.CALC_SUCCESS);
			}

			List<RTDataSet> rtDataSetList = PersistBuilder.buildRTDataSet(result, kksList, timeHelper.getMinTime());
			String dubboUrl = "dubbo://" + host + ":" + dubboPort;
			KdmDubboApi kdmDubboApi = new KdmDubboApi(dubboUrl);
			kdmDubboApi.writeRtds(rtDataSetList);
			System.out.println("本次写入数据成功！");
			if (result == null) {
				System.out.println("no space result -------->");

				return new StatInfo(Constant.ALG_RESULT_ISNULL);
			}
			System.out.println("calc space ok -------->");
			SpaceHelper.printResult(result);
			return new StatInfo(Constant.WRITE_SUCCESS);
		} catch (Exception e) {
			// 记录一下错误数据包
			if (rtdsList != null) {
				// FOR TEST
				// KdmJsonUtils.saveToFile(rtdsList, "space-" + new
				// Date().getTime() + ".json");
			}
			e.printStackTrace();
		}
		System.out.println("calc space [error] -------->");
		return new StatInfo(Constant.CACL_ERROR);
	}

	public static SpaceResult calc(MasterModel[] master) throws Exception {
		SpaceNeed one = new SpaceNeed(master, true);
		return MainDeal.cacuAll(one);
	}

	public static SpaceResult calc(String jsonFile) throws Exception {
		return calc(jsonFile, null);
	}

	public static SpaceResult calc(String jsonFile, String[] kksArr) throws Exception {
		// System.out.println(jsonFile);
		// 从json文件中读取
		String json = KdmJsonUtils.readFile(jsonFile);
		// 将json对象转成RTDataSet
		List<RTDataSet> rtdsList = KdmJsonUtils.getRTDataSet(json);
		if (kksArr != null) {
			rtdsList = KdmUtils.sortRtds(rtdsList, kksArr);
		}
		// RTDataSet转成波形对象MasterModel
		MasterModel[] models = OgeAlgUtils.getMasterModels(rtdsList);
		MasterModel[] inputModels = new MasterModel[12];
		for (int i = 0; i < models.length; i++) {
			inputModels[i] = models[i];
		}
		SpaceResult result = calc(inputModels);
		return result;
	}
}
