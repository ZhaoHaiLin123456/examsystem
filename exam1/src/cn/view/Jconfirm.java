package cn.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.model.ExamAndReviewModel;

import javax.swing.JDesktopPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 *  «∑ÒÃ·Ωª»∑»œΩÁ√Ê
 */
public class Jconfirm extends JFrame {

	private JPanel contentPane;
	
	public Jconfirm(ExamAndReviewModel confirm) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 300, 287, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JDesktopPane desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		JButton button = new JButton("\u786E\u8BA4");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirm.confirm();
				dispose();
			}
		});
		button.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 15));
		button.setBounds(14, 57, 113, 27);
		desktopPane.add(button);
		
		JButton button_1 = new JButton("\u53D6\u6D88");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_1.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 15));
		button_1.setBounds(145, 57, 113, 27);
		desktopPane.add(button_1);
		
		JLabel label = new JLabel(" \u786E\u5B9A\u5417\uFF1F");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 17));
		label.setBounds(100, 13, 73, 31);
		desktopPane.add(label);
	}
}
