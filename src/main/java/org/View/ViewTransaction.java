/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.View;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.Controller.ControllerTransaction;
import org.Model.Transaction;
import org.Model.TransactionGroup;
import org.Model.User;

/**
 *
 * @author Dreamvalian
 */
public class ViewTransaction extends javax.swing.JFrame {

    private ControllerTransaction contTrans;
    private TransactionGroup transGroup;
    private Transaction trans;
    private User userView;
    
    private int loginStatusView;
    
    private DefaultTableModel model;
    
    public ViewTransaction() {
        initComponents();
        
        model = new DefaultTableModel();
        SalesDropDown.setSelectedItem(null);
        TransactionTable.setModel(model);
        model.addColumn("Transaction Id");
        model.addColumn("Table Num");
        model.addColumn("Total");
        model.addColumn("Transaction Date");
        model.addColumn("Payment Status");
        
        getData();
        
        setLocationRelativeTo(null);
    }
    
    public ViewTransaction(User user, int loginStatus) {
        initComponents();
        
        loginStatusView = loginStatus;
        userView = user;
        SalesDropDown.setSelectedItem(null);
        model = new DefaultTableModel();
        
        TransactionTable.setModel(model);
        model.addColumn("Transaction Id");
        model.addColumn("Table Num");
        model.addColumn("Total");
        model.addColumn("Transaction Date");
        model.addColumn("Payment Status");
        
        getData();
        
        setLocationRelativeTo(null);
    }
    
    public final void getData(){
       DefaultTableModel dtm = (DefaultTableModel) TransactionTable.getModel();
       contTrans = new ControllerTransaction();
       
       dtm.setRowCount(0);
       
       List<TransactionGroup> listTransactionGroup = contTrans.getListTransaction();
       
       String[] data = new String[6];
       for(TransactionGroup transGroup: listTransactionGroup){
           data[0] = Integer.toString(transGroup.getTransaction_id());
           data[1] = transGroup.getTable_num();
           data[2] = Double.toString(transGroup.getTotal());
           data[3] = transGroup.getTransaction_date();
           data[4] = Integer.toString(transGroup.getPayment_status());
           
           dtm.addRow(data);
       }
    }
    
    public final void getData(String payment_status){
       DefaultTableModel dtm = (DefaultTableModel) TransactionTable.getModel();
       contTrans = new ControllerTransaction();
       
       clearTable();
       
       dtm.setRowCount(0);
       int status;
       
       if(payment_status.equals("Open Tables")){
           status = 0;
       }
       else{
           status = 1;
       }
       List<TransactionGroup> listTransactionGroup = contTrans.filterByPayment(status);
       
       String[] data = new String[6];
       for(TransactionGroup transGroup: listTransactionGroup){
           data[0] = Integer.toString(transGroup.getTransaction_id());
           data[1] = transGroup.getTable_num();
           data[2] = Double.toString(transGroup.getTotal());
           data[3] = transGroup.getTransaction_date();
           data[4] = Integer.toString(transGroup.getPayment_status());
           
           dtm.addRow(data);
       }
    }
    
    public final void getTransactionDetails(int i){
        DefaultTableModel dtm = (DefaultTableModel) TransactionTable.getModel();
        contTrans = new ControllerTransaction();
       
        dtm.setRowCount(0);
       
        List<Transaction> listTransaction = contTrans.showListTransaction(i);
       
        String[] data = new String[9];
        for(Transaction transaction: listTransaction){
            data[0] = Integer.toString(transaction.getTransaction_id());
            data[1] = transaction.getTable_num();
            data[2] = transaction.getProduct_name();
            data[3] = Integer.toString(transaction.getQuantity());
            data[4] = Double.toString(transaction.getPrice());
            data[5] = Double.toString(transaction.getSubtotal());
            data[6] = transaction.getTransaction_date();
            data[7] = Integer.toString(transaction.getPayment_status());
                       
            dtm.addRow(data);
        }
    }
    
    public void setTableById(String id){
        DefaultTableModel dtm = (DefaultTableModel) TransactionTable.getModel();
        clearTable();
        
        transGroup = new TransactionGroup();
        transGroup = contTrans.findTransaction(Integer.parseInt(id));
        
        
        
        if(transGroup.getTransaction_id() != 0){
            String[] data = new String[6];
            data[0] = Integer.toString(transGroup.getTransaction_id());
            data[1] = transGroup.getTable_num();
            data[2] = Double.toString(transGroup.getTotal());
            data[3] = transGroup.getTransaction_date();
            data[4] = Integer.toString(transGroup.getPayment_status());
            
            dtm.addRow(data);
        }else{
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }
        
    }
    
