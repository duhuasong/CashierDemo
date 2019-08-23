package payUI;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import cashierUI.Cashier;
import core.AbstractUnionPay;
import core.UnionPayForDeliver;
import core.UnionPayForPack;
import data.RetrunData;
import data.SimpleData;
import sun.util.logging.resources.logging;

public class test {
	private static Logger log = LogManager.getLogger(test.class);
	public static void main(String[] args) {
		Frame frame = new Frame();
		Pay pay = new Pay();
		AbstractUnionPay.setPay(pay);
		UnionPayForDeliver unionPayForDeliver = new UnionPayForDeliver();
		SimpleData simpleData = new SimpleData();
		RetrunData.setDb(simpleData);
		pay.setUnionPay(unionPayForDeliver);
		AbstractUnionPay.setRetrunData(simpleData);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		frame.add(pay);
		frame.setSize(360, 600);
		//使窗体居在屏幕上居中显示 zw
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setExtendedState(1);
		frame.setVisible(true);
	}
}
