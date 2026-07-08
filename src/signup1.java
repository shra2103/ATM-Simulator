import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;


public class signup1 extends JFrame implements ActionListener{

    long random;
    JTextField nTextField,fnameTextField,emailTextField,addressTextField,cityTextField,pincodeTextField;
    JComboBox statebox;
    JDateChooser dateChooser;
    JButton next;
    JRadioButton male,female,other,married,unmarried;

    signup1(){
        setLayout(null); // then only setBound will work
        setTitle("New Account Application Form : Page 1");

        Random ran = new Random();
        random = Math.abs((ran.nextLong()%9000L )+1000L);

        JLabel formno = new JLabel("APPLICATION FORM NO : "+random); 
        formno.setFont(new Font("Raileay",Font.BOLD,38));
        formno.setBounds(140,20,600,40);
        add(formno);

        //add personal detail title
        JLabel persondetail = new JLabel("Page 1 : Personal Details "); 
        persondetail.setFont(new Font("Raileay",Font.BOLD,22));
        persondetail.setBounds(290,80,400,30);
        add(persondetail);

        //add name
        JLabel name = new JLabel("Name :"); 
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,200,30);
        add(name);
        // add text field
        nTextField = new JTextField();
        nTextField.setBounds(300,140,400,30);
        nTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(nTextField);

