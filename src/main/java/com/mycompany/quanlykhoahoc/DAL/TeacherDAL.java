/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlykhoahoc.DAL;

import com.mycompany.quanlykhoahoc.Entity.Teacher;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Manh Hai
 */
public class TeacherDAL extends MyDatabaseManager{
    public TeacherDAL() {
    }

    public ArrayList<Teacher> readTeachers() {
        connectDB();
        ArrayList list = new ArrayList();
        try {
            String query = "SELECT * FROM Person WHERE HireDate > 0";
            ResultSet rs = TeacherDAL.SQLQuery(query);

            if (rs != null) {
                while (rs.next()) {
                    Teacher t = new Teacher();
                    t.setPersonId(rs.getInt("PersonID"));
                    t.setFirstName(rs.getString("FirstName"));
                    t.setLastName(rs.getString("LastName"));
                    t.setHireDate(rs.getString("HireDate"));
                    list.add(t);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return list;
    }

    public Teacher getTeacher(int teacherID) {
        connectDB();
        Teacher t = new Teacher();

        try {
            String query = "SELECT * FROM Person WHERE HireDate > 0 AND PersonID = ? ";

            PreparedStatement p = StudentDAL.getConnection().prepareStatement(query);
            p.setInt(1, teacherID);
            ResultSet rs = p.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    t.setPersonId(rs.getInt("PersonID"));
                    t.setFirstName(rs.getString("FirstName"));
                    t.setLastName(rs.getString("LastName"));
                    t.setHireDate(rs.getString("HireDate"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return t;

    }

    public int updateTeacher(Teacher t) {
        connectDB();
        int result = 0;
        try {
            String query = "Update Person SET FirstName = ? , LastName = ? "
                    + " WHERE PersonID = ?";
            PreparedStatement p = StudentDAL.getConnection().prepareStatement(query);
            p.setString(1, t.getFirstName());
            p.setString(2, t.getLastName());
            p.setInt(3, t.getPersonId());
            result = p.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    public int insertTeacher(Teacher t) {
        connectDB();
        int result = 0;

        try {
            String query = "Insert Person (FirstName, LastName, HireDate) VALUES (?, ?, ?)";
            PreparedStatement p = StudentDAL.getConnection().prepareStatement(query);
            p.setString(1, t.getFirstName());
            p.setString(2, t.getLastName());
            p.setString(3, t.getHireDate().toString());
            result = p.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    public ArrayList<Teacher> findStudents(String fullName) {
        connectDB();
        ArrayList list = new ArrayList();

        try {
            String query = "SELECT * FROM Person WHERE concat(FirstName, ' ', LastName)  LIKE ?";
            PreparedStatement p = StudentDAL.getConnection().prepareStatement(query);
            p.setString(1, "%" + fullName + "%");
            ResultSet rs = p.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Teacher t = new Teacher();
                    t.setPersonId(rs.getInt("PersonID"));
                    t.setFirstName(rs.getString("FirstName"));
                    t.setLastName(rs.getString("LastName"));
                    t.setHireDate(rs.getString("HireDate"));
                    list.add(t);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }

        return list;
    }

    public int deleteTeacher(int teacherID) {
        connectDB();
        int result = 0;

        try {
            String query = "DELETE FROM Person WHERE PersonID = ?";
            PreparedStatement p = StudentDAL.getConnection().prepareStatement(query);
            p.setInt(1, teacherID);
            result = p.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }

        return result;
    }

    public int countRecordTeacher() {
        connectDB();
        int result = 0;

        try {
            String query = "select count(*) as count from Person WHERE HireDate > 0";
            PreparedStatement p = StudentDAL.getConnection().prepareStatement(query);
            ResultSet rs = p.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    result = rs.getInt("count");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            StudentDAL.closeConnection();
        }

        return result;
    }
}
