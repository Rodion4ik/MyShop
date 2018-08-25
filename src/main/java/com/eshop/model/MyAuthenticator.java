/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eshop.model;

import javax.mail.PasswordAuthentication;

/**
 *
 * @author Samsung
 */

    public class MyAuthenticator extends javax.mail.Authenticator
{
    private String login   ;
    private String password;
    public MyAuthenticator (final String login, final String password)
    {
        this.login    = login;
        this.password = password;
    }
    public PasswordAuthentication getPasswordAuthentication()
    {
        return new PasswordAuthentication(login, password);
    }
}

