/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import org.ConnectionManager.ConnectionManager;

/**
 *
 * @author Acer
 */
public class ControllerTransaction {
    static String query;
    
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
