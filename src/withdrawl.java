import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class withdrawl extends JFrame implements ActionListener{

    JTextField amount;
    JButton withdrawl,back;
    String pin;

    withdrawl(String pin){

        this.pin = pin;
        setLayout(null);

        // image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        // instruction
        JLabel text = new JLabel("Enter amount to be withdrawl : ");
        text.setBounds(170,300,400,20);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        // add textfield
        amount = new JTextField();
        amount.setFont(new Font("System",Font.BOLD,20));
        amount.setBounds(170,350,320,25);
        image.add(amount);

        // withdrawl
        withdrawl = new JButton("Withdrawl");
        withdrawl.setBounds(355,485,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        // back
        back = new JButton("Back");
        back.setBounds(170,485,150,30);
        back.addActionListener(this);
        image.add(back);


        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new transaction(pin).setVisible(true);
        }
        else if (ae.getSource()==withdrawl){
            String damount = amount.getText();
            Date date = new Date();
            // format it to dd/mm/yy hh/mm/ss
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String strDate = sdf.format(date);

            try{
                if(damount==""){
                JOptionPane.showMessageDialog(null,"Enter amount");
            }
            else{
                try{

                    int currentbalance=0;
                    conn c = new conn();

                    // check if enough balance is there or not
                    String fetchBalance = "select balance from balance where pin='"+pin+"'";
                    ResultSet rs = c.s.executeQuery(fetchBalance);
                    if(rs.next()){
                        currentbalance = rs.getInt("balance");
                    }
                    int withdrawlamount = Integer.parseInt(damount);
                    if (withdrawlamount <= currentbalance){
                        // update balace
                        String query1 = "update balance set balance = "+(currentbalance-withdrawlamount)+" where pin='"+pin+"'";
                        c.s.executeUpdate(query1);

                        // entry to transaction
                        String query = "insert into transactions value ( '"+pin+"','"+strDate+"','Withdrawl','"+damount+"' )";
                        c.s.executeUpdate(query);
                        
                        JOptionPane.showMessageDialog(null,"Withdrawl successfully");
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Not enough balance!!");
                    }
                    setVisible(false);
                    new transaction(pin).setVisible(true);

                } catch(Exception e){
                    System.out.println(e);
                }
            } 

            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
    
    public static void main(String[] args) {
        new withdrawl("");
    }
}
