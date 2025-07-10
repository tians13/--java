package com.it.daxing;

import com.it.daxing.finish.ImagePanel;
import com.it.daxing.finish.staff_login;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class staff_frame extends JFrame{
    /**
     *
     */

    private static final long serialVersionUID = 1L;
    JTabbedPane jtbp; //定义选项卡
    JPanel jp1,jp2,jp3;	//定义面板
    private JComboBox<String> candidatebox;
    public JDialog candidateDialog;

    public staff_frame() // throws SQLException, ClassNotFoundException
    {
        super("负责人登陆");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        setVisible(true);

        MenuBar bar = new MenuBar();// 创建菜单栏
        bar.setFont(new Font("楷体", Font.PLAIN, 30));
        Menu fileMenu = new Menu("FILE");// 创建“文件”菜单
        fileMenu.setFont(new Font("楷体", Font.PLAIN, 17));
        MenuItem open = new MenuItem("OPEN");
        MenuItem exit = new MenuItem("EXIT");
        Menu help = new Menu("HELP");// 创建“帮助"菜单
        help.setFont(new Font("楷体", Font.PLAIN, 17));
        MenuItem print = new MenuItem("PRINT");

        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("成功进入窗口了222！\n");
                new staff_login();
                System.out.println("成功进入窗口了333！\n");
                System.out.println();
                closeThis();
            }
        });

        fileMenu.add(print);
        fileMenu.add(open);
        fileMenu.addSeparator();// 设置菜单分隔符
        fileMenu.add(exit);
        bar.add(fileMenu);// 将文件添加到菜单栏上
        bar.add(help);// 将文件添加到菜单栏上
        setMenuBar(bar);// 设置菜单栏，使用这种方式设置菜单栏可以不占用布局空间

        //创建组件
        Image img = Toolkit.getDefaultToolkit().getImage("src\\Image\\寻找熊出没仓库照片 (6).png");
        // 创建ImagePanel并添加到JFrame
        jp1 = new ImagePanel(img);

        Image img1 = Toolkit.getDefaultToolkit().getImage("src\\Image\\寻找熊出没仓库照片 (5).png");
        // 创建ImagePanel并添加到JFrame
        jp2 = new ImagePanel(img1);

        Image img2 = Toolkit.getDefaultToolkit().getImage("D:\\新建文件夹\\er0h12pspo4.jpg");
        // 创建ImagePanel并添加到JFrame
        jp3 = new ImagePanel(img2);


        //jp1面板上上的内容
        String[][] datas = {};
        String[] titles = {"负责人工号","负责人姓名","电话号码","登录密码"};			//"学号", "姓名", "性别", "年龄", "专业"};
        String[][] datas1 = {};
        String[] titles1 = {"货架号","商品名","商品数量"};													//"课程号", "课程名", "学分"};

        DefaultTableModel myModel = new DefaultTableModel(datas, titles);// myModel存放表格的数据
        DefaultTableModel myModel1 = new DefaultTableModel(datas1, titles1);
        JTable table = new JTable(myModel);// 表格对象table的数据来源是myModel对象
        JTable table1 = new JTable(myModel1);
        table.setPreferredScrollableViewportSize(new Dimension(550, 100));// 表格的显示尺寸
        table1.setPreferredScrollableViewportSize(new Dimension(550, 100));
        // 产生一个带滚动条的面板
        JScrollPane scrollPane = new JScrollPane(table);
        JScrollPane scrollPane1 = new JScrollPane(table1);
        //行高
        table.setRowHeight(20);
        table1.setRowHeight(20);

        JLabel j1;
        JLabel j;
        JButton again;
        JButton again1;
        JScrollPane scrollPane2;
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

            //左侧菜单A 第一张表
            String strSQL = "(Select * from  dbo.staff where Pid='" + staff_login.user.getText() + "')";
            ResultSet rs = st.executeQuery(strSQL);
            if (rs.next()) {
                Vector<String> ve = new Vector<String>();
                ve.addElement(rs.getString(1));
                ve.addElement(rs.getString(2));
                ve.addElement(rs.getString(3));
                ve.addElement(rs.getString(4));
                myModel.addRow(ve);
            }

            //左侧菜单A 第二张表
            String s1 = "(Select * from dbo.staff,dbo.stash,dbo.supervise where staff.Pid='" + staff_login.user.getText() + "' And staff.Pid=supervise.Pid And supervise.Cid = stash.Cid)";
            ResultSet r1 = st.executeQuery(s1);
            if (r1.next()) {
                String s2 = "(Select * from dbo.shelf,dbo.stash,dbo.cargo,dbo.supervise where supervise.Pid='" + /*staff_login.user.getText()*/ r1.getString(8) + "' And stash.Cid=shelf.Cid AND shelf.Sname = cargo.Sname And stash.Cid = supervise.Cid)";
                //r1.getstring(7)代表的是获取上一次查询结束后的第7列数据
                ResultSet r2 = st.executeQuery(s2);
                while (r2.next()) {
                    Vector<String> ve1 = new Vector<String>();
                    ve1.addElement(r2.getString(1));
                    ve1.addElement(r2.getString(3));
                    ve1.addElement(r2.getString(8));
                    myModel1.addRow(ve1);
                }
            }

            again = new JButton("刷 新~");
            again.setForeground(Color.white);
            again.setContentAreaFilled(false);
            again.setFont(new Font("楷体", Font.BOLD, 14));
            //点击 “刷新” 按钮后，
            again.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                        String url = "jdbc:sqlserver://localhost:1433;DatabaseName=stash;trustServerCertificate=true;";
                        String user = "sa3";//sa超级管理员
                        String password = "123456";//密码
                        Connection conn = DriverManager.getConnection(url, user, password);
                        Statement st = conn.createStatement();

                        while(myModel1.getRowCount()>0)
                        {
                            System.out.println("去除了第" + myModel1.getRowCount() + "列");
                            myModel1.removeRow(myModel1.getRowCount()-1);
                        }
                        //左侧菜单A 第二张表 刷新
                        String s1 = "(Select * from dbo.staff,dbo.stash,dbo.supervise where staff.Pid='" + staff_login.user.getText() + "' And supervise.Cid = stash.Cid And supervise.Pid = staff.Pid)";
                        ResultSet r1 = st.executeQuery(s1);
                        if (r1.next()) {
                            String s2 = "(Select * from dbo.shelf,dbo.stash,dbo.cargo,dbo.supervise where supervise.Pid='" + r1.getString(8) + "' And stash.Cid=shelf.Cid AND shelf.Sname = cargo.Sname And supervise.Cid = stash.Cid)";
                            System.out.println(r1.getString(8));
                            //r1.getstring(7)代表的是获取上一次查询结束后的第7列数据，即s1的第7列的数据而不是s2的第7列数据！！     这个错误耗时很久！！！
                            ResultSet r2 = st.executeQuery(s2);
                            System.out.printf("正常33\n");
                            //System.out.println(String.valueOf(r2.next()));                                            这个错误耗时很久！！！  开始不知到r2.next()的用法，r2.next() 方法是将指针移动到结果集中的下一行。所以如果这行存在的话，那么下面的数据就会少一行。

                            //r2.next();
                            //System.out.println(r2.getString(8));                                                      这个错误也耗时很久！！！ 只有先调用了r2.next()，才能调用r2.getstring,因为在179行新建的r2默认指向的是表格第0行元素【数据从第1行元素出现，所以此时如果直接调用r2.next()会报错】

                            while (r2.next()) {
                                System.out.printf("正常55\n");
                                Vector<String> ve1 = new Vector<String>();
                                ve1.addElement(r2.getString(1));
                                ve1.addElement(r2.getString(3));
                                ve1.addElement(r2.getString(8));
                                myModel1.addRow(ve1);
                                System.out.printf("正常66\n");
                            }
                            conn.close();
                        }
                    } catch (ClassNotFoundException ex) {
                        System.out.println("没有找到对应的数据库驱动类");
                    } catch (SQLException ex) {
                        System.out.println("数据库连接或者是数据库操作失败22");
                    }
                }
            });

            //左侧菜单B
            String[][] datas2 = {};
            String[] titles2 = {"货架号","商品名","商品数量"};            //{"课程号", "课程名", "学分"};
            DefaultTableModel myModel2 = new DefaultTableModel(datas2, titles2);
            JTable table2 = new JTable(myModel2);
            table2.setRowHeight(20);
            table2.setPreferredScrollableViewportSize(new Dimension(550, 400));
            scrollPane2 = new JScrollPane(table2);
            String s2 = "(Select * from dbo.shelf,dbo.stash,dbo.cargo,dbo.supervise where supervise.Pid='"+staff_login.user.getText()+"' And stash.Cid=shelf.Cid AND shelf.Sname = cargo.Sname And supervise.Cid = stash.Cid)";
            ResultSet r2 = st.executeQuery(s2);
            while (r2.next()) {
                Vector<String> ve2 = new Vector<String>();
                ve2.addElement(r2.getString(1));
                ve2.addElement(r2.getString(3));
                ve2.addElement(r2.getString(8));
                myModel2.addRow(ve2);
            }
            again1 = new JButton("刷 新~");
            again1.setForeground(Color.white);
            again1.setContentAreaFilled(false);
            again1.setFont(new Font("楷体", Font.BOLD, 14));
            again1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                        String url = "jdbc:sqlserver://localhost:1433;DatabaseName=stash;trustServerCertificate=true;";
                        String user = "sa3";//sa超级管理员
                        String password = "123456";//密码
                        Connection conn = DriverManager.getConnection(url, user, password);
                        Statement st = conn.createStatement();

                        while(myModel2.getRowCount()>0)
                        {
                            myModel2.removeRow(myModel2.getRowCount()-1);
                        }

                        String s2 = "(Select * from dbo.shelf,dbo.stash,dbo.cargo,dbo.supervise where supervise.Pid='"+staff_login.user.getText()+"' And stash.Cid=shelf.Cid AND shelf.Sname = cargo.Sname And supervise.Cid = stash.Cid)";
                        ResultSet r2 = st.executeQuery(s2);

                        while (r2.next()) {
                            Vector<String> ve1 = new Vector<String>();
                            ve1.addElement(r2.getString(1));
                            ve1.addElement(r2.getString(3));
                            ve1.addElement(r2.getString(8));
                            myModel2.addRow(ve1);
                        }
                        conn.close();
                    } catch (ClassNotFoundException ex) {
                        System.out.println("没有找到对应的数据库驱动类");
                    } catch (SQLException ex) {
                        System.out.println("数据库连接或者是数据库操作失败22");
                    }
                }
            });
            conn.close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        JLabel goods_name = new JLabel("请输入需要修改的商品名:");
        goods_name.setForeground(Color.black);
        goods_name.setFont(new Font("楷体", Font.BOLD, 18));
        JLabel goods_num = new JLabel("请输入需要修改的数量(例:+50):");
        goods_num.setForeground(Color.black);
        goods_num.setFont(new Font("楷体", Font.BOLD, 18));

        // goods_name1用来接收用户输入的商品名
        JTextField goods_name1 = new JTextField(20);
        // goods_num1用来接收新增商品的数量
        JTextField goods_num1 = new JTextField(20);

        JButton c = new JButton("确定");
        //这里还需要判断是否输入内容！！
        c.setFont(new Font("楷体", Font.BOLD, 20));
        c.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    String url = "jdbc:sqlserver://localhost:1433;DatabaseName=stash;trustServerCertificate=true;";
                    String user = "sa3";//sa超级管理员
                    String password = "123456";//密码
                    Connection conn = DriverManager.getConnection(url, user, password);
                    Statement st = conn.createStatement();

                    //读取用户输入的 “商品名”
                    String ok = goods_name1.getText().trim();
                    //用户输入的 “商品数量”
                    String ok_num = goods_num1.getText().trim();
                    String ok_num1 = ok_num;


                    if (ok.isEmpty() && ok_num1.isEmpty()){
                        JOptionPane.showMessageDialog(null, "请完善信息！","提示消息",JOptionPane.WARNING_MESSAGE);
                    }else {
                        String s = "(Select * from dbo.shelf,dbo.stash,dbo.cargo,dbo.supervise where supervise.Pid='" + staff_login.user.getText() + "' And stash.Cid=shelf.Cid AND shelf.Sname = cargo.Sname AND supervise.Cid = stash.Cid AND shelf.Sname = '"+ok+"')";
                        ResultSet r = st.executeQuery(s);
                        if (r.next()) {
                            if (ok_num.isEmpty()){
                                JOptionPane.showMessageDialog(null, "请输入数量！","提示消息",JOptionPane.WARNING_MESSAGE);
                            }
                            else {
                                ok_num = ok_num.substring(1);
                                int number = Integer.parseInt(ok_num);
                                if(ok_num1.startsWith("+")){
                                    System.out.printf("这里显示正常11\n");
                                    String addSql = "UPDATE dbo.cargo SET Snum = Snum + '"+number+"' WHERE cargo.Sname = '"+ok+"'";
                                    /*String addSql = "(UPDATE dbo.cargo SET Snum = Snum + '"+number+"' WHERE cargo.Sname = '"+ok+"')";*/   //这个代码报错，错误原因为：()
                                    int i1 = st.executeUpdate(addSql);
                                    System.out.printf("这里显示正常22\n");
                                    if(i1 == 1){
                                        System.out.printf("这里显示正常33\n");

                                        JOptionPane.showMessageDialog(null, "添加成功","提示消息",JOptionPane.WARNING_MESSAGE);
                                    }

                                }else if(ok_num1.startsWith("-")){
                                    System.out.printf("这里显示正常44\n");
                                    String deleteSql = "UPDATE dbo.cargo SET Snum = Snum - '"+number+"' WHERE cargo.Sname = '"+ok+"'";
                                    int i2 = st.executeUpdate(deleteSql);
                                    if(i2 == 1){
                                        JOptionPane.showMessageDialog(null, "删除成功","提示消息",JOptionPane.WARNING_MESSAGE);
                                    }
                                }
                            }
                        }else
                        {
                            JOptionPane.showMessageDialog(null, "没有你说的商品","提示消息",JOptionPane.WARNING_MESSAGE);
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



        //左侧菜单C

        JLabel ja1 = new JLabel("你想查询的商品名：");
        ja1.setForeground(Color.black);
        JLabel ja2 = new JLabel("它的仓库名：");
        ja2.setForeground(Color.black);
        JLabel ja3 = new JLabel("它的货架号：");
        ja3.setForeground(Color.black);

        ja1.setFont(new Font("楷体", Font.BOLD, 20));
        ja2.setFont(new Font("楷体", Font.BOLD, 20));
        ja3.setFont(new Font("楷体", Font.BOLD, 20));

        JTextField input_1 = new JTextField(15);
        candidatebox = new JComboBox<>();

        JTextField output_1 = new JTextField(15);
        JTextField output_2 = new JTextField(15);
        JButton c1 = new JButton("查 询");

















        input_1.addKeyListener(new KeyListener() {
            @Override
            public  void  keyTyped(KeyEvent  e)  {
                String  query  =  input_1.getText().trim();
                //先清除掉原本候选框里的内容
                candidatebox.removeAllItems();
                if  (query.isEmpty())  {
                    candidatebox.setVisible(false);
                }  else  {
                    try  {
                        candidatebox.setVisible(true);
                        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                        String  url  =  "jdbc:sqlserver://localhost:1433;DatabaseName=stash;trustServerCertificate=true;";
                        String  user  =  "sa3";  //  sa超级管理员
                        String  password  =  "123456";  //  密码
                        Connection  conn  =  DriverManager.getConnection(url,  user,  password);
                        Statement  st  =  conn.createStatement();

                        String  L  =  "(select  *  from  shelf,stash,cargo,supervise  where  supervise.Pid  =  '"  +  staff_login.user.getText()  +  "'  and  supervise.Cid  =  stash.Cid  and  stash.Cid  =  shelf.Cid  and  shelf.Sname  =  cargo.Sname  and  cargo.Sname  LIKE  '%"  +  query  +  "%')";
                        ResultSet  rs  =  st.executeQuery(L);

                        while  (rs.next())  {
                            candidatebox.addItem(rs.getString(7));
                        }

                    }  catch  (SQLException  ex)  {
                        ex.printStackTrace();
                    }  catch  (ClassNotFoundException  ex)  {
                        throw  new  RuntimeException(ex);
                    }
                }
            }

//  其他方法的实现可以保持不变


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
                    input_1.setText(selectedValue);
                }else {
                    System.out.println("已经没有内容啦！");
                }
            }
        });



        c1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    String url = "jdbc:sqlserver://localhost:1433;DatabaseName=stash;trustServerCertificate=true;";
                    String user = "sa3";//sa超级管理员
                    String password = "123456";//密码
                    Connection conn = DriverManager.getConnection(url, user, password);
                    Statement st = conn.createStatement();

                    String B1 = input_1.getText().trim();


                    String L = "(select * from shelf,stash,cargo,supervise where supervise.Pid = '"+staff_login.user.getText()+"' and supervise.Cid = stash.Cid and stash.Cid = shelf.Cid and shelf.Sname = cargo.Sname and cargo.Sname = '"+B1+"' )";
                    ResultSet M = st.executeQuery(L);
                    if (M.next()) {
                        System.out.printf("正常111\n");
                        output_1.setText(M.getString(5));
                        output_2.setText(M.getString(1));
                    } else {
                        JOptionPane.showMessageDialog(null, "没有该商品，请联系总管添加", "提示消息", JOptionPane.WARNING_MESSAGE);
                    }
                    conn.close();

                } catch (ClassNotFoundException ex) {
                    System.out.println("没有找到对应的数据库驱动类");
                } catch (SQLException ex) {
                    System.out.println("数据库连接或者是数据库操作失败");
                }
            }
        });

        jp1.setLayout(null);//自由布局
        jp2.setLayout(null);//自由布局
        jp3.setLayout(null);//自由布局

        //jp1中组件的位置
        scrollPane.setBounds(50, 90, 550, 70);
        scrollPane1.setBounds(50, 190, 550, 100);
        again.setBounds(490, 40, 80, 30);


        //jp2中组件的位置
        scrollPane2.setBounds(50, 20, 550, 250);

        goods_name.setBounds(20, 300, 250, 30);
        goods_name1.setBounds(50, 350, 150, 25);

        goods_num.setBounds(300, 300, 300, 30);
        goods_num1.setBounds(300, 350, 300, 25);

        again1.setBounds(100, 400, 80, 30);
        c.setBounds(500, 400, 80, 27);


        //jp3中组件的位置
        ja1.setBounds(50, 50, 200, 30);
        ja2.setBounds(80, 220, 150, 30);
        ja3.setBounds(80, 270, 150, 30);

        input_1.setBounds(260, 50, 150, 25);
        output_1.setBounds(260, 220, 100, 25);
        output_2.setBounds(260, 270, 100, 25);
        c1.setBounds(450, 50, 70, 30);
        candidatebox.setBounds(260,80,150,25);




        // 将组件添加入jp1窗口中
        jp1.add(scrollPane);
        jp1.add(scrollPane1);
        jp1.add(again);

        // 将组件添加入jp2窗口中
        jp2.add(scrollPane2);
        jp2.add(goods_name);
        jp2.add(goods_name1);
        jp2.add(goods_num);
        jp2.add(goods_num1);
        jp2.add(again1);
        jp2.add(c);

        // 将组件添加入jp3窗口中
        jp3.add(ja1);
        jp3.add(ja2);
        jp3.add(ja3);

        jp3.add(input_1);
        jp3.add(output_1);
        jp3.add(output_2);
        jp3.add(c1);
        jp3.add(candidatebox);

        jtbp = new JTabbedPane(JTabbedPane.LEFT); //创建选项卡并使选项卡垂直排列
        jtbp.add("个人信息", jp1);
        jtbp.add("进、出货", jp2);
        jtbp.add("货品查询", jp3);
        jtbp.setFont(new Font("楷体", Font.PLAIN, 30));
        this.add(jtbp);
    }

    public  void closeThis()//关闭当前界面
    {
        this.dispose();
    }
}
