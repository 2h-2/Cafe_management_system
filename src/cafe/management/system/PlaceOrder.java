package cafe.management.system;

import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import common.OpenPdf;
import dao.BillDao;
import dao.CategoryDao;
import dao.ProductDao;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.LinkedList;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.Bill;
import model.Category;
import model.Product;
import java.util.Date;


public class PlaceOrder extends javax.swing.JFrame {

    public String email = "";
    public int billId = 1;
    public String emailPattern = "^[a-zA-Z0-9]+[@]+[a-zA-Z0-9]+[.]+[a-zA-Z0-9]+$";
    public String mobileNumberPattern = "^[0-9]*$";
    public int grandTotal = 0;
    public int productPrice = 0;
    public int productTotal = 0;
    
    
    public PlaceOrder() {
        initComponents();
    }
    
    public PlaceOrder(String userEmail) {
        initComponents();
        email = userEmail;
        txtProductName.setEditable(false);
        txtPrice.setEditable(false);
        txtTotal.setEditable(false);
        btnAddToCart.setEnabled(false);
        btnGBill.setEnabled(false);
        JFormattedTextField tf = ((JSpinner.DefaultEditor) jSpinner2.getEditor()).getTextField();
        tf.setEnabled(false);
    }

    public void clear(){
        txtProductName.setText("");
        txtPrice.setText("");
        txtTotal.setText("");
        productPrice = 0;
        jSpinner2.setValue(1);
        btnAddToCart.setEnabled(false);
    }
    
