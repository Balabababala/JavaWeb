package util;

public class Util {
	public static boolean isNumber(String data) {
		try {
			Integer.parseInt(data);
			return true;
		}catch (Exception e) {
			return false;
			// TODO: handle exception
		}
	}
	public static boolean isNumber2(String data) {
		if (data==null)return false;
		return data.matches("\\d+");
	}
	public static boolean isDouble(String data) {
		try {
			Double.parseDouble(data);
			return true;
		}catch (Exception e) {
			return false;
			// TODO: handle exception
		}
	}
}
