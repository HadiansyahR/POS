/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.View;

/**
 *
 * @author Dreamvalian
 */
public class FunctionView extends javax.swing.JFrame {

    /**
     * Creates new form FunctionView
     */
    public FunctionView() {
        initComponents();
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
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        ReportButton = new javax.swing.JButton();
        ManageProductButton = new javax.swing.JButton();
        ViewTransactionButton = new javax.swing.JButton();
        UpdateProductButton = new javax.swing.JButton();
        DeleteProductButton = new javax.swing.JButton();
        ClearButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ManageTable = new javax.swing.JTable();
        NameTextfield = new javax.swing.JTextField();
        PriceTextfield = new javax.swing.JTextField();
        QuantityTextfield = new javax.swing.JTextField();
        SubCategoryDropdown = new javax.swing.JComboBox<>();
        CategoryDropdown = new javax.swing.JComboBox<>();
        CreateProductButton = new javax.swing.JButton();
        ManageUserButton = new javax.swing.JButton();
        CreateUserButton = new javax.swing.JButton();
        UpdateUserButton = new javax.swing.JButton();
        DeleteUserButton = new javax.swing.JButton();
        UsernameTextfield = new javax.swing.JTextField();
        RolesDropdown = new javax.swing.JComboBox<>();
        PinTextfield = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        BacktomainButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(71, 103, 237));
        jPanel1.setForeground(new java.awt.Color(35, 35, 35));

