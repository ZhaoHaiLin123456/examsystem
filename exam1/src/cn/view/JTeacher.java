package cn.view;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.bean.Serial;
import cn.bean.Student;
import cn.bean.Teacher;
import cn.biz.AutoImportQuestion;
import cn.biz.ManuImportQuestion;
import cn.dao.ClassesDao;
import cn.dao.SerialDao;
import cn.dao.impl.SerialDaoImpl;
import cn.model.QuestionModel;
import cn.model.ResultModel;
import cn.model.ReviewModel;
import cn.model.SerialModel;

import javax.swing.JDesktopPane;
import javax.swing.JTabbedPane;
import javax.swing.JSplitPane;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;

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
import javax.swing.JFileChooser;
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
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
/**
 * 教师端界面
 */
public class JTeacher extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_6;
	private JTextField textField_9;
	private JTable table_1;
	private JTable table;
	private JTable table_2;
	private JCheckBox chckbxD;
	private JCheckBox chckbxC;
	private JCheckBox chckbxB;
	private JCheckBox chckbxA;
	
	
	Teacher teacher;
	ResultModel sm;
	String subjectName;
	String classesName;
	String serialName;
	int subjectId,classesId,serialId;
	SerialModel serialModel;
	QuestionModel questionModel;
	JComboBox comboBox_4;
	File file;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JTeacher frame = new JTeacher();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public JTeacher(Teacher tea) {
		setTitle("教师端");
		serialModel=new SerialModel();
//		questionModel=new QuestionModel();
//		questionModel.queryQuestionImformation(aq);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1080, 768);
		teacher=tea;
		List<Student> ls=new ArrayList<Student>();
		sm=new ResultModel();
		sm.queryStudentResult(-1, -1, -1, teacher.getSubjectId());
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
		tabbedPane.addTab("  题目录入  ", null, desktopPane_1, null);
		
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("TabbedPane.light"));
		panel.setBounds(14, 44, 751, 154);
		desktopPane_1.add(panel);
		panel.setLayout(null);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		tabbedPane_1.setBounds(14, 13, 723, 128);
		panel.add(tabbedPane_1);
		
		JDesktopPane desktopPane_5 = new JDesktopPane();
		tabbedPane_1.addTab("判断题录入", null, desktopPane_5, null);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("宋体", Font.PLAIN, 15));
		textField_1.setText("\u5728\u6B64\u8F93\u5165\u9898\u76EE");
		textField_1.setBounds(14, 13, 430, 70);
		desktopPane_5.add(textField_1);
		textField_1.setColumns(10);
		
		JRadioButton radioButton = new JRadioButton("\u6B63\u786E");
		radioButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		radioButton.setBounds(454, 13, 59, 27);
		desktopPane_5.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("");
		radioButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		radioButton_1.setEnabled(false);
		radioButton_1.setBounds(649, 13, 59, 27);
		desktopPane_5.add(radioButton_1);
		
		JRadioButton radioButton_2 = new JRadioButton("");
		radioButton_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		radioButton_2.setEnabled(false);
		radioButton_2.setBounds(584, 13, 59, 27);
		desktopPane_5.add(radioButton_2);
		
		JRadioButton radioButton_3 = new JRadioButton("\u9519\u8BEF");
		radioButton_3.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		radioButton_3.setBounds(519, 13, 59, 27);
		desktopPane_5.add(radioButton_3);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(radioButton);
		buttonGroup.add(radioButton_3);
		
		
		JButton button_1 = new JButton("\u5F55\u5165");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringBuffer bufferContent = new StringBuffer(textField_1.getText());
				bufferContent.insert(bufferContent.indexOf("A"), '\n');
				String content = bufferContent.toString();
				if (content.equals("在此输入题目") || content.equals("")) {
					return;
				}
				String selected;
			    int subId = teacher.getSubjectId();
			    int typeId = 1;
				if (radioButton.isSelected()) {
					selected = radioButton.getActionCommand();
				}else {
					selected = radioButton_3.getActionCommand();
				}
				boolean isFlag =ManuImportQuestion.addTrueOrFalseQuestion(content, selected, subId, typeId);
				if (isFlag) {
					textField_1.setText("");
					JOptionPane.showMessageDialog(contentPane, "试题录入成功");
				} else {
					JOptionPane.showMessageDialog(contentPane, "试题录入失败");
				}
			}
		});
		button_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		button_1.setBounds(606, 56, 102, 27);
		desktopPane_5.add(button_1);
		
		JDesktopPane desktopPane_6 = new JDesktopPane();
		tabbedPane_1.addTab("单项选择题录入", null, desktopPane_6, null);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("宋体", Font.PLAIN, 15));
		textField_2.setText("\u5728\u6B64\u8F93\u5165\u9898\u76EE");
		textField_2.setColumns(10);
		textField_2.setBounds(14, 13, 430, 70);
		desktopPane_6.add(textField_2);
		
		
		
		JRadioButton rdbtnD = new JRadioButton("D");
		rdbtnD.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		rdbtnD.setBounds(649, 13, 59, 27);
		desktopPane_6.add(rdbtnD);
		
		JRadioButton rdbtnC = new JRadioButton("C");
		rdbtnC.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		rdbtnC.setBounds(584, 13, 59, 27);
		desktopPane_6.add(rdbtnC);
		
		JRadioButton rdbtnB = new JRadioButton("B");
		rdbtnB.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		rdbtnB.setBounds(519, 13, 59, 27);
		desktopPane_6.add(rdbtnB);
		
		JRadioButton rdbtnA = new JRadioButton("A");
		rdbtnA.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		rdbtnA.setBounds(454, 13, 59, 27);
		desktopPane_6.add(rdbtnA);
		
		ButtonGroup buttonGroup2 = new ButtonGroup();
		buttonGroup2.add(rdbtnA);
		buttonGroup2.add(rdbtnB);
		buttonGroup2.add(rdbtnC);
		buttonGroup2.add(rdbtnD);
		
		JButton button_2 = new JButton("\u5F55\u5165");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringBuffer bufferContent = new StringBuffer(textField_2.getText());
				bufferContent.insert(bufferContent.indexOf("A"), '\n');
				String content = bufferContent.toString();
				if (content.equals("在此输入题目") || content.equals("")) {
					return;
				}
				String selected;
			    int subId = teacher.getSubjectId();
			    int typeId = 2;
				if (rdbtnA.isSelected()) {
					selected = rdbtnA.getActionCommand();
				}else if (rdbtnB.isSelected()){
					selected = rdbtnB.getActionCommand();
				}else if (rdbtnC.isSelected()) {
					selected = rdbtnC.getActionCommand();
				}else {
					selected = rdbtnD.getActionCommand();
				}
				boolean isFlag = ManuImportQuestion.addMultipleChoiceQuestion(content, selected, subId, typeId);
				if (isFlag) {
					textField_2.setText("");
					JOptionPane.showMessageDialog(contentPane, "试题录入成功");
				} else {
					JOptionPane.showMessageDialog(contentPane, "试题录入失败");
				}
			}
		});
		
		button_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		button_2.setBounds(606, 56, 102, 27);
		desktopPane_6.add(button_2);
		
		JDesktopPane desktopPane_7 = new JDesktopPane();
		tabbedPane_1.addTab("多项选择题录入", null, desktopPane_7, null);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("宋体", Font.PLAIN, 15));
		textField_3.setText("\u5728\u6B64\u8F93\u5165\u9898\u76EE");
		textField_3.setColumns(10);
		textField_3.setBounds(14, 13, 430, 70);
		desktopPane_7.add(textField_3);
		
		JButton button_3 = new JButton("\u5F55\u5165");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringBuffer bufferContent = new StringBuffer(textField_3.getText());
				bufferContent.insert(bufferContent.indexOf("A"), '\n');
				String content = bufferContent.toString();
				if (content.equals("在此输入题目") || content.equals("")) {
					return;
				}
				StringBuffer buffer = new StringBuffer();
				String selected;
			    int subId = teacher.getSubjectId();
			    int typeId = 3;
				if (chckbxA.isSelected()) {
					buffer.append(chckbxA.getText());
				}
				if(chckbxB.isSelected()){
					buffer.append(chckbxB.getText());
				}
				if(chckbxC.isSelected()) {
					buffer.append(chckbxC.getText());
				}
				if(chckbxD.isSelected()) {
					buffer.append(chckbxD.getText());
				}
				selected = buffer.toString();
				boolean isFlag = ManuImportQuestion.addMultipleChoicesQuestion(content, selected, subId, typeId);
				if (isFlag) {
					textField_3.setText("");
					JOptionPane.showMessageDialog(contentPane, "试题录入成功");
				} else {
					JOptionPane.showMessageDialog(contentPane, "试题录入失败");
				}
			}
		});
		button_3.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		button_3.setBounds(606, 56, 102, 27);
		desktopPane_7.add(button_3);
		
		chckbxD = new JCheckBox("D");
		chckbxD.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		chckbxD.setBounds(649, 13, 59, 27);
		desktopPane_7.add(chckbxD);
		
		chckbxC = new JCheckBox("C");
		chckbxC.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		chckbxC.setBounds(584, 13, 59, 27);
		desktopPane_7.add(chckbxC);
		
		chckbxB = new JCheckBox("B");
		chckbxB.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		chckbxB.setBounds(519, 13, 59, 27);
		desktopPane_7.add(chckbxB);
		
		chckbxA = new JCheckBox("A");
		chckbxA.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		chckbxA.setBounds(454, 13, 59, 27);
		desktopPane_7.add(chckbxA);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(UIManager.getColor("TabbedPane.light"));
		panel_1.setBounds(14, 242, 751, 48);
		desktopPane_1.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label_6 = new JLabel("\u9009\u62E9\u6587\u4EF6\uFF1A");
		label_6.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label_6.setBounds(14, 13, 75, 18);
		panel_1.add(label_6);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("宋体", Font.PLAIN, 15));
		textField_4.setBounds(90, 10, 405, 24);
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
		JButton button_4 = new JButton("\u5F00\u59CB\u5F55\u5165");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AutoImportQuestion at = new AutoImportQuestion();
				boolean isFlag = false;
				int subId = teacher.getSubjectId();
				if (file != null) {
					isFlag = at.autoImport(file, subId);
					if (isFlag) {
						JOptionPane.showMessageDialog(contentPane, "导入试题成功");
					} else {
						if (at.getErrorMsg().startsWith("录入失败的题目")) {
							JOptionPane.showMessageDialog(contentPane, at.getErrorMsg());
						} else {
							JOptionPane.showMessageDialog(contentPane, "试题文件格式有误!");
							textField_4.setText("");
						}
					}
				}
				questionModel=new QuestionModel();
				questionModel.queryQuestionImformation(at);
				table.setModel(questionModel);
			}
		});
		button_4.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		button_4.setBounds(624, 9, 113, 27);
		panel_1.add(button_4);
		
		JButton button_5 = new JButton("\u6D4F\u89C8");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getSelectedFile();
			}
		});
		button_5.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		button_5.setBounds(497, 9, 113, 27);
		panel_1.add(button_5);
		
		JLabel label_1 = new JLabel("\u624B\u52A8\u5F55\u5165");
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label_1.setBounds(14, 13, 72, 18);
		desktopPane_1.add(label_1);
		
		JLabel label_2 = new JLabel("\u81EA\u52A8\u5F55\u5165");
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label_2.setBounds(14, 211, 72, 18);
		desktopPane_1.add(label_2);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(UIManager.getColor("TabbedPane.light"));
		panel_5.setBounds(14, 334, 751, 312);
		desktopPane_1.add(panel_5);
		panel_5.setLayout(null);
		
		table = new JTable();
		table.setFont(new Font("宋体", Font.PLAIN, 15));
		table.setBounds(14, 13, 723, 286);
		panel_5.add(table);
		
		JScrollPane scrollPane_1 = new JScrollPane(table);
		scrollPane_1.setBounds(14, 13, 723, 286);
		panel_5.add(scrollPane_1);
		
		JLabel label_3 = new JLabel("\u5F55\u5165\u7ED3\u679C");
		label_3.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label_3.setBounds(14, 303, 72, 18);
		desktopPane_1.add(label_3);
		
		JDesktopPane desktopPane_2 = new JDesktopPane();
		tabbedPane.addTab("  发起考试  ", null, desktopPane_2, null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(SystemColor.controlHighlight);
		panel_2.setBounds(14, 13, 751, 633);
		desktopPane_2.add(panel_2);
		
		JLabel label_11 = new JLabel("\u5DF2\u53D1\u8D77\u7684\u8003\u8BD5\uFF1A");
		label_11.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label_11.setBounds(14, 13, 105, 18);
		panel_2.add(label_11);
		
		JLabel label_12 = new JLabel("\u53D1\u8D77\u65B0\u8003\u8BD5\uFF1A");
		label_12.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label_12.setBounds(14, 496, 90, 18);
		panel_2.add(label_12);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(14, 527, 723, 95);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel label_13 = new JLabel("\u8003\u8BD5\u540D\u79F0\uFF1A");
		label_13.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label_13.setBounds(14, 13, 85, 27);
		panel_3.add(label_13);
		
		textField_9 = new JTextField();
		textField_9.setFont(new Font("宋体", Font.PLAIN, 15));
		textField_9.setColumns(10);
		textField_9.setBounds(89, 14, 185, 24);
		panel_3.add(textField_9);
		
		JLabel label_14 = new JLabel("\u8003\u8BD5\u65F6\u95F4\uFF1A");
		label_14.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label_14.setBounds(479, 13, 75, 27);
		panel_3.add(label_14);
		
		JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("宋体", Font.PLAIN, 15));
		spinner.setModel(new SpinnerDateModel(new Date(), null, null, Calendar.HOUR_OF_DAY));
		spinner.setBounds(552, 16, 157, 24);
		panel_3.add(spinner);
		
		JLabel label_15 = new JLabel("\u73ED\u7EA7\uFF1A");
		label_15.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label_15.setBounds(288, 13, 72, 27);
		panel_3.add(label_15);
		
		comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(sm.queryAllClasses()));
		comboBox_4.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		comboBox_4.setBounds(324, 14, 141, 24);
		panel_3.add(comboBox_4);
		
		JButton button_6 = new JButton("\u786E\u8BA4");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==button_6) {
					String serialName=textField_9.getText();
					Date Time= (Date) spinner.getValue();
					SimpleDateFormat fromatetime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String serialTime=fromatetime.format(Time);
					int subjectId=teacher.getSubjectId();
					String classesName=(String)comboBox_4.getSelectedItem();
					String[] cl=classesName.split("-");
					int classesId=Integer.parseInt(cl[1]);
					System.out.println("考试名字"+serialName+"\r考试时间"+serialTime+"\r考试科目"+subjectId+"\r考试班级"+classesId);;
					Serial serial=new Serial(serialName, serialTime, subjectId, classesId);
					
					
					serialModel.serialDao=new SerialDaoImpl();
					serialModel.serialDao.doSerialId(serial);
					serialModel=new SerialModel();
					serialModel.querySerialImformation(subjectId);
					table_2.setModel(serialModel);
					textField_9.setText("");
					
				}
				
				
			}
		});
		button_6.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		button_6.setBounds(596, 53, 113, 27);
		panel_3.add(button_6);
		
		serialModel.querySerialImformation(teacher.getSubjectId());
		table_2 = new JTable(serialModel);
		table_2.setFont(new Font("宋体", Font.PLAIN, 15));
		table_2.setBounds(24, 44, 713, 439);
		panel_2.add(table_2);
		
		JScrollPane scrollPane_2 = new JScrollPane(table_2);
		scrollPane_2.setBounds(24, 44, 713, 439);
		panel_2.add(scrollPane_2);
		
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
		textField_6.setText(tea.getTeacherId()+"");
		textField_6.setFont(new Font("宋体", Font.PLAIN, 15));
		textField_6.setBounds(86, 45, 66, 24);
		panel_4.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel label_9 = new JLabel("\u6309\u73ED\u7EA7\uFF1A");
		label_9.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label_9.setBounds(177, 44, 72, 27);
		panel_4.add(label_9);
		
		JLabel label_10 = new JLabel("\u6309\u8003\u6B21\uFF1A");
		label_10.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label_10.setBounds(359, 44, 90, 27);
		panel_4.add(label_10);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(sm.queryAllSerial()));
		comboBox_3.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		comboBox_3.setBounds(412, 45, 181, 24);
		panel_4.add(comboBox_3);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setModel(new DefaultComboBoxModel(sm.queryAllClasses()));
		comboBox_5.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		comboBox_5.setBounds(229, 45, 108, 24);
		panel_4.add(comboBox_5);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				classesName=(String) comboBox_5.getSelectedItem();
				System.out.println("班级"+classesName);
				serialName=(String) comboBox_3.getSelectedItem();
				System.out.println("场次"+serialName);
				
				if (classesName==null) {
					classesId=-1;
				}else {
					String [] cl=classesName.split("-");
					classesId=Integer.parseInt(cl[1]);
				}
				if (serialName==null) {
					serialId=-1;
				}else {
					String [] sl=serialName.split("-");
					serialId=Integer.parseInt(sl[1]);
				}
				System.out.println(classesId);
				System.out.println(serialId);
				if (e.getSource()==btnNewButton) {
					System.out.println("点击该按钮");
					sm=new ResultModel();
					sm.queryStudentResult(-1, serialId, classesId, teacher.getSubjectId());
					table_1.setModel(sm);
					
				}
			}
		});
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		btnNewButton.setBounds(624, 44, 113, 27);
		panel_4.add(btnNewButton);
		
		table_1 = new JTable(sm);
		table_1.setFont(new Font("宋体", Font.PLAIN, 15));
		table_1.setBounds(24, 84, 713, 497);
		panel_4.add(table_1);
		
		JButton button_7 = new JButton("\u67E5\u770B\u8BE6\u7EC6");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int row=table_1.getSelectedRow();
				if (row<0) {
					JOptionPane.showMessageDialog(button_7, "请选中表格中的一条成绩，查看该考生的答题情况！");
				}else {
					System.out.println(row);
					int sutdentId= (int) sm.getValueAt(row, 0);
					int serialId= (int) sm.getValueAt(row, 1);
					System.out.println(serialId);
					ReviewModel review = 
							new ReviewModel(sutdentId,serialId);
					review.doReview();
				}
				
			}
		});
		button_7.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		button_7.setBounds(624, 593, 113, 27);
		panel_4.add(button_7);
		
		JScrollPane scrollPane_3 = new JScrollPane(table_1);
		scrollPane_3.setBounds(24, 84, 713, 497);
		panel_4.add(scrollPane_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 13, 238, 697);
		desktopPane.add(scrollPane);
		
		JDesktopPane desktopPane_4 = new JDesktopPane();
		scrollPane.setViewportView(desktopPane_4);
		
		JTextPane txtpnnnn = new JTextPane();
		txtpnnnn.setFont(new Font("宋体", Font.PLAIN, 18));
		txtpnnnn.setEditable(false);
		txtpnnnn.setText("\r\n\r\n工号: " + tea.getTeacherId() + "\r\n姓名: " + tea.getTeacherName() + "\r\n性别: " + tea.getTeacherSex()+"\r\n科目: "+sm.subjectDao.findSubjectById(tea.getSubjectId()).getSubjectName());
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
	
	/**
	 * 获取选择的试题文件
	 */
	public void getSelectedFile() {
		JFileChooser chooser = new JFileChooser();
		chooser.showOpenDialog(null);
		file = chooser.getSelectedFile();
		if(file != null) {
			textField_4.setText(file.getPath());
		}
	}
}
