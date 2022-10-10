/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlykhoahoc.BLL;

import com.mycompany.quanlykhoahoc.DAL.OnlineCourseDAL;
import com.mycompany.quanlykhoahoc.Entity.OnlineCourse;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Manh Hai
 */
public class OnlineCourseBLL {

    OnlineCourseDAL onlineCourseDAL;

    public OnlineCourseBLL() {
        onlineCourseDAL = new OnlineCourseDAL();
    }

    public ArrayList<OnlineCourse> LoadOnlineCourses(int page) {
        int numofrecords = 15;
        ArrayList list = onlineCourseDAL.readOnlineCourses();
        int size = list.size();

        int from, to;
        from = (page - 1) * numofrecords;
        to = page * numofrecords;
        
        if(to > list.size()) {
            to = list.size();
        }
        
        ArrayList<OnlineCourse> resultList = new ArrayList<>();
        for(int i = from; i < to; i++) {
            resultList.add((OnlineCourse) list.get(i));
        }

        return resultList;
    }

    public List findOnlineCourse(String title) {
        List list = new ArrayList();
        list = onlineCourseDAL.findOnlineCourse(title);
        return list;
    }

    public OnlineCourse getOnlineCourse(int courseID) {
        OnlineCourse oc = onlineCourseDAL.getOnlineCourse(courseID);
        return oc;
    }

    public int addOnlineCourse(OnlineCourse oc) {
        int result = onlineCourseDAL.insertOnlineCourse(oc);
        return result;
    }
    
    public int updateOnlineCourse(OnlineCourse oc) {
        int result = onlineCourseDAL.updateOnlineCourse(oc);
        return result;
    }
    
    public int deleteOnlineCourse(int onlineCourseID) {
        int result = onlineCourseDAL.deleteOnlineCourse(onlineCourseID);
        return result;
    }
    
    public int countRecordOnlineCourse() {
        int result = onlineCourseDAL.countRecordOnlineCourse();
        return result;
    }
    
    public int getMaxIDCourse() {
        int result = onlineCourseDAL.getMaxIDCourse();
        return result;
    }
}
