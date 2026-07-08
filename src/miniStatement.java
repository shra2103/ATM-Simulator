import java.awt.Color;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class miniStatement extends JFrame{

    String pin;
    int currentbalnace=0;

    miniStatement(String pin){

        this.pin=pin;
        setTitle("Mini Statement");
        setLayout(null);

        JLabel text = new JLabel();
        text.setBounds(20,140,400,200);
        add(text);

        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150,20,100,20);
        add(bank);

        JLabel balance = new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);

        // to display card details acc no
        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card); 

        // card details db
        try{

            conn c = new conn();
            String query = "select * from login where pin='"+pin+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                card.setText("Card Number : "+rs.getString("cardno").substring(0,4)+"XXXXXXXX"+rs.getString("cardno").substring(12));
            }

        }catch(Exception e){
            System.out.println(e);
        }

        // text db
        try{
            conn c = new conn();
            String query1 = "select * from transactions where pin = '"+pin+"'";
            ResultSet rs = c.s.executeQuery(query1);
            while(rs.next()){
                text.setText(text.getText()+ "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type_of_transaction") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br>");
            }

        }catch(Exception e){
            System.out.println(e);
        }

        // fetch balance
        
        try{
            conn c = new conn();
            String query2 = "select balance from balance where pin = '"+pin+"'";
            ResultSet rs = c.s.executeQuery(query2);
            while(rs.next()){
                currentbalnace = rs.getInt("balance");
                balance.setText("Total available Balance : "+currentbalnace);
            }

        }catch(Exception e){
            System.out.println(e);
        }

        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new miniStatement("");
    }
}
