import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Signup extends JFrame implements ActionListener {

    JTextField usertf,nametf,answertf,passwordtf;

//    JPasswordField ;

    JComboBox cbquestion;

    JButton submit,cancel;


    Signup(){


        setLayout(null);
        getContentPane().setBackground(Color.white);

        setSize(800,450);
        setLocationRelativeTo(null);

        JLabel label = new JLabel(" Create Account ");
        label.setBounds(300,10,200,25);
        label.setFont(new Font("Raleway",Font.BOLD,23));
        add(label);

        JLabel labelusername = new JLabel("Username :");
        labelusername.setBounds(50,60,150,20);
        labelusername.setFont(new Font("Raleway",Font.PLAIN,17));
        add(labelusername);

        usertf = new JTextField();
        usertf.setBounds(250,60,200,20);
        add(usertf);

        JLabel labelname = new JLabel("Name :");
        labelname.setBounds(50,100,150,20);
        labelname.setFont(new Font("Raleway",Font.PLAIN,17));
        add(labelname);

        nametf = new JTextField();
        nametf.setBounds(250,100,200,20);
        add(nametf);

        JLabel labelpassword = new JLabel("Password :");
        labelpassword.setBounds(50,140,150,20);
        labelpassword.setFont(new Font("Raleway",Font.PLAIN,17));
        add(labelpassword);

        passwordtf = new JPasswordField();
        passwordtf.setBounds(250,140,200,20);
        add(passwordtf);

        JLabel labelquestion = new JLabel("Security Question :");
        labelquestion.setBounds(50,180,200,20);
        labelquestion.setFont(new Font("Raleway",Font.PLAIN,17));
        add(labelquestion);

        String[] question = {"Your Nickname?","Favorite Game?","favorite Food?","Dream Place?","Best Singer"};

        cbquestion = new JComboBox(question);
        cbquestion.setBounds(250,180,200,20);
        cbquestion.setBackground(Color.white);
        add(cbquestion);

        JLabel labelanswer = new JLabel("Answer :");
        labelanswer.setBounds(50,220,200,20);
        labelanswer.setFont(new Font("Raleway",Font.PLAIN,17));
        add(labelanswer);

        answertf = new JTextField();
        answertf.setBounds(250,220,200,20);
        add(answertf);


        submit = new JButton("SignUp");
        submit.setBounds(100,280,120,25);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setFont(new Font("Tahoma",Font.BOLD,15));
        submit.addActionListener(this);
        add(submit);


        cancel = new JButton("Cancel");
        cancel.setBounds(280,280,120,25);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("Tahoma",Font.BOLD,15));
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/icon1.png"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(520,50,200,200);
        add(image);



        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == cancel){
            setVisible(false);
        } else if (ae.getSource() == submit) {

            String username = usertf.getText();
            String name = nametf.getText();
            String password = passwordtf.getText();
            String question = (String) cbquestion.getSelectedItem();
            String answer = answertf.getText();

            try{

                Conn conn = new Conn();

                String query = "insert into Signup values('"+username+"','"+name+"','"+password+"','"+question+"','"+answer+"')";

                conn.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Account Created Successfully");
                setVisible(false);

            }catch (Exception e){
                System.out.println(e);
            }

        }
    }

    public static void main(String[] args) {
        new Signup();
    }
}
