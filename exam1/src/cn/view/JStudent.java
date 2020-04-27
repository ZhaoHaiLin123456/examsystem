package cn.view;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

import cn.bean.Student;
import cn.biz.TimeVerification;
import cn.dao.SerialDao;
import cn.model.ExamModel;
import cn.model.ResultModel;
import cn.model.ReviewModel;
import cn.model.SerialModel;
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
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JToolBar;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
/**
 * 学生端界面
 */
public class JStudent extends JFrame implements Runnable{

	private JPanel contentPane;
	private JTextField textField_6;
	private JTable table;
	private JTable table_1;
	private Student student;
	JButton btnNewButton;
	JButton button;
	ResultModel sm;
	SerialModel serialModel;
	String subjectName;
	String serialName;
	int subjectId,classesId,serialId;
	private boolean isStop = false;
	private JLabel label_3;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JStudent frame = new JStudent();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 * @param stu 
	 */
	public JStudent(Student stu) {
		setTitle("学生端");
		student = stu;
		setResizable(false);
		List<Student> ls=new ArrayList<Student>();
		sm=new ResultModel();
		sm.queryStudentResult(stu.getStudentId(), -1, -1, -1);//登陆进去只能看到学生自己的所有成绩
		serialModel=new SerialModel();
		serialModel.querySerialImformation(student.getStudentClassId());
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
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
		
		JDesktopPane desktopPane_1 = new JDesktopPane();
		tabbedPane.addTab("  进入考试  ", null, desktopPane_1, null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(14, 85, 751, 560);
		desktopPane_1.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label_1 = new JLabel("\u53EF\u53C2\u52A0\u7684\u8003\u8BD5\uFF1A");
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label_1.setBounds(14, 13, 110, 18);
		panel_1.add(label_1);
		
		table_1 = new JTable(serialModel);
		table_1.setFont(new Font("宋体", Font.PLAIN, 15));
		table_1.setBounds(24, 44, 713, 386);
		panel_1.add(table_1);
		
		JButton button_2 = new JButton("\u8FDB\u5165\u8003\u8BD5");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TimeVerification v = new TimeVerification();
				int rowIndex=table_1.getSelectedRow();
				if (rowIndex<0) {
					JOptionPane.showMessageDialog(button_2, "请选中表格中的一场考试，进入该场考试！");
				}else {
					int serialId=(int) serialModel.getValueAt(rowIndex, 0);
					String msg = v.validateTime(serialId); //场次
					System.out.println(serialId);
					System.out.println(msg);
					if (msg.indexOf("考试") == -1) {
						isStop = true;
						setVisible(false);
						ExamModel examModel = new ExamModel(stu.getStudentId(), serialId);
						examModel.setMessage(msg);
						examModel.doExam();	
					}else {
						JOptionPane.showMessageDialog(contentPane,msg);
					}
				}
				
			}
		});
		button_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		button_2.setBounds(576, 443, 161, 43);
		panel_1.add(button_2);
		
		JScrollPane scrollPane_1 = new JScrollPane(table_1);
		scrollPane_1.setBounds(24, 44, 713, 386);
		panel_1.add(scrollPane_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(14, 13, 250, 59);
		desktopPane_1.add(panel_2);
		panel_2.setBackground(Color.WHITE);
		
		JLabel label_2 = new JLabel("");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(11, 0, 59, 59);
		label_2.setIcon(new ImageIcon("image\\clock2.jpg"));
		
		label_3 = new JLabel();
		label_3.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label_3.setBounds(72, 0, 250, 59);
		panel_2.setLayout(null);
		panel_2.add(label_2);
		panel_2.add(label_3);
		
		JDesktopPane desktopPane_3 = new JDesktopPane();
		tabbedPane.addTab("  成绩查询  ", null, desktopPane_3, null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(SystemColor.controlHighlight);
		panel_4.setBounds(14, 13, 751, 633);
		desktopPane_3.add(panel_4);
		
		JLabel label_7 = new JLabel("\u6309\u5B66\u53F7\uFF1A");
		label_7.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label_7.setBounds(24, 44, 72, 27);
		panel_4.add(label_7);
		
		JLabel label_8 = new JLabel("\u9009\u62E9\u67E5\u8BE2\u6761\u4EF6\uFF1A");
		label_8.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label_8.setBounds(14, 13, 105, 18);
		panel_4.add(label_8);
		
		textField_6 = new JTextField();
		textField_6.setText(stu.getStudentId()+"");;
		textField_6.setFont(new Font("宋体", Font.PLAIN, 15));
		textField_6.setEnabled(false);
		textField_6.setBounds(86, 45, 142, 24);
		panel_4.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel label_9 = new JLabel("\u6309\u79D1\u76EE\uFF1A");
		label_9.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label_9.setBounds(242, 44, 72, 27);
		panel_4.add(label_9);
		
		JLabel label_10 = new JLabel("\u6309\u8003\u6B21\uFF1A");
		label_10.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label_10.setBounds(422, 44, 90, 27);
		panel_4.add(label_10);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setModel(new DefaultComboBoxModel(sm.queryStudentSubject()));
		comboBox_5.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		comboBox_5.setBounds(300, 45, 108, 24);
		
		
		panel_4.add(comboBox_5);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(sm.queryAllSerial()));
		comboBox_3.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		comboBox_3.setBounds(484, 45, 126, 24);
	
		
		panel_4.add(comboBox_3);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subjectName=(String) comboBox_5.getSelectedItem();
				System.out.println("科目"+subjectName);
				serialName=(String) comboBox_3.getSelectedItem();
				System.out.println("场次"+serialName);
				classesId=-1;
				if(subjectName==null) {
					subjectId=-1;
				}else {
					String [] sub = subjectName.split("-");
					subjectId = Integer.parseInt(sub[1]);
				}
				
				if(serialName==null) {
					serialId=-1;
				}else {
					String[] se = serialName.split("-");
					serialId = Integer.parseInt(se[1]);
				}
				System.out.println(subjectId);
				System.out.println(serialId);
				if (e.getSource()==btnNewButton) {
					System.out.println("点击该按钮");
					sm=new ResultModel();
					sm.queryStudentResult(student.getStudentId(), serialId, classesId, subjectId);
					table.setModel(sm);
					
				}
			}
		});
	
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		btnNewButton.setBounds(624, 44, 113, 27);
		panel_4.add(btnNewButton);
		
		
		table = new JTable(sm);
		
		table.setFont(new Font("宋体", Font.PLAIN, 15));
		table.setBounds(24, 84, 713, 497);
		panel_4.add(table);
		
		JButton button_1 = new JButton("\u67E5\u770B\u8BE6\u7EC6");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row=table.getSelectedRow();
				if (row<0) {
					JOptionPane.showMessageDialog(button_1, "请选中表格中的一条成绩，查看该场考试");
				}else {
					System.out.println(row);
					int col= (int) sm.getValueAt(row, 1);
					System.out.println(col);
					ReviewModel review = 
							new ReviewModel(stu.getStudentId(),col);
					review.doReview();
				}
			
			}
		});
		button_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		button_1.setBounds(624, 593, 113, 27);
		panel_4.add(button_1);
		
		JScrollPane scrollPane_2 = new JScrollPane(table);
		scrollPane_2.setBounds(24, 84, 713, 497);
		panel_4.add(scrollPane_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 13, 238, 697);
		desktopPane.add(scrollPane);
		
		JDesktopPane desktopPane_4 = new JDesktopPane();
		scrollPane.setViewportView(desktopPane_4);
		
		JTextPane txtpnnnn = new JTextPane();
		txtpnnnn.setFont(new Font("宋体", Font.PLAIN, 18));
		txtpnnnn.setEditable(false);
		txtpnnnn.setText("\r\n\r\n学号: " + stu.getStudentId() + "\r\n姓名: " + stu.getStudentName() + "\r\n性别: " + stu.getStudentSex() + "\r\n班级: " + stu.getStudentClassId());
		txtpnnnn.setBounds(14, 133, 208, 331);
		desktopPane_4.add(txtpnnnn);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("image\\小.jpg"));
		label.setBounds(14, 13, 208, 107);
		desktopPane_4.add(label);
		
		 button = new JButton("\u9000\u51FA\u7CFB\u7EDF");
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		button.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		button.setBounds(14, 655, 208, 27);
		desktopPane_4.add(button);
	}
	@Override
	public void run() {
		while(!isStop) {
			Date date = new Date();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
			String dateStr = simpleDateFormat.format(date);
			label_3.setText("当前系统时间:" + dateStr);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
		
	}
	
	

	
	
}

