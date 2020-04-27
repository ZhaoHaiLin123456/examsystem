package cn.view;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.model.StudentModel;
import cn.model.TeacherModel;
import cn.utils.MD5;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
/**
 * 更改密码页面
 */
public class JUpdatePwd extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	JLabel label_3;
	TeacherModel teacherModel;
	StudentModel studentModel;
	int studentId,teacherId;
	JButton button = new JButton("\u786E\u8BA4");
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					JUpdatePwd frame = new JUpdatePwd(null, null, defaultCloseOperation);
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
	public JUpdatePwd(Object object,int rowNums) {//利用多态来实现传入的是student还是teacher模型
		
		setTitle("修改密码");
		System.out.println(object);
		System.out.println(rowNums);
//		this.teacherModel=teacher;
//		this.studentModel=student;
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 310, 225);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if( e.getKeyChar()=='\n' ) {
					yes();
				}
			}
		});
		textField.setFont(new Font("宋体", Font.PLAIN, 15));
		textField.setBounds(94, 94, 172, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u65B0\u5BC6\u7801\uFF1A");
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label_1.setBounds(30, 97, 72, 18);
		contentPane.add(label_1);
		
		button.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent e) {
				yes();
			}
		});
		button.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		button.setBounds(100, 138, 113, 27);
		contentPane.add(button);
		
		JLabel label_2 = new JLabel("\u4FEE\u6539\u6B64\u8D26\u6237\uFF1A");
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label_2.setBounds(30, 66, 90, 18);
		contentPane.add(label_2);
		
		JLabel lblNewLabel_1 = new JLabel("\u4FEE\u6539\u5BC6\u7801");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(30, 13, 246, 40);
		contentPane.add(lblNewLabel_1);
		
		label_3 = new JLabel();
		
		if (object.getClass()==TeacherModel.class) {//常用Object类中的getclass()方法
			teacherModel=(TeacherModel)object;
			teacherId=(int) teacherModel.getValueAt(rowNums, 0);
			label_3.setText(Integer.toString(teacherId));
		}else {
			studentModel=(StudentModel) object;
			studentId=(int) studentModel.getValueAt(rowNums, 0);
			label_3.setText(Integer.toString(studentId));
		}
//		if (studentModel!=null) {
//			studentId=(int) studentModel.getValueAt(rowNums, 0);
//			label_3.setText(Integer.toString(studentId));
//		}
//		else {
//			teacherId=(int) teacherModel.getValueAt(rowNums, 0);
//			label_3.setText(Integer.toString(teacherId));
//		}
		label_3.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label_3.setBounds(122, 66, 72, 18);
		contentPane.add(label_3);
	}
	
	private void yes() {
		String newPassword=new MD5().getMD5ofStr(textField.getText());	
		System.out.println(studentModel);
		System.out.println(teacherModel);
		if (studentModel!=null) {
			studentModel.studentDao.updateStuPwd(studentId, newPassword);
		}
		else {
			teacherModel.teacherDao.updatePwd(teacherId, newPassword);
		}
		JOptionPane.showMessageDialog(button, "修改密码成功");
		dispose();
	}
}
