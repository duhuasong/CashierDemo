package data;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.google.gson.Gson;

import payUI.Pay;
import paydll.CallDll;

public abstract class RetrunData {
	static 	Logger log = LogManager.getLogger(Pay.class);
	private CallDll callDll;

	public CallDll getCallDll() {
		return callDll;
	}

	public void setCallDll(CallDll callDll) {
		this.callDll = callDll;
	}

	private static RetrunData db;

	public static RetrunData getDb() {
		return db;
	}

	public static void setDb(RetrunData db) {
		RetrunData.db = db;
	}

	public abstract Map<String, String> parse(String data);

	public abstract int save(String data);

	public abstract int update(String data);

	public abstract String select(String data);

	public abstract String delete(String data);

	public String[] unionParse(String req, String xml) {
		
		log.debug("xml:" + xml);
		String res[] = new String[] { "", "" };
		Map<String, String> mapReq = db.parse(req);
		Map<String, String> mapOne = db.parse(xml);
		Map<String, String> mapTwo = new TreeMap<>();
		String re = null;
		String pm = null;
		String time = null;
		String tradeNo = null;
		int i = 0;
		String mString = mapOne.get("ReturnCode");
		String reference = mapOne.get("Reference");
		log.debug("mapOne:" + mapOne);
		while (mString != null && !mString.equals("") && !mString.trim().equals("201") && i < 7) {
			i++;
			String stringxml = callDll.query(reference);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			mapTwo = db.parse(stringxml);
			log.debug("i:" + i + "///" + new Gson().toJson(mapTwo));
			mString = mapTwo.get("ReturnCode");
		}
		Map<String, String> maptmp = RetrunData.mapMege(mapReq, mapOne);
		Map<String, String> map = RetrunData.mapMege(maptmp, mapTwo);
		log.debug("map:" + new Gson().toJson(map));

		if (map.get("ReturnCode") != null && !map.get("ReturnCode").equals("")
				&& map.get("ReturnCode").trim().equals("201")) {
			res[1] = "支付成功";
			if (map.get("TransType") != null && !map.get("TransType").equals("")
					&& map.get("TransType").trim().equals("2")) {
				// 二维码
				pm = "二维码";
			} else if (map.get("TransType") != null && !map.get("TransType").equals("")
					&& map.get("TransType").trim().equals("1")) {
				// 银行卡
				pm = "银行卡";
			} else {
				pm = "其他";
			}

			if (map.get("TransDate") != null && !map.get("TransDate").equals("")) {
				time = (String) map.get("TransDate");
				try {
					time = RetrunData.dateParse(time);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else {
				time = "";
			}

			if (map.get("Reference") != null && !map.get("Reference").equals("")) {
				tradeNo = (String) map.get("Reference");
			} else {
				tradeNo = "";
			}
		} else {
			if (map.get("ReturnCode") != null && !map.get("ReturnCode").equals("")
					&& map.get("ReturnCode").trim().equals("203")) {
				res[1] = "未知";
			} else if (map.get("ReturnCode") != null && !map.get("ReturnCode").equals("")
					&& map.get("ReturnCode").trim().equals("202")) {
				res[1] = "支付失败";
			} else if (map.get("ReturnCode") != null && !map.get("ReturnCode").equals("")
					&& map.get("ReturnCode").trim().equals("205")) {
				res[1] = "客户未支付（未输入密码等）";
			} else if (map.get("ReturnCode") != null && !map.get("ReturnCode").equals("")
					&& map.get("ReturnCode").trim().equals("206")) {
				res[1] = "用户支付中（等待用户支付完成）";
			} else {
				res[1] = "未知";
			}
			pm = "二维码";
			time = "";
			tradeNo = map.get("Reference");
		}
		re = "支付方式："+pm + "\n" + "交易时间："+time + "\n" + "订单号："+tradeNo;
		res[0] = re;
		log.debug("res:" + new Gson().toJson(res));
		return res;
	}

	public static String dateParse(String dateStr) throws Exception {
		if (dateStr != null && !dateStr.trim().equals("")) {
			String simpleDateFormat = "yyyyMMddHHmmss";
			String simpleDateFormat2 = "yyyy-MM-dd-HH:mm:ss";
			SimpleDateFormat dateFormat = new SimpleDateFormat(simpleDateFormat);
			Date date = dateFormat.parse(dateStr);
			SimpleDateFormat dateFormat2 = new SimpleDateFormat(simpleDateFormat2);
			return dateFormat2.format(date);
		} else {
			return null;
		}
	}

	public static Map<String, String> mapMege(Map<String, String> a, Map<String, String> b) {
		Map<String, String> combineResultMap = new TreeMap<String, String>();
		combineResultMap.putAll(a);
		combineResultMap.putAll(b);
		return combineResultMap;

	}

	/*
	 * public static void main(String[] args) throws Exception { Map<String,
	 * String> a = new TreeMap<String, String>(); a.put("one", "一");
	 * a.put("two", "二"); a.put("three", "三");
	 * 
	 * Map<String, String> b = new TreeMap<String, String>(); b.put("one", "十");
	 * b.put("nine", "九"); b.put("eight", "八"); Map<String, String> map =
	 * RetrunData.mapMege(a, b); System.out.print(new Gson().toJson(map));
	 * 
	 * 
	 * }
	 */

}
