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
import org.Controller.ControllerProduct;
import org.Controller.ControllerTransaction;
import org.Controller.ControllerUser;
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
//        String query;
//        int i = 0;
////        ConnectionManager conMan = new ConnectionManager();
////        Connection con = conMan.LogOn();
////        query = "SELECT transaction_id FROM transaction GROUP BY transaction_id";
////        
////        try{
////            Statement stm = con.createStatement();
////            ResultSet rs;
////            rs = stm.executeQuery(query);
////            while(rs.next()){
////                i++;
////            }
////        }catch(Exception ex){
////            System.out.println(ex.toString());
////            conMan.LogOff();
////        }
////        conMan.LogOff();
//        
//        LocalDate date = LocalDate.now();
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-dd-MM");
////        String a = date.toString();
//        System.out.println(date);
//        System.out.println(date.format(dtf));
        ControllerTransaction ct = new ControllerTransaction();
        
//        ct.showListTransaction();
        
        ControllerUser cu = new ControllerUser();
        ControllerProduct cp = new ControllerProduct();
//        System.out.println(cu.insertUser(1515, "testing", "Waiter"));
//        System.out.println(cu.updateUser(1515, "Nisga", "Waiter"));
//        System.out.println(cu.deleteUser(1515));

//        System.out.println(cp.insertProduct("Test", "Food", "Appetizer", 100, 2));
//        System.out.println(cp.updateProduct("P017", "Pecel Lele", "Food", "Main Course", 0, 10));
        System.out.println(cp.deleteProduct("P017"));
    }
    
}
