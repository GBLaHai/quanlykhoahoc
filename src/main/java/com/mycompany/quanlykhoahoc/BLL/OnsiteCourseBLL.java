/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlykhoahoc.BLL;

import com.mycompany.quanlykhoahoc.DAL.OnsiteCourseDAL;
import com.mycompany.quanlykhoahoc.Entity.OnsiteCourse;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Manh Hai
 */
public class OnsiteCourseBLL {

    OnsiteCourseDAL onsiteCourseDAL;

    public OnsiteCourseBLL() {
        onsiteCourseDAL = new OnsiteCourseDAL();
    }

    public ArrayList<OnsiteCourse> LoadOnsiteCourses(int page) {
        int numofrecords = 15;
        ArrayList list = onsiteCourseDAL.readOnsiteCourses();
        int size = list.size();

        int from, to;
        from = (page - 1) * numofrecords;
        to = page * numofrecords;
        
        if(to > list.size()) {
            to = list.size();
        }
        
        ArrayList<OnsiteCourse> resultList = new ArrayList<>();
        for(int i = from; i < to; i++) {
            resultList.add((OnsiteCourse) list.get(i));
        }

        return resultList;
    }

    public List findOnsiteCourse(String title) {
        List list = new ArrayList();
        list = onsiteCourseDAL.findOnsiteCourse(title);
        return list;
    }

    public OnsiteCourse getOnsiteCourse(int courseID) {
        OnsiteCourse oc = onsiteCourseDAL.getOnsiteCourse(courseID);
        return oc;
    }

    public int addOnsiteCourse(OnsiteCourse oc) {
        int result = onsiteCourseDAL.insertOnsiteCourse(oc);
        return result;
    }
    
    public int updateOnsiteCourse(OnsiteCourse oc) {
        int result = onsiteCourseDAL.updateOnsiteCourse(oc);
        return result;
    }
    
    public int deleteOnsiteCourse(int onsiteCourseID) {
        int result = onsiteCourseDAL.deleteOnsiteCourse(onsiteCourseID);
        return result;
    }
    
    public int countRecordOnsiteCourse() {
        int result = onsiteCourseDAL.countRecordOnsiteCourse();
        return result;
    }
    
    public int getMaxIDCourse() {
        int result = onsiteCourseDAL.getMaxIDCourse();
        return result;
    }
}
