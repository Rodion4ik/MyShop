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
public class EMailMessage {

    private final String SERVER="smtp.mail.ru";
    private final String PORT ="465";
    private String user;
    private String password;
    private String body;
    private String recepient;
    private String subject;
    
    public EMailMessage(String user,String password,String body,String recepient,String subject){
        this.user=user;
        this.password=password;
        this.body=body;
        this.recepient=recepient;
        this.subject=subject;
    
    }

    
    public String getServer() {
        return SERVER;
    }

    
    
    public String getPort() {
        return PORT;
    }

 
    
    public String getUser() {
        return user;
    }

    
    public void setUser(String user) {
        this.user = user;
    }

   
    public String getPassword() {
        return password;
    }

   
    public void setPassword(String password) {
        this.password = password;
    }

    
    public String getBody() {
        return body;
    }

    
    public void setBody(String body) {
        this.body = body;
    }

    
    public String getRecepient() {
        return recepient;
    }

    
    public void setRecepient(String recepient) {
        this.recepient = recepient;
    }

    
    public String getSubject() {
        return subject;
    }

    
    public void setSubject(String subject) {
        this.subject = subject;
    }

}
