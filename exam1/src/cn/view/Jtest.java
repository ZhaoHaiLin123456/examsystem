package cn.view;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.biz.Timer;
import cn.model.ExamAndReviewModel;
import cn.model.ExamModel;

import javax.swing.JScrollPane;
import javax.swing.JDesktopPane;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JToolBar;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
/**
 * 考试界面和考试回顾界面
 */
public class Jtest extends JFrame implements Runnable{

	private JPanel contentPane;
	private JTextPane textField;
	JLabel lblEmpty = new JLabel("empty");
	JPanel panel_multi = new JPanel();
	JPanel panel_single = new JPanel();
	JPanel panel_judge = new JPanel();

	JRadioButton rdbtnT = new JRadioButton("正确");
	JRadioButton rdbtnF = new JRadioButton("错误");
	JRadioButton rdbtnA = new JRadioButton("A");
	JRadioButton rdbtnB = new JRadioButton("B");
	JRadioButton rdbtnC = new JRadioButton("C");
	JRadioButton rdbtnD = new JRadioButton("D");
	JCheckBox chckbxA = new JCheckBox("A");
	JCheckBox chckbxB = new JCheckBox("B");
	JCheckBox chckbxC = new JCheckBox("C");
	JCheckBox chckbxD = new JCheckBox("D");
	
	JButton[] buttons;
	
	private Timer timer;
	private JLabel label_1;
	private String timeStr;
	private ExamAndReviewModel model;
	/*
	 * 切换题目需要的方法
	 */
	public void setQueContext(String text) {
		textField.setText(text);
	}
	//题型切换
	public void swichToJudge() {
		panel_judge.setVisible(true);
		panel_single.setVisible(false);
		panel_multi.setVisible(false);
	}
	public void swichToSingle() {
		panel_judge.setVisible(false);
		panel_single.setVisible(true);
		panel_multi.setVisible(false);
	}
	public void swichToMulti() {
		panel_judge.setVisible(false);
		panel_single.setVisible(false);
		panel_multi.setVisible(true);
	}
	//读取所选项
	public String readJudge() {
		if(rdbtnT.isSelected()) {
			return "正确";
		}else if(rdbtnF.isSelected()) {
			return "错误";
		}
		return null;
	}
	public String readSingle() {
		if(rdbtnA.isSelected()) { return "A"; }
		if(rdbtnB.isSelected()) { return "B"; }
		if(rdbtnC.isSelected()) { return "C"; }
		if(rdbtnD.isSelected()) { return "D"; }
		return null;
	}
	public String readMulti() {
		String selection = "";
		if(chckbxA.isSelected()) { selection+="A"; }
		if(chckbxB.isSelected()) { selection+="B"; }
		if(chckbxC.isSelected()) { selection+="C"; }
		if(chckbxD.isSelected()) { selection+="D"; }
		if(selection.equals("")) {
			return null;
		}
		return selection;
	}
	//还原所选项
	public void restoreJudge(String answer) {
		if(answer==null) {
			rdbtnT.setSelected(false);
			rdbtnF.setSelected(false);
		}
		else if(answer.equals("正确")) {
			rdbtnT.setSelected(true);
			rdbtnF.setSelected(false);
		}else if(answer.equals("错误")) {
			rdbtnT.setSelected(false);
			rdbtnF.setSelected(true);
		}
	}
	public void restoreSingle(String answer) {
		if(answer==null) {
			rdbtnA.setSelected(false);
			rdbtnB.setSelected(false);
			rdbtnC.setSelected(false);
			rdbtnD.setSelected(false);
		}
		else if(answer.equals("A")) {
			rdbtnA.setSelected(true);
			rdbtnB.setSelected(false);
			rdbtnC.setSelected(false);
			rdbtnD.setSelected(false);
		}else if(answer.equals("B")) {
			rdbtnA.setSelected(false);
			rdbtnB.setSelected(true);
			rdbtnC.setSelected(false);
			rdbtnD.setSelected(false);
		}else if(answer.equals("C")) {
			rdbtnA.setSelected(false);
			rdbtnB.setSelected(false);
			rdbtnC.setSelected(true);
			rdbtnD.setSelected(false);
		}else if(answer.equals("D")) {
			rdbtnA.setSelected(false);
			rdbtnB.setSelected(false);
			rdbtnC.setSelected(false);
			rdbtnD.setSelected(true);
		}
	}
	public void restoreMulti(String answer) {
		if(answer==null) {
			chckbxA.setSelected(false);
			chckbxB.setSelected(false);
			chckbxC.setSelected(false);
			chckbxD.setSelected(false);
		}else {
			if(answer.indexOf('A')==-1) chckbxA.setSelected(false);
				else chckbxA.setSelected(true);
			if(answer.indexOf('B')==-1) chckbxB.setSelected(false);
				else chckbxB.setSelected(true);
			if(answer.indexOf('C')==-1) chckbxC.setSelected(false);
				else chckbxC.setSelected(true);
			if(answer.indexOf('D')==-1) chckbxD.setSelected(false);
				else chckbxD.setSelected(true);
		}
	}
	//禁用选项框，用于review时
	public void setSelectionDisable() {
		rdbtnT.setEnabled(false);
		rdbtnF.setEnabled(false);
		rdbtnA.setEnabled(false);
		rdbtnB.setEnabled(false);
		rdbtnC.setEnabled(false);
		rdbtnD.setEnabled(false);
		chckbxA.setEnabled(false);
		chckbxB.setEnabled(false);
		chckbxC.setEnabled(false);
		chckbxD.setEnabled(false);
	}
	public void setCorrectAnswer(String answer) {
		lblEmpty.setText(answer);
	}
	
	
	
