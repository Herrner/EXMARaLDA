/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.exmaralda.partitureditor.jexmaraldaswing.fileDialogs;

/**
 *
 * @author Schmidt
 */
public class TCFExportAccessoryPanel extends javax.swing.JPanel {

    /**
     * Creates new form TCFExportAccessoryPanel
     */
    public TCFExportAccessoryPanel() {
        initComponents(); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        languageComboBox = new javax.swing.JComboBox();

        setBorder(javax.swing.BorderFactory.createTitledBorder("TCF Export Language"));

        languageComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "de", "en", "cs", "es", "fr", "it", "nl", "ro" }));
        add(languageComboBox);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox languageComboBox;
    // End of variables declaration//GEN-END:variables
}
