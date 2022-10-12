/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlykhoahoc.BLL;

import com.mycompany.quanlykhoahoc.DAL.StudentGradeDAL;
import com.mycompany.quanlykhoahoc.Entity.StudentGrade;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Manh Hai
 */
public class StudentGradeBLL {

    StudentGradeDAL studentGradeDAL;

    public StudentGradeBLL() {
        studentGradeDAL = new StudentGradeDAL();
    }

    public ArrayList<StudentGrade> LoadStudentGrades(int page) {
        int numofrecords = 15;
        ArrayList list = studentGradeDAL.readStudentGarde();
        int size = list.size();

        int from, to;
        from = (page - 1) * numofrecords;
        to = page * numofrecords;
        
        if(to > list.size()) {
            to = list.size();
        }
        
        ArrayList<StudentGrade> resultList = new ArrayList<>();
        for(int i = from; i < to; i++) {
            resultList.add((StudentGrade) list.get(i));
        }

        return resultList;
    }

    public List findStudentGrade(String enrollmentID) {
        List list = new ArrayList();
        list = studentGradeDAL.findStudentGrades(enrollmentID);
        return list;
    }

    public StudentGrade getStudentGrade(int enrollmentID) {
        StudentGrade sg = studentGradeDAL.getStudentGrade(enrollmentID);
        return sg;
    }

    public int addStudentGrade(StudentGrade sg) {
        int result;
        if(sg.getGrade() > 10 || sg.getGrade() < 0) { 
            result = -1;
        }
        else {
            result = studentGradeDAL.insertStudentGrade(sg);
        }
        return result;
    }
    
    public int updateStudentGrade(StudentGrade sg) {
        int result;
        if(sg.getGrade() > 10 || sg.getGrade() < 0) { 
            result = -1;
        }
        else {
            result = studentGradeDAL.updateStudentGrade(sg);
        }
        return result;
    }
    
    public int deleteStudentGrade(int enrollmentID) {
        int result = studentGradeDAL.deleteStudentGrade(enrollmentID);
        return result;
    }
    
    public int countRecordStudentGrade() {
        int result = studentGradeDAL.countRecordStudentGrade();
        return result;
    }
    
}
