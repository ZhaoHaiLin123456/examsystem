package cn.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDesktopPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
/**
 * 是否提交成功提示界面
 */
public class Jsuccess extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Jsuccess() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 260, 156);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JDesktopPane desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		JButton button = new JButton("\u786E\u8BA4");
		button.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button.setBounds(66, 59, 113, 27);
		desktopPane.add(button);
		
		JLabel lblNewLabel = new JLabel("\u63D0\u4EA4\u6210\u529F\uFF01");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(76, 19, 103, 27);
		desktopPane.add(lblNewLabel);
	}

}
