package cn.oge.sci.space.温泉;

import org.oge.spacecacu.model.SpaceResult;

import cn.oge.sci.JSpaceMain;
import cn.oge.sci.space.SpaceHelper;
import cn.oge.sci.space.青居.JsonFileTest_QJ;

public class Test {

	@org.junit.Test
	public void test1() throws Exception {

		String[] kks = new String[] { "EB000HP1MKC01MK012BL01J1CC001CA01", "EB000HP1MKC01MK012BN01J1CC001CA01",
				"EB000HP1MKD01MK012BL01J1CC001CA01", "EB000HP1MKD01MK012BN01J1CC001CA01",
				"EB000HP1MEC01ME010BL01J1CC001CA01", "EB000HP1MEC01ME010BN01J1CC001CA01",
				"EB000HP1MKC01MK011BL01J1CB001CA01", "EB000HP1MKC01MK011BN01J1CB001CA01",
				"EB000HP1MKD01MK011BL01J1CB001CA01", "EB000HP1MKD01MK011BN01J1CB001CA01",
				"EB000HP1MEJ01ME029BL01J1CB001CA01", "EB000HP1MEJ01ME029BN01J1CB001CA01" };

		String filePath = "/wenqian/1.json";
		String absPath = JsonFileTest_QJ.class.getResource(filePath).getPath();
		// SpaceResult result = JSpaceMain.calc(absPath);
		SpaceResult result = JSpaceMain.calc(absPath, kks);
		// System.out.println(JSONObject.fromObject(result));

		SpaceHelper.printResult(result);
	}
}
