/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.Model;

/**
 *
 * @author Acer
 */
public class Receipt {
    private int quantity;
    private String product_name;
    private double amount;

    public Receipt(int quantity, String product_name, double amount) {
        this.quantity = quantity;
        this.product_name = product_name;
        this.amount = amount;
    }

    public Receipt() {
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
