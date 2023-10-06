// package university_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.util.Random;
import com.toedter.calendar.JDateChooser;

public class UpdateStudent extends JFrame implements ActionListener {

    JTextField tfcourse, tfbranch, tfaddress, tfphone, tfemail;
    JLabel labelrollno, slrollno, labelname;

    JDateChooser dcdob;

    Choice crollno;

    JButton update, cancel;

    Random ran = new Random();
    long first4 = Math.abs((ran.nextLong() % 9000L) + 1000L);

    UpdateStudent() {

        setLayout(null);

        setSize(900, 650);
        setLocation(200, 20);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel heading = new JLabel("Update Student Details");
        heading.setBounds(50, 10, 500, 30);
        heading.setFont(new Font("Tahoma", Font.ITALIC, 25));
        add(heading);

        JLabel slrollno = new JLabel("Select Roll Number");
        slrollno.setBounds(50, 70, 200, 20);
        slrollno.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(slrollno);

        Choice crollno = new Choice();
        crollno.setBounds(300, 70, 300, 20);
        add(crollno);

        try {

            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from student");
            while (rs.next()) {
                crollno.add(rs.getString("rollno"));
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        JLabel sname = new JLabel("Name");
        sname.setBounds(50, 120, 100, 25);
        sname.setFont(new Font("serif", Font.BOLD, 20));
        add(sname);

        labelname = new JLabel();
        labelname.setBounds(170, 120, 200, 30);
        add(labelname);

        JLabel fname = new JLabel("father's Name");
        fname.setBounds(400, 120, 150, 25);
        fname.setFont(new Font("serif", Font.BOLD, 20));
        add(fname);

        JLabel labelfname = new JLabel();
        labelfname.setBounds(600, 120, 200, 30);
        add(labelfname);

        JLabel srollno = new JLabel("Roll number");
        srollno.setBounds(50, 170, 150, 25);
        srollno.setFont(new Font("serif", Font.BOLD, 20));
        add(srollno);

        labelrollno = new JLabel();
        labelrollno.setBounds(170, 170, 150, 25);
        labelrollno.setFont(new Font("serif", Font.BOLD, 20));
        add(labelrollno);

        JLabel sdob = new JLabel("Date of Birth");
        sdob.setBounds(400, 170, 150, 25);
        sdob.setFont(new Font("serif", Font.BOLD, 20));
        add(sdob);

        JLabel labeldob = new JLabel();
        labeldob.setBounds(600, 170, 200, 25);
        add(labeldob);

        JLabel saddress = new JLabel("Address");
        saddress.setBounds(50, 220, 100, 25);
        saddress.setFont(new Font("serif", Font.BOLD, 20));
        add(saddress);

        tfaddress = new JTextField();
        tfaddress.setBounds(170, 220, 200, 30);
        add(tfaddress);

        JLabel sphone = new JLabel("Phone");
        sphone.setBounds(400, 220, 150, 25);
        sphone.setFont(new Font("serif", Font.BOLD, 20));
        add(sphone);

        tfphone = new JTextField();
        tfphone.setBounds(600, 220, 200, 30);
        add(tfphone);

        JLabel semail = new JLabel("Email Id");
        semail.setBounds(50, 270, 100, 25);
        semail.setFont(new Font("serif", Font.BOLD, 20));
        add(semail);

        tfemail = new JTextField();
        tfemail.setBounds(170, 270, 200, 30);
        add(tfemail);

        JLabel sxpercent = new JLabel("Class X(%)");
        sxpercent.setBounds(400, 270, 150, 25);
        sxpercent.setFont(new Font("serif", Font.BOLD, 20));
        add(sxpercent);

        JLabel labelx = new JLabel();
        labelx.setBounds(600, 270, 200, 30);
        add(labelx);

        JLabel sx2percent = new JLabel("Class XII(%)");
        sx2percent.setBounds(50, 320, 150, 25);
        sx2percent.setFont(new Font("serif", Font.BOLD, 20));
        add(sx2percent);

        JLabel labelxii = new JLabel();
        labelxii.setBounds(170, 320, 200, 30);
        add(labelxii);

        JLabel saadhar = new JLabel("Aadhar No");
        saadhar.setBounds(400, 320, 150, 25);
        saadhar.setFont(new Font("serif", Font.BOLD, 20));
        add(saadhar);

        JLabel labelaadhar = new JLabel();
        labelaadhar.setBounds(600, 320, 200, 30);
        add(labelaadhar);

        JLabel scourse = new JLabel("Course");
        scourse.setBounds(50, 370, 200, 25);
        scourse.setFont(new Font("serif", Font.BOLD, 20));
        add(scourse);

        tfcourse = new JTextField();
        tfcourse.setBackground(Color.white);
        tfcourse.setBounds(170, 370, 150, 25);
        add(tfcourse);

        JLabel sbranch = new JLabel("Branch");
        sbranch.setBounds(400, 370, 200, 25);
        sbranch.setFont(new Font("serif", Font.BOLD, 20));
        add(sbranch);

        tfbranch = new JTextField();
        tfbranch.setBackground(Color.white);
        tfbranch.setBounds(600, 370, 150, 25);
        add(tfbranch);

        try {
            Conn conn = new Conn();
            String query = "select * from student where rollno = '" + crollno.getSelectedItem() + "'";
            ResultSet rs = conn.s.executeQuery(query);
            while (rs.next()) {
                labelname.setText(rs.getString("name"));
                labelfname.setText(rs.getString("father_name"));
                labelrollno.setText(rs.getString("rollno"));
                labeldob.setText(rs.getString("dob"));
                labelx.setText(rs.getString("X_marks"));
                labelxii.setText(rs.getString("XII_marks"));
                tfaddress.setText(rs.getString("address"));
                tfbranch.setText(rs.getString("branch"));
                tfcourse.setText(rs.getString("course"));
                tfemail.setText(rs.getString("email"));
                tfphone.setText(rs.getString("phone"));
                labelaadhar.setText(rs.getString("aadhar"));

            }

        } catch (Exception ae) {
            System.out.println(ae);
        }

        crollno.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {

                try {
                    Conn conn = new Conn();
                    String query = "select * from student where rollno = '" + crollno.getSelectedItem() + "'";
                    ResultSet rs = conn.s.executeQuery(query);
                    while (rs.next()) {
                        labelname.setText(rs.getString("name"));
                        labelfname.setText(rs.getString("father_name"));
                        labelrollno.setText(rs.getString("rollno"));
                        labeldob.setText(rs.getString("dob"));
                        labelx.setText(rs.getString("X_marks"));
                        labelxii.setText(rs.getString("XII_marks"));
                        tfaddress.setText(rs.getString("address"));
                        tfbranch.setText(rs.getString("branch"));
                        tfcourse.setText(rs.getString("course"));
                        tfemail.setText(rs.getString("email"));
                        tfphone.setText(rs.getString("phone"));
                        labelaadhar.setText(rs.getString("aadhar"));

                    }

                } catch (Exception ae) {
                    System.out.println(ae);
                }

            }
        });

        update = new JButton("Update");
        update.setBounds(250, 470, 130, 30);
        update.setBackground(Color.black);
        update.setForeground(Color.white);
        update.addActionListener(this);
        update.setFont(new Font("Raleway", Font.CENTER_BASELINE, 20));
        add(update);

        cancel = new JButton("Cancel");
        cancel.setBounds(450, 470, 130, 30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Raleway", Font.CENTER_BASELINE, 20));
        add(cancel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == cancel) {
            setVisible(false);
            // System.exit(1);
        } else if (ae.getSource() == update) {      
            String rollno = labelrollno.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText(); 
            String course = tfcourse.getText();
            String branch = tfbranch.getText();

            try {

                String query = "update student set address = '"+address+"',phone = '"+phone+"',email = '"+email+"',course = '"+course+"',branch = '"+branch+"' where rollno = '"+rollno+"'";

                Conn conn = new Conn();

                conn.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Student Details Update Successfully");
                setVisible(false);

            } catch (Exception e) {
                System.out.println(e);
            }

        }
    }

    public static void main(String[] args) {
        new UpdateStudent();
    }
}
