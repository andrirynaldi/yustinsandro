/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.andrirynaldi.cakeapp.database;

import com.andrirynaldi.cakeapp.impl.UserDaoImpl;
import com.andrirynaldi.cakeapp.service.UserDao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author andri
 */
public class CakeAppDatabase {
    private static Connection connection;
    private static UserDao userDao;

    public static Connection getConnection() throws SQLException {
        if(connection==null){
             String url = "jdbc:sqlite:database.db";
             connection = DriverManager.getConnection(url);
        }
        return connection;
    }

    public static UserDao getUserDao() throws SQLException {
        if(userDao==null){
            userDao=new UserDaoImpl(getConnection());
        }
        return userDao;
    }
    
    
}
