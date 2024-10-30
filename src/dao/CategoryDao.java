/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import javax.swing.JOptionPane;
import model.Category;
import java.sql.*;
import java.util.LinkedList;

public class CategoryDao {
    public static void save(Category category){
        String query = "insert into category(name) values('"+category.getName()+"')";
        DbOerations.setDataOrDelete(query,"Category Added Successfully.");
    }
    
    public static LinkedList<Category>  getAllCategory(){
        LinkedList<Category> category = new LinkedList<Category>();
        try{
            
            ResultSet rs = DbOerations.getData("select * from category ");
            
                while(rs.next()){
                    Category cat = new Category();
                    cat.setId(rs.getInt(1));
                    cat.setName(rs.getString("name"));
                    category.add(cat);
                }
           
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        return category;
    }
    
    public static void delete(String id){
        String Query = "delete from category where id='"+ id+"'";
        DbOerations.setDataOrDelete(Query,"Category Deleted Successfully.");
    }
    
   /* public static void main(String[] args){
        
        LinkedList<Category> category = new LinkedList<Category>();
        category = getAllCategory();
        for(Category c : category){
            System.out.println(c.getId());
            System.out.println(c.getName());
        }
    }*/

}
