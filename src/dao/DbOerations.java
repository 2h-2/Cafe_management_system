
package dao;

//import com.sun.jdi.connect.spi.Connection;
import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.ImageIcon;

public class DbOerations {
    
    public static void setDataOrDelete(String Query, String msg){
        Connection con = null;
         Statement st = null;
        try{
            con = ConnectionProvider.getCon();
            
            st = con.createStatement();
            st.executeUpdate(Query);
            if(!msg.equals("")){
                ImageIcon icon = new ImageIcon("src/popupicon/correct.png");
                JOptionPane.showMessageDialog(null,msg,"Message", JOptionPane.WARNING_MESSAGE,icon);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e, "Message", JOptionPane.ERROR_MESSAGE);
        }finally {
                    try {
			st.close();
			con.close();
                    } catch (Exception e) {}
		}
    }
    
    
    
    public static ResultSet getData(String Query){
        Connection con = null;
        Statement st = null;
        try{
            con = ConnectionProvider.getCon();
            st = con.createStatement();
            ResultSet rs = st.executeQuery(Query);
            return rs;
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e, "Message", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}
