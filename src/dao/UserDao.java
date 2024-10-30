/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import javax.swing.JOptionPane;
import model.User;
import java.sql.*;
import java.util.Iterator;
import java.util.LinkedList;
import model.Bill;
import model.Product;

public class UserDao {
    public static void save(User user){
        String query = "insert into user(name,email,mobileNumber,address,password,securityQuestion,answer,status) values('"+user.getName()+"','"+user.getEmail()+"','"+user.getMobileNumber()+"','"+user.getAddress()+"','"+user.getPassword()+"','"+user.getSecurityQuestion()+"','"+user.getAnswer()+"','false')";
        DbOerations.setDataOrDelete(query,"Registered Successfully.");
    }
    
    public static void update(String email, String password){
        String query = "update user set password= '"+password+"' where email='"+email+"'";
        DbOerations.setDataOrDelete(query,"Password Changed Successfully.");
    }
    
    public static void updateSecurityQuestion(String email, String securityQuestion, String answer){
        String query = "update user set securityQuestion= '"+securityQuestion+"' , answer = '"+answer+"' where email='"+email+"'";
        DbOerations.setDataOrDelete(query,"Security Question Changed Successfully.");
    }
    
    public static void updateStatus(String id, String status){
        if(status == "true"){
            status = "false";
        }else{
            status = "true";
        }
        String query = "update user set status= '"+status+"' where id='"+id+"'";
        DbOerations.setDataOrDelete(query,"Status Changed Successfully.");
    }
    
    public static User Login(String email, String password){
        User user = null;
        try{
            
            ResultSet rs = DbOerations.getData("select * from user where email='"+ email +"' and password='"+ password +"'");
            
                while(rs.next()){
                    user = new User();
                    user.setStatus(rs.getString("status"));
                }
           
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        return user;
    }
    
    public static User CheckEmail(String email){
        User user = null;
        try{
            
            ResultSet rs = DbOerations.getData("select * from user where email='"+ email +"'");
           // Iterator<User> it = rs.next();
                while(rs.next()){
                    user = new User();
                    user.setStatus(rs.getString("status"));
                    user.setPassword(rs.getString("password"));
                }
           
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        return user;
    }
    
    public static User getSecurityQuestion(String email){
        User user = null;
        try{
            
            ResultSet rs = DbOerations.getData("select * from user where email='"+ email +"'");
            
                while(rs.next()){
                    user = new User();
                    user.setSecurityQuestion(rs.getString("securityQuestion"));
                    user.setAnswer("answer");
                }
           
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        return user;
    }
    
    public static LinkedList<User> getAllUsers(String email){
        LinkedList<User> userList = new LinkedList<User>();
        
        try{
            
            ResultSet rs = DbOerations.getData("select * from user where email like '%"+email+"%'");
            
                while(rs.next()){
                  User user = new User();
                  user.setId(rs.getInt(1));
                  user.setName(rs.getString("name"));
                  user.setEmail(rs.getString("email"));
                  user.setMobileNumber(rs.getString("mobileNumber"));
                  user.setAddress(rs.getString("address"));
                  user.setSecurityQuestion(rs.getString("securityQuestion"));
                  user.setStatus(rs.getString("status"));
                  userList.add(user);
                }
           
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        return userList;
    }
    
     /*public static void main(String[] args){
       
        User user = CheckEmail("hasnaa@gmail.com");
        System.out.println(user.getStatus());
    }*/
    
}
