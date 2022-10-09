/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlykhoahoc.DAL;

import com.mycompany.quanlykhoahoc.Entity.OnlineCourse;
import java.util.ArrayList;


/**
 *
 * @author Manh Hai
 */
public class ClientTest {

    public static void main(String[] args) {
        OnlineCourseDAL ocdal = new OnlineCourseDAL();
        System.out.println(ocdal.countRecordOnlineCourse());
    }
}