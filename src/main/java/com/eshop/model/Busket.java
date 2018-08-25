/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eshop.model;

import java.util.List;

public class Busket {

    private List<BusketItem> busketItems;
    private User user;

    public Busket(List<BusketItem> busketItems, User user) {
        this.busketItems = busketItems;
        this.user = user;
    }

    /**
     * @return the busketItem
     */
    public List<BusketItem> getBusketItems() {
        return busketItems;
    }

    /**
     * @param busketItem the busketItem to set
     */
    public void setBusketItems(List<BusketItem> busketItems) {
        this.busketItems = busketItems;
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

    public double getTotalPrice() {
        double cost = 0.0;
        for (BusketItem bi : busketItems) {
            cost += bi.getProduct().getCost();
        }

        return cost;
    }

}
