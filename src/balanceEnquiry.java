import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class balanceEnquiry extends JFrame implements ActionListener{

    String pin;
    JButton back;
    int amount=0;

    balanceEnquiry(String pin){

        this.pin = pin;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        // back button
        back = new JButton("Back");
        back.setBounds(170,485,150,30);
        back.addActionListener(this);
        image.add(back);

        // retrieve data from db and display on screen
        conn c = new conn();
        try{
            String query = "select balance from balance where pin = '"+pin+"'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                amount = rs.getInt("balance");
        }
        } catch(Exception e){
            System.out.println(e);
        }

        // display balance
        JLabel text = new JLabel("Your account balance is Rs. "+amount);
        text.setBounds(170,300,400,30);
        text.setFont(new Font("Raleway",Font.BOLD,16));
        text.setForeground(Color.WHITE);
        image.add(text);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new transaction(pin).setVisible(true);
    }
    
    public static void main(String[] args) {
        new balanceEnquiry("");
    }
}
