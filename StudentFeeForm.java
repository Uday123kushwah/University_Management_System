import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class StudentFeeForm extends JFrame implements  ActionListener{

    JComboBox cbcourse,cbbranch,csemester;
    JLabel labeltotal;

    JButton update,payfee,back;
    Choice crollno;

    StudentFeeForm(){

        setLayout(null);
        getContentPane().setBackground(Color.black);

        setSize(1000,500);
        setLocation(140,50);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fee.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450,40,500,300);
        add(image);

        JLabel slrollno = new JLabel("Select Roll Number");
        slrollno.setBounds(40, 40, 150, 20);
        slrollno.setForeground(Color.white);
        slrollno.setFont(new Font("tahoma",Font.BOLD,15));
        add(slrollno);

        crollno = new Choice();
        crollno.setBounds(220, 40, 200, 20);
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
        sname.setBounds(40, 80, 100, 20);
        sname.setForeground(Color.white);
        sname.setFont(new Font("tahoma",Font.BOLD,15));
        add(sname);

        JLabel labelname = new JLabel();
        labelname.setBounds(220, 80, 200, 20);
        labelname.setForeground(Color.white);
        add(labelname);

        JLabel fname = new JLabel("father's Name");
        fname.setBounds(40, 120, 150, 20);
        fname.setFont(new Font("tahoma",Font.BOLD,15));
        fname.setForeground(Color.white);
        add(fname);

        JLabel labelfname = new JLabel();
        labelfname.setBounds(220, 120, 200, 20);
        labelfname.setForeground(Color.white);
        add(labelfname);

        try {
            Conn conn = new Conn();
            String query = "select * from student where rollno = '" + crollno.getSelectedItem() + "'";
            ResultSet rs = conn.s.executeQuery(query);
            while (rs.next()) {
                labelname.setText(rs.getString("name"));
                labelfname.setText(rs.getString("father_name"));

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

                    }

                } catch (Exception ae) {
                    System.out.println(ae);
                }

            }
        });

        JLabel scourse = new JLabel("Course");
        scourse.setBounds(40,170,100,20);
        scourse.setFont(new Font("Tahoma",Font.BOLD,15));
        scourse.setForeground(Color.white);
        add(scourse);


        String[] course = {"B.Tech","BCA","BBA","BA","B.COM","BSC","B.ED","MA","MSC","MCA","M.TECH","MBA","M.COM"};

        cbcourse = new JComboBox(course);
        cbcourse.setBackground(Color.black);
        cbcourse.setForeground(Color.white);
        cbcourse.setBounds(220,170,200,20);
        add(cbcourse);

        JLabel sbranch = new JLabel("Branch");
        sbranch.setBounds(40,215,100,20);
        sbranch.setFont(new Font("Tahoma",Font.BOLD,15));
        sbranch.setForeground(Color.white);
        add(sbranch);


        String[] branch = {"Computer Science","Electronics","Mechanical Engineering","Civil Engineering","Artitect","Information Technology"};

        cbbranch = new JComboBox(branch);
        cbbranch.setBackground(Color.black);
        cbbranch.setBounds(220,215,200,20);
        cbbranch.setForeground(Color.white);
        add(cbbranch);


        JLabel lblsemester = new JLabel("Select Semester");
        lblsemester.setBounds(40, 260, 150, 15);
        lblsemester.setForeground(Color.white);
        lblsemester.setFont(new Font("tahoma",Font.BOLD,15));
        add(lblsemester);

        String[] semester = {"semester1","semester2","semester3","semester4","semester5","semester6","semester7","semester8"};
        csemester = new JComboBox(semester);
        csemester.setBounds(220,260, 200, 20);
        csemester.setBackground(Color.black);
        csemester.setForeground(Color.white);
        add(csemester);

        JLabel total = new JLabel("Total Payable");
        total.setBounds(40, 300, 150, 15);
        total.setForeground(Color.white);
        total.setFont(new Font("tahoma",Font.BOLD,15));
        add(total);

        labeltotal = new JLabel();
        labeltotal.setBounds(220, 300, 150, 15);
        labeltotal.setForeground(Color.white);
        labeltotal.setFont(new Font("tahoma",Font.BOLD,15));
        add(labeltotal);


        update = new JButton("Update");
        update.setBounds(40,380,100,20);
        update.setBackground(Color.white);
        update.setForeground(Color.black);
        update.addActionListener(this);
        update.setFont(new Font("Raleway",Font.BOLD,15));
        add(update);

        payfee = new JButton("PayFee");
        payfee.setBounds(180,380,100,20);
        payfee.setBackground(Color.white);
        payfee.setForeground(Color.black);
        payfee.addActionListener(this);
        payfee.setFont(new Font("Raleway",Font.BOLD,15));
        add(payfee);

        back = new JButton("Back");
        back.setBounds(320,380,100,20);
        back.setBackground(Color.white);
        back.setForeground(Color.black);
        back.addActionListener(this);
        back.setFont(new Font("Raleway",Font.BOLD,15));
        add(back);






        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource() == update){

            String course = (String) (cbcourse.getSelectedItem());
            String semester = (String)(csemester.getSelectedItem());
            try{
                Conn conn = new Conn();
                ResultSet rs = conn.s.executeQuery("select * from fee where course = '"+course+"'");
                while(rs.next()){
                    labeltotal.setText(rs.getString(semester));
                }

            }catch(Exception e){
                System.out.println(e);
            }

        } else if (ae.getSource() == payfee) {

            String rollno = crollno.getSelectedItem();
            String course = (String) (cbcourse.getSelectedItem());
            String semester = (String)(csemester.getSelectedItem());
            String branch = (String) (cbbranch.getSelectedItem());
            String total = labeltotal.getText();

            try{
                Conn conn = new Conn();
                String query = "insert into collegefee values('"+rollno+"','"+course+"','"+branch+"','"+semester+"','"+total+"')";
                conn.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"College Fee Submitted Successfully");
                setVisible(false);

            }catch(Exception aex){
                System.out.println(aex);
            }


        } else{
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new StudentFeeForm();
    }
}
