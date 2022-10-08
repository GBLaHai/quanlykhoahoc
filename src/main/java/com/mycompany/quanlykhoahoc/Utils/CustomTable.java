/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlykhoahoc.Utils;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTable;

/**
 *
 * @author Manh Hai
 */
public class CustomTable {
    // create a function to customize the jtable
    public void customTable(JTable table) {
        table.setSelectionBackground(new Color(249, 105, 14));
        table.setSelectionForeground(Color.white);
        table.setRowHeight(35);
        table.setShowGrid(false);
        table.setBackground(new Color(248, 248, 248));
        table.setShowHorizontalLines(true);
        table.setGridColor(Color.orange);
    }
    
    // create a function to customize the jtable header
    public void customTableHeader(JTable table, Color brColor, Integer fontSize) {
        table.getTableHeader().setBackground(brColor);
        table.getTableHeader().setForeground(Color.white);
        table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, fontSize));
        table.getTableHeader().setOpaque(false);
    }
}
