import java.sql.*;

public class conn {

    Connection c;
    Statement s;
    
    public conn(){
        try{

            // register driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //create connection
            c = DriverManager.getConnection("jdbc:mysql:///bank_management","root","Pass@123");

            // create statement
            s = c.createStatement();

            // write sql query
            

        }catch(Exception e){
            System.out.println(e);
        }
    }
}
