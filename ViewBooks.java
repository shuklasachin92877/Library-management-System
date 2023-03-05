package LibraryManagement;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import  java.sql.*;
import java.util.Objects;
import javax.swing.*;

public class ViewBooks extends JFrame
{

    JLabel l1,l2,l3,l4,l5,l6,label;
    JTextField t1,t2,t3,t4,t5;
    JButton b1;
    JPanel p1,p2,p3;

    public ViewBooks() {
        super("View Book Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900,660);
        setLocation(200,10);
        setVisible(true);

        p1=new JPanel();
        p2=new JPanel();
        p3=new JPanel();


        Font f=new Font("arial",Font.BOLD,40);
        l6=new JLabel("View Book List");
        l6.setHorizontalAlignment(JLabel.CENTER);
        l6.setFont(f);
        p1.add(l6);
        p1.setBounds(200,20,500,60);
        p1.setBackground(Color.white);

        p2.setBounds(70,130,760,40);
        p3.setBounds(400,580,100,50);

        //panel 2 -->
        l1=new JLabel("Book ID");
        l2=new JLabel("Title");
        l3=new JLabel("Author");
        l4=new JLabel("Status");
        l5=new JLabel("Quantity");

        t1=new JTextField();
        t2=new JTextField();
        t3=new JTextField();
        t4=new JTextField();
        t5=new JTextField();
        //font
        Font f1=new Font("arial",Font.BOLD,24);
        l1.setFont(f1);
        l2.setFont(f1);
        l3.setFont(f1);
        l4.setFont(f1);
        l5.setFont(f1);
        t1.setFont(f1);
        t2.setFont(f1);
        t3.setFont(f1);
        t4.setFont(f1);
        t5.setFont(f1);

        p2.setLayout(new GridLayout(1,5));
        p2.add(l1);
        p2.add(l2);
        p2.add(l3);
        p2.add(l4);
        p2.add(l5);

        //
        Font f2=new Font("arial",Font.BOLD,20);
        b1=new JButton("Back");
        b1.setFont(f2);
        p3.add(b1);

        //
        add(p1);
        add(p2);
        add(p3);
        //image add
        ImageIcon ic=new ImageIcon(ClassLoader.getSystemResource("LibraryManagement/pexels-eneida-nieves-964547.jpg"));
        Image img=ic.getImage().getScaledInstance(900,670,Image.SCALE_DEFAULT);
        ImageIcon ic1=new ImageIcon(img);
        label=new JLabel(ic1);
        add(label);

        //

        ActionListener back=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Library();
                System.out.println(" back view Page !!");
            }
        };

        b1.addActionListener(back);


    }

}
