import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
abstract class methods{
    abstract void clearfilebtn();
}
public class StudentData extends methods{

    public static void main(String args[]){

        //BACKEND SETUP
        String[] monthlist = {"January","February","March","April","May","June","July","August","Sepetember","October","November","December"};
        String[] datelist = new String[31];
        String[] yearlist = new String[10];
        for(int i=1;i<=31;i++){
            datelist[i-1]=Integer.toString(i);
        }
        for(int i=0;i<10;i++){
            yearlist[i]=Integer.toString(i+1995);
        }


        //INTERFACE
        JFrame app = new JFrame();

        JDialog message = new JDialog();

        JLabel Heading = new JLabel("Student Data Form");
        Heading.setFont(new Font("Verdana", Font.PLAIN, 18));

        JLabel FullName = new JLabel("Full Name : ");
        JTextField eFullName = new JTextField();

        JLabel DOB = new JLabel("Date of Birth : ");
        JComboBox eMonth = new JComboBox(monthlist);
        JComboBox eDate = new JComboBox(datelist);
        JComboBox eYear = new JComboBox(yearlist);

        JLabel PersonalEmail = new JLabel("Personal Email ID : ");
        JTextField ePersonalEmail = new JTextField();

        JLabel CollegeEmail = new JLabel("College Email ID : ");
        JTextField eCollegeEmail = new JTextField();

        JLabel RegNo = new JLabel("Registration Number : ");
        JTextField eRegNo = new JTextField();

        JLabel Branch = new JLabel("Branch : ");
        JTextField eBranch = new JTextField();

        JLabel PhoneNumber = new JLabel("Mobile Number : ");
        JTextField ePhoneNumber = new JTextField();

        JButton Submit = new JButton("SUBMIT");
        Submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                try {

                    BufferedWriter file = new BufferedWriter(new FileWriter("Data.txt",true));

                    eFullName.write(file);file.newLine();
                    JTextField eDOB = new JTextField();
                    eDOB.setText(eDate.getSelectedItem()+"/"+eMonth.getSelectedItem()+"/"+eYear.getSelectedItem()+"\n");
                    eDOB.write(file);file.newLine();
                    ePersonalEmail.write(file);file.newLine();
                    eCollegeEmail.write(file);file.newLine();
                    eRegNo.write(file);file.newLine();
                    eBranch.write(file);file.newLine();
                    ePhoneNumber.write(file);
                    file.write("\n\n");

                    file.close();


                    eFullName.setText("");
                    eDate.setSelectedIndex(0);
                    eMonth.setSelectedIndex(0);
                    eYear.setSelectedIndex(0);
                    ePersonalEmail.setText("");
                    eCollegeEmail.setText("");
                    eRegNo.setText("");
                    eBranch.setText("");
                    ePhoneNumber.setText("");

                    JOptionPane.showMessageDialog(null,"Data Added Successfully");
                }
                catch (Exception e){
                    JOptionPane.showMessageDialog(null,"Error Occurred");
                }
            }
        });
        JButton ClearData = new JButton("Clear Data");
        ClearData.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                new StudentData().clearfilebtn();
            }
        });


        Heading.setBounds(290,20,250,20);
        FullName.setBounds(40,100,150,20);
        DOB.setBounds(40,140,150,20);
        PersonalEmail.setBounds(40,180,150,20);
        CollegeEmail.setBounds(40,220,150,20);
        RegNo.setBounds(40,260,150,20);
        Branch.setBounds(40,300,150,20);
        PhoneNumber.setBounds(40,340,150,20);

        Submit.setBounds(100,400,200,30);
        ClearData.setBounds(350,400,200,30);

        eFullName.setBounds(200,100,150,20);
        eDate.setBounds(200,140,150,20);
        eMonth.setBounds(360,140,150,20);
        eYear.setBounds(520,140,150,20);
        ePersonalEmail.setBounds(200,180,150,20);
        eCollegeEmail.setBounds(200,220,150,20);
        eRegNo.setBounds(200,260,150,20);
        eBranch.setBounds(200,300,150,20);
        ePhoneNumber.setBounds(200,340,150,20);


        app.add(Heading);
        app.add(FullName);
        app.add(DOB);
        app.add(CollegeEmail);
        app.add(PersonalEmail);
        app.add(RegNo);
        app.add(Branch);
        app.add(PhoneNumber);

        app.add(Submit);
        app.add(ClearData);

        app.add(eFullName);
        app.add(eDate);
        app.add(eMonth);
        app.add(eYear);
        app.add(eCollegeEmail);
        app.add(ePersonalEmail);
        app.add(eRegNo);
        app.add(eBranch);
        app.add(ePhoneNumber);


        //APP SETUP
        app.setLayout(null);
        app.setSize(800,500);
        app.setVisible(true);

    }
    void clearfilebtn(){
        try {
            BufferedWriter file = new BufferedWriter(new FileWriter("Data.txt"));
            file.write("");
            file.close();
            JOptionPane.showMessageDialog(null,"Data Cleared Successfully");
        } catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error Occurred");
        }
    }
}