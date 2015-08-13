/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SelectionAccessory.java
 *
 * Created on 12.04.2010, 16:00:35
 */

package org.exmaralda.partitureditor.jexmaraldaswing.fileDialogs;

/**
 *
 * @author thomas
 */
public class SelectionAccessory extends javax.swing.JPanel {

    public static final int ALL = 0;
    public static final int VISIBLE = 1;
    public static final int SELECTION = 2;

    /** Creates new form SelectionAccessory */
    public SelectionAccessory() {
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        allRadioButton = new javax.swing.JRadioButton();
        visibleRadioButton = new javax.swing.JRadioButton();
        selectionRadioButton = new javax.swing.JRadioButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Range"));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        buttonGroup1.add(allRadioButton);
        allRadioButton.setSelected(true);
        allRadioButton.setText("Everything");
        add(allRadioButton);

        buttonGroup1.add(visibleRadioButton);
        visibleRadioButton.setText("All visible tiers");
        add(visibleRadioButton);

        buttonGroup1.add(selectionRadioButton);
        selectionRadioButton.setText("Selection");
        add(selectionRadioButton);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton allRadioButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton selectionRadioButton;
    private javax.swing.JRadioButton visibleRadioButton;
    // End of variables declaration//GEN-END:variables

    public int getSelectionChoice() {
        if (visibleRadioButton.isSelected()){
            return SelectionAccessory.VISIBLE;
        }
        if (selectionRadioButton.isSelected()){
            return SelectionAccessory.SELECTION;
        }
        return SelectionAccessory.ALL;
    }

}
