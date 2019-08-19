package core;


import java.awt.Color;
import java.awt.Font;
import java.io.IOException;

import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import com.google.gson.Gson;

import payUI.Pay;
import paydll.CallDll;
import paydll.UsbhookDll;
import sound.Mp3Player;
import sound.Voice;


public class UnionPayForDeliver extends AbstractUnionPay {
	// 授权码使用参数传递策略
	public void pay(final String amount) {
		log.debug("amount:"+amount);
		String f = String.valueOf(Float.valueOf(amount) * 100);
		log.debug(" f :"+ f );
		final String fString = String.valueOf(Math.round(Float.valueOf(f)));
		// 此处轮询判断银行卡二维码硬件状态，后续补充银行卡状态
		cachedThreadPool.execute(new  Runnable() {
			public void run() {
				unionPay();
			}
		});
		
		
		cachedThreadPool.execute(new Runnable() {
			public void run() {
				synchronized (lock) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			    //v1
				//String tmps = UsbhookDll.tmp ;
				//v1
				String  tmps = getPay().getTextPane1().getText();
				log.debug("String tmps :"+tmps);
				callDll = new CallDll();
				String[] re = callDll.payWithAuthCode(fString, "1", "2", tmps);// 此处写死，后续补充
				log.debug("String[] re :"+new Gson().toJson(re));
				retrunData.setCallDll(callDll);
				String[] strings = retrunData.unionParse(re[0],re[1]);
				log.debug("String[] strings :"+new Gson().toJson(strings));
				getPay().getTitle2().setText("收款金额：                       ");
				final Pay  pay = AbstractUnionPay.getPay();
				JTextPane  jtex = pay.getTextPane1();
				SimpleAttributeSet dSet = new SimpleAttributeSet();   
				StyleConstants.setAlignment(dSet, StyleConstants.ALIGN_CENTER);  
				StyledDocument doc = jtex.getStyledDocument();  
		        doc.setCharacterAttributes(105, doc.getLength()-105, dSet, false);  
		        doc.setParagraphAttributes(0, 104, dSet, false);  
				jtex.setStyledDocument(doc);
				Font font = new Font("宋体",Font.BOLD,40);
				jtex.setFont(font);
				jtex.setEditable(true);
				jtex.setText(amount + "元 \n" + strings[1] );
				jtex.setEditable(false);
				try {
					if (condition) {
						
					}
					Voice.voice(strings[1]+amount+"元");
					Voice.voice(strings[1]+amount+"元");
					Voice.transform(strings[1], "./voice/"+strings[1]+".wav");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					Mp3Player.pl("./voice/"+"收款成功.wav");
					
				}
				
				SimpleAttributeSet eSet = new SimpleAttributeSet();   
				JTextPane  jp = pay.getTextPane2();
				StyleConstants.setAlignment(eSet, StyleConstants.ALIGN_LEFT);  
				StyledDocument doc2 = jp.getStyledDocument();  
		        doc2.setCharacterAttributes(105, doc2.getLength()-105, eSet, false);  
		        doc2.setParagraphAttributes(0, 104, eSet, false);  
				jp.setStyledDocument(doc2);
				Font font2 = new Font("宋体",Font.PLAIN,15);
				jp.setFont(font2);
				jp.setEditable(true);
				jp.setBackground(new Color(255,255,255));
				jp.setText(strings[0]);
				jp.setEditable(false);
				
				cachedThreadPool.execute(new  Runnable() {
					public void run() {
						Pay.setThread(Thread.currentThread());
						for (int i = 20; i >= 0; i--) {
							pay.getTitle4().setText("返回(" + i + "秒...)");	
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						SimpleAttributeSet bSet = new SimpleAttributeSet();
						StyleConstants.setAlignment(bSet, StyleConstants.ALIGN_LEFT);
						StyledDocument doc =pay.getTextPane1().getStyledDocument();
						doc.setCharacterAttributes(105, doc.getLength() - 105, bSet, false);
						doc.setParagraphAttributes(0, 104, bSet, false);
						pay.getTextPane1().setStyledDocument(doc);
						pay.getTextPane1().setFont(new Font("宋体", Font.PLAIN, 48));
						pay.getTextPane1().setForeground(new Color(0, 0, 0));
						pay.getTextPane1().setEditable(true);
						pay.getTextPane1().setText("￥");
						pay.getTitle4().setText("确定");
						pay.getTextPane2().setBackground(new Color(240,240,240));
						pay.getTextPane2().setText("");
						Pay.getThread().stop();
					}
				});


			}
		});
	}

	public static void main(String[] args) {
		UnionPayForDeliver unionPay = new UnionPayForDeliver();
		unionPay.pay("1");
	}

}
