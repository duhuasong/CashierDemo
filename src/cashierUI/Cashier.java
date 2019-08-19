/*
 * Created by JFormDesigner on Thu Aug 15 22:13:08 CST 2019
 */

package cashierUI;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import com.jgoodies.forms.factories.*;
import info.clearthought.layout.*;
import org.jdesktop.swingx.*;

/**
 * @author dhs
 */
public class Cashier  {
	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	private JFrame frame1;
	private JPanel panel2;
	private JPanel panel7;
	private JLabel title1;
	private JPanel panel3;
	private JLabel label1;
	private JPanel panel4;
	private JScrollPane scrollPane5;
	private JTextArea textArea2;
	private JPanel panel5;
	private JScrollPane scrollPane6;
	private JTextArea textArea3;
	private JButton button1;
	private JPanel panel6;
	private JButton button2;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
	public static void main(String[] args) {
				
    }

	public   void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		DefaultComponentFactory compFactory = DefaultComponentFactory.getInstance();
		frame1 = new JFrame();
		panel2 = new JPanel();
		panel7 = new JPanel();
		title1 = compFactory.createTitle("\u767b\u5f55");
		panel3 = new JPanel();
		label1 = compFactory.createLabel("");
		panel4 = new JPanel();
		scrollPane5 = new JScrollPane();
		textArea2 = new JTextArea();
		panel5 = new JPanel();
		scrollPane6 = new JScrollPane();
		textArea3 = new JTextArea();
		button1 = new JButton();
		panel6 = new JPanel();
		button2 = new JButton();

		//======== frame1 ========
		{
			frame1.setResizable(false);
			frame1.setForeground(new Color(0, 20, 230));
			Container frame1ContentPane = frame1.getContentPane();
			frame1ContentPane.setLayout(new TableLayout(new double[][] {
				{TableLayout.FILL},
				{TableLayout.FILL}}));

			//======== panel2 ========
			{
				panel2.setBorder(LineBorder.createBlackLineBorder());
				panel2.setLayout(new VerticalLayout());

				//======== panel7 ========
				{
					panel7.setBackground(new Color(63, 12, 222));
					panel7.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 7));

					//---- title1 ----
					title1.setForeground(Color.white);
					title1.setFont(new Font("\u4eff\u5b8b", Font.BOLD, 20));
					panel7.add(title1);
				}
				panel2.add(panel7);

				//======== panel3 ========
				{
					panel3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10));
					((FlowLayout)panel3.getLayout()).setAlignOnBaseline(true);

					//---- label1 ----
					label1.setIcon(new ImageIcon("C:\\Users\\dhs\\Desktop\\ti.jpg"));
					panel3.add(label1);
				}
				panel2.add(panel3);

				//======== panel4 ========
				{
					panel4.setLayout(new FlowLayout());
				}
				panel2.add(panel4);

				//======== scrollPane5 ========
				{

					//---- textArea2 ----
					textArea2.setText("\u8bf7\u8f93\u5165\u7528\u6237\u540d\uff08\u624b\u673a\u53f7\uff09");
					scrollPane5.setViewportView(textArea2);
				}
				panel2.add(scrollPane5);

				//======== panel5 ========
				{
					panel5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10));

					//======== scrollPane6 ========
					{

						//---- textArea3 ----
						textArea3.setRows(1);
						textArea3.setTabSize(1);
						textArea3.setPreferredSize(new Dimension(171, 24));
						textArea3.setText("\u9a8c\u8bc1\u7801");
						scrollPane6.setViewportView(textArea3);
					}
					panel5.add(scrollPane6);

					//---- button1 ----
					button1.setText("\u83b7\u53d6\u9a8c\u8bc1\u7801");
					button1.setMinimumSize(new Dimension(93, 24));
					button1.setMaximumSize(new Dimension(93, 24));
					button1.setPreferredSize(new Dimension(93, 25));
					button1.setSelected(true);
					panel5.add(button1);
				}
				panel2.add(panel5);

				//======== panel6 ========
				{
					panel6.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 50));
				}
				panel2.add(panel6);

				//---- button2 ----
				button2.setText("\u767b\u5f55");
				button2.setMaximumSize(new Dimension(57, 44));
				button2.setMinimumSize(new Dimension(57, 44));
				button2.setPreferredSize(new Dimension(57, 30));
				button2.setRequestFocusEnabled(false);
				button2.setFont(new Font("\u5e7c\u5706", Font.PLAIN, 16));
				button2.setBackground(Color.white);
				panel2.add(button2);
			}
			frame1ContentPane.add(panel2, new TableLayoutConstraints(0, 0, 0, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
			frame1.pack();
			frame1.setLocationRelativeTo(frame1.getOwner());
		}
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}
}
