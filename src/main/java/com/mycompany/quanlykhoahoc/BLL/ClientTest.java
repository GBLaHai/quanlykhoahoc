/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlykhoahoc.BLL;

import com.mycompany.quanlykhoahoc.Entity.OnlineCourse;
import java.util.ArrayList;



/**
 *
 * @author Manh Hai
 */
public class ClientTest {
    public static void main(String[] args) {
        OnlineCourseBLL bLL = new OnlineCourseBLL();
        OnlineCourse course = bLL.getOnlineCourse(4041);
        System.out.println(course.toString());
    }
}
