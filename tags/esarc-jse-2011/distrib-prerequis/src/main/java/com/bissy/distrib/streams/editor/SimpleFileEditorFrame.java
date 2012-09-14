package com.bissy.distrib.streams.editor;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class SimpleFileEditorFrame extends javax.swing.JFrame {

    private FileEditor fileEditor;

    /** Creates new form SimpleFileEditor */
    public SimpleFileEditorFrame() {
        initComponents();
        setLocation(200, 200);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        saveAsMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        fileMenu.setText("File");
        fileMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileMenuActionPerformed(evt);
            }
        });

        openMenuItem.setText("Open");
        openMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(openMenuItem);

        saveMenuItem.setText("Save");
        saveMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(saveMenuItem);

        saveAsMenuItem.setText("Save As ...");
        saveAsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAsMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(saveAsMenuItem);

        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        helpMenu.setText("Help");

        aboutMenuItem.setText("About");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 637, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void openMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuItemActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        chooser.setMultiSelectionEnabled(false);
        chooser.setDialogTitle("Open file ..."); // NOI18N
        chooser.setCurrentDirectory(new File("."));
        int option = chooser.showOpenDialog(SwingUtilities.getWindowAncestor(openMenuItem)); // Sow the chooser
        
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            fileEditor = new FileEditor(file);
            try {
                jTextArea1.setText(fileEditor.getContent());
            } catch (Exception ex) {
                jTextArea1.setText(ex.getMessage());
                throw new RuntimeException(ex);
            }
        }
    }//GEN-LAST:event_openMenuItemActionPerformed

    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
        JOptionPane.showMessageDialog(this, "Cours d'objet distribué\n Copyright, 2009");
    }//GEN-LAST:event_aboutMenuItemActionPerformed

    private void fileMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileMenuActionPerformed
       
    }//GEN-LAST:event_fileMenuActionPerformed

    private void saveAsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAsMenuItemActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        chooser.setMultiSelectionEnabled(false);
        chooser.setDialogTitle("Save as ..."); // NOI18N

        if (fileEditor != null && fileEditor.getFile() != null) {
            chooser.setCurrentDirectory(fileEditor.getFile().getParentFile());
        } else {
            chooser.setCurrentDirectory(new File("."));
        }
        int option = chooser.showSaveDialog(SwingUtilities.getWindowAncestor(openMenuItem)); // Sow the chooser

        if (option == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            fileEditor = new FileEditor(file);
            try {
                fileEditor.save(jTextArea1.getText());
            } catch (Exception ex) {
                jTextArea1.setText(ex.getMessage());
                throw new RuntimeException(ex);
            }
        }
    }//GEN-LAST:event_saveAsMenuItemActionPerformed

    private void saveMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveMenuItemActionPerformed
         if (fileEditor == null || fileEditor.getFile() == null) {
            saveAsMenuItemActionPerformed(evt);
        }
        try {
             fileEditor.save(jTextArea1.getText());
        } catch (Exception ex) {
            jTextArea1.setText(ex.getMessage());
            throw new RuntimeException(ex);
        }

    }//GEN-LAST:event_saveMenuItemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new SimpleFileEditorFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JMenuItem saveAsMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    // End of variables declaration//GEN-END:variables
}
