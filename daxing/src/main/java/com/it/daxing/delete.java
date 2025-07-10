package com.it.daxing;

import com.it.daxing.finish.ImagePanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

public class delete extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public delete() {
		super("删除信息");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(500, 550);
		this.setLocationRelativeTo(null);
		setVisible(true);

		Image img = Toolkit.getDefaultToolkit().getImage("D:\\新建文件夹\\delete.png");
		// 创建ImagePanel并添加到JFrame
		ImagePanel frame = new ImagePanel(img);
		this.add(frame);

		//单选框集合
		ButtonGroup group = new ButtonGroup();
		JRadioButton option1 = new TransparentRadioButton("负责人姓名");
		option1.setBackground(new Color(0, 0, 0, 0)); // 设置背景为透明
		option1.setForeground(Color.black);
		JRadioButton option2 = new TransparentRadioButton("负责人工号");
		option2.setBackground(new Color(0, 0, 0, 0)); // 设置背景为透明
		option2.setForeground(Color.black);
		group.add(option1);
		group.add(option2);



		JLabel goods_name = new JLabel("商品名:");
		goods_name.setForeground(Color.black);
		goods_name.setFont(new Font("楷体", Font.PLAIN, 20));//设置字体的字体，样子，大小
		JTextField goodsName_input = new JTextField(12);

		JLabel staff_id_name = new JLabel("负责人ID/姓名:");
		staff_id_name.setForeground(Color.black);
		staff_id_name.setFont(new Font("楷体", Font.PLAIN, 20));
		JTextField staff_input = new JTextField(10);

		JLabel j1 = new JLabel("(温馨提醒：谨慎删除哦~)");
		j1.setForeground(Color.black);
		j1.setFont(new Font("宋体", Font.PLAIN, 12));

		JButton aa = new JButton("确定");
		aa.setFont(new Font("楷体", Font.PLAIN, 20));
		aa.setBackground(Color.GREEN);
		JButton bb = new JButton("重置");
		bb.setFont(new Font("楷体", Font.PLAIN, 20));
		bb.setBackground(Color.RED);


		aa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
					//创建SQL语句执行对象

					String a = goodsName_input.getText().trim();

					String staff = staff_input.getText().trim();
					if (a.isEmpty() && staff.isEmpty()){
						JOptionPane.showMessageDialog(null, "请输入内容aaa！");
					}else {
						if (!(a.isEmpty())){
							String s = "(Select * from dbo.cargo where Sname='" + a + "')";
							ResultSet r = st.executeQuery(s);
							if (r.next()) {

								String strSQL = "delete from shelf where Sname = '" + a + "'";
								int i1 = st.executeUpdate(strSQL);
								String strSQL1 = "delete from cargo where Sname = '" + a + "'";
								int i = st.executeUpdate(strSQL1);
								JOptionPane.showMessageDialog(null, "删除商品成功哦~");

							}else {
								JOptionPane.showMessageDialog(null, "你输入的商品名有误！","警告",JOptionPane.WARNING_MESSAGE);
							}
						}
						if (!(staff.isEmpty())){
							if (option1.isSelected()) {
								//如果输入的是姓名
								String strSQL = "select * from staff where Pname = '" + staff + "'";
								ResultSet r1 = st.executeQuery(strSQL);
								if (r1.next()) {
									String s1 = r1.getString(1);

									String strSQL1 = "delete from supervise where Pid = '" + s1 + "'";
									int i1 = st.executeUpdate(strSQL1);
									String strSQL2 = "delete from staff where Pname = '" + staff + "'";
									int i2 = st.executeUpdate(strSQL2);

									JOptionPane.showMessageDialog(null, "根据负责人的姓名删除成功！");
								}else {
									JOptionPane.showMessageDialog(null, "你输入的负责人姓名有误！","警告",JOptionPane.WARNING_MESSAGE);
								}
							} else if (option2.isSelected()) {
								//如果输入的是负责人的工号
								String strSQL3 = "select * from staff where Pid = '" + staff + "'";
								ResultSet r3 = st.executeQuery(strSQL3);
								if (r3.next()) {

									String strSQL4 = "delete from supervise where Pid = '" + staff + "'";
									int i4 = st.executeUpdate(strSQL4);
									String strSQL5 = "delete from staff where Pid = '" + staff + "'";
									int i5 = st.executeUpdate(strSQL5);
									JOptionPane.showMessageDialog(null, "根据负责人的id删除成功！");
								}else {
									JOptionPane.showMessageDialog(null, "你输入的负责人id有误！","警告",JOptionPane.WARNING_MESSAGE);
								}
							}
						}
					}
					conn.close();
				} catch (ClassNotFoundException ex) {
					System.out.println("没有找到对应的数据库驱动类");
				} catch (SQLException ex) {
					System.out.println("数据库连接或者是数据库操作失败");
				}
			}
		});


		//重置清零
		bb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goodsName_input.setText("");
				staff_input.setText("");
				option1.setSelected(false);
				option2.setSelected(false);
			}
		});



		frame.setLayout(null);//自由布局
		goods_name.setBounds(30, 20, 100, 20);
		goodsName_input.setBounds(130, 20, 150, 25);
		j1.setBounds(10, 480, 450, 15);

		option1.setBounds(30, 120, 150, 20);
		option2.setBounds(30, 150, 150, 20);
		staff_id_name.setBounds(180, 120, 200, 30);
		staff_input.setBounds(180, 160, 100, 25);
		aa.setBounds(100, 420, 100, 30);
		bb.setBounds(300, 420, 100, 30);


		frame.add(aa);
		frame.add(bb);
		frame.add(goods_name);
		frame.add(goodsName_input);
		frame.add(staff_id_name);
		frame.add(staff_input);
		frame.add(option1);
		frame.add(option2);
		frame.add(j1);
	}
}
