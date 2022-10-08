/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlykhoahoc.BLL;

import com.mycompany.quanlykhoahoc.DAL.StudentDAL;
import com.mycompany.quanlykhoahoc.Entity.Student;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Manh Hai
 */
public class StudentBLL {

    StudentDAL studentDAL;

    public StudentBLL() {
        studentDAL = new StudentDAL();
    }

    public ArrayList<Student> LoadStudents(int page) {
        int numofrecords = 15;
        ArrayList list = studentDAL.readStudents();
        int size = list.size();

        int from, to;
        from = (page - 1) * numofrecords;
        to = page * numofrecords;
        
        if(to > list.size()) {
            to = list.size();
        }
        
        ArrayList<Student> resultList = new ArrayList<>();
        for(int i = from; i < to; i++) {
            resultList.add((Student) list.get(i));
        }

        return resultList;
    }

    public List findStudent(String fullname) {
        List list = new ArrayList();
        list = studentDAL.findStudents(fullname);
        return list;
    }

    public Student getStudent(int studentID) {
        Student s = studentDAL.getStudent(studentID);
        return s;
    }

    public int addStudent(Student s) {
        int result = studentDAL.insertStudent(s);
        return result;
    }
    
    public int updateStudent(Student s) {
        int result = studentDAL.updateStudent(s);
        return result;
    }
    
    public int deleteStudent(int studentID) {
        int result = studentDAL.deleteStudent(studentID);
        return result;
    }
    
    public int countRecordStudent() {
        int result = studentDAL.countRecordStudent();
        return result;
    }
    
}
