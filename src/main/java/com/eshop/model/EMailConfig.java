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
//sender  cofiguration
public class EMailConfig {

    private static final String emailLogin = "rodion.vlasov@mail.ru";
    private static final String emailPassword = "xxx";

    public EMailConfig() {

    }

    /**
     * @return the emailLogin
     */
    public static String getEmailLogin() {
        return emailLogin;
    }

    /**
     * @param aEmailLogin the emailLogin to set
     */
    /**
     * @return the emailPassword
     */
    public static String getEmailPassword() {
        return emailPassword;
    }

    /**
     * @param aEmailPassword the emailPassword to set
     */
}
