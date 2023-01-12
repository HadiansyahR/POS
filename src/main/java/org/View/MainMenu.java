/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.View;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.Controller.ControllerProduct;
import org.Controller.ControllerTransaction;
import org.Controller.ControllerUser;
import org.Model.Product;
import org.Model.Transaction;
import org.Model.User;

/**
 *
 * @author Dreamvalian
 */
public class MainMenu extends javax.swing.JFrame {

    static ControllerUser contUser;
    static ControllerProduct contProd;
    static ControllerTransaction contTrans;
    
    static List<Product> listProduct;
    static Product product;
    
//    static List<Transaction> listTransaction = new ArrayList<>();
    static List<Transaction> listTransaction;
    static Transaction transaction;
    
    static User user;
    
    static int loginStatus = 0;
    static int orderRow;
    
    static double totalBill;
    static final double tax = 0.21;
    
    static String textValue = "";
    static String tableNum = "";
    
    private DefaultTableModel model;
    /**
     * Creates new form Splash
     */
    public MainMenu() {
//        PinForm.setEditable(false);
        setTitle("Please Login to Proceed");
        
        initComponents();
        tableNum = "";
        loginStatus = 0;
        
        model = new DefaultTableModel();
        TableOrder.setModel(model);
        model.addColumn("Qty");
        model.addColumn("Description");
        model.addColumn("Amount");
                
        SubTotalButton.setEnabled(false);
        ViewTransButton.setEnabled(false);
        TableHoldButton.setEnabled(false);
        DineInButton.setEnabled(false);
        TakeawayButton.setEnabled(false);
        
        PrintBillButton.setEnabled(false);
        FunctionButton.setEnabled(false);
        VoidButton.setEnabled(false);
        DiscountBtn.setEnabled(false);
        
        Category1Button.setEnabled(false);
        SubCategory1Button1.setEnabled(false);
        SubCategory1Button2.setEnabled(false);
        SubCategory1Button3.setEnabled(false);
        SubCategory1Button4.setEnabled(false);
        SubCategory1Button5.setEnabled(false);
        
        Category2Button.setEnabled(false);
        SubCategory2_1Button.setEnabled(false);
        SubCategory2_1Button1.setEnabled(false);
        SubCategory2_1Button2.setEnabled(false);
        SubCategory2_1Button3.setEnabled(false);
        SubCategory2_1Button4.setEnabled(false);
        
        SubCategory2_2Button.setEnabled(false);
        SubCategory2_2Button1.setEnabled(false);
        SubCategory2_2Button2.setEnabled(false);
        SubCategory2_2Button3.setEnabled(false);
        
        ProductButton1.setEnabled(false);
        ProductButton2.setEnabled(false);
        ProductButton3.setEnabled(false);
        ProductButton4.setEnabled(false);
        
        SubTotalField.setText("0.0");
        DiscountField.setText("0.0");
        TotalField.setText("0.0");
        
        this.setLocationRelativeTo(null);
    }
    
    public MainMenu(User user, int loginStatus) {
//        PinForm.setEditable(false);
//        setTitle("Please Login to Proceed");
        
        initComponents();
        tableNum = "";
        
        model = new DefaultTableModel();
        TableOrder.setModel(model);
        model.addColumn("Qty");
        model.addColumn("Description");
        model.addColumn("Amount");
                
        if (loginStatus > 0){
            user = contUser.getUser();
            setTitle(user.getUsername()+"\t"+user.getRole()+"\tTable: "+tableNum);
            clearTextField();
//            JOptionPane.showMessageDialog(null, "Login Berhasil");
            Category1Button.setEnabled(true);
            Category2Button.setEnabled(true);
            SubTotalButton.setEnabled(true);
            ViewTransButton.setEnabled(true);
            TableHoldButton.setEnabled(true);
            DineInButton.setEnabled(true);
            TakeawayButton.setEnabled(true);
            
            if (loginStatus == 1){
                PrintBillButton.setEnabled(true);
                FunctionButton.setEnabled(true);
                VoidButton.setEnabled(true);
                DiscountBtn.setEnabled(true);
            }else if (loginStatus == 2){
                PrintBillButton.setEnabled(true);
                FunctionButton.setEnabled(false);
                VoidButton.setEnabled(false);
                DiscountBtn.setEnabled(false);
            }else if (loginStatus == 3){
                PrintBillButton.setEnabled(true);
                FunctionButton.setEnabled(false);
                VoidButton.setEnabled(true);
                DiscountBtn.setEnabled(true);
            }
            
            showPassword();
        }
        
//        Category1Button.setEnabled(false);
        SubCategory1Button1.setEnabled(false);
        SubCategory1Button2.setEnabled(false);
        SubCategory1Button3.setEnabled(false);
        SubCategory1Button4.setEnabled(false);
        SubCategory1Button5.setEnabled(false);
        
//        Category2Button.setEnabled(false);
        SubCategory2_1Button.setEnabled(false);
        SubCategory2_1Button1.setEnabled(false);
        SubCategory2_1Button2.setEnabled(false);
        SubCategory2_1Button3.setEnabled(false);
        SubCategory2_1Button4.setEnabled(false);
        
        SubCategory2_2Button.setEnabled(false);
        SubCategory2_2Button1.setEnabled(false);
        SubCategory2_2Button2.setEnabled(false);
        SubCategory2_2Button3.setEnabled(false);
        
        ProductButton1.setEnabled(false);
        ProductButton2.setEnabled(false);
        ProductButton3.setEnabled(false);
        ProductButton4.setEnabled(false);
        
        SubTotalField.setText("0.0");
        DiscountField.setText("0.0");
        TotalField.setText("0.0");
        
        this.setLocationRelativeTo(null);
    }
    
    public void setTable(String quantity, Product product){
        DefaultTableModel dtm = (DefaultTableModel) TableOrder.getModel();
        
        String[] data = new String[5];
        double amount = Integer.parseInt(quantity) * product.getPrice();
        
        data[0] = quantity;
        data[1] = product.getProduct_name();
        data[2] = String.valueOf(amount);
        
        dtm.addRow(data);
    }
    