        //add fathers name
        JLabel fname = new JLabel("Father's Name :"); 
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);
        // add text field
        fnameTextField = new JTextField();
        fnameTextField.setBounds(300,190,400,30);
        fnameTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(fnameTextField);

        //add dob
        JLabel dob = new JLabel("Date of Birth :"); 
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);
        // add text field
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300,240,400,30);
        dateChooser.setForeground(Color.red);
        add(dateChooser);


        //add gender
        JLabel gender = new JLabel("Gender :"); 
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add(gender);
        // add text field radio chose only one 
        male = new JRadioButton("Male");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.WHITE);
        male.setFont(new Font("Arial",Font.BOLD,14));
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(450,290,120,30);
        female.setBackground(Color.WHITE);
        female.setFont(new Font("Arial",Font.BOLD,14));
        add(female);

        // we have to chose only one of them so we have to group them
        ButtonGroup gendeGroup = new ButtonGroup();
        gendeGroup.add(male);
        gendeGroup.add(female);

        //add email
        JLabel email = new JLabel("Email :"); 
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,340,200,30);
        add(email);
        // add text field
        emailTextField = new JTextField();
        emailTextField.setBounds(300,340,400,30);
        emailTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(emailTextField);

        //add marital status
        JLabel maritals = new JLabel("Marital Status :"); 
        maritals.setFont(new Font("Raleway",Font.BOLD,20));
        maritals.setBounds(100,390,200,30);
        add(maritals);
        // add radio married unmarried and other
        married = new JRadioButton("Married");
        married.setBounds(300,390,100,20);
        married.setBackground(Color.WHITE);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450,390,100,20);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        other = new JRadioButton("Other");
        other.setBounds(630,390,100,20);
        other.setBackground(Color.WHITE);
        add(other);
        
        // now group them
        ButtonGroup maritalButtonGroup = new ButtonGroup();
        maritalButtonGroup.add(married);
        maritalButtonGroup.add(unmarried);
        maritalButtonGroup.add(other);


        //add address
        JLabel address = new JLabel("Address :"); 
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,440,200,30);
        add(address);
        // add text field
        addressTextField = new JTextField();
        addressTextField.setBounds(300,440,400,30);
        addressTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(addressTextField);

        //add city
        JLabel city = new JLabel("City :"); 
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,490,200,30);
        add(city);
        // add text field
        cityTextField = new JTextField();
        cityTextField.setBounds(300,490,400,30);
        cityTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cityTextField);

        //add state
        JLabel state = new JLabel("State :"); 
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);
        // add text field
        String stateval[] ={ "-- Select State --", "Andhra Pradesh", "Arunachal Pradesh", "Asom (Assam)", "Bihar", 
            "Chhattisgarh", "Goa", "Gujarat", "Haryana", "Himachal Pradesh", "Jharkhand", 
            "Karnataka", "Kerala", "Madhya Pradesh", "Maharashtra", "Manipur", "Meghalaya", 
            "Mizoram", "Nagaland", "Odisha", "Punjab", "Rajasthan", "Sikkim", "Tamil Nadu", 
            "Telangana", "Tripura", "Uttar Pradesh", "Uttarakhand", "West Bengal"};
        statebox = new JComboBox<>(stateval);
        statebox.setBounds(300,540,400,30);
        statebox.setFont(new Font("Arial",Font.BOLD,14));
        add(statebox);

        //add pincode
        JLabel pincode = new JLabel("PIN CODE :"); 
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100,590,200,30);
        add(pincode);
        // add text field
        pincodeTextField = new JTextField();
        pincodeTextField.setBounds(300,590,400,30);
        pincodeTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(pincodeTextField);

        // add next button
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);


        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setVisible(true);
        setLocation(350,10);

    }

    public void actionPerformed(ActionEvent ae){
        String formno = ""+ random; // concatinating with " " converts the long to string
        String name = nTextField.getText(); // gettinf name
        String fname = fnameTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText(); // get Text only works on textfield
        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        }else if(female.isSelected()){
            gender = "Female";
        }
        String email = emailTextField.getText();
        String marital = null;
        if(married.isSelected()){
            marital="Married";
        }else if(unmarried.isSelected()){
            marital="Unmarried";
        }else if(other.isSelected()){
            marital="Other";
        }
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = (String) statebox.getSelectedItem();
        String pin = pincodeTextField.getText();

        // email format
        String emailPattern = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@gmail.com$";
        // now add to database first we have to check if it is correct form or not
        try{

            // Name
            if(name.equals("")|| !name.matches("^[a-zA-Z\\s]+$")){
                JOptionPane.showMessageDialog(null, "Name is Mandatory");// if name not filled it will show msg

            }
            // fname
            else if(fname.equals("")|| !fname.matches("^[a-zA-Z\\s]+$")){
                JOptionPane.showMessageDialog(null, "Father's name is Mandatory");// if name not filled it will show msg   
            }
            // dob
            else if(dob.equals("")){
                JOptionPane.showMessageDialog(null, "Date of Birth Mandatory");// if name not filled it will show msg
            }
            // gender
            else if(gender==null){
                JOptionPane.showMessageDialog(null, "Select the gender");
            }
            // email
            else if (email.equals("")|| !email.matches(emailPattern)){
                JOptionPane.showMessageDialog(null, "Enter a valid email");
            }
            // marital status
            else if(marital==null){
                JOptionPane.showMessageDialog(null, "Select the Marital Stauts");
            }
            // address
            else if (address.equals("")){
                JOptionPane.showMessageDialog(null, "Address is mandatory");
            }
            // state
            else if(state.equals("-- Select State --")){
                JOptionPane.showMessageDialog(null,"Select State from list");
            }
            // city
            else if(city.equals("")){
                JOptionPane.showMessageDialog(null, "Enter city");
            }
            // pin
            else if (pin.equals("") || pin.length() != 6 || !pin.matches("^[0-9]+$")) {
                JOptionPane.showMessageDialog(null, "PIN Code must be exactly 6 digits long!");
            }
            else{
                // call db connection
                conn cn = new conn();
                // write query
                String query = "insert into signup values ('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pin+"')";
                // now call statement from conn class
                cn.s.executeUpdate(query);

                // now open next page
                setVisible(false);
                new signup2(formno).setVisible(true);
            }

        }catch(Exception e){
            System.out.println(e);
        }

    }

    public static void main(String[] args) {
        new signup1();
    }
}
