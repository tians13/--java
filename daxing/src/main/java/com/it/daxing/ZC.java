package com.it.daxing;

import com.it.daxing.finish.ImagePanel;
import com.it.daxing.finish.staff_login;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

	public class ZC extends JFrame{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private VerificationCode vcode = new VerificationCode();
		JTextField user,pass,idd,ph,co;
		JButton register,exit;

		public ZC()
		{
			super("注册");			
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			this.setSize(500,500);	
			this.setLocationRelativeTo(null); //此窗口将置于屏幕的中央
			setVisible(true);

			Image img = Toolkit.getDefaultToolkit().getImage("src\\Image\\寻找熊出没仓库照片 (4).png");
			// 创建ImagePanel并添加到JFrame
			ImagePanel frame = new ImagePanel(img);
		    this.add(frame);			
			
			JLabel username=new JLabel("负责人姓名");
			username.setForeground(Color.white);
			JLabel password=new JLabel("密码");
			password.setForeground(Color.white);
			JLabel id=new JLabel("负责人工号");
			id.setForeground(Color.white);
			JLabel phone=new JLabel("手机号码");
			phone.setForeground(Color.white);
			JLabel code=new JLabel("验证码");
			code.setForeground(Color.white);

			user=new JTextField();
			pass=new JTextField();
			idd=new JTextField();
			ph=new JTextField();
			co=new JTextField();

			register=new JButton("注  册");
			register.setForeground(Color.BLACK);
			exit=new JButton("退  出");
			exit.setForeground(Color.BLACK);
			
			username.setBounds(20, 46, 125, 40);
			username.setFont(new Font("楷体",Font.BOLD,17));
			user.setBounds(135,50,120,30);

			password.setBounds(20,100,125,30);
			password.setFont(new Font("楷体",Font.BOLD,17));
			pass.setBounds(135,100,120,30);

			id.setBounds(20,150,125,30);
			id.setFont(new Font("楷体",Font.BOLD,17));
			idd.setBounds(135,150,120,30);

			phone.setBounds(20,200,125,30);
			phone.setFont(new Font("楷体",Font.BOLD,17));
			ph.setBounds(135,200,120,30);

			code.setBounds(20,250,125,30);
			code.setFont(new Font("楷体",Font.BOLD,17));
			co.setBounds(135,250,120,30);

			vcode.setBounds(112, 300, 100, 40);
			register.setBounds(150,380,70,30);
			exit.setBounds(250,380,70,30);
		
			
			frame.setLayout(null);
			frame.add(username);
			frame.add(user);
			frame.add(password);
			frame.add(pass);
			frame.add(id);
			frame.add(idd);
			frame.add(phone);
			frame.add(ph);
			frame.add(code);
			frame.add(co);
			frame.add(register);
			frame.add(exit);
			frame.add(vcode);

			register.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String user1 = user.getText().trim();
					String pass1 = pass.getText().trim();
					String id1 = idd.getText().trim();
					String ph1 = ph.getText().trim();
					String co1 = co.getText();

					try {
						Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
						//加载对应的jdbc驱动
						String url = "jdbc:sqlserver://localhost:1433;DatabaseName=stash;trustServerCertificate=true;";
						//配置连接字符串
						String user = "sa3";//sa超级管理员
						String password = "123456";//密码
						Connection conn = DriverManager.getConnection(url, user, password);
						//创建数据库连接对象
						Statement st = conn.createStatement();

						if (user1.isEmpty()){
							JOptionPane.showMessageDialog(null, "请输入姓名!", "提示消息", JOptionPane.WARNING_MESSAGE);
						}else {
							//创建SQL语句执行对象
							String strSQL = "(Select * from  dbo.staff where Pname='" + user1 + "' )";
							ResultSet rs = st.executeQuery(strSQL);

							if (rs.next()){
								JOptionPane.showMessageDialog(null, "该用户名已存在!", "提示消息", JOptionPane.WARNING_MESSAGE);
							}else {
								if (pass1.isEmpty()){
									JOptionPane.showMessageDialog(null, "请输入密码!", "提示消息", JOptionPane.WARNING_MESSAGE);
								}else {
									if (id1.isEmpty() &&  ph1.isEmpty()){
										JOptionPane.showMessageDialog(null, "请继续补全信息，谢谢!", "提示消息", JOptionPane.WARNING_MESSAGE);
									}else {
										if (co1.isEmpty()) {
											JOptionPane.showMessageDialog(null, "请输入验证码!", "提示消息", JOptionPane.WARNING_MESSAGE);
										}
										else{
											if (!isValidCodeRight()) {
												JOptionPane.showMessageDialog(null, "验证码错误,请重新输入!", "提示消息", JOptionPane.WARNING_MESSAGE);
											} else {
												try{
													String sql = "insert into dbo.staff(Pid,Pname,Pphonenumber,Ppassword) values('" + id1 + "','" + user1 + "','" + ph1 + "','" + pass1 + "') ";

													int i = st.executeUpdate(sql);
													JOptionPane.showMessageDialog(null, "注册成功");
												}
												catch (SQLException ex) {
													JOptionPane.showMessageDialog(null, "负责人工号重复，请核查!", "提示消息", JOptionPane.WARNING_MESSAGE);
												}
												conn.close();
												//关闭数据库连接
											}
										}
									}
								}

							}
						}
					} catch (ClassNotFoundException ex) {
						System.out.println("没有找到对应的数据库驱动类");
					} catch (SQLException ex) {
						System.out.println("数据库连接或者是数据库操作失败");
					}
				}

			});

			exit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					closeThis();
					new staff_login();
				}
			});
		}

		public boolean isValidCodeRight() {

			if (co == null) {
				return false;
			} else if (vcode == null) {
				return true;
			} else if (vcode.getCode().equals(co.getText())) {
				return true;
			} else
				return false;

		}


		public void closeThis()//关闭当前界面
		{
			this.dispose();
		}

	}


