/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PartiturEditorInfoPanel.java
 *
 * Created on 11.10.2011, 14:49:27
 */
package org.exmaralda.partitureditor.jexmaraldaswing;

/**
 *
 * @author thomas
 */
public class PartiturEditorInfoPanel extends javax.swing.JPanel {

    /** Creates new form PartiturEditorInfoPanel */
    public PartiturEditorInfoPanel() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        segmentationLabel = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 32767));
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        playerLabel = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

        jLabel1.setText("Segmentation: ");
        jPanel2.add(jLabel1);

        segmentationLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        segmentationLabel.setText("GENERIC");
        jPanel2.add(segmentationLabel);

        jPanel1.add(jPanel2);
        jPanel1.add(filler1);

        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.LINE_AXIS));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Player: ");
        jPanel3.add(jLabel2);

        playerLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        playerLabel.setText("DirectShow");
        jPanel3.add(playerLabel);

        jPanel1.add(jPanel3);

        add(jPanel1, java.awt.BorderLayout.EAST);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public javax.swing.JLabel playerLabel;
    public javax.swing.JLabel segmentationLabel;
    // End of variables declaration//GEN-END:variables
}
