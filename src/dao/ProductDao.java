/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import javax.swing.JOptionPane;
import model.Product;
import java.sql.*;
import java.util.LinkedList;

public class ProductDao {
   public static void save(Product product){
        String query = "insert into product(name,category,price) values('"+product.getName()+"','"+product.getCategory()+"','"+product.getPrice()+"')";
        DbOerations.setDataOrDelete(query,"Product Added Successfully.");
    } 
   
   public static LinkedList<Product> getAllProduct(){
        LinkedList<Product> product = new LinkedList<Product>();
        try{
            
            ResultSet rs = DbOerations.getData("select * from product ");
            
                while(rs.next()){
                    Product pro = new Product();
                    pro.setId(rs.getInt(1));
                    pro.setName(rs.getString("name"));
                    pro.setCategory(rs.getString("category"));
                    pro.setPrice(rs.getString("price"));
                    product.add(pro);
                }
           
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        return product;
    }
   
   public static Product getProductByName(String name){
        Product product = new Product();
        try{
            
            ResultSet rs = DbOerations.getData("select * from product where name='"+name+"'");
            
                while(rs.next()){
                    product.setId(rs.getInt(1));
                    product.setName(rs.getString("name"));
                    product.setCategory(rs.getString("category"));
                    product.setPrice(rs.getString("price"));
                }
           
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        return product;
    }
   
   public static LinkedList<Product> getProductsOfCategory(String categoryName, String name){
        LinkedList<Product> product = new LinkedList<Product>();
        try{
            
            ResultSet rs = DbOerations.getData("select * from product where name like '%"+name+"%'"+" and category ='"+categoryName+"'");
            
                while(rs.next()){
                    Product pro = new Product();
                    pro.setId(rs.getInt(1));
                    pro.setName(rs.getString("name"));
                    pro.setCategory(rs.getString("category"));
                    pro.setPrice(rs.getString("price"));
                    product.add(pro);
                }
           
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        return product;
    }
   
   public static void delete(int id){
        String query = "delete from product where id = '"+id+"'";
        DbOerations.setDataOrDelete(query,"Product Deleted Successfully.");
    } 
   
   public static void update(Product product){
        //String query = "update product set name ='"+id+"' where id= = '"+id+"'";
        Connection con = ConnectionProvider.getCon();
        try{
            String sql = "update product set name=? , category=? , price=? WHERE id = ?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1,product.getName());
            preparedStatement.setString(2,product.getCategory());
            preparedStatement.setString(3,product.getPrice());
            preparedStatement.setInt(4,product.getId());
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null,"Update Successfully.");
        }catch (SQLException e ) {
               JOptionPane.showMessageDialog(null,e);
        }
        
    }
}
