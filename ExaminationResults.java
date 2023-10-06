import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

import javax.swing.*;

import net.proteanit.sql.DbUtils;

public class ExaminationResults extends JFrame implements ActionListener{

    JTextField search;
    JButton submit,cancel;
    JTable table;

    ExaminationResults() {

        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setSize(1000, 600);
        setLocation(120, 50);

        JLabel heading = new JLabel("Check Result");
        heading.setBounds(400, 20, 200, 24);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(heading);

        JLabel heading1 = new JLabel("Enter Roll No. ");
        heading1.setBounds(50, 60, 220, 24);
        heading1.setFont(new Font("Tahoma", Font.ITALIC, 20));
        add(heading1);

        search = new JTextField();
        search.setBounds(275, 60,220,25);
        add(search);

        submit = new JButton("Search");
        submit.setBounds(550,60,130,25);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        submit.setFont(new Font("Raleway",Font.BOLD,18));
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(755,60,130,25);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener((ActionListener) this);
        cancel.setFont(new Font("Raleway",Font.BOLD,18));
        add(cancel);

        table = new JTable();
        table.setFont(new Font("Tahoma", Font.CENTER_BASELINE,15));

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,120,1000,570);
        add(jsp);

        try{

            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from student");
            table.setModel(DbUtils.resultSetToTableModel(rs));

        }catch(Exception e){
            System.out.println(e);
        }

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent ms){
                int row = table.getSelectedRow();
                search.setText(table.getModel().getValueAt(row,2).toString());
            }
        });

        

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            setVisible(false);
            new Marks(search.getText());
        }
        else{
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new ExaminationResults();
    }
}
