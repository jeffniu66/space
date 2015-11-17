package cn.oge.sci.space.青居;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import cn.oge.sci.JSpaceMain;
import cn.oge.sci.StatInfo;
import cn.oge.sci.kks.InputKKS_Space_TZL;
import cn.oge.sci.kks.KKS_QJ_01;

public class RestTest {

	// 桐子林1号机组
	public static String[] kksArr = { //
	/*----*/"EB001HP0MKA01MK016BL01J1CA004CA01", // +X
			"EB001HP0MKA01MK016BM01J1CA004CA01", // +X+Y
			"EB001HP0MKA01MK016BN01J1CA004CA01", // +Y
			"EB001HP0MKA01MK016BP01J1CA004CA01", // -X+Y
			"EB001HP0MKA01MK016BR01J1CA004CA01", // -X
			"EB001HP0MKA01MK016BQ01J1CA004CA01", // -X-Y
			"EB001HP0MKA01MK016BS01J1CA004CA01", // -Y
			"EB001HP0MKA01MK016BT01J1CA004CA01" // / -X-Y
	};

	public static List<String> kksList = new ArrayList<String>();

	public static List<String> createKKSList() {
		kksList.add("EB001HP0MKA01MK016BL01J1CA004CA01");
		kksList.add("EB001HP0MKA01MK016BM01J1CA004CA01");
		kksList.add("EB001HP0MKA01MK016BN01J1CA004CA01");
		kksList.add("EB001HP0MKA01MK016BP01J1CA004CA01");
		kksList.add("EB001HP0MKA01MK016BR01J1CA004CA01");
		kksList.add("EB001HP0MKA01MK016BQ01J1CA004CA01");
		kksList.add("EB001HP0MKA01MK016BS01J1CA004CA01");
		kksList.add("EB001HP0MKA01MK016BT01J1CA004CA01");
		return kksList;
	}

	@Test
	public void test1() {
		String host = "211.154.164.67";
		int port = 5080;
		int dubboPort = 20883;
		String[] kksArr = InputKKS_Space_TZL.KKS[0];
		for (int i = 0; i < 1000; i++) {
			StatInfo result = JSpaceMain.calc(kksArr, host, port, dubboPort, createKKSList());
			if (result != null) {
				System.out.println("good!");
			}
			System.out.println("-------" + (i + 1));
		}
	}

	@Test
	public void 小天都_1号机_12个输入量() {
		String host = "10.61.98.80";
		int port = 8082;
		int dubboPort = 20883;
		String[] kksArr = KKS_QJ_01.KKS_IN;
		for (int i = 0; i < 1000; i++) {
			StatInfo result = JSpaceMain.calc(kksArr, host, port, dubboPort, createKKSList());
			if (result != null) {
				System.out.println("good!");
			}
			System.out.println("-------" + (i + 1));
		}
	}
}
