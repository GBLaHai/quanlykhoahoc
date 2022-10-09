/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlykhoahoc.Entity;

/**
 *
 * @author Manh Hai
 */
public class Department {
    private int departmentID;
    private String name;
    private long budget;
    private String startDate;
    private int administrator;

    public Department() {
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getBudget() {
        return budget;
    }

    public void setBudget(long budget) {
        this.budget = budget;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public int getAdministrator() {
        return administrator;
    }

    public void setAdministrator(int administrator) {
        this.administrator = administrator;
    }

    @Override
    public String toString() {
        return "Department{" + "departmentID=" + departmentID + ", name=" + name + ", budget=" + budget + ", startDate=" + startDate + ", administrator=" + administrator + '}';
    }
    
    
}
