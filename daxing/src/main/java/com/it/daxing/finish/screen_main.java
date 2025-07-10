package com.it.daxing.finish;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;

public class screen_main extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public screen_main() {
		setTitle("登录");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 500);
		this.setLocation(300, 120);

		Image img = Toolkit.getDefaultToolkit().getImage("src\\Image\\寻找熊出没仓库照片 (1).png");
		// 创建ImagePanel并添加到JFrame
		ImagePanel B = new ImagePanel(img);
		this.add(B);

		JButton manager = new JButton("总管登录");
		manager.setOpaque(true);
		manager.setBackground(Color.black);
		manager.setForeground(Color.white);

		JButton staff = new JButton("负责人登录");
		staff.setOpaque(true);
		staff.setBackground(Color.black);
		staff.setForeground(Color.white);

		JButton student = new JButton("学生登录");
		student.setOpaque(true);
		student.setBackground(Color.black);
		student.setForeground(Color.white);


		manager.setBounds(420, 300, 200, 30);
		staff.setBounds(420, 350, 200, 30);
		student.setBounds(420, 400, 200, 30);

		manager.setFont(new Font("微软雅黑", Font.BOLD, 20));
		staff.setFont(new Font("微软雅黑", Font.BOLD, 20));
		student.setFont(new Font("微软雅黑", Font.BOLD, 20));
		B.setLayout(null);
		B.add(manager);
		B.add(staff);
        B.add(student);

		staff.addActionListener(new ActionListener()    //监听 负责人 按钮
		{

			public void actionPerformed(ActionEvent e) { new staff_login();}
		});

		manager.addActionListener(new ActionListener()   //监听 总管 按钮
		{
			public void actionPerformed(ActionEvent e) {
				new manager_login();
			}
		});

		student.addActionListener(new ActionListener()   //监听 总管 按钮
		{
			public void actionPerformed(ActionEvent e) { new student_login();}
		});

	}

	public static void main(String[] args) {
		new screen_main().setVisible(true);

	}

}
	
	

