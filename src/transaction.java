import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class transaction extends JFrame implements ActionListener{
    
    String pin;
    JButton deposite,withdrawl,fastcash,ministatement,pinchange,balance,exit;

    transaction(String pin){
        this.pin = pin;
        setLayout(null);

        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        // enter please instructon
        JLabel text = new JLabel("Please select your transaction");
        text.setBounds(210,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

        // Enter operations
        //1
        deposite = new JButton("Deposite");
        deposite.setBounds(170, 415, 150, 30);
        deposite.addActionListener(this);
        image.add(deposite);
        //2
        withdrawl = new JButton("Cash Withdrawl");
        withdrawl.setBounds(170, 450, 150, 30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        //3
        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(355, 415, 150, 30);
        fastcash.addActionListener(this);
        image.add(fastcash);
        //4
        ministatement = new JButton("Mini Statement");
        ministatement.setBounds(355, 450, 150, 30);
        ministatement.addActionListener(this);
        image.add(ministatement);
        //5
        pinchange = new JButton("Change PIN");
        pinchange.setBounds(170, 485, 150, 30);
        pinchange.addActionListener(this);
        image.add(pinchange);
        //6
        balance = new JButton("Balance Enquiry");
        balance.setBounds(355, 485, 150, 30);
        balance.addActionListener(this);
        image.add(balance);

        // exit button
        exit = new JButton("Exit");
        exit.setBounds(355,520,150,30);
        exit.addActionListener(this);
        image.add(exit);


        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
            System.exit(0);
        }
        // deposite
        else if(ae.getSource()==deposite){
            setVisible(false);
            new deposite(pin);
        }
        //withdrwal
        else if(ae.getSource()==withdrawl){
            setVisible(false);
            new withdrawl(pin);
        }
        //fastcash
        else if(ae.getSource()==fastcash){
            setVisible(false);
            new FastCash(pin).setVisible(true);
        }
        //ministate
        else if(ae.getSource()==ministatement){
            setVisible(false);
            new miniStatement(pin).setVisible(true);
        }
        //pinchange
        else if(ae.getSource()==pinchange){
            setVisible(false);
            new pinChange(pin).setVisible(true);
        }
        //balance
        else if(ae.getSource()==balance){
            setVisible(false);
            new balanceEnquiry(pin);
        }
        
    }
    
    public static void main(String[] args) {
        new transaction("");
    }
}
