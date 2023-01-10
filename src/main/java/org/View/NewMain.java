/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.View;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.ConnectionManager.ConnectionManager;
import org.Model.Product;

/**
 *
 * @author Acer
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String query;
        int i = 0;
//        ConnectionManager conMan = new ConnectionManager();
//        Connection con = conMan.LogOn();
//        query = "SELECT transaction_id FROM transaction GROUP BY transaction_id";
//        
//        try{
//            Statement stm = con.createStatement();
//            ResultSet rs;
//            rs = stm.executeQuery(query);
//            while(rs.next()){
//                i++;
//            }
//        }catch(Exception ex){
//            System.out.println(ex.toString());
//            conMan.LogOff();
//        }
//        conMan.LogOff();
        
        LocalDate date = LocalDate.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-dd-MM");
//        String a = date.toString();
        System.out.println(date);
        System.out.println(date.format(dtf));
        
    }
    
}
