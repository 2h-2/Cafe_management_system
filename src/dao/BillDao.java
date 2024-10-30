/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import static dao.DbOerations.getData;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.LinkedList;
import model.Bill;

public class BillDao {
    public static void save(Bill bill){
        String query = "insert into bill(id,name,email,mobileNumber,date,total,createdBy) values('"+bill.getId()+"','"+bill.getName()+"','"+bill.getEmail()+"','"+bill.getMobileNumber()+"','"+bill.getDate()+"','"+bill.getTotal()+"','"+bill.getCreatedBy()+"')";
        DbOerations.setDataOrDelete(query,"Bill Added Successfully.");
    }
    
    /**
     *
     * @param date
     * @param order
     * @return
     */
    public static LinkedList<Bill> getAllProduct(String date, String order){
        LinkedList<Bill> bill = new LinkedList<Bill>();
        try{
            
            ResultSet rs = DbOerations.getData("select * from bill where date like '%"+date+"%' order by id "+order);
            
                while(rs.next()){
                    Bill bi = new Bill();
                    bi.setId(rs.getInt(1));
                    bi.setName(rs.getString("name"));
                    bi.setMobileNumber(rs.getString("mobileNumber"));
                    bi.setDate(rs.getString("date"));
                    bi.setTotal(rs.getString("total"));
                    bi.setCreatedBy(rs.getString("createdBy"));
                    bill.add(bi);
                }
           
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        return bill;
    }
    
    public static LinkedList<Bill> getAllBillsByAsc(String date){
        LinkedList<Bill> bill = new LinkedList<Bill>();
        try{
            
            ResultSet rs = DbOerations.getData("select * from bill where date like '%"+date+"%' order by id ASC");
            
                while(rs.next()){
                    Bill bi = new Bill();
                    bi.setId(rs.getInt(1));
                    bi.setName(rs.getString("name"));
                    bi.setMobileNumber(rs.getString("mobileNumber"));
                    bi.setDate(rs.getString("date"));
                    bi.setTotal(rs.getString("total"));
                    bi.setCreatedBy(rs.getString("createdBy"));
                    bill.add(bi);
                }
           
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        return bill;
    }
    
    public static LinkedList<Bill> getAllBillsByDesc(String date){
        LinkedList<Bill> bill = new LinkedList<Bill>();
        try{
            
            ResultSet rs = DbOerations.getData("select * from bill where date like '%"+date+"%' order by id DESC");
            
                while(rs.next()){
                    Bill bi = new Bill();
                    bi.setId(rs.getInt(1));
                    bi.setName(rs.getString("name"));
                    bi.setMobileNumber(rs.getString("mobileNumber"));
                    bi.setDate(rs.getString("date"));
                    bi.setTotal(rs.getString("total"));
                    bi.setCreatedBy(rs.getString("createdBy"));
                    bill.add(bi);
                }
           
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        return bill;
    }
    
    public static String getId(){
        String query = "select max(id) from bill";
        ResultSet rs = DbOerations.getData(query);
        int id = 1;
        try{
            while(rs.next()){
                id = rs.getInt(1);
                id++;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        
        return String.valueOf(id);
    }
    
    
}
