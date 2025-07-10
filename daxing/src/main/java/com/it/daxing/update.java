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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class update extends JFrame {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public update() {
        super("修改信息");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(500, 550);
        this.setLocationRelativeTo(null);
        setVisible(true);

        Image img = Toolkit.getDefaultToolkit().getImage("D:\\新建文件夹\\update.png");
        // 创建ImagePanel并添加到JFrame
        ImagePanel frame = new ImagePanel(img);
        this.add(frame);

        JLabel j = new JLabel("负责人ID:");
        j.setFont(new Font("楷体", Font.PLAIN, 20));//设置字体的字体，样子，大小
        j.setForeground(Color.black);
        JLabel j1 = new JLabel("负责人姓名:");
        j1.setFont(new Font("楷体", Font.PLAIN, 20));
        j1.setForeground(Color.black);
        JLabel j2 = new JLabel("电话号码:");
        j2.setFont(new Font("楷体", Font.PLAIN, 20));
        j2.setForeground(Color.black);
        JLabel j3 = new JLabel("密码:");
        j3.setFont(new Font("楷体", Font.PLAIN, 20));
        j3.setForeground(Color.black);

        JLabel j4 = new JLabel("需要绑定的新仓库号:");
        j4.setFont(new Font("楷体", Font.PLAIN, 20));
        j4.setForeground(Color.black);

        JLabel j8 = new JLabel("(温馨提醒：所有信息请谨慎填写！)");
        j8.setFont(new Font("宋体", Font.PLAIN, 11));
        j8.setForeground(Color.black);

        JButton aa = new JButton("确定");
        aa.setFont(new Font("楷体", Font.PLAIN, 20));
        aa.setBackground(Color.GREEN);
        JButton bb = new JButton("重置");
        bb.setFont(new Font("楷体", Font.PLAIN, 20));
        bb.setBackground(Color.RED);

        JTextField c = new JTextField(15);
        JTextField c1 = new JTextField(15);
        JTextField c2 = new JTextField(15);
        JTextField c3 = new JTextField(15);

        JTextField c4 = new JTextField(15);

        aa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    String url = "jdbc:sqlserver://localhost:1433;DatabaseName=stash;trustServerCertificate=true;";
                    String user = "sa3";//sa超级管理员
                    String password = "123456";//密码
                    Connection conn = DriverManager.getConnection(url, user, password);
                    Statement st = conn.createStatement();


                    String a = c.getText().trim();
                    String a1 = c1.getText().trim();    //姓名
                    String a2 = c2.getText().trim();    //电话号码
                    String a3 = c3.getText().trim();    //密码

                    String a4 = c4.getText().trim();    //新绑定的仓库号

                    String s = "select * from staff where Pid = '" + a + "'";
                    ResultSet r = st.executeQuery(s);
                    boolean flag1 = false;
                    if (r.next()) {
                        if (a1 != null) {
                            String strSQL = "update staff set Pname = '" + a1 + "' where Pid = '" + a + "'";
                            int i4 = st.executeUpdate(strSQL);
                        }
                        if (a2 != null) {
                            String strSQL = "update staff set Pphonenumber = '" + a2 + "' where Pid = '" + a + "'";
                            int i5 = st.executeUpdate(strSQL);
                        }
                        if (a3 != null) {
                            String strSQL = "update staff set Ppassword = '" + a3 + "' where Pid = '" + a + "'";
                            int i6 = st.executeUpdate(strSQL);
                        }

                        if (!(a4.isEmpty())) {
                            try {
                                String strSQL = "insert into dbo.supervise(Pid,Cid) values ('" + a + "','" + a4 + "')";
                                int i7 = st.executeUpdate(strSQL);
                            }catch (SQLException ex) {
                                JOptionPane.showMessageDialog(null, "输入的需要绑定的仓库号有误/该仓库已经有负责人了!", "提示消息", JOptionPane.ERROR_MESSAGE);
                                flag1 = true;
                            }
                        } else if (a4.isEmpty()) {
                            System.out.println("负责人没有修改绑定的仓库");
                        }
                        if (a1.isEmpty() && a2.isEmpty() && a3.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "请务必完善姓名、电话号码或密码!");
                        } else if (flag1 == false){
                            JOptionPane.showMessageDialog(null, "修改成功!");
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "负责人工号不存在，请检查输入是否正确！");
                    }

                    conn.close();
                } catch (ClassNotFoundException ex) {
                    System.out.println("没有找到对应的数据库驱动类");
                } catch (SQLException ex) {
                    System.out.println("数据库连接或者是数据库操作失败123");
                }
            }
        });

        //重置清零
        bb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                c.setText("");
                c1.setText("");
                c2.setText("");
                c3.setText("");

                c4.setText("");
            }
        });

        frame.setLayout(null);//自由布局
        //一个字的大小是25
        j.setBounds(20, 30, 130, 20);
        c.setBounds(160, 30, 130, 25);
        j1.setBounds(20, 70, 130, 20);
        c1.setBounds(160, 70, 130, 25);
        j2.setBounds(20, 110, 130, 30);
        c2.setBounds(160, 110, 130, 25);
        j3.setBounds(20, 150, 130, 30);
        c3.setBounds(160, 150, 130, 25);
        j4.setBounds(20, 190, 200, 30);
        c4.setBounds(210, 190, 130, 25);

        aa.setBounds(100, 400, 100, 30);
        bb.setBounds(300, 400, 100, 30);

        j8.setBounds(10, 480, 450, 15);


        frame.add(j);
        frame.add(j1);
        frame.add(j2);
        frame.add(j3);
        frame.add(j4);
        frame.add(c);
        frame.add(c1);
        frame.add(c2);
        frame.add(c3);
        frame.add(c4);
        frame.add(aa);
        frame.add(bb);
        frame.add(j8);
    }

}