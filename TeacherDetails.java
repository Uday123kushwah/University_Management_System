// package university_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

public class TeacherDetails extends JFrame implements ActionListener {

    Choice cempid;

    JTable table;

    JButton search,print,update,add,cancel;
    TeacherDetails(){


        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel heading = new JLabel("Search by Employee Id");
        heading.setBounds(20,20,150,20);
        add(heading);

        cempid = new Choice();
        cempid.setBounds(180,20,150,20);
        add(cempid);

        try{

            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from Teacher");
            while(rs.next()){
                cempid.add(rs.getString("emp_id"));
            }

        }catch (Exception e){
            System.out.println(e);
        }

        table = new JTable();

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,100,1250,550);
        add(jsp);

        try{

            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from Teacher");
            table.setModel(DbUtils.resultSetToTableModel(rs));

        }catch (Exception e){
            System.out.println(e);
        }

        search = new JButton("Search");
        search.setBounds(20,70,80,20);
        search.setBackground(Color.white);
        search.addActionListener(this);
        add(search);

        print = new JButton("Print");
        print.setBounds(120,70,80,20);
        print.setBackground(Color.white);
        print.addActionListener(this);
        add(print);

        update = new JButton("Update");
        update.setBounds(220,70,80,20);
        update.setBackground(Color.white);
        update.addActionListener(this);
        add(update);

        add = new JButton("Add");
        add.setBounds(320,70,80,20);
        add.setBackground(Color.white);
        add.addActionListener(this);
        add(add);

        cancel = new JButton("Cancel");
        cancel.setBounds(420,70,80,20);
        cancel.setBackground(Color.white);
        cancel.addActionListener(this);
        add(cancel);


        setSize(1250,650);
        setLocation(10,25);
//        getDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==search){

            String query = "select * from Teacher where emp_id = '"+cempid.getSelectedItem()+"'";

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

        } else if (ae.getSource()==update) {
            setVisible(false);
//            new UpdateStudent();

        } else if (ae.getSource()==add) {
            setVisible(false);
            new AddTeacher();

        } else if (ae.getSource()==cancel) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new TeacherDetails();
    }
}
