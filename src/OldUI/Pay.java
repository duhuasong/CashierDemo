/*
 * Created by JFormDesigner on Thu Aug 15 22:26:11 CST 2019
 */

package OldUI;

import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import com.jgoodies.forms.factories.*;
import com.sun.corba.se.spi.orbutil.threadpool.ThreadPool;

import core.AbstractUnionPay;
import core.UnionPayForPack;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.jdesktop.swingx.*;

/**
 * @author dhs
 */
public class Pay extends JPanel {
	public JPanel getPanel5() {
		return panel5;
	}

	public void setPanel5(JPanel panel5) {
		this.panel5 = panel5;
	}



	public JPanel getPanel6() {
		return panel6;
	}

	public void setPanel6(JPanel panel6) {
		this.panel6 = panel6;
	}



	public JPanel getPanel8() {
		return panel8;
	}

	public void setPanel8(JPanel panel8) {
		this.panel8 = panel8;
	}


	public JPanel getPanel2() {
		return panel2;
	}

	public void setPanel2(JPanel panel2) {
		this.panel2 = panel2;
	}




	private static 	Logger log = LogManager.getLogger(Pay.class);
	// JFormDesigner - Variables declaration - DO NOT MODIFY
	// //GEN-BEGIN:variables
	private JPanel panel5;
	public JLabel getTip() {
		return tip;
	}

	public void setTip(JLabel tip) {
		this.tip = tip;
	}

	public JTextPane getTextOne() {
		return textOne;
	}

	public void setTextOne(JTextPane textOne) {
		this.textOne = textOne;
	}

	public JTextPane getTextTwo() {
		return textTwo;
	}

	public void setTextTwo(JTextPane textTwo) {
		this.textTwo = textTwo;
	}

	public JLabel getButtonOne() {
		return buttonOne;
	}

	public void setButtonOne(JLabel buttonOne) {
		this.buttonOne = buttonOne;
	}




	private JPanel panel2;
	private JLabel tip;
	private JTextPane textOne;
	private JTextPane textTwo;
	private JPanel panel6;
	private JLabel buttonOne;
	private JPanel panel8;
	// JFormDesigner - End of variables declaration //GEN-END:variables
	private AbstractUnionPay unionPay;
	private static Thread thread;

	public static Thread getThread() {
		return thread;
	}

	public static void setThread(Thread thread) {
		Pay.thread = thread;
	}

	public AbstractUnionPay getUnionPay() {
		return unionPay;
	}

	public void setUnionPay(AbstractUnionPay unionPay) {
		this.unionPay = unionPay;
	}

	public Pay() {
		initComponents();
	}

	private void panel6KeyPressed(KeyEvent e) {
		// TODO add your code here

	}

	private void title4KeyPressed(KeyEvent e) {
		// TODO add your code here
	}

