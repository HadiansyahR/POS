/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.View;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.Controller.ControllerProduct;
import org.Controller.ControllerTransaction;
import org.Model.Product;
import org.Model.Transaction;
import org.Model.User;

/**
 *
 * @author Dreamvalian
 */
public class ReportView extends javax.swing.JFrame {

    private ControllerTransaction contTrans;
    private ControllerProduct contProd;
    
    private User userReport;
    private int loginStatusReport;   
    
    public ReportView() {
        initComponents();
        
//        loginStatusReport = loginStatus;
//        userReport = user;
        
        getReport();
        
        setLocationRelativeTo(null);
    }
    
    public ReportView(User user, int loginStatus) {
        initComponents();
        
        loginStatusReport = loginStatus;
        userReport = user;
        
        getReport();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ReportTextArea = new javax.swing.JTextArea();
        CloseButton = new javax.swing.JButton();
        Preview = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(71, 103, 237));
        jPanel1.setForeground(new java.awt.Color(35, 35, 35));
        jPanel1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        ReportTextArea.setColumns(20);
        ReportTextArea.setRows(5);
        jScrollPane1.setViewportView(ReportTextArea);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                .addContainerGap())
        );

        CloseButton.setBackground(new java.awt.Color(249, 249, 249));
        CloseButton.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        CloseButton.setForeground(new java.awt.Color(35, 35, 35));
        CloseButton.setText("Close");
        CloseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseButtonActionPerformed(evt);
            }
        });

        Preview.setBackground(new java.awt.Color(249, 249, 249));
        Preview.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        Preview.setForeground(new java.awt.Color(249, 249, 249));
        Preview.setText("Preview");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(CloseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Preview, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Preview)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CloseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public int[] getAmountSold(List<Transaction> listTransaction, List<Product> listProduct){
        int[] amountSoldByProduct = new int[listProduct.size()];
        int i = 0;
        int qty;
        String namaProduk;
        
        for(Product product: listProduct){
            qty = 0;
            namaProduk = product.getProduct_name();
            
            for(Transaction trans: listTransaction){
                if(trans.getProduct_name().equals(namaProduk)){
                    qty = qty + trans.getQuantity();
                }
            }
            
            amountSoldByProduct[i] = qty;
            i++;
        }
        
        return amountSoldByProduct;
    }
    
    public String getReportProduct(List<Product> listProduct, String subCategoryName, int expectedQty, int amountSold){
        String reportProduct = "";
        String body = "";
        
        for(Product product: listProduct){
            if(product.getSub_category().equals(subCategoryName)){
                body = product.getProduct_name()+"\t"+(product.getPrice()*expectedQty)+"\t"+amountSold+"  "+(product.getPrice()*amountSold)+"\n";
                reportProduct = reportProduct + body;
            }
            
        }
        
        return reportProduct;
    }
    
    public void getReport(){
        LocalDate trans_date = LocalDate.now();
        
        List<Transaction> listTransaction = new ArrayList<>();
        List<Product> listProduct = new ArrayList<>();
        
        contTrans = new ControllerTransaction();
        contProd = new ControllerProduct();
        
        String reportHead = "Report: "+trans_date.toString()+"\n"
                + "Product Name\tExpected\tQty  Amount\n\n";
        
        String reportProduct = "";
        String reportBody = "";
        String reportHeadProduct;
        String reportBodyProduct;
                
        String report = "";
        
//        listTransaction = contTrans.getTodayTransaction(trans_date.toString());
        listTransaction = contTrans.getTodayTransaction("2023-01-11");
        listProduct = contProd.getProducts();
        
        int i = 0;
        int[] amountSoldByProduct = getAmountSold(listTransaction, listProduct);
       
        int ExpectedQty = 0;
        
//        String[] subCategory = contProd.getListCategory();
        
        for(Product product: listProduct){
            
            if(reportBody.contains(product.getSub_category())){
                continue;
            }
            reportHeadProduct = "========================================\n"
                    + "Sub Category: "+product.getSub_category()+"\n"
                    + "========================================\n";
            
            if(product.getSub_category().equals("Appetizer")){
                ExpectedQty = 2;
            }else if(product.getSub_category().equals("Soup")){
                ExpectedQty = 3;
            }else if(product.getSub_category().equals("Salad")){
                ExpectedQty = 1;
            }else if(product.getSub_category().equals("Main Course")){
                ExpectedQty = 3;
            }else if(product.getSub_category().equals("Dessert")){
                ExpectedQty = 3;
            }else if(product.getSub_category().equals("Spirit")){
                ExpectedQty = 2;
            }else if(product.getSub_category().equals("Wine")){
                ExpectedQty = 2;
            }else if(product.getSub_category().equals("Liquor")){
                ExpectedQty = 2;
            }else if(product.getSub_category().equals("Cocktail")){
                ExpectedQty = 2;
            }else if(product.getSub_category().equals("Coffee")){
                ExpectedQty = 1;
            }else if(product.getSub_category().equals("Juice")){
                ExpectedQty = 2;
            }else if(product.getSub_category().equals("Mocktail")){
                ExpectedQty = 2;
            }
            
//            reportBodyProduct = product.getProduct_name()+"\t"+(product.getPrice()*ExpectedQty)+"\t"+(product.getPrice()*amountSoldByProduct[i])+"\n";
            
            reportBodyProduct = getReportProduct(listProduct, product.getSub_category(), ExpectedQty, amountSoldByProduct[i]);
            
            reportProduct = reportHeadProduct + reportBodyProduct;
            reportBody = reportBody + reportProduct;
            i++;
        }
        
        report = reportHead + reportBody;
        
        ReportTextArea.setText(report);
    }
    
    
    
    private void CloseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseButtonActionPerformed
        dispose();
        FunctionView fv = new FunctionView(userReport, loginStatusReport);
        fv.setVisible(true);
    }//GEN-LAST:event_CloseButtonActionPerformed

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
                if ("Windows Vista".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ReportView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReportView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReportView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReportView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReportView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CloseButton;
    private javax.swing.JLabel Preview;
    private javax.swing.JTextArea ReportTextArea;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
