package LibraryManagement;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import  java.sql.*;
import java.util.Objects;
import javax.swing.*;

public class Library extends JFrame
{
    //connection
    static Connection con;
    static ResultSet rs;
    static Statement st;
    private  String s;
    private static String driver;
    private static String url;
    private static String uname;
    private static String pass;

    JLabel l1,l2;
    JButton b1,b2,b3,b4,b5;
    JPanel p1,p2,p3;

    public Library()
    {
        super("Home Page");

        p1=new JPanel();
        p2=new JPanel();
        p3=new JPanel();
        p2.setBounds(100,20,450,60);
        p2.setBackground(Color.white);
        p3.setBounds(180,150,290,380);
        p3.setBackground(Color.white);

        Font f=new Font("arial",Font.BOLD,40);
        l1=new JLabel("Welcome to Library");
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setFont(f);
        p2.add(l1);

        //panel 3 --> add buttons
        b1=new JButton("Add Book ");
        b2=new JButton("Delete Book ");
        b3=new JButton("View Book List ");
        b4=new JButton("Issue Book to Student ");
        b5=new JButton("Return Book ");

        Font f1=new Font("arial",Font.BOLD,24);
        b1.setFont(f1);
        b2.setFont(f1);
        b3.setFont(f1);
        b4.setFont(f1);
        b5.setFont(f1);

        p3.setLayout(new GridLayout(5,1));
        p3.add(b1);
        p3.add(b2);
        p3.add(b3);
        p3.add(b4);
        p3.add(b5);
        //
        add(p1);
        add(p2);
        add(p3);
        //image add
        ImageIcon ic=new ImageIcon(ClassLoader.getSystemResource("LibraryManagement/pexels-eneida-nieves-964547.jpg"));
        Image img=ic.getImage().getScaledInstance(650,600,Image.SCALE_DEFAULT);
        ImageIcon ic1=new ImageIcon(img);
        l2=new JLabel(ic1);
        add(l2);
        //
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(650,600);
        setLocation(300,20);
        setVisible(true);




        ActionListener addBook=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // System.out.println("Book added successfully !!!");
                dispose();
                new AddBooks();

            }
        };
        ActionListener deleteBook=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Book deleted successfully !!!");
                dispose();
                new DeleteBook();
            }
        };
        ActionListener viewBook=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ViewBooks();
                System.out.println("Book viewed successfully !!!");
            }
        };
        ActionListener issueBook=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new IssueBook();
                System.out.println("Book issued successfully !!!");
            }
        };
        ActionListener returnBook=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ReturnBook();
                System.out.println("Book returned successfully !!!");
            }
        };
        b1.addActionListener(addBook);
        b2.addActionListener(deleteBook);
        b3.addActionListener(viewBook);
        b4.addActionListener(issueBook);
        b5.addActionListener(returnBook);

    }
    public static void connect()
    {
        driver="com.mysql.cj.jdbc.Driver";
        url="jdbc:mysql://localhost:3306/library";
        uname="root";
        pass="Sairaj242@";
        try{
            Class.forName(driver);
        }catch (ClassNotFoundException ex)
        {
            System.out.println(ex);
        }
        try {
            con = DriverManager.getConnection(url, uname, pass);
            st = con.createStatement();
        }
        catch (SQLException ex)
        {
            System.out.println(ex);
        }
    }

