// package university_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import com.toedter.calendar.JDateChooser;

public class AddTeacher extends JFrame implements ActionListener {


    JTextField tfname,ffname,tfaddress,tpfield,emailfield,txpercentf,tx2percentf,taadharf;
    JLabel labelempid;

    JComboBox qualification,department;

    JDateChooser dcdob;

    JButton submit,cancel;

    Random ran = new Random();
    long first4 = Math.abs((ran.nextLong() % 9000L) + 1000L);
    AddTeacher(){

        setLayout(null);

        setSize(900,650);
        setLocation(200,20);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel heading = new JLabel("New Teacher Details");
        heading.setBounds(330,20,500,50);
        heading.setFont(new Font("serif",Font.BOLD,20));
        add(heading);

        JLabel tname = new JLabel("Name");
        tname.setBounds(50,120,100,25);
        tname.setFont(new Font("serif",Font.BOLD,20));
        add(tname);

        tfname = new JTextField();
        tfname.setBounds(170,120,200,30);
        add(tfname);

        JLabel fname = new JLabel("father's Name");
        fname.setBounds(400,120,150,25);
        fname.setFont(new Font("serif",Font.BOLD,20));
        add(fname);

        ffname = new JTextField();
        ffname.setBounds(600,120,200,30);
        add(ffname);

        JLabel tempid = new JLabel("Employee Id");
        tempid.setBounds(50,170,150,25);
        tempid.setFont(new Font("serif",Font.BOLD,20));
        add(tempid);

        labelempid = new JLabel("203"+first4);
        labelempid.setBounds(170,170,150,25);
        labelempid.setFont(new Font("serif",Font.BOLD,20));
        add(labelempid);

        JLabel tdob = new JLabel("Date of Birth");
        tdob.setBounds(400,170,150,25);
        tdob.setFont(new Font("serif",Font.BOLD,20));
        add(tdob);

        dcdob = new JDateChooser();
        dcdob.setBounds(600,170,200,25);
        add(dcdob);


        JLabel taddress = new JLabel("Address");
        taddress.setBounds(50,220,100,25);
        taddress.setFont(new Font("serif",Font.BOLD,20));
        add(taddress);

        tfaddress = new JTextField();
        tfaddress.setBounds(170,220,200,30);
        add(tfaddress);

        JLabel tphone = new JLabel("Phone");
        tphone.setBounds(400,220,150,25);
        tphone.setFont(new Font("serif",Font.BOLD,20));
        add(tphone);

        tpfield = new JTextField();
        tpfield.setBounds(600,220,200,30);
        add(tpfield);


        JLabel semail = new JLabel("Email Id");
        semail.setBounds(50,270,100,25);
        semail.setFont(new Font("serif",Font.BOLD,20));
        add(semail);

        emailfield = new JTextField();
        emailfield.setBounds(170,270,200,30);
        add(emailfield);

        JLabel txpercent = new JLabel("Class X(%)");
        txpercent.setBounds(400,270,150,25);
        txpercent.setFont(new Font("serif",Font.BOLD,20));
        add(txpercent);

        txpercentf = new JTextField();
        txpercentf.setBounds(600,270,200,30);
        add(txpercentf);

        JLabel tx2percent = new JLabel("Class XII(%)");
        tx2percent.setBounds(50,320,150,25);
        tx2percent.setFont(new Font("serif",Font.BOLD,20));
        add(tx2percent);

        tx2percentf = new JTextField();
        tx2percentf.setBounds(170,320,200,30);
        add(tx2percentf);

        JLabel taadhar = new JLabel("Aadhar No");
        taadhar.setBounds(400,320,150,25);
        taadhar.setFont(new Font("serif",Font.BOLD,20));
        add(taadhar);

        taadharf = new JTextField();
        taadharf.setBounds(600,320,200,30);
        add(taadharf);

        JLabel eduaction = new JLabel("Qualification");
        eduaction.setBounds(50,370,200,25);
        eduaction.setFont(new Font("serif",Font.BOLD,20));
        add(eduaction);


        String[] course = {"B.Tech","BCA","BBA","BA","B.COM","BSC","B.ED","MA","MSC","MCA","M.TECH","MBA","M.COM"};

        qualification = new JComboBox(course);
        qualification.setBackground(Color.white);
        qualification.setBounds(170,370,150,25);
        add(qualification);

        JLabel tdepartment = new JLabel("Department");
        tdepartment.setBounds(400,370,200,25);
        tdepartment.setFont(new Font("serif",Font.BOLD,20));
        add(tdepartment);


        String[] branch = {"Computer Science","Electronics","Mechanical Engineering","Civil Engineering","Artitect","Information Technology"};

        department = new JComboBox(branch);
        department.setBackground(Color.white);
        department.setBounds(600,370,150,25);
        add(department);

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
            String name = tfname.getText();
            String fathername = ffname.getText();
            String empid =labelempid.getText();
            String dob = ((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
            String address = tfaddress.getText();
            String phone = tpfield.getText();
            String email = emailfield.getText();
            String x = txpercentf.getText();
            String xii = tx2percentf.getText();
            String aadhar = taadharf.getText();
            String qualifi = (String) qualification.getSelectedItem();
            String depart = (String) department.getSelectedItem();

            try{

                String query = "insert into Teacher values('"+name+"','"+fathername+"','"+empid+"','"+dob+"','"+address+"','"+phone+"','"+email+"','"+x+"','"+xii+"','"+aadhar+"','"+qualifi+"','"+depart+"')";

                Conn conn = new Conn();

                conn.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Teacher Details Successfully Inserted");
                setVisible(false);


            }catch (Exception e){
                System.out.println(e);
            }



        }
    }

    public static void main(String[] args) {

        new AddTeacher();
    }
}
