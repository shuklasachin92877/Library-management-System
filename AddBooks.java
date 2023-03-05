package LibraryManagement;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import  java.sql.*;
import java.util.Objects;
import javax.swing.*;

public class AddBooks extends JFrame {
    private String s;

    JLabel l1, l2, l3, l4, l5, l6, label, l7, l8;
    JTextField t1, t2, t3, t4, t5;
    JButton b1, b2;
    JPanel p1, p2, p3;

    public AddBooks() {
        super("Add Book Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(650, 600);
        setLocation(300, 20);
        setVisible(true);

        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();


        Font f = new Font("arial", Font.BOLD, 40);
        l6 = new JLabel("Add Book Details");
        l6.setHorizontalAlignment(JLabel.CENTER);
        l6.setFont(f);
        p1.add(l6);
        p1.setBounds(100, 20, 450, 60);
        p1.setBackground(Color.white);

        p2.setBounds(100, 130, 450, 300);
        p3.setBounds(100, 460, 450, 80);

        //panel 2 -->
        l1 = new JLabel("Book ID");
        l2 = new JLabel("Title");
        l3 = new JLabel("Author");
        l4 = new JLabel("Status");
        l5 = new JLabel("Quantity");

        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        t5 = new JTextField();
        //font
        Font f1 = new Font("arial", Font.BOLD, 24);
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

        p2.setLayout(new GridLayout(5, 2));
        p2.add(l1);
        p2.add(t1);
        p2.add(l2);
        p2.add(t2);
        p2.add(l3);
        p2.add(t3);
        p2.add(l4);
        p2.add(t4);
        p2.add(l5);
        p2.add(t5);
        //
        b1 = new JButton("Submit");
        b2 = new JButton("Back");
        b1.setFont(f1);
        b2.setFont(f1);
        //
        p3.setLayout(new GridLayout(1, 2));
        p3.add(b1);
        p3.add(b2);
        //
        add(p1);
        add(p2);
        add(p3);
        //image add
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("LibraryManagement/pexels-eneida-nieves-964547.jpg"));
        Image img = ic.getImage().getScaledInstance(650, 600, Image.SCALE_DEFAULT);
        ImageIcon ic1 = new ImageIcon(img);
        label = new JLabel(ic1);
        add(label);
        //

        ActionListener submit = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int bookID, quantity;
                String bookName, authorName, status;
                try {
                    Library.connect();

                    bookID = Integer.parseInt(t1.getText());
                    bookName = t2.getText();
                    authorName = t3.getText();
                    status = t4.getText();
                    quantity = Integer.parseInt(t5.getText());
                    s = "insert into books values(" + bookID + ",'" + bookName + "','" + authorName + "','" + status + "'," + quantity + ")";

                    boolean flag = false;
                    try {
                        int t = Library.st.executeUpdate(s);
                    } catch (SQLIntegrityConstraintViolationException ex) {
                        flag = true;
                        t1.setText("");
                        t2.setText("");
                        t3.setText("");
                        t4.setText("");
                        t5.setText("");
                        JOptionPane.showMessageDialog(null, "Record not inserted !!+SQLIntegrityConstraintViolationException");

                    }
                    if (flag == false) {
                        JOptionPane.showMessageDialog(null, "Record inserted successfully !!");
                        t1.setText("");
                        t2.setText("");
                        t3.setText("");
                        t4.setText("");
                        t5.setText("");
                    }
                    Library.con.close();
                } catch (SQLException ex) {
                    System.out.println(ex);
                }

            }
        };
        ActionListener back = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Library();

            }
        };
        b1.addActionListener(submit);
        b2.addActionListener(back);


    }

