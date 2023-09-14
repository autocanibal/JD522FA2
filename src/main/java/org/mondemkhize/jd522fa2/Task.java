/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.mondemkhize.jd522fa2;

import com.opencsv.CSVWriter;
import java.awt.Component;
import java.io.BufferedWriter;
import java.io.File;
import java.nio.file.*;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.attribute.FileTime;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author monde
 */
public class Task {
    private String Name;
    private String Description;
    private String Category;
    private boolean completionState;
    
    final HashMap<String, String> TaskDictionary = new HashMap();
    
    
    public HashMap<String, String> getTaskDictionary() {
        TaskDictionary.put("Task Name", Name);
        TaskDictionary.put("Category", Category);
        TaskDictionary.put("Description", Description);
        TaskDictionary.put("Completion State", String.valueOf(completionState));
        return TaskDictionary;
    }

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
        BufferedWriter out;
        try {
            out = new BufferedWriter(new FileWriter("out.txt"));
            out.write(taskName + "\n" + category + "\n" + description + "\n" + completionState);
            out.close();
            new JOptionPane().showMessageDialog(comp, "File saved successfully");
        } catch (IOException ex) {
            new JOptionPane().showMessageDialog(comp, "IO Failed");
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
    
    public long fileSize(Component comp){
        Path path = Path.of("out.txt");
        try{
            long bytes = Files.size(path);
            return bytes;
        }catch(IOException exception){
            new JOptionPane().showMessageDialog(comp, exception.getMessage());
            return 0;
        }
    }
    
    public String creationTime(Component comp){
        try{
            Path path = Path.of("out.txt");
            FileTime fileTime = (FileTime) Files.getAttribute(path, "creationTime");
            LocalDateTime localDateTime = fileTime.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

            return localDateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
            //return fileTime;
        }catch (IOException ex) {
            new JOptionPane().showMessageDialog(comp, ex.getMessage());
            return "Never";
        }
    }
    
    public String lastModified(Component comp) {
        try {
            Path path = Path.of("out.txt");
            FileTime fileTime = Files.getLastModifiedTime(path);
            LocalDateTime localDateTime = fileTime.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

            return localDateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
            //return fileTime;
        } catch (IOException ex) {
            new JOptionPane().showMessageDialog(comp, ex.getMessage());
            return "Never";
        }
    }
    
    public void xportToCSV(String fileName, JTable table,Component comp){
        File file = new File(fileName);
        try {
            // create FileWriter object with file as parameter
            FileWriter outputfile = new FileWriter(file);

            // create CSVWriter with '|' as separator
            CSVWriter writer = new CSVWriter(outputfile, '|',
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);

            // create a List which contains String array
            List<String[]> data = new ArrayList<String[]>();
            data.add(new String[]{"TaskName", "Category", "Description", "Completon Status"});
            data.add(new String[]{table.getValueAt(table.getSelectedRow(), 0).toString(), table.getValueAt(table.getSelectedRow(), 1).toString(), table.getValueAt(table.getSelectedRow(), 2).toString(), table.getValueAt(table.getSelectedRow(), 3).toString()});
            writer.writeAll(data);

            // closing writer connection
            writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            new JOptionPane().showMessageDialog(comp, e.getMessage());
        }
    }
}
