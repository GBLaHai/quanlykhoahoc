/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlykhoahoc.BLL;

import com.mycompany.quanlykhoahoc.DAL.TeacherDAL;
import com.mycompany.quanlykhoahoc.Entity.Teacher;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Manh Hai
 */
public class TeacherBLL {

    TeacherDAL teacherDAL;

    public TeacherBLL() {
        teacherDAL = new TeacherDAL();
    }

    public ArrayList<Teacher> LoadTeachers(int page) {
        int numofrecords = 15;
        ArrayList list = teacherDAL.readTeachers();
        int size = list.size();

        int from, to;
        from = (page - 1) * numofrecords;
        to = page * numofrecords;
        
        if(to > list.size()) {
            to = list.size();
        }
        
        ArrayList<Teacher> resultList = new ArrayList<>();
        for(int i = from; i < to; i++) {
            resultList.add((Teacher) list.get(i));
        }

        return resultList;
    }

    public List findTeacher(String fullname) {
        List list = new ArrayList();
        list = teacherDAL.findStudents(fullname);
        return list;
    }

    public Teacher getTeacher(int teacherID) {
        Teacher t = teacherDAL.getTeacher(teacherID);
        return t;
    }

    public int addTeacher(Teacher t) {
        int result = teacherDAL.insertTeacher(t);
        return result;
    }
    
    public int updateTeacher(Teacher t) {
        int result = teacherDAL.updateTeacher(t);
        return result;
    }
    
    public int deleteTeacher(int teacherID) {
        int result = teacherDAL.deleteTeacher(teacherID);
        return result;
    }
    
    public int countRecordTeacher() {
        int result = teacherDAL.countRecordTeacher();
        return result;
    }
    
}
