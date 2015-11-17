package cn.oge.sci.space.青居;

import java.util.List;

import net.sf.json.JSONArray;

import org.junit.Test;

import cn.oge.kdm.service.dto.RTDataSet;
import cn.oge.sci.data.DataLoader;
import cn.oge.sci.data.kdm.KdmDubboApi;
import cn.oge.sci.kks.KKS_QJ_01;
import cn.oge.sci.kks.KKS_QJ_02;
import cn.oge.sci.kks.KKS_QJ_03;
import cn.oge.sci.kks.KKS_QJ_04;
import cn.oge.sci.util.KdmJsonUtils;
import cn.oge.sci.util.KdmUtils;

public class JsonData_QJ {
	
	private String dubbourl = "dubbo://10.61.70.80:20883";

	// 青居1
	@Test
	public void test1() {
		DataLoader dataLoader = new KdmDubboApi(dubbourl);
		try {
			String kks = KdmUtils.arr2str(KKS_QJ_01.KKS_IN);
			List<RTDataSet> snapshot = dataLoader.getRTDataSnapshot(kks);
			System.out.println(JSONArray.fromObject(snapshot));
			KdmJsonUtils.saveToFile(snapshot,
					"src/test/resources/qj/space_01.json");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 青居2
	@Test
	public void test2() {
		DataLoader dataLoader = new KdmDubboApi(dubbourl);
		try {
			String kks = KdmUtils.arr2str(KKS_QJ_02.KKS_IN);
			List<RTDataSet> snapshot = dataLoader.getRTDataSnapshot(kks);
			System.out.println(JSONArray.fromObject(snapshot));
			KdmJsonUtils.saveToFile(snapshot,
					"src/test/resources/qj/space_02.json");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 青居3
	@Test
	public void test3() {
		DataLoader dataLoader = new KdmDubboApi(dubbourl);
		try {
			String kks = KdmUtils.arr2str(KKS_QJ_03.KKS_IN);
			List<RTDataSet> snapshot = dataLoader.getRTDataSnapshot(kks);
			System.out.println(JSONArray.fromObject(snapshot));
			KdmJsonUtils.saveToFile(snapshot,
					"src/test/resources/qj/space_03.json");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 青居4
	@Test
	public void test4() {
		DataLoader dataLoader = new KdmDubboApi(dubbourl);
		try {
			String kks = KdmUtils.arr2str(KKS_QJ_04.KKS_IN);
			List<RTDataSet> snapshot = dataLoader.getRTDataSnapshot(kks);
			System.out.println(JSONArray.fromObject(snapshot));
			KdmJsonUtils.saveToFile(snapshot,
					"src/test/resources/qj/space_04.json");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
