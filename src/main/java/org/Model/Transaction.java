/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.Model;

import java.util.Date;

/**
 *
 * @author Acer
 */
public class Transaction {
    private int transaction_id;
    private int quantity;
    private int payment_status;
    private String product_name;
    private String transaction_date;
    private String table_num;
    private double price;
    private double subtotal;

    public Transaction() {
    }

    public Transaction(int transaction_id, int quantity, int payment_status, String product_name, String transaction_date, double price, double subtotal) {
        this.transaction_id = transaction_id;
        this.quantity = quantity;
        this.payment_status = payment_status;
        this.product_name = product_name;
        this.transaction_date = transaction_date;
        this.price = price;
        this.subtotal = subtotal;
    }

    
    /**
     * @return the transaction_id
     */
    public int getTransaction_id() {
        return transaction_id;
    }

    /**
     * @param transaction_id the transaction_id to set
     */
    public void setTransaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getTable_num() {
        return table_num;
    }

    public void setTable_num(String table_num) {
        this.table_num = table_num;
    }
    
    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the payment_status
     */
    public int getPayment_status() {
        return payment_status;
    }

    /**
     * @param payment_status the payment_status to set
     */
    public void setPayment_status(int payment_status) {
        this.payment_status = payment_status;
    }

    /**
     * @return the product_name
     */
    public String getProduct_name() {
        return product_name;
    }

    /**
     * @param product_name the product_name to set
     */
    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    /**
     * @return the transaction_date
     */
    public String getTransaction_date() {
        return transaction_date;
    }

    /**
     * @param transaction_date the transaction_date to set
     */
    public void setTransaction_date(String transaction_date) {
        this.transaction_date = transaction_date;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the subtotal
     */
    public double getSubtotal() {
        return subtotal;
    }

    /**
     * @param subtotal the subtotal to set
     */
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
}
