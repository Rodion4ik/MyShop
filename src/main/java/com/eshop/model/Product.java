package com.eshop.model;

import java.util.ArrayList;

public class Product {

    private int id;
    private String productName;
    private double cost;
    private int vendor_id;
    private String description;
    private ArrayList<Integer> photosIds;
    private int productCategoryId;

    public Product(int id, String productName, double cost, int vendor_id,
            String description, int productCategoryId) {

        this.id = id;
        this.productName = productName;
        this.description = description;
        this.cost = cost;
        this.vendor_id = vendor_id;
        this.productCategoryId = productCategoryId;
        this.photosIds=photosIds;

    }

    public Product(int id) {

        this.id = id;

    }

    public Product(int id, String productName, double cost) {

        this.id = id;
        this.productName = productName;
        this.cost=cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getVendor_id() {
        return vendor_id;
    }

    public void setVendor_id(int vendor_id) {
        this.vendor_id = vendor_id;
    }

    public String getDescription() {
      return  (description!=null)? description:"";
    
        
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public String getPhotoProductFile() {
//        return photoProductFile;
//    }
//
//    
//    public void setPhotoProductFile(String photoProductFile) {
//        this.photoProductFile = photoProductFile;
//    }
    public int getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(int productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    /**
     * @return the photosIds
     */
    public ArrayList<Integer> getPhotosIds() {
        return photosIds;
    }

    /**
     * @param photosIds the photosIds to set
     */
    public void setPhotosIds(ArrayList<Integer> photosIds) {
        this.photosIds = photosIds;
    }

}
//dz  oformit tablicy i opisanie product
