package untill;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import core.AbstractUnionPay;
import paydll.UsbhookDll;

public class QraResolve {
	    static 	Logger log = LogManager.getLogger(QraResolve.class);
		public static boolean discriminate(String qra){
			int len  = qra.length();
			log.debug("qra："+qra);
			log.debug("int len"+len);			
			if (len >= 18) {
				//满足三种二维码条件
				if (len < 19 ) {
					
					//满足微信、支付宝二维码条件
					if (qra.substring(len-18, len-16).equals("13") || qra.substring(len-18, len-16).equals("28")) {
						return true;
					}else {
						return false;
					}
				}else {
					//大于等于20位，先判断微信支付宝云闪付条件
					if (qra.substring(len-18, len-16).equals("13") || qra.substring(len-18, len-16).equals("28") || qra.substring(len-19,len-17).equals("62")) {
						return true;
					}else {
						return false;
					}			
				}
			}else {
				//都不满足
				return false;
			}
		}
		
/*		public static void main(String[] args) {
			UsbhookDll usbhookDll = new UsbhookDll();
			usbhookDll.init();
			log.debug(QraResolve.discriminate(usbhookDll.tmp));
			String qra = usbhookDll.tmp;
			log.debug(QraResolve.discriminate(qra));
		}*/
}
