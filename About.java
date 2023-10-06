import javax.swing.*;
import java.awt.*;

public class About extends JFrame {

    About(){

        setLayout(null);
        getContentPane().setBackground(Color.black);

        setSize(700,500);
        setLocation(300,50);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/about.jpg"));
        Image i2 = i1.getImage().getScaledInstance(300,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,20,300,200);
        add(image);

        JLabel heading = new JLabel("<html> College <br/> Management System </html>");
        heading.setBounds(50,40,250,130);
        heading.setForeground(Color.white);
        heading.setFont(new Font("Tahoma",Font.BOLD,30));
        add(heading);

        JLabel name = new JLabel("Developed By : Uday Kushwah");
        name.setBounds(50,240,500,30);
        name.setForeground(Color.white);
        name.setFont(new Font("Tahoma",Font.BOLD,25));
        add(name);

        JLabel Rollno = new JLabel("Roll Number : 2101045011108");
        Rollno.setBounds(50,280,500,25);
        Rollno.setForeground(Color.white);
        Rollno.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(Rollno);

        JLabel contact = new JLabel("Contact : udaykushwah2002@gmail.com");
        contact.setBounds(50,315,500,20);
        contact.setForeground(Color.white);
        contact.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(contact);

        JLabel thnx = new JLabel("Thank You");
        thnx.setBounds(50,350,200,20);
        thnx.setForeground(Color.white);
        thnx.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(thnx);


        setVisible(true);
    }

    public static void main(String[] args) {
        new About();
    }
}
