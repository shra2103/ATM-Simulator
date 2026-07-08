import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class pinChange extends JFrame implements ActionListener{

    JButton back,change;
    JPasswordField enterpin,reenterpin;
    String pin;
    
    pinChange(String pin){

        this.pin=pin;
        setLayout(null);

        // add image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        // enter instruction
        JLabel text = new JLabel("Enter the pin to change : ");
        text.setFont(new Font("System",Font.BOLD,16));
        text.setForeground(Color.WHITE);
        text.setBounds(250,280,500,35);
        image.add(text);

        // new pin
        JLabel newpin = new JLabel("New PIN - ");
        newpin.setBounds(165,320,180,25);
        newpin.setFont(new Font("System",Font.BOLD,25));
        newpin.setForeground(Color.WHITE);
        image.add(newpin);
        // text field for pin
        enterpin = new JPasswordField();
        enterpin.setBounds(330,320,180,25);
        enterpin.setFont(new Font("Raleway",Font.BOLD,22));
        image.add(enterpin);

        // repin
        JLabel repin = new JLabel("Re-enter new PIN - ");
        repin.setBounds(165,360,180,25);
        repin.setFont(new Font("System",Font.BOLD,16));
        repin.setForeground(Color.WHITE);
        image.add(repin);
        // text field for re entered pin
        reenterpin = new JPasswordField();
        reenterpin.setBounds(330,360,180,25);
        reenterpin.setFont(new Font("Raleway",Font.BOLD,25));
        image.add(reenterpin);

        // change button
        change = new JButton("Change");
        change.setBounds(355,485,150,30);
        change.addActionListener(this);
        image.add(change);

        // back button
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
        else if(ae.getSource()==change){
            try{

                String npin = enterpin.getText();
                String rpin = reenterpin.getText();

                if(npin.equals("")){
                    JOptionPane.showMessageDialog(null,"Enter PIN");
                }
                else if(rpin.equals("")){
                    JOptionPane.showMessageDialog(null,"Renter pin");
                }
                else if(!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null,"PIN does not match !");
                } 
                else{
                    try{

                        conn c = new conn();
                        String query1 = "update signup3 set pin='"+rpin+"' where pin='"+pin+"'";
                        c.s.executeUpdate(query1);
                        String query2 = "update login set pin='"+rpin+"' where pin='"+pin+"'";
                        c.s.executeUpdate(query2);
                        String query3 = "update transactions set pin='"+rpin+"' where pin='"+pin+"'";
                        c.s.executeUpdate(query3);
                        String query4 = "update balance set pin='"+rpin+"' where pin='"+pin+"'";
                        c.s.executeUpdate(query4);

                        JOptionPane.showMessageDialog(null, "PIN changed successfull !");
                        JOptionPane.showMessageDialog(null, "Login again !");
                        setVisible(false);
                        new Login().setVisible(true);

                    }catch(Exception e){
                        System.out.println(e);
                    }
                }

            }catch(Exception e){
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        new pinChange("");
    }
}
