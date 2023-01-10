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
import org.Model.Product;

/**
 *
 * @author Acer
 */
public class ControllerProduct {
    static String query;
    
    public List<Product> getProductsByCategory(String subcategory){
        ConnectionManager conMan = new ConnectionManager();
        Connection con = conMan.LogOn();
        List<Product> listProduct = new ArrayList<Product>();
        query = "SELECT * FROM product WHERE sub_category = '"+subcategory+"' && quantity > 0";
        
        try{
            Statement stm = con.createStatement();
            ResultSet rs;
            rs = stm.executeQuery(query);
            while(rs.next()){
                Product product = new Product();
                product.setProduct_id(rs.getString("product_id"));
                product.setProduct_name(rs.getString("product_name"));
                product.setCategory(rs.getString("category"));
                product.setSub_category(rs.getString("sub_category"));
                product.setPrice(rs.getDouble("price"));
                product.setQuantity(rs.getInt("quantity"));
                listProduct.add(product);
            }
        }catch(Exception ex){
            System.out.println(ex.toString());
            conMan.LogOff();
        }
        conMan.LogOff();
        return listProduct;
    }
    
    public Product getProduct(String name){
        ConnectionManager conMan = new ConnectionManager();
        Connection con = conMan.LogOn();
        query = "SELECT * FROM product WHERE product_name = '"+name+"'";
        Product product = new Product();
        try{
            Statement stm = con.createStatement();
            ResultSet rs;
            rs = stm.executeQuery(query);
            while(rs.next()){
                product.setProduct_id(rs.getString("product_id"));
                product.setProduct_name(rs.getString("product_name"));
                product.setCategory(rs.getString("category"));
                product.setSub_category(rs.getString("sub_category"));
                product.setPrice(rs.getDouble("price"));
                product.setQuantity(rs.getInt("quantity"));
            }           
        }catch(Exception ex){
            System.out.println(ex.toString());
            conMan.LogOff();
        }
        conMan.LogOff();
        return product;
    }
    
//    public List<Product> getFood(){
//        ConnectionManager conMan = new ConnectionManager();
//        Connection con = conMan.LogOn();
//        List<Product> listProduct = new ArrayList<Product>();
//        query = "SELECT * FROM product WHERE category = 'Food'";
//        
//        try{
//            Statement stm = con.createStatement();
//            ResultSet rs;
//            rs = stm.executeQuery(query);
//            while(rs.next()){
//                Product product = new Product();
//                product.setProduct_id(rs.getString("product_id"));
//                product.setProduct_name(rs.getString("product_name"));
//                product.setCategory(rs.getString("category"));
//                product.setSub_category(rs.getString("sub_category"));
//                product.setPrice(rs.getDouble("price"));
//                product.setQuantity(rs.getInt("quantity"));
//                listProduct.add(product);
//            }
//        }catch(Exception ex){
//            System.out.println(ex.toString());
//            conMan.LogOff();
//        }
//        conMan.LogOff();
//        return listProduct;
//    }
//    
//    public List<Product> getBeverage(){
//        ConnectionManager conMan = new ConnectionManager();
//        Connection con = conMan.LogOn();
//        List<Product> listProduct = new ArrayList<Product>();
//        query = "SELECT * FROM product WHERE category = 'Beverage'";
//        
//        try{
//            Statement stm = con.createStatement();
//            ResultSet rs;
//            rs = stm.executeQuery(query);
//            while(rs.next()){
//                Product product = new Product();
//                product.setProduct_id(rs.getString("product_id"));
//                product.setProduct_name(rs.getString("product_name"));
//                product.setCategory(rs.getString("category"));
//                product.setSub_category(rs.getString("sub_category"));
//                product.setPrice(rs.getDouble("price"));
//                product.setQuantity(rs.getInt("quantity"));
//                listProduct.add(product);
//            }
//        }catch(Exception ex){
//            System.out.println(ex.toString());
//            conMan.LogOff();
//        }
//        conMan.LogOff();
//        return listProduct;
//    }
}
