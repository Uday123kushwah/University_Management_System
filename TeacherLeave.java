// package university_management_system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class TeacherLeave extends JFrame implements ActionListener {

    Choice empid,ctime;

    JDateChooser dcdate;

    JButton submit,cancel;

    TeacherLeave(){

        setSize(500,500);
        setLocation(425,100);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("Apply Leave(Teacher)");
        heading.setBounds(120,40,300,25);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        add(heading);


        JLabel lbempid = new JLabel("Search by Employee Id");
        lbempid.setBounds(120,80,350,20);
        add(lbempid);

        empid = new Choice();
        empid.setBounds(120,110,200,20);
        add(empid);

        try{

            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from Teacher");
            while(rs.next()){
                empid.add(rs.getString("emp_id"));
            }

        }catch (Exception e){
            System.out.println(e);
        }

        JLabel lbdate = new JLabel("Date");
        lbdate.setBounds(120,160,100,20);
        add(lbdate);

        dcdate = new JDateChooser();
        dcdate.setBounds(120,190,200,20);
        add(dcdate);

        JLabel lbtime = new JLabel("Time Duration");
        lbtime.setBounds(120,220,200,20);
        add(lbtime);

        ctime = new Choice();
        ctime.setBounds(120,250,200,20);
        ctime.add("Full Day");
        ctime.add("Half Day");
        add(ctime);

        submit = new JButton("Submit");
        submit.setBounds(60,330,110,25);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        submit.setFont(new Font("Raleway",Font.CENTER_BASELINE,20));
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(280,330,100,25);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Raleway",Font.CENTER_BASELINE,20));
        add(cancel);




        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String emp_id = empid.getSelectedItem();
            String date = ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
            String duration = ctime.getSelectedItem();

            String query = "insert into TeacherLeave values('"+emp_id+"','"+date+"','"+duration+"')";

            try{

                Conn conn = new Conn();
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Leave Confirmed");
                setVisible(false);

            }catch (Exception e){
                System.out.println(e);
            }

        } else if (ae.getSource() == cancel) {
            setVisible(false);

        }
    }
    public static void main(String[] args) {
        new TeacherLeave();
    }
}
