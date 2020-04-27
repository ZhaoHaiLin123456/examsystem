package cn.view;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.StyleContext.SmallAttributeSet;

import cn.bean.Manager;
import cn.model.ResultModel;
import cn.model.StudentModel;
import cn.model.TeacherModel;

import javax.swing.JDesktopPane;
import javax.swing.JTabbedPane;
import javax.swing.JSplitPane;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLayeredPane;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JSeparator;
import javax.swing.JProgressBar;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * 管理员界面
 */
public class JManager extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	Manager manager;
	TeacherModel tModel;
	StudentModel sModel;
	String className,subjectName;
	int classId,subjectId;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JManager frame = new JManager();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame
	 */
	public JManager(Manager  mar) {
		setTitle("管理员端");
		manager=mar;
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1080, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JDesktopPane desktopPane = new JDesktopPane();
		contentPane.add(desktopPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		tabbedPane.setBounds(266, 13, 784, 697);
		desktopPane.add(tabbedPane);
		
		JDesktopPane desktopPane_2 = new JDesktopPane();
		tabbedPane.addTab("  学生信息  ", null, desktopPane_2, null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(SystemColor.controlHighlight);
		panel_2.setBounds(14, 13, 751, 633);
		desktopPane_2.add(panel_2);
		
		JLabel label_11 = new JLabel("\u6309\u73ED\u7EA7\u7B5B\u9009\uFF1A");
		label_11.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label_11.setBounds(14, 13, 105, 18);
		panel_2.add(label_11);
		
		JButton button_1 = new JButton("\u4FEE\u6539\u5BC6\u7801");
		button_1.addActionListener(new ActionListener() {//教师的监听器按钮
			public void actionPerformed(ActionEvent e) {
				System.out.println("修改密码");
				int rows= table.getSelectedRow();
				System.out.println(rows);
				if (rows>=0) {
					//tModel=null;
					//sModel=new StudentModel();
					JUpdatePwd pwd=new JUpdatePwd(sModel, rows);
					pwd.setVisible(true);
				}
				else {
					//panel_2
					JOptionPane.showMessageDialog(button_1, "请选择一行");
					return ;
				}
			}
		});
		button_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		button_1.setBounds(624, 593, 113, 27);
		panel_2.add(button_1);
		
		sModel=new StudentModel();
		sModel.queryStudentImformation(1);
		table = new JTable(sModel);
	
		table.setFont(new Font("宋体", Font.PLAIN, 15));
		table.setBounds(24, 50, 713, 530);
		panel_2.add(table);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(sModel.queryAllClass()));
		comboBox.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		comboBox.setBounds(109, 10, 128, 24);
		panel_2.add(comboBox);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				className=(String) comboBox.getSelectedItem();
				String[] cn=className.split("-");
				classId=Integer.parseInt(cn[1]);
				if (e.getSource()==btnNewButton) {
					System.out.println("点击该按钮");
					sModel=new StudentModel();
					sModel.queryStudentImformation(classId);
					table.setModel(sModel);
					
				}
			}
		});
		btnNewButton.setBounds(624, 10, 113, 27);
		panel_2.add(btnNewButton);
		
		JScrollPane scrollPane_1 = new JScrollPane(table);
		scrollPane_1.setBounds(24, 50, 713, 530);
		panel_2.add(scrollPane_1);
		
		JDesktopPane desktopPane_1 = new JDesktopPane();
		tabbedPane.addTab("  教师信息  ", null, desktopPane_1, null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(SystemColor.controlHighlight);
		panel.setBounds(14, 13, 751, 633);
		desktopPane_1.add(panel);
		
		JLabel label_1 = new JLabel("\u6309\u79D1\u76EE\u7B5B\u9009\uFF1A");
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label_1.setBounds(14, 13, 105, 18);
		panel.add(label_1);
		
		JButton button_2 = new JButton("\u4FEE\u6539\u5BC6\u7801");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rows= table_1.getSelectedRow();
				System.out.println(rows);
				if (rows>=0) {
//					sModel=null;
//					tModel=new TeacherModel();
					JUpdatePwd pwd=new JUpdatePwd(tModel, rows);
					if (tModel.getClass() == TeacherModel.class) {
						
					}
					pwd.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(button_2, "请选择一行");
					return ;
				}
			}
		});
		button_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		button_2.setBounds(624, 593, 113, 27);
		panel.add(button_2);
		
		tModel=new TeacherModel();
		tModel.queryTeacherImformation(1);
		table_1 = new JTable(tModel);
		table_1.setFont(new Font("宋体", Font.PLAIN, 15));
		table_1.setBounds(24, 50, 713, 530);
		panel.add(table_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(tModel.queryAllSubject()));
		comboBox_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		comboBox_1.setBounds(109, 10, 128, 24);
		panel.add(comboBox_1);
		
		JButton btnNewButton_1 = new JButton("\u67E5\u8BE2");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subjectName=(String) comboBox_1.getSelectedItem();
				String[] sn=subjectName.split("-");
				subjectId=Integer.parseInt(sn[1]);
				if (e.getSource()==btnNewButton_1) {
					System.out.println("点击该按钮");
					tModel=new TeacherModel();
					tModel.queryTeacherImformation(subjectId);
					table_1.setModel(tModel);
					
				}
			}
		});
		btnNewButton_1.setBounds(624, 10, 113, 27);
		panel.add(btnNewButton_1);
		
		JScrollPane scrollPane_2 = new JScrollPane(table_1);
		scrollPane_2.setBounds(24, 50, 713, 530);
		panel.add(scrollPane_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 13, 238, 697);
		desktopPane.add(scrollPane);
		
		JDesktopPane desktopPane_4 = new JDesktopPane();
		scrollPane.setViewportView(desktopPane_4);
		
		JTextPane txtpnnnn = new JTextPane();
		txtpnnnn.setFont(new Font("宋体", Font.PLAIN, 18));
		txtpnnnn.setEditable(false);
		txtpnnnn.setText("\r\n\r\n"+"管理员工号:"+mar.getManagerId()+"\r\n\r\n"+"管理员姓名："+mar.getManagerName());
		txtpnnnn.setBounds(14, 133, 208, 331);
		desktopPane_4.add(txtpnnnn);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("image\\小.jpg"));
		label.setBounds(14, 13, 208, 107);
		desktopPane_4.add(label);
		
		JButton button = new JButton("\u9000\u51FA\u7CFB\u7EDF");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		button.setBounds(14, 655, 208, 27);
		desktopPane_4.add(button);
	}
}
