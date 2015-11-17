package cn.oge.sci.space;

import org.oge.spacecacu.model.SpaceResult;
import org.oge.spacecacu.model.SpaceVector;

public class SpaceHelper {

	public static void printResult(SpaceResult result) {
		// print result
		printFLoat(result.getAvrValue_top_x(), "TOPXAV");
		printFLoat(result.getAvrValue_top_y(), "TOPYAV");
		printFLoat(result.getAvrValue_bottom_x(), "BOTTOMXAV");
		printFLoat(result.getAvrValue_bottom_y(), "BOTTOMYAV");
		printFLoat(result.getAvrValue_horizon_x(), "HORIZONXAV");
		printFLoat(result.getAvrValue_horizon_y(), "HORIZONYAV");
		printFLoat(result.getAvrValue_topFrame_x(), "TOPFRAMEXAV");
		printFLoat(result.getAvrValue_topFrame_y(), "TOPFRAMEYAV");
		printFLoat(result.getAvrValue_bottomFrame_x(), "BOTTOMFRAMEXAV");
		printFLoat(result.getAvrValue_bottomFrame_y(), "BOTTOMFRAMEYAV");
		printFLoat(result.getAvrValue_boxFrame_x(), "BOXFRAMEXAV");
		printFLoat(result.getAvrValue_boxFrame_y(), "BOXFRAMEYAV");

		// 平均值
		printFLoat(result.getAvrValue_top_x_one(), "TOPXAV_one");
		printFLoat(result.getAvrValue_top_y_one(), "TOPYAV_one");
		printFLoat(result.getAvrValue_bottom_x_one(), "BOTTOMXAV_one");
		printFLoat(result.getAvrValue_bottom_y_one(), "BOTTOMYAV_one");
		printFLoat(result.getAvrValue_horizon_x_one(), "HORIZONXAV_one");
		printFLoat(result.getAvrValue_horizon_y_one(), "HORIZONYAV_one");
		printFLoat(result.getAvrValue_topFrame_x_one(), "TOPFRAMEXAV_one");
		printFLoat(result.getAvrValue_topFrame_y_one(), "TOPFRAMEYAV_one");
		printFLoat(result.getAvrValue_bottomFrame_x_one(), "BOTTOMFRAMEXAV_one");
		printFLoat(result.getAvrValue_bottomFrame_y_one(), "BOTTOMFRAMEYAV_one");
		printFLoat(result.getAvrValue_boxFrame_x_one(), "BOXFRAMEXAV_one");
		printFLoat(result.getAvrValue_boxFrame_y_one(), "BOXFRAMEYAV_one");

		// 峰峰值
		printFLoat(result.getFfz_top_x(), "FFZTOPX");
		printFLoat(result.getFfz_top_y(), "FFZTOPY");
		printFLoat(result.getFfz_bottom_x(), "FFZBOTTOMX");
		printFLoat(result.getFfz_bottom_y(), "FFZBOTTOMY");
		printFLoat(result.getFfz_horizon_x(), "FFZHORIZONX");
		printFLoat(result.getFfz_horizon_y(), "FFZHORIZONY");
		printFLoat(result.getFfz_topFrame_x(), "FFZTOPFRAMEX");
		printFLoat(result.getFfz_topFrame_y(), "FFZTOPFRAMEY");
		printFLoat(result.getFfz_bottomFrame_x(), "FFZBOTTOMFRAMEX");
		printFLoat(result.getFfz_bottomFrame_y(), "FFZBOTTOMFRAMEY");
		printFLoat(result.getFfz_boxFrame_x(), "FFZBOXFRAMEX");
		printFLoat(result.getFfz_boxFrame_y(), "FFZBOXFRAMEY");

		printFLoat(result.getTopRail(), "3：上导摆度1X量（上导X，上导Y） ");
		printFLoat(result.getBottomRail(), "4：下导摆度1X量 ok");

		printFLoat(result.getHorizonRail(), "5：水导摆度1X量 ok");

		printFLoat(result.getTopFrame(), "6：上机架振动1X量");
		printFLoat(result.getBottomFrame(), "7：下机架振动1X量");
		printFLoat(result.getTopHeadFrame(), "8：顶盖振动1X量");

		printFLoat(result.getRotatorOffCentre(), "9：转子回转偏心量（上导XY，下导XY）");
		printFLoat(result.getRotatorOffCenterAffect(), "10：转子离心力振动影响量（上机架XY，下机架XY）");
		printFLoat(result.getTopBend(), "11：上导弯曲量");
		printFLoat(result.getBottomBend(), "12：下导弯曲量");
		printFLoat(result.getHorizonBend(), "13：水导弯曲量");
		printFLoat(result.getMirrorNotVertical(), "14：镜板不垂直量");

		// 15上导/水导盘车量 ?
		printFLoat(result.getTopPanCar(), "15：上导/水导盘车量 -上导");
		printFLoat(result.getTopHorrizonPanCar(), "15：上导/水导盘车量 -水导");
		// 16下导/水导盘车量 ?
		printFLoat(result.getBottomPanCar(), "16：下导/水导盘车量 -下导");
		printFLoat(result.getBottomHorrizonPanCar(), "16：下导/水导盘车量-水导");
	}

	private static void printFLoat(float[] arr, String begin) {
		if (arr == null) {
			System.out.println("不存在");
			return;
		}
		System.out.print(begin + ":");
		for (float a : arr) {
			System.out.print(a + ",");
		}
		System.out.println("");
	}

	private static void printFLoat(float arr, String begin) {
		if (arr == 9999) {
			System.out.println("不存在");
			return;
		}
		System.out.println(begin + ":" + arr);
	}

	private static void printFLoat(SpaceVector arr, String begin) {
		if (arr == null) {
			System.out.println("不存在");
			return;
		}
		System.out.println(begin + ":Angle:" + arr.getAngle() + "，Len:" + arr.getLength());
	}
}
