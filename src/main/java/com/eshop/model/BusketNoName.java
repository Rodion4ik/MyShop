/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eshop.model;

import java.util.List;
import javax.websocket.Session;

/**
 *
 * @author Samsung
 */
public class BusketNoName {

    private List<BusketItem> busketItems;
    private Session session;

    public BusketNoName(List<BusketItem> busketItems, Session session) {
        this.busketItems = busketItems;
        this.session = session;
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
    public double getTotalPrice() {
        double cost = 0.0;
        for (BusketItem bi : busketItems) {
            cost += bi.getProduct().getCost();
        }

        return cost;
    }

    /**
     * @return the session
     */
    public Session getSession() {
        return session;
    }

    /**
     * @param session the session to set
     */
    public void setSession(Session session) {
        this.session = session;
    }
}
