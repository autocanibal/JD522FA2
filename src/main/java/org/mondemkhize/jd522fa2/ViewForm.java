/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.mondemkhize.jd522fa2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import me.xdrop.fuzzywuzzy.FuzzySearch;
import me.xdrop.fuzzywuzzy.ToStringFunction;
import me.xdrop.fuzzywuzzy.model.BoundExtractedResult;
import me.xdrop.fuzzywuzzy.model.ExtractedResult;

/**
 *
 * @author monde
 */
public class ViewForm extends javax.swing.JFrame {

    /**
     * Creates new form ViewForm
     */
    TaskDB tdb = new TaskDB();
    ArrayList<HashMap<String, String>> taskDictionList = tdb.getTaskDictionList();
    ArrayList<String> taskNames = tdb.getTasksNames();
    public ViewForm() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.searchField.getDocument().addDocumentListener(new DocumentListener (){
            @Override//from  w  w  w .  j  av  a 2s.  com
            public void insertUpdate(DocumentEvent e) {
                List<ExtractedResult> match = FuzzySearch.extractTop(searchField.getText(), taskNames, 5);
                tdb.clearLists();
                for(ExtractedResult a: match){
                    System.out.println(a.getString());
                    tdb.selctWhere(a.getString(), rootPane);
                }
                jTable1.setModel(new javax.swing.table.DefaultTableModel(new String[]{"Task Name", "Category", "Description", "CompletionState"}, taskDictionList.size()));
                for (int r = 0; r < taskDictionList.size(); r++) {
                    jTable1.setValueAt(taskDictionList.get(r).get("TaskName"), r, 0);
                    jTable1.setValueAt(taskDictionList.get(r).get("Category"), r, 1);
                    jTable1.setValueAt(taskDictionList.get(r).get("Description"), r, 2);
                    jTable1.setValueAt(taskDictionList.get(r).get("CompletionState"), r, 3);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if(!searchField.getText().isEmpty()){
                List<ExtractedResult> match = FuzzySearch.extractTop(searchField.getText(), taskNames, 5);
                tdb.clearLists();
                for (ExtractedResult a : match) {
                    System.out.println(a.getString());
                    tdb.selctWhere(a.getString(), rootPane);
                }
                jTable1.setModel(new javax.swing.table.DefaultTableModel(new String[]{"Task Name", "Category", "Description", "CompletionState"}, taskDictionList.size()));
                for (int r = 0; r < taskDictionList.size(); r++) {
                    jTable1.setValueAt(taskDictionList.get(r).get("TaskName"), r, 0);
                    jTable1.setValueAt(taskDictionList.get(r).get("Category"), r, 1);
                    jTable1.setValueAt(taskDictionList.get(r).get("Description"), r, 2);
                    jTable1.setValueAt(taskDictionList.get(r).get("CompletionState"), r, 3);
                }
                }else{
                    tdb.selectAll(rootPane);
                    ArrayList<HashMap<String, String>> taskDictionList = tdb.getTaskDictionList();
                    jTable1.setModel(new javax.swing.table.DefaultTableModel(new String[]{"Task Name", "Category", "Description", "CompletionState"}, taskDictionList.size()));
                    for (int r = 0; r < taskDictionList.size(); r++) {
                        jTable1.setValueAt(taskDictionList.get(r).get("TaskName"), r, 0);
                        jTable1.setValueAt(taskDictionList.get(r).get("Category"), r, 1);
                        jTable1.setValueAt(taskDictionList.get(r).get("Description"), r, 2);
                        jTable1.setValueAt(taskDictionList.get(r).get("CompletionState"), r, 3);
                    }
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                System.out.println(searchField.getText());
            }
        });
        /*
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
    new Object [][] {
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null}
    },
    new String [] {
        "Task Name", "Category", "Description", "CompletionState"
    }
) {
    Class[] types = new Class [] {
        java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
    };

    public Class getColumnClass(int columnIndex) {
        return types [columnIndex];
    }
});
        */
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tdb.selectAll(this);
        ArrayList<HashMap<String,String>> taskDictionList = tdb.getTaskDictionList();
        jTable1 = new javax.swing.JTable();
        BackBtn = new javax.swing.JButton();
        editTaskBtn = new javax.swing.JButton();
        exportCSVBtn = new javax.swing.JButton();
        searchLbl = new javax.swing.JLabel();
        searchField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(new String [] {"Task Name", "Category", "Description", "CompletionState"},taskDictionList.size()));
        for(int r=0;r<taskDictionList.size();r++){
            jTable1.setValueAt(taskDictionList.get(r).get("TaskName"), r, 0);
            jTable1.setValueAt(taskDictionList.get(r).get("Category"), r, 1);
            jTable1.setValueAt(taskDictionList.get(r).get("Description"), r, 2);
            jTable1.setValueAt(taskDictionList.get(r).get("CompletionState"), r, 3);
        }
        jTable1.setRowSelectionAllowed(false);
        jScrollPane2.setViewportView(jTable1);

        BackBtn.setText("Return Home");
        BackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackBtnActionPerformed(evt);
            }
        });

        editTaskBtn.setText("Edit Task");
        editTaskBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editTaskBtnActionPerformed(evt);
            }
        });

        exportCSVBtn.setText("Export to CSV");
        exportCSVBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportCSVBtnActionPerformed(evt);
            }
        });

        searchLbl.setText("Search:");

        jLabel1.setText("Tasks Saved");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(82, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(editTaskBtn)
                        .addGap(18, 18, 18)
                        .addComponent(exportCSVBtn)
                        .addGap(18, 18, 18)
                        .addComponent(BackBtn)
                        .addGap(52, 52, 52))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(134, 134, 134))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(179, 179, 179)
                        .addComponent(searchLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchLbl)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BackBtn)
                    .addComponent(editTaskBtn)
                    .addComponent(exportCSVBtn))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackBtnActionPerformed
        JD522FA2 mainwin = new JD522FA2();
        mainwin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BackBtnActionPerformed

    private void editTaskBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editTaskBtnActionPerformed
        NewTaskForm editForm = new NewTaskForm(this);
        editForm.setVisible(true);
        try{
            //System.out.println(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), this.jTable1.getSelectedColumn()));
            //System.out.println(this.jTable1.editCellAt(this.jTable1.getEditingRow(), this.jTable1.getEditingColumn()));
            String taskName = this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0).toString();
            String category = this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 1).toString();
            String description = this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 2).toString();
            String completionState = this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 3).toString();
        }catch(Exception a){
            new JOptionPane().showMessageDialog(this, a.getMessage());
        }
        
    }//GEN-LAST:event_editTaskBtnActionPerformed

    private void exportCSVBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportCSVBtnActionPerformed
        // TODO add your handling code here:
        try{
        String pathName = this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0).toString().replaceAll(" ", "-")+".csv";
        Task task = new Task();
        task.xportToCSV(pathName, this.jTable1, this);
        }catch(Exception a){
            new JOptionPane().showMessageDialog(this, a.getMessage());
        }
    }//GEN-LAST:event_exportCSVBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackBtn;
    private javax.swing.JButton editTaskBtn;
    private javax.swing.JButton exportCSVBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField searchField;
    private javax.swing.JLabel searchLbl;
    // End of variables declaration//GEN-END:variables
}
