package cn.oge.sci.space;

import org.junit.Test;
import org.oge.spacecacu.model.SpaceResult;

import cn.oge.sci.JSpaceMain;

public class JsonFileTest {

	/***
	 * 可以运行
	 * 
	 * @throws Exception
	 */
	@Test
	public void t_1426746133000() throws Exception {
		String filePath = "/space-1-1426746133000.json";
		String absPath = JsonFileTest.class.getResource(filePath).getPath();
		SpaceResult result = JSpaceMain.calc(absPath);
		// System.out.println(JSONObject.fromObject(result));
		
		SpaceHelper.printResult(result);
	}
	
	/***
	 * 桐子林1号机
	 * 
	 * @throws Exception
	 */
	@Test
	public void t_tzl67_space() throws Exception {
		String filePath = "/tzl67-space.json";
		String absPath = JsonFileTest.class.getResource(filePath).getPath();
		SpaceResult result = JSpaceMain.calc(absPath);
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
		String absPath = JsonFileTest.class.getResource(filePath).getPath();
		SpaceResult result = JSpaceMain.calc(absPath);
		// System.out.println(JSONObject.fromObject(result));
		SpaceHelper.printResult(result);
	}

}