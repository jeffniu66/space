package cn.oge.sci.space.青居;

import org.junit.Test;
import org.oge.spacecacu.model.SpaceResult;

import cn.oge.sci.JSpaceMain;
import cn.oge.sci.kks.KKS_QJ_01;
import cn.oge.sci.kks.KKS_QJ_02;
import cn.oge.sci.kks.KKS_QJ_03;
import cn.oge.sci.kks.KKS_QJ_04;
import cn.oge.sci.space.SpaceHelper;

public class JsonFileTest_QJ {

	/**
	 * #1号机snapshot数据测试
	 */
	@Test
	public void test_snapshot_01() throws Exception {
		String filePath = "/qj/space_01.json";
		String absPath = JsonFileTest_QJ.class.getResource(filePath).getPath();
		// SpaceResult result = JSpaceMain.calc(absPath);
		SpaceResult result = JSpaceMain.calc(absPath, KKS_QJ_01.KKS_IN);
		// System.out.println(JSONObject.fromObject(result));

		SpaceHelper.printResult(result);
	}

	/**
	 * #2号机snapshot数据测试
	 */
	@Test
	public void test_snapshot_02() throws Exception {
		String filePath = "/qj/space_02.json";
		String absPath = JsonFileTest_QJ.class.getResource(filePath).getPath();
		// SpaceResult result = JSpaceMain.calc(absPath);
		SpaceResult result = JSpaceMain.calc(absPath, KKS_QJ_02.KKS_IN);
		// System.out.println(JSONObject.fromObject(result));

		SpaceHelper.printResult(result);
	}

	/**
	 * #3号机snapshot数据测试
	 */
	@Test
	public void test_snapshot_03() throws Exception {
		String filePath = "/qj/space_03.json";
		String absPath = JsonFileTest_QJ.class.getResource(filePath).getPath();
		// SpaceResult result = JSpaceMain.calc(absPath);
		SpaceResult result = JSpaceMain.calc(absPath, KKS_QJ_03.KKS_IN);
		// System.out.println(JSONObject.fromObject(result));

		SpaceHelper.printResult(result);
	}

	/**
	 * #4号机snapshot数据测试
	 */
	@Test
	public void test_snapshot_04() throws Exception {
		String filePath = "/qj/space_04.json";
		String absPath = JsonFileTest_QJ.class.getResource(filePath).getPath();
		// SpaceResult result = JSpaceMain.calc(absPath);
		SpaceResult result = JSpaceMain.calc(absPath, KKS_QJ_04.KKS_IN);
		// System.out.println(JSONObject.fromObject(result));

		SpaceHelper.printResult(result);
	}

}