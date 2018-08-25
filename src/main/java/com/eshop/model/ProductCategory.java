/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eshop.model;

import java.util.List;

/**
 *
 * @author Samsung
 */
public class ProductCategory {
    private int id;
    private String categoryName;
    private List<Product> listProducts;
    
  public  ProductCategory(int id,String categoryName){
        this.id=id;
        this.categoryName=categoryName;
    }
  public  ProductCategory(int id,String categoryName, List<Product> listProducts){
        this.id=id;
        this.categoryName=categoryName;
        this.listProducts= listProducts;
    }
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
   
    public String getCategoryName() {
        return categoryName;
    }
   
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    
    public List<Product> getListProducts() {
        return listProducts;
    }

    public void setListProducts(List<Product> listProducts) {
        this.listProducts = listProducts;
    }
    
    
}
