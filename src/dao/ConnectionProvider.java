
package dao;
import java.sql.*;



public class ConnectionProvider {
    public static Connection getCon(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafe_management_system", "root","");
            System.out.println("Connected Successfully...");
            return con;
        }catch(Exception e){
            System.out.println("Could not connect to database...");
            e.printStackTrace();
            
        }
        return null;
    }
    
   /* public static void main(String[] args){
       getCon();
      
    }*/
}
