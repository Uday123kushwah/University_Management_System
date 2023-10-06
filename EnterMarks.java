import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;
import javax.swing.border.Border;

public class EnterMarks extends JFrame implements ActionListener{

    Choice crollno;
    JComboBox csemester;
    JButton submit,cancel;
    JTextField tfsub1,tfsub2,tfsub3,tfsub4,tfsub5,tfmarks1,tfmarks2,tfmarks3,tfmarks4,tfmarks5;

    EnterMarks(){

        setLayout(null);
        getContentPane().setBackground(Color.black);
        setSize(1000,600);
        setLocation(150, 50);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/exam.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400,400,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500,70,400,400);
        add(image);

        JLabel heading = new JLabel("Enter Marks of Student");
        heading.setBounds(30, 20, 500, 25);
        heading.setFont(new Font("Tahoma", Font.BOLD, 25));
        heading.setForeground(Color.white);
        add(heading);

        JLabel lblrollno = new JLabel("Select Roll Number");
        lblrollno.setBounds(30, 90, 160, 15);
        lblrollno.setForeground(Color.white);
        add(lblrollno);

        crollno = new Choice();
        crollno.setBounds(210, 90, 200, 15);
        crollno.setBackground(Color.BLACK);
        crollno.setForeground(Color.white);
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

        JLabel lblsemester = new JLabel("Select Semester");
        lblsemester.setBounds(30, 130, 150, 15);
        lblsemester.setForeground(Color.white);
        add(lblsemester);

        String[] semester = {"1st semester","2nd semester","3rd semester","4th semester","5th semester","6th semester","7th semester","8th semester"};
        csemester = new JComboBox(semester);
        csemester.setBounds(210,130, 200, 20);
        csemester.setBackground(Color.black);
        csemester.setForeground(Color.white);
        add(csemester);


        JLabel lblsubject = new JLabel("Enter Subjects");
        lblsubject.setBounds(90, 180, 150, 25);
        lblsubject.setForeground(Color.white);
        add(lblsubject);

        JLabel lblmarks = new JLabel("Enter Marks");
        lblmarks.setBounds(270, 180, 150, 25);
        lblmarks.setForeground(Color.white);
        add(lblmarks);

        tfsub1 = new JTextField();
        tfsub1.setBounds(30,215,200,20);
        add(tfsub1);

        tfmarks1 = new JTextField();
        tfmarks1.setBounds(240,215,200,20);
        add(tfmarks1);

        tfsub2 = new JTextField();
        tfsub2.setBounds(30,245,200,20);
        add(tfsub2);

        tfmarks2 = new JTextField();
        tfmarks2.setBounds(240,245,200,20);
        add(tfmarks2);

        tfsub3 = new JTextField();
        tfsub3.setBounds(30,275,200,20);
        add(tfsub3);

        tfmarks3 = new JTextField();
        tfmarks3.setBounds(240,275,200,20);
        add(tfmarks3);

        tfsub4 = new JTextField();
        tfsub4.setBounds(30,305,200,20);
        add(tfsub4);

        tfmarks4 = new JTextField();
        tfmarks4.setBounds(240,305,200,20);
        add(tfmarks4);

        tfsub5 = new JTextField();
        tfsub5.setBounds(30,335,200,20);
        add(tfsub5);

        tfmarks5 = new JTextField();
        tfmarks5.setBounds(240,335,200,20);
        add(tfmarks5);

        submit = new JButton("Submit");
        submit.setBounds(65,400,130,25);
        submit.setBackground(Color.white);
        submit.setForeground(Color.black);
        submit.addActionListener(this);
        submit.setFont(new Font("Raleway",Font.BOLD,18));
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(270,400,130,25);
        cancel.setBackground(Color.white);
        cancel.setForeground(Color.black);
        cancel.addActionListener((ActionListener) this);
        cancel.setFont(new Font("Raleway",Font.BOLD,18));
        add(cancel);



        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){

            try{
                Conn conn = new Conn();

                String query1 = "insert into Subject values('"+crollno.getSelectedItem()+"','"+csemester.getSelectedItem()+"','"+tfsub1.getText()+"','"+tfsub2.getText()+"','"+tfsub3.getText()+"','"+tfsub4.getText()+"','"+tfsub5.getText()+"')";

                String query2 = "insert into Marks values('"+crollno.getSelectedItem()+"','"+csemester.getSelectedItem()+"','"+tfmarks1.getText()+"','"+tfmarks2.getText()+"','"+tfmarks3.getText()+"','"+tfmarks4.getText()+"','"+tfmarks5.getText()+"')";

                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null, "Marks Inserted Successfully");
                setVisible(false);

            }catch(Exception e){
                System.out.println(e);
            }

        } else if(ae.getSource() == cancel){
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new EnterMarks();
    }
    
}
