/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.exmaralda.folker.gui;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.exmaralda.folker.utilities.FOLKERInternationalizer;
import org.jdom.Element;

/**
 *
 * @author Schmidt
 */
public class MaskEntryDialog extends javax.swing.JDialog implements ListSelectionListener {

    public boolean approved = false;
    private final KeyTableModel model;
    
    /**
     * Creates new form MaskEntryDialog
     */
    public MaskEntryDialog(java.awt.Frame parent, boolean modal, Element keyElement) {
        super(parent, modal);
        initComponents();
        maskEntryTextArea.getInputMap().put(KeyStroke.getKeyStroke("ENTER"),"ignoreEnterAndCloseWithOK"); 
        maskEntryTextArea.getActionMap().put("ignoreEnterAndCloseWithOK", new AbstractAction(){

            @Override
            public void actionPerformed(ActionEvent e) {
                okButtonActionPerformed(e);
            }
            
        });
        
        model = new KeyTableModel(keyElement);
        keyTable.setModel(model);
        keyTable.getSelectionModel().addListSelectionListener(this);
        
    }
    
    private void formatTable(){
        keyTable.getColumnModel().getColumn(0).setMinWidth(150);        
        keyTable.getColumnModel().getColumn(1).setMinWidth(150);        
    }
    
    public String getText(){
        return maskEntryTextArea.getText(); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textScrollPane = new javax.swing.JScrollPane();
        maskEntryTextArea = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        buttonPanel = new javax.swing.JPanel();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        keyPanel = new javax.swing.JPanel();
        keyTableScrollPane = new javax.swing.JScrollPane();
        keyTable = new javax.swing.JTable();
        editKeyPanel = new javax.swing.JPanel();
        realPanel = new javax.swing.JPanel();
        realLabel = new javax.swing.JLabel();
        realTextField = new javax.swing.JTextField();
        maskPanel = new javax.swing.JPanel();
        maskLabel = new javax.swing.JLabel();
        maskTextField = new javax.swing.JTextField();
        keyTableButtonPanel = new javax.swing.JPanel();
        addKeyButton = new javax.swing.JButton();
        removeKeyButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(FOLKERInternationalizer.getString("dialog.maskEntry"));

        maskEntryTextArea.setColumns(40);
        maskEntryTextArea.setLineWrap(true);
        maskEntryTextArea.setRows(10);
        maskEntryTextArea.setWrapStyleWord(true);
        textScrollPane.setViewportView(maskEntryTextArea);

        getContentPane().add(textScrollPane, java.awt.BorderLayout.CENTER);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/exmaralda/folker/tangoicons/othericons/mask_black.png"))); // NOI18N
        jPanel1.add(jLabel1);

        getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(okButton);

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(cancelButton);

        getContentPane().add(buttonPanel, java.awt.BorderLayout.SOUTH);

        keyPanel.setLayout(new java.awt.BorderLayout());

        keyTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        keyTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                keyTableMouseClicked(evt);
            }
        });
        keyTableScrollPane.setViewportView(keyTable);

        keyPanel.add(keyTableScrollPane, java.awt.BorderLayout.CENTER);

        editKeyPanel.setLayout(new java.awt.GridLayout(3, 1));

        realPanel.setLayout(new javax.swing.BoxLayout(realPanel, javax.swing.BoxLayout.LINE_AXIS));

        realLabel.setText("Realname: ");
        realLabel.setMaximumSize(new java.awt.Dimension(69, 14));
        realLabel.setPreferredSize(new java.awt.Dimension(69, 14));
        realPanel.add(realLabel);

        realTextField.setPreferredSize(new java.awt.Dimension(200, 20));
        realTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                realTextFieldActionPerformed(evt);
            }
        });
        realPanel.add(realTextField);

        editKeyPanel.add(realPanel);

        maskPanel.setLayout(new javax.swing.BoxLayout(maskPanel, javax.swing.BoxLayout.LINE_AXIS));

        maskLabel.setText("Maskenname: ");
        maskPanel.add(maskLabel);

        maskTextField.setPreferredSize(new java.awt.Dimension(200, 20));
        maskTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maskTextFieldActionPerformed(evt);
            }
        });
        maskPanel.add(maskTextField);

        editKeyPanel.add(maskPanel);

        keyTableButtonPanel.setLayout(new javax.swing.BoxLayout(keyTableButtonPanel, javax.swing.BoxLayout.LINE_AXIS));

        addKeyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/exmaralda/folker/tangoicons/tango-icon-theme-0.8.1/16x16/actions/list-add.png"))); // NOI18N
        addKeyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addKeyButtonActionPerformed(evt);
            }
        });
        keyTableButtonPanel.add(addKeyButton);

        removeKeyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/exmaralda/folker/tangoicons/tango-icon-theme-0.8.1/16x16/actions/list-remove.png"))); // NOI18N
        removeKeyButton.setEnabled(false);
        removeKeyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeKeyButtonActionPerformed(evt);
            }
        });
        keyTableButtonPanel.add(removeKeyButton);

        editKeyPanel.add(keyTableButtonPanel);

        keyPanel.add(editKeyPanel, java.awt.BorderLayout.SOUTH);

        getContentPane().add(keyPanel, java.awt.BorderLayout.WEST);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        approved = true;
        dispose();
    }//GEN-LAST:event_okButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void addKeyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addKeyButtonActionPerformed
        String realName = realTextField.getText();
        String maskName = maskTextField.getText();
        if (realName.trim().length()==0){
            JOptionPane.showMessageDialog(rootPane, "Realname darf nicht leer sein.");
            return;
        }
        if (maskName.trim().length()==0){
            JOptionPane.showMessageDialog(rootPane, "Maskenname darf nicht leer sein.");
            return;
        }
        model.addKey(realName, maskName);
    }//GEN-LAST:event_addKeyButtonActionPerformed

    private void removeKeyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeKeyButtonActionPerformed
       model.removeKey(keyTable.getSelectedRow());
    }//GEN-LAST:event_removeKeyButtonActionPerformed

    private void keyTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_keyTableMouseClicked
        if (evt.getClickCount()==2){
            int rowIndex = keyTable.getSelectedRow();
            if (rowIndex<0) return;
            String real = (String) model.getValueAt(rowIndex, 0);
            String mask = (String) model.getValueAt(rowIndex, 1);
            maskEntryTextArea.requestFocus();
            maskEntryTextArea.replaceSelection(real + " --> " + mask);
        }
    }//GEN-LAST:event_keyTableMouseClicked

    private void maskTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maskTextFieldActionPerformed
        addKeyButtonActionPerformed(evt);
    }//GEN-LAST:event_maskTextFieldActionPerformed

    private void realTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_realTextFieldActionPerformed
        maskTextField.requestFocus();
        maskTextField.selectAll();
    }//GEN-LAST:event_realTextFieldActionPerformed

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
            java.util.logging.Logger.getLogger(MaskEntryDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MaskEntryDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MaskEntryDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MaskEntryDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MaskEntryDialog dialog = new MaskEntryDialog(new javax.swing.JFrame(), true, null);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addKeyButton;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JPanel editKeyPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel keyPanel;
    private javax.swing.JTable keyTable;
    private javax.swing.JPanel keyTableButtonPanel;
    private javax.swing.JScrollPane keyTableScrollPane;
    private javax.swing.JTextArea maskEntryTextArea;
    private javax.swing.JLabel maskLabel;
    private javax.swing.JPanel maskPanel;
    private javax.swing.JTextField maskTextField;
    private javax.swing.JButton okButton;
    private javax.swing.JLabel realLabel;
    private javax.swing.JPanel realPanel;
    private javax.swing.JTextField realTextField;
    private javax.swing.JButton removeKeyButton;
    private javax.swing.JScrollPane textScrollPane;
    // End of variables declaration//GEN-END:variables

    @Override
    public void valueChanged(ListSelectionEvent e) {
        this.removeKeyButton.setEnabled(keyTable.getSelectedRow()>=0);
    }
}