	/*
	 * 用于考试界面的颜色配置
	 */
	//更新题号按钮颜色
	public void updateColor(boolean readCurrentAnswer, int currentQues) {
		if(buttons[currentQues].getBackground().equals(new Color(255, 215, 0))) {
			buttons[currentQues].setBackground(new Color(255, 165, 0));
		}else {
			if(readCurrentAnswer) {
				buttons[currentQues].setBackground(UIManager.getColor("textHighlight"));
			}else {
				buttons[currentQues].setBackground(UIManager.getColor("Button.background"));
			}
		}
	}
	//显示当前所在题目
	public void tagNow(int currentQues) {
		if(buttons[currentQues].getBackground().equals(new Color(255, 165, 0))) {
			buttons[currentQues].setBackground(new Color(255, 215, 0));
		}else {
			buttons[currentQues].setBackground(Color.WHITE);
		}
	}
	//标记题目
	public void setFlag(int currentQues) {
		if(buttons[currentQues].getBackground().equals(new Color(255, 215, 0))) {
			buttons[currentQues].setBackground(Color.WHITE);
		}else {
			buttons[currentQues].setBackground(new Color(255, 215, 0));
		}
	}
	/*
	 * 用于review界面的颜色配置
	 */
	//更新题号按钮颜色
	public void setColor_review(boolean correct, int currentQues) {
		if(correct) {
			buttons[currentQues].setBackground(new Color(173, 255, 47));
		}else {
			buttons[currentQues].setBackground(new Color(255, 69, 0));
		}
	}
	//显示当前所在题目
	public void setButtonFalse(int currentQues) {
		buttons[currentQues].setEnabled(false);
	}
	public void setButtonTrue(int currentQues) {
		buttons[currentQues].setEnabled(true);
	}
	
	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Jtest frame = new Jtest();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public Jtest(ExamAndReviewModel model) {
		this.model = model;
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		JDesktopPane desktopPane = new JDesktopPane();
		scrollPane.setViewportView(desktopPane);
		
		JButton button_2 = new JButton("\u6807\u8BB0\u6B64\u9898");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setFlag(model.getCurrentQues());
			}
		});
		button_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		button_2.setBounds(17, 231, 102, 27);
		desktopPane.add(button_2);
		
		lblEmpty.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		lblEmpty.setBounds(683, 240, 73, 18);
		desktopPane.add(lblEmpty);
		
		JLabel label_3 = new JLabel("\u6B63\u786E\u7B54\u6848\uFF1A");
		label_3.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		label_3.setBounds(607, 240, 149, 18);
		desktopPane.add(label_3);
		
		
		JButton button = new JButton("\u4E0B\u4E00\u9898");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.nextQuestion();
			}
		});
		button.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		button.setBounds(643, 339, 113, 27);
		desktopPane.add(button);
		
		JButton button_1 = new JButton("\u4E0A\u4E00\u9898");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.lastQuestion();
			}
		});
		button_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		button_1.setBounds(14, 339, 113, 27);
		desktopPane.add(button_1);
		
		textField = new JTextPane();
		textField.setFont(new Font("宋体", Font.PLAIN, 15));
		textField.setEditable(false);
		textField.setText("\u9898\u76EE\u663E\u793A\u533A\u57DF");
		textField.setBounds(27, 79, 718, 139);
		desktopPane.add(textField);
		
		/*
		 * 判断题选项框
		 */
		panel_judge.setBounds(484, 271, 273, 59);
		desktopPane.add(panel_judge);
		panel_judge.setLayout(null);
		rdbtnT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnF.setSelected(false);
			}
		});
		rdbtnT.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		rdbtnT.setBounds(0, 0, 133, 27);
		panel_judge.add(rdbtnT);
		rdbtnF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnT.setSelected(false);
			}
		});
		rdbtnF.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		rdbtnF.setBounds(139, 0, 133, 27);
		panel_judge.add(rdbtnF);
		
		/*
		 * 单选题选项框
		 */
		panel_single.setBounds(484, 271, 273, 59);
		desktopPane.add(panel_single);
		panel_single.setLayout(null);
		rdbtnA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnB.setSelected(false);
				rdbtnC.setSelected(false);
				rdbtnD.setSelected(false);
			}
		});
		rdbtnA.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		rdbtnA.setBounds(0, 0, 133, 27);
		panel_single.add(rdbtnA);
		rdbtnB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnA.setSelected(false);
				rdbtnC.setSelected(false);
				rdbtnD.setSelected(false);
			}
		});
		rdbtnB.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		rdbtnB.setBounds(139, 0, 133, 27);
		panel_single.add(rdbtnB);
		rdbtnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnA.setSelected(false);
				rdbtnB.setSelected(false);
				rdbtnD.setSelected(false);
			}
		});
		rdbtnC.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		rdbtnC.setBounds(0, 32, 133, 27);
		panel_single.add(rdbtnC);
		rdbtnD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnA.setSelected(false);
				rdbtnB.setSelected(false);
				rdbtnC.setSelected(false);
			}
		});
		rdbtnD.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		rdbtnD.setBounds(139, 32, 133, 27);
		panel_single.add(rdbtnD);
		panel_single.setVisible(false);
		
		/*
		 * 多选题选项框
		 */
		panel_multi.setBounds(484, 271, 273, 59);
		desktopPane.add(panel_multi);
		panel_multi.setLayout(null);
		chckbxA.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		chckbxA.setBounds(0, 0, 133, 27);
		panel_multi.add(chckbxA);
		chckbxB.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		chckbxB.setBounds(139, 0, 133, 27);
		panel_multi.add(chckbxB);
		chckbxC.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		chckbxC.setBounds(0, 32, 133, 27);
		panel_multi.add(chckbxC);
		chckbxD.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		chckbxD.setBounds(139, 32, 133, 27);
		panel_multi.add(chckbxD);
		panel_multi.setVisible(false);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setEnabled(false);
		toolBar.setFloatable(false);
		toolBar.setBounds(14, 271, 172, 59);
		desktopPane.add(toolBar);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("image\\7_minutes2.png"));
		toolBar.add(label);
		
		label_1 = new JLabel("00:00:00");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 25));
		toolBar.add(label_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(14, 381, 742, 107);
		desktopPane.add(scrollPane_1);
		
		/*
		 * 题目编号按钮栏
		 */
		JToolBar toolBar_1 = new JToolBar();
		scrollPane_1.setViewportView(toolBar_1);
		toolBar_1.setRollover(true);
		toolBar_1.setOrientation(SwingConstants.VERTICAL);
		toolBar_1.setFloatable(false);
		
		//题目01~20题栏
		JToolBar toolBar_2 = new JToolBar();
		toolBar_2.setFloatable(false);
		toolBar_1.add(toolBar_2);
		
		//题目21~40题栏
		JToolBar toolBar_3 = new JToolBar();
		toolBar_3.setFloatable(false);
		toolBar_1.add(toolBar_3);
		
		//题目41~60题栏
		JToolBar toolBar_4 = new JToolBar();
		toolBar_4.setFloatable(false);
		toolBar_1.add(toolBar_4);
		
		/*
		 * 循环创建按钮并添加进JToolBar
		 * 为按键添加监听事件，以k标记每个按钮
		 */
		int MountOfQues = model.getAmountOfQues();
		buttons = new JButton[MountOfQues];
		for(int i=0;i<MountOfQues;i++) {
			String ques_num = " ";
			if(i<9) {
				ques_num += "0"+(i+1);
			}else {
				ques_num += (i+1);
			}
			buttons[i] = new JButton(ques_num);
			buttons[i].setBackground(UIManager.getColor("Button.background"));
			buttons[i].setFont(new Font("微软雅黑", Font.PLAIN, 15));
			int k = i;
			buttons[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					model.switchQuestion(k);
				}
			});
			if(i<20) {
				toolBar_2.add(buttons[i]);
			}else if(i<40) {
				toolBar_3.add(buttons[i]);
			}else {
				toolBar_4.add(buttons[i]);
			}
		}
		
		JButton button_62 = new JButton("\u4EA4\u5377");
		button_62.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(timer.getTimes() > 1800) {
					JOptionPane.showMessageDialog(contentPane,"考试开始一个小时之后才能提交!");
				}else {
					model.switchQuestion(model.currentQues);
					Jconfirm confirm = new Jconfirm(model);
					confirm.setVisible(true);
				}
				
			}
		});
		button_62.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		button_62.setBounds(619, 501, 137, 39);
		desktopPane.add(button_62);
		
		if(model.getClass().toString().indexOf("ReviewModel")!=-1) {
			button_2.setVisible(false);
			button_62.setVisible(false);
		}
		
		JLabel lblNewLabel = new JLabel(model.getSerialName());
		lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(17, 13, 454, 42);
		desktopPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(14, 68, 742, 194);
		desktopPane.add(panel);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("image\\小小.jpg"));
		label_2.setBounds(629, 13, 127, 64);
		desktopPane.add(label_2);
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE");
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(17, 501, 113, 27);
		desktopPane.add(btnNewButton);

		if(model.getClass().toString().indexOf("ExamModel")!=-1) {
			lblEmpty.setVisible(false);
			label_3.setVisible(false);
			btnNewButton.setVisible(false);
		}
		
	}
	@Override
	public void run() {
		countDown();
		
	}
	public String getTimeStr() {
		return timeStr;
	}
	public void setTimeStr(String timeStr) {
		this.timeStr = timeStr;
	}
	
	public void countDown() {
		//TimeVerification v = new TimeVerification();
		//String msg = v.validateTime(6); 
		//System.out.println(msg);

		/*if (msg.indexOf("考试") == -1) {
			timer.setTimeStr(msg);
			Thread thread = new Thread(timer);
			thread.start();
		}else {
			JOptionPane.showMessageDialog(contentPane,msg);
		}*/
		timer = new Timer();
		timer.setTimeStr(timeStr);
		Thread thread = new Thread(timer);
		thread.start();
		while (true) {
			try {
				if (timer.getClock() != null && timer.getClock().equals("0:0:0"))
					break;
				label_1.setText(timer.getClock());
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		model.confirm();
		
	}
}
