/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.app.view;

import java.awt.Dimension;
import java.awt.Toolkit;

import com.mycompany.app.controller.HelpViewController;
import com.mycompany.app.utils.commands.Commands;

/**
 * Help view.
 */
public final class HelpView extends javax.swing.JFrame {

    /**
     * Controller.
     */
    @SuppressWarnings("unused")
    private HelpViewController c;

    /**
     * Creates new form StartView.
     */
    public HelpView() {
        initComponents();
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(d.width / 2 - this.getSize().width / 2, d.height / 2 - this.getSize().height / 2);

        c = new HelpViewController();

        listCommandsArea.setText(Commands.helpCommand());
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        frameLabel = new javax.swing.JLabel();
        listCommandsArea = new javax.swing.JTextArea();

        listCommandsArea.setEditable(false);
        listCommandsArea.setLineWrap(true);
        listCommandsArea.setWrapStyleWord(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        frameLabel.setText("Comandi");

        listCommandsArea.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(195, 195, 195)
                .addComponent(frameLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(listCommandsArea)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(frameLabel)
                .addGap(3, 3, 3)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(listCommandsArea, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel frameLabel;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea listCommandsArea;
    // End of variables declaration//GEN-END:variables
}
