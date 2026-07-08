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

public class deposite extends JFrame implements ActionListener{

    JButton back,depo;
    JTextField amount;
    String pin;
    
    deposite(String pin){

        this.pin = pin;
        setLayout(null);

        // image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        // add text saying deposite money
        JLabel text = new JLabel("Enter the amount to be deposited : ");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(170,300,400,20);
        image.add(text);
        // add amount textfield
        amount = new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        amount.setBounds(170,350,320,25);
        image.add(amount);

        // add deposite button
        depo = new JButton("Deposite");
        depo.setBounds(355,485,150,30);
        depo.addActionListener(this);
        image.add(depo);

        // add back button
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

        if(ae.getSource()==depo){
            String damount = amount.getText();
            Date date = new Date();
            // format it to dd/mm/yy hh/mm/ss
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String strDate = sdf.format(date);

            if(damount==""){
                JOptionPane.showMessageDialog(null,"Enter amount");
            }
            else{
                int currentbalance =0;
                try{

                    conn c = new conn();

                    // entry to transaction table
                    String query = "insert into transactions value ( '"+pin+"','"+strDate+"','Deposite','"+damount+"' )";
                    c.s.executeUpdate(query);

                    // maintain balance
                    String fetchBalance = "select balance from balance where pin='"+pin+"'";
                    ResultSet rs = c.s.executeQuery(fetchBalance);
                    if(rs.next()){
                        currentbalance = rs.getInt("balance");
                    }
                    int newBalance = currentbalance + Integer.parseInt(damount);
                    String query1 = "update balance set balance = "+newBalance+" where pin='"+pin+"'";
                    c.s.executeUpdate(query1);
                    System.out.println("DEBUG -> Current: " + currentbalance + " | Depositing: " + damount + " | Calculated New: " + newBalance);


                    JOptionPane.showMessageDialog(null,"Deposited successfully");
                    setVisible(false);
                    new transaction(pin).setVisible(true);

                } catch(Exception e){
                    System.out.println(e);
                }
            }
        }
        else if(ae.getSource()==back){
            setVisible(false);
            new transaction(pin).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new deposite("");
    }
}
