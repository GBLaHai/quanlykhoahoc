/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlykhoahoc.BLL;

import com.mycompany.quanlykhoahoc.DAL.DepartmentDAL;
import com.mycompany.quanlykhoahoc.Entity.Department;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Manh Hai
 */
public class DepartmentBLL {

    DepartmentDAL departmentDAL;

    public DepartmentBLL() {
        departmentDAL = new DepartmentDAL();
    }

    public ArrayList<Department> LoadDepartments() {
        List list = new ArrayList();
        list = departmentDAL.readDepartments();
        return (ArrayList<Department>) list;
    }

    public Department findDepartment(String name) {
        Department d = new Department();
        d = departmentDAL.findDepartment(name);
        return d;
    }

    public Department getDepartment(int departmentID) {
        Department d = departmentDAL.getDepartment(departmentID);
        return d;
    }
    
}
