/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eshop.model;

/**
 *
 * @author Samsung
 */
public class BusketItem {

    private int id;
    private Product product;
    private int number;

    public BusketItem(Product product, int number) {
        this.product = product;
        this.number = number;

    }

    public BusketItem(Product product, int number, int id) {
        this.product = product;
        this.number = number;
        this.id = id;

    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

}
