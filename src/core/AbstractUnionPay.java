package core;

import java.awt.Font;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import data.RetrunData;
import payUI.Pay;
import paydll.CallDll;
import paydll.UsbhookDll;
import sound.Mp3Player;
import sound.Voice;

public abstract class AbstractUnionPay {
	// 定义支付处理整体框架
	protected static ThreadLocal<UsbhookDll> uThreadLocal = new ThreadLocal<UsbhookDll>();
	protected static ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
	protected static CallDll callDll;
	protected static RetrunData  retrunData;
	static Voice voice;
	 public static Voice getVoice() {
		return voice;
	}

	public static void setVoice(Voice voice) {
		AbstractUnionPay.voice = voice;
	}

	static 	Logger log = LogManager.getLogger(AbstractUnionPay.class);
	public static RetrunData getRetrunData() {
		return retrunData;
	}

	public static void setRetrunData(RetrunData retrunData) {
		AbstractUnionPay.retrunData = retrunData;
	}

	public static CallDll getCallDll() {
		return callDll;
	}

	public static void setCallDll(CallDll callDll) {
		AbstractUnionPay.callDll = callDll;
	}

	public static ExecutorService getCachedThreadPool() {
		return cachedThreadPool;
	}

	public static void setCachedThreadPool(ExecutorService cachedThreadPool) {
		AbstractUnionPay.cachedThreadPool = cachedThreadPool;
	}

	public static ThreadLocal<UsbhookDll> getuThreadLocal() {
		return uThreadLocal;
	}

	public static void setuThreadLocal(ThreadLocal<UsbhookDll> uThreadLocal) {
		AbstractUnionPay.uThreadLocal = uThreadLocal;
	}

	public static Lock lock = new ReentrantLock();
	private static Pay pay;

	public static Pay getPay() {
		return pay;
	}

	public static void setPay(Pay pay) {
		AbstractUnionPay.pay = pay;
	}


	protected static ThreadLocal<FutureTask<String>> futureTaskThreadLocal = new ThreadLocal<FutureTask<String>>();
	private Callable<String> calculateCallable;
	private FutureTask<String> calculateFutureTask;

	public abstract void pay(String amount);

	//后台默认支付策略
	public void unionPayv1() {
		// 配置二维码监听进程
		final UsbhookDll usbhookDll = new UsbhookDll();
		usbhookDll.setLock(lock);
		usbhookDll.setUsbhook(usbhookDll);
		UsbhookDll.setPay(pay);
		usbhookDll.init();
		// 启动监听
		uThreadLocal.set(usbhookDll);
		if (callDll ==null) {
			callDll = new CallDll();	
		}
		AbstractUnionPay.setCallDll(callDll);
	}
	
	//扫码填充策略
	public void unionPay() {
		// 配置二维码监听进程
		//final UsbhookDll usbhookDll = new UsbhookDll();
		//usbhookDll.setLock(lock);
		//usbhookDll.setUsbhook(usbhookDll);
		//UsbhookDll.setPay(pay);
		//usbhookDll.init();
		// 启动监听
		//uThreadLocal.set(usbhookDll);
		
		pay.getTextPane1().setText("");
		SimpleAttributeSet bSet = new SimpleAttributeSet();
		StyleConstants.setAlignment(bSet, StyleConstants.ALIGN_CENTER);
		StyledDocument doc = pay.getTextPane1().getStyledDocument();
		doc.setCharacterAttributes(105, doc.getLength() - 105, bSet, false);
		doc.setParagraphAttributes(0, 104, bSet, false);
		pay.getTitle2().setText("请扫描二维码");
		try {
			Voice.voice("请扫描二维码");
			Voice.voice("请扫描二维码");
			Voice.transform("请扫描二维码", "./voice/"+"请扫描二维码.wav");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Mp3Player.pl("./voice/"+"请扫描二维码.wav");
		}
		pay.getTextPane1().setStyledDocument(doc);
		pay.getTextPane1().setFont(new Font("宋体", Font.PLAIN, 30));
		pay.getTextPane1().setFocusable(true);
		AbstractUnionPay.setCallDll(callDll);
	}
	

}
