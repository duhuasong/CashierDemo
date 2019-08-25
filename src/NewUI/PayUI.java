/*
 * Created by JFormDesigner on Sun Aug 25 14:06:14 CST 2019
 */

package NewUI;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.concurrent.locks.Lock;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import com.google.gson.Gson;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;

import OldUI.Pay;
import core.AbstractUnionPay;
import data.Dao;
import net.miginfocom.swing.*;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.jdesktop.swingx.*;

/**
 * @author dhs
 */
public class PayUI extends JPanel {
	public PayUI() {
		initComponents();
	}

	private void createUIComponents() {
		// TODO: add custom component creation code here
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY
	// //GEN-BEGIN:variables
	private JPanel panel1;
	private JPanel panel5;
	private JLabel label2;
	private JPanel panel10;
	private JLabel label4;
	private JLabel label5;
	private JLabel label6;
	private JPanel panel9;
	private JTextField textField2;
	private JTextField textField1;
	private JTextField textField3;
	private JTextField textField4;
	private JTextField textField5;
	private JPanel panel2;
	private JButton button1;
	private JPanel panel3;
	private JPanel panel6;
	private JLabel label1;
	private JSeparator separator1;
	private JLabel tip;
	private JTextPane textOne;
	private JTextPane textTwo;
	private JButton buttonOne;
	// JFormDesigner - End of variables declaration //GEN-END:variables
	private AbstractUnionPay unionPay;
	private static JFrame frame;
	private Dao dao;

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

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

	public JButton getButtonOne() {
		return buttonOne;
	}

	public void setButtonOne(JButton buttonOne) {
		this.buttonOne = buttonOne;
	}

	public AbstractUnionPay getUnionPay() {
		return unionPay;
	}

	public void setUnionPay(AbstractUnionPay unionPay) {
		this.unionPay = unionPay;
	}

	public static Thread getThread() {
		return thread;
	}

	public static void setThread(Thread thread) {
		PayUI.thread = thread;
	}

	private static Logger log = LogManager.getLogger(PayUI.class);
	private static Thread thread;

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY
		// //GEN-BEGIN:initComponents
		createUIComponents();

		panel1 = new JPanel();
		panel5 = new JPanel();
		label2 = new JLabel();
		panel10 = new JPanel();
		label4 = new JLabel();
		label5 = new JLabel();
		label6 = new JLabel();
		panel9 = new JPanel();
		textField2 = new JTextField();
		textField1 = new JTextField();
		textField3 = new JTextField();
		textField4 = new JTextField();
		textField5 = new JTextField();
		panel2 = new JPanel();
		button1 = new JButton();
		buttonOne = new JButton();
		panel3 = new JPanel();
		panel6 = new JPanel();
		label1 = new JLabel();
		separator1 = new JSeparator();
		tip = new JLabel();
		textOne = new JTextPane();
		textTwo = new JTextPane();
		// ======== PayUI ========
		{
			this.setPreferredSize(new Dimension(715, 580));
			this.setMinimumSize(new Dimension(1, 1));
			this.setLayout(new HorizontalLayout());

			// ======== panel1 ========
			{
				panel1.setPreferredSize(new Dimension(350, 580));
				panel1.setLayout(new VerticalLayout());

				// ======== panel5 ========
				{
					panel5.setBackground(new Color(102, 153, 255));
					panel5.setLayout(new VerticalLayout());

					// ---- label2 ----
					label2.setText("\u5f53\u65e5\u6536\u6b3e\u8bb0\u5f55");
					label2.setPreferredSize(new Dimension(24, 80));
					label2.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1 Light", Font.PLAIN, 30));
					label2.setHorizontalTextPosition(SwingConstants.CENTER);
					label2.setHorizontalAlignment(SwingConstants.CENTER);
					label2.setBackground(new Color(102, 204, 255));
					panel5.add(label2);
				}
				panel1.add(panel5);

				// ======== panel10 ========
				{
					panel10.setPreferredSize(new Dimension(0, 70));
					panel10.setLayout(new HorizontalLayout());

					// ---- label4 ----
					label4.setText("\u6536\u6b3e\u65f6\u95f4");
					label4.setPreferredSize(new Dimension(116, 15));
					label4.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1 Light", Font.PLAIN, 26));
					label4.setHorizontalAlignment(SwingConstants.CENTER);
					panel10.add(label4);

					// ---- label5 ----
					label5.setText("\u6536\u6b3e\u91d1\u989d");
					label5.setPreferredSize(new Dimension(117, 15));
					label5.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1 Light", Font.PLAIN, 26));
					label5.setHorizontalAlignment(SwingConstants.CENTER);
					panel10.add(label5);

					// ---- label6 ----
					label6.setText("\u4ea4\u6613\u72b6\u6001");
					label6.setPreferredSize(new Dimension(116, 15));
					label6.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1 Light", Font.PLAIN, 26));
					label6.setHorizontalAlignment(SwingConstants.CENTER);
					panel10.add(label6);
				}
				panel1.add(panel10);

				// ======== panel9 ========
				{
					panel9.setLayout(new FormLayout("default", "4*(default, $lgap), default"));

					// ---- textField2 ----
					textField2.setPreferredSize(new Dimension(6, 60));
					textField2.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1 Light", Font.PLAIN, 15));
					textField2.setText("");
					panel9.add(textField2, CC.xy(1, 1));

					// ---- textField1 ----
					textField1.setPreferredSize(new Dimension(350, 60));
					textField1.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1 Light", Font.PLAIN, 15));
					textField1.setText("");
					panel9.add(textField1, CC.xy(1, 3));

					// ---- textField3 ----
					textField3.setPreferredSize(new Dimension(6, 60));
					textField3.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1 Light", Font.PLAIN, 15));
					textField3.setText("");
					panel9.add(textField3, CC.xy(1, 5));

					// ---- textField4 ----
					textField4.setPreferredSize(new Dimension(6, 60));
					textField4.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 15));
					panel9.add(textField4, CC.xy(1, 7));

					// ---- textField5 ----
					textField5.setPreferredSize(new Dimension(6, 60));
					textField5.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 15));
					panel9.add(textField5, CC.xy(1, 9));
				}
				panel1.add(panel9);
			}
			this.add(panel1);

			// ======== panel2 ========
			{
				panel2.setPreferredSize(new Dimension(20, 580));
				panel2.setLayout(new VerticalLayout(-1));

				// ---- button1 ----
				button1.setText("<<");
				button1.setPreferredSize(new Dimension(15, 590));
				button1.setMargin(new Insets(0, 0, 0, 0));
				button1.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 10));
				button1.setVerticalAlignment(SwingConstants.CENTER);
				panel2.add(button1);

				/*
				 * //---- button2 ---- button2.setText(">>");
				 * button2.setPreferredSize(new Dimension(15, 290));
				 * button2.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 10));
				 * button2.setMargin(new Insets(0, 0, 0, 0));
				 * button2.setIconTextGap(0);
				 * button2.setVerticalAlignment(SwingConstants.TOP);
				 * panel2.add(button2);
				 */
			}
			this.add(panel2);

			// ======== panel3 ========
			{
				panel3.setPreferredSize(new Dimension(350, 580));
				panel3.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 22));
				panel3.setLayout(new VerticalLayout());

				// ======== panel6 ========
				{
					panel6.setBackground(new Color(102, 153, 255));
					panel6.setLayout(new VerticalLayout());

					// ---- label1 ----
					label1.setText("\u6536\u94f6\u52a9\u624b");
					label1.setPreferredSize(new Dimension(24, 80));
					label1.setBackground(new Color(153, 255, 255));
					label1.setMinimumSize(new Dimension(20, 15));
					label1.setMaximumSize(new Dimension(60, 100));
					label1.setHorizontalAlignment(SwingConstants.CENTER);
					label1.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1 Light", Font.PLAIN, 30));
					panel6.add(label1);
				}
				panel3.add(panel6);
				panel3.add(separator1);

				// ---- tip ----
				tip.setText("\u6536\u6b3e\u91d1\u989d\uff1a");
				tip.setPreferredSize(new Dimension(24, 70));
				tip.setMaximumSize(new Dimension(10024, 100));
				tip.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1 Light", Font.PLAIN, 26));
				tip.setBackground(new Color(51, 51, 255));
				panel3.add(tip);

				// ---- textOne ----
				textOne.setPreferredSize(new Dimension(6, 120));
				textOne.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 56));
				textOne.setText("\uffe5");
				textOne.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
				panel3.add(textOne);

				// ---- textTwo ----
				textTwo.setPreferredSize(new Dimension(6, 120));
				textTwo.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 56));
				textTwo.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
				textTwo.setBackground(new Color(240, 240, 240));
				panel3.add(textTwo);

				// ---- buttonOne ----
				buttonOne.setText("\u786e \u5b9a");
				buttonOne.setPreferredSize(new Dimension(57, 80));
				buttonOne.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1 Light", Font.PLAIN, 56));
				buttonOne.setBorderPainted(false);
				buttonOne.setMinimumSize(new Dimension(10, 73));
				buttonOne.setMaximumSize(new Dimension(173, 190));
				buttonOne.setBackground(UIManager.getColor("Button.background"));
				buttonOne.setMargin(new Insets(0, 0, 0, 0));
				buttonOne.setHorizontalTextPosition(SwingConstants.CENTER);
				buttonOne.setForeground(new Color(102, 153, 255));
				panel3.add(buttonOne);
			}
			this.add(panel3);
		}
		// JFormDesigner - End of component initialization
		// //GEN-END:initComponents
		textOne.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				textOneKeyPressed(e);
			}
		});
		buttonOne.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				buttonOneMouseClicked(e);
			}
		});
		button1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				button1MouseClicked(e);
			}
		});

		textField1.setEditable(false);
		textField2.setEditable(false);
		textField3.setEditable(false);
		textField4.setEditable(false);
		textField5.setEditable(false);
		panel1.setVisible(false);
		textOne.setFocusable(true);
		textOne.grabFocus();
		textOne.requestFocus(true);
	}

	private void button1MouseClicked(MouseEvent e) {
		if (button1.getText().trim().equals("<<")) {
			panel1.setVisible(true);
			button1.setText(">>");
			frame.setSize(715, 580);
			Dao.connect("tr");
			if (dao == null) {
				dao = new Dao();
			}

			List<String[]> list = dao.select();
			log.debug("List<String[]> list" + new Gson().toJson(list));
			String[] strings = null;
			textField1.setEditable(true);
			textField2.setEditable(true);
			textField3.setEditable(true);
			textField4.setEditable(true);
			textField5.setEditable(true);
			log.debug("List<String[]> list.size" + list.size());
			switch (list.size()) {
			case 1:
				strings = list.remove(0);
				textField2.setText(strings[1] + "       " + strings[3] + "              " + strings[4]);				
				break;
			case 2:
				strings = list.remove(0);
				textField2.setText(strings[1] + "       " + strings[3] + "              " + strings[4]);
				strings = list.remove(0);
				textField1.setText(strings[1] + "       " + strings[3] + "              " + strings[4]);
				break;
			case 3:
				strings = list.remove(0);  
				textField2.setText(strings[1] + "       " + strings[3] + "              " + strings[4]);					
				strings = list.remove(0);
				textField1.setText(strings[1] + "       " + strings[3] + "              " + strings[4]);
				strings = list.remove(0);
				textField3.setText(strings[1] + "       " + strings[3] + "              " + strings[4]);
				break;
			case 4:
				strings = list.remove(0);
				textField2.setText(strings[1] + "       " + strings[3] + "              " + strings[4]);					
				strings = list.remove(0);
				textField1.setText(strings[1] + "       " + strings[3] + "              " + strings[4]);
				strings = list.remove(0);
				textField3.setText(strings[1] + "       " + strings[3] + "              " + strings[4]);
				strings = list.remove(0);
				textField4.setText(strings[1] + "       " + strings[3] + "              " + strings[4]);				
				break;
			case 5:
				strings = list.remove(0);
				textField2.setText(strings[1] + "       " + strings[3] + "              " + strings[4]);				
				strings = list.remove(0); 
				textField1.setText(strings[1] + "       " + strings[3] + "              " + strings[4]);
				strings = list.remove(0);
				textField3.setText(strings[1] + "       " + strings[3] + "              " + strings[4]);
				strings = list.remove(0);
				textField4.setText(strings[1] + "       " + strings[3] + "              " + strings[4]);
				strings = list.remove(0);
				textField5.setText(strings[1] + "       " + strings[3] + "              " + strings[4]);
				break;
			default:
				break;
			}
			textField1.setEditable(false);
			textField2.setEditable(false);
			textField3.setEditable(false);
			textField4.setEditable(false);
			textField5.setEditable(false);
		} else {
			panel1.setVisible(false);
			button1.setText("<<");
			frame.setSize(375, 580);
		}

	}

	private void buttonOneMouseClicked(MouseEvent e) {
		// TODO add your code here
		log.debug("进入buttonOneMouseClicked");
		log.debug("getButtonOne().getText() ：" + getButtonOne().getText());
		/*
		 * if (getButtonOne().getText() .trim()== "确定") { if
		 * (getTip().getText().trim() == "请扫描二维码") { //扫描二维码后操作
		 * log.debug("进入扫描二维码后操作");
		 * AbstractUnionPay.getCachedThreadPool().execute(new Runnable() {
		 * public void run() { String[] ss =new String[]{ ".","..","..."}; int
		 * num = 0; for (int i = 10; i >= 0; i--) { if (num == 3) { num = 0; }
		 * getTextOne().setFont(new Font("微软雅黑light", Font.PLAIN, 40));
		 * SimpleAttributeSet aSet = new SimpleAttributeSet();
		 * StyleConstants.setAlignment(aSet, StyleConstants.ALIGN_CENTER);
		 * StyledDocument doc = getTextOne().getStyledDocument();
		 * doc.setCharacterAttributes(105, doc.getLength() - 105, aSet, false);
		 * doc.setParagraphAttributes(0, 104, aSet, false);
		 * getTextOne().setStyledDocument(doc); getTextOne().setForeground(new
		 * Color(50, 205, 50)); getTextOne().setEditable(true);
		 * getTextOne().setText("等待付款"+ss[num]); num++;
		 * getTextOne().setEditable(false); try { Thread.sleep(1000); } catch
		 * (InterruptedException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } } } });
		 * 
		 * Lock lock = AbstractUnionPay.lock; synchronized (lock) {
		 * lock.notify(); } }else { final String amount =
		 * String.valueOf(getTextOne().getText()).substring(1);
		 * log.debug("String.valueOf(getTextOne().getText()).substring(1):"+
		 * amount + "\n"); unionPay.pay(amount); } }else{ SimpleAttributeSet
		 * bSet = new SimpleAttributeSet(); StyleConstants.setAlignment(bSet,
		 * StyleConstants.ALIGN_LEFT); StyledDocument doc =
		 * getTextOne().getStyledDocument(); doc.setCharacterAttributes(105,
		 * doc.getLength() - 105, bSet, false); doc.setParagraphAttributes(0,
		 * 104, bSet, false); getTextOne().setStyledDocument(doc);
		 * getTextOne().setFont(new Font("微软雅黑light", Font.PLAIN, 48));
		 * getTextOne().setForeground(new Color(0, 0, 0));
		 * getTextOne().setEditable(true); getTextOne().setText("￥");
		 * getButtonOne().setText("确定"); getTextTwo().setBackground(new
		 * Color(240,240,240)); getTextTwo().setText(""); getThread().stop(); }
		 */
		if (!getTip().getText().trim().equals("请扫描二维码")) {
			final String amount = String.valueOf(getTextOne().getText()).substring(1);
			log.debug("String.valueOf(getTextPane1().getText()).substring(1):" + amount + "\n");
			unionPay.pay(amount);
		} else {
			Lock lock = AbstractUnionPay.lock;
			synchronized (lock) {
				lock.notify();
			}
		}

	}

	private void textOneKeyPressed(KeyEvent e) {
		// TODO add your code here
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (!getTip().getText().trim().equals("请扫描二维码:")) {
				final String amount = String.valueOf(getTextOne().getText()).substring(1);
				log.debug("String.valueOf(getTextPane1().getText()).substring(1):" + amount + "\n");
				unionPay.pay(amount);
			} else {
				Lock lock = AbstractUnionPay.lock;
				synchronized (lock) {
					lock.notify();
				}
			}
		}
	}
}
