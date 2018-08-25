/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eshop.dao;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Samsung
 */
public class DBUtil {

    public static DataSource dataSource;

    public static JdbcTemplate getTemplate() {
        return new JdbcTemplate(dataSource);
    }
}
//ctrl shift+ i - vse importy

//dz usera zapolni
//zapolnit vendorov i privyazka k vendoru

//
