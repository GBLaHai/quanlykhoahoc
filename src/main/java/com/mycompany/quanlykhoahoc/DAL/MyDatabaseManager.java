/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlykhoahoc.DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Manh Hai
 */
public class MyDatabaseManager {
    private static Connection c;
    private static Statement s;
    
    private static String host, port, dbName, dbUser, dbPassword;
    
    
    public static void connectDB()
    {
        host = "localhost";
        port = "3306";
        dbUser = "root";
        dbName = "quanlykhoahoc";
        dbPassword = "123456";
        String dbPath = "jdbc:mysql://" + host + ":" + port + "/"
                + dbName + "?useUnicode=yes&characterEncoding=UTF-8";
        try {
            c = (Connection) DriverManager.getConnection(dbPath, dbUser, dbPassword);
            s = c.createStatement();
            
            System.out.println("Ket noi den database thanh cong");
        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
        }
    }
    public static Connection getConnection()
    {
        return c;
    }
    //run sql
    public static ResultSet SQLQuery(String sql) {
        ResultSet rs = null;
        
        try {
            rs = s.executeQuery(sql);
            System.out.println(sql + " truy van thanh cong.");
        } catch (SQLException ex) {
            System.out.println("Khong the truy van du lieu.");
            Logger.getLogger(MyDatabaseManager.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public static int SQLUpdate(String sql) {
        int i = 0;
        
        try {
            i = s.executeUpdate(sql);
            System.out.println(sql + " cap nhat thanh cong.");
        } catch (SQLException ex) {
            System.out.println("Khong the cap nhat du lieu.");
            Logger.getLogger(MyDatabaseManager.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        
        return i;
    }
    
    public static void closeConnection() {
        try{
            if (c != null){
                c.close();
            }
            if (s != null){
                s.close();
            }
            System.out.println("Da ngat ket noi den database.");
        }
        catch (SQLException e){
            System.out.println("Khong the dong ket noi den database.");
        }
    }
    

    //test connection
    public static void main(String[] args) {
        MyDatabaseManager.connectDB();
        
    }
}