    public void validateFields(){
        String name = txtUserName.getText();
        String emaile = txtEmail.getText();
        String mobileNumer = txtMobileNumber.getText();
       
        
        if(!name.equals("")&& !emaile.equals("")&& emaile.matches(emailPattern) && mobileNumer.matches(mobileNumberPattern)&& grandTotal > 0){
            btnGBill.setEnabled(true);
        }else{
            btnGBill.setEnabled(false);
        }
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtMobileNumber = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtId = new javax.swing.JLabel();
        txtCategory = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtProductName = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        btnClear = new javax.swing.JButton();
        btnAddToCart = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnGBill = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtGrandTotal = new javax.swing.JLabel();
        jSpinner2 = new javax.swing.JSpinner();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/place order.png"))); // NOI18N
        jLabel1.setText("Place Order");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Bill ID:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Customer Details:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("User Name");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, -1, -1));

        txtUserName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtUserName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUserNameKeyReleased(evt);
            }
        });
        getContentPane().add(txtUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 240, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Mobile Number");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, -1, -1));

        txtMobileNumber.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtMobileNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMobileNumberKeyReleased(evt);
            }
        });
        getContentPane().add(txtMobileNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 240, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Email");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, -1, -1));

        txtEmail.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEmailKeyReleased(evt);
            }
        });
        getContentPane().add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 360, 240, -1));

        txtId.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtId.setForeground(new java.awt.Color(255, 255, 255));
        txtId.setText("00");
        getContentPane().add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, -1, -1));

        txtCategory.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCategory.setForeground(new java.awt.Color(255, 255, 255));
        txtCategory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtCategoryMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txtCategoryMouseReleased(evt);
            }
        });
        txtCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCategoryActionPerformed(evt);
            }
        });
        txtCategory.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCategoryKeyReleased(evt);
            }
        });
        getContentPane().add(txtCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 100, 240, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Search");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 160, -1, -1));

        txtSearch.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        getContentPane().add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 200, 240, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 260, 240, -1));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Price", "Quantity", "Total"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 300, 540, 380));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Category");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 70, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Name");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 70, -1, -1));

        txtProductName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtProductName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProductNameActionPerformed(evt);
            }
        });
        getContentPane().add(txtProductName, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 100, 240, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Quantity");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 160, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Price");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 70, -1, -1));

        txtPrice.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(txtPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 100, 230, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Total");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 160, -1, -1));

        txtTotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 200, 220, -1));

        btnClear.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clear.png"))); // NOI18N
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        getContentPane().add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 250, -1, -1));

        btnAddToCart.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAddToCart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add to cart.png"))); // NOI18N
        btnAddToCart.setText("Add To Cart");
        btnAddToCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddToCartActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddToCart, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 250, -1, -1));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 10, -1, -1));

        btnGBill.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnGBill.setText("Generate Bill & Print");
        btnGBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGBillActionPerformed(evt);
            }
        });
        getContentPane().add(btnGBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 710, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Grand Total:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 710, -1, -1));

        txtGrandTotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtGrandTotal.setForeground(new java.awt.Color(255, 255, 255));
        txtGrandTotal.setText("00");
        txtGrandTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtGrandTotalKeyReleased(evt);
            }
        });
        getContentPane().add(txtGrandTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 710, -1, -1));

        jSpinner2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner2StateChanged(evt);
            }
        });
        getContentPane().add(jSpinner2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 200, 240, -1));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/full-page-background.PNG"))); // NOI18N
        jLabel15.setText("jLabel15");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddToCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddToCartActionPerformed
        
        String name = txtProductName.getText();
        String price = txtPrice.getText();
        String quantity = String.valueOf(jSpinner2.getValue());
        DefaultTableModel dmt = (DefaultTableModel) jTable2.getModel();
        dmt.addRow(new Object[]{name,price,quantity,productTotal});
        grandTotal += productTotal;
        txtGrandTotal.setText(String.valueOf(grandTotal));
        clear();
        txtTotal.setText("");
        //validateFields();
    }//GEN-LAST:event_btnAddToCartActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int a = JOptionPane.showConfirmDialog(null, "Do you really want to close the application ?", "Select", JOptionPane.YES_NO_OPTION);
            if(a==0){
                setVisible(false);
                //new Home(email).setVisible(true);
            }
    }//GEN-LAST:event_jButton3ActionPerformed

    public void getCategories(String categoryName, String name){
        DefaultTableModel dmt = (DefaultTableModel) jTable1.getModel();
        dmt.setRowCount(0);
         LinkedList<Product> list = ProductDao.getProductsOfCategory(categoryName,name);
         Iterator<Product> it = list.iterator();
         while(it.hasNext()){
             Product product = it.next();
             dmt.addRow(new Object[]{product.getName()});
         }
    }
    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
         billId = Integer.parseInt(BillDao.getId());
         txtId.setText(BillDao.getId());
        LinkedList<Category> list = CategoryDao.getAllCategory();
         Iterator<Category> it = list.iterator();
         while(it.hasNext()){
            Category category = it.next();
            txtCategory.addItem(category.getName());
         }
        
        String catName = (String) txtCategory.getSelectedItem();
        getCategories(catName,"");
         
    }//GEN-LAST:event_formComponentShown

    private void txtCategoryKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCategoryKeyReleased
        
    }//GEN-LAST:event_txtCategoryKeyReleased

    private void txtCategoryMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCategoryMousePressed
        
    }//GEN-LAST:event_txtCategoryMousePressed

    private void txtCategoryMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCategoryMouseReleased
        
    }//GEN-LAST:event_txtCategoryMouseReleased

    private void txtCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCategoryActionPerformed
        String catName =(String) txtCategory.getSelectedItem();
        getCategories(catName,"");
    }//GEN-LAST:event_txtCategoryActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        String catName =(String) txtCategory.getSelectedItem();
        getCategories(catName,txtSearch.getText());
    }//GEN-LAST:event_txtSearchActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int index = jTable1.getSelectedRow();
        TableModel model = jTable1.getModel();
        String name = model.getValueAt(index, 0).toString();
        Product product = ProductDao.getProductByName(name);
        txtProductName.setText(product.getName());
        txtPrice.setText(product.getPrice());
        jSpinner2.setValue(1);
        txtTotal.setText(product.getPrice());
        productPrice = Integer.parseInt(product.getPrice());
        productTotal = Integer.parseInt(product.getPrice());
        btnAddToCart.setEnabled(true);
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void txtProductNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProductNameActionPerformed
        
    }//GEN-LAST:event_txtProductNameActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clear();
    }//GEN-LAST:event_btnClearActionPerformed

    private void txtUserNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserNameKeyReleased
       validateFields();
    }//GEN-LAST:event_txtUserNameKeyReleased

    private void txtMobileNumberKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMobileNumberKeyReleased
        validateFields();
    }//GEN-LAST:event_txtMobileNumberKeyReleased

    private void txtEmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyReleased
        validateFields();
    }//GEN-LAST:event_txtEmailKeyReleased

    private void txtGrandTotalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrandTotalKeyReleased
        validateFields();
    }//GEN-LAST:event_txtGrandTotalKeyReleased

    private void jSpinner2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner2StateChanged
        int quantity = (int) jSpinner2.getValue();
        if(quantity <=1){
            jSpinner2.setValue(1);
            quantity = 1;
        }
        productTotal = quantity*productPrice;
        txtTotal.setText(String.valueOf(productTotal));
    }//GEN-LAST:event_jSpinner2StateChanged

    private void btnGBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGBillActionPerformed
        String userName = txtUserName.getText();
        String mobileNumber = txtMobileNumber.getText();
        String useEmail = txtEmail.getText();
        SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        String todayDate = dFormat.format(date);
        String total = String.valueOf(grandTotal);
        Bill bill = new Bill();
        bill.setId(billId);
        bill.setName(userName);
        bill.setEmail(useEmail);
        bill.setMobileNumber(mobileNumber);
        bill.setDate(todayDate);
        bill.setTotal(total);
        bill.setCreatedBy(email);
        BillDao.save(bill);
        
        // Creating document
        String path = "E:\\";
        com.itextpdf.text.Document doc = new com.itextpdf.text.Document();
        try{
            
           PdfWriter.getInstance(doc, new FileOutputStream(path+""+billId+".pdf"));
           doc.open();
           Paragraph cafeName = new Paragraph("                                                              Cafe Management System");
           doc.add(cafeName);
           Paragraph starLine = new Paragraph("****************************************************************************************************************");
           doc.add(starLine);
           Paragraph paragraph3 = new Paragraph("\tBill ID: "+billId+"\nCustomer Name: "+ userName+"\nTotal Paid: "+ grandTotal);
           doc.add(paragraph3);
           doc.add(starLine);
           PdfPTable tb1 = new PdfPTable(4);
           tb1.addCell("Name");
           tb1.addCell("Price");
           tb1.addCell("Quantity");
           tb1.addCell("Total");
           for(int i=0; i < jTable2.getRowCount(); i++){
               String n = jTable2.getValueAt(i, 0).toString();
               String p = jTable2.getValueAt(i, 1).toString();
               String q = jTable2.getValueAt(i, 2).toString();
               String t = jTable2.getValueAt(i, 3).toString();
               tb1.addCell(n);
               tb1.addCell(p);
               tb1.addCell(q);
               tb1.addCell(t);
           }
           doc.add(tb1);
           doc.add(starLine);
           Paragraph paragraph4 = new Paragraph("Thank you, Please Visit Again.");
           doc.add(paragraph4);
           // Open Document
           OpenPdf.openById(String.valueOf(billId));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        doc.close();
        setVisible(false);
        new PlaceOrder(email).setVisible(true);
    }//GEN-LAST:event_btnGBillActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        int a = JOptionPane.showConfirmDialog(null, "Delete Row ?", "Select", JOptionPane.YES_NO_OPTION);
            if(a==0){
                int index = jTable2.getSelectedRow();
                TableModel model = jTable2.getModel();
                String total = model.getValueAt(index, 3).toString();
                grandTotal -= Integer.parseInt(total);
                txtGrandTotal.setText(String.valueOf(grandTotal));
                ((DefaultTableModel) jTable2.getModel()).removeRow(index);
            } 
    }//GEN-LAST:event_jTable2MouseClicked
 
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PlaceOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlaceOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlaceOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlaceOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PlaceOrder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddToCart;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnGBill;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JComboBox<String> txtCategory;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JLabel txtGrandTotal;
    private javax.swing.JLabel txtId;
    private javax.swing.JTextField txtMobileNumber;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtProductName;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
