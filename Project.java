// package university_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Project extends JFrame implements ActionListener {


    JMenuItem ex;
    Project(){

        setSize(1300,680);
        getContentPane().setBackground(Color.black);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1200,650,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);


        JMenuBar mb = new JMenuBar();


        // New Information

        JMenu newInformation = new JMenu("New Information");
        newInformation.setForeground(Color.blue);
        mb.add(newInformation);

        JMenuItem facultyInfo = new JMenuItem("New Faculty Information");
        facultyInfo.setForeground(Color.black);
        facultyInfo.setBackground(Color.white);
        facultyInfo.addActionListener(this);
        newInformation.add(facultyInfo);

        JMenuItem studentInfo = new JMenuItem("New Student Information");
        studentInfo.setForeground(Color.black);
        studentInfo.setBackground(Color.white);
        studentInfo.addActionListener(this);
        newInformation.add(studentInfo);

        // details

        JMenu details = new JMenu("View Details");
        details.setForeground(Color.red);
        mb.add(details);

        JMenuItem facultyDetails= new JMenuItem("View Faculty Details");
        facultyDetails.setForeground(Color.black);
        facultyDetails.setBackground(Color.white);
        facultyDetails.addActionListener(this);
        details.add(facultyDetails);

        JMenuItem studentDetails = new JMenuItem("View Student Details");
        studentDetails.setForeground(Color.black);
        studentDetails.setBackground(Color.white);
        studentDetails.addActionListener(this);
        details.add(studentDetails);

        // Leave

        JMenu leave = new JMenu("Apply Leave");
        leave.setForeground(Color.blue);
        mb.add(leave);

        JMenuItem facultyleave= new JMenuItem("Faculty Leave");
        facultyleave.setForeground(Color.black);
        facultyleave.setBackground(Color.white);
        facultyleave.addActionListener(this);
        leave.add(facultyleave);

        JMenuItem studentLeave = new JMenuItem("Student Leave");
        studentLeave.setForeground(Color.black);
        studentLeave.setBackground(Color.white);
        studentLeave.addActionListener(this);
        leave.add(studentLeave);

        // Leave Details

        JMenu leaveDetails = new JMenu("Leave Details");
        leaveDetails .setForeground(Color.red);
        mb.add(leaveDetails );

        JMenuItem facultyleaveDetails= new JMenuItem("Faculty Leave Details");
        facultyleaveDetails.setForeground(Color.black);
        facultyleaveDetails.setBackground(Color.white);
        facultyleaveDetails.addActionListener(this);
        leaveDetails.add(facultyleaveDetails);

        JMenuItem studentLeaveDetails = new JMenuItem("Student Leave Details");
        studentLeaveDetails.setForeground(Color.black);
        studentLeaveDetails.setBackground(Color.white);
        studentLeaveDetails.addActionListener(this);
        leaveDetails.add(studentLeaveDetails);

        // Exam

        JMenu exam = new JMenu("Examination");
        exam .setForeground(Color.blue);
        mb.add(exam );

        JMenuItem examinationResults = new JMenuItem("Examination Results");
        examinationResults.setForeground(Color.black);
        examinationResults.setBackground(Color.white);
        examinationResults.addActionListener(this);
        exam.add(examinationResults);

        JMenuItem marks = new JMenuItem("Enter Marks");
        marks.setForeground(Color.black);
        marks.setBackground(Color.white);
        marks.addActionListener(this);
        exam.add(marks);


        // Update

        JMenu update = new JMenu("Update Details");
        update.setForeground(Color.red);
        mb.add(update);

        JMenuItem updateFacultyInfo = new JMenuItem("Update Faculty Details");
        updateFacultyInfo.setBackground(Color.white);
        updateFacultyInfo.addActionListener(this);
        update.add(updateFacultyInfo);

        JMenuItem updateStudentDetails = new JMenuItem("Update student Details");
        updateStudentDetails.setBackground(Color.white);
        updateStudentDetails.addActionListener(this);
        update.add(updateStudentDetails);

        // Fee

        JMenu fee = new JMenu("Fee Details");
        fee.setForeground(Color.blue);
        mb.add(fee);

        JMenuItem feeStructure= new JMenuItem("Fee Structure");
        feeStructure.setBackground(Color.white);
        feeStructure.addActionListener(this);
        fee.add(feeStructure);

        JMenuItem feeForm = new JMenuItem("Student Fee Form");
        feeForm.setBackground(Color.white);
        feeForm.addActionListener(this);
        fee.add(feeForm);

        // Identity Card

        JMenu card = new JMenu("Student Identity Card");
        card.setForeground(Color.red);
        mb.add(card);

        JMenuItem identitycardform = new JMenuItem("Idetity card Form");
        identitycardform.setBackground(Color.white);
        identitycardform.addActionListener(this);
        card.add(identitycardform);

        JMenuItem downloadIdentityCard = new JMenuItem("Download Identity card");
        downloadIdentityCard.setBackground(Color.white);
        downloadIdentityCard.addActionListener(this);
        card.add(downloadIdentityCard);


        // Utility

        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.blue);
        mb.add(utility);

        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.addActionListener(this);
        notepad.setForeground(Color.black);
        notepad.setBackground(Color.white);
        utility.add(notepad);

