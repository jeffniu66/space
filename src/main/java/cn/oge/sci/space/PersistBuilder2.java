package cn.oge.sci.space;

import java.util.ArrayList;
import java.util.List;

import org.oge.spacecacu.model.SpaceResult;
import org.oge.spacecacu.model.SpaceVector;

import cn.oge.kdm.service.dto.RTDataSet;
import cn.oge.kdm.service.dto.RTValue;

public class PersistBuilder2 {

	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// ### KKS顺序 ###
	// --------------------------------------------
	// 1.评价值（12个量）
	// 上导摆度Y平均值-计算量
	// 上导摆度X平均值-计算量
	// 下导摆度Y平均值-计算量
	// 下导摆度X平均值-计算量
	// 水导摆度Y平均值-计算量
	// 水导摆度X平均值-计算量
	// 上机架Y平均值-计算量
	// 上机架X平均值-计算量
	// 下机架Y平均值-计算量
	// 下机架X平均值-计算量
	// 顶盖Y平均值-计算量
	// 顶盖X平均值-计算量
	//
	// 2.峰峰值（12个量）
	// 上导摆度X峰峰值-计算量
	// 上导摆度Y峰峰值-计算量
	// 下导摆度X峰峰值-计算量
	// 下导摆度Y峰峰值-计算量
	// 上机架X峰峰值-计算量
	// 上机架Y峰峰值-计算量
	// 下机架X峰峰值-计算量
	// 下机架Y峰峰值-计算量
	// 水导摆度X峰峰值-计算量
	// 水导摆度Y峰峰值-计算量
	// 顶盖X峰峰值-计算量
	// 顶盖Y峰峰值-计算量
	//
	// 3.摆度1X量-偏心角与偏心量（6）
	// 上导摆度1X量-偏心角-计算量
	// 上导摆度1X量-偏心量-计算量
	// 下导摆度1X量-偏心角-计算量
	// 下导摆度1X量-偏心量-计算量
	// 水导摆度1X量-偏心角-计算量
	// 水导摆度1X量-偏心量-计算量
	//
	// 4.振动1X量-偏心角与偏心量（6）
	// 上机架振动1X量-偏心角-计算量
	// 上机架振动1X量-偏心量-计算量
	// 下机架振动1X量-偏心角-计算量
	// 下机架振动1X量-偏心量-计算量
	// 顶盖振动1X量-偏心角-计算量
	// 顶盖振动1X量-偏心量-计算量
	//
	// 5.弯曲量-偏心角与偏心量（6）
	// 上导弯曲量-偏心角-计算量
	// 上导弯曲量-偏心量-计算量
	// 下导弯曲量-偏心角-计算量
	// 下导弯曲量-偏心量-计算量
	// 水导弯曲量-偏心角-计算量
	// 水导弯曲量-偏心量-计算量
	//
	// 6.盘车量-偏心角与偏心量（8）
	// 上导盘车量-偏心量-计算量
	// 上导盘车量-偏心角-计算量
	// 下导盘车量-偏心量-计算量
	// 下导盘车量-偏心角-计算量
	// 上水导盘车量-偏心量-计算量
	// 上水导盘车量-偏心角-计算量
	// 下水导盘车量-偏心量-计算量
	// 下水导盘车量-偏心角-计算量
	//
	// 7.转子镜板-偏心角与偏心量（6）
	// 转子回转偏心角-计算量
	// 转子回转偏心量-计算量
	// 转子离心力振动影响-偏心角-计算量
	// 转子离心力振动影响-偏心量-计算量
	// 镜板不垂直量-偏心角-计算量
	// 镜板不垂直量-偏心量-计算量
	// ===============================================
	public static List<RTDataSet> buildRTDataSet(SpaceResult result,
			List<String> kksList, Long time) {

		// SpacecauUtils.show(result);

		List<RTDataSet> rtdsList = new ArrayList<RTDataSet>();

		int index = 0;

		Long ltime = time;

		/*************************************************************
		 * 01/02. 平均值
		 * ***********************************************************/

		// "TOPXAV" #上导摆度X平均值-计算量
		// rtdsList.add(buildRTDataSet(
		// METE_TOP_X_AVG, ltime, result.getAvrValue_top_x()));
		/** 一个结果值 */
		rtdsList.add(buildRTDataSet(kksList.get(index++), ltime,
				result.getAvrValue_top_x_one()));

		// "TOPYAV" #上导摆度Y平均值-计算量
		// rtdsList.add(buildRTDataSet(
		// METE_TOP_Y_AVG, ltime, result.getAvrValue_top_y()));
		/** 一个结果值 */
		rtdsList.add(buildRTDataSet(kksList.get(index++), ltime,
				result.getAvrValue_top_y_one()));

		// BOTTOMXAV #下导摆度X平均值-计算量
		// rtdsList.add(buildRTDataSet(
		// METE_BOTTOM_X_AVG, ltime,
		// result.getAvrValue_bottom_x()));
		/** 一个结果值 */
		rtdsList.add(buildRTDataSet(kksList.get(index++), ltime,
				result.getAvrValue_bottom_x_one()));

		// BOTTOMYAV #下导摆度Y平均值-计算量
		// rtdsList.add(buildRTDataSet(
		// METE_BOTTOM_Y_AVG, ltime,
		// result.getAvrValue_bottom_y()));
		/** 一个结果值 */
		rtdsList.add(buildRTDataSet(kksList.get(index++), ltime,
				result.getAvrValue_bottom_y_one()));

		// HORIZONXAV #水导摆度X平均值-计算量
		// rtdsList.add(buildRTDataSet(
		// METE_HORIZON_X_AVG, ltime,
		// result.getAvrValue_horizon_x()));
		/** 一个结果值 */
		rtdsList.add(buildRTDataSet(kksList.get(index++), ltime,
				result.getAvrValue_horizon_x_one()));

		// HORIZONYAV #水导摆度Y平均值-计算量
		// rtdsList.add(buildRTDataSet(
		// METE_HORIZON_Y_AVG, ltime,
		// result.getAvrValue_horizon_y()));
		/** 一个结果值 */
		rtdsList.add(buildRTDataSet(kksList.get(index++), ltime,
				result.getAvrValue_horizon_y_one()));

		// TOPFRAMEXAV #上机架X平均值-计算量
		// rtdsList.add(buildRTDataSet(
		// METE_TOP_FRAME_X_AVG, ltime,
		// result.getAvrValue_topFrame_x()));
		/** 一个结果值 */
		rtdsList.add(buildRTDataSet(kksList.get(index++), ltime,
				result.getAvrValue_topFrame_x_one()));

		// TOPFRAMEYAV #上机架Y平均值-计算量
		// rtdsList.add(buildRTDataSet(
		// METE_TOP_FRAME_Y_AVG, ltime,
		// result.getAvrValue_topFrame_y()));
		/** 一个结果值 */
		rtdsList.add(buildRTDataSet(kksList.get(index++), ltime,
				result.getAvrValue_topFrame_y_one()));

		// BOTTOMFRAMEXAV #下机架X平均值-计算量
		// rtdsList.add(buildRTDataSet(
		// METE_BOTTOM_FRAME_X_AVG, ltime,
		// result.getAvrValue_bottomFrame_x()));
		/** 一个结果值 */
		rtdsList.add(buildRTDataSet(kksList.get(index++), ltime,
				result.getAvrValue_bottomFrame_x_one()));

		// BOTTOMFRAMEYAV #下机架Y平均值-计算量
		// rtdsList.add(buildRTDataSet(
		// METE_BOTTOM_FRAME_Y_AVG, ltime,
		// result.getAvrValue_bottomFrame_y()));
		/** 一个结果值 */
		rtdsList.add(buildRTDataSet(kksList.get(index++), ltime,
				result.getAvrValue_bottomFrame_y_one()));

		// BOXFRAMEXAV #顶盖X平均值-计算量
		// rtdsList.add(buildRTDataSet(
		// METE_BOX_FRAME_X_AVG, ltime,
		// result.getAvrValue_boxFrame_x()));
		/** 一个结果值 */
		rtdsList.add(buildRTDataSet(kksList.get(index++), ltime,
				result.getAvrValue_boxFrame_x_one()));

		// BOXFRAMEYAV #顶盖Y平均值-计算量
		// rtdsList.add(buildRTDataSet(
		// METE_BOX_FRAME_Y_AVG, ltime,
		// result.getAvrValue_boxFrame_y()));
		/** 一个结果值 */
		rtdsList.add(buildRTDataSet(kksList.get(index++), ltime,
				result.getAvrValue_boxFrame_y_one()));

		/*************************************************************
		 * 03. 峰值
		 * ***********************************************************/
		// FFZTOPX #上导摆度X峰峰值-计算量
		rtdsList.add(buildRTDataSet(kksList.get(index++), ltime,
				result.getFfz_top_x()));
		// FFZTOPY #上导摆度Y峰峰值-计算量
		rtdsList.add(buildRTDataSet(kksList.get(index++), ltime,
				result.getFfz_top_y()));

		// FFZBOTTOMX #下导摆度Y峰峰值-计算量
		rtdsList.add(buildRTDataSet(kksList.get(index++), ltime,
				result.getFfz_bottom_x()));
		// FFZBOTTOMY #上导摆度Y峰峰值-计算量
		rtdsList.add(buildRTDataSet(kksList.get(index++), ltime,
				result.getFfz_bottom_y()));

		// FFZHORIZONX #水导摆度X峰峰值-计算量
		rtdsList.add(buildRTDataSet(kksList.get(index++), ltime,
				result.getFfz_horizon_x()));
		// FFZHORIZONY #水导摆度Y峰峰值-计算量
		rtdsList.add(buildRTDataSet(kksList.get(index++), ltime,
				result.getFfz_horizon_y()));

		// FFZTOPFRAMEX #上机架X峰峰值-计算量
		rtdsList.add(buildRTDataSet(kksList.get(index++), ltime,
				result.getFfz_topFrame_x()));
		// FFZTOPFRAMEY #上机架Y峰峰值-计算量
		rtdsList.add(buildRTDataSet(kksList.get(index++), ltime,
				result.getFfz_topFrame_y()));

		// FFZBOTTOMFRAMEX #下机架X峰峰值-计算量
		rtdsList.add(buildRTDataSet(kksList.get(index++), ltime,
				result.getFfz_bottomFrame_x()));
		// FFZBOTTOMFRAMEY #下机架Y峰峰值-计算量
		rtdsList.add(buildRTDataSet(kksList.get(index++), ltime,
				result.getFfz_bottomFrame_y()));

		// FFZBOXFRAMEX #顶盖X峰峰值-计算量
		rtdsList.add(buildRTDataSet(kksList.get(index++), ltime,
				result.getFfz_boxFrame_x()));
		// FFZBOXFRAMEY #顶盖Y峰峰值-计算量
		rtdsList.add(buildRTDataSet(kksList.get(index++), ltime,
				result.getFfz_boxFrame_y()));

		/*************************************************************
		 * 04. 偏心
		 * ***********************************************************/
		// 上导
		SpaceVector topRail = result.getTopRail();
		// #上导摆度1X量-偏心量-计算量
		rtdsList.add(buildRTDataSet(kksList.get(index++), ltime,
				topRail.getLength()));
		// #导摆度1X量-偏心角-计算量
		rtdsList.add(buildRTDataSet(kksList.get(index++), ltime,
				topRail.getAngle()));

		// 下导
		SpaceVector bottomRail = result.getBottomRail();
		// #下导摆度1X量-偏心量-计算量
		rtdsList.add(buildRTDataSet(kksList.get(index++), ltime,
				bottomRail.getLength()));
		// #下导摆度1X量-偏心角-计算量
		rtdsList.add(buildRTDataSet(kksList.get(index++), ltime,
				bottomRail.getAngle()));

		// 水导
		SpaceVector horizonRail = result.getHorizonRail();
		// #水导摆度1X量-偏心量-计算量
		rtdsList.add(buildRTDataSet(kksList.get(index++), ltime,
				horizonRail.getLength()));
		// #水导摆度1X量-偏心角-计算量
		rtdsList.add(buildRTDataSet(kksList.get(index++), ltime,
				horizonRail.getAngle()));

		// 上机架
		SpaceVector topFrame = result.getTopFrame();
		// #上机架振动1X量-偏心量-计算量
		rtdsList.add(buildRTDataSet(kksList.get(index++), ltime,
				topFrame.getLength()));
		// #上机架振动1X量-偏心角-计算量
		rtdsList.add(buildRTDataSet(kksList.get(index++), ltime,
				topFrame.getAngle()));

		// 下机架
		SpaceVector bottomFrame = result.getBottomFrame();
		// #下机架振动1X量-偏心量-计算量
		rtdsList.add(buildRTDataSet(kksList.get(index++), ltime,
				bottomFrame.getLength()));
		// #下机架振动1X量-偏心角-计算量
		rtdsList.add(buildRTDataSet(kksList.get(index++), ltime,
				bottomFrame.getAngle()));

		// 顶盖
		SpaceVector topHeadFrame = result.getTopHeadFrame();
		// #顶盖振动1X量-偏心量-计算量
		rtdsList.add(buildRTDataSet(kksList.get(index++), ltime,
				topHeadFrame.getLength()));
		// #顶盖振动1X量-偏心角-计算量
		rtdsList.add(buildRTDataSet(kksList.get(index++), ltime,
				topHeadFrame.getAngle()));

		/** 上导弯曲量 */
		SpaceVector topBend = result.getTopBend();
		// #上导弯曲量-偏心量-计算量
		rtdsList.add(buildRTDataSet(kksList.get(index++), ltime,
				topBend.getLength()));
		// #上导弯曲量-偏心角-计算量
		rtdsList.add(buildRTDataSet(kksList.get(index++), ltime,
				topBend.getAngle()));
		/** 下导弯曲量 */
		SpaceVector bottomBend = result.getBottomBend();
		// #下导弯曲量-偏心量-计算量
		rtdsList.add(buildRTDataSet(kksList.get(index++), ltime,
				bottomBend.getLength()));
		// #下导弯曲量-偏心角-计算量
		rtdsList.add(buildRTDataSet(kksList.get(index++), ltime,
				bottomBend.getAngle()));
		/** 水导弯曲量 */
		SpaceVector horizonBend = result.getHorizonBend();
		// #水导弯曲量-偏心量-计算量
		rtdsList.add(buildRTDataSet(kksList.get(index++), ltime,
				horizonBend.getLength()));
		// #水导弯曲量-偏心角-计算量
		rtdsList.add(buildRTDataSet(kksList.get(index++), ltime,
				horizonBend.getAngle()));

		/** 盘车量 */
		SpaceVector topPanCar = result.getTopPanCar();
		// #上导盘车量-偏心量-计算量
		rtdsList.add(buildRTDataSet(kksList.get(index++), ltime,
				topPanCar.getLength()));
		// #上导盘车量-偏心角-计算量
		rtdsList.add(buildRTDataSet(kksList.get(index++), ltime,
				topPanCar.getAngle()));

		SpaceVector bottomPanCar = result.getBottomPanCar();
		// #下导盘车量-偏心量-计算量
		rtdsList.add(buildRTDataSet(kksList.get(index++), ltime,
				bottomPanCar.getLength()));
		// #下导盘车量-偏心角-计算量
		rtdsList.add(buildRTDataSet(kksList.get(index++), ltime,
				bottomPanCar.getAngle()));

		SpaceVector topHorPanCar = result.getTopHorrizonPanCar();
		// #上水导盘车量-偏心量-计算量
		rtdsList.add(buildRTDataSet(kksList.get(index++), ltime,
				topHorPanCar.getLength()));
		// #上水导盘车量-偏心角-计算量
		rtdsList.add(buildRTDataSet(kksList.get(index++), ltime,
				topHorPanCar.getAngle()));

		SpaceVector bottomHorPanCar = result.getBottomHorrizonPanCar();
		// #下水导盘车量-偏心量-计算量
		rtdsList.add(buildRTDataSet(kksList.get(index++), ltime,
				bottomHorPanCar.getLength()));
		// #下水导盘车量-偏心角-计算量
		rtdsList.add(buildRTDataSet(kksList.get(index++), ltime,
				bottomHorPanCar.getAngle()));

		// 转子回转
		SpaceVector rotatorOffCenter = result.getRotatorOffCentre();
		// #转子回转偏心量-计算量
		rtdsList.add(buildRTDataSet(kksList.get(index++), ltime,
				rotatorOffCenter.getLength()));
		// #转子回转偏心角-计算量
		rtdsList.add(buildRTDataSet(kksList.get(index++), ltime,
				rotatorOffCenter.getAngle()));
		// 转子离心力
		SpaceVector roca = result.getRotatorOffCenterAffect();
		// #转子离心力振动影响-偏心量-计算量
		rtdsList.add(buildRTDataSet(kksList.get(index++), ltime,
				roca.getLength()));
		// #转子离心力振动影响-偏心角-计算量
		rtdsList.add(buildRTDataSet(kksList.get(index++), ltime,
				roca.getAngle()));
		/** 镜板 */
		SpaceVector mirrorNotV = result.getMirrorNotVertical();
		// #镜板不垂直量-偏心量-计算量
		rtdsList.add(buildRTDataSet(kksList.get(index++), ltime,
				mirrorNotV.getLength()));
		// #镜板不垂直量-偏心角-计算量
		rtdsList.add(buildRTDataSet(kksList.get(index++), ltime,
				mirrorNotV.getAngle()));
		return rtdsList;
	}

	public static RTDataSet buildRTDataSet(String code, Long time, float value) {
		String kksCode = code;
		List<RTValue> rtvList = new ArrayList<RTValue>();
		// String tagId = kksCode;
		rtvList.add(new RTValue(time, value));
		return new RTDataSet(kksCode, rtvList);
	}

	public static RTValue buildRTValue(String code, Long time, Object value) {
		return new RTValue(time, value);
	}
}
