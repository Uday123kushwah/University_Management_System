import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.concurrent.ExecutionException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.mysql.cj.jdbc.result.ResultSetFactory;

public class Marks extends JFrame implements ActionListener{

    String rollno;
    JButton cancel;

    Marks(String rollno) {
        this.rollno = rollno;

        setLayout(null);
        getContentPane().setBackground(Color.white);

        setSize(500, 600);
        setLocation(400, 30);

        JLabel heading = new JLabel("Rajiv Academy Technology And Management");
        heading.setBounds(40, 20, 500, 25);
        heading.setFont(new Font("serif", Font.BOLD, 20));
        add(heading);

        JLabel subheading = new JLabel("Result of Examination 2023");
        subheading.setBounds(120, 50, 500, 25);
        subheading.setFont(new Font("serif", Font.BOLD, 17));
        add(subheading);

        JLabel lbrollno = new JLabel("Roll Number " + rollno);
        lbrollno.setBounds(40, 100, 500, 25);
        lbrollno.setFont(new Font("serif", Font.PLAIN, 15));
        add(lbrollno);

        JLabel lblsemester = new JLabel();
        lblsemester.setBounds(40, 140, 200, 25);
        lblsemester.setFont(new Font("serif", Font.PLAIN, 15));
        add(lblsemester);

        JLabel sub1 = new JLabel();
        sub1.setBounds(140, 200, 200, 25);
        sub1.setFont(new Font("serif", Font.PLAIN, 15));
        add(sub1);

        JLabel sub2 = new JLabel();
        sub2.setBounds(140, 230, 200, 25);
        sub2.setFont(new Font("serif", Font.PLAIN, 15));
        add(sub2);

        JLabel sub3 = new JLabel();
        sub3.setBounds(140, 260, 200, 25);
        sub3.setFont(new Font("serif", Font.PLAIN, 15));
        add(sub3);

        JLabel sub4 = new JLabel();
        sub4.setBounds(140, 290, 200, 25);
        sub4.setFont(new Font("serif", Font.PLAIN, 15));
        add(sub4);

        JLabel sub5 = new JLabel();
        sub5.setBounds(140, 320, 200, 25);
        sub5.setFont(new Font("serif", Font.PLAIN, 15));
        add(sub5);

        try {

            Conn conn = new Conn();
            ResultSet rs1 = conn.s.executeQuery("select * from Subject");
            while (rs1.next()) {
                sub1.setText(rs1.getString("subject1"));
                sub2.setText(rs1.getString("subject2"));
                sub3.setText(rs1.getString("subject3"));
                sub4.setText(rs1.getString("subject4"));
                sub5.setText(rs1.getString("subject5"));
                lblsemester.setText("Semester :: "+rs1.getString("semester"));
            }

            ResultSet rs2 = conn.s.executeQuery("select * from Marks");
            while (rs2.next()) {
                sub1.setText(sub1.getText() + "   ---------- " + rs2.getString("marks1"));
                sub2.setText(sub2.getText() + "   ---------- " + rs2.getString("marks2"));

                sub3.setText(sub3.getText() + "   ---------- " + rs2.getString("marks3"));

                sub4.setText(sub4.getText() + "   ---------- " + rs2.getString("marks4"));

                sub5.setText(sub5.getText() + "   ---------- " + rs2.getString("marks5"));

                String s1 = rs2.getString("marks1");
                System.out.println(s1);

            }

        } catch (Exception e) {
            System.out.println(e);
        }
        cancel = new JButton("Cancel");
        cancel.setBounds(280,480,130,25);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener((ActionListener) this);
        cancel.setFont(new Font("Raleway",Font.BOLD,18));
        add(cancel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == cancel){
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Marks(" ");
    }
}
