/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.Model;

/**
 *
 * @author Acer
 */
public class Product {
    private String product_id;
    private String product_name;
    private String category;
    private String sub_category;
    private double price;
    private int quantity;

    public Product() {
    }

    public Product(String product_id, String product_name, String category, String sub_category, double price, int quantity) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.category = category;
        this.sub_category = sub_category;
        this.price = price;
        this.quantity = quantity;
    }

    
    /**
     * @return the product_id
     */
    public String getProduct_id() {
        return product_id;
    }

    /**
     * @param product_id the product_id to set
     */
    public void setProduct_id(String product_id) {
        this.product_id = product_id;
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
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return the sub_category
     */
    public String getSub_category() {
        return sub_category;
    }

    /**
     * @param sub_category the sub_category to set
     */
    public void setSub_category(String sub_category) {
        this.sub_category = sub_category;
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
}
