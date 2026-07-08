import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;



public class Login extends JFrame implements ActionListener{

    JButton login,signup,clear;
    JTextField ctextField;
    JPasswordField ptextField;

    Login(){
        setLayout(null);
        setTitle("ATM"); //Set title of frame

        //Set logo 
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        // change the scale
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        // convert it io icon
        ImageIcon i3 = new ImageIcon(i2);
        //convert it to lable
        JLabel j1 = new JLabel(i3);
        //adjust size of lable
        j1.setBounds(70,10,100,100);
        //put it on frame
        add(j1);

        // Adding title jlable
        JLabel text = new JLabel("Welcome to ATM");
        // have to specify loaction bcz we define layot to null
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200,40,500,40);
        //add on frame
        add(text);

        // Add Card no
        JLabel cardno = new JLabel("Card No : ");
        // have to specify loaction bcz we define layot to null
        cardno.setFont(new Font("Railway",Font.BOLD,28));
        cardno.setBounds(120,150,150,30);
        //add on frame
        add(cardno);

        // to add input box
        ctextField = new JTextField();
        ctextField.setBounds(300,150,250,30);
        ctextField.setFont(new Font("Arial",Font.BOLD,14));
        add(ctextField);

        // Add Pin
        JLabel pin = new JLabel("PIN : ");
        // have to specify loaction bcz we define layot to null
        pin.setFont(new Font("Railway",Font.BOLD,28));
        pin.setBounds(120,220,500,30);
        //add on frame
        add(pin);

        // to add pin input box
        ptextField = new JPasswordField();
        ptextField.setBounds(300,220,250,30);
        ptextField.setFont(new Font("Arial",Font.BOLD,14));
        add(ptextField);

        //now set sign in , sign up and claer button
        login = new JButton("SIGN IN");
        login.setBounds(300, 300, 100, 40);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        // After clicking user shoud be notified hence used action linstner
        login.addActionListener(this);
        add(login);

        clear = new JButton("CLEAR");
        clear.setBounds(430, 300, 100, 40);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("SIGN UP");
        signup.setBounds(300, 350, 230, 40);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
        
        //change bg color
        getContentPane().setBackground(Color.WHITE);

        //create frame
        setSize(800,480);
        // make it visible
        setVisible(true);
        // how fmae will be shown when program runs
        setLocation(350,200);
    }

    // so after clicking on buttons this function from interface will define what to do next with this button
    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==clear){
            ctextField.setText("");          // All text shoud be clear hence ued ""
            ptextField.setText("");

        } 
        else if(ae.getSource()==login){

            conn cn = new conn();
            String cardnumber = ctextField.getText();
            String pin = ptextField.getText();
            String query = "select * from login where cardno='"+cardnumber+"' and pin='"+pin+"'";
            try{
                ResultSet rs = cn.s.executeQuery(query);
                if(rs.next()){ // means if data is there this block will execute
                    setVisible(false);
                    new transaction(pin).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Enter correct credentials");
                    ctextField.setText("");          // All text shoud be clear hence ued ""
                    ptextField.setText("");
                }

            }catch(Exception e){
                System.out.println(e);
            }

        } 
        else if(ae.getSource()==signup){
            setVisible(false);
            new signup1().setVisible(true);
        }
    }

    public static void main(String[] args) {
        // whenever we run main it will create object and call constructor . Constructor has frame code hec=nce automatically frame will be open
        new Login();
    }
}
