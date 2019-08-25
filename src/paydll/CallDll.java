package paydll;

import java.io.UnsupportedEncodingException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;
import com.sun.jna.win32.StdCallLibrary;

import OldUI.Pay;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.ByteByReference;
import com.sun.jna.Memory;
import com.sun.jna.Native;

/**
 * JNA妗嗘灦DLL鍔ㄦ�搴撹鍙栬皟鐢ㄧず渚嬬被
 * 
 * @ClassName: DllCall
 * @Description: 璇诲彇璋冪敤DLL鍔ㄦ�搴撴枃浠朵腑鐨勬柟娉�
 * @author: LinWenLi
 * @date: 2018骞�鏈�8鏃�涓婂崍10:32:16
 */
public class CallDll {
	static 	Logger log = LogManager.getLogger(CallDll.class);
	/**
	 * DLL鍔ㄦ�搴撹皟鐢ㄦ柟娉�
	 * 
	 * @Description: 璇诲彇璋冪敤CDecl鏂瑰紡瀵煎嚭鐨凞LL鍔ㄦ�搴撴柟娉�
	 * @author: LinWenLi
	 * @date: 2018骞�鏈�8鏃�涓婂崍10:49:02
	 */
	public interface CLibrary extends Library {
		CLibrary INSTANCE = (CLibrary) Native.loadLibrary("Tpos", CLibrary.class);
		void UnionPay(String format1, Pointer format2);
		void UnionPayCheck(String format1, Pointer format2);
	}
	
	public interface CLibraryhk extends Library {
		CLibraryhk INSTANCEHK = (CLibraryhk) Native.loadLibrary("Connect_Web", CLibraryhk.class);
		void UnionPay_Pay(String format1, Pointer format2);
	}

	public String pay(String amount, String body, String transType) {
		// 调用底层支付接口,transType银行卡交易传1，二维码交易传2。
		String p1 = "<xml><TransType>" + transType + "</TransType><Amount>" + amount + "</Amount><Body>" + body+ "</Body></xml>";
		Pointer myStr = new Memory(1024);
		log.debug("p1:"+p1);
		CLibrary.INSTANCE.UnionPay(p1, myStr);
		String string = new String(myStr.getString(0, "gb2312"));
		log.debug("String string:"+string);		
		return string;
	}
	
	public String[] payWithAuthCode(String amount, String body, String transType, String authCode) {
		// 调用底层支付接口,transType银行卡交易传1，二维码交易传2。
		String p1 = "<xml><TransType>" + transType + "</TransType><Amount>" + amount + "</Amount><Body>" + body
				+ "</Body><QRCode>" + authCode + "</QRCode></xml>";
		Pointer myStr = new Memory(1024);
		log.debug("String p1:"+p1);	
		String[] strings = new String[]{"",""}; 
		CLibrary.INSTANCE.UnionPay(p1, myStr);
		strings[0] = p1;
		strings[1] = new String(myStr.getString(0, "gb2312"));
		log.debug("String[] strings:"+new Gson().toJson(strings));		
		return strings;
	}

	public String payhk(String mchId, String outTradeNo, String deviceInfo, String body, String totalFee,
			String mchCreateIp, String authCode, String nonceStr, String sign) {
		// 调用原始底层支付接口

		String p1 = "<xml><service>unified.trade.micropay</service><mch_id>" + mchId + "</mch_id><out_trade_no>"
				+ outTradeNo + "</out_trade_no><device_info>" + deviceInfo + "</device_info><body>" + body
				+ "</body><total_fee>" + totalFee + "</total_fee><mch_create_ip>" + mchCreateIp
				+ "</mch_create_ip><auth_code>" + authCode + "</auth_code><nonce_str>" + nonceStr
				+ "</nonce_str> <sign>" + sign + "</sign></xml>";
		Pointer myStr = new Memory(1024);
		CLibraryhk.INSTANCEHK.UnionPay_Pay(p1, myStr);
		String string = new String(myStr.getString(0, "gb2312"));
		return string;
	}

	public String query(String reference) {
		// 调用底层支付接口,transType银行卡交易传1，二维码交易传2。
		String p1 = "<xml><Reference>" + reference + "</Reference></xml>";
		log.debug("String p1:"+p1);		
		Pointer myStr = new Memory(1024);
		CLibrary.INSTANCE.UnionPayCheck(p1, myStr);
		String string = new String(myStr.getString(0, "gb2312"));
		log.debug("String string:"+string);		
		return string;
	}

	public String queryhk(String mchId, String outTradeNo, String deviceInfo, String body, String nonceStr,
			String sign) {
		// 调用原始底层支付接口
		String p1 = "<xml><service>unified.trade.query</service><mch_id>" + mchId + "</mch_id><out_trade_no>"
				+ outTradeNo + "</out_trade_no><device_info>" + deviceInfo + "</device_info><body>" + body
				+ "</body><total_fee>" + 0 + "</total_fee><nonce_str>" + nonceStr + "</nonce_str> <sign>" + sign
				+ "</sign></xml>";
		Pointer myStr = new Memory(1024);
		CLibrary.INSTANCE.UnionPayCheck(p1, myStr);
		String string = new String(myStr.getString(0, "gb2312"));
		return string;
	}

/*public static void main(String[] args) {
	CallDll callDll = new CallDll();
	//String string = callDll.pay("1", "1", "2");
	String string = callDll.payWithAuthCode("1", "1", "2", "134807834379682352");
	System .out.print("string:"+string);
}*/

}