/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.Model;

/**
 *
 * @author Acer
 */
public class TransactionGroup {
    private int transaction_id;
    private int payment_status;
    private String table_num;
    private String transaction_date;
    private double total;

    public TransactionGroup() {
    }

    public TransactionGroup(int transaction_id, int payment_status, String table_num, String transaction_date, double total) {
        this.transaction_id = transaction_id;
        this.payment_status = payment_status;
        this.table_num = table_num;
        this.transaction_date = transaction_date;
        this.total = total;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
    }

    public int getPayment_status() {
        return payment_status;
    }

    public void setPayment_status(int payment_status) {
        this.payment_status = payment_status;
    }

    public String getTable_num() {
        return table_num;
    }

    public void setTable_num(String table_num) {
        this.table_num = table_num;
    }

    public String getTransaction_date() {
        return transaction_date;
    }

    public void setTransaction_date(String transaction_date) {
        this.transaction_date = transaction_date;
    }
    
    
}
