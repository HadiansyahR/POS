/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.ConnectionManager.ConnectionManager;
import org.Model.Transaction;
import org.Model.TransactionGroup;

/**
 *
 * @author Acer
 */
public class ControllerTransaction {
    static String query;
    
    public int insertTransaction(List<Transaction> listTransaction){
        int status = 0;
        int rowAffected = 0;
        
        ConnectionManager conMan = new ConnectionManager();
        Connection con = conMan.LogOn();
        
        for(Transaction trans: listTransaction){
            query = "INSERT INTO transaction VALUES("
                    + ""+trans.getTransaction_id()+", "
                    + "'"+trans.getTable_num()+"', "
                    + "'"+trans.getProduct_name()+"', "
                    + ""+trans.getQuantity()+", "
                    + ""+trans.getPrice()+", "
                    + ""+trans.getSubtotal()+", "
                    + "'"+trans.getTransaction_date()+"', "
                    + ""+trans.getPayment_status()+""
                    + ")";
            try{
                Statement stm = con.createStatement();
                rowAffected = stm.executeUpdate(query);
                
                if(rowAffected > 0){
                    status = 1;
                }else{
                    status = 0;
                }
            }catch(Exception ex){
                System.out.println(ex.toString());
                conMan.LogOff();
            }
        }
        conMan.LogOff();
                
        return status;
    }
    
    public int countTransactionRow(){
        int row = 0;
        ConnectionManager conMan = new ConnectionManager();
        Connection con = conMan.LogOn();
        query = "SELECT transaction_id FROM transaction GROUP BY transaction_id";
        
        try{
            Statement stm = con.createStatement();
            ResultSet rs;
            rs = stm.executeQuery(query);
            while(rs.next()){
                row++;
            }
        }catch(Exception ex){
            System.out.println(ex.toString());
            conMan.LogOff();
        }
        conMan.LogOff();
        
        return row;
    }
    
    public List<Transaction> showListTransaction(int id){
        ConnectionManager conMan = new ConnectionManager();
        Connection con = conMan.LogOn();
        List<Transaction> listTransaction = new ArrayList<>();
        query = "SELECT * FROM transaction WHERE transaction_id = "+id;
        
        try{
            Statement stm = con.createStatement();
            ResultSet rs;
            rs = stm.executeQuery(query);
            while(rs.next()){
                Transaction trans = new Transaction();
                trans.setTransaction_id(id);
                trans.setTable_num(rs.getString("table_num"));
                trans.setProduct_name(rs.getString("product_name"));
                trans.setQuantity(rs.getInt("quantity"));
                trans.setPrice(rs.getDouble("price"));
                trans.setSubtotal(rs.getDouble("subtotal"));
                trans.setTransaction_date(rs.getString("transaction_date"));
                trans.setPayment_status(rs.getInt("payment_status"));
                
                listTransaction.add(trans);
            }
        }catch(Exception ex){
            System.out.println(ex.toString());
            conMan.LogOff();
        }
        conMan.LogOff();
        return listTransaction;
    }
    
    public List<TransactionGroup> getListTransaction(){
        ConnectionManager conMan = new ConnectionManager();
        Connection con = conMan.LogOn();
        
        List<TransactionGroup> listTransactionGroup = new ArrayList<>();
        
        int rowTransaction = countTransactionRow();
        double[] totalPrice = new double[rowTransaction];
        
        for(int i=0; i<rowTransaction; i++){
            query = "SELECT SUM(subtotal) from transaction WHERE transaction_id = "+(i+1);
            try{
                Statement stm = con.createStatement();
                ResultSet rs;
                rs = stm.executeQuery(query);
                while(rs.next()){
                    totalPrice[i] = rs.getDouble(1);
//                    System.out.println(totalPrice[i]);
                }
            }catch(Exception ex){
                System.out.println(ex.toString());
                conMan.LogOff();
            }
        }
        
        query = "SELECT * FROM transaction GROUP BY transaction_id";
        
        try{
            Statement stm = con.createStatement();
            ResultSet rs;
            rs = stm.executeQuery(query);
            int j = 0;
            while(rs.next()){
                TransactionGroup transGroup = new TransactionGroup();
                transGroup.setTransaction_id(rs.getInt("transaction_id"));
                transGroup.setTable_num(rs.getString("table_num"));
                transGroup.setTotal(totalPrice[j]);
                transGroup.setTransaction_date(rs.getString("transaction_date"));
                transGroup.setPayment_status(rs.getInt("payment_status"));
                
                listTransactionGroup.add(transGroup);
                j++;
            }
        }catch(Exception ex){
            System.out.println(ex.toString());
            conMan.LogOff();
        }
        
        conMan.LogOff();
        
        return listTransactionGroup;
    }
    
    public TransactionGroup findTransaction(int transaction_id){
        TransactionGroup transGroup = new TransactionGroup();
        
        ConnectionManager conMan = new ConnectionManager();
        Connection con = conMan.LogOn();
        
        query = "SELECT transaction_id, table_num, SUM(subtotal) as total, transaction_date, payment_status"
                + " from transaction WHERE transaction_id = "+transaction_id;
        
        try{
            Statement stm = con.createStatement();
            ResultSet rs;
            rs = stm.executeQuery(query);
            
            while(rs.next()){
                transGroup.setTransaction_id(rs.getInt("transaction_id"));
                transGroup.setTable_num(rs.getString("table_num"));
                transGroup.setTotal(rs.getDouble("total"));
                transGroup.setTransaction_date(rs.getString("transaction_date"));
                transGroup.setPayment_status(rs.getInt("payment_status"));
            }
        }catch(Exception ex){
            System.out.println(ex.toString());
            conMan.LogOff();
        }
        
        return transGroup;
    }
    
    public List<TransactionGroup> filterByPayment(int payment_status){
        ConnectionManager conMan = new ConnectionManager();
        Connection con = conMan.LogOn();
        
        List<TransactionGroup> listTransactionGroup = new ArrayList<>();
        
        int rowTransaction = countTransactionRow();
        double[] totalPrice = new double[rowTransaction];
        
        for(int i=0; i<rowTransaction; i++){
            query = "SELECT SUM(subtotal) from transaction WHERE transaction_id = "+(i+1);
            try{
                Statement stm = con.createStatement();
                ResultSet rs;
                rs = stm.executeQuery(query);
                while(rs.next()){
                    totalPrice[i] = rs.getDouble(1);
//                    System.out.println(totalPrice[i]);
                }
            }catch(Exception ex){
                System.out.println(ex.toString());
                conMan.LogOff();
            }
        }
        
        query = "SELECT * FROM transaction WHERE payment_status = "+ payment_status +" GROUP BY transaction_id";
        
        try{
            Statement stm = con.createStatement();
            ResultSet rs;
            rs = stm.executeQuery(query);
            int j = 0;
            while(rs.next()){
                TransactionGroup transGroup = new TransactionGroup();
                transGroup.setTransaction_id(rs.getInt("transaction_id"));
                transGroup.setTable_num(rs.getString("table_num"));
                transGroup.setTotal(totalPrice[j]);
                transGroup.setTransaction_date(rs.getString("transaction_date"));
                transGroup.setPayment_status(rs.getInt("payment_status"));
                
                listTransactionGroup.add(transGroup);
                j++;
            }
        }catch(Exception ex){
            System.out.println(ex.toString());
            conMan.LogOff();
        }
        
        conMan.LogOff();
        
        return listTransactionGroup;
    }

}
