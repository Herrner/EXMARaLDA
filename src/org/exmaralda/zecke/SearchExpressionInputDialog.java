/*
 * SearchExpressionInputDialog.java
 *
 * Created on 18. Januar 2005, 17:58
 */

package org.exmaralda.zecke;

/**
 *
 * @author  thomas
 */
public class SearchExpressionInputDialog extends javax.swing.JDialog {
    
    /** Creates new form SearchExpressionInputDialog */
    public SearchExpressionInputDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public String getSearchExpression(){
        int count = 0;
        String result = "";
        if (wordListSearchRadioButton.isSelected()){
            String wordlist = wordListTextField.getText();
            java.util.StringTokenizer tokenizer = new java.util.StringTokenizer(wordlist, ",");
            while (tokenizer.hasMoreTokens()){
                if (count>0) result+="|";
                String word = tokenizer.nextToken();
                char initial = word.charAt(0);
                String firstChar = Character.toString(initial);
                if (ignoreCaseCheckBox.isSelected()){
                    if (Character.isUpperCase(initial)){
                        firstChar = "[" + initial + Character.toLowerCase(initial) + "]";                        
                    } else if (Character.isLowerCase(initial)){
                        firstChar = "[" + initial + Character.toUpperCase(initial) + "]";                                                
                    }                    
                }
                String casedWord = firstChar + word.substring(1);
                result+="(\\b" + casedWord + "\\b)";
                count++;
            }
        } else if (delimiterSearchRadioButton.isSelected()){
            result = leftDelimiterTextField.getText() + ".*?" + rightDelimiterTextField.getText();
        }
        return result;
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        wordListSearchRadioButton = new javax.swing.JRadioButton();
        wordListTextField = new javax.swing.JTextField();
        ignoreCaseCheckBox = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        delimiterSearchRadioButton = new javax.swing.JRadioButton();
        leftDelimiterTextField = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        rightDelimiterTextField = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setTitle("Search Expression Input Helper");
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jPanel1.setLayout(new java.awt.GridLayout(2, 1));

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.X_AXIS));

        wordListSearchRadioButton.setSelected(true);
        wordListSearchRadioButton.setText("Wordlist Search");
        buttonGroup1.add(wordListSearchRadioButton);
        jPanel2.add(wordListSearchRadioButton);

        wordListTextField.setToolTipText("Enter words, separated by commas, e.g.: he,she,it");
        wordListTextField.setPreferredSize(new java.awt.Dimension(200, 20));
        wordListTextField.setFocusCycleRoot(true);
        wordListTextField.setMaximumSize(new java.awt.Dimension(700, 20));
        wordListTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                wordListTextFieldFocusGained(evt);
            }
        });

        jPanel2.add(wordListTextField);

        ignoreCaseCheckBox.setText("Ignore case");
        jPanel2.add(ignoreCaseCheckBox);

        jPanel1.add(jPanel2);

        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.X_AXIS));

        delimiterSearchRadioButton.setText("Delimiter Search");
        buttonGroup1.add(delimiterSearchRadioButton);
        jPanel3.add(delimiterSearchRadioButton);

        leftDelimiterTextField.setPreferredSize(new java.awt.Dimension(50, 20));
        leftDelimiterTextField.setMaximumSize(new java.awt.Dimension(50, 20));
        leftDelimiterTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                leftDelimiterTextFieldFocusGained(evt);
            }
        });

        jPanel3.add(leftDelimiterTextField);

        jPanel5.setMaximumSize(new java.awt.Dimension(30, 20));
        jPanel3.add(jPanel5);

        rightDelimiterTextField.setPreferredSize(new java.awt.Dimension(50, 20));
        rightDelimiterTextField.setMaximumSize(new java.awt.Dimension(50, 20));
        rightDelimiterTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                rightDelimiterTextFieldFocusGained(evt);
            }
        });

        jPanel3.add(rightDelimiterTextField);

        jPanel1.add(jPanel3);

        getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel4.add(jButton1);

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel4.add(jButton2);

        getContentPane().add(jPanel4, java.awt.BorderLayout.SOUTH);

        pack();
    }//GEN-END:initComponents

    private void rightDelimiterTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rightDelimiterTextFieldFocusGained
        // TODO add your handling code here:
        delimiterSearchRadioButton.setSelected(true);        
    }//GEN-LAST:event_rightDelimiterTextFieldFocusGained

    private void leftDelimiterTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_leftDelimiterTextFieldFocusGained
        // TODO add your handling code here:
        delimiterSearchRadioButton.setSelected(true);        
    }//GEN-LAST:event_leftDelimiterTextFieldFocusGained

    private void wordListTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_wordListTextFieldFocusGained
        // TODO add your handling code here:
        wordListSearchRadioButton.setSelected(true);
    }//GEN-LAST:event_wordListTextFieldFocusGained

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        new SearchExpressionInputDialog(new javax.swing.JFrame(), true).show();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton delimiterSearchRadioButton;
    private javax.swing.JCheckBox ignoreCaseCheckBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField leftDelimiterTextField;
    private javax.swing.JTextField rightDelimiterTextField;
    private javax.swing.JRadioButton wordListSearchRadioButton;
    private javax.swing.JTextField wordListTextField;
    // End of variables declaration//GEN-END:variables
    
    public void show(){
        java.awt.Dimension dialogSize = this.getPreferredSize();
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(screenSize.width/2 - dialogSize.width/2, screenSize.height/2 - dialogSize.height/2);        
        super.show();
    }
    
    
}
