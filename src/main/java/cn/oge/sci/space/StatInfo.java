package cn.oge.sci.space;


public class StatInfo {

	private int errorNumber;

	public String getErrorMsg() {
		int errorNum = this.errorNumber;
		String msg = "未知错误";
		switch (errorNum) {
		case ErrorNumber.KKS_ISNULL:
			msg = "kks为空！";
			break;
		case ErrorNumber.RTVALUELIST_ISNULL:
			msg = "rtValueList为空！";
			break;
		case ErrorNumber.SPACE_RESULT_ISNULL:
			msg = "没有空间轴线结果！";
			break;
		case ErrorNumber.CACL_ERROR:
			msg = "计算结果错误！";
			break;
		case ErrorNumber.NO_NEW_DATA:
			msg = "没有新数据！";
			break;
		case ErrorNumber.INVALID_TIME_DIFF:
			msg = "数据包内时间差大过指定时间！";
			break;
		case ErrorNumber.WAVE_ISNOTFULL:
			msg = "波形不完整！";
			break;
		case ErrorNumber.CALC_SUCCESS:
			msg = "计算成功！";
			break;
		case ErrorNumber.WRITE_SUCCESS:
			msg = "写入成功！";
			break;
		default:
			break;
		}
		return msg;
	}

	public StatInfo(int errNo) {
		this.errorNumber = errNo;
	}

	public void setErrorNumber(int errorNumber) {
		this.errorNumber = errorNumber;
	}

	public int getErrorNumber() {
		return errorNumber;
	}
}
