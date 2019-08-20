/*
 * Created by JFormDesigner on Thu Aug 15 22:26:11 CST 2019
 */

package payUI;

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
	private static 	Logger log = LogManager.getLogger(Pay.class);
	// JFormDesigner - Variables declaration - DO NOT MODIFY
	// //GEN-BEGIN:variables
	private JPanel panel1;
	public static Logger getLog() {
		return log;
	}

	public static void setLog(Logger log) {
		Pay.log = log;
	}

	public JPanel getPanel1() {
		return panel1;
	}

	public void setPanel1(JPanel panel1) {
		this.panel1 = panel1;
	}

	public JLabel getTitle1() {
		return title1;
	}

	public void setTitle1(JLabel title1) {
		this.title1 = title1;
	}

	public JPanel getPanel5() {
		return panel5;
	}

	public void setPanel5(JPanel panel5) {
		this.panel5 = panel5;
	}

	public JPanel getPanel2() {
		return panel2;
	}

	public void setPanel2(JPanel panel2) {
		this.panel2 = panel2;
	}

	public JLabel getTitle2() {
		return title2;
	}

	public void setTitle2(JLabel title2) {
		this.title2 = title2;
	}

	public JTextPane getTextPane2() {
		return textPane2;
	}

	public void setTextPane2(JTextPane textPane2) {
		this.textPane2 = textPane2;
	}

	public JScrollPane getScrollPane1() {
		return scrollPane1;
	}

	public void setScrollPane1(JScrollPane scrollPane1) {
		this.scrollPane1 = scrollPane1;
	}

	public JPanel getPanel4() {
		return panel4;
	}

	public void setPanel4(JPanel panel4) {
		this.panel4 = panel4;
	}

	public JPanel getPanel6() {
		return panel6;
	}

	public void setPanel6(JPanel panel6) {
		this.panel6 = panel6;
	}

	public JLabel getTitle4() {
		return title4;
	}

	public void setTitle4(JLabel title4) {
		this.title4 = title4;
	}

	public JPanel getPanel7() {
		return panel7;
	}

	public void setPanel7(JPanel panel7) {
		this.panel7 = panel7;
	}

	public JPanel getPanel8() {
		return panel8;
	}

	public void setPanel8(JPanel panel8) {
		this.panel8 = panel8;
	}

	public JLabel getTitle5() {
		return title5;
	}

	public void setTitle5(JLabel title5) {
		this.title5 = title5;
	}

	public JLabel getTitle6() {
		return title6;
	}

	public void setTitle6(JLabel title6) {
		this.title6 = title6;
	}

	private JLabel title1;
	private JPanel panel5;
	private JPanel panel2;
	private JLabel title2;
	private JTextPane textPane1;
	private JTextPane textPane2;
	private JScrollPane scrollPane1;
	private JPanel panel4;
	private JPanel panel6;
	private JLabel title4;
	private JPanel panel7;
	private JPanel panel8;
	private JLabel title5;
	private JLabel title6;
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
		System.out.print(getTextPane1().getText());
	}

	private void title4KeyPressed(KeyEvent e) {
		// TODO add your code here
		System.out.print(getTextPane1().getText());
	}

	private void panel6MouseClicked(MouseEvent e) {
		// TODO add your code here
		log.debug("进入panel6MouseClicked");
		if (getTitle4().getText() == "确定") {
			if (getTitle2().getText().trim() == "请扫描二维码") {
				//扫描二维码后操作
				AbstractUnionPay.getCachedThreadPool().execute(new Runnable() {
					public void run() {
						String[] ss =new String[]{ ".","..","..."};
						int num = 0;
						for (int i = 10; i >= 0; i--) {
							if (num == 3) {
								num = 0;
							}
							getTextPane1().setFont(new Font("宋体", Font.PLAIN, 40));
							SimpleAttributeSet aSet = new SimpleAttributeSet();
							StyleConstants.setAlignment(aSet, StyleConstants.ALIGN_CENTER);
							StyledDocument doc = getTextPane1().getStyledDocument();
							doc.setCharacterAttributes(105, doc.getLength() - 105, aSet, false);
							doc.setParagraphAttributes(0, 104, aSet, false);
							getTextPane1().setStyledDocument(doc);
							getTextPane1().setForeground(new Color(50, 205, 50));
							getTextPane1().setEditable(true);
							getTextPane1().setText("等待付款"+ss[num]);
							num++;
							getTextPane1().setEditable(false);
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
				final String amount = String.valueOf(getTextPane1().getText()).substring(1);
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
		}else{
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
			getTitle4().setText("确定");
			getTextPane2().setBackground(new Color(240,240,240));
			getTextPane2().setText("");
			getThread().stop();
		}

	}

	private void title4MouseClicked(MouseEvent e) {
		// TODO add your code here
		if (getTitle4().getText() == "确定") {
			if (getTitle2().getText().trim() == "请扫描二维码") {
				//扫描二维码后操作
				AbstractUnionPay.getCachedThreadPool().execute(new Runnable() {
					public void run() {
						String[] ss =new String[]{ ".","..","..."};
						int num = 0;
						for (int i = 10; i >= 0; i--) {
							if (num == 3) {
								num = 0;
							}
							getTextPane1().setFont(new Font("宋体", Font.PLAIN, 40));
							SimpleAttributeSet aSet = new SimpleAttributeSet();
							StyleConstants.setAlignment(aSet, StyleConstants.ALIGN_CENTER);
							StyledDocument doc = getTextPane1().getStyledDocument();
							doc.setCharacterAttributes(105, doc.getLength() - 105, aSet, false);
							doc.setParagraphAttributes(0, 104, aSet, false);
							getTextPane1().setStyledDocument(doc);
							getTextPane1().setForeground(new Color(50, 205, 50));
							getTextPane1().setEditable(true);
							getTextPane1().setText("等待付款"+ss[num]);
							num++;
							getTextPane1().setEditable(false);
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
				final String amount = String.valueOf(getTextPane1().getText()).substring(1);
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
			StyledDocument doc = getTextPane1().getStyledDocument();
			doc.setCharacterAttributes(105, doc.getLength() - 105, bSet, false);
			doc.setParagraphAttributes(0, 104, bSet, false);
			getTextPane1().setStyledDocument(doc);
			getTextPane1().setFont(new Font("宋体", Font.PLAIN, 48));
			getTextPane1().setForeground(new Color(0, 0, 0));
			getTextPane1().setEditable(true);
			getTextPane1().setText("￥");
			getTitle4().setText("确定");
			getTextPane2().setBackground(new Color(240,240,240));
			getTextPane2().setText("");
			getThread().stop();
		}
	}

	private void createUIComponents() {
		// TODO: add custom component creation code here
	}

	private void title5MouseClicked(MouseEvent e) {
		// TODO add your code here
		this.title5.setForeground(new Color(50, 205, 50));
		this.title6.setForeground(new Color(0, 0, 0));
	}

	private void title6MouseClicked(MouseEvent e) {
		// TODO add your code here
		this.title6.setForeground(new Color(50, 205, 50));
		this.title5.setForeground(new Color(0, 0, 0));
	}

	private void textPane1KeyPressed(KeyEvent e) {
		// TODO add your code here
		if (e.getKeyCode() == KeyEvent.VK_ENTER ) {
			if (! getTitle2().getText() .trim().equals("请扫描二维码")) {
					final String amount = String.valueOf(getTextPane1().getText()).substring(1);
					log.debug("String.valueOf(getTextPane1().getText()).substring(1):"+amount + "\n");
					unionPay.pay(amount);
			}else {
				//扫描二维码后操作
				AbstractUnionPay.getCachedThreadPool().execute(new Runnable() {
					public void run() {
						thread =Thread.currentThread();
						String[] ss =new String[]{ ".","..","..."};
						int num = 0;
						for (int i = 10; i >= 0; i--) {
							if (num == 3) {
								num = 0;
							}
							getTextPane1().setFont(new Font("宋体", Font.PLAIN, 40));
							SimpleAttributeSet aSet = new SimpleAttributeSet();
							StyleConstants.setAlignment(aSet, StyleConstants.ALIGN_CENTER);
							StyledDocument doc = getTextPane1().getStyledDocument();
							doc.setCharacterAttributes(105, doc.getLength() - 105, aSet, false);
							doc.setParagraphAttributes(0, 104, aSet, false);
							getTextPane1().setStyledDocument(doc);
							getTextPane1().setForeground(new Color(50, 205, 50));
							getTextPane1().setEditable(true);
							getTextPane1().setText("等待付款"+ss[num]);
							num++;
							getTextPane1().setEditable(false);
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
			}
		}
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY
		// //GEN-BEGIN:initComponents
		DefaultComponentFactory compFactory = DefaultComponentFactory.getInstance();
		panel1 = new JPanel();
		title1 = compFactory.createTitle("\u9996\u9875");
		panel5 = new JPanel();
		panel2 = new JPanel();
		title2 = compFactory.createTitle("\u6536\u6b3e\u91d1\u989d\uff1a                                       ");
		textPane1 = new JTextPane();
		textPane2 = new JTextPane();
		scrollPane1 = new JScrollPane();
		panel4 = new JPanel();
		panel6 = new JPanel();
		title4 = compFactory.createTitle("\u786e\u5b9a");
		panel7 = new JPanel();
		panel8 = new JPanel();
		title5 = compFactory.createTitle("\u9996\u9875");
		title6 = compFactory.createTitle("             \u6211\u7684");

		//======== this ========
		setPreferredSize(new Dimension(276, 777));
		setLayout(new VerticalLayout());

		//======== panel1 ========
		{
			panel1.setBackground(new Color(255, 11, 41));
			panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 7));
			((FlowLayout)panel1.getLayout()).setAlignOnBaseline(true);

			//---- title1 ----
			title1.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1 Light", Font.BOLD, 20));
			title1.setForeground(Color.white);
			title1.setBackground(new Color(51, 17, 199));
			panel1.add(title1);
		}
		add(panel1);

		//======== panel5 ========
		{
			panel5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 15));
		}
		add(panel5);

		//======== panel2 ========
		{
			panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 1, 4));

			//---- title2 ----
			title2.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1 Light", Font.PLAIN, 17));
			title2.setHorizontalAlignment(SwingConstants.LEFT);
			title2.setVerticalTextPosition(SwingConstants.BOTTOM);
			title2.setOpaque(true);
			title2.setHorizontalTextPosition(SwingConstants.RIGHT);
			title2.setVerticalAlignment(SwingConstants.BOTTOM);
			panel2.add(title2);
		}
		add(panel2);

		//---- textPane1 ----
		textPane1.setText("\uffe5 ");
		textPane1.setPreferredSize(new Dimension(50, 100));
		textPane1.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 48));
		textPane1.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		textPane1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				textPane1KeyPressed(e);
			}
		});
		add(textPane1);

		//---- textPane2 ----
		textPane2.setPreferredSize(new Dimension(6, 70));
		textPane2.setBackground(new Color(240, 240, 240));
		add(textPane2);
		add(scrollPane1);

		//======== panel4 ========
		{
			panel4.setRequestFocusEnabled(false);
			panel4.setLayout(new FlowLayout());
		}
		add(panel4);

		//======== panel6 ========
		{
			panel6.setBackground(new Color(255, 11, 41));
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

			//---- title4 ----
			title4.setForeground(Color.white);
			title4.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1 Light", Font.BOLD, 20));
			title4.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					title4KeyPressed(e);
				}
			});
			title4.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					title4MouseClicked(e);
				}
			});
			panel6.add(title4);
		}
		add(panel6);

		//======== panel7 ========
		{
			panel7.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 30));
		}
		add(panel7);

		//======== panel8 ========
		{
			panel8.setBackground(new Color(250, 250, 250));
			panel8.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 7));

			//---- title5 ----
			title5.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1 Light", Font.PLAIN, 20));
			title5.setHorizontalAlignment(SwingConstants.LEFT);
			title5.setVerticalAlignment(SwingConstants.TOP);
			title5.setHorizontalTextPosition(SwingConstants.LEFT);
			title5.setForeground(Color.cyan);
			title5.setPreferredSize(new Dimension(40, 33));
			title5.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					title5MouseClicked(e);
				}
			});
			panel8.add(title5);

			//---- title6 ----
			title6.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1 Light", Font.PLAIN, 20));
			title6.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					title6MouseClicked(e);
				}
			});
			panel8.add(title6);
		}
		add(panel8);
		// //GEN-END:initComponents
	}

	public JTextPane getTextPane1() {
		return textPane1;
	}

	public void setTextPane1(JTextPane textPane1) {
		this.textPane1 = textPane1;
	}

}
