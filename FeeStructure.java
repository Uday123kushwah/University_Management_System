import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class FeeStructure extends JFrame {

    FeeStructure(){
        setLayout(null);
        getContentPane().setBackground(Color.black);

        setSize(1000,650);
        setLocation(150,20);

        JLabel heading = new JLabel("Fee Structure");
        heading.setBounds(390,10,250,30);
        heading.setForeground(Color.white);
        heading.setFont(new Font("Tahoma",Font.BOLD,25));
        add(heading);

        JTable table = new JTable();

        try{

            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from fee");
            table.setModel(DbUtils.resultSetToTableModel(rs));

        }catch (Exception e){
            e.printStackTrace();
        }

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,50,1000,600);

        add(jsp);


        setVisible(true);
    }

    public static void main(String[] args) {
        new FeeStructure();
    }
}
