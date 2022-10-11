/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlykhoahoc.BLL;

import com.mycompany.quanlykhoahoc.DAL.CourseInstructorDAL;
import com.mycompany.quanlykhoahoc.Entity.CourseInstructor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Manh Hai
 */
public class CourseInstructorBLL {

    CourseInstructorDAL courseInstructorDAL;

    public CourseInstructorBLL() {
        courseInstructorDAL = new CourseInstructorDAL();
    }

    public ArrayList<CourseInstructor> LoadCourseInstructor(int page) {
        int numofrecords = 15;
        ArrayList list = courseInstructorDAL.readCourseIntructors();
        int size = list.size();

        int from, to;
        from = (page - 1) * numofrecords;
        to = page * numofrecords;
        
        if(to > list.size()) {
            to = list.size();
        }
        
        ArrayList<CourseInstructor> resultList = new ArrayList<>();
        for(int i = from; i < to; i++) {
            resultList.add((CourseInstructor) list.get(i));
        }

        return resultList;
    }

    public List findCourseInstructor(String title) {
        List list = new ArrayList();
        list = courseInstructorDAL.findCourseInstructors(title);
        return list;
    }

    public CourseInstructor getCourseInstructor(int courseID, int teacherID) {
        CourseInstructor ci = courseInstructorDAL.getCourseInstructor(courseID, teacherID);
        return ci;
    }

    public int addCourseInstructor(CourseInstructor ci) {
        int result = courseInstructorDAL.insertCourseInstructor(ci);
        return result;
    }
    
    public int updateCourseInstructor(CourseInstructor newci, CourseInstructor oldci) {
        int result = courseInstructorDAL.updateCourseInstructor(newci, oldci);
        return result;
    }
    
    public int deleteCourseInstructor(int courseID, int teacherID) {
        int result = courseInstructorDAL.deleteCourseInstructor(courseID, teacherID);
        return result;
    }
    
    public int countRecordCourseInstructor() {
        int result = courseInstructorDAL.countRecordCourseInstructor();
        return result;
    }
    
}
