/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlykhoahoc.DAL;

import com.mycompany.quanlykhoahoc.Entity.Student;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Manh Hai
 */
public class StudentDAL extends MyDatabaseManager {

    public StudentDAL() {
    }

    public ArrayList<Student> readStudents() {
        connectDB();
        ArrayList list = new ArrayList();
        try {
            String query = "SELECT * FROM Person WHERE EnrollmentDate > 0";
            ResultSet rs = StudentDAL.SQLQuery(query);

            if (rs != null) {
                while (rs.next()) {
                    Student s = new Student();
                    s.setPersonId(rs.getInt("PersonID"));
                    s.setFirstName(rs.getString("FirstName"));
                    s.setLastName(rs.getString("LastName"));
                    s.setEnrollmentDate(rs.getString("EnrollmentDate"));
                    list.add(s);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return list;
    }

    public Student getStudent(int studentID) {
        connectDB();
        Student s = new Student();

        try {
            String query = "SELECT * FROM Person WHERE EnrollmentDate > 0 AND PersonID = ? ";

            PreparedStatement p = StudentDAL.getConnection().prepareStatement(query);
            p.setInt(1, studentID);
            ResultSet rs = p.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    s.setPersonId(rs.getInt("PersonID"));
                    s.setFirstName(rs.getString("FirstName"));
                    s.setLastName(rs.getString("LastName"));
                    s.setEnrollmentDate(rs.getString("EnrollmentDate"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return s;

    }

    public int updateStudent(Student s) {
        connectDB();
        int result = 0;
        try {
            String query = "Update Person SET FirstName = ? , LastName = ? "
                    + " WHERE PersonID = ?";
            PreparedStatement p = StudentDAL.getConnection().prepareStatement(query);
            p.setString(1, s.getFirstName());
            p.setString(2, s.getLastName());
            p.setInt(3, s.getPersonId());
            result = p.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    public int insertStudent(Student s) {
        connectDB();
        int result = 0;

        try {
            String query = "Insert Person (FirstName, LastName, EnrollmentDate) VALUES (?, ?, ?)";
            PreparedStatement p = StudentDAL.getConnection().prepareStatement(query);
            p.setString(1, s.getFirstName());
            p.setString(2, s.getLastName());
            p.setString(3, s.getEnrollmentDate().toString());
            result = p.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    public ArrayList<Student> findStudents(String fullName) {
        connectDB();
        ArrayList list = new ArrayList();

        try {
            String query = "SELECT * FROM Person WHERE concat(FirstName, ' ', LastName)  LIKE ?";
            PreparedStatement p = StudentDAL.getConnection().prepareStatement(query);
            p.setString(1, "%" + fullName + "%");
            ResultSet rs = p.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Student s = new Student();
                    s.setPersonId(rs.getInt("PersonID"));
                    s.setFirstName(rs.getString("FirstName"));
                    s.setLastName(rs.getString("LastName"));
                    s.setEnrollmentDate(rs.getString("EnrollmentDate"));
                    list.add(s);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }

        return list;
    }

    public int deleteStudent(int studentID) {
        connectDB();
        int result = 0;

        try {
            String query = "DELETE FROM Person WHERE PersonID = ?";
            PreparedStatement p = StudentDAL.getConnection().prepareStatement(query);
            p.setInt(1, studentID);
            result = p.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }

        return result;
    }

    public int countRecordStudent() {
        connectDB();
        int result = 0;

        try {
            String query = "select count(*) as count from Person WHERE EnrollmentDate > 0";
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
            closeConnection();
        }

        return result;
    }

}