	private void panel6MouseClicked(MouseEvent e) {
		// TODO add your code here
		log.debug("进入panel6MouseClicked");
		if (getButtonOne().getText() == "确定") {
			if (getTip().getText().trim() == "请扫描二维码") {
				//扫描二维码后操作
				AbstractUnionPay.getCachedThreadPool().execute(new Runnable() {
					public void run() {
						String[] ss =new String[]{ ".","..","..."};
						int num = 0;
						for (int i = 10; i >= 0; i--) {
							if (num == 3) {
								num = 0;
							}
							getTextOne().setFont(new Font("宋体", Font.PLAIN, 40));
							SimpleAttributeSet aSet = new SimpleAttributeSet();
							StyleConstants.setAlignment(aSet, StyleConstants.ALIGN_CENTER);
							StyledDocument doc = getTextOne().getStyledDocument();
							doc.setCharacterAttributes(105, doc.getLength() - 105, aSet, false);
							doc.setParagraphAttributes(0, 104, aSet, false);
							getTextOne().setStyledDocument(doc);
							getTextOne().setForeground(new Color(50, 205, 50));
							getTextOne().setEditable(true);
							getTextOne().setText("等待付款"+ss[num]);
							num++;
							getTextOne().setEditable(false);
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				});
				
				Lock lock = AbstractUnionPay.lock;
				synchronized (lock) {
					lock.notify();
				}	
			}else {
				final String amount = String.valueOf(getTextOne().getText()).substring(1);
				log.debug("String.valueOf(getTextOne().getText()).substring(1):"+amount + "\n");
				unionPay.pay(amount);				
			}

			

			/*
			AbstractUnionPay.getCachedThreadPool().execute(new Runnable() {
				public void run() {
					thread = Thread.currentThread();
					for (int i = 10; i >= 0; i--) {
						getTextPane1().setFont(new Font("宋体", Font.PLAIN, 40));
						SimpleAttributeSet aSet = new SimpleAttributeSet();
						StyleConstants.setAlignment(aSet, StyleConstants.ALIGN_CENTER);
						StyledDocument doc = getTextPane1().getStyledDocument();
						doc.setCharacterAttributes(105, doc.getLength() - 105, aSet, false);
						doc.setParagraphAttributes(0, 104, aSet, false);
						getTextPane1().setStyledDocument(doc);
						getTextPane1().setForeground(new Color(50, 205, 50));
						getTextPane1().setEditable(true);
						getTextPane1().setText("等待付款\n(" + i + "秒...)");
						getTextPane1().setEditable(false);
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					SimpleAttributeSet bSet = new SimpleAttributeSet();
					StyleConstants.setAlignment(bSet, StyleConstants.ALIGN_LEFT);
					StyledDocument doc = getTextPane1().getStyledDocument();
					doc.setCharacterAttributes(105, doc.getLength() - 105, bSet, false);
					doc.setParagraphAttributes(0, 104, bSet, false);
					getTextPane1().setStyledDocument(doc);
					getTextPane1().setFont(new Font("宋体", Font.PLAIN, 48));
					getTextPane1().setForeground(new Color(0, 0, 0));
					getTextPane1().setEditable(true);
					getTextPane1().setText("￥");
					getTextPane2().setBackground(new Color(240,240,240));
					getThread().stop();
				}
			});*/
		}else{
			SimpleAttributeSet bSet = new SimpleAttributeSet();
			StyleConstants.setAlignment(bSet, StyleConstants.ALIGN_LEFT);
			StyledDocument doc = getTextOne().getStyledDocument();
			doc.setCharacterAttributes(105, doc.getLength() - 105, bSet, false);
			doc.setParagraphAttributes(0, 104, bSet, false);
			getTextOne().setStyledDocument(doc);
			getTextOne().setFont(new Font("宋体", Font.PLAIN, 48));
			getTextOne().setForeground(new Color(0, 0, 0));
			getTextOne().setEditable(true);
			getTextOne().setText("￥");
			getButtonOne().setText("确定");
			getTextTwo().setBackground(new Color(240,240,240));
			getTextTwo().setText("");
			getThread().stop();
		}

	}

	private void buttonOneMouseClicked(MouseEvent e) {
		// TODO add your code here
		if (getButtonOne().getText() == "确定") {
			if (getTip().getText().trim() == "请扫描二维码") {
				//扫描二维码后操作
				AbstractUnionPay.getCachedThreadPool().execute(new Runnable() {
					public void run() {
						String[] ss =new String[]{ ".","..","..."};
						int num = 0;
						for (int i = 10; i >= 0; i--) {
							if (num == 3) {
								num = 0;
							}
							getTextOne().setFont(new Font("宋体", Font.PLAIN, 40));
							SimpleAttributeSet aSet = new SimpleAttributeSet();
							StyleConstants.setAlignment(aSet, StyleConstants.ALIGN_CENTER);
							StyledDocument doc = getTextOne().getStyledDocument();
							doc.setCharacterAttributes(105, doc.getLength() - 105, aSet, false);
							doc.setParagraphAttributes(0, 104, aSet, false);
							getTextOne().setStyledDocument(doc);
							getTextOne().setForeground(new Color(50, 205, 50));
							getTextOne().setEditable(true);
							getTextOne().setText("等待付款"+ss[num]);
							num++;
							getTextOne().setEditable(false);
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				});
				
				Lock lock = AbstractUnionPay.lock;
				synchronized (lock) {
					lock.notify();
				}
				
				
			}else {
				final String amount = String.valueOf(getTextOne().getText()).substring(1);
				log.debug("String.valueOf(getTextPane1().getText()).substring(1):"+amount + "\n");
				unionPay.pay(amount);				
			}
			/*
			AbstractUnionPay.getCachedThreadPool().execute(new Runnable() {
				public void run() {
					thread = Thread.currentThread();
					for (int i = 10; i >= 0; i--) {
						getTextPane1().setFont(new Font("宋体", Font.PLAIN, 40));
						SimpleAttributeSet aSet = new SimpleAttributeSet();
						StyleConstants.setAlignment(aSet, StyleConstants.ALIGN_CENTER);
						StyledDocument doc = getTextPane1().getStyledDocument();
						doc.setCharacterAttributes(105, doc.getLength() - 105, aSet, false);
						doc.setParagraphAttributes(0, 104, aSet, false);
						getTextPane1().setStyledDocument(doc);
						getTextPane1().setForeground(new Color(50, 205, 50));
						getTextPane1().setEditable(true);
						getTextPane1().setText("等待付款\n(" + i + "秒...)");
						getTextPane1().setEditable(false);
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					SimpleAttributeSet bSet = new SimpleAttributeSet();
					StyleConstants.setAlignment(bSet, StyleConstants.ALIGN_LEFT);
					StyledDocument doc = getTextPane1().getStyledDocument();
					doc.setCharacterAttributes(105, doc.getLength() - 105, bSet, false);
					doc.setParagraphAttributes(0, 104, bSet, false);
					getTextPane1().setStyledDocument(doc);
					getTextPane1().setFont(new Font("宋体", Font.PLAIN, 48));
					getTextPane1().setForeground(new Color(0, 0, 0));
					getTextPane1().setEditable(true);
					getTextPane1().setText("￥");
					getTextPane2().setBackground(new Color(240,240,240));
					getThread().stop();
				}
			});*/
			
		} else  {
			SimpleAttributeSet bSet = new SimpleAttributeSet();
			StyleConstants.setAlignment(bSet, StyleConstants.ALIGN_LEFT);
			StyledDocument doc = getTextOne().getStyledDocument();
			doc.setCharacterAttributes(105, doc.getLength() - 105, bSet, false);
			doc.setParagraphAttributes(0, 104, bSet, false);
			getTextOne().setStyledDocument(doc);
			getTextOne().setFont(new Font("宋体", Font.PLAIN, 48));
			getTextOne().setForeground(new Color(0, 0, 0));
			getTextOne().setEditable(true);
			getTextOne().setText("￥");
			getTextOne().setText("确定");
			getTextOne().setBackground(new Color(240,240,240));
			getTextOne().setText("");
			getThread().stop();
		}
	}

	private void createUIComponents() {
		// TODO: add custom component creation code here
	}


	private void textOneKeyPressed(KeyEvent e) {
		// TODO add your code here
		if (e.getKeyCode() == KeyEvent.VK_ENTER ) {
			if (! getTip().getText() .trim().equals("请扫描二维码")) {
					final String amount = String.valueOf(getTextOne().getText()).substring(1);
					log.debug("String.valueOf(getTextPane1().getText()).substring(1):"+amount + "\n");
					unionPay.pay(amount);
			}else {
				Lock lock = AbstractUnionPay.lock;
				synchronized (lock) {
					lock.notify();
				}				
			}
		}
	}

	private void title4MouseClicked(MouseEvent e) {
		// TODO add your code here
	}


	private void textPane1KeyPressed(KeyEvent e) {
		// TODO add your code here
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY
		// //GEN-BEGIN:initComponents
		DefaultComponentFactory compFactory = DefaultComponentFactory.getInstance();
		panel5 = new JPanel();
		panel2 = new JPanel();
		tip = compFactory.createTitle("\u6536\u6b3e\u91d1\u989d\uff1a");
		textOne = new JTextPane();
		textTwo = new JTextPane();
		panel6 = new JPanel();
		buttonOne = compFactory.createTitle("\u786e \u5b9a");
		panel8 = new JPanel();

		//======== this ========
		setPreferredSize(new Dimension(350, 580));
		setLayout(new VerticalLayout());

		//======== panel5 ========
		{
			panel5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 15));
		}
		add(panel5);

		//======== panel2 ========
		{
			panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 1, 4));

			//---- tip ----
			tip.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 26));
			tip.setHorizontalAlignment(SwingConstants.LEFT);
			tip.setVerticalTextPosition(SwingConstants.BOTTOM);
			tip.setOpaque(true);
			tip.setHorizontalTextPosition(SwingConstants.LEFT);
			tip.setPreferredSize(new Dimension(280, 50));
			tip.setText("\u6536\u6b3e\u91d1\u989d\uff1a    ");
			tip.setAlignmentY(0.0F);
			tip.setMinimumSize(new Dimension(20, 27));
			tip.setMaximumSize(new Dimension(300, 500));
			tip.setIconTextGap(0);
			panel2.add(tip);
		}
		add(panel2);

		//---- textOne ----
		textOne.setText("\uffe5 ");
		textOne.setPreferredSize(new Dimension(50, 100));
		textOne.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 54));
		textOne.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		textOne.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				textPane1KeyPressed(e);
				textOneKeyPressed(e);
			}
		});
		add(textOne);

		//---- textTwo ----
		textTwo.setPreferredSize(new Dimension(6, 70));
		textTwo.setBackground(new Color(240, 240, 240));
		add(textTwo);

		//======== panel6 ========
		{
			panel6.setBackground(new Color(51, 153, 255));
			panel6.setPreferredSize(new Dimension(350, 100));
			panel6.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					panel6KeyPressed(e);
					panel6KeyPressed(e);
				}
			});
			panel6.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					panel6MouseClicked(e);
				}
			});
			panel6.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 6));
			((FlowLayout)panel6.getLayout()).setAlignOnBaseline(true);

			//---- buttonOne ----
			buttonOne.setPreferredSize(new Dimension(150, 90));
			buttonOne.setMinimumSize(new Dimension(10, 20));
			buttonOne.setMaximumSize(new Dimension(300, 500));
			buttonOne.setText("\u786e \u5b9a");
			buttonOne.setHorizontalAlignment(SwingConstants.CENTER);
			buttonOne.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 50));
			buttonOne.setForeground(Color.white);
			buttonOne.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					title4KeyPressed(e);
				}
			});
			buttonOne.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					title4MouseClicked(e);
					buttonOneMouseClicked(e);
				}
			});
			panel6.add(buttonOne);
		}
		add(panel6);

		//======== panel8 ========
		{
			panel8.setBackground(new Color(250, 250, 250));
			panel8.setPreferredSize(new Dimension(10, 80));
			panel8.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 7));
		}
		add(panel8);
		// //GEN-END:initComponents
	}


}
