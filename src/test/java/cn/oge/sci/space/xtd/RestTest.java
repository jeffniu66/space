package cn.oge.sci.space.xtd;

import org.junit.Test;

import cn.oge.sci.JSpaceMain;
import cn.oge.sci.StatInfo;
import cn.oge.sci.kks.KKS_XTD_01;
import cn.oge.sci.kks.KKS_XTD_02;
import cn.oge.sci.kks.KKS_XTD_03;

public class RestTest {

	private String host = "10.61.98.79";
	private int port = 8082;
	private int dubboPort = 20883;

	@Test
	public void 小天都_3号机() {
		String[] kksArr = KKS_XTD_03.KKS_IN;
		for (int i = 0; i < 1000; i++) {
			// StatInfo result = JSpaceMain.calc(kksArr, host, port, dubboPort,
			// KKS_XTD_02.KKS_OUT);
			StatInfo result = JSpaceMain.calc(kksArr, host, port, dubboPort);
			if (result != null) {
				System.out.println("good!");
				System.out.println(result.getErrorMsg());
			}
			System.out.println("-------" + (i + 1));
		}
	}

	@Test
	public void 小天都_2号机() {
		String[] kksArr = KKS_XTD_02.KKS_IN;
		for (int i = 0; i < 1000; i++) {
			// StatInfo result = JSpaceMain.calc(kksArr, host, port, dubboPort,
			// KKS_XTD_02.KKS_OUT);
			StatInfo result = JSpaceMain.calc(kksArr, host, port, dubboPort);
			if (result != null) {
				System.out.println("good!");
				System.out.println(result.getErrorMsg());
			}
			System.out.println("-------" + (i + 1));
		}
	}

	@Test
	public void 小天都_1号机() {

		String[] kksArr = KKS_XTD_01.KKS_IN;
		for (int i = 0; i < 1000; i++) {
			// StatInfo result = JSpaceMain.calc(kksArr, host, port, dubboPort,
			// KKS_XTD_01.KKS_OUT);
			StatInfo result = JSpaceMain.calc(kksArr, host, port, dubboPort);
			if (result != null) {
				System.out.println("good!");
				System.out.println(result.getErrorMsg());
			}
			System.out.println("-------" + (i + 1));
		}
	}
}
