/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlykhoahoc.DAL;

import com.mycompany.quanlykhoahoc.Entity.StudentGrade;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Manh Hai
 */
public class StudentGradeDAL extends MyDatabaseManager {

    public StudentGradeDAL() {
    }

    public ArrayList<StudentGrade> readStudentGarde() {
        connectDB();
        ArrayList list = new ArrayList();
        try {
            String query = "select sg.EnrollmentID, sg.CourseID, sg.StudentID, sg.Grade, c.Title, p.Firstname, p.Lastname \n"
                    + "from StudentGrade sg join Person p\n"
                    + "on sg.StudentID = p.PersonID join Course c\n"
                    + "on sg.CourseID = c.CourseID;";
            ResultSet rs = SQLQuery(query);

            if (rs != null) {
                while (rs.next()) {
                    StudentGrade sg = new StudentGrade();
                    sg.setEnrollmentID(rs.getInt("EnrollmentID"));
                    sg.setCourseID(rs.getInt("CourseID"));
                    sg.setStudentID(rs.getInt("StudentID"));
                    sg.setGrade(rs.getFloat("Grade"));
                    sg.setTitle(rs.getString("Title"));
                    sg.setFirstName(rs.getString("Firstname"));
                    sg.setLastName(rs.getString("Lastname"));
                    list.add(sg);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return list;
    }

    public StudentGrade getStudentGrade(int enrollmentID) {
        connectDB();
        StudentGrade sg = new StudentGrade();

        try {
            String query = "select sg.EnrollmentID, sg.CourseID, sg.StudentID, sg.Grade, c.Title, p.Firstname, p.Lastname \n"
                    + "from StudentGrade sg join Person p\n"
                    + "on sg.StudentID = p.PersonID join Course c\n"
                    + "on sg.CourseID = c.CourseID\n"
                    + "where sg.EnrollmentID = ?;";

            PreparedStatement p = getConnection().prepareStatement(query);
            p.setInt(1, enrollmentID);
            ResultSet rs = p.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    sg.setEnrollmentID(rs.getInt("EnrollmentID"));
                    sg.setCourseID(rs.getInt("CourseID"));
                    sg.setStudentID(rs.getInt("StudentID"));
                    sg.setGrade(rs.getFloat("Grade"));
                    sg.setTitle(rs.getString("Title"));
                    sg.setFirstName(rs.getString("Firstname"));
                    sg.setLastName(rs.getString("Lastname"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return sg;

    }

    public int updateStudentGrade(StudentGrade sg) {
        connectDB();
        int result = 0;
        try {
            String query = "update StudentGrade set CourseID = ?, StudentID = ?, Grade = ?\n"
                    + "where EnrollmentID = ?;";
            PreparedStatement p = getConnection().prepareStatement(query);
            p.setInt(1, sg.getCourseID());
            p.setInt(2, sg.getStudentID());
            p.setFloat(3, sg.getGrade());
            p.setInt(4, sg.getEnrollmentID());
            result = p.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    public int insertStudentGrade(StudentGrade sg) {
        connectDB();
        int result = 0;

        try {
            String query = "insert StudentGrade(CourseID, StudentID, Grade) values (?, ?, ?);";
            PreparedStatement p = getConnection().prepareStatement(query);
            p.setInt(1, sg.getCourseID());
            p.setInt(2, sg.getStudentID());
            p.setFloat(3, sg.getGrade());
            result = p.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    public ArrayList<StudentGrade> findStudentGrades(String StudentID) {
        connectDB();
        ArrayList list = new ArrayList();

        try {
            String query = "select sg.EnrollmentID, sg.CourseID, sg.StudentID, sg.Grade, c.Title, p.Firstname, p.Lastname \n"
                    + "from StudentGrade sg join Person p\n"
                    + "on sg.StudentID = p.PersonID join Course c\n"
                    + "on sg.CourseID = c.CourseID\n"
                    + "where sg.StudentID LIKE ?;";
            PreparedStatement p = getConnection().prepareStatement(query);
            p.setString(1, StudentID + "%");
            ResultSet rs = p.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    StudentGrade sg = new StudentGrade();
                    sg.setEnrollmentID(rs.getInt("EnrollmentID"));
                    sg.setCourseID(rs.getInt("CourseID"));
                    sg.setStudentID(rs.getInt("StudentID"));
                    sg.setGrade(rs.getFloat("Grade"));
                    sg.setTitle(rs.getString("Title"));
                    sg.setFirstName(rs.getString("Firstname"));
                    sg.setLastName(rs.getString("Lastname"));
                    list.add(sg);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }

        return list;
    }

    public int deleteStudentGrade(int enrollmentID) {
        connectDB();
        int result = 0;

        try {
            String query = "delete from StudentGrade where EnrollmentID = ?;";
            PreparedStatement p = getConnection().prepareStatement(query);
            p.setInt(1, enrollmentID);
            result = p.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }

        return result;
    }

    public int countRecordStudentGrade() {
        connectDB();
        int result = 0;

        try {
            String query = "select count(*) as count from StudentGrade";
            PreparedStatement p = getConnection().prepareStatement(query);
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
