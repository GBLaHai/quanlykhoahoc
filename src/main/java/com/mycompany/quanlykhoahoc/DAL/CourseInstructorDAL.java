/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlykhoahoc.DAL;

import com.mycompany.quanlykhoahoc.Entity.CourseInstructor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Manh Hai
 */
public class CourseInstructorDAL extends MyDatabaseManager {

    public CourseInstructorDAL() {
    }

    public ArrayList<CourseInstructor> readCourseIntructors() {
        connectDB();
        ArrayList list = new ArrayList();
        try {
            String query = "select ci.CourseID, ci.PersonID, c.Title, p.FirstName, p.LastName\n"
                    + "from CourseInstructor ci join course c\n"
                    + "on ci.CourseID = c.CourseID join person p\n"
                    + "on ci.PersonID = p.PersonID and p.HireDate > 0;";
            ResultSet rs = SQLQuery(query);

            if (rs != null) {
                while (rs.next()) {
                    CourseInstructor ci = new CourseInstructor();
                    ci.setCourseID(rs.getInt("CourseID"));
                    ci.setFirstName(rs.getString("FirstName"));
                    ci.setLastName(rs.getString("LastName"));
                    ci.setTeacherID(rs.getInt("PersonID"));
                    ci.setTitleCourse(rs.getString("Title"));
                    list.add(ci);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return list;
    }

    public CourseInstructor getCourseInstructor(int courseID, int personID) {
        connectDB();
        CourseInstructor ci = new CourseInstructor();

        try {
            String query = "select ci.CourseID, ci.PersonID, c.Title, p.FirstName, p.LastName\n"
                    + "from CourseInstructor ci join course c\n"
                    + "on ci.CourseID = c.CourseID join person p\n"
                    + "on ci.PersonID = p.PersonID and p.HireDate > 0\n"
                    + "where ci.PersonID = ? and ci.CourseID = ?;";

            PreparedStatement p = getConnection().prepareStatement(query);
            p.setInt(1, personID);
            p.setInt(2, courseID);
            ResultSet rs = p.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    ci.setCourseID(rs.getInt("CourseID"));
                    ci.setFirstName(rs.getString("FirstName"));
                    ci.setLastName(rs.getString("LastName"));
                    ci.setTeacherID(rs.getInt("PersonID"));
                    ci.setTitleCourse(rs.getString("Title"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return ci;

    }

    public int updateCourseInstructor(CourseInstructor newci, CourseInstructor oldci) {
        connectDB();
        int result = 0;
        try {
            String query = "update CourseInstructor set CourseID = ?, PersonID = ?\n"
                    + "where CourseID = ? and PersonID = ?;";
            PreparedStatement p = getConnection().prepareStatement(query);
            p.setInt(1, newci.getCourseID());
            p.setInt(2, newci.getTeacherID());
            p.setInt(3, oldci.getCourseID());
            p.setInt(4, oldci.getTeacherID());
            result = p.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    public int insertCourseInstructor(CourseInstructor ci) {
        connectDB();
        int result = 0;

        try {
            String query = "insert CourseInstructor(CourseID, PersonID) values (?, ?);";
            PreparedStatement p = getConnection().prepareStatement(query);
            p.setInt(1, ci.getCourseID());
            p.setInt(2, ci.getTeacherID());
            result = p.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    public ArrayList<CourseInstructor> findCourseInstructors(String title) {
        connectDB();
        ArrayList list = new ArrayList();

        try {
            String query = "select ci.CourseID, ci.PersonID, c.Title, p.FirstName, p.LastName\n"
                    + "from CourseInstructor ci join course c\n"
                    + "on ci.CourseID = c.CourseID join person p\n"
                    + "on ci.PersonID = p.PersonID and p.HireDate > 0\n"
                    + "where c.Title like ?;";
            PreparedStatement p = getConnection().prepareStatement(query);
            p.setString(1, "%" + title + "%");
            ResultSet rs = p.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    CourseInstructor ci = new CourseInstructor();
                    ci.setCourseID(rs.getInt("CourseID"));
                    ci.setFirstName(rs.getString("FirstName"));
                    ci.setLastName(rs.getString("LastName"));
                    ci.setTeacherID(rs.getInt("PersonID"));
                    ci.setTitleCourse(rs.getString("Title"));
                    list.add(ci);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }

        return list;
    }

    public int deleteCourseInstructor(int courseID, int personID) {
        connectDB();
        int result = 0;

        try {
            String query = "DELETE FROM CourseInstructor WHERE CourseID = ? and PersonID = ?;";
            PreparedStatement p = getConnection().prepareStatement(query);
            p.setInt(1, courseID);
            p.setInt(2, personID);
            result = p.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }

        return result;
    }

    public int countRecordCourseInstructor() {
        connectDB();
        int result = 0;

        try {
            String query = "select count(*) as count from CourseInstructor;";
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