        jLabel3.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(249, 249, 249));
        jLabel3.setText("Function");

        jSeparator1.setBackground(new java.awt.Color(249, 249, 249));
        jSeparator1.setForeground(new java.awt.Color(249, 249, 249));

        jPanel2.setBackground(new java.awt.Color(249, 249, 249));
        jPanel2.setForeground(new java.awt.Color(35, 35, 35));

        ReportButton.setBackground(new java.awt.Color(249, 249, 249));
        ReportButton.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        ReportButton.setForeground(new java.awt.Color(35, 35, 35));
        ReportButton.setText("Report");

        ManageProductButton.setBackground(new java.awt.Color(249, 249, 249));
        ManageProductButton.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        ManageProductButton.setForeground(new java.awt.Color(35, 35, 35));
        ManageProductButton.setText("Manage Product");
        ManageProductButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManageProductButtonActionPerformed(evt);
            }
        });

        ViewTransactionButton.setBackground(new java.awt.Color(249, 249, 249));
        ViewTransactionButton.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        ViewTransactionButton.setForeground(new java.awt.Color(35, 35, 35));
        ViewTransactionButton.setText("View Trans.");

        UpdateProductButton.setBackground(new java.awt.Color(249, 249, 249));
        UpdateProductButton.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        UpdateProductButton.setForeground(new java.awt.Color(35, 35, 35));
        UpdateProductButton.setText("Update Product");
        UpdateProductButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateProductButtonActionPerformed(evt);
            }
        });

        DeleteProductButton.setBackground(new java.awt.Color(249, 249, 249));
        DeleteProductButton.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        DeleteProductButton.setForeground(new java.awt.Color(35, 35, 35));
        DeleteProductButton.setText("Delete Product");
        DeleteProductButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteProductButtonActionPerformed(evt);
            }
        });

        ClearButton.setBackground(new java.awt.Color(249, 249, 249));
        ClearButton.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        ClearButton.setForeground(new java.awt.Color(35, 35, 35));
        ClearButton.setText("Clear");
        ClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearButtonActionPerformed(evt);
            }
        });

        ManageTable.setBackground(new java.awt.Color(249, 249, 249));
        ManageTable.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        ManageTable.setForeground(new java.awt.Color(35, 35, 35));
        ManageTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(ManageTable);

        NameTextfield.setBackground(new java.awt.Color(249, 249, 249));
        NameTextfield.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        NameTextfield.setForeground(new java.awt.Color(35, 35, 35));
        NameTextfield.setText("Name");

        PriceTextfield.setBackground(new java.awt.Color(249, 249, 249));
        PriceTextfield.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        PriceTextfield.setForeground(new java.awt.Color(35, 35, 35));
        PriceTextfield.setText("Price");

        QuantityTextfield.setBackground(new java.awt.Color(249, 249, 249));
        QuantityTextfield.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        QuantityTextfield.setForeground(new java.awt.Color(35, 35, 35));
        QuantityTextfield.setText("Quantity");

        SubCategoryDropdown.setBackground(new java.awt.Color(249, 249, 249));
        SubCategoryDropdown.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        SubCategoryDropdown.setForeground(new java.awt.Color(35, 35, 35));
        SubCategoryDropdown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Appetizer", "Soup", "Salad", "Main Course", "Dessert", "Alcoholic - Spirit", "Alcoholic - Wine", "Alcoholic - Liquor", "Alcoholic - Cocktail", "Non-Alcoholic - Coffee", "Non-Alcoholic - Tea", "Non-Alcoholic - Juice", "Non-Alcoholic - Mocktail" }));
        SubCategoryDropdown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubCategoryDropdownActionPerformed(evt);
            }
        });

        CategoryDropdown.setBackground(new java.awt.Color(249, 249, 249));
        CategoryDropdown.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        CategoryDropdown.setForeground(new java.awt.Color(35, 35, 35));
        CategoryDropdown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Food", "Beverage" }));
        CategoryDropdown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CategoryDropdownActionPerformed(evt);
            }
        });

        CreateProductButton.setBackground(new java.awt.Color(249, 249, 249));
        CreateProductButton.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        CreateProductButton.setForeground(new java.awt.Color(35, 35, 35));
        CreateProductButton.setText("Create Product");
        CreateProductButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateProductButtonActionPerformed(evt);
            }
        });

        ManageUserButton.setBackground(new java.awt.Color(249, 249, 249));
        ManageUserButton.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        ManageUserButton.setForeground(new java.awt.Color(35, 35, 35));
        ManageUserButton.setText("Manage User");
        ManageUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManageUserButtonActionPerformed(evt);
            }
        });

        CreateUserButton.setBackground(new java.awt.Color(249, 249, 249));
        CreateUserButton.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        CreateUserButton.setForeground(new java.awt.Color(35, 35, 35));
        CreateUserButton.setText("Create User");
        CreateUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateUserButtonActionPerformed(evt);
            }
        });

        UpdateUserButton.setBackground(new java.awt.Color(249, 249, 249));
        UpdateUserButton.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        UpdateUserButton.setForeground(new java.awt.Color(35, 35, 35));
        UpdateUserButton.setText("Update User");
        UpdateUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateUserButtonActionPerformed(evt);
            }
        });

        DeleteUserButton.setBackground(new java.awt.Color(249, 249, 249));
        DeleteUserButton.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        DeleteUserButton.setForeground(new java.awt.Color(35, 35, 35));
        DeleteUserButton.setText("Delete User");
        DeleteUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteUserButtonActionPerformed(evt);
            }
        });

        UsernameTextfield.setBackground(new java.awt.Color(249, 249, 249));
        UsernameTextfield.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        UsernameTextfield.setForeground(new java.awt.Color(35, 35, 35));
        UsernameTextfield.setText("Username");

        RolesDropdown.setBackground(new java.awt.Color(249, 249, 249));
        RolesDropdown.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        RolesDropdown.setForeground(new java.awt.Color(35, 35, 35));
        RolesDropdown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Server", "Cashier", "Admin" }));
        RolesDropdown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RolesDropdownActionPerformed(evt);
            }
        });

        PinTextfield.setBackground(new java.awt.Color(249, 249, 249));
        PinTextfield.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        PinTextfield.setForeground(new java.awt.Color(35, 35, 35));
        PinTextfield.setText("Pin");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(UpdateUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CreateUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DeleteUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PinTextfield, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(RolesDropdown, javax.swing.GroupLayout.Alignment.TRAILING, 0, 193, Short.MAX_VALUE)
                            .addComponent(UsernameTextfield, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(ManageUserButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(UpdateProductButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CreateProductButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(DeleteProductButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(NameTextfield, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(PriceTextfield, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(QuantityTextfield, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(SubCategoryDropdown, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CategoryDropdown, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(ManageProductButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(ClearButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ReportButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ViewTransactionButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(ManageProductButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ManageUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(UsernameTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addComponent(PinTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(RolesDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(3, 3, 3)
                                                .addComponent(CreateProductButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(CreateUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(UpdateUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(DeleteUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(UpdateProductButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(DeleteProductButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(NameTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CategoryDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SubCategoryDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PriceTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(QuantityTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ViewTransactionButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ReportButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(71, 103, 237));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249, 249, 249)));
        jPanel3.setForeground(new java.awt.Color(35, 35, 35));

        BacktomainButton.setBackground(new java.awt.Color(249, 248, 113));
        BacktomainButton.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        BacktomainButton.setForeground(new java.awt.Color(35, 35, 35));
        BacktomainButton.setText("Back to Main");
        BacktomainButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BacktomainButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BacktomainButton, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BacktomainButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(448, 448, 448))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BacktomainButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BacktomainButtonActionPerformed

    }//GEN-LAST:event_BacktomainButtonActionPerformed

    private void ManageProductButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManageProductButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ManageProductButtonActionPerformed

    private void UpdateProductButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateProductButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateProductButtonActionPerformed

    private void DeleteProductButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteProductButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DeleteProductButtonActionPerformed

    private void ClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ClearButtonActionPerformed

    private void SubCategoryDropdownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubCategoryDropdownActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SubCategoryDropdownActionPerformed

    private void CategoryDropdownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CategoryDropdownActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CategoryDropdownActionPerformed

    private void CreateProductButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateProductButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CreateProductButtonActionPerformed

    private void ManageUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManageUserButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ManageUserButtonActionPerformed

    private void CreateUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateUserButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CreateUserButtonActionPerformed

    private void UpdateUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateUserButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateUserButtonActionPerformed

    private void DeleteUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteUserButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DeleteUserButtonActionPerformed

    private void RolesDropdownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RolesDropdownActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RolesDropdownActionPerformed

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
            java.util.logging.Logger.getLogger(FunctionView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FunctionView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FunctionView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FunctionView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FunctionView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BacktomainButton;
    private javax.swing.JComboBox<String> CategoryDropdown;
    private javax.swing.JButton ClearButton;
    private javax.swing.JButton CreateProductButton;
    private javax.swing.JButton CreateUserButton;
    private javax.swing.JButton DeleteProductButton;
    private javax.swing.JButton DeleteUserButton;
    private javax.swing.JButton ManageProductButton;
    private javax.swing.JTable ManageTable;
    private javax.swing.JButton ManageUserButton;
    private javax.swing.JTextField NameTextfield;
    private javax.swing.JTextField PinTextfield;
    private javax.swing.JTextField PriceTextfield;
    private javax.swing.JTextField QuantityTextfield;
    private javax.swing.JButton ReportButton;
    private javax.swing.JComboBox<String> RolesDropdown;
    private javax.swing.JComboBox<String> SubCategoryDropdown;
    private javax.swing.JButton UpdateProductButton;
    private javax.swing.JButton UpdateUserButton;
    private javax.swing.JTextField UsernameTextfield;
    private javax.swing.JButton ViewTransactionButton;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