    public void setFrame(String subcategory){
        contProd = new ControllerProduct();
        listProduct = new ArrayList<>();
        
        ProductButton1.setText("");
        ProductButton2.setText("");
        ProductButton3.setText("");
        ProductButton4.setText("");
        
        listProduct = contProd.getProductsByCategory(subcategory);
        ProductButton1.setText(listProduct.get(0).getProduct_name());
        ProductButton2.setText(listProduct.get(1).getProduct_name());
        ProductButton3.setText(listProduct.get(2).getProduct_name());
        ProductButton4.setText(listProduct.get(3).getProduct_name());
        
//        if(subcategory.equals("Pork")){
//            listProduct = contProd.getFood();
//            ProductButton1.setText(listProduct.get(0).getProduct_name());
//            ProductButton2.setText(listProduct.get(1).getProduct_name());
//            ProductButton3.setText(listProduct.get(2).getProduct_name());
//            ProductButton4.setText(listProduct.get(3).getProduct_name());
//        }
//        else if(subcategory.equals("Coffee")){
//            listProduct = contProd.getBeverage();
//            ProductButton1.setText(listProduct.get(0).getProduct_name());
//            ProductButton2.setText(listProduct.get(1).getProduct_name());
//            ProductButton3.setText(listProduct.get(2).getProduct_name());
//            ProductButton4.setText(listProduct.get(3).getProduct_name());            
//        }
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DiscountButton = new javax.swing.JButton();
        TablePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableOrder = new javax.swing.JTable();
        BillPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        SubTotalField = new javax.swing.JTextField();
        TotalField = new javax.swing.JTextField();
        DiscountField = new javax.swing.JTextField();
        NumpadPanel = new javax.swing.JPanel();
        Button7 = new javax.swing.JButton();
        Button8 = new javax.swing.JButton();
        Button9 = new javax.swing.JButton();
        Button4 = new javax.swing.JButton();
        Button5 = new javax.swing.JButton();
        Button6 = new javax.swing.JButton();
        Button3 = new javax.swing.JButton();
        Button2 = new javax.swing.JButton();
        Button1 = new javax.swing.JButton();
        Button0 = new javax.swing.JButton();
        DotButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        PinForm = new javax.swing.JPasswordField();
        FunctionPanel = new javax.swing.JPanel();
        SubTotalButton = new javax.swing.JButton();
        TableHoldButton = new javax.swing.JButton();
        TakeawayButton = new javax.swing.JButton();
        ViewTransButton = new javax.swing.JButton();
        DineInButton = new javax.swing.JButton();
        CategoryPanel = new javax.swing.JPanel();
        Category2Button = new javax.swing.JButton();
        Category1Button = new javax.swing.JButton();
        SubCategory1Button1 = new javax.swing.JButton();
        SubCategory1Button2 = new javax.swing.JButton();
        SubCategory1Button3 = new javax.swing.JButton();
        SubCategory1Button4 = new javax.swing.JButton();
        SubCategory1Button5 = new javax.swing.JButton();
        SubCategory2_1Button = new javax.swing.JButton();
        SubCategory2_2Button = new javax.swing.JButton();
        SubCategory2_2Button1 = new javax.swing.JButton();
        SubCategory2_1Button1 = new javax.swing.JButton();
        SubCategory2_1Button2 = new javax.swing.JButton();
        SubCategory2_1Button3 = new javax.swing.JButton();
        SubCategory2_2Button2 = new javax.swing.JButton();
        SubCategory2_2Button3 = new javax.swing.JButton();
        SubCategory2_1Button4 = new javax.swing.JButton();
        Category3Button1 = new javax.swing.JButton();
        BottomFunctionPanel = new javax.swing.JPanel();
        CloseButton = new javax.swing.JButton();
        SignInButton = new javax.swing.JButton();
        VoidButton = new javax.swing.JButton();
        PrintBillButton = new javax.swing.JButton();
        FunctionButton = new javax.swing.JButton();
        DiscountBtn = new javax.swing.JButton();
        ProductPanel = new javax.swing.JPanel();
        ProductButton1 = new javax.swing.JButton();
        ProductButton2 = new javax.swing.JButton();
        ProductButton3 = new javax.swing.JButton();
        ProductButton4 = new javax.swing.JButton();

        DiscountButton.setBackground(new java.awt.Color(249, 249, 249));
        DiscountButton.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        DiscountButton.setForeground(new java.awt.Color(35, 35, 35));
        DiscountButton.setText("Discount");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(35, 35, 35));

        TablePanel.setBackground(new java.awt.Color(71, 103, 237));

        TableOrder.setBackground(new java.awt.Color(249, 249, 249));
        TableOrder.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        TableOrder.setForeground(new java.awt.Color(35, 35, 35));
        TableOrder.setModel(new javax.swing.table.DefaultTableModel(
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
        TableOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableOrderMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableOrder);

        BillPanel.setBackground(new java.awt.Color(249, 249, 249));

        jLabel1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(35, 35, 35));
        jLabel1.setText("Sub Total:");

