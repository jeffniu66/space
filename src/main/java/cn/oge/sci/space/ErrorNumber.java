package cn.oge.sci.space;

public class ErrorNumber {

	public static final int KKS_ISNULL = -10;
	/** 通过地址访问获取的数据为空 */
	public static final int RTVALUELIST_ISNULL = -20;
	public static final int SPACE_RESULT_ISNULL = -30;
	public static final int CACL_ERROR = -40;
	
	public static final int INVALID_TIME_DIFF = -50;
	/** 波形不完整 */
	public static final int WAVE_ISNOTFULL = -60;
	/** 没有新的数据 */
	public static final int NO_NEW_DATA = -1;

	public static final int CALC_SUCCESS = 10;
	public static final int WRITE_SUCCESS = 20;
}
