/*
 * Created by JFormDesigner on Sun Aug 25 14:12:36 CST 2019
 */

package NewUI;

import java.awt.*;
import javax.swing.*;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;
import org.jdesktop.swingx.*;

/**
 * @author dhs
 */
public class NewPay  {

	private void createUIComponents() {
		// TODO: add custom component creation code here
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		createUIComponents();

		PayUI = new JPanel();
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
		button2 = new JButton();
		panel3 = new JPanel();
		panel6 = new JPanel();
		label1 = new JLabel();
		separator1 = new JSeparator();
		tip = new JLabel();
		textOne = new JTextPane();
		textTwo = new JTextPane();

		//======== PayUI ========
		{
			PayUI.setPreferredSize(new Dimension(715, 580));
			PayUI.setMinimumSize(new Dimension(1, 1));
			PayUI.setLayout(new HorizontalLayout());

			//======== panel1 ========
			{
				panel1.setPreferredSize(new Dimension(350, 580));
				panel1.setLayout(new VerticalLayout());

				//======== panel5 ========
				{
					panel5.setBackground(new Color(102, 153, 255));
					panel5.setLayout(new VerticalLayout());

					//---- label2 ----
					label2.setText("\u5f53\u65e5\u6536\u6b3e\u8bb0\u5f55");
					label2.setPreferredSize(new Dimension(24, 80));
					label2.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1 Light", Font.PLAIN, 30));
					label2.setHorizontalTextPosition(SwingConstants.CENTER);
					label2.setHorizontalAlignment(SwingConstants.CENTER);
					label2.setBackground(new Color(102, 204, 255));
					panel5.add(label2);
				}
				panel1.add(panel5);

				//======== panel10 ========
				{
					panel10.setPreferredSize(new Dimension(0, 70));
					panel10.setLayout(new HorizontalLayout());

					//---- label4 ----
					label4.setText("\u6536\u6b3e\u65f6\u95f4");
					label4.setPreferredSize(new Dimension(116, 15));
					label4.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1 Light", Font.PLAIN, 26));
					label4.setHorizontalAlignment(SwingConstants.CENTER);
					panel10.add(label4);

					//---- label5 ----
					label5.setText("\u6536\u6b3e\u91d1\u989d");
					label5.setPreferredSize(new Dimension(117, 15));
					label5.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1 Light", Font.PLAIN, 26));
					label5.setHorizontalAlignment(SwingConstants.CENTER);
					panel10.add(label5);

					//---- label6 ----
					label6.setText("\u4ea4\u6613\u72b6\u6001");
					label6.setPreferredSize(new Dimension(116, 15));
					label6.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1 Light", Font.PLAIN, 26));
					label6.setHorizontalAlignment(SwingConstants.CENTER);
					panel10.add(label6);
				}
				panel1.add(panel10);

				//======== panel9 ========
				{
					panel9.setLayout(new FormLayout(
						"default",
						"4*(default, $lgap), default"));

					//---- textField2 ----
					textField2.setPreferredSize(new Dimension(6, 60));
					textField2.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1 Light", Font.PLAIN, 24));
					textField2.setText(" 22:32:18    \uffe510.00        \u6210\u529f");
					panel9.add(textField2, CC.xy(1, 1));

					//---- textField1 ----
					textField1.setPreferredSize(new Dimension(350, 60));
					textField1.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1 Light", Font.PLAIN, 24));
					textField1.setText(" 22:18:26    \uffe512.00        \u6210\u529f");
					panel9.add(textField1, CC.xy(1, 3));

					//---- textField3 ----
					textField3.setPreferredSize(new Dimension(6, 60));
					textField3.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1 Light", Font.PLAIN, 24));
					textField3.setText(" 21:42:56    \uffe58.00         \u6210\u529f");
					panel9.add(textField3, CC.xy(1, 5));

					//---- textField4 ----
					textField4.setPreferredSize(new Dimension(6, 60));
					textField4.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 24));
					panel9.add(textField4, CC.xy(1, 7));

					//---- textField5 ----
					textField5.setPreferredSize(new Dimension(6, 60));
					textField5.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 24));
					panel9.add(textField5, CC.xy(1, 9));
				}
				panel1.add(panel9);
			}
			PayUI.add(panel1);

			//======== panel2 ========
			{
				panel2.setPreferredSize(new Dimension(15, 580));
				panel2.setLayout(new VerticalLayout(-1));

				//---- button1 ----
				button1.setText("<<");
				button1.setPreferredSize(new Dimension(15, 290));
				button1.setMargin(new Insets(0, 0, 0, 0));
				button1.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 10));
				button1.setVerticalAlignment(SwingConstants.BOTTOM);
				panel2.add(button1);

				//---- button2 ----
				button2.setText(">>");
				button2.setPreferredSize(new Dimension(15, 290));
				button2.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 10));
				button2.setMargin(new Insets(0, 0, 0, 0));
				button2.setIconTextGap(0);
				button2.setVerticalAlignment(SwingConstants.TOP);
				panel2.add(button2);
			}
			PayUI.add(panel2);

			//======== panel3 ========
			{
				panel3.setPreferredSize(new Dimension(350, 580));
				panel3.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 22));
				panel3.setLayout(new VerticalLayout());

				//======== panel6 ========
				{
					panel6.setBackground(new Color(102, 153, 255));
					panel6.setLayout(new VerticalLayout());

					//---- label1 ----
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

				//---- tip ----
				tip.setText("\u6536\u6b3e\u91d1\u989d\uff1a");
				tip.setPreferredSize(new Dimension(24, 70));
				tip.setMaximumSize(new Dimension(10024, 100));
				tip.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1 Light", Font.PLAIN, 26));
				tip.setBackground(new Color(51, 51, 255));
				panel3.add(tip);

				//---- textOne ----
				textOne.setPreferredSize(new Dimension(6, 120));
				textOne.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 56));
				textOne.setText("\uffe5");
				textOne.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
				panel3.add(textOne);

				//---- textTwo ----
				textTwo.setPreferredSize(new Dimension(6, 120));
				textTwo.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 56));
				textTwo.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
				textTwo.setBackground(new Color(240, 240, 240));
				panel3.add(textTwo);

				//---- buttonOne ----
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
			PayUI.add(panel3);
		}
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	private JPanel PayUI;
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
	private JButton button2;
	private JPanel panel3;
	private JPanel panel6;
	private JLabel label1;
	private JSeparator separator1;
	private JLabel tip;
	private JTextPane textOne;
	private JTextPane textTwo;
	private JButton buttonOne;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