//        ImageIcon i21 = new ImageIcon(ClassLoader.getSystemResource("icons/icon9.png"));
//        Image i31 = i21.getImage().getScaledInstance(20,10,Image.SCALE_DEFAULT);
//        ImageIcon i41 = new ImageIcon(i31);
//        JLabel image1 = new JLabel(i41);
//        notepad.add(image1);

        JMenuItem calc = new JMenuItem("Calculator");
        calc.addActionListener(this);
        calc.setForeground(Color.black);
        calc.setBackground(Color.white);
        utility.add(calc);


        // about

        JMenu about = new JMenu("About");
        about.setForeground(Color.red);
        mb.add(about);

        JMenuItem ab = new JMenuItem("About");
        ab.setForeground(Color.black);
        ab.setBackground(Color.white);
        ab.addActionListener(this);
        about.add(ab);

        // Exit

        JMenu exit = new JMenu("Exit");
        exit.setForeground(Color.blue);
        mb.add(exit);

        JMenuItem ex = new JMenuItem("Exit");
        ex.setForeground(Color.black);
        ex.setBackground(Color.white);
        ex.addActionListener(this);
        exit.add(ex);



        setJMenuBar(mb);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        String msg = ae.getActionCommand();
        if(msg.equals("Exit")){
            setVisible(false);
            System.exit(1);
        } else if (msg.equals("Calculator")) {
            try{
                Runtime.getRuntime().exec("calc.exe");

            }catch (Exception e){
                System.out.println(e);
            }
        }else if (msg.equals("Notepad")) {
            try{
                Runtime.getRuntime().exec("notepad.exe");

            }catch (Exception e){
                System.out.println(e);
            }
        } else if (msg.equals("New Faculty Information")) {
            new AddTeacher();
        } else if (msg.equals("New Student Information")) {
            new AddStudent();
        } else if (msg.equals("View Faculty Details")) {
            new TeacherDetails();
        } else if (msg.equals("View Student Details")) {
            new StudentDetails();
        } else if (msg.equals("Faculty Leave")) {
            new TeacherLeave();
        } else if (msg.equals("Student Leave")) {
            new StudentLeave();
        } else if (msg.equals("Faculty Leave Details")) {
            new TeacherLeaveDetails();
        } else if (msg.equals("Student Leave Details")) {
            new StudentLeaveDetails();
        } else if(msg.equals("Update Faculty Details")){
            new UpdateTeacher();
        } else if(msg.equals("Update student Details")){
            new UpdateStudent();
        } else if(msg.equals("Enter Marks")){
            new EnterMarks();
        } else if(msg.equals("Examination Results")){
            new ExaminationResults();
        } else if (msg.equals("Fee Structure")) {
            new FeeStructure();
        } else if (msg.equals("About")) {
            new About();
        } else if (msg.equals("Student Fee Form")) {
            new StudentFeeForm();
        } else if (msg.equals("Idetity card Form")) {
            new IdentyCardForm();
        }
    }

    public static void main(String[] args) {
        new Project();
    }
}
