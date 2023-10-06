// package university_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

public class StudentLeaveDetails extends JFrame implements ActionListener {

    Choice crollno;

    JTable table;

    JButton search,print,update,add,cancel;
    StudentLeaveDetails(){


        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel heading = new JLabel("Search by Roll Number");
        heading.setBounds(20,20,150,20);
        add(heading);

        crollno = new Choice();
        crollno.setBounds(180,20,150,20);
        add(crollno);

        try{

            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from student");
            while(rs.next()){
                crollno.add(rs.getString("roll_no"));
            }

        }catch (Exception e){
            System.out.println(e);
        }

        table = new JTable();

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,100,1000,500);
        add(jsp);

        try{

            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from StudentLeave");
            table.setModel(DbUtils.resultSetToTableModel(rs));

        }catch (Exception e){
            System.out.println(e);
        }

        search = new JButton("Search");
        search.setBounds(20,70,80,20);
        search.setBackground(Color.black);
        search.setForeground(Color.white);
        search.addActionListener(this);
        add(search);

        print = new JButton("Print");
        print.setBounds(120,70,80,20);
        print.setBackground(Color.black);
        print.setForeground(Color.white);
        print.addActionListener(this);
        add(print);

        cancel = new JButton("Cancel");
        cancel.setBounds(220,70,80,20);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);


        setSize(1000,600);
        setLocation(110,25);
//        getDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==search){

            String query = "select * from StudentLeave where rollno = '"+crollno.getSelectedItem()+"'";

            try{
                Conn conn = new Conn();
                ResultSet rs = conn.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));

            }catch (Exception e){
                System.out.println(e);
            }

        } else if (ae.getSource()==print) {
            try {
                table.print();
            } catch (PrinterException e) {
                throw new RuntimeException(e);
            }

        }  else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new StudentLeaveDetails();
    }
}
