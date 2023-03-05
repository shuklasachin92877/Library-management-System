package LibraryManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import  java.sql.*;
import java.util.Objects;

public class IssueBook extends JFrame{

    JLabel l1,l2,l3,l4,l5,l6;
    JTextField t1,t2,t3,t4;
    JButton b1,b2;
    JPanel p1,p2,p3;
    public IssueBook()
    {
        super("Issue Book Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(650,600);
        setLocation(300,20);
        setVisible(true);

        p1=new JPanel();
        p2=new JPanel();
        p3=new JPanel();


        Font f=new Font("arial",Font.BOLD,40);
        l1=new JLabel("Issue Book");
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setFont(f);
        p1.add(l1);
        p1.setBounds(100,20,450,60);
        p1.setBackground(Color.white);

        p2.setBounds(100,200,450,200);
        p3.setBounds(100,450,450,50);

        //panel 2 -->
        l2=new JLabel("Book ID");
        l3=new JLabel("Student ID");
        l4=new JLabel("Student Name");
        l5=new JLabel("Date");
        t1=new JTextField();
        t2=new JTextField();
        t3=new JTextField();
        t4=new JTextField();
        Font f1=new Font("arial",Font.BOLD,24);

        l2.setFont(f1);
        l3.setFont(f1);
        l4.setFont(f1);
        l5.setFont(f1);
        t1.setFont(f1);
        t2.setFont(f1);
        t3.setFont(f1);
        t4.setFont(f1);

        //set layout
        p2.setLayout(new GridLayout(4,2));
        p2.add(l2);
        p2.add(t1);
        p2.add(l3);
        p2.add(t2);
        p2.add(l4);
        p2.add(t3);
        p2.add(l5);
        p2.add(t4);
        //
        b1=new JButton("Submit");
        b2=new JButton("Back");
        b1.setFont(f1);
        b2.setFont(f1);
        //
        p3.setLayout(new GridLayout(1,2));
        p3.add(b1);
        p3.add(b2);
        //
        add(p1);
        add(p2);
        add(p3);
        //image add
        ImageIcon ic=new ImageIcon(ClassLoader.getSystemResource("LibraryManagement/pexels-eneida-nieves-964547.jpg"));
        Image img=ic.getImage().getScaledInstance(650,600,Image.SCALE_DEFAULT);
        ImageIcon ic1=new ImageIcon(img);
        l6=new JLabel(ic1);
        add(l6);
        //

        ActionListener issue=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Book issued !!!");
            }
        };
        ActionListener back=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Library();
                System.out.println(" back issue page !!");
            }
        };
        b1.addActionListener(issue);
        b2.addActionListener(back);
    }

