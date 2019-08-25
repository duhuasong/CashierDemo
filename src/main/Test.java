package main;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import NewUI.PayUI;
import core.AbstractUnionPay;
import core.UnionPayForDeliver;
import data.Dao;
import data.RetrunData;
import data.SimpleData;

public class Test {
	private static Logger log = LogManager.getLogger(Test.class);

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		PayUI pay = new PayUI();
		Dao dao = new Dao();
		AbstractUnionPay.setPay(pay);
		AbstractUnionPay.setDao(dao);
		UnionPayForDeliver unionPayForDeliver = new UnionPayForDeliver();
		SimpleData simpleData = new SimpleData();
		RetrunData.setDb(simpleData);
		pay.setUnionPay(unionPayForDeliver);
		pay.setVisible(true);
		AbstractUnionPay.setRetrunData(simpleData);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		frame.add(pay);
		pay.setFrame(frame);
		frame.setSize(370, 580);
		// 使窗体居在屏幕上居中显示 zw
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setExtendedState(1);
		frame.setVisible(true);
	}	

}
