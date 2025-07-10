package com.it.daxing;
import com.it.daxing.finish.add;
import com.it.daxing.finish.ImagePanel;
import com.it.daxing.finish.manager_login;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Vector;
import java.util.stream.Collectors;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class manager_frame extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private JComboBox<String> candidatebox;
    public manager_frame() {
        super("总管登录");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 800);
        this.setLocationRelativeTo(null);
        setVisible(true);


        Image img = Toolkit.getDefaultToolkit().getImage("src\\Image\\寻找熊出没仓库照片 (5).png");
        // 创建ImagePanel并添加到JFrame
        ImagePanel frame = new ImagePanel(img);
        this.add(frame);

		//单选框集合
		//以下查询都需要用到模糊查询！
		ButtonGroup group = new ButtonGroup();
		JRadioButton option1 = new TransparentRadioButton("负责人查询");
		option1.setBackground(new Color(0, 0, 0, 0)); // 设置背景为透明
		option1.setForeground(Color.black);

		JRadioButton option2 = new TransparentRadioButton("货品名查询");
		option2.setBackground(new Color(0, 0, 0, 0)); // 设置背景为透明
		option2.setForeground(Color.black);

		JRadioButton option3 = new TransparentRadioButton("仓库查询");
		option3.setBackground(new Color(0, 0, 0, 0)); // 设置背景为透明
		option3.setForeground(Color.black);

		JRadioButton option4 = new TransparentRadioButton("货架查询");
		option4.setBackground(new Color(0, 0, 0, 0)); // 设置背景为透明
		option4.setForeground(Color.black);

		group.add(option1);
		group.add(option2);
		group.add(option3);
		group.add(option4);



        //生成A窗体中的各种组件
        JButton component1 = new JButton("添加");
        component1.setBackground(Color.white);
        JButton component2 = new JButton("修改");
        component2.setBackground(Color.white);
        JButton component3 = new JButton("删除");
        component3.setBackground(Color.white);
        JButton component4 = new JButton("退出");//增删改退按钮
        component4.setBackground(Color.white);

        JLabel component5 = new JLabel("请输入内容:");
        component5.setFont(new Font("楷体", Font.PLAIN, 17));//设置字体的字体，样子，大小
        component5.setForeground(Color.white);
        JTextField component6 = new JTextField(20);//后面的输入框
        candidatebox = new JComboBox<>();



        JButton component7 = new JButton("查询");//查询按钮
        component7.setBackground(Color.cyan);
        JButton component8 = new JButton("全 部 信 息 展 示");
        component8.setBackground(new Color(152, 251, 152));
        component8.setFont(new Font("楷体", Font.BOLD, 17));
        JButton component9 = new JButton("<html><body>查询所有未管理仓库</body></html>");
        component9.setBackground(new Color(152, 251, 152));
        component9.setFont(new Font("楷体", Font.BOLD, 17));

        frame.setLayout(null);//自由布局
        component1.setBounds(500, 20, 70, 30);
        component2.setBounds(580, 20, 70, 30);
        component3.setBounds(500, 90, 70, 30);
        component4.setBounds(580, 90, 70, 30);

        component5.setBounds(20, 30, 500, 25);
        component6.setBounds(150, 30, 200, 25);
        candidatebox.setBounds(150,60,200,25);

        component7.setBounds(375, 30, 60, 30);
		option1.setBounds(140,100,100,20);
		option2.setBounds(140,125,100,20);
		option3.setBounds(280,100,100,20);
		option4.setBounds(280,125,100,20);
        component8.setBounds(140, 150, 210, 30);
        component9.setBounds(140,190,210,30);


        //把所有组件加入窗体对象中去
        frame.add(component1);
        frame.add(component2);
        frame.add(component3);
        frame.add(component4);
        frame.add(component5);
        frame.add(component6);
        frame.add(component7);
        frame.add(component8);
        frame.add(component9);
		frame.add(option1);
		frame.add(option2);
		frame.add(option3);
		frame.add(option4);
        frame.add(candidatebox);

        //四个表格
        String[][] datas = {};
        String[] titles = {"负责人工号", "姓名", "电话", "密码"};        //"学号", "姓名","性别","年龄","专业"
        String[][] datas1 = {};
        String[] titles1 = {"仓库号", "仓库名", "位置"};  //"课程号", "课程名","学分"
        String[][] datas2 = {};
        String[] titles2 = {"货架号", "商品名"};                    //"学号", "课程号","成绩","等级"
        String[][] datas3 = {};
        String[] titles3 = {"商品名", "数量"};                        //"账号", "密码","学号","电话号码"};

        DefaultTableModel myModel = new DefaultTableModel(datas, titles);// myModel存放表格的数据
        DefaultTableModel myModel1 = new DefaultTableModel(datas1, titles1);
        DefaultTableModel myModel2 = new DefaultTableModel(datas2, titles2);
        DefaultTableModel myModel3 = new DefaultTableModel(datas3, titles3);

        JTable table = new JTable(myModel);// 表格对象table的数据来源是myModel对象
        JTable table1 = new JTable(myModel1);
        JTable table2 = new JTable(myModel2);
        JTable table3 = new JTable(myModel3);

        table.setPreferredScrollableViewportSize(new Dimension(600, 100));// 表格的显示尺寸
        table1.setPreferredScrollableViewportSize(new Dimension(600, 100));
        table2.setPreferredScrollableViewportSize(new Dimension(600, 100));
        table3.setPreferredScrollableViewportSize(new Dimension(600, 100));

        // 产生一个带滚动条的面板
        JScrollPane scrollPane = new JScrollPane(table);
        JScrollPane scrollPane1 = new JScrollPane(table1);
        JScrollPane scrollPane2 = new JScrollPane(table2);
        JScrollPane scrollPane3 = new JScrollPane(table3);

        //表格的位置
        scrollPane3.setBounds(100, 230, 600, 120);
        scrollPane.setBounds(100, 360, 600, 120);
        scrollPane1.setBounds(100, 490, 600, 120);
        scrollPane2.setBounds(100, 620, 600, 120);

        // 将带滚动条的面板添加入B窗口中
        frame.setLayout(null);//自由布局
        frame.add(scrollPane);
        frame.add(scrollPane1);
        frame.add(scrollPane2);
        frame.add(scrollPane3);
        //增
        component1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new add();
            }
        });
        //改
        component2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new update();
            }
        });
        //删
        component3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new delete();
            }
        });
        //退出登录
        component4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new manager_login();
                closeThis();
            }
        });


        component6.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                String  query  =  component6.getText().trim();
                //先清除掉原本候选框里的内容
                candidatebox.removeAllItems();
                if  (query.isEmpty())  {
                    candidatebox.setVisible(false);
                }else  {
                    try  {
                        candidatebox.setVisible(true);
                        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                        String  url  =  "jdbc:sqlserver://localhost:1433;DatabaseName=stash;trustServerCertificate=true;";
                        String  user =  "sa3";  //  sa超级管理员
                        String  password  =  "123456";  //  密码
                        Connection  conn  =  DriverManager.getConnection(url,  user,  password);
                        Statement  st  =  conn.createStatement();

                        if (option1.isSelected()) {
                            /*String L = "select * from staff where staff.Pname like '%"+query+"%'";
                            ResultSet rs = st.executeQuery(L);
                            boolean flag = rs.next();
                            boolean flag0 = flag;
                            String L1 = "select * from staff where staff.Pid like '%"+query+"%'";
                            ResultSet rs1 = st.executeQuery(L1); // 在这里创建新的结果集对象
                            boolean flag1 = rs1.next();

                            if (flag0 == true){
                                while (flag) {
                                    candidatebox.addItem(rs.getString(2));
                                    flag = rs.next();
                                }
                                rs.close();
                            }
                            else if (flag0 == false){
                                while (flag1) {
                                    candidatebox.addItem(rs1.getString(1));
                                    flag1 = rs1.next();
                                }
                                rs1.close();
                            }*/
//                          报错原因分析：ResultSet rs = stmt.executeQuery(sql);
//
//                          当让stmt来返回一个结果集的时候，前面一个ResultSet会自动关闭。
//
//                          即在执行stmt.executeQuery的时候，会自动关闭上一次stmt.executeQuery的结果集。
//
//                          所以，我们用：
//
//                          ResultSet rs = stmt.executeQuery(sql);
//                          while(){……}
//
//                          rs2 = stmt.executeQuery(sql2);
//
//                          while(){……}
//
//                          rs3 =  stmt.executeQuery(sql3);
//
//                          while(){……}
//
//                            是没有问题的，因为我们在用下一个结果集的时候，没再去前一个中拿数据。
//                            原文链接：https://blog.csdn.net/axiaositong/article/details/114825295

                            /*正确代码如下*/
                            String L = "select * from staff where staff.Pname like '%"+query+"%'";
                            ResultSet rs = st.executeQuery(L);
                            boolean flag = rs.next();

                            if (flag == true){
                                while (flag) {
                                    candidatebox.addItem(rs.getString(2));
                                    flag = rs.next();
                                }
                                rs.close(); // 在这里关闭结果集
                            }
                            else {
                                String L1 = "select * from staff where staff.Pid like '%"+query+"%'";
                                ResultSet rs1 = st.executeQuery(L1); // 在这里创建新的结果集对象
                                boolean flag1 = rs1.next();

                                while (flag1) {
                                    candidatebox.addItem(rs1.getString(1));
                                    flag1 = rs1.next();
                                }
                                rs1.close(); // 在这里关闭结果集
                            }

                        }
                        else if (option2.isSelected()) {
                            String L = "select * from cargo where Sname like '%"+query+"%'";
                            ResultSet rs = st.executeQuery(L);
                            while (rs.next()) {
                                candidatebox.addItem(rs.getString(1));
                            }
                        }
                        else if (option3.isSelected()) {
                            String L = " select * from stash where (Cid like '%"+query+"%' or Cname like '%"+query+"%')";
                            ResultSet rs = st.executeQuery(L);
                            while (rs.next()) {
                                candidatebox.addItem(rs.getString(1));
                            }
                        }
                        else if (option4.isSelected()) {
                            String L = "select * from shelf where shelf.Hid like '%"+query+"%'";
                            ResultSet rs = st.executeQuery(L);
                            while (rs.next()) {
                                candidatebox.addItem(rs.getString(1));
                            }
                        }

                    }  catch  (SQLException  ex)  {
                        ex.printStackTrace();
                    }  catch  (ClassNotFoundException  ex)  {
                        throw  new  RuntimeException(ex);
                    }
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        candidatebox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (candidatebox.getItemCount() != 0){
                    String selectedValue = candidatebox.getSelectedItem().toString();
                    component6.setText(selectedValue);
                }else {
                    System.out.println("已经没有内容啦！123");
                }
            }
        });

        //当按下“查询”按钮
        component7.addActionListener(new ActionListener() {
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

                    while (myModel.getRowCount() > 0) {
                        myModel.removeRow(myModel.getRowCount() - 1);
                    }
                    while (myModel1.getRowCount() > 0) {
                        myModel1.removeRow(myModel1.getRowCount() - 1);
                    }
                    while (myModel2.getRowCount() > 0) {
                        myModel2.removeRow(myModel2.getRowCount() - 1);
                    }
                    while (myModel3.getRowCount() > 0) {
                        myModel3.removeRow(myModel3.getRowCount() - 1);
                    }//清空表上的东西

                    String ID = component6.getText().trim();

                    if (ID.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "请输入内容~", "提示消息", JOptionPane.WARNING_MESSAGE);
                    }
                    else if (option1.isSelected()) {
                        //当选择“负责人查询”时：
                        String s = "(Select * from dbo.staff, dbo.supervise, dbo.stash where (staff.Pid='" + ID + "' OR staff.Pname='" + ID + "') And staff.Pid = supervise.Pid And supervise.Cid = stash.Cid)";
                        ResultSet r = st.executeQuery(s);
                        boolean flag1 = true;
                        boolean determine = r.next();
                        if (determine == false) {
                            JOptionPane.showMessageDialog(null, "输入错误/未查询到负责人信息，请检查后输入！", "错误消息", JOptionPane.ERROR_MESSAGE);
                        }
                        else {
                            while (determine) {
                                if (flag1) {
                                    Vector<String> ve = new Vector<String>();
                                    ve.addElement(r.getString(1));
                                    ve.addElement(r.getString(2));
                                    ve.addElement(r.getString(3));
                                    ve.addElement(r.getString(4));
                                    myModel.addRow(ve);
                                    flag1 = false;
                                }
                                Vector<String> ve1 = new Vector<String>();
                                ve1.addElement(r.getString(7));
                                ve1.addElement(r.getString(8));
                                ve1.addElement(r.getString(9));
                                myModel1.addRow(ve1);
                                determine = r.next();
                            }

                            String strSQL = "select * from staff where Pid = '" + ID + "' or Pname = '" + ID + "'";
                            ResultSet rs = st.executeQuery(strSQL);
                            rs.next();
                            String ID1 = rs.getString(1);
                            String createViewSql = "select Hid,cargo.Sname,Snum from cargo join(select Hid,shelf.Sname,stash.Cid from stash,shelf,supervise where supervise.Pid = '" + ID1 + "' and stash.Cid = shelf.Cid and supervise.Cid = stash.Cid)temp1 on temp1.Sname = cargo.Sname";
                            ResultSet r1 = st.executeQuery(createViewSql);
                            while (r1.next()) {
                                Vector<String> ve1 = new Vector<String>();
                                ve1.addElement(r1.getString(1));
                                ve1.addElement(r1.getString(2));
                                myModel2.addRow(ve1);

                                Vector<String> ve2 = new Vector<String>();
                                ve2.addElement(r1.getString(2));
                                ve2.addElement(r1.getString(3));
                                myModel3.addRow(ve2);
                            }
                        }
                    }
                    else if (option2.isSelected()) {
                        String strSQL = "select * from cargo,shelf,staff,supervise,stash where cargo.Sname = shelf.Sname and shelf.Cid = stash.Cid and stash.Cid = supervise.Cid and supervise.Pid = staff.Pid and cargo.Sname = '" + ID + "'";
                        ResultSet rs = st.executeQuery(strSQL);

                        boolean determine = rs.next();
                        if (determine == false) {
                            JOptionPane.showMessageDialog(null, "输入错误/未查询到货品信息，请检查！", "错误消息", JOptionPane.ERROR_MESSAGE);
                        }
                        else {
                            while (determine) {

                                Vector<String> ve = new Vector<String>();
                                ve.addElement(rs.getString(6));
                                ve.addElement(rs.getString(7));
                                ve.addElement(rs.getString(8));
                                ve.addElement(rs.getString(9));
                                myModel.addRow(ve);

                                Vector<String> ve1 = new Vector<String>();
                                ve1.addElement(rs.getString(12));
                                ve1.addElement(rs.getString(13));
                                ve1.addElement(rs.getString(14));
                                myModel1.addRow(ve1);

                                Vector<String> ve2 = new Vector<String>();
                                ve2.addElement(rs.getString(3));
                                ve2.addElement(rs.getString(5));
                                myModel2.addRow(ve2);

                                Vector<String> ve3 = new Vector<String>();
                                ve3.addElement(rs.getString(1));
                                ve3.addElement(rs.getString(2));
                                myModel3.addRow(ve3);

                                determine = rs.next();
                            }
                        }

                    }
                    else if (option3.isSelected()) {
                        String s = "select * from cargo,shelf,staff,supervise,stash where cargo.Sname = shelf.Sname and shelf.Cid = stash.Cid and stash.Cid = supervise.Cid and supervise.Pid = staff.Pid and (stash.Cid = '" + ID + "' or stash.Cname = '" + ID + "')";
                        ResultSet r = st.executeQuery(s);
                        boolean flag1 = true;

                        boolean determine = r.next();
                        if (determine == false) {

                            //仓库有可能是没人管理的
                            String s1 = "select * from cargo,shelf,stash where cargo.Sname = shelf.Sname and shelf.Cid = stash.Cid and stash.Cid = '"+ID+"'";
                            ResultSet r1 = st.executeQuery(s1);
                            boolean flag11 = true;

                            boolean determine1 = r1.next();
                            if (determine1) {
                                while (determine1){
                                    if (flag11){
                                        Vector<String> ve1 = new Vector<String>();
                                        ve1.addElement(r1.getString(6));
                                        ve1.addElement(r1.getString(7));
                                        ve1.addElement(r1.getString(8));
                                        myModel1.addRow(ve1);
                                        flag11 = false;
                                    }
                                    Vector<String> ve2 = new Vector<String>();
                                    ve2.addElement(r1.getString(3));
                                    ve2.addElement(r1.getString(5));
                                    myModel2.addRow(ve2);

                                    Vector<String> ve3 = new Vector<String>();
                                    ve3.addElement(r1.getString(1));
                                    ve3.addElement(r1.getString(2));
                                    myModel3.addRow(ve3);
                                    determine1 = r1.next();

                                }
                            }
                            else {
                                JOptionPane.showMessageDialog(null, "输入错误/未查询到仓库信息，请检查后输入！", "错误消息", JOptionPane.ERROR_MESSAGE);
                            }

                        }
                        else {
                            while (determine) {
                                if (flag1) {
                                    Vector<String> ve = new Vector<String>();
                                    ve.addElement(r.getString(6));
                                    ve.addElement(r.getString(7));
                                    ve.addElement(r.getString(8));
                                    ve.addElement(r.getString(9));
                                    myModel.addRow(ve);

                                    Vector<String> ve1 = new Vector<String>();
                                    ve1.addElement(r.getString(12));
                                    ve1.addElement(r.getString(13));
                                    ve1.addElement(r.getString(14));
                                    myModel1.addRow(ve1);
                                    flag1 = false;
                                }

                                Vector<String> ve2 = new Vector<String>();
                                ve2.addElement(r.getString(3));
                                ve2.addElement(r.getString(5));
                                myModel2.addRow(ve2);

                                Vector<String> ve3 = new Vector<String>();
                                ve3.addElement(r.getString(1));
                                ve3.addElement(r.getString(2));
                                myModel3.addRow(ve3);

                                determine = r.next();
                            }
                        }


                    }
                    else if (option4.isSelected()) {
                        String strSQL = "select * from cargo,shelf,staff,supervise,stash where cargo.Sname = shelf.Sname and shelf.Cid = stash.Cid and stash.Cid = supervise.Cid and supervise.Pid = staff.Pid and shelf.Hid = '" + ID + "'";
                        ResultSet rs = st.executeQuery(strSQL);

                        boolean determine = rs.next();
                        if (determine == false) {
                            JOptionPane.showMessageDialog(null, "未查询到货架！", "错误消息", JOptionPane.ERROR_MESSAGE);
                        }
                        else {
                            while (determine) {

                                Vector<String> ve = new Vector<String>();
                                ve.addElement(rs.getString(6));
                                ve.addElement(rs.getString(7));
                                ve.addElement(rs.getString(8));
                                ve.addElement(rs.getString(9));
                                myModel.addRow(ve);

                                Vector<String> ve1 = new Vector<String>();
                                ve1.addElement(rs.getString(12));
                                ve1.addElement(rs.getString(13));
                                ve1.addElement(rs.getString(14));
                                myModel1.addRow(ve1);

                                Vector<String> ve2 = new Vector<String>();
                                ve2.addElement(rs.getString(3));
                                ve2.addElement(rs.getString(5));
                                myModel2.addRow(ve2);

                                Vector<String> ve3 = new Vector<String>();
                                ve3.addElement(rs.getString(1));
                                ve3.addElement(rs.getString(2));
                                myModel3.addRow(ve3);

                                determine = rs.next();
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

        //当按下 “查询所有信息时”
        component8.addActionListener(new ActionListener() {
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

                    while (myModel.getRowCount() > 0) {
                        myModel.removeRow(myModel.getRowCount() - 1);
                    }

                    while (myModel1.getRowCount() > 0) {
                        myModel1.removeRow(myModel1.getRowCount() - 1);
                    }

                    while (myModel2.getRowCount() > 0) {
                        myModel2.removeRow(myModel2.getRowCount() - 1);
                    }
                    while (myModel3.getRowCount() > 0) {
                        myModel3.removeRow(myModel3.getRowCount() - 1);
                    }


                    String strSQL = "(Select * from  dbo.staff)";
                    ResultSet rs = st.executeQuery(strSQL);
                    while (rs.next()) {
                        Vector<String> v = new Vector<String>();
                        v.addElement(rs.getString(1));
                        v.addElement(rs.getString(2));
                        v.addElement(rs.getString(3));
                        v.addElement(rs.getString(4));
                        myModel.addRow(v);
                    }
                    String strSQL1 = "(Select * from  dbo.stash)";
                    ResultSet rs1 = st.executeQuery(strSQL1);
                    while (rs1.next()) {
                        Vector<String> v1 = new Vector<String>();
                        v1.addElement(rs1.getString(1));
                        v1.addElement(rs1.getString(2));
                        v1.addElement(rs1.getString(3));
                        myModel1.addRow(v1);
                    }
                    String strSQL2 = "(Select * from  dbo.shelf)";
                    ResultSet rs2 = st.executeQuery(strSQL2);
                    while (rs2.next()) {
                        Vector<String> v2 = new Vector<String>();
                        v2.addElement(rs2.getString(1));
                        v2.addElement(rs2.getString(3));
                        myModel2.addRow(v2);
                    }
                    String strSQL3 = "(Select * from  dbo.cargo)";
                    ResultSet rs3 = st.executeQuery(strSQL3);
                    while (rs3.next()) {
                        Vector<String> v3 = new Vector<String>();
                        v3.addElement(rs3.getString(1));
                        v3.addElement(rs3.getString(2));
                        myModel3.addRow(v3);
                    }
                    conn.close();
                } catch (ClassNotFoundException ex) {
                    System.out.println("没有找到对应的数据库驱动类");
                } catch (SQLException ex) {
                    System.out.println("数据库连接或者是数据库操作失败");
                }
            }

        });

        component9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
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

                    String result = "";
                    String result1 = "";
                    StringBuilder sb = new StringBuilder();


                    while (myModel.getRowCount() > 0) {
                        myModel.removeRow(myModel.getRowCount() - 1);
                    }

                    while (myModel1.getRowCount() > 0) {
                        myModel1.removeRow(myModel1.getRowCount() - 1);
                    }

                    while (myModel2.getRowCount() > 0) {
                        myModel2.removeRow(myModel2.getRowCount() - 1);
                    }
                    while (myModel3.getRowCount() > 0) {
                        myModel3.removeRow(myModel3.getRowCount() - 1);
                    }

                    String s = "select * from cargo,shelf,staff,supervise,stash where cargo.Sname = shelf.Sname and shelf.Cid = stash.Cid and stash.Cid = supervise.Cid and supervise.Pid = staff.Pid order by stash.Cid";
                    ResultSet r = st.executeQuery(s);
                    //可以查询出已经绑定负责人的仓库，那么我们就可以通过排除法来获得没有绑定负责人的仓库。
                    while (r.next()) {
                        result += r.getString(4).trim() + " ";
                    }
                    String collect = Arrays.stream(result.split(" ")).distinct().collect(Collectors.joining(" "));
                    System.out.println(collect);
                    String[] str = collect.split(" ");


                    String s1 = "select * from cargo,shelf,stash where cargo.Sname = shelf.Sname and shelf.Cid = stash.Cid order by stash.Cid";
                    ResultSet r1 = st.executeQuery(s1);
                    while (r1.next()){
                        result1 += r1.getString(4).trim() + " ";
                    }
                    String collect1 = Arrays.stream(result1.split(" ")).distinct().collect(Collectors.joining(" "));
                    System.out.println(collect1);
                    String[] str1 = collect1.split(" ");

                    for (int i = 0;i<str.length;i++){
                        String s_ = str[i];
                        if (!collect1.contains(s_)){
                            sb.append(s_ + "");
                        }
                    }

                    for (int i = 0;i<str1.length;i++){
                        String s_1 = str1[i];
                        if (!collect.contains(s_1)){
                            sb.append(s_1 + "");
                        }
                    }
                    String result2 = sb.substring(0, sb.length());
                    System.out.println(result2);
                    String[] str2 = result2.split("");

                    for (int i = 0;i<str2.length;i++){
                        System.out.println(str2.length);
                        if (result2.isEmpty()){
                            break;
                        }
                        String temp = str2[i]+str2[i+1]+str2[i+2];
                        i = i+2;
                        String query = "select * from cargo,shelf,stash where cargo.Sname = shelf.Sname and shelf.Cid = stash.Cid and stash.Cid = '"+temp+"'";
                        ResultSet rs = st.executeQuery(query);

                        boolean flag1 = true;
                        while (rs.next()){
                            if (flag1){
                                Vector<String> v = new Vector<String>();
                                v.addElement(rs.getString(6));
                                v.addElement(rs.getString(7));
                                v.addElement(rs.getString(8));
                                myModel1.addRow(v);
                                flag1 = false;
                            }

                            Vector<String> v2 = new Vector<String>();
                            v2.addElement(rs.getString(3));
                            v2.addElement(rs.getString(5));
                            myModel2.addRow(v2);

                            Vector<String> v3 = new Vector<String>();
                            v3.addElement(rs.getString(1));
                            v3.addElement(rs.getString(2));
                            myModel3.addRow(v3);
                        }
                    }

                    conn.close();
                }catch (ClassNotFoundException ex) {
                    System.out.println("没有找到对应的数据库驱动类");
                } catch (SQLException ex) {
                    System.out.println("数据库连接或者是数据库操作失败");
                }
            }
        });
    }

    public void closeThis()//关闭当前界面
    {
        this.dispose();
    }

}