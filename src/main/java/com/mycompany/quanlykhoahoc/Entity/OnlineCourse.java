/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlykhoahoc.Entity;

/**
 *
 * @author Manh Hai
 */
public class OnlineCourse extends Course{
    private String url;

    public OnlineCourse() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }  

    @Override
    public String toString() {
        return super.toString() + " OnlineCourse{" + "url=" + url + '}';
    }
    
    
}
