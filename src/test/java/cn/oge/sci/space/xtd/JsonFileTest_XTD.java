package cn.oge.sci.space.xtd;

import org.junit.Test;
import org.oge.spacecacu.model.SpaceResult;

import cn.oge.sci.JSpaceMain;
import cn.oge.sci.kks.KKS_XTD_02;
import cn.oge.sci.kks.KKS_XTD_03;
import cn.oge.sci.space.SpaceHelper;

public class JsonFileTest_XTD {

	/***
	 * 磁极有问题
	 * 
	 * @throws Exception
	 */
	@Test
	public void t_1426746133000() throws Exception {
		String filePath = "/space-xtd-1.json";
		String absPath = JsonFileTest_XTD.class.getResource(filePath).getPath();
		SpaceResult result = JSpaceMain.calc(absPath);
		// System.out.println(JSONObject.fromObject(result));

		SpaceHelper.printResult(result);
	}

	@Test
	public void test_snapshot() throws Exception {
		String filePath = "/snapshot/space.json";
		String absPath = JsonFileTest_XTD.class.getResource(filePath).getPath();
		// SpaceResult result = JSpaceMain.calc(absPath);
		SpaceResult result = JSpaceMain.calc(absPath, KKS_XTD_02.KKS_IN);
		// System.out.println(JSONObject.fromObject(result));

		SpaceHelper.printResult(result);
	}
	
	@Test
	public void test_2_1441487714000() throws Exception {
		String filePath = "/xtd/space_2_1441487714000.json";
		String absPath = JsonFileTest_XTD.class.getResource(filePath).getPath();
		// SpaceResult result = JSpaceMain.calc(absPath);
		SpaceResult result = JSpaceMain.calc(absPath, KKS_XTD_02.KKS_IN);
		// System.out.println(JSONObject.fromObject(result));

		SpaceHelper.printResult(result);
	}
	
	@Test
	public void test_3_1441487714000() throws Exception {
		String filePath = "/xtd/space_3_1441487714000.json";
		String absPath = JsonFileTest_XTD.class.getResource(filePath).getPath();
		// SpaceResult result = JSpaceMain.calc(absPath);
		SpaceResult result = JSpaceMain.calc(absPath, KKS_XTD_03.KKS_IN);
		// System.out.println(JSONObject.fromObject(result));

		SpaceHelper.printResult(result);
	}
	@Test
	public void test_3_1439374828000() throws Exception {
		String filePath = "/xtd/space_3_1439374828000.json";
		String absPath = JsonFileTest_XTD.class.getResource(filePath).getPath();
		// SpaceResult result = JSpaceMain.calc(absPath);
		SpaceResult result = JSpaceMain.calc(absPath, KKS_XTD_03.KKS_IN);
		// System.out.println(JSONObject.fromObject(result));
		
		SpaceHelper.printResult(result);
	}

	/***
	 * 有问题
	 * 
	 * @throws Exception
	 */
	@Test
	public void t_1431172415000() throws Exception {
		String filePath = "/xjb_space_1431172415000.json";
		String absPath = JsonFileTest_XTD.class.getResource(filePath).getPath();
		SpaceResult result = JSpaceMain.calc(absPath);
		// System.out.println(JSONObject.fromObject(result));
		SpaceHelper.printResult(result);
	}

}