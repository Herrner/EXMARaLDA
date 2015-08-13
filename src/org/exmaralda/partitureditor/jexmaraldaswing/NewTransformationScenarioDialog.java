/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * NewTransformationScenarioDialog.java
 *
 * Created on 11.02.2009, 16:26:23
 */

package org.exmaralda.partitureditor.jexmaraldaswing;

/**
 *
 * @author thomas
 */
public class NewTransformationScenarioDialog extends javax.swing.JDialog {

    /** Creates new form NewTransformationScenarioDialog */
    public NewTransformationScenarioDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
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
        jLabel1 = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionTextArea = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        okButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Name: ");
        jPanel1.add(jLabel1);

        nameTextField.setMaximumSize(new java.awt.Dimension(300, 20));
        nameTextField.setMinimumSize(new java.awt.Dimension(200, 20));
        nameTextField.setPreferredSize(new java.awt.Dimension(200, 20));
        jPanel1.add(nameTextField);

        getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Description"));
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.LINE_AXIS));

        jScrollPane1.setMaximumSize(new java.awt.Dimension(500, 200));

        descriptionTextArea.setColumns(20);
        descriptionTextArea.setLineWrap(true);
        descriptionTextArea.setRows(5);
        descriptionTextArea.setWrapStyleWord(true);
        descriptionTextArea.setMaximumSize(new java.awt.Dimension(200, 100));
        descriptionTextArea.setMinimumSize(new java.awt.Dimension(200, 100));
        descriptionTextArea.setPreferredSize(new java.awt.Dimension(200, 100));
        jScrollPane1.setViewportView(descriptionTextArea);

        jPanel3.add(jScrollPane1);

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        jPanel2.add(okButton);

        getContentPane().add(jPanel2, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_okButtonActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NewTransformationScenarioDialog dialog = new NewTransformationScenarioDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JTextArea descriptionTextArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    javax.swing.JTextField nameTextField;
    private javax.swing.JButton okButton;
    // End of variables declaration//GEN-END:variables

}
