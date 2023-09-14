/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.mondemkhize.jd522fa2;

import java.awt.Component;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;
import me.xdrop.fuzzywuzzy.FuzzySearch;
import me.xdrop.fuzzywuzzy.model.ExtractedResult;

/**
 *
 * @author monde
 */
public class TaskDB {
    final String OSname = System.getProperty("os.name");
    
    private ArrayList<Task> TasksList = new ArrayList();
    private ArrayList<HashMap<String, String>> TaskDictionList = new ArrayList();
    private ArrayList<String> taskNames = new ArrayList();

    Comparator<HashMap<String, String>> categoryComparator = new Comparator<HashMap<String, String>>() {

        @Override
        public int compare(HashMap<String, String> o1, HashMap<String, String> o2) {
            // Get the distance and compare the distance.
            String firstValue = o1.get("Category");
            String secondValue = o2.get("Category");
            return firstValue.compareTo(secondValue);
        }
    };
    
    public ArrayList<HashMap<String, String>> getTaskDictionList() {
        return TaskDictionList;
    }

    public ArrayList<Task> getTasksList() {
        return TasksList;
    }
    
    public ArrayList<String> getTasksNames() {
        return taskNames;
    }
    
    public void clearLists(){
        TasksList.clear();
        taskNames.clear();
        TaskDictionList.clear();
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
        TasksList.clear();
        taskNames.clear();
        TaskDictionList.clear();
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
                taskNames.add(currentTask.getName());
                currentTask.setTaskNames(taskNames);
                TaskDictionList.add(currentTask.getTaskDictionary());
            }
            Collections.sort(TaskDictionList, categoryComparator);
            /*
            System.out.println("\n\n");
            
            for (var a : TaskDictionList) {
                System.out.println(a);
            }*/
        }catch (SQLException e) {
            new JOptionPane().showMessageDialog(comp, e.getMessage());
        }
    }
    
   
    public void selctWhere(String TaskName, Component comp){
        String sql = "select * from TaskInfo where TaskName=?";
        
        try (Connection conn = this.connect(comp); PreparedStatement pstmt = conn.prepareStatement(sql)){

            pstmt.setString(1, TaskName);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Task currentTask = new Task();

                currentTask.setName(rs.getString("TaskName"));
                currentTask.setCategory(rs.getString("Category"));
                currentTask.setDescription(rs.getString("Description"));
                boolean compState = Boolean.parseBoolean(rs.getString("CompletionState"));

                currentTask.setCompletionState(compState);
             
                TasksList.add(currentTask);
                taskNames.add(currentTask.getName());
                currentTask.setTaskNames(taskNames);
                TaskDictionList.add(currentTask.getTaskDictionary());
            }

        } catch (SQLException e) {
            new JOptionPane().showMessageDialog(comp, e.getMessage());
        }
    }
        
}

