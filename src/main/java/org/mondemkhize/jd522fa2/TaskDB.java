/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.mondemkhize.jd522fa2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author monde
 */
public class TaskDB {
    public void connect (){
        Connection conn = null;
        try{
            String connectionString = "jdbc:sqlite:/home/monde/databasename";
            conn = DriverManager.getConnection(connectionString);
            System.out.println("Connection to sqlite successfull");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally {
            try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
        
        
}