        jLabel2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(35, 35, 35));
        jLabel2.setText("Total: ");

        jLabel3.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(35, 35, 35));
        jLabel3.setText("Disc:");

        jSeparator1.setForeground(new java.awt.Color(35, 35, 35));

        SubTotalField.setBackground(new java.awt.Color(249, 249, 249));
        SubTotalField.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        SubTotalField.setForeground(new java.awt.Color(35, 35, 35));
        SubTotalField.setBorder(null);

        TotalField.setBackground(new java.awt.Color(249, 249, 249));
        TotalField.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        TotalField.setForeground(new java.awt.Color(35, 35, 35));
        TotalField.setBorder(null);

        DiscountField.setBackground(new java.awt.Color(249, 249, 249));
        DiscountField.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        DiscountField.setForeground(new java.awt.Color(35, 35, 35));
        DiscountField.setBorder(null);

        javax.swing.GroupLayout BillPanelLayout = new javax.swing.GroupLayout(BillPanel);
        BillPanel.setLayout(BillPanelLayout);
        BillPanelLayout.setHorizontalGroup(
            BillPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BillPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BillPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(BillPanelLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TotalField, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BillPanelLayout.createSequentialGroup()
                        .addGroup(BillPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(BillPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(DiscountField, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                            .addComponent(SubTotalField))))
                .addContainerGap())
        );
        BillPanelLayout.setVerticalGroup(
            BillPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BillPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(BillPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(SubTotalField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(BillPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(DiscountField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(BillPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TotalField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout TablePanelLayout = new javax.swing.GroupLayout(TablePanel);
        TablePanel.setLayout(TablePanelLayout);
        TablePanelLayout.setHorizontalGroup(
            TablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(BillPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        TablePanelLayout.setVerticalGroup(
            TablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BillPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        NumpadPanel.setBackground(new java.awt.Color(255, 204, 204));

        Button7.setBackground(new java.awt.Color(249, 249, 249));
        Button7.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        Button7.setForeground(new java.awt.Color(35, 35, 35));
        Button7.setText("7");
        Button7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button7ActionPerformed(evt);
            }
        });

        Button8.setBackground(new java.awt.Color(249, 249, 249));
        Button8.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        Button8.setForeground(new java.awt.Color(35, 35, 35));
        Button8.setText("8");
        Button8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button8ActionPerformed(evt);
            }
        });

        Button9.setBackground(new java.awt.Color(249, 249, 249));
        Button9.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        Button9.setForeground(new java.awt.Color(35, 35, 35));
        Button9.setText("9");
        Button9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button9ActionPerformed(evt);
            }
        });

        Button4.setBackground(new java.awt.Color(249, 249, 249));
        Button4.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        Button4.setForeground(new java.awt.Color(35, 35, 35));
        Button4.setText("4");
        Button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button4ActionPerformed(evt);
            }
        });

        Button5.setBackground(new java.awt.Color(249, 249, 249));
        Button5.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        Button5.setForeground(new java.awt.Color(35, 35, 35));
        Button5.setText("5");
        Button5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button5ActionPerformed(evt);
            }
        });

        Button6.setBackground(new java.awt.Color(249, 249, 249));
        Button6.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        Button6.setForeground(new java.awt.Color(35, 35, 35));
        Button6.setText("6");
        Button6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button6ActionPerformed(evt);
            }
        });

        Button3.setBackground(new java.awt.Color(249, 249, 249));
        Button3.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        Button3.setForeground(new java.awt.Color(35, 35, 35));
        Button3.setText("3");
        Button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button3ActionPerformed(evt);
            }
        });

        Button2.setBackground(new java.awt.Color(249, 249, 249));
        Button2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        Button2.setForeground(new java.awt.Color(35, 35, 35));
        Button2.setText("2");
        Button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button2ActionPerformed(evt);
            }
        });

        Button1.setBackground(new java.awt.Color(249, 249, 249));
        Button1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        Button1.setForeground(new java.awt.Color(35, 35, 35));
        Button1.setText("1");
        Button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button1ActionPerformed(evt);
            }
        });

        Button0.setBackground(new java.awt.Color(249, 249, 249));
        Button0.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        Button0.setForeground(new java.awt.Color(35, 35, 35));
        Button0.setText("0");
        Button0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button0ActionPerformed(evt);
            }
        });

        DotButton.setBackground(new java.awt.Color(249, 249, 249));
        DotButton.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        DotButton.setForeground(new java.awt.Color(35, 35, 35));
        DotButton.setText(".");
        DotButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DotButtonActionPerformed(evt);
            }
        });

        DeleteButton.setBackground(new java.awt.Color(249, 249, 249));
        DeleteButton.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        DeleteButton.setForeground(new java.awt.Color(35, 35, 35));
        DeleteButton.setText("Del");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout NumpadPanelLayout = new javax.swing.GroupLayout(NumpadPanel);
        NumpadPanel.setLayout(NumpadPanelLayout);
        NumpadPanelLayout.setHorizontalGroup(
            NumpadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NumpadPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(NumpadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PinForm)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NumpadPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Button1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Button2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Button3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(NumpadPanelLayout.createSequentialGroup()
                        .addComponent(Button0, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DotButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(DeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(NumpadPanelLayout.createSequentialGroup()
                        .addGroup(NumpadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Button7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Button4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(NumpadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(NumpadPanelLayout.createSequentialGroup()
                                .addComponent(Button5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Button6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NumpadPanelLayout.createSequentialGroup()
                                .addComponent(Button8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Button9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        NumpadPanelLayout.setVerticalGroup(
            NumpadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NumpadPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PinForm, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(NumpadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Button8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Button9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(NumpadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Button5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Button6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(NumpadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Button2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Button3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(NumpadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button0, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DotButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        FunctionPanel.setBackground(new java.awt.Color(249, 248, 113));

        SubTotalButton.setBackground(new java.awt.Color(249, 249, 249));
        SubTotalButton.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        SubTotalButton.setForeground(new java.awt.Color(35, 35, 35));
        SubTotalButton.setText("Sub Total");
        SubTotalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubTotalButtonActionPerformed(evt);
            }
        });

        TableHoldButton.setBackground(new java.awt.Color(249, 249, 249));
        TableHoldButton.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        TableHoldButton.setForeground(new java.awt.Color(35, 35, 35));
        TableHoldButton.setText("Table / Hold");
        TableHoldButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TableHoldButtonActionPerformed(evt);
            }
        });

        TakeawayButton.setBackground(new java.awt.Color(249, 249, 249));
        TakeawayButton.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        TakeawayButton.setForeground(new java.awt.Color(35, 35, 35));
        TakeawayButton.setText("Take Away");
        TakeawayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TakeawayButtonActionPerformed(evt);
            }
        });

        ViewTransButton.setBackground(new java.awt.Color(249, 249, 249));
        ViewTransButton.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        ViewTransButton.setForeground(new java.awt.Color(35, 35, 35));
        ViewTransButton.setText("View Trans.");
        ViewTransButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewTransButtonActionPerformed(evt);
            }
        });

        DineInButton.setBackground(new java.awt.Color(249, 249, 249));
        DineInButton.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        DineInButton.setForeground(new java.awt.Color(35, 35, 35));
        DineInButton.setText("Dine In");
        DineInButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DineInButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout FunctionPanelLayout = new javax.swing.GroupLayout(FunctionPanel);
        FunctionPanel.setLayout(FunctionPanelLayout);
        FunctionPanelLayout.setHorizontalGroup(
            FunctionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FunctionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(FunctionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SubTotalButton, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                    .addComponent(TableHoldButton, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                    .addComponent(TakeawayButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                    .addComponent(ViewTransButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DineInButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))
                .addContainerGap())
        );
        FunctionPanelLayout.setVerticalGroup(
            FunctionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FunctionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SubTotalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ViewTransButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TableHoldButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DineInButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(TakeawayButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        CategoryPanel.setBackground(new java.awt.Color(249, 249, 249));
        CategoryPanel.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        Category2Button.setBackground(new java.awt.Color(249, 249, 249));
        Category2Button.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        Category2Button.setForeground(new java.awt.Color(35, 35, 35));
        Category2Button.setText("Beverages");
        Category2Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Category2ButtonActionPerformed(evt);
            }
        });

        Category1Button.setBackground(new java.awt.Color(249, 249, 249));
        Category1Button.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        Category1Button.setForeground(new java.awt.Color(35, 35, 35));
        Category1Button.setText("Food");
        Category1Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Category1ButtonActionPerformed(evt);
            }
        });

        SubCategory1Button1.setBackground(new java.awt.Color(249, 249, 249));
        SubCategory1Button1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        SubCategory1Button1.setForeground(new java.awt.Color(35, 35, 35));
        SubCategory1Button1.setText("Appetizer");
        SubCategory1Button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubCategory1Button1ActionPerformed(evt);
            }
        });

        SubCategory1Button2.setBackground(new java.awt.Color(249, 249, 249));
        SubCategory1Button2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        SubCategory1Button2.setForeground(new java.awt.Color(35, 35, 35));
        SubCategory1Button2.setText("Soup");
        SubCategory1Button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubCategory1Button2ActionPerformed(evt);
            }
        });

        SubCategory1Button3.setBackground(new java.awt.Color(249, 249, 249));
        SubCategory1Button3.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        SubCategory1Button3.setForeground(new java.awt.Color(35, 35, 35));
        SubCategory1Button3.setText("Salad");
        SubCategory1Button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubCategory1Button3ActionPerformed(evt);
            }
        });

        SubCategory1Button4.setBackground(new java.awt.Color(249, 249, 249));
        SubCategory1Button4.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        SubCategory1Button4.setForeground(new java.awt.Color(35, 35, 35));
        SubCategory1Button4.setText("Main Course");
        SubCategory1Button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubCategory1Button4ActionPerformed(evt);
            }
        });

        SubCategory1Button5.setBackground(new java.awt.Color(249, 249, 249));
        SubCategory1Button5.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        SubCategory1Button5.setForeground(new java.awt.Color(35, 35, 35));
        SubCategory1Button5.setText("Dessert");
        SubCategory1Button5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubCategory1Button5ActionPerformed(evt);
            }
        });

        SubCategory2_1Button.setBackground(new java.awt.Color(249, 249, 249));
        SubCategory2_1Button.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        SubCategory2_1Button.setForeground(new java.awt.Color(35, 35, 35));
        SubCategory2_1Button.setText("Alcoholic");
        SubCategory2_1Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubCategory2_1ButtonActionPerformed(evt);
            }
        });

        SubCategory2_2Button.setBackground(new java.awt.Color(249, 249, 249));
        SubCategory2_2Button.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        SubCategory2_2Button.setForeground(new java.awt.Color(35, 35, 35));
        SubCategory2_2Button.setText("Non-Alcoholic");
        SubCategory2_2Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubCategory2_2ButtonActionPerformed(evt);
            }
        });

        SubCategory2_2Button1.setBackground(new java.awt.Color(249, 249, 249));
        SubCategory2_2Button1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        SubCategory2_2Button1.setForeground(new java.awt.Color(35, 35, 35));
        SubCategory2_2Button1.setText("Coffee");
        SubCategory2_2Button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubCategory2_2Button1ActionPerformed(evt);
            }
        });

        SubCategory2_1Button1.setBackground(new java.awt.Color(249, 249, 249));
        SubCategory2_1Button1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        SubCategory2_1Button1.setForeground(new java.awt.Color(35, 35, 35));
        SubCategory2_1Button1.setText("Spirit");
        SubCategory2_1Button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubCategory2_1Button1ActionPerformed(evt);
            }
        });

        SubCategory2_1Button2.setBackground(new java.awt.Color(249, 249, 249));
        SubCategory2_1Button2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        SubCategory2_1Button2.setForeground(new java.awt.Color(35, 35, 35));
        SubCategory2_1Button2.setText("Wine");
        SubCategory2_1Button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubCategory2_1Button2ActionPerformed(evt);
            }
        });

        SubCategory2_1Button3.setBackground(new java.awt.Color(249, 249, 249));
        SubCategory2_1Button3.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        SubCategory2_1Button3.setForeground(new java.awt.Color(35, 35, 35));
        SubCategory2_1Button3.setText("Liquor");
        SubCategory2_1Button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubCategory2_1Button3ActionPerformed(evt);
            }
        });

        SubCategory2_2Button2.setBackground(new java.awt.Color(249, 249, 249));
        SubCategory2_2Button2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        SubCategory2_2Button2.setForeground(new java.awt.Color(35, 35, 35));
        SubCategory2_2Button2.setText("Juice");
        SubCategory2_2Button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubCategory2_2Button2ActionPerformed(evt);
            }
        });

        SubCategory2_2Button3.setBackground(new java.awt.Color(249, 249, 249));
        SubCategory2_2Button3.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        SubCategory2_2Button3.setForeground(new java.awt.Color(35, 35, 35));
        SubCategory2_2Button3.setText("Mocktail");
        SubCategory2_2Button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubCategory2_2Button3ActionPerformed(evt);
            }
        });

        SubCategory2_1Button4.setBackground(new java.awt.Color(249, 249, 249));
        SubCategory2_1Button4.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        SubCategory2_1Button4.setForeground(new java.awt.Color(35, 35, 35));
        SubCategory2_1Button4.setText("Cocktail");
        SubCategory2_1Button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubCategory2_1Button4ActionPerformed(evt);
            }
        });

        Category3Button1.setBackground(new java.awt.Color(249, 249, 249));
        Category3Button1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        Category3Button1.setForeground(new java.awt.Color(35, 35, 35));
        Category3Button1.setText("Other");
        Category3Button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Category3Button1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CategoryPanelLayout = new javax.swing.GroupLayout(CategoryPanel);
        CategoryPanel.setLayout(CategoryPanelLayout);
        CategoryPanelLayout.setHorizontalGroup(
            CategoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CategoryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CategoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(SubCategory1Button1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SubCategory1Button2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SubCategory1Button3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SubCategory1Button4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SubCategory1Button5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Category1Button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CategoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(CategoryPanelLayout.createSequentialGroup()
                        .addGroup(CategoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Category2Button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SubCategory2_1Button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SubCategory2_2Button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(CategoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(SubCategory2_2Button1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SubCategory2_1Button1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(CategoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(SubCategory2_2Button2, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                            .addComponent(SubCategory2_1Button2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(6, 6, 6)
                        .addGroup(CategoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(CategoryPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(SubCategory2_1Button3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SubCategory2_1Button4, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(SubCategory2_2Button3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(Category3Button1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        CategoryPanelLayout.setVerticalGroup(
            CategoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CategoryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CategoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Category1Button, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Category2Button, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CategoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SubCategory1Button1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SubCategory2_1Button, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SubCategory2_1Button1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SubCategory2_1Button2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SubCategory2_1Button3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SubCategory2_1Button4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CategoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SubCategory1Button2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SubCategory2_2Button, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SubCategory2_2Button1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SubCategory2_2Button2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SubCategory2_2Button3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SubCategory1Button3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SubCategory1Button4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(CategoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Category3Button1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(SubCategory1Button5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        BottomFunctionPanel.setBackground(new java.awt.Color(249, 249, 249));

        CloseButton.setBackground(new java.awt.Color(249, 249, 249));
        CloseButton.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        CloseButton.setForeground(new java.awt.Color(35, 35, 35));
        CloseButton.setText("Close");
        CloseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseButtonActionPerformed(evt);
            }
        });

        SignInButton.setBackground(new java.awt.Color(249, 249, 249));
        SignInButton.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        SignInButton.setForeground(new java.awt.Color(35, 35, 35));
        SignInButton.setText("Sign In / OP");
        SignInButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignInButtonActionPerformed(evt);
            }
        });

        VoidButton.setBackground(new java.awt.Color(249, 249, 249));
        VoidButton.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        VoidButton.setForeground(new java.awt.Color(35, 35, 35));
        VoidButton.setText("Void");
        VoidButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VoidButtonActionPerformed(evt);
            }
        });

        PrintBillButton.setBackground(new java.awt.Color(249, 249, 249));
        PrintBillButton.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        PrintBillButton.setForeground(new java.awt.Color(35, 35, 35));
        PrintBillButton.setText("Print BIll");

        FunctionButton.setBackground(new java.awt.Color(249, 249, 249));
        FunctionButton.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        FunctionButton.setForeground(new java.awt.Color(35, 35, 35));
        FunctionButton.setText("Function");
        FunctionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FunctionButtonActionPerformed(evt);
            }
        });

        DiscountBtn.setBackground(new java.awt.Color(249, 249, 249));
        DiscountBtn.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        DiscountBtn.setForeground(new java.awt.Color(35, 35, 35));
        DiscountBtn.setText("Discount");
        DiscountBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DiscountBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BottomFunctionPanelLayout = new javax.swing.GroupLayout(BottomFunctionPanel);
        BottomFunctionPanel.setLayout(BottomFunctionPanelLayout);
        BottomFunctionPanelLayout.setHorizontalGroup(
            BottomFunctionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BottomFunctionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PrintBillButton, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FunctionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(VoidButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DiscountBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(SignInButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CloseButton)
                .addContainerGap())
        );
        BottomFunctionPanelLayout.setVerticalGroup(
            BottomFunctionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BottomFunctionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BottomFunctionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, BottomFunctionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(FunctionButton, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                        .addComponent(VoidButton, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                        .addComponent(DiscountBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                    .addComponent(PrintBillButton, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(SignInButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CloseButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        ProductPanel.setBackground(new java.awt.Color(255, 204, 204));

        ProductButton1.setBackground(new java.awt.Color(249, 249, 249));
        ProductButton1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        ProductButton1.setForeground(new java.awt.Color(35, 35, 35));
        ProductButton1.setText("Product 1");
        ProductButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductButton1ActionPerformed(evt);
            }
        });

        ProductButton2.setBackground(new java.awt.Color(249, 249, 249));
        ProductButton2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        ProductButton2.setForeground(new java.awt.Color(35, 35, 35));
        ProductButton2.setText("Product 2");
        ProductButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductButton2ActionPerformed(evt);
            }
        });

        ProductButton3.setBackground(new java.awt.Color(249, 249, 249));
        ProductButton3.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        ProductButton3.setForeground(new java.awt.Color(35, 35, 35));
        ProductButton3.setText("Product 3");
        ProductButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductButton3ActionPerformed(evt);
            }
        });

        ProductButton4.setBackground(new java.awt.Color(249, 249, 249));
        ProductButton4.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        ProductButton4.setForeground(new java.awt.Color(35, 35, 35));
        ProductButton4.setText("Product 4");
        ProductButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ProductPanelLayout = new javax.swing.GroupLayout(ProductPanel);
        ProductPanel.setLayout(ProductPanelLayout);
        ProductPanelLayout.setHorizontalGroup(
            ProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProductPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ProductButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ProductButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ProductButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ProductButton4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ProductPanelLayout.setVerticalGroup(
            ProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProductPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ProductButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ProductButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ProductButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ProductButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(NumpadPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FunctionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(TablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CategoryPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BottomFunctionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ProductPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(TablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FunctionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(NumpadPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(layout.createSequentialGroup()
                .addComponent(ProductPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CategoryPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BottomFunctionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void showPassword(){
        String title = getTitle();
        if(title.equals("Main menu") == false){
            PinForm.setEchoChar((char)0);
        }
    }
    
    public void clearTextField(){
        PinForm.setText("");
    }
    
    public void clearBill(){
        SubTotalField.setText("0.0");
        DiscountField.setText("0.0");
        TotalField.setText("0.0");
    }
    
    public void clearTable(){
        DefaultTableModel dtm = (DefaultTableModel) TableOrder.getModel();
        
        int row = dtm.getRowCount();
        
        for(int i = row; i>0; i--){
            dtm.removeRow(i-1);
        }
    }
    
    public void clearTableNum(){
        tableNum = "";
        setTitle(user.getUsername()+"\t"+user.getRole()+"\tTable: "+tableNum);
    }
    
    public double getAmount(){
        TableModel model = TableOrder.getModel();
        
        int row = model.getRowCount();
        double sub = 0;
        double[] amount = new double[row];
        
        for(int i = 0; i<row; i++){
            amount[i] = Double.parseDouble(model.getValueAt(i, 2).toString());
            sub = sub + amount[i];
        }
        
        return sub;
    }
    
    //method di baris 1005 - 1017 buat ngetes doang
    public void printOrder(List<Transaction> listTransaction){
        for(Transaction trans: listTransaction){
            System.out.println(trans.getTransaction_id());
            System.out.println(trans.getTable_num());
            System.out.println(trans.getProduct_name());
            System.out.println(trans.getQuantity());
            System.out.println(trans.getPrice());
            System.out.println(trans.getSubtotal());
            System.out.println(trans.getTransaction_date());
            System.out.println(trans.getPayment_status());
        }
    }
    
    private void Button7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button7ActionPerformed
        textValue = String.valueOf(PinForm.getPassword());
        if(textValue.length() < 4){
            PinForm.setText(textValue + "7");
        }
    }//GEN-LAST:event_Button7ActionPerformed

    private void Button8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button8ActionPerformed
        textValue = String.valueOf(PinForm.getPassword());
        if(textValue.length() < 4){
            PinForm.setText(textValue + "8");
        }
    }//GEN-LAST:event_Button8ActionPerformed

    private void Button9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button9ActionPerformed
        textValue = String.valueOf(PinForm.getPassword());
        if(textValue.length() < 4){
            PinForm.setText(textValue + "9");
        }
    }//GEN-LAST:event_Button9ActionPerformed

    private void Button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button4ActionPerformed
        textValue = String.valueOf(PinForm.getPassword());
        if(textValue.length() < 4){
            PinForm.setText(textValue + "4");
        }
    }//GEN-LAST:event_Button4ActionPerformed

    private void Button5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button5ActionPerformed
        textValue = String.valueOf(PinForm.getPassword());
        if(textValue.length() < 4){
            PinForm.setText(textValue + "5");
        }
    }//GEN-LAST:event_Button5ActionPerformed

    private void Button6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button6ActionPerformed
        textValue = String.valueOf(PinForm.getPassword());
        if(textValue.length() < 4){
            PinForm.setText(textValue + "6");
        }
    }//GEN-LAST:event_Button6ActionPerformed

    private void Button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button3ActionPerformed
        textValue = String.valueOf(PinForm.getPassword());
        if(textValue.length() < 4){
            PinForm.setText(textValue + "3");
        }
    }//GEN-LAST:event_Button3ActionPerformed

    private void Button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button2ActionPerformed
        textValue = String.valueOf(PinForm.getPassword());
        if(textValue.length() < 4){
            PinForm.setText(textValue + "2");
        }
    }//GEN-LAST:event_Button2ActionPerformed

    private void Button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button1ActionPerformed
        textValue = String.valueOf(PinForm.getPassword());
        if(textValue.length() < 4){
            PinForm.setText(textValue + "1");
        }
    }//GEN-LAST:event_Button1ActionPerformed

    private void Button0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button0ActionPerformed
        textValue = String.valueOf(PinForm.getPassword());
        if(textValue.length() < 4){
            PinForm.setText(textValue + "0");
        }
    }//GEN-LAST:event_Button0ActionPerformed

    private void DotButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DotButtonActionPerformed
        textValue = String.valueOf(PinForm.getPassword());
        if(textValue.length() < 4){
            PinForm.setText(textValue + ".");
        }
    }//GEN-LAST:event_DotButtonActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        textValue = String.valueOf(PinForm.getPassword());
        if(textValue.length() < 5 && textValue.length() > 0){
            textValue = textValue.substring(0, textValue.length()-1);
            PinForm.setText(textValue);
        }
        
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void Category1ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Category1ButtonActionPerformed
        SubCategory2_1Button.setEnabled(false);
        SubCategory2_1Button1.setEnabled(false);
        SubCategory2_1Button2.setEnabled(false);
        SubCategory2_1Button3.setEnabled(false);
        SubCategory2_1Button4.setEnabled(false);
        
        SubCategory2_2Button.setEnabled(false);
        SubCategory2_2Button1.setEnabled(false);
        SubCategory2_2Button2.setEnabled(false);
        SubCategory2_2Button3.setEnabled(false);
        
        SubCategory1Button1.setEnabled(true);
        SubCategory1Button2.setEnabled(true);
        SubCategory1Button3.setEnabled(true);
        SubCategory1Button4.setEnabled(true);
        SubCategory1Button5.setEnabled(true);
        
        ProductButton1.setEnabled(true);
        ProductButton1.setText("");
        ProductButton2.setEnabled(true);
        ProductButton2.setText("");
        ProductButton3.setEnabled(true);
        ProductButton3.setText("");
        ProductButton4.setEnabled(true);
        ProductButton4.setText("");
    }//GEN-LAST:event_Category1ButtonActionPerformed

    private void SubTotalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubTotalButtonActionPerformed
        double taxService, discount, subTotal, total;
        
        clearBill();
        
        subTotal = getAmount();
        discount = Double.parseDouble(DiscountField.getText());
        
        if(discount != 0){
            discount = discount * subTotal;
            total = subTotal - discount;
            
            taxService = total * tax;
            total = total + taxService;
        }
        else{
            total = subTotal;
            taxService = total * tax;
            total = total + taxService;
        }
