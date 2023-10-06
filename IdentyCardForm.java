import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class IdentyCardForm extends JFrame implements ActionListener {

    JLabel labelname, labelrollno,labelfname,labeldob;
    JTextField tfaddress, tfemail, tfbranch, tfphone, tfcourse, tfpphone, tfblood;
    JComboBox cbcourse, cbbranch,cbsemester;

    JButton submit, cancel;

    IdentyCardForm() {
        setLayout(null);
        getContentPane().setBackground(Color.black);

        setSize(900, 600);
        setLocation(150, 20);

        JLabel heading = new JLabel("Identy Card Details");
        heading.setBounds(350, 10, 300, 30);
        heading.setForeground(Color.white);
        heading.setFont(new Font("tahoma", Font.BOLD, 20));
        add(heading);

        JLabel slrollno = new JLabel("Select Roll Number");
        slrollno.setBounds(50, 70, 200, 20);
        slrollno.setForeground(Color.white);
        slrollno.setFont(new Font("Tahoma", Font.PLAIN, 17));
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
        sname.setForeground(Color.white);
        sname.setFont(new Font("serif", Font.BOLD, 20));
        add(sname);

        labelname = new JLabel();
        labelname.setForeground(Color.green);
        labelname.setFont(new Font("Raleway",Font.PLAIN,16));
        labelname.setBounds(170, 120, 200, 30);
        add(labelname);

        JLabel fname = new JLabel("father's Name");
        fname.setBounds(400, 120, 150, 25);
        fname.setForeground(Color.white);
        fname.setFont(new Font("serif", Font.BOLD, 20));
        add(fname);

        labelfname = new JLabel();
        labelfname.setForeground(Color.green);
        labelfname.setFont(new Font("Raleway",Font.PLAIN,16));
        labelfname.setBounds(600, 120, 200, 30);
        add(labelfname);

        JLabel srollno = new JLabel("Roll number");
        srollno.setBounds(50, 170, 150, 25);
        srollno.setForeground(Color.white);
        srollno.setFont(new Font("serif", Font.BOLD, 20));
        add(srollno);

        labelrollno = new JLabel();
        labelrollno.setForeground(Color.green);
        labelrollno.setBounds(170, 170, 150, 25);
        labelrollno.setFont(new Font("serif", Font.BOLD, 20));
        add(labelrollno);

        JLabel sdob = new JLabel("Date of Birth");
        sdob.setBounds(400, 170, 150, 25);
        sdob.setForeground(Color.white);
        sdob.setFont(new Font("serif", Font.BOLD, 20));
        add(sdob);

        labeldob = new JLabel();
        labeldob.setBounds(600, 170, 200, 25);
        labeldob.setForeground(Color.green);
        labeldob.setFont(new Font("Raleway",Font.PLAIN,16));
        add(labeldob);

        JLabel saddress = new JLabel("Address");
        saddress.setForeground(Color.white);
        saddress.setBounds(50, 220, 100, 25);
        saddress.setFont(new Font("serif", Font.BOLD, 20));
        add(saddress);

        tfaddress = new JTextField();
        tfaddress.setBackground(Color.white);
        tfaddress.setForeground(Color.black);
        tfaddress.setFont(new Font("Raleway", Font.BOLD, 17));
        tfaddress.setBounds(170, 220, 200, 25);
        add(tfaddress);

        JLabel sphone = new JLabel("Phone");
        sphone.setBounds(400, 220, 150, 25);
        sphone.setForeground(Color.white);
        sphone.setFont(new Font("serif", Font.BOLD, 20));
        add(sphone);

        tfphone = new JTextField();
        tfphone.setBackground(Color.white);
        tfphone.setForeground(Color.black);
        tfphone.setBounds(600, 220, 200, 25);
        tfphone.setFont(new Font("Raleway", Font.BOLD, 17));
        add(tfphone);

        JLabel semail = new JLabel("Email Id");
        semail.setBounds(50, 270, 100, 25);
        semail.setForeground(Color.white);
        semail.setFont(new Font("serif", Font.BOLD, 20));
        add(semail);

        tfemail = new JTextField();
        tfemail.setBackground(Color.white);
        tfemail.setForeground(Color.black);
        tfemail.setBounds(170, 270, 200, 25);
        tfemail.setFont(new Font("Raleway", Font.BOLD, 17));
        add(tfemail);

        JLabel pphone = new JLabel("Parent's Phone");
        pphone.setBounds(400, 270, 150, 25);
        pphone.setForeground(Color.white);
        pphone.setFont(new Font("serif", Font.BOLD, 20));
        add(pphone);

        tfpphone = new JTextField();
        tfpphone.setBackground(Color.white);
        tfpphone.setForeground(Color.black);
        tfpphone.setFont(new Font("Raleway", Font.BOLD, 17));
        tfpphone.setBounds(600, 270, 200, 25);
        add(tfpphone);

        JLabel bloodGroup = new JLabel("Blood Grp");
        bloodGroup.setForeground(Color.white);
        bloodGroup.setBounds(50, 320, 150, 25);
        bloodGroup.setFont(new Font("serif", Font.BOLD, 20));
        add(bloodGroup);

        tfblood = new JTextField();
        tfblood.setBackground(Color.white);
        tfblood.setForeground(Color.black);
        tfblood.setBounds(170, 320, 200, 25);
        tfblood.setFont(new Font("Raleway", Font.BOLD, 17));
        add(tfblood);

        JLabel ssemester = new JLabel("Semester");
        ssemester.setBounds(400, 320, 150, 25);
        ssemester.setForeground(Color.white);
        ssemester.setFont(new Font("serif", Font.BOLD, 20));
        add(ssemester);

        String[] semester = {"Semester 1","Semester 2","Semester 3","Semester 4","Semester 5","Semester 6","Semester 7","Semester 8"};

        cbsemester = new JComboBox(semester);
        cbsemester.setBackground(Color.white);
        cbsemester.setBounds(600, 320, 200, 30);
        add(cbsemester);

        JLabel scourse = new JLabel("Course");
        scourse.setForeground(Color.white);
        scourse.setBounds(50, 370, 200, 25);
        scourse.setFont(new Font("serif", Font.BOLD, 20));
        add(scourse);

        String[] course = {"B.Tech", "BCA", "BBA", "BA", "B.COM", "BSC", "B.ED", "MA", "MSC", "MCA", "M.TECH", "MBA", "M.COM"};

        cbcourse = new JComboBox(course);
        cbcourse.setBackground(Color.white);
        cbcourse.setBounds(170, 370, 200, 25);
        add(cbcourse);

        JLabel sbranch = new JLabel("Branch");
        sbranch.setForeground(Color.white);
        sbranch.setBounds(400, 370, 200, 25);
        sbranch.setFont(new Font("tahoma", Font.BOLD, 20));
        add(sbranch);

        String[] branch = {"Computer Science", "Electronics", "Mechanical Engineering", "Civil Engineering", "Artitect", "Information Technology"};

        cbbranch = new JComboBox(branch);
        cbbranch.setBackground(Color.white);
        cbbranch.setBounds(600, 370, 200, 25);
        add(cbbranch);


        try {
            Conn conn = new Conn();
            String query = "select * from student where rollno = '" + crollno.getSelectedItem() + "'";
            ResultSet rs = conn.s.executeQuery(query);
            while (rs.next()) {
                labelname.setText(rs.getString("name"));
                labelfname.setText(rs.getString("father_name"));
                labelrollno.setText(rs.getString("rollno"));
                labeldob.setText(rs.getString("dob"));
//                tfaddress.setText(rs.getString("address"));
//                tfbranch.setText(rs.getString("branch"));
//                tfcourse.setText(rs.getString("course"));
//                tfemail.setText(rs.getString("email"));
//                tfphone.setText(rs.getString("phone"));

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

//                        tfaddress.setText(rs.getString("address"));
//                        tfbranch.setText(rs.getString("branch"));
//                        tfcourse.setText(rs.getString("course"));
//                        tfemail.setText(rs.getString("email"));
//                        tfphone.setText(rs.getString("phone"));


                    }

                } catch (Exception ae) {
                    System.out.println(ae);
                }

            }
        });

        submit = new JButton("Submit");
        submit.setBounds(250, 470, 130, 30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        submit.setFont(new Font("Raleway", Font.BOLD, 20));
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(450, 470, 130, 30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Raleway", Font.BOLD, 20));
        add(cancel);


        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == cancel) {
            setVisible(false);
//             System.exit(1);
        } else if (ae.getSource() == submit) {
            String name = labelname.getText();
            String fathername = labelfname.getText();
            String dob = labeldob.getText();
            String rollno = labelrollno.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String pphone = tfpphone.getText();
            String email = tfemail.getText();
            String blood = tfblood.getText();
            String semester = (String) cbsemester.getSelectedItem();
            String course = (String) cbcourse.getSelectedItem();
            String branch = (String) cbbranch.getSelectedItem();

            try {

                String query = "insert into IdentityCard values('"+name+"','"+fathername+"','"+dob+"','"+rollno+"','"+address+"','"+phone+"','"+pphone+"','"+email+"','"+blood+"','"+semester+"','"+course+"','"+branch+"')";

                Conn conn = new Conn();

                conn.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Student Details Successfully Submitted");
                setVisible(false);

            } catch (Exception e) {
                System.out.println(e);
            }

        }


    }

    public static void main(String[] args) {
        new IdentyCardForm();
    }
}
