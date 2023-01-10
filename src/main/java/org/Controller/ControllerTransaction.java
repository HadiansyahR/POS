/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import org.ConnectionManager.ConnectionManager;
import org.Model.Transaction;

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
    
//    public 
}