//        if(DiscountField.getText().equals("0.0")){
//            discount = 0;
//        }
//        else{
//            discount = Double.parseDouble(DiscountField.getText());
//        }
//        double taxService;
//        
//        if(discount != 0){
//            discount = discount * subTotal;
//            total = subTotal - discount;
//            
//            taxService = total * tax;
//            total = total + taxService;
//        }
//        else{
//            total = subTotal;
//            taxService = total * tax;
//            total = total + taxService;
//        }
        
        SubTotalField.setText(String.valueOf(subTotal));
        DiscountField.setText(String.valueOf(discount));
        TotalField.setText(String.valueOf(total));
        
    }//GEN-LAST:event_SubTotalButtonActionPerformed

    private void TableHoldButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TableHoldButtonActionPerformed
        TableModel model = TableOrder.getModel();
        
        contTrans = new ControllerTransaction();
        listTransaction = new ArrayList<>();
        
        int insertStatus = 0;
        int row = model.getRowCount();
        int trans_id = contTrans.countTransactionRow();
        LocalDate trans_date = LocalDate.now();
//        DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        if(row != 0){
            if(tableNum.isEmpty()){
                JOptionPane.showMessageDialog(null, "Harap Masukkan Data Table");
            }else{
                for(int i = 0; i<row; i++){
                    product = contProd.getProduct(model.getValueAt(i, 1).toString());

                    transaction = new Transaction();

                    transaction.setTransaction_id(trans_id+1);
                    transaction.setTable_num(tableNum);
                    transaction.setProduct_name(product.getProduct_name());
                    transaction.setQuantity(Integer.parseInt(model.getValueAt(i, 0).toString()));
                    transaction.setPrice(product.getPrice());
                    transaction.setSubtotal(Double.parseDouble(model.getValueAt(i, 2).toString()));
        //            transaction.setTransaction_date(trans_date.format(dateformat));
                    transaction.setTransaction_date(trans_date.toString());
                    transaction.setPayment_status(0);

                    listTransaction.add(transaction);            
                }

                insertStatus = contTrans.insertTransaction(listTransaction);

                if(insertStatus == 1){
                    JOptionPane.showMessageDialog(null, "Order Berhasil Dilakukan");
                    clearBill();
                    clearTable();
                    clearTableNum();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Order Gagal");
                }
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Data Pesanan Kosong");
        }
        
        
        
