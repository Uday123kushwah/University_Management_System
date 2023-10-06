import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ForgetPassword extends JFrame implements ActionListener {

    JTextField usertf,nametf,answertf,passwordtf;

//    JPasswordField ;

    JComboBox cbquestion;

    JButton submit,cancel;

    ForgetPassword(){

        setLayout(null);
        setSize(700,350);
        getContentPane().setBackground(Color.white);
        setLocationRelativeTo(null);

        JLabel labelusername = new JLabel("Username :");
        labelusername.setBounds(50,60,150,20);
        labelusername.setFont(new Font("Raleway",Font.PLAIN,17));
        add(labelusername);

        usertf = new JTextField();
        usertf.setBounds(250,60,200,20);
        add(usertf);

        JLabel labelquestion = new JLabel("Security Question :");
        labelquestion.setBounds(50,100,200,20);
        labelquestion.setFont(new Font("Raleway",Font.PLAIN,17));
        add(labelquestion);

        String[] question = {"Your Nickname?","Favorite Game?","favorite Food?","Dream Place?","Best Singer"};

        cbquestion = new JComboBox(question);
        cbquestion.setBounds(250,100,200,20);
        cbquestion.setBackground(Color.white);
        add(cbquestion);

        JLabel labelanswer = new JLabel("Answer :");
        labelanswer.setBounds(50,140,200,20);
        labelanswer.setFont(new Font("Raleway",Font.PLAIN,17));
        add(labelanswer);

        answertf = new JTextField();
        answertf.setBounds(250,140,200,20);
        add(answertf);

        submit = new JButton("SignUp");
        submit.setBounds(100,200,120,25);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setFont(new Font("Tahoma",Font.BOLD,15));
        submit.addActionListener(this);
        add(submit);


        cancel = new JButton("Cancel");
        cancel.setBounds(280,200,120,25);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("Tahoma",Font.BOLD,15));
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/icon15.png"));
        Image i2 = i1.getImage().getScaledInstance(170,170,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(470,50,170,170);
        add(image);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String uname = usertf.getText();
            String ques = (String) cbquestion.getSelectedItem();
            String ans = answertf.getText();

            try{

                Conn conn = new Conn();

                ResultSet rs = conn.s.executeQuery("select * from Signup where username = '"+uname+"' and question = '"+ques+"' and answer = '"+ans+"'");

                while(rs.next()){

                    JOptionPane.showMessageDialog(null,"Your Password is "+rs.getString("password"));
                    setVisible(false);
                    return;
                }

                JOptionPane.showMessageDialog(null,"Invalid Username or Answer Try Again");


            }catch(Exception e){
                System.out.println(e);
            }

        }
        else{
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new ForgetPassword();
    }
}
