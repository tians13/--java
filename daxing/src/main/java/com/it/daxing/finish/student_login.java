package com.it.daxing.finish;
import com.it.daxing.VerificationCode;
import com.it.daxing.ZC;
import com.it.daxing.student_frame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
public class student_login extends JFrame {
    private static final long serialVersionUID = 1L;
    private VerificationCode vcode = new VerificationCode();
    JTextField co;
    public static JTextField user;
    JPasswordField pass;
    JButton ok,register;

    public student_login(){
        super("学生登陆");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(450,350);
        this.setLocationRelativeTo(null);
        setVisible(true);


        Image img = Toolkit.getDefaultToolkit().getImage("src\\Image\\寻找熊出没仓库照片 (2).png");
        // 创建ImagePanel并添加到JFrame
        ImagePanel frame = new ImagePanel(img);
        this.add(frame);

        //账号、密码所代表的图形
        Icon login = new ImageIcon("D:\\新建文件夹\\user.jpg");
        JLabel l= new JLabel();
        l.setIcon(login);
        Icon password = new ImageIcon("D:\\新建文件夹\\password.png");
        JLabel p= new JLabel();
        p.setIcon(password);

        JLabel code=new JLabel("验证码");
        code.setForeground(Color.white);
        code.setFont(new Font("楷体",Font.BOLD,17));

        user=new JTextField();
        pass=new JPasswordField();
        /*对密码进行MD5加密*//*
		Md5 md5=new Md5();

		String password_MD5 = pass.toString();
		password_MD5 = md5.EncoderByMd5(password_MD5);

		System.out.println(password_MD5);

		*/co=new JTextField();
        ok=new JButton("登录");
        ok.setContentAreaFilled(false);
        register=new JButton("注册");
        register.setContentAreaFilled(false);
        ok.setForeground(Color.white);
        register.setForeground(Color.white);


        l.setBounds(80, 50, 60, 40);
        p.setBounds(80, 100, 60, 40);
        code.setBounds(70, 150, 60, 40);
        user.setBounds(150, 50, 150, 30);
        pass.setBounds(150, 100, 150, 30);
        co.setBounds(150, 150, 150, 30);
        ok.setBounds(120, 220, 70, 30);
        register.setBounds(250, 220, 70, 30);
        vcode.setBounds(310, 145, 100, 40);


        frame.setLayout(null);
        frame.add(l);
        frame.add(p);
        frame.add(code);
        frame.add(user);
        frame.add(pass);
        frame.add(co);
        frame.add(ok);
        frame.add(register);
        frame.add(vcode);

        //按下 “注册”按钮时
        register.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                //跳转到注册界面
                new ZC();
                closeThis();
            }
        });
        //按下 “登录”按钮时
        ok.addActionListener(new ActionListener()
        {

            public void actionPerformed(ActionEvent e)
            {
                String jusername=user.getText();
                char s[]=pass.getPassword();
                String jpassword=new String(s);
                String coo=co.getText();

                try {
                    String user="sa3";//sa超级管理员
                    String password="123456";//密码
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    //加载对应的jdbc驱动
                    String url="jdbc:sqlserver://localhost:1433;DatabaseName=stash;trustServerCertificate=true;";
                    //配置连接字符串
                    Connection conn=DriverManager.getConnection(url,user,password);
                    //创建数据库连接对象
                    Statement st=conn.createStatement();
                    //创建SQL语句执行对象

					/*Md5 md5 = new Md5();
					String newString = md5.EncoderByMd5(jpassword);*/

                    String  strSQL="(Select * from  dbo.student where Qid='"+jusername+"'And Qpassword='"+jpassword+"' )";
                    ResultSet rs=st.executeQuery(strSQL);

                    if (coo.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "请输入验证码!", "提示消息", JOptionPane.WARNING_MESSAGE);
                    } else {
                        if (!isValidCodeRight()) {
                            JOptionPane.showMessageDialog(null, "验证码错误,请重新输入!", "提示消息", JOptionPane.WARNING_MESSAGE);
                        }
                        else {

                            if (rs.next()) {
                                System.out.println("成功进入窗口了111！\n");
                                new student_frame();
                                System.out.println("成功进入窗口了999！\n");
                                closeThis();
                            } else {
                                JOptionPane.showMessageDialog(null, "用户名不存在或密码错误", "错误!", JOptionPane.ERROR_MESSAGE);
                            }
                            conn.close();

                            //关闭数据库连接
                        }
                    }
                }
                catch (ClassNotFoundException ex) {
                    System.out.println("没有找到对应的数据库驱动类");
                }
                catch (SQLException ex) {
                    System.out.println("数据库连接或者是数据库操作失败11");
                }
            }
        });
    }
    public boolean isValidCodeRight() {

        if(co == null) {
            return false;
        }else if(vcode == null) {
            return true;
        }else if(vcode.getCode() .equals(co.getText())) {
            return true;
        }else
            return false;

    }


    public  void closeThis()//关闭当前界面
    {
        this.dispose();
    }

}


