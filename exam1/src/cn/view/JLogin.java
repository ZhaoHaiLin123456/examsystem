package cn.view;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.bean.Manager;
import cn.bean.Student;
import cn.bean.Teacher;
import cn.biz.Login;
import cn.utils.MD5;

import javax.swing.JDesktopPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *µÇÂ¼Ò³Ãæ
 */
public class JLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JRadioButton radioButton;
	private JRadioButton radioButton_1;
	private JRadioButton radioButton_2;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JLogin frame = new JLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JLogin() {
		setResizable(false);
		setTitle("µÇÂ½Ò³Ãæ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(450, 375);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JDesktopPane desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		textField = new JTextField();
		textField.setBounds(109, 145, 238, 24);
		desktopPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if( e.getKeyChar()=='\n' ) {
					validateLogin();
				}
			}
		});
		passwordField.setBounds(109, 187, 238, 24);
		desktopPane.add(passwordField);
	
		JButton button = new JButton("\u767B\u9646");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				validateLogin();
			}
		});
		button.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		button.setBounds(152, 268, 113, 27);
		desktopPane.add(button);
		
		JLabel label_1 = new JLabel("\u5BC6\u7801\uFF1A");
		label_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		label_1.setBounds(64, 187, 45, 18);
		desktopPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u8D26\u53F7\uFF1A");
		label_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		label_2.setBounds(64, 145, 45, 18);
		desktopPane.add(label_2);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon("image\\Ð¡.jpg"));
		label.setBounds(75, 13, 272, 119);
		desktopPane.add(label);
		
		radioButton = new JRadioButton("\u5B66\u751F");
		radioButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		radioButton.setBackground(Color.WHITE);
		radioButton.setBounds(85, 225, 83, 27);
		desktopPane.add(radioButton);
		
		radioButton_1 = new JRadioButton("\u8001\u5E08");
		radioButton_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		radioButton_1.setBackground(Color.WHITE);
		radioButton_1.setBounds(175, 225, 83, 27);
		desktopPane.add(radioButton_1);
		
		radioButton_2 = new JRadioButton("\u7BA1\u7406\u5458");
		radioButton_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		radioButton_2.setBackground(Color.WHITE);
		radioButton_2.setBounds(264, 225, 83, 27);
		desktopPane.add(radioButton_2);
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(radioButton);
		buttonGroup.add(radioButton_1);
		buttonGroup.add(radioButton_2);
		radioButton.setSelected(true);
		
	}
	
	public void validateLogin() {
		String input1 = textField.getText();
		String input2 = new String(passwordField.getPassword());
	
		if (input1.equals("") || input2.equals("")) {
			JOptionPane.showMessageDialog(contentPane,"ÕËºÅºÍÃÜÂë¾ùÐèÌîÐ´!");
			return;
		}
		
		int loginId = Integer.parseInt(textField.getText());
		String loginPwd = new MD5().getMD5ofStr(new String(passwordField.getPassword()));
		if (radioButton.isSelected()) {
			String status = radioButton.getActionCommand();
			Student stu = Login.validate(loginId, loginPwd,status);
			if (stu != null) {
				setVisible(false);
				JStudent stuView = new JStudent(stu);
				stuView.setVisible(true);
				Thread thread = new Thread(stuView);
				thread.start();
				return;
			}
		}else if (radioButton_1.isSelected()) {
			String status = radioButton_1.getActionCommand();
			Teacher teacher = Login.validate(loginId, loginPwd, status);
			if(teacher != null) {
				setVisible(false);
				JTeacher teacherView = new JTeacher(teacher);
				teacherView.setVisible(true);
				return;
			}
		}else {
			String status = radioButton_2.getActionCommand();
			Manager manager = Login.validate(loginId, loginPwd, status);
			if (manager != null) {
				setVisible(false);
				JManager managerView = new JManager(manager);
				managerView.setVisible(true);
				return;
			}
		}
		JOptionPane.showMessageDialog(contentPane,"µÇÂ¼Ê§°Ü");
	}
}