//        printOrder(listTransaction);
        
    }//GEN-LAST:event_TableHoldButtonActionPerformed

    private void ViewTransButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewTransButtonActionPerformed
        dispose();
        ViewTransaction vt = new ViewTransaction(user, loginStatus);
        vt.setVisible(true);
    }//GEN-LAST:event_ViewTransButtonActionPerformed

    private void DineInButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DineInButtonActionPerformed
        textValue = String.valueOf(PinForm.getPassword());
        if(textValue.isEmpty()){
            JOptionPane.showMessageDialog(null, "Masukkan Nomor Tabel!!!");
        }else{
            tableNum = textValue;
            setTitle(user.getUsername()+"\t"+user.getRole()+"\tTable: "+tableNum);
        }
        clearTextField();
    }//GEN-LAST:event_DineInButtonActionPerformed

    private void TakeawayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TakeawayButtonActionPerformed
        tableNum = "TA";
        setTitle(user.getUsername()+"\t"+user.getRole()+"\tTable: "+tableNum);
    }//GEN-LAST:event_TakeawayButtonActionPerformed

    
    private void SignInButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignInButtonActionPerformed
        contUser = new ControllerUser();
        loginStatus = contUser.login(String.valueOf(PinForm.getPassword()));
        
        if (loginStatus > 0){
            user = contUser.getUser();
            setTitle(user.getUsername()+"\t"+user.getRole()+"\tTable: "+tableNum);
            clearTextField();
            JOptionPane.showMessageDialog(null, "Login Berhasil");
            Category1Button.setEnabled(true);
            Category2Button.setEnabled(true);
            SubTotalButton.setEnabled(true);
            ViewTransButton.setEnabled(true);
            TableHoldButton.setEnabled(true);
            DineInButton.setEnabled(true);
            TakeawayButton.setEnabled(true);
            
            if (loginStatus == 1){
                PrintBillButton.setEnabled(true);
                FunctionButton.setEnabled(true);
                VoidButton.setEnabled(true);
                DiscountBtn.setEnabled(true);
            }else if (loginStatus == 2){
                PrintBillButton.setEnabled(true);
                FunctionButton.setEnabled(false);
                VoidButton.setEnabled(false);
                DiscountBtn.setEnabled(false);
            }else if (loginStatus == 3){
                PrintBillButton.setEnabled(true);
                FunctionButton.setEnabled(false);
                VoidButton.setEnabled(true);
                DiscountBtn.setEnabled(true);
            }
            
            showPassword();
        }
        else{
            JOptionPane.showMessageDialog(null, "Login Gagal");
        }
        
    }//GEN-LAST:event_SignInButtonActionPerformed

    private void ProductButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductButton1ActionPerformed
        product = new Product();
        product = contProd.getProduct(ProductButton1.getText());
        