    public void clearTable(){
        DefaultTableModel dtm = (DefaultTableModel) TransactionTable.getModel();
        
        int row = dtm.getRowCount();
        
        for(int i = row; i>0; i--){
            dtm.removeRow(i-1);
        }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        TransactionTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        RefreshButton = new javax.swing.JButton();
        SalesDropDown = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        SearchField = new javax.swing.JTextField();
        OpenButton = new javax.swing.JButton();
        NewTableButton = new javax.swing.JButton();
        PrintButton = new javax.swing.JButton();
        ViewButton = new javax.swing.JButton();
        TenderButton = new javax.swing.JButton();
        CloseButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(249, 249, 249));
        jPanel1.setForeground(new java.awt.Color(35, 35, 35));

        jScrollPane1.setBackground(new java.awt.Color(71, 103, 237));
        jScrollPane1.setForeground(new java.awt.Color(35, 35, 35));

        TransactionTable.setBackground(new java.awt.Color(249, 249, 249));
        TransactionTable.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        TransactionTable.setForeground(new java.awt.Color(35, 35, 35));
        TransactionTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(TransactionTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        jPanel2.setBackground(new java.awt.Color(71, 103, 237));
        jPanel2.setForeground(new java.awt.Color(35, 35, 35));

        jPanel3.setBackground(new java.awt.Color(249, 249, 249));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(178, 178, 178)));
        jPanel3.setForeground(new java.awt.Color(35, 35, 35));
        jPanel3.setToolTipText("");

        jSeparator1.setBackground(new java.awt.Color(249, 249, 249));
        jSeparator1.setForeground(new java.awt.Color(35, 35, 35));

        RefreshButton.setBackground(new java.awt.Color(249, 249, 249));
        RefreshButton.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        RefreshButton.setForeground(new java.awt.Color(35, 35, 35));
        RefreshButton.setText("Refresh");
        RefreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshButtonActionPerformed(evt);
            }
        });

        SalesDropDown.setBackground(new java.awt.Color(249, 249, 249));
        SalesDropDown.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        SalesDropDown.setForeground(new java.awt.Color(35, 35, 35));
        SalesDropDown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Open Tables", "Closed Table" }));
        SalesDropDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalesDropDownActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(249, 249, 249));
        jLabel2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(35, 35, 35));
        jLabel2.setText("Sales Status");

        jCheckBox1.setBackground(new java.awt.Color(249, 249, 249));
        jCheckBox1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jCheckBox1.setForeground(new java.awt.Color(35, 35, 35));
        jCheckBox1.setText("Table Open Date");

        jCheckBox2.setBackground(new java.awt.Color(249, 249, 249));
        jCheckBox2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jCheckBox2.setForeground(new java.awt.Color(35, 35, 35));
        jCheckBox2.setText("POS ID");

        SearchField.setBackground(new java.awt.Color(249, 249, 249));
        SearchField.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        SearchField.setForeground(new java.awt.Color(35, 35, 35));
        SearchField.setText("Find by Id");
        SearchField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SearchFieldMouseClicked(evt);
            }
        });
        SearchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SearchFieldKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SalesDropDown, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RefreshButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2))
                    .addComponent(SearchField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox1)
                            .addComponent(jCheckBox2))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(1, 1, 1)
                .addComponent(SalesDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(RefreshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        OpenButton.setBackground(new java.awt.Color(249, 249, 249));
        OpenButton.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        OpenButton.setForeground(new java.awt.Color(35, 35, 35));
        OpenButton.setText("Open");
        OpenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenButtonActionPerformed(evt);
            }
        });

        NewTableButton.setBackground(new java.awt.Color(249, 249, 249));
        NewTableButton.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        NewTableButton.setForeground(new java.awt.Color(35, 35, 35));
        NewTableButton.setText("New Table");
        NewTableButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewTableButtonActionPerformed(evt);
            }
        });

        PrintButton.setBackground(new java.awt.Color(249, 249, 249));
        PrintButton.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        PrintButton.setForeground(new java.awt.Color(35, 35, 35));
        PrintButton.setText("Print");
        PrintButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintButtonActionPerformed(evt);
            }
        });

        ViewButton.setBackground(new java.awt.Color(249, 249, 249));
        ViewButton.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        ViewButton.setForeground(new java.awt.Color(35, 35, 35));
        ViewButton.setText("View");
        ViewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewButtonActionPerformed(evt);
            }
        });

        TenderButton.setBackground(new java.awt.Color(249, 249, 249));
        TenderButton.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        TenderButton.setForeground(new java.awt.Color(35, 35, 35));
        TenderButton.setText("Tender");
        TenderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TenderButtonActionPerformed(evt);
            }
        });

        CloseButton.setBackground(new java.awt.Color(249, 249, 249));
        CloseButton.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        CloseButton.setForeground(new java.awt.Color(35, 35, 35));
        CloseButton.setText("Close");
        CloseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(OpenButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(NewTableButton, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                            .addComponent(PrintButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ViewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TenderButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CloseButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(239, 239, 239)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OpenButton, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(ViewButton, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NewTableButton, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(TenderButton, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PrintButton, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(CloseButton, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RefreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshButtonActionPerformed
        model = new DefaultTableModel();
        
        TransactionTable.setModel(model);
        model.addColumn("Transaction Id");
        model.addColumn("Table Num");
        model.addColumn("Total");
        model.addColumn("Transaction Date");
        model.addColumn("Payment Status");
        
        String choice = (String) SalesDropDown.getSelectedItem();
        if (choice.equals("All")){
            getData();
        }else{
            getData(choice);
        }
        
    }//GEN-LAST:event_RefreshButtonActionPerformed

    private void OpenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenButtonActionPerformed
        
        int i = TransactionTable.getSelectedRow();
        
        if(i == -1){
            JOptionPane.showMessageDialog(OpenButton, "Harap pilih salah satu data!",
                    "Warning!", JOptionPane.WARNING_MESSAGE);
            return;
        }
        else{
            String idString = model.getValueAt(i, 0).toString();
            model = new DefaultTableModel();
        
            TransactionTable.setModel(model);
            model.addColumn("Transaction Id");
            model.addColumn("Table Num");
            model.addColumn("Product Name");
            model.addColumn("Quantity");
            model.addColumn("Price");
            model.addColumn("Sub Total");
            model.addColumn("Transaction Date");
            model.addColumn("Payment Status");

            getTransactionDetails(Integer.parseInt(idString));
        }       
    }//GEN-LAST:event_OpenButtonActionPerformed

    private void NewTableButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewTableButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NewTableButtonActionPerformed

    private void PrintButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PrintButtonActionPerformed

    private void ViewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ViewButtonActionPerformed

    private void TenderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TenderButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TenderButtonActionPerformed

    private void CloseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseButtonActionPerformed
        dispose();
        MainMenu mm = new MainMenu(userView, loginStatusView);
        mm.setVisible(true);
    }//GEN-LAST:event_CloseButtonActionPerformed

    private void SalesDropDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalesDropDownActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SalesDropDownActionPerformed

    private void SearchFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchFieldKeyPressed
        String idString = SearchField.getText();

        if (SearchField.getText().isEmpty() == false) {
            if(evt.getKeyCode() == KeyEvent.VK_ENTER){
                model = new DefaultTableModel();
        
                TransactionTable.setModel(model);
                model.addColumn("Transaction Id");
                model.addColumn("Table Num");
                model.addColumn("Total");
                model.addColumn("Transaction Date");
                model.addColumn("Payment Status");
                setTableById(idString);
                SearchField.setText("Find by Id");
            }
        }
    }//GEN-LAST:event_SearchFieldKeyPressed

    private void SearchFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchFieldMouseClicked
        SearchField.setText("");
    }//GEN-LAST:event_SearchFieldMouseClicked

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
            java.util.logging.Logger.getLogger(ViewTransaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewTransaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewTransaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewTransaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewTransaction().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CloseButton;
    private javax.swing.JButton NewTableButton;
    private javax.swing.JButton OpenButton;
    private javax.swing.JButton PrintButton;
    private javax.swing.JButton RefreshButton;
    private javax.swing.JComboBox<String> SalesDropDown;
    private javax.swing.JTextField SearchField;
    private javax.swing.JButton TenderButton;
    private javax.swing.JTable TransactionTable;
    private javax.swing.JButton ViewButton;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
