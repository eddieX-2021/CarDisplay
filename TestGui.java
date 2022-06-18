import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.table.*;
public class TestGui {
	/**{
	 * 创建并显示GUI。出于线程安全的考虑，
	 * 这个方法在事件调用线程中调用。
	 */
	static int carNum = 0;
	private static void createAndShowGUI() {
		WaitingLine queue = new WaitingLine();
		// 确保一个漂亮的外观风格
		JFrame.setDefaultLookAndFeelDecorated(true);

		// 创建及设置窗口
		JFrame frame = new JFrame("车辆管理");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int y = frame.getHeight();
		int x = frame.getWidth();
		frame.setSize(x, y);
		//frame.setSize(1000,1000);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

		/////////////////////////////
		JPanel jp=new JPanel();    //创建面板
		// jp.setLayout(new GridLayout(2,2,5,5));

		JTextField newCarText=new JTextField(50);    //创建文本框
		newCarText.setText("在此添加信息");    //设置文本框的内容
		jp.add(newCarText);

		String[] name={"序号","车牌号","状态"};
		DefaultTableModel model = new DefaultTableModel(queue.getData(),name);
		JTable table=new JTable(model);
		JTableHeader head = table.getTableHeader(); // 创建表格标题对象
		head.setPreferredSize(new Dimension(head.getWidth(), 45));// 设置表头大小
		head.setFont(new Font("Menu.font", Font.PLAIN, 40));// 设置表格字体
		table.setRowHeight(35);
		table.setFont(new Font("Menu.font", Font.PLAIN, 40));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);// 以下设置表格列宽
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(300);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.setModel(model);

		// JScrollPane jSP = new JScrollPane(table);
		//table.setSize(1900, 1750);
		table.setPreferredScrollableViewportSize(new Dimension(924,900));
		table.setRowHeight(100);


		////////////////////////////
		ActionListener listener = new ActionListener () {
			public void actionPerformed (ActionEvent event) {
				queue.addCar(newCarText.getText());
				DefaultTableModel model = new DefaultTableModel(queue.getData(),name);
				table.setModel(model); 
				table.repaint();
				System.out.println(queue);
			}
		};
		/////////////////////////////

		JButton addCarBtn=new JButton("添加车辆");    //创建JButton对象
		addCarBtn.addActionListener(listener);
		jp.add(addCarBtn);
		carNum++;

		////////////////////////////
		ActionListener listener2 = new ActionListener () {
			public void actionPerformed (ActionEvent event) {
				queue.delCar();
				DefaultTableModel model = new DefaultTableModel(queue.getData(),name);
				table.setModel(model); 
				table.repaint();
				System.out.println(queue);
			}
		};
		/////////////////////////////

		JButton delCarBtn=new JButton("第一车辆完成");    //创建JButton对象
		delCarBtn.addActionListener(listener2);
		jp.add(delCarBtn);


		JScrollPane jSP = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jSP.setSize(2000, 1800);
		// jSP.setMinimumSize(2000,1800);
		jp.add(jSP);
		frame.add(jp);

		// 显示窗口
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		// 显示应用 GUI
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}
        