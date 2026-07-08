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

public class FastCash extends JFrame implements ActionListener{
    
    String pin;
    JButton deposite,withdrawl,fastcash,ministatement,pinchange,balance,back;

    FastCash(String pin){
        this.pin = pin;
        setLayout(null);

        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        // enter please instructon
        JLabel text = new JLabel("Select withdrawl amount");
        text.setBounds(210,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

        // Amount
        //1
        deposite = new JButton("Rs.100");
        deposite.setBounds(170, 415, 150, 30);
        deposite.addActionListener(this);
        image.add(deposite);
        //2
        withdrawl = new JButton("Rs.500");
        withdrawl.setBounds(170, 450, 150, 30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        //3
        fastcash = new JButton("Rs.1000");
        fastcash.setBounds(355, 415, 150, 30);
        fastcash.addActionListener(this);
        image.add(fastcash);
        //4
        ministatement = new JButton("Rs.2000");
        ministatement.setBounds(355, 450, 150, 30);
        ministatement.addActionListener(this);
        image.add(ministatement);
        //5
        pinchange = new JButton("Rs.5000");
        pinchange.setBounds(170, 485, 150, 30);
        pinchange.addActionListener(this);
        image.add(pinchange);
        //6
        balance = new JButton("Rs.10000");
        balance.setBounds(355, 485, 150, 30);
        balance.addActionListener(this);
        image.add(balance);

        // exit button
        back = new JButton("Back");
        back.setBounds(170,520,150,30);
        back.addActionListener(this);
        image.add(back);


        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        Date date = new Date();
        // format it to dd/mm/yy hh/mm/ss
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strDate = sdf.format(date);

        if(ae.getSource()==back){
            setVisible(false);
            new transaction(pin).setVisible(true);
        }
        else{

            int currentbalance=0;
            String damount = ((JButton)ae.getSource()).getText().substring(3); // RS 500
            
            try{

                conn c = new conn();
                String query = "select balance from balance where pin='"+pin+"'";
                ResultSet rs = c.s.executeQuery(query);
                while(rs.next()){
                    currentbalance = rs.getInt("balance");
                }
                int amount = Integer.parseInt(damount);
                if(amount<=currentbalance){
                    // update balance 
                    String query1 = "update balance set balance="+(currentbalance-amount)+" where pin= '"+pin+"'";
                    c.s.executeUpdate(query1);

                    // entry to transaction
                    // entry to transaction
                    String query2 = "insert into transactions value ( '"+pin+"','"+strDate+"','Fast Cash','"+amount+"' )";
                    c.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null,"Rs "+amount+" debited succefully");
                }
                else{
                    JOptionPane.showMessageDialog(null,"Not enough balance !!");
                }

            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
    
    public static void main(String[] args) {
        new FastCash("");
    }
}

