/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.mondemkhize.jd522fa2;

import java.awt.Component;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author monde
 */
public class TaskDB {
    private String OSname = System.getProperty("os.name");
    private ArrayList<Task> TasksList = new ArrayList();

    public ArrayList<Task> getTasksList() {
        return TasksList;
    }
    private Connection connect (Component comp){
        Connection conn = null;
        
        try{
            if (OSname.equals("Windows 11")) {
                String connectionString = "jdbc:sqlite:C:/sqlite/TaskManager.db";
                conn = DriverManager.getConnection(connectionString);
            } else {
                String connectionString = "jdbc:sqlite:/home/monde/TaskManager";
                conn = DriverManager.getConnection(connectionString);
            }
        } catch (SQLException e) {
            new JOptionPane().showMessageDialog(comp,e.getMessage());
        }
        return conn;
    }
    public void insert(String Name, String Category, String Description, String CompletionState, Component comp){
       String sql = "INSERT INTO TaskInfo(TaskName,Category, Description, CompletionState) VALUES(?,?,?,?)" ;
       
       try(Connection conn = this.connect(comp);
           PreparedStatement pstmnt = conn.prepareStatement(sql)){
           pstmnt.setString(1,Name);
           pstmnt.setString(2, Category);
           pstmnt.setString(3, Description);
           pstmnt.setString(4, CompletionState);
           pstmnt.executeUpdate();
           new JOptionPane().showMessageDialog(comp, "Added task successfullly");
       }catch (SQLException e){
           new JOptionPane().showMessageDialog(comp, e.getMessage());
       }
}
    
    public void selectAll(Component comp){
        String sql = "select * from TaskInfo";
        
        try(Connection conn = this.connect(comp);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql))
        {
            
            while(rs.next()){
                Task currentTask = new Task();
                currentTask.setName(rs.getString("TaskName"));
                currentTask.setCategory(rs.getString("Category"));
                currentTask.setDescription(rs.getString("Description"));
                boolean compState = Boolean.parseBoolean(rs.getString("CompletionState"));
                currentTask.setCompletionState(compState);
                TasksList.add(currentTask); 
            }
            
        }catch (SQLException e) {
            new JOptionPane().showMessageDialog(comp, e.getMessage());
        }
    }
    
        
}

