package cn.oge.sci.space;

import java.util.ArrayList;
import java.util.List;

import org.oge.spacecacu.model.SpaceResult;
import org.oge.spacecacu.model.SpaceVector;

import cn.oge.kdm.service.dto.RTDataSet;
import cn.oge.kdm.service.dto.RTValue;

public class PersistBuilder {

	/** 段学辉纯算法约定 */
	private static float INVALID_DATA = 9999;

	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// ### KKS顺序 ###
	// --------------------------------------------
	// 01 摆度-上导/发导-X(3)
	// 平均值、峰峰值、偏心量
	// 02 摆度-上导/发导-Y(3)
	// 平均值、峰峰值、偏心角
	// 03 摆度-下导/组合轴承-X(3)
	// 平均值、峰峰值、偏心量
	// 04 摆度-下导/组合轴承-Y(3)
	// 平均值、峰峰值、偏心角
	// 05 摆度-水导-X(3)
	// 平均值、峰峰值、偏心量
	// 06 摆度-水导-Y(3)
	// 平均值、峰峰值、偏心角
	// 07 振动-上机架-X(3)
	// 平均值、峰峰值、偏心量
	// 08 振动-上机架-Y(3)
	// 平均值、峰峰值、偏心角
	// 09 振动-下机架-X(3)
	// 平均值、峰峰值、偏心量
	// 10 振动-下机架-Y(3)
	// 平均值、峰峰值、偏心角
	// 11 振动-顶盖-X(3)
	// 平均值、峰峰值、偏心量
	// 12 振动-顶盖-Y(3)
	// 平均值、峰峰值、偏心角
	//
	// 13 弯曲量-偏心量与偏心角(3*2=6)
	// 上导、下导、水导
	// 14 盘车量-偏心量与偏心角(4*2=8)
	// 上导盘车、下导盘车、上水导盘车、下水导盘车
	// 15 转子镜板-偏心量与偏心角(3*2=6)
	// 转子回转、转子离心力、镜板
	// ===============================================
	public static List<RTDataSet> buildRTDataSet(SpaceResult result, List<String> kksList, Long time) {

		// SpacecauUtils.show(result);

		List<RTDataSet> rtdsList = new ArrayList<RTDataSet>();

		int index = 0;

		Long ltime = time;

		/*************************************************************
		 * 01 上导/发导-X-4---平均值，峰峰值，振动
		 * ***********************************************************/
		// 平均值
		float avr_top_x_one = result.getAvrValue_top_x_one();
		if (avr_top_x_one != INVALID_DATA) {
			rtdsList.add(buildRTDataSet(kksList.get(index), ltime, avr_top_x_one));
		}
		index++;

		// 峰峰值
		float ffz_top_x = result.getFfz_top_x();
		if (ffz_top_x != INVALID_DATA) {
			rtdsList.add(buildRTDataSet(kksList.get(index), ltime, ffz_top_x));
		}
		index++;

		// #上导摆度1X量-偏心量-计算量
		SpaceVector topRail = result.getTopRail();
		if (topRail != null) {
			rtdsList.add(buildRTDataSet(kksList.get(index), ltime, topRail.getLength()));
		}
		index++;

		/*************************************************************
		 * 02 上导/发导-Y-4---平均值，峰峰值，振动
		 * ***********************************************************/
		// 平均值
		float avr_top_y_one = result.getAvrValue_top_y_one();
		if (avr_top_y_one != INVALID_DATA) {
			rtdsList.add(buildRTDataSet(kksList.get(index), ltime, avr_top_y_one));
		}
		index++;

		// #上导摆度Y峰峰值-计算量
		float ffz_top_y = result.getFfz_top_y();
		if (ffz_top_y != INVALID_DATA) {
			rtdsList.add(buildRTDataSet(kksList.get(index), ltime, ffz_top_y));
		}
		index++;

		if (topRail != null) {
			// #上导摆度1X量-偏心角-计算量
			rtdsList.add(buildRTDataSet(kksList.get(index), ltime, topRail.getAngle()));
		}
		index++;

		/*************************************************************
		 * 03 下导/组合轴承-X-4---平均值，峰峰值，振动
		 * ***********************************************************/
		// #下导摆度X平均值-计算量
		float avr_bottom_x_one = result.getAvrValue_bottom_x_one();
		if (avr_bottom_x_one != INVALID_DATA) {
			rtdsList.add(buildRTDataSet(kksList.get(index), ltime, avr_bottom_x_one));
		}
		index++;

		// #下导摆度X峰峰值-计算量
		float ffz_bottom_x = result.getFfz_bottom_x();
		if (ffz_bottom_x != INVALID_DATA) {
			rtdsList.add(buildRTDataSet(kksList.get(index), ltime, ffz_bottom_x));
		}
		index++;

		// #下导摆度1X量-偏心量-计算量
		SpaceVector bottomRail = result.getBottomRail();
		if (bottomRail != null) {
			rtdsList.add(buildRTDataSet(kksList.get(index), ltime, bottomRail.getLength()));
		}
		index++;

		/*************************************************************
		 * 04下导/组合轴承-Y-4---平均值，峰峰值，振动
		 * ***********************************************************/
		// #下导摆度Y平均值-计算量
		float avr_bottom_y_one = result.getAvrValue_bottom_y_one();
		if (avr_bottom_y_one != INVALID_DATA) {
			rtdsList.add(buildRTDataSet(kksList.get(index), ltime, avr_bottom_y_one));
		}
		index++;

		// #下导摆度Y峰峰值-计算量
		float ffz_bottom_y = result.getFfz_bottom_y();
		if (ffz_bottom_y != INVALID_DATA) {
			rtdsList.add(buildRTDataSet(kksList.get(index), ltime, ffz_bottom_y));
		}
		index++;

		// #下导摆度1X量-偏心角-计算量
		if (bottomRail != null) {
			rtdsList.add(buildRTDataSet(kksList.get(index), ltime, bottomRail.getAngle()));
		}
		index++;

		/*************************************************************
		 * 05水导-X-4---平均值，峰峰值，振动
		 * ***********************************************************/
		// #水导摆度X平均值-计算量
		float avr_horizon_x_one = result.getAvrValue_horizon_x_one();
		if (avr_horizon_x_one != INVALID_DATA) {
			rtdsList.add(buildRTDataSet(kksList.get(index), ltime, avr_horizon_x_one));
		}
		index++;

		// #水导摆度X峰峰值-计算量
		float ffz_horizon_x = result.getFfz_horizon_x();
		if (ffz_horizon_x != INVALID_DATA) {
			rtdsList.add(buildRTDataSet(kksList.get(index), ltime, ffz_horizon_x));
		}
		index++;

		SpaceVector horizonRail = result.getHorizonRail();
		// #水导摆度1X量-偏心量-计算量
		if (horizonRail != null) {
			rtdsList.add(buildRTDataSet(kksList.get(index), ltime, horizonRail.getLength()));
		}
		index++;

		/*************************************************************
		 * 06水导-Y-4---平均值，峰峰值，振动
		 * ***********************************************************/
		// #水导摆度Y平均值-计算量
		float avr_horizon_y_one = result.getAvrValue_horizon_y_one();
		if (avr_horizon_y_one != INVALID_DATA) {
			rtdsList.add(buildRTDataSet(kksList.get(index), ltime, avr_horizon_y_one));
		}
		index++;

		// #水导摆度Y峰峰值-计算量
		float ffz_horizon_y = result.getFfz_horizon_y();
		if (ffz_horizon_y != INVALID_DATA) {
			rtdsList.add(buildRTDataSet(kksList.get(index), ltime, ffz_horizon_y));
		}
		index++;

		// #水导摆度1X量-偏心角-计算量
		if (horizonRail != null) {
			rtdsList.add(buildRTDataSet(kksList.get(index), ltime, horizonRail.getAngle()));
		}
		index++;

		/*************************************************************
		 * 07 振动-上机架-X(3)---平均值，峰峰值，振动
		 * ***********************************************************/
		// 平均值
		float avr_topFrame_x_one = result.getAvrValue_topFrame_x_one();
		if (avr_topFrame_x_one != INVALID_DATA) {
			rtdsList.add(buildRTDataSet(kksList.get(index), ltime, avr_topFrame_x_one));
		}
		index++;

		// 峰峰值
		float ffz_topFrame_x = result.getFfz_topFrame_x();
		if (ffz_topFrame_x != INVALID_DATA) {
			rtdsList.add(buildRTDataSet(kksList.get(index), ltime, ffz_topFrame_x));
		}
		index++;

		// #振动-上机架1X量-偏心量-计算量
		SpaceVector topFrameRail = result.getTopFrame();
		if (topFrameRail != null) {
			rtdsList.add(buildRTDataSet(kksList.get(index), ltime, topFrameRail.getLength()));
		}
		index++;

		/*************************************************************
		 * 08 振动-上机架-Y(3)---平均值，峰峰值，振动
		 * ***********************************************************/
		// #振动-上机架-Y-平均值
		float avr_topFrame_y_one = result.getAvrValue_topFrame_y_one();
		if (avr_topFrame_y_one != INVALID_DATA) {
			rtdsList.add(buildRTDataSet(kksList.get(index), ltime, avr_topFrame_y_one));
		}
		index++;

		// #振动-上机架Y峰峰值-计算量
		float ffz_topFrame_y = result.getFfz_topFrame_y();
		if (ffz_topFrame_y != INVALID_DATA) {
			rtdsList.add(buildRTDataSet(kksList.get(index), ltime, ffz_topFrame_y));
		}
		index++;

		// #振动-上机架1X量-偏心角-计算量
		if (topFrameRail != null) {
			rtdsList.add(buildRTDataSet(kksList.get(index), ltime, topFrameRail.getAngle()));
		}
		index++;

		/*************************************************************
		 * 09 振动-下机架-X(3)---平均值，峰峰值，振动
		 * ***********************************************************/
		// #振动-下机架X平均值-计算量
		float avr_bottomFrame_x_one = result.getAvrValue_bottomFrame_x_one();
		if (avr_bottomFrame_x_one != INVALID_DATA) {
			rtdsList.add(buildRTDataSet(kksList.get(index), ltime, avr_bottomFrame_x_one));
		}
		index++;

		// #振动-下机架X峰峰值-计算量
		float ffz_bottomFrame_x = result.getFfz_bottomFrame_x();
		if (ffz_bottomFrame_x != INVALID_DATA) {
			rtdsList.add(buildRTDataSet(kksList.get(index), ltime, ffz_bottomFrame_x));
		}
		index++;

		// #振动-下机架1X量-偏心量-计算量
		SpaceVector bottomFrameRail = result.getBottomFrame();
		if (bottomFrameRail != null) {
			rtdsList.add(buildRTDataSet(kksList.get(index), ltime, bottomFrameRail.getLength()));
		}
		index++;

		/*************************************************************
		 * 10 振动-下机架-Y(3)---平均值，峰峰值，振动
		 * ***********************************************************/
		// #振动-下机架Y平均值-计算量
		float avr_bottomFrame_y_one = result.getAvrValue_bottomFrame_y_one();
		if (avr_bottomFrame_y_one != INVALID_DATA) {
			rtdsList.add(buildRTDataSet(kksList.get(index), ltime, avr_bottomFrame_y_one));
		}
		index++;

		// #振动-下机架Y峰峰值-计算量
		float ffz_bottomFrame_y = result.getFfz_bottom_y();
		if (ffz_bottomFrame_y != INVALID_DATA) {
			rtdsList.add(buildRTDataSet(kksList.get(index), ltime, ffz_bottomFrame_y));
		}
		index++;

		// #振动-下机架1X量-偏心角-计算量
		if (bottomFrameRail != null) {
			rtdsList.add(buildRTDataSet(kksList.get(index), ltime, bottomFrameRail.getAngle()));
		}
		index++;

		/*************************************************************
		 * 11 振动-顶盖-X(3)---平均值，峰峰值，振动
		 * ***********************************************************/
		// #振动-顶盖X平均值-计算量
		float avr_boxFrame_x_one = result.getAvrValue_boxFrame_x_one();
		if (avr_boxFrame_x_one != INVALID_DATA) {
			rtdsList.add(buildRTDataSet(kksList.get(index), ltime, avr_boxFrame_x_one));
		}
		index++;

		// #振动-顶盖X峰峰值-计算量
		float ffz_boxFrame_x = result.getFfz_boxFrame_x();
		if (ffz_boxFrame_x != INVALID_DATA) {
			rtdsList.add(buildRTDataSet(kksList.get(index), ltime, ffz_boxFrame_x));
		}
		index++;

		SpaceVector boxFrameRail = result.getTopHeadFrame();
		// #振动-顶盖1X量-偏心量-计算量
		if (boxFrameRail != null) {
			rtdsList.add(buildRTDataSet(kksList.get(index), ltime, boxFrameRail.getLength()));
		}
		index++;

		/*************************************************************
		 * 12 振动-顶盖-Y(3)---平均值，峰峰值，振动
		 * ***********************************************************/
		// #振动-顶盖Y平均值-计算量
		float avr_boxFrame_y_one = result.getAvrValue_boxFrame_y_one();
		if (avr_boxFrame_y_one != INVALID_DATA) {
			rtdsList.add(buildRTDataSet(kksList.get(index), ltime, avr_boxFrame_y_one));
		}
		index++;

		// #振动-顶盖Y峰峰值-计算量
		float ffz_boxFrame_y = result.getFfz_boxFrame_y();
		if (ffz_boxFrame_y != INVALID_DATA) {
			rtdsList.add(buildRTDataSet(kksList.get(index), ltime, ffz_boxFrame_y));
		}
		index++;

		// #振动-顶盖1X量-偏心角-计算量
		if (boxFrameRail != null) {
			rtdsList.add(buildRTDataSet(kksList.get(index), ltime, boxFrameRail.getAngle()));
		}
		index++;

		/*************************************************************
		 * 13 弯曲量-偏心量与偏心角
		 * ***********************************************************/
		/** 上导弯曲量 */
		SpaceVector topBend = result.getTopBend();
		if (topBend != null) {
			// #上导弯曲量-偏心量-计算量
			rtdsList.add(buildRTDataSet(kksList.get(index++), ltime, topBend.getLength()));
			// #上导弯曲量-偏心角-计算量
			rtdsList.add(buildRTDataSet(kksList.get(index++), ltime, topBend.getAngle()));
		} else {
			index = index + 2;
		}

		/** 下导弯曲量 */
		SpaceVector bottomBend = result.getBottomBend();
		if (bottomBend != null) {
			// #下导弯曲量-偏心量-计算量
			rtdsList.add(buildRTDataSet(kksList.get(index++), ltime, bottomBend.getLength()));
			// #下导弯曲量-偏心角-计算量
			rtdsList.add(buildRTDataSet(kksList.get(index++), ltime, bottomBend.getAngle()));
		} else {
			index = index + 2;
		}

		/** 水导弯曲量 */
		SpaceVector horizonBend = result.getHorizonBend();
		if (horizonBend != null) {
			// #水导弯曲量-偏心量-计算量
			rtdsList.add(buildRTDataSet(kksList.get(index++), ltime, horizonBend.getLength()));
			// #水导弯曲量-偏心角-计算量
			rtdsList.add(buildRTDataSet(kksList.get(index++), ltime, horizonBend.getAngle()));
		} else {
			index = index + 2;
		}

		/*************************************************************
		 * 14 盘车量-偏心量与偏心角
		 * ***********************************************************/
		SpaceVector topPanCar = result.getTopPanCar();
		if (topPanCar != null) {
			// #上导盘车量-偏心量-计算量
			rtdsList.add(buildRTDataSet(kksList.get(index++), ltime, topPanCar.getLength()));
			// #上导盘车量-偏心角-计算量
			rtdsList.add(buildRTDataSet(kksList.get(index++), ltime, topPanCar.getAngle()));
		} else {
			index = index + 2;
		}

		SpaceVector bottomPanCar = result.getBottomPanCar();
		if (bottomPanCar != null) {
			// #下导盘车量-偏心量-计算量
			rtdsList.add(buildRTDataSet(kksList.get(index++), ltime, bottomPanCar.getLength()));
			// #下导盘车量-偏心角-计算量
			rtdsList.add(buildRTDataSet(kksList.get(index++), ltime, bottomPanCar.getAngle()));
		} else {
			index = index + 2;
		}

		SpaceVector topHorPanCar = result.getTopHorrizonPanCar();
		if (topHorPanCar != null) {
			// #上水导盘车量-偏心量-计算量
			rtdsList.add(buildRTDataSet(kksList.get(index++), ltime, topHorPanCar.getLength()));
			// #上水导盘车量-偏心角-计算量
			rtdsList.add(buildRTDataSet(kksList.get(index++), ltime, topHorPanCar.getAngle()));
		} else {
			index = index + 2;
		}

		SpaceVector bottomHorPanCar = result.getBottomHorrizonPanCar();
		if (bottomHorPanCar != null) {
			// #下水导盘车量-偏心量-计算量
			rtdsList.add(buildRTDataSet(kksList.get(index++), ltime, bottomHorPanCar.getLength()));
			// #下水导盘车量-偏心角-计算量
			rtdsList.add(buildRTDataSet(kksList.get(index++), ltime, bottomHorPanCar.getAngle()));
		} else {
			index = index + 2;
		}

		/*************************************************************
		 * 15 转子镜板-偏心量与偏心角
		 * ***********************************************************/
		// 转子回转
		SpaceVector rotatorOffCenter = result.getRotatorOffCentre();
		if (rotatorOffCenter != null) {
			// #转子回转偏心量-计算量
			rtdsList.add(buildRTDataSet(kksList.get(index++), ltime, rotatorOffCenter.getLength()));
			// #转子回转偏心角-计算量
			rtdsList.add(buildRTDataSet(kksList.get(index++), ltime, rotatorOffCenter.getAngle()));
		} else {
			index = index + 2;
		}

		// 转子离心力
		SpaceVector roca = result.getRotatorOffCenterAffect();
		if (roca != null) {
			// #转子离心力振动影响-偏心量-计算量
			rtdsList.add(buildRTDataSet(kksList.get(index++), ltime, roca.getLength()));
			// #转子离心力振动影响-偏心角-计算量
			rtdsList.add(buildRTDataSet(kksList.get(index++), ltime, roca.getAngle()));
		} else {
			index = index + 2;
		}

		/** 镜板 */
		SpaceVector mirrorNotV = result.getMirrorNotVertical();
		if (mirrorNotV != null) {
			// #镜板不垂直量-偏心量-计算量
			rtdsList.add(buildRTDataSet(kksList.get(index++), ltime, mirrorNotV.getLength()));
			// #镜板不垂直量-偏心角-计算量
			rtdsList.add(buildRTDataSet(kksList.get(index++), ltime, mirrorNotV.getAngle()));
		}

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
