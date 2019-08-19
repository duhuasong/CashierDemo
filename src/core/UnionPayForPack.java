package core;

import java.util.concurrent.ExecutionException;

import untill.KeyIntMap;

public class UnionPayForPack extends AbstractUnionPay {
	// 授权码使用主动填充策略
	private static KeyIntMap keyIntMap = new KeyIntMap();
	private String re = null;

	public String getRe() {
		return re;
	}

	public void setRe(String re) {
		this.re = re;
	}

	public void pay(final String amount) {
		// 此处轮询判断银行卡二维码硬件状态，后续补充银行卡状态
		unionPay();
		uThreadLocal.get().setHasValue(0);// 清零
		final String tmps = uThreadLocal.get().getTmp();
		new Thread(new Runnable() {
			public void run() {
				String string = null;
				try {
					while (string == null) {
						string = futureTaskThreadLocal.get().get();
						System.out.print("string:"+string);
					}
					System.out.print("stringout:"+string);
					Thread.sleep(2000);
					re =  AbstractUnionPay.getCallDll().pay(amount, "1", "2");// 此处写死，后续补充
				} catch (InterruptedException | ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.print(" futureTaskThreadLocal.get().get()");
				}
				keyIntMap.key(tmps);
			}
		}).start();
	}

/*	public static void main(String[] args) {
		UnionPayForPack unionPay = new UnionPayForPack();
		 unionPay.pay("1");
		//System.out.print(string);
	}*/

}
