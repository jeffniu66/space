package cn.oge.sci.space.error;

import org.junit.Test;
import org.oge.spacecacu.model.SpaceResult;

import cn.oge.sci.JSpaceMain;
import cn.oge.sci.space.SpaceHelper;

public class ErrorTest {

	/**
	 * 计算，转子离心力振动影响量（上机架XY，下机架XY），有误
	 * 
	 * @throws Exception
	 */
	@Test
	public void t_1439635120672() throws Exception {
		String filePath = "/error/1439635120672.json";
		SpaceResult result = JSpaceMain.calc(filePath);
		// System.out.println(JSONObject.fromObject(result));
		SpaceHelper.printResult(result);
	}

}