/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.mondemkhize.jd522fa2;

import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author monde
 */
public class TaskDB {
    private Connection connect (Component comp){
        Connection conn = null;
        String connectionString = "jdbc:sqlite:/home/monde/databasename";
        try{
            conn = DriverManager.getConnection(connectionString);
        } catch (SQLException e) {
            new JOptionPane().showMessageDialog(comp,e.getMessage());
        }
        return conn;
    }
    public void insert(String one, int two, Component comp){
       String sql = "INSERT INTO tbleone(one,two) VALUES(?,?)" ;
       
       try(Connection conn = this.connect(comp);
           PreparedStatement pstmnt = conn.prepareStatement(sql)){
           pstmnt.setString(1,one);
           pstmnt.setInt(2, two);
           pstmnt.executeUpdate();
           new JOptionPane().showMessageDialog(comp, pstmnt + "Successful");
       }catch (SQLException e){
           new JOptionPane().showMessageDialog(comp, e.getMessage());
       }
}
        
        
}

