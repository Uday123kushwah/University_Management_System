// package university_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import com.toedter.calendar.JDateChooser;

public class AddStudent extends JFrame implements ActionListener {


    JTextField sfname,ffname,sfaddress,pfield,emailfield,sxpercentf,sx2percentf,saadharf;
    JLabel labelrollno;

    JComboBox cbcourse,cbbranch;

    JDateChooser dcdob;

    JButton submit,cancel;

    Random ran = new Random();
    long first4 = Math.abs((ran.nextLong() % 9000L) + 1000L);

    AddStudent(){

        setLayout(null);

        setSize(900,650);
        setLocation(200,20);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel heading = new JLabel("New Student Details");
        heading.setBounds(330,20,500,50);
        heading.setFont(new Font("serif",Font.BOLD,20));
        add(heading);

        JLabel sname = new JLabel("Name");
        sname.setBounds(50,120,100,25);
        sname.setFont(new Font("serif",Font.BOLD,20));
        add(sname);

        sfname = new JTextField();
        sfname.setBounds(170,120,200,30);
        add(sfname);

        JLabel fname = new JLabel("father's Name");
        fname.setBounds(400,120,150,25);
        fname.setFont(new Font("serif",Font.BOLD,20));
        add(fname);

        ffname = new JTextField();
        ffname.setBounds(600,120,200,30);
        add(ffname);

        JLabel srollno = new JLabel("Roll number");
        srollno.setBounds(50,170,150,25);
        srollno.setFont(new Font("serif",Font.BOLD,20));
        add(srollno);

        labelrollno = new JLabel("1533"+first4);
        labelrollno.setBounds(170,170,150,25);
        labelrollno.setFont(new Font("serif",Font.BOLD,20));
        add(labelrollno);

        JLabel sdob = new JLabel("Date of Birth");
        sdob.setBounds(400,170,150,25);
        sdob.setFont(new Font("serif",Font.BOLD,20));
        add(sdob);

        dcdob = new JDateChooser();
        dcdob.setBounds(600,170,200,25);
        add(dcdob);


        JLabel saddress = new JLabel("Address");
        saddress.setBounds(50,220,100,25);
        saddress.setFont(new Font("serif",Font.BOLD,20));
        add(saddress);

        sfaddress = new JTextField();
        sfaddress.setBounds(170,220,200,30);
        add(sfaddress);

        JLabel sphone = new JLabel("Phone");
        sphone.setBounds(400,220,150,25);
        sphone.setFont(new Font("serif",Font.BOLD,20));
        add(sphone);

        pfield = new JTextField();
        pfield.setBounds(600,220,200,30);
        add(pfield);


        JLabel semail = new JLabel("Email Id");
        semail.setBounds(50,270,100,25);
        semail.setFont(new Font("serif",Font.BOLD,20));
        add(semail);

        emailfield = new JTextField();
        emailfield.setBounds(170,270,200,30);
        add(emailfield);

        JLabel sxpercent = new JLabel("Class X(%)");
        sxpercent.setBounds(400,270,150,25);
        sxpercent.setFont(new Font("serif",Font.BOLD,20));
        add(sxpercent);

        sxpercentf = new JTextField();
        sxpercentf.setBounds(600,270,200,30);
        add(sxpercentf);

        JLabel sx2percent = new JLabel("Class XII(%)");
        sx2percent.setBounds(50,320,150,25);
        sx2percent.setFont(new Font("serif",Font.BOLD,20));
        add(sx2percent);

        sx2percentf = new JTextField();
        sx2percentf.setBounds(170,320,200,30);
        add(sx2percentf);

        JLabel saadhar = new JLabel("Aadhar No");
        saadhar.setBounds(400,320,150,25);
        saadhar.setFont(new Font("serif",Font.BOLD,20));
        add(saadhar);

        saadharf = new JTextField();
        saadharf.setBounds(600,320,200,30);
        add(saadharf);

        JLabel scourse = new JLabel("Course");
        scourse.setBounds(50,370,200,25);
        scourse.setFont(new Font("serif",Font.BOLD,20));
        add(scourse);


        String[] course = {"B.Tech","BCA","BBA","BA","B.COM","BSC","B.ED","MA","MSC","MCA","M.TECH","MBA","M.COM"};

        cbcourse = new JComboBox(course);
        cbcourse.setBackground(Color.white);
        cbcourse.setBounds(170,370,150,25);
        add(cbcourse);

        JLabel sbranch = new JLabel("Branch");
        sbranch.setBounds(400,370,200,25);
        sbranch.setFont(new Font("serif",Font.BOLD,20));
        add(sbranch);


        String[] branch = {"Computer Science","Electronics","Mechanical Engineering","Civil Engineering","Artitect","Information Technology"};

        cbbranch = new JComboBox(branch);
        cbbranch.setBackground(Color.white);
        cbbranch.setBounds(600,370,150,25);
        add(cbbranch);

        submit = new JButton("Submit");
        submit.setBounds(250,470,130,30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.GREEN);
        submit.addActionListener(this);
        submit.setFont(new Font("Raleway",Font.CENTER_BASELINE,20));
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(450,470,130,30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.GREEN);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Raleway",Font.CENTER_BASELINE,20));
        add(cancel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == cancel){
            setVisible(false);
//            System.exit(1);
        } else if (ae.getSource()==submit) {
            String name = sfname.getText();
            String fathername = ffname.getText();
            String rollno =labelrollno.getText();
            String dob = ((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
            String address = sfaddress.getText();
            String phone = pfield.getText();
            String email = emailfield.getText();
            String x = sxpercentf.getText();
            String xii = sx2percentf.getText();
            String aadhar = saadharf.getText();
            String course = (String) cbcourse.getSelectedItem();
            String branch = (String) cbbranch.getSelectedItem();

            try{

                String query = "insert into student values('"+name+"','"+fathername+"','"+rollno+"','"+dob+"','"+address+"','"+phone+"','"+email+"','"+x+"','"+xii+"','"+aadhar+"','"+course+"','"+branch+"')";

                Conn conn = new Conn();

                conn.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Student Details Successfully Entered");
                setVisible(false);

            }catch (Exception e){
                System.out.println(e);
            }



        }
    }

    public static void main(String[] args) {
        new AddStudent();
    }
}
