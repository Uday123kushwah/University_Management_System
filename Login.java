
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {


    JButton login,cancel,signup,clickhere;
    JTextField userpasswordfield,userfield;
    Login(){

        setLayout(null);
        getContentPane().setBackground(Color.white);

        JLabel username = new JLabel("Username");
        username.setBounds(50,30,100,22);
        add(username);

        userfield = new JTextField();
        userfield.setBounds(150,30,160,20);
        add(userfield);

        JLabel userpassword = new JLabel("Password");
        userpassword.setBounds(50,80,100,22);
        add(userpassword);

        userpasswordfield = new JPasswordField();
        userpasswordfield.setBounds(150,80,160,20);
        add(userpasswordfield);

        login = new JButton("Login");
        login.setBounds(50,130,120,30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.setFont(new Font("Tahoma",Font.BOLD,15));
        login.addActionListener(this);
        add(login);

        cancel = new JButton("Cancel");
        cancel.setBounds(190,130,120,30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("Tahoma",Font.BOLD,15));
        cancel.addActionListener(this);
        add(cancel);

        signup = new JButton("SignUp");
        signup.setBounds(50,180,262,30);
        signup.setBackground(Color.black);
        signup.setForeground(Color.white);
        signup.setFont(new Font("Tahoma",Font.BOLD,15));
        signup.addActionListener(this);
        add(signup);

        JLabel labelforget = new JLabel(" If Forget Password ");
        labelforget.setForeground(Color.red);
        labelforget.setBounds(50,225,180,20);
        add(labelforget);

        clickhere = new JButton("Click Here");
        clickhere.setBounds(190,225,120,20);
        clickhere.setBackground(Color.white);
        clickhere.setForeground(Color.blue);
//        clickhere.setFont(new Font("Tahoma",Font.BOLD,15));
        clickhere.addActionListener(this);
        add(clickhere);



        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,0,200,200);
        add(image);

        setSize(600,300);
        setLocation(350,200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==cancel){
            setVisible(false);
            System.exit(1);
        } else if (ae.getSource() == login) {
            String username = userfield.getText();
            String password = userpasswordfield.getText();

            String query = "select * from Signup where username = '"+username+"' and password = '"+password+"'";

            try{
                Conn conn = new Conn();
                ResultSet rs = conn.s.executeQuery(query);

                if(rs.next()){
                    setVisible(false);
                    new Project();
                }
                else {
                    JOptionPane.showMessageDialog(null,"Invalid Username or Password");
                    setVisible(false);
                }

            }catch (Exception e){
                System.out.println(e);
            }
        } else if (ae.getSource() == signup) {
            new Signup();
        } else if (ae.getSource() == clickhere) {
            new ForgetPassword();
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
