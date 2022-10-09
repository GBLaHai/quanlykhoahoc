/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlykhoahoc.DAL;

import static com.mycompany.quanlykhoahoc.DAL.MyDatabaseManager.closeConnection;
import static com.mycompany.quanlykhoahoc.DAL.MyDatabaseManager.connectDB;
import com.mycompany.quanlykhoahoc.Entity.Department;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Manh Hai
 */
public class DepartmentDAL extends MyDatabaseManager {

    public DepartmentDAL() {
    }

    public ArrayList<Department> readDepartments() {
        connectDB();
        ArrayList list = new ArrayList();
        try {
            String query = "select * from department";
            ResultSet rs = SQLQuery(query);

            if (rs != null) {
                while (rs.next()) {
                    Department d = new Department();
                    d.setDepartmentID(rs.getInt("DepartmentID"));
                    d.setName(rs.getString("Name"));
                    d.setBudget(rs.getLong("Budget"));
                    d.setStartDate(rs.getString("StartDate"));
                    d.setAdministrator(rs.getInt("Administrator"));
                    list.add(d);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return list;
    }

    public Department getDepartment(int departmentID) {
        connectDB();
        Department d = new Department();

        try {
            String query = "select * from department where DepartmentID = ?";

            PreparedStatement p = getConnection().prepareStatement(query);
            p.setInt(1, departmentID);
            ResultSet rs = p.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    d.setDepartmentID(rs.getInt("DepartmentID"));
                    d.setName(rs.getString("Name"));
                    d.setBudget(rs.getLong("Budget"));
                    d.setStartDate(rs.getString("StartDate"));
                    d.setAdministrator(rs.getInt("Administrator"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return d;

    }
    
    public Department findDepartment(String name) {
        connectDB();
        Department d = new Department();
        try {
            String query = "select * from department where Name = ?";
            PreparedStatement p = getConnection().prepareStatement(query);
            p.setString(1, name);
            ResultSet rs = p.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    d.setDepartmentID(rs.getInt("DepartmentID"));
                    d.setName(rs.getString("Name"));
                    d.setBudget(rs.getLong("Budget"));
                    d.setStartDate(rs.getString("StartDate"));
                    d.setAdministrator(rs.getInt("Administrator"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return d;
    }
}