//        System.out.println(ProductButton1.getText());
//        System.out.println(product.getProduct_name());
        
        String quantity = String.valueOf(PinForm.getPassword());
        
        if(ProductButton1.getText().isEmpty() == false){
            if(quantity.isEmpty()){
            setTable("1", product);
            }
            else{
                setTable(quantity, product);
                clearTextField();
            }
        }
        
//        if(product != null){
//            JOptionPane.showMessageDialog(null, "Produk ada");
//        }
    }//GEN-LAST:event_ProductButton1ActionPerformed

    private void ProductButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductButton2ActionPerformed
        product = new Product(); 
        product = contProd.getProduct(ProductButton2.getText());
        
//        System.out.println(ProductButton2.getText());
//        System.out.println(product.getProduct_name());
        
        String quantity = String.valueOf(PinForm.getPassword());
        
        if(ProductButton2.getText().isEmpty() == false){
            if(quantity.isEmpty()){
            setTable("1", product);
            }
            else{
                setTable(quantity, product);
                clearTextField();
            }
        }
    }//GEN-LAST:event_ProductButton2ActionPerformed

    private void ProductButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductButton3ActionPerformed
        product = new Product(); 
        product = contProd.getProduct(ProductButton3.getText());
        
//        System.out.println(ProductButton2.getText());
//        System.out.println(product.getProduct_name());
        
        String quantity = String.valueOf(PinForm.getPassword());
        if(ProductButton3.getText().isEmpty() == false){
            if(quantity.isEmpty()){
            setTable("1", product);
            }
            else{
                setTable(quantity, product);
                clearTextField();
            }
        }
        
    }//GEN-LAST:event_ProductButton3ActionPerformed

    private void ProductButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductButton4ActionPerformed
        product = new Product(); 
        product = contProd.getProduct(ProductButton4.getText());
        
