/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.mondemkhize.jd522fa2;

import java.awt.Component;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author monde
 */
public class NewTaskForm extends javax.swing.JFrame {

    /**
     * Creates new form NewTaskForm
     * @param comp
     * @param taskName
     * @param Category
     * @param description
     * @param compleationState
     */   
    public NewTaskForm(Component comp, String taskName, String Category, String description, boolean compleationState) {
        initComponents(comp);
        this.setLocationRelativeTo(null);
        if(comp instanceof JD522FA2){
            System.out.println("lol");
        }
        else if(comp instanceof ViewForm){
            System.out.println("edit yay");
            this.AddBtn.setText("Update");
            this.TaskNameField.setText(taskName);
            this.TaskNameField.setEditable(false);
            this.CategoryField.setText(Category);
            this.DecriptionField.setText(description);
            this.CompletionBox.setSelected(compleationState);
            
        }
        
        /*if(comp.getName()){
            System.out.println("cool");
        }*/
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents(Component comp) {

        TaskNameField = new javax.swing.JTextField();
        TaskNameLabel = new javax.swing.JLabel();
        DescriTaskLabel = new javax.swing.JLabel();
        DecriptionPane = new javax.swing.JScrollPane();
        DecriptionField = new javax.swing.JTextArea();
        CompletionBox = new javax.swing.JCheckBox();
        AddBtn = new javax.swing.JButton();
        CanclBtn = new javax.swing.JButton();
        CategoryLabel = new javax.swing.JLabel();
        CategoryField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("NewTask");

        TaskNameLabel.setText("Task Name:");

        DescriTaskLabel.setText("Description:");

        DecriptionField.setColumns(20);
        DecriptionField.setRows(5);
        DecriptionPane.setViewportView(DecriptionField);

        CompletionBox.setText("Complete");

        AddBtn.setText("Add");
        AddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBtnActionPerformed(evt, comp);
            }
        });

        CanclBtn.setText("Cancel");
        CanclBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CanclBtnActionPerformed(evt, comp);
            }
        });

        CategoryLabel.setText("Category:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(DescriTaskLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DecriptionPane, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 105, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(CategoryLabel))
                            .addComponent(TaskNameLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TaskNameField)
                            .addComponent(CategoryField))
                        .addGap(127, 127, 127))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CanclBtn)
                            .addComponent(AddBtn))
                        .addGap(75, 75, 75))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(CompletionBox)
                        .addGap(199, 199, 199))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TaskNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TaskNameLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CategoryLabel)
                    .addComponent(CategoryField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DecriptionPane, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DescriTaskLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CompletionBox)
                .addGap(18, 18, 18)
                .addComponent(AddBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CanclBtn)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddBtnActionPerformed(ActionEvent evt, Component comp) {
        Task currentTask = new Task();
        currentTask.setName(this.TaskNameField.getText());
        String taskName = currentTask.getName(); //New variable made to be used in database and file

        currentTask.setDescription(this.DecriptionField.getText());
        String description = currentTask.getDescription();//New variable made to be used in database and file

        currentTask.setCategory(this.CategoryField.getText());
        String category = currentTask.getCategory();//New variable made to be used in database and file

        currentTask.setCompletionState(this.CompletionBox.isSelected());
        String completionState = String.valueOf(currentTask.isCompletionState());
        if(comp instanceof JD522FA2){
            TaskDB insert = new TaskDB();
            insert.insert(taskName, category, description, completionState, this);

        currentTask.writeToFile(taskName, category, description, completionState, this);
        this.TaskNameField.setText("");
        this.CategoryField.setText("");
        this.DecriptionField.setText("");
        this.CompletionBox.setSelected(false);
        }
        else if(comp instanceof ViewForm){
            TaskDB update = new TaskDB();
            update.update(taskName, category, description, completionState, this);
            ViewForm viewForm = new ViewForm();
            viewForm.setVisible(true);
            this.dispose();
        }
    }

    private void CanclBtnActionPerformed(java.awt.event.ActionEvent evt, Component comp) {//GEN-FIRST:event_CanclBtnActionPerformed
        // TODO add your handling code here:
        if(comp instanceof JD522FA2){
            JD522FA2 mainwin = new JD522FA2();
            mainwin.setVisible(true);
            this.dispose();
        }else if(comp instanceof ViewForm){
            ViewForm mainwin = new ViewForm();
            mainwin.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_CanclBtnActionPerformed

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
            java.util.logging.Logger.getLogger(NewTaskForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewTaskForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewTaskForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewTaskForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewTaskForm(null, "", "", "", false).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBtn;
    private javax.swing.JButton CanclBtn;
    private javax.swing.JTextField CategoryField;
    private javax.swing.JLabel CategoryLabel;
    private javax.swing.JCheckBox CompletionBox;
    private javax.swing.JTextArea DecriptionField;
    private javax.swing.JScrollPane DecriptionPane;
    private javax.swing.JLabel DescriTaskLabel;
    private javax.swing.JTextField TaskNameField;
    private javax.swing.JLabel TaskNameLabel;
    // End of variables declaration//GEN-END:variables
}
