import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class signup2 extends JFrame implements ActionListener{
    
    JTextField panTextField,adharTextField;
    JComboBox religonbox,Categorybox,incomebox,edubox,occubox;
    JRadioButton yes,no,yes1,no1;
    String formno;
    JButton next;

    signup2(String formno){
        this.formno = formno;

        setLayout(null);
        setTitle("New Account Application Form: Page 2");


        JLabel adddetails = new JLabel("Page 2 : Additional Details");
        adddetails.setBounds(290,80,400,30);
        adddetails.setFont(new Font("Raleway",Font.BOLD,22));
        add(adddetails);

        // add religion
        JLabel religon = new JLabel("Religon :");
        religon.setBounds(100,140,200,30);
        religon.setFont(new Font("Raleway",Font.BOLD,20));
        add(religon);
        // drop down box
        String relval[] ={ "-- Select Religon --","Hindu","Muslim","Sikh","Chirstian","Other"};
        religonbox = new JComboBox<>(relval);
        religonbox.setBounds(350,140,300,30);
        religonbox.setBackground(Color.WHITE);
        add(religonbox);


        // add category
        JLabel category = new JLabel("Category :");
        category.setBounds(100,190,200,30);
        category.setFont(new Font("Raleway",Font.BOLD,20));
        add(category);
        // drop down box
        String catval[] ={ "-- Select Category --","Open","OBC","SC","ST","Other"};
        Categorybox = new JComboBox<>(catval);
        Categorybox.setBounds(350,190,300,30);
        Categorybox.setBackground(Color.WHITE);
        add(Categorybox);

        // add income
        JLabel income = new JLabel("Income :");
        income.setBounds(100,240,200,30);
        income.setFont(new Font("Raleway",Font.BOLD,20));
        add(income);
        // drop down box
        String incomeval[] ={ "-- Select Income --","0","< 1.5 Lakh","< 2.5 Lakh","< 5 Lakh","upto 10 Lakh"};
        incomebox = new JComboBox<>(incomeval);
        incomebox.setBounds(350,240,300,30);
        incomebox.setBackground(Color.WHITE);
        add(incomebox);

        // educational qualification
        JLabel education = new JLabel("Educational");
        education.setBounds(100,290,200,30);
        education.setFont(new Font("Raleway",Font.BOLD,20));
        add(education);
        JLabel qualification = new JLabel("Qualification : ");
        qualification.setBounds(100,310,200,30);
        qualification.setFont(new Font("Raleway",Font.BOLD,20));
        add(qualification);
        // drop down box
        String eduval[] ={ "-- Select Qualification --","Non Graduate","Graduate","Post Graduate","Doctrate","Others"};
        edubox = new JComboBox<>(eduval);
        edubox.setBounds(350,310,300,30);
        edubox.setBackground(Color.WHITE);
        add(edubox);

        //Occupation
        JLabel occupation = new JLabel("Occupation :");
        occupation.setBounds(100,360,200,30);
        occupation.setFont(new Font("Raleway",Font.BOLD,20));
        add(occupation);
        // drop down box
        String occuval[] ={ "-- Select Occupation --","Salaried","Self Employed","Business","Student","Other"};
        occubox = new JComboBox<>(occuval);
        occubox.setBounds(350,360,300,30);
        occubox.setBackground(Color.WHITE);
        add(occubox);

        //PAN NO
        JLabel panno = new JLabel("PAN Number :");
        panno.setBounds(100,410,200,30);
        panno.setFont(new Font("Raleway",Font.BOLD,20));
        add(panno);
        // add text field
        panTextField = new JTextField();
        panTextField.setBounds(350,410,300,30);
        panTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(panTextField);

        //ADHAR
        JLabel adharno = new JLabel("Aadhar Number :");
        adharno.setBounds(100,460,200,30);
        adharno.setFont(new Font("Raleway",Font.BOLD,20));
        add(adharno);
        // add text field
        adharTextField = new JTextField();
        adharTextField.setBounds(350,460,300,30);
        adharTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(adharTextField);

        //senior citizen
        JLabel senior = new JLabel("Senior Citizen :");
        senior.setBounds(100,510,200,30);
        senior.setFont(new Font("Raleway",Font.BOLD,20));
        add(senior);
        // add radio button yes or no
        yes = new JRadioButton("Yes");
        yes.setBounds(350,510,100,30);
        yes.setBackground(Color.WHITE);
        add(yes);
        // no
        no = new JRadioButton("No");
        no.setBounds(460,510,100,30);
        no.setBackground(Color.WHITE);
        add(no);
        //combine them 
        ButtonGroup seniorselection = new ButtonGroup();
        seniorselection.add(yes);
        seniorselection.add(no);

        //Existing acc
        JLabel existacc = new JLabel("Existing Account :");
        existacc.setBounds(100,560,200,30);
        existacc.setFont(new Font("Raleway",Font.BOLD,20));
        add(existacc);
        // add radio button yes or no
        yes1 = new JRadioButton("Yes");
        yes1.setBounds(350,560,100,30);
        yes1.setBackground(Color.WHITE);
        add(yes1);
        // no
        no1 = new JRadioButton("No");
        no1.setBounds(460,560,100,30);
        no1.setBackground(Color.WHITE);
        add(no1);
        //combine them 
        ButtonGroup exisaccselection = new ButtonGroup();
        exisaccselection.add(yes1);
        exisaccselection.add(no1);

        // add next button
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(620,660,80,30);
        next.setFont(new Font("Raleway",Font.BOLD,20));
        next.addActionListener(this);
        add(next);

        setSize(800,800);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        setLocation(350,10);
    }

    public void actionPerformed(ActionEvent ae){

        String religon = (String) religonbox.getSelectedItem();
        String category = (String) Categorybox.getSelectedItem();
        String income = (String) incomebox.getSelectedItem();
        String education = (String) edubox.getSelectedItem();
        String occupation = (String) occubox.getSelectedItem();
        String pan = panTextField.getText();
        String adhar = adharTextField.getText();
        String senior = null;
        if(yes.isSelected()){
            senior = "YES";
        }else if(no.isSelected()){
            senior = "NO";
        }
        String exist = null;
        if(yes1.isSelected()){
            exist="Yes";
        }else if (no1.isSelected()){
            exist="No";
        }

        //insert into db

        try{

            // religon
            if(religon.equals("-- Select Religon --")){
                JOptionPane.showMessageDialog(null, "Select Religon");
            }
            // category
            else if (category.equals("-- Select Category --")){
                JOptionPane.showMessageDialog(null, "Select Category");
            }
            // education
            else if (education.equals("-- Select Qualification --")){
                JOptionPane.showMessageDialog(null,"Select education");
            }
            //occupation
            else if(occupation.equals("-- Select Occupation --")){
                JOptionPane.showMessageDialog(null,"Select occupation");
            }
            //pan
            else if(pan.equals("")|| !pan.matches("^[A-Z]{5}\\d{4}[A-Z]{1}$")){ //ABCDE1234F
                JOptionPane.showMessageDialog(null,"Enter valid PAN Number (e.g ABCDE1234F)");
            }
            // adhar
            else if(adhar.equals("") || !adhar.matches("^\\d{12}$")){
                JOptionPane.showMessageDialog(null, "Enter valid adhar number");
            }
            // senior
            else if(senior==null){
                JOptionPane.showMessageDialog(null, "Select the Senior citizen stauts");
            }
            // existing acc
            else if(exist==null){
                JOptionPane.showMessageDialog(null, "Select Existing account status");
            }
            else{
                // call db connection
                conn cn = new conn();
                // write query
                String query = "insert into signup2 values ('"+formno+"','"+religon+"','"+category+"','"+income+"','"+education+"','"+occupation+"','"+pan+"','"+adhar+"','"+senior+"','"+exist+"')";
                // now call statement from conn class
                cn.s.executeUpdate(query);

                // now open next page
                setVisible(false);
                new signup3(formno).setVisible(true);
            }

        }catch(Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new signup2("");
    }
}
