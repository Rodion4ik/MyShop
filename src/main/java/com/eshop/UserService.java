/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eshop;

import com.eshop.model.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Samsung
 */
public class UserService {

    public User getUserInformation(String login) throws SQLException {
        User user = null;

        Connection c = getConnection();

        String s = "select id,password,email from myshop.user where login =?";
        PreparedStatement p = c.prepareStatement(s);
        p.setString(1, login);
        try {
            ResultSet rs = p.executeQuery();
            if(rs.next()) {
                user = new User();
                user.setLogin(login);
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setId(rs.getInt("id"));
                System.out.println("zapros iz bazy info user  schitalsya" + rs.getString("password"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            p.close();
            c.close();
        }
        return user;

    }

    public void addUser(String login, String password, String email) throws SQLException {

        Connection c = getConnection();
        String s = "INSERT into myshop.user (login,password,email) VALUES (?,?,?)";
        //zdes - kak to podstavit parametry iz metoda

        PreparedStatement p = c.prepareStatement(s);
        p.setString(1, login);
        p.setString(2, password);
        p.setString(3, email);

        try {
            p.executeUpdate();
            
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            p.close();
            c.close();
        }
    }

    Connection getConnection() throws SQLException {
        String string = "jdbc:postgresql://localhost:5432/postgres?user=postgres&password=postgres";
        Connection conn = DriverManager.getConnection(string);
        return conn;
    }
}
//dz - user Service  i jsp stranica dlya usera i podumat kak svyazat s registraciei  s korzinoi
