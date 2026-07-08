import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

public class signup3 extends JFrame implements ActionListener{
    
        JRadioButton savingaccount,currentaccount, fdaccount, recdepositeaccount;
        JCheckBox c1,c2,c3,c4,c5,c6,c7;
        JButton submit,cancel;
        String formno;

    signup3(String formno){

        this.formno=formno;

        setLayout(null);
        setTitle("New Account Application Form : Page 3");

        // set title of page
        JLabel title = new JLabel("Page 3 : Account Details");
        title.setBounds(290,60,400,30);
        title.setFont(new Font("Raleway",Font.BOLD,24));
        add(title);

        // acc type
        JLabel accounttype = new JLabel("Account Type");
        accounttype.setBounds(100,140,200,30);
        accounttype.setFont(new Font("Raleway",Font.BOLD,22));
        add(accounttype);
        // add 4 options
        //1
        savingaccount = new JRadioButton("Saving Account");
        savingaccount.setBackground(Color.WHITE);
        savingaccount.setBounds(100,180,200,30);
        savingaccount.setFont(new Font("Arial",Font.BOLD,14));
        add(savingaccount);
        //2
        fdaccount = new JRadioButton("Fixed Deposite Account");
        fdaccount.setBounds(350,180,200,30);
        fdaccount.setBackground(Color.WHITE);
        fdaccount.setFont(new Font("Arial",Font.BOLD,14));
        add(fdaccount);
        //3
        currentaccount = new JRadioButton("Current Account");
        currentaccount.setBackground(Color.WHITE);
        currentaccount.setBounds(100,210,200,30);
        currentaccount.setFont(new Font("Arial",Font.BOLD,14));
        add(currentaccount);
        //4
        recdepositeaccount = new JRadioButton("Recurrent Deposite Account");
        recdepositeaccount.setBackground(Color.WHITE);
        recdepositeaccount.setBounds(350,210,400,30);
        recdepositeaccount.setFont(new Font("Arial",Font.BOLD,14));
        add(recdepositeaccount);
        // grup them 
        ButtonGroup acctype = new ButtonGroup();
        acctype.add(savingaccount);
        acctype.add(currentaccount);
        acctype.add(recdepositeaccount);
        acctype.add(fdaccount);

        // show card number
        JLabel card = new JLabel("Card Number");
        card.setFont(new Font("Raleway",Font.BOLD,22));
        card.setBounds(100,280,200,30);
        add(card);
        JLabel inst = new JLabel("Your 14 digit Card Number");
        inst.setBounds(100,300,400,30);
        inst.setFont(new Font("Raleway",Font.BOLD,12));
        add(inst);
        // display card number
        JLabel cardno = new JLabel("XXXX-XXXX-XXXX-4968");
        cardno.setFont(new Font("Raleway",Font.BOLD,24));
        cardno.setBounds(350,290,400,30);
        add(cardno);

        // show pin number
        JLabel pin = new JLabel("PIN");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100,370,200,30);
        add(pin);
        JLabel instr = new JLabel("Your 4 digit password");
        instr.setBounds(100,390,400,30);
        instr.setFont(new Font("Raleway",Font.BOLD,12));
        add(instr);
        // display pin
        JLabel pinno = new JLabel("XXXX");
        pinno.setFont(new Font("Raleway",Font.BOLD,24));
        pinno.setBounds(350,375,400,30);
        add(pinno);

        // Services required
        JLabel services = new JLabel("Services Required");
        services.setFont(new Font("Raleway",Font.BOLD,22));
        services.setBounds(100,460,200,30);
        add(services);
        // make checkbox
        //1
        c1 = new JCheckBox("Internet Banking");
        c1.setBounds(100,500,200,30);
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway",Font.BOLD,14));
        add(c1);
        //2
        c2 = new JCheckBox("Mobile Banking");
        c2.setBounds(100,530,200,30);
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway",Font.BOLD,14));
        add(c2);
        //3
        c3 = new JCheckBox("ATM Card");
        c3.setBounds(100,560,200,30);
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway",Font.BOLD,14));
        add(c3);
        //4
        c4 = new JCheckBox("Email & SMS Alert");
        c4.setBounds(350,500,200,30);
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway",Font.BOLD,14));
        add(c4);
        //5
        c5 = new JCheckBox("Cheque Book");
        c5.setBounds(350,530,200,30);
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway",Font.BOLD,14));
        add(c5);
        //6
        c6 = new JCheckBox("E Statement");
        c6.setBounds(350,560,200,30);
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway",Font.BOLD,14));
        add(c6);


        // self declaration
        c7 = new JCheckBox("I hereby declares that the above entered details are correct to the best of my knowledge");
        c7.setBounds(100,620,600,30);
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        add(c7);

        //submit button
        submit = new JButton("Submit");
        submit.setBounds(200,680,100,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway",Font.BOLD,20));
        submit.addActionListener(this);
        add(submit);
    
        //cancel button
        cancel = new JButton("Cancel");
        cancel.setBounds(450,680,100,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway",Font.BOLD,20));
        cancel.addActionListener(this);
        add(cancel);


        setSize(800,800);
        getContentPane().setBackground(Color.WHITE);
        setLocation(350,10);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String account = null;
            if(savingaccount.isSelected()){
                account = "Saving Account";
            }else if(currentaccount.isSelected()){
                account = "Current Account";
            }else if (fdaccount.isSelected()){
                account = "FD";
            }else if (recdepositeaccount.isSelected()){
                account="Recurrent Fixed Deposite";
            }

            Random ran = new Random();
            String cardno = ""+ Math.abs((ran.nextLong()%90000000L)+5040936000000000L);
            String pin = ""+Math.abs((ran.nextLong()%9000L)+1000L);

            String facility = " ";
            if(c1.isSelected()){
                facility += "Internet Banking";
            }else if(c2.isSelected()){
                facility += "Mobile Banking";
            }else if(c3.isSelected()){
                facility += "ATM Card";
            }else if(c4.isSelected()){
                facility += "Email & SMS Services";
            }else if(c5.isSelected()){
                facility += "Cheque Book";
            }else if(c6.isSelected()){
                facility += "E ststement";
            }

            try{
                
                if(account==null){
                    JOptionPane.showMessageDialog(null, "Select account type is mandatory");
                }
                else{
                    
                    // call db connection
                    conn cn = new conn();
                    // write query
                    String query = "insert into signup3 values ('"+formno+"','"+account+"','"+cardno+"','"+pin+"','"+facility+"')";
                    // now call statement from conn class
                    cn.s.executeUpdate(query);

                    // insert into query table
                    String query1 = "insert into login values ('"+formno+"','"+cardno+"','"+pin+"')";
                    // now call statement from conn class
                    cn.s.executeUpdate(query1);

                    // insert to balance table also
                    String query2 = "insert into balance(account_number, pin, balance) values('" + cardno + "', '" + pin + "',0)";
                    cn.s.executeUpdate(query2);

                    // Show msg to user
                    JOptionPane.showMessageDialog(null,"Card Number : "+cardno+"\n"+"PIN : "+pin);

                    // open login page
                    setVisible(false);
                    new deposite(pin).setVisible(true);
                }

            }catch(Exception e){
                System.out.println(e);
            }
        }
        else if (ae.getSource()==cancel){
            setVisible(false);
            new Login().setVisible(true);
        }

    }

    public static void main(String[] args) {
        new signup3("");
    }
}
