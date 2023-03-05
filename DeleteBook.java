package LibraryManagement;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import  java.sql.*;
import java.util.Objects;

public class DeleteBook extends JFrame {

    private String s;
    JLabel l1,l2,l3;
    JTextField t1;
    JButton b1,b2;
    JPanel p1,p2,p3;

    public DeleteBook()
    {
        super("Delete Book Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(650,600);
        setLocation(300,20);
        setVisible(true);

        p1=new JPanel();
        p2=new JPanel();
        p3=new JPanel();


        Font f=new Font("arial",Font.BOLD,40);
        l1=new JLabel("Delete Book ");
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setFont(f);
        p1.add(l1);
        p1.setBounds(100,20,450,60);
        p1.setBackground(Color.white);

        p2.setBounds(100,200,450,85);
        p3.setBounds(100,400,450,50);

        //panel 2 -->
        l2=new JLabel("Book ID");
        t1=new JTextField();
        Font f1=new Font("arial",Font.BOLD,24);
        l2.setFont(f1);
        t1.setFont(f1);
        p2.setLayout(new GridLayout(1,2));
        p2.add(l2);
        p2.add(t1);
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
        l3=new JLabel(ic1);
        add(l3);
        //

        ActionListener submit=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int bookID;
                try {
                    Library.connect();
                    bookID = Integer.parseInt(t1.getText());
                    s="delete from books where bookID="+bookID;
                    int t = Library.st.executeUpdate(s);
                    if (t==0)
                    {
                        t1.setText("");
                        JOptionPane.showMessageDialog(null, "Record not deleted !!");
                    }
                    else {
                        t1.setText("");
                        JOptionPane.showMessageDialog(null, "Record deleted successfully !!");
                    }
                    Library.con.close();
                } catch (SQLException ex) {
                    System.out.println(ex);
                }

            }
        };
        ActionListener back=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Library();
                System.out.println(" back delete page !!");
            }
        };
        b1.addActionListener(submit);
        b2.addActionListener(back);
    }

}
