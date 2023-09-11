/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.mondemkhize.jd522fa2;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author monde
 */
public class Task {
    private String Name;
    private String Description;
    private String Category;
    private boolean completionState;

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

    public boolean isCompletionState() {
        return completionState;
    }

    public void setCompletionState(boolean completionState) {
        this.completionState = completionState;
    }
    
    public void writeToFile(String taskName, String category, String description, String completionState, Component comp){
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new FileWriter("out.txt"));
            out.write(taskName + "\n" + category + "\n" + description + "\n" + completionState);
            new JOptionPane().showMessageDialog(comp, "It worked");
        } catch (IOException ex) {
            new JOptionPane().showMessageDialog(comp, "IO Failed");
        } finally {
            try {
                out.close();
            } catch (IOException ex) {
                Logger.getLogger(NewTaskForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public List<String> readFromFile(Component comp){
        Path filePath = Path.of("out.txt");
        try{
            List<String> contents = Files.readAllLines(filePath);
            //contents.forEach(line -> System.out.println(line));
            return contents;
        }catch (IOException ex) {
            new JOptionPane().showMessageDialog(comp, ex.getMessage());
            return null;
        }
        
    }
}
