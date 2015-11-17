package cn.oge.sci.space.xtd;

import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;

import org.junit.Test;

import cn.oge.kdm.service.dto.RTDataSet;
import cn.oge.kdm.service.dto.RTValue;
import cn.oge.sci.data.DataLoader;
import cn.oge.sci.data.kdm.KdmDubboApi;
import cn.oge.sci.kks.KKS_XTD_02;
import cn.oge.sci.kks.KKS_XTD_03;
import cn.oge.sci.util.KdmJsonUtils;
import cn.oge.sci.util.KdmUtils;

public class JsonData_XTD {

	private static String dubboUrl = "dubbo://10.61.98.79:20883";

	// 小天都3
	@Test
	public void test_snapshot_03() {
		DataLoader dataLoader = new KdmDubboApi(dubboUrl);
		try {
			String kks = KdmUtils.arr2str(KKS_XTD_03.KKS_IN);
			List<RTDataSet> snapshot = dataLoader.getRTDataSnapshot(kks);
			System.out.println(JSONArray.fromObject(snapshot));
			KdmJsonUtils.saveToFile(snapshot, "src/test/resources/snapshot/space.json");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取2号机指定时间数据
	 */
	@Test
	public void test_timestamp_2_1441487714000() {
		long time = 1441487714000L;
		saveToFile(KKS_XTD_02.KKS_IN, 2, time);
	}

	/**
	 * 获取3号机指定时间数据
	 */
	@Test
	public void test_timestamp_3_1441487714000() {
		long time = 1441487714000L;
		saveToFile(KKS_XTD_03.KKS_IN, 3, time);
	}

	public static void saveToFile(String[] kksArr, int machineNo, Long ltime) {
		Date time = new Date(ltime);
		DataLoader dataLoader = new KdmDubboApi(dubboUrl);
		try {
			String kks = KdmUtils.arr2str(kksArr);
			List<RTDataSet> snapshot = dataLoader.getRtData(kks, time, time);
			System.out.println(JSONArray.fromObject(snapshot));
			KdmJsonUtils.saveToFile(snapshot, "src/test/resources/xtd/space_" + machineNo + "_" + ltime + ".json");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取3号机指定时间段数据
	 */
	@Test
	public void test_period_03() {
		Long stime = 1438358400000L;// 2015-8-1
		Long etime = 1441036800000L;// 2015-9-1
		saveToFile(KKS_XTD_03.KKS_IN, 3, stime, etime);
	}

	public static void saveToFile(String[] kksArr, int machineNo, Long stime, Long etime) {
		Date sdate = new Date(stime);
		Date edate = new Date(etime);
		DataLoader dataLoader = new KdmDubboApi(dubboUrl);
		try {
			List<RTDataSet> timeSlots = dataLoader.getTimeSlots(kksArr[0], sdate, edate);
			List<RTValue> rtvLst = timeSlots.get(0).getRTDataValues();
			String kks = KdmUtils.arr2str(kksArr);
			for (RTValue rtval : rtvLst) {
				long ltime = rtval.getTime();
				List<RTDataSet> data = dataLoader.getBlockData(kks, new Date(ltime));
				if (!checkRtds(data)) {
					continue;
				}
				System.out.println("获取到数据-->" + new Date(ltime));
				KdmJsonUtils.saveToFile(data, "src/test/resources/xtd/space_" + machineNo + "_" + ltime + ".json");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean checkRtds(List<RTDataSet> rtdsList) {
		int errorNo = 0;
		for (RTDataSet rtds : rtdsList) {
			List<RTValue> rtvalues = rtds.getRTDataValues();
			if (rtvalues == null || rtvalues.isEmpty()) {
				System.out.println("没有数据 --> kks:" + rtds.getKksCode() + ",tag:" + rtds.getTag());
				errorNo++;
				continue;
			}
		}
		if (errorNo > 0) {
			return false;
		}
		return true;
	}
}
