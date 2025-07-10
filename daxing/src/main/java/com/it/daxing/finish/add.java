package com.it.daxing.finish;

import com.it.daxing.finish.ImagePanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class add extends JFrame{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public add() {
		super("添加货物");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(500,550);		
		this.setLocationRelativeTo(null);
		setVisible(true);

		Image img = Toolkit.getDefaultToolkit().getImage("D:\\新建文件夹\\add.png");
		// 创建ImagePanel并添加到JFrame
		ImagePanel frame = new ImagePanel(img);
	    this.add(frame);
	    
	    JLabel j=new JLabel("商品名:"); j.setFont(new Font("楷体",Font.PLAIN,20));j.setForeground(Color.black);
		JLabel j1=new JLabel("数量:");j1.setFont(new Font("楷体",Font.PLAIN,20));j1.setForeground(Color.black);
	    JLabel j2=new JLabel("仓库名:");j2.setFont(new Font("楷体",Font.PLAIN,20));j2.setForeground(Color.black);
	    JLabel j3=new JLabel("货架号:");j3.setFont(new Font("楷体",Font.PLAIN,20));j3.setForeground(Color.black);
	    
	    JLabel j8=new JLabel("(温馨提醒：要把信息填全哦！)");
		j8.setForeground(Color.white);
	    j8.setFont(new Font("宋体",Font.PLAIN,11));
	    
	    JButton aa=new JButton("确定");
	    aa.setFont(new Font("楷体",Font.PLAIN,20));
	    aa.setBackground(Color.GREEN);
	    JButton bb=new JButton("重置");
	    bb.setFont(new Font("楷体",Font.PLAIN,20));
	    bb.setBackground(Color.RED);
	    
	    JTextField c=new JTextField(15);//商品名
	    JTextField c1=new JTextField(15);//数量
		JTextField c2=new JTextField(15);//仓库名
	    JTextField c3=new JTextField(15);//货架号


	    
	    aa.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
            	try {
    				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					String url="jdbc:sqlserver://localhost:1433;DatabaseName=stash;trustServerCertificate=true;";
    				String user="sa3";//sa超级管理员
    				String password="123456";//密码
    				Connection conn=DriverManager.getConnection(url,user,password);
    				Statement st=conn.createStatement();
   
    				String goods_name=c.getText().trim();
					String goods_num=c1.getText().trim();
					String stash_name=c2.getText().trim();
					String shelf_id=c3.getText().trim();

 			
    				String  s="(Select * from dbo.cargo where Sname='"+goods_name+"')";
     				ResultSet r=st.executeQuery(s);
					if (goods_name.isEmpty()){
						JOptionPane.showMessageDialog(null, "请输入商品名~","提示消息",JOptionPane.WARNING_MESSAGE);
					}else {
						if(r.next())
						{
							JOptionPane.showMessageDialog(null, "该商品已存在,请勿重复添加~","提示消息",JOptionPane.WARNING_MESSAGE);
						}
						else
						{
							if (stash_name.isEmpty()){
								JOptionPane.showMessageDialog(null, "请输入仓库名~","提示消息",JOptionPane.WARNING_MESSAGE);
							}else {
								//商品验证通过后，接下来要验证货架号是否与给的仓库名匹配
								String  s4="select * from stash,shelf where Cname = '"+stash_name+"' and stash.Cid = shelf.Cid";
								ResultSet r1 = st.executeQuery(s4);
								//如果查询结果存在，说明输入的仓库名正确
								if(r1.next()){
									String s5 = r1.getString(4).trim();
									//如果输入的货架号的首字母与目标仓库里原有货架的首字母相同
									if(shelf_id.startsWith(String.valueOf(s5.charAt(0)))){
										//再判断输入的货架号是否已经有货物放置在上面了

										String  s6="select * from stash,shelf where stash.Cid = shelf.Cid";
										ResultSet r2 = st.executeQuery(s6);
										boolean r2_flag = r2.next();
										while (r2_flag){
											if(r2.getString(4).trim().equals(shelf_id)) {
												System.out.println(r2.getString(5));
												System.out.println(shelf_id);
												JOptionPane.showMessageDialog(null, "你输入的货架号在原仓库已经有了，换个试试？", "提示消息", JOptionPane.WARNING_MESSAGE);
												r2_flag = true;
												break;
											}
											r2_flag = r2.next();
										}
										if (r2_flag == false){
											//遍历完所有的货架号后，还需要根据输入的仓库名，筛选出仓库的ID
											String s7 = "select * from stash where Cname = '"+stash_name+"'";
											ResultSet r3 = st.executeQuery(s7);
											r3.next();
											//获取仓库ID
											String stash_id = r3.getString(1);
											String s8 = "insert into dbo.cargo(Sname,Snum) values('" + goods_name + "','" + goods_num + "')";
											int r4 = st.executeUpdate(s8);
											String s9 = "insert into dbo.shelf(Hid,Cid,Sname) values('"+shelf_id+"','"+stash_id+"','"+goods_name+"')";
											int r5 = st.executeUpdate(s9);
											JOptionPane.showMessageDialog(null, "添加成功!","成功消息",JOptionPane.WARNING_MESSAGE);
										}
									}else {
										JOptionPane.showMessageDialog(null, "你输入的货架号与仓库名不符!","提示消息",JOptionPane.WARNING_MESSAGE);
									}
								}else{
									JOptionPane.showMessageDialog(null, "你输入的仓库名有误，请检查后重新输入","提示消息",JOptionPane.WARNING_MESSAGE);
								}
							}
						}
					}
     				conn.close();
            	}catch (ClassNotFoundException ex) {
    				System.out.println("没有找到对应的数据库驱动类");
    			}
    			catch (SQLException ex) {
    				System.out.println("数据库连接或者是数据库操作失败");
    			}      	
            }
	    });
	        
	    //重置清零
	    bb.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
            	c.setText("");
            	c1.setText("");
            	c2.setText("");   	
				c3.setText("");
            }
	    });    
	    
	    frame.setLayout(null);//自由布局
	    j.setBounds(20, 30,  100, 20); c.setBounds(120, 30, 120, 25);
	    j1.setBounds(20, 70, 100, 20);c1.setBounds(120, 70, 100, 25);
	    j2.setBounds(20, 110, 100, 30);c2.setBounds(120, 110, 100, 25);
	    j3.setBounds(20, 150, 100, 30);c3.setBounds(120, 150, 100, 25);
	       
	    aa.setBounds(100, 400, 100, 30); bb.setBounds(300, 400, 100, 30);
	    j8.setBounds(10, 480, 450, 15);

		frame.add(j);
		frame.add(j1);
		frame.add(j2);
		frame.add(j3);
		frame.add(c);
		frame.add(c1);
		frame.add(c2);
		frame.add(c3);
		frame.add(aa);
		frame.add(bb);
		frame.add(j8);
    } 	
    } 