//        System.out.println(ProductButton2.getText());
//        System.out.println(product.getProduct_name());
        
        String quantity = String.valueOf(PinForm.getPassword());
        
        if(ProductButton4.getText().isEmpty() == false){
            if(quantity.isEmpty()){
            setTable("1", product);
            }
            else{
                setTable(quantity, product);
                clearTextField();
            }
        }
    }//GEN-LAST:event_ProductButton4ActionPerformed

    private void Category2ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Category2ButtonActionPerformed
        SubCategory1Button1.setEnabled(false);
        SubCategory1Button2.setEnabled(false);
        SubCategory1Button3.setEnabled(false);
        SubCategory1Button4.setEnabled(false);
        SubCategory1Button5.setEnabled(false);
        
        SubCategory2_1Button.setEnabled(true);
//        SubCategory2_1Button1.setEnabled(true);
//        SubCategory2_1Button2.setEnabled(true);
//        SubCategory2_1Button3.setEnabled(true);
//        SubCategory2_1Button4.setEnabled(true);
        
        SubCategory2_2Button.setEnabled(true);
//        SubCategory2_2Button1.setEnabled(true);
//        SubCategory2_2Button2.setEnabled(true);
//        SubCategory2_2Button3.setEnabled(true);
        
        ProductButton1.setEnabled(true);
        ProductButton1.setText("");
        ProductButton2.setEnabled(true);
        ProductButton2.setText("");
        ProductButton3.setEnabled(true);
        ProductButton3.setText("");
        ProductButton4.setEnabled(true);
        ProductButton4.setText("");
    }//GEN-LAST:event_Category2ButtonActionPerformed

    private void SubCategory1Button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubCategory1Button1ActionPerformed
        setFrame(SubCategory1Button1.getText());
    }//GEN-LAST:event_SubCategory1Button1ActionPerformed

    private void SubCategory1Button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubCategory1Button2ActionPerformed
        setFrame(SubCategory1Button2.getText());
    }//GEN-LAST:event_SubCategory1Button2ActionPerformed

    private void SubCategory1Button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubCategory1Button3ActionPerformed
        setFrame(SubCategory1Button3.getText());
    }//GEN-LAST:event_SubCategory1Button3ActionPerformed

    private void SubCategory1Button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubCategory1Button4ActionPerformed
        setFrame(SubCategory1Button4.getText());
    }//GEN-LAST:event_SubCategory1Button4ActionPerformed

    private void SubCategory1Button5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubCategory1Button5ActionPerformed
        setFrame(SubCategory1Button5.getText());
    }//GEN-LAST:event_SubCategory1Button5ActionPerformed

    private void SubCategory2_1ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubCategory2_1ButtonActionPerformed
        SubCategory2_2Button1.setEnabled(false);
        SubCategory2_2Button2.setEnabled(false);
        SubCategory2_2Button3.setEnabled(false);
        
        SubCategory2_1Button1.setEnabled(true);
        SubCategory2_1Button2.setEnabled(true);
        SubCategory2_1Button3.setEnabled(true);
        SubCategory2_1Button4.setEnabled(true);
    }//GEN-LAST:event_SubCategory2_1ButtonActionPerformed

    private void SubCategory2_2ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubCategory2_2ButtonActionPerformed
        SubCategory2_2Button1.setEnabled(true);
        SubCategory2_2Button2.setEnabled(true);
        SubCategory2_2Button3.setEnabled(true);
        
        SubCategory2_1Button1.setEnabled(false);
        SubCategory2_1Button2.setEnabled(false);
        SubCategory2_1Button3.setEnabled(false);
        SubCategory2_1Button4.setEnabled(false);
    }//GEN-LAST:event_SubCategory2_2ButtonActionPerformed

    private void SubCategory2_2Button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubCategory2_2Button1ActionPerformed
        setFrame(SubCategory2_2Button1.getText());
    }//GEN-LAST:event_SubCategory2_2Button1ActionPerformed

    private void SubCategory2_1Button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubCategory2_1Button1ActionPerformed
        setFrame(SubCategory2_1Button1.getText());
    }//GEN-LAST:event_SubCategory2_1Button1ActionPerformed

    private void SubCategory2_1Button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubCategory2_1Button2ActionPerformed
        setFrame(SubCategory2_1Button2.getText());
    }//GEN-LAST:event_SubCategory2_1Button2ActionPerformed

    private void SubCategory2_1Button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubCategory2_1Button3ActionPerformed
        setFrame(SubCategory2_1Button3.getText());
    }//GEN-LAST:event_SubCategory2_1Button3ActionPerformed

    private void SubCategory2_2Button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubCategory2_2Button2ActionPerformed
        setFrame(SubCategory2_2Button2.getText());
    }//GEN-LAST:event_SubCategory2_2Button2ActionPerformed

    private void SubCategory2_2Button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubCategory2_2Button3ActionPerformed
        setFrame(SubCategory2_2Button3.getText());
    }//GEN-LAST:event_SubCategory2_2Button3ActionPerformed

    private void SubCategory2_1Button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubCategory2_1Button4ActionPerformed
        setFrame(SubCategory2_1Button4.getText());
    }//GEN-LAST:event_SubCategory2_1Button4ActionPerformed

    private void Category3Button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Category3Button1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Category3Button1ActionPerformed

    private void CloseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseButtonActionPerformed
        SplashScreen splash = new SplashScreen();
        dispose();
        splash.setVisible(true);
    }//GEN-LAST:event_CloseButtonActionPerformed

    public double countDiscount(){
        double taxService, discount, total = 0;
        
        double sub = Double.parseDouble(SubTotalField.getText());
        
        if(sub != 0){
            if(String.valueOf(PinForm.getPassword()).isEmpty()){
                discount = 0;
            }else{
                discount = Double.parseDouble(String.valueOf(PinForm.getPassword()));
            }
            
            discount = discount * sub;

            total = sub - discount;
            taxService = total * tax;

            total = total + taxService;

            DiscountField.setText(String.valueOf(discount));

            TotalField.setText(String.valueOf(total));
            clearTextField();
        }else{
            JOptionPane.showMessageDialog(null, "Sub Total Kosong");
        }
        
        return total;
    }
    
    private void DiscountBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DiscountBtnActionPerformed
        totalBill = countDiscount();        
    }//GEN-LAST:event_DiscountBtnActionPerformed

    public void deleteRow(){
        DefaultTableModel dtm = (DefaultTableModel) TableOrder.getModel();
        if(TableOrder.isRowSelected(orderRow)){
            dtm.removeRow(orderRow);
        }
    }
    
    private void VoidButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VoidButtonActionPerformed
        deleteRow();
    }//GEN-LAST:event_VoidButtonActionPerformed

    private void TableOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableOrderMouseClicked
        orderRow = TableOrder.getSelectedRow();
    }//GEN-LAST:event_TableOrderMouseClicked

    private void FunctionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FunctionButtonActionPerformed
        dispose();
        FunctionView fv = new FunctionView(user, loginStatus);
        fv.setVisible(true);
    }//GEN-LAST:event_FunctionButtonActionPerformed

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
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BillPanel;
    private javax.swing.JPanel BottomFunctionPanel;
    private javax.swing.JButton Button0;
    private javax.swing.JButton Button1;
    private javax.swing.JButton Button2;
    private javax.swing.JButton Button3;
    private javax.swing.JButton Button4;
    private javax.swing.JButton Button5;
    private javax.swing.JButton Button6;
    private javax.swing.JButton Button7;
    private javax.swing.JButton Button8;
    private javax.swing.JButton Button9;
    private javax.swing.JButton Category1Button;
    private javax.swing.JButton Category2Button;
    private javax.swing.JButton Category3Button1;
    private javax.swing.JPanel CategoryPanel;
    private javax.swing.JButton CloseButton;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JButton DineInButton;
    private javax.swing.JButton DiscountBtn;
    private javax.swing.JButton DiscountButton;
    private javax.swing.JTextField DiscountField;
    private javax.swing.JButton DotButton;
    private javax.swing.JButton FunctionButton;
    private javax.swing.JPanel FunctionPanel;
    private javax.swing.JPanel NumpadPanel;
    private javax.swing.JPasswordField PinForm;
    private javax.swing.JButton PrintBillButton;
    private javax.swing.JButton ProductButton1;
    private javax.swing.JButton ProductButton2;
    private javax.swing.JButton ProductButton3;
    private javax.swing.JButton ProductButton4;
    private javax.swing.JPanel ProductPanel;
    private javax.swing.JButton SignInButton;
    private javax.swing.JButton SubCategory1Button1;
    private javax.swing.JButton SubCategory1Button2;
    private javax.swing.JButton SubCategory1Button3;
    private javax.swing.JButton SubCategory1Button4;
    private javax.swing.JButton SubCategory1Button5;
    private javax.swing.JButton SubCategory2_1Button;
    private javax.swing.JButton SubCategory2_1Button1;
    private javax.swing.JButton SubCategory2_1Button2;
    private javax.swing.JButton SubCategory2_1Button3;
    private javax.swing.JButton SubCategory2_1Button4;
    private javax.swing.JButton SubCategory2_2Button;
    private javax.swing.JButton SubCategory2_2Button1;
    private javax.swing.JButton SubCategory2_2Button2;
    private javax.swing.JButton SubCategory2_2Button3;
    private javax.swing.JButton SubTotalButton;
    private javax.swing.JTextField SubTotalField;
    private javax.swing.JButton TableHoldButton;
    private javax.swing.JTable TableOrder;
    private javax.swing.JPanel TablePanel;
    private javax.swing.JButton TakeawayButton;
    private javax.swing.JTextField TotalField;
    private javax.swing.JButton ViewTransButton;
    private javax.swing.JButton VoidButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
