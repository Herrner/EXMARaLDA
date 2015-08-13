/*
 * NewTierDialog.java
 *
 * Created on 21. August 2001, 10:28
 */

package org.exmaralda.partitureditor.jexmaraldaswing;

import org.exmaralda.common.helpers.Internationalizer;
import org.exmaralda.partitureditor.jexmaralda.Tier;
import org.exmaralda.partitureditor.jexmaralda.Speakertable;
import org.exmaralda.partitureditor.jexmaralda.TierDescriptions;
import org.exmaralda.partitureditor.jexmaralda.BasicTranscription;
import java.util.*;
import org.exmaralda.partitureditor.jexmaralda.JexmaraldaException;

/**
 *
 * @author  Thomas
 * @version 
 */
public class NewTierDialog extends JEscapeDialog {

    private static String[] TYPES = {"T(ranscription)", "D(escription)", "A(nnotation)", "L(ink)", "U(ser) D(efined)"};
    private String[] speakers;
    private javax.swing.DefaultComboBoxModel speakerComboBoxModel;
    private String[] tiers;
    private BasicTranscription transcription;
    private Speakertable speakertable;
    private Tier newTier;
    public boolean speakertableChanged;
    private java.awt.Frame parent;
    private String[] speakerIDs;
    
    /** Creates new form NewTierDialog */
    public NewTierDialog(java.awt.Frame p, boolean modal, BasicTranscription t) {
        super (p, modal);
        parent = p;
        speakertableChanged = false;
        transcription = t;
        speakertable = transcription.getHead().getSpeakertable().makeCopy();
        speakerIDs = speakertable.getAllSpeakerIDs();
        Vector speakersVector = new Vector();
        for (int pos=0; pos<speakerIDs.length; pos++){
            try{
                String listEntry = speakerIDs[pos] + " [" + speakertable.getSpeakerWithID(speakerIDs[pos]).getAbbreviation() + "]";
                speakersVector.addElement(listEntry);
            } catch (org.exmaralda.partitureditor.jexmaralda.JexmaraldaException je){};
        }
        speakersVector.addElement("[no speaker]");
        speakers = StringUtilities.stringVectorToArray(speakersVector);
        speakerComboBoxModel = new javax.swing.DefaultComboBoxModel(speakers);
        
        String[] tierIDs = transcription.getBody().getAllTierIDs();
        TierDescriptions tierDescriptions = new TierDescriptions(transcription);                
        Vector tiersVector = new Vector();
        for (int pos=0; pos<tierIDs.length; pos++){
            String listEntry = tierIDs[pos] + " (" + tierDescriptions.getTierDescriptionForTierID(tierIDs[pos]) + ")";
            tiersVector.addElement(listEntry);
        }
        tiers = StringUtilities.stringVectorToArray(tiersVector);

        
        initComponents ();
        this.getRootPane().setDefaultButton(okButton);        
        pack ();
        
        Internationalizer.internationalizeDialogToolTips(this);
        
        checkWarnings();
        
    }

    public Tier getNewTier(){
        newTier.setDisplayName(newTier.getDescription(speakertable));
        return newTier;
    }
    
    public Speakertable getSpeakertable(){
        return speakertable;
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the FormEditor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonPanel = new javax.swing.JPanel();
        okButton = new javax.swing.JButton();
        okButton.setMnemonic('O');
        cancelButton = new javax.swing.JButton();
        cancelButton.setMnemonic('C');
        propertiesPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        speakerComboBox = new javax.swing.JComboBox(speakerComboBoxModel);
        speakerComboBox.setSelectedIndex(0);
        editSpeakerTableButton = new javax.swing.JButton();
        editSpeakerTableButton.setMnemonic('E');
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        typeComboBox = new javax.swing.JComboBox(TYPES);
        typeComboBox.setSelectedIndex(0);
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        categoryTextField = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        copyTierCheckBox = new javax.swing.JCheckBox();
        copyTierComboBox = new javax.swing.JComboBox(tiers);
        copyTierComboBox.setEnabled(false);
        copyTextCheckBox = new javax.swing.JCheckBox();
        warningPanel = new javax.swing.JPanel();
        warningLabel = new javax.swing.JLabel();

        setTitle("New tier");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        okButton.setText("OK");
        okButton.setMaximumSize(new java.awt.Dimension(110, 27));
        okButton.setMinimumSize(new java.awt.Dimension(80, 27));
        okButton.setPreferredSize(new java.awt.Dimension(110, 27));
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(okButton);

        cancelButton.setText("Cancel");
        cancelButton.setMaximumSize(new java.awt.Dimension(110, 27));
        cancelButton.setMinimumSize(new java.awt.Dimension(80, 27));
        cancelButton.setPreferredSize(new java.awt.Dimension(110, 27));
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(cancelButton);

        getContentPane().add(buttonPanel, java.awt.BorderLayout.SOUTH);

        propertiesPanel.setMaximumSize(new java.awt.Dimension(320, 100));
        propertiesPanel.setLayout(new javax.swing.BoxLayout(propertiesPanel, javax.swing.BoxLayout.Y_AXIS));

        jPanel3.setAlignmentX(0.0F);
        jPanel3.setAlignmentY(0.0F);
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.LINE_AXIS));

        jLabel2.setText("Speaker: ");
        jLabel2.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabel2.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabel2.setPreferredSize(new java.awt.Dimension(60, 16));
        jPanel3.add(jLabel2);

        speakerComboBox.setMaximumSize(new java.awt.Dimension(300, 27));
        speakerComboBox.setPreferredSize(new java.awt.Dimension(200, 27));
        speakerComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                speakerComboBoxActionPerformed(evt);
            }
        });
        jPanel3.add(speakerComboBox);

        editSpeakerTableButton.setText("Edit speakertable...");
        editSpeakerTableButton.setMaximumSize(new java.awt.Dimension(160, 27));
        editSpeakerTableButton.setPreferredSize(new java.awt.Dimension(160, 27));
        editSpeakerTableButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editSpeakerTableButtonActionPerformed(evt);
            }
        });
        jPanel3.add(editSpeakerTableButton);

        propertiesPanel.add(jPanel3);

        jPanel4.setAlignmentX(0.0F);
        jPanel4.setAlignmentY(0.0F);
        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.LINE_AXIS));

        jLabel3.setText("Type: ");
        jLabel3.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabel3.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabel3.setPreferredSize(new java.awt.Dimension(60, 16));
        jPanel4.add(jLabel3);

        typeComboBox.setMaximumSize(new java.awt.Dimension(200, 27));
        typeComboBox.setPreferredSize(new java.awt.Dimension(150, 27));
        typeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeComboBoxActionPerformed(evt);
            }
        });
        jPanel4.add(typeComboBox);

        propertiesPanel.add(jPanel4);

        jPanel5.setAlignmentX(0.0F);
        jPanel5.setAlignmentY(0.0F);
        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.LINE_AXIS));

        jLabel4.setText("Category: ");
        jLabel4.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabel4.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabel4.setPreferredSize(new java.awt.Dimension(60, 16));
        jPanel5.add(jLabel4);

        categoryTextField.setText("v");
        categoryTextField.setMaximumSize(new java.awt.Dimension(100, 27));
        categoryTextField.setMinimumSize(new java.awt.Dimension(50, 20));
        categoryTextField.setPreferredSize(new java.awt.Dimension(100, 27));
        jPanel5.add(categoryTextField);

        propertiesPanel.add(jPanel5);

        jPanel6.setAlignmentX(0.0F);
        jPanel6.setAlignmentY(0.0F);
        jPanel6.setLayout(new javax.swing.BoxLayout(jPanel6, javax.swing.BoxLayout.LINE_AXIS));

        copyTierCheckBox.setText("Copy events from: ");
        copyTierCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyTierCheckBoxActionPerformed(evt);
            }
        });
        jPanel6.add(copyTierCheckBox);

        copyTierComboBox.setMaximumSize(new java.awt.Dimension(200, 27));
        copyTierComboBox.setPreferredSize(new java.awt.Dimension(200, 27));
        jPanel6.add(copyTierComboBox);

        copyTextCheckBox.setSelected(true);
        copyTextCheckBox.setText("Copy text");
        jPanel6.add(copyTextCheckBox);

        propertiesPanel.add(jPanel6);

        getContentPane().add(propertiesPanel, java.awt.BorderLayout.CENTER);

        warningLabel.setForeground(new java.awt.Color(255, 0, 0));
        warningPanel.add(warningLabel);

        getContentPane().add(warningPanel, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void editSpeakerTableButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editSpeakerTableButtonActionPerformed
        // Add your handling code here:
       EditSpeakerTableDialog dialog = new EditSpeakerTableDialog(parent,true, speakertable);
        if (dialog.editSpeakertable()){
            speakertable=dialog.getSpeakertable();
            speakertableChanged=true;
            speakerIDs = speakertable.getAllSpeakerIDs();
            Vector speakersVector = new Vector();
            for (int pos=0; pos<speakerIDs.length; pos++){
                try{
                    String listEntry = new String(speakerIDs[pos] + " [" + speakertable.getSpeakerWithID(speakerIDs[pos]).getAbbreviation() + "]");
                    speakersVector.addElement(listEntry);
                } catch (org.exmaralda.partitureditor.jexmaralda.JexmaraldaException je){
                    je.printStackTrace();
                };
            }
            speakersVector.addElement(new String("[no speaker]"));
            speakers = StringUtilities.stringVectorToArray(speakersVector);
            speakerComboBoxModel.removeAllElements();
            for (int pos=0; pos<speakers.length; pos++){
                speakerComboBoxModel.addElement(speakers[pos]);
            }
        }                    
    }//GEN-LAST:event_editSpeakerTableButtonActionPerformed

  private void copyTierCheckBoxActionPerformed (java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyTierCheckBoxActionPerformed
// Add your handling code here:
      copyTierComboBox.setEnabled(copyTierCheckBox.isSelected());
      copyTextCheckBox.setEnabled(copyTierCheckBox.isSelected());
  }//GEN-LAST:event_copyTierCheckBoxActionPerformed

  private void cancelButtonActionPerformed (java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
// Add your handling code here:
    change = false;
    setVisible (false);
    dispose ();    
  }//GEN-LAST:event_cancelButtonActionPerformed

  private void okButtonActionPerformed (java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
// Add your handling code here:
    change = true;
    int typeIndex = typeComboBox.getSelectedIndex();
    String id = transcription.getBody().getFreeID();
    String type = new String();
    switch (typeIndex){
        case 0 : type = "t"; break;
        case 1 : type = "d"; break;
        case 2 : type = "a"; break;
        case 3 : type = "l"; break;
        case 4 : type = "ud"; break;
    }
    if (copyTierCheckBox.isSelected()){
        String selectedTier = (String)copyTierComboBox.getSelectedItem();
        String copyID = selectedTier.substring(0,selectedTier.indexOf(" ("));
        try {
            Tier copyTier = transcription.getBody().getTierWithID(copyID);
            if (!copyTextCheckBox.isSelected()){
                newTier = copyTier.makeEmptyCopy();
            } else {
                newTier = copyTier.makeCopy();
            }
        }
        catch (JexmaraldaException je) {}
    }
    else {
        newTier = new Tier();
    }
    String selectedSpeaker = (String)speakerComboBox.getSelectedItem();
    if (!selectedSpeaker.equals("[no speaker]")){
        String speakerID = speakerIDs[speakerComboBox.getSelectedIndex()];
        newTier.setSpeaker(speakerID);
    } else {
        newTier.setSpeaker(null);
    }
    newTier.setID(id);
    newTier.setType(type);
    String category = categoryTextField.getText();
    newTier.setCategory(category);
    setVisible (false);
    dispose ();               
  }//GEN-LAST:event_okButtonActionPerformed

    /** Closes the dialog */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        change = false;
        setVisible (false);
        dispose ();
    }//GEN-LAST:event_closeDialog

    private void speakerComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_speakerComboBoxActionPerformed
        checkWarnings();
    }//GEN-LAST:event_speakerComboBoxActionPerformed

    private void typeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeComboBoxActionPerformed
        checkWarnings();
    }//GEN-LAST:event_typeComboBoxActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main (String args[]) {
 //       new NewTierDialog (new javax.swing.JFrame (), true).show ();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField categoryTextField;
    private javax.swing.JCheckBox copyTextCheckBox;
    private javax.swing.JCheckBox copyTierCheckBox;
    private javax.swing.JComboBox copyTierComboBox;
    private javax.swing.JButton editSpeakerTableButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JButton okButton;
    private javax.swing.JPanel propertiesPanel;
    private javax.swing.JComboBox speakerComboBox;
    private javax.swing.JComboBox typeComboBox;
    private javax.swing.JLabel warningLabel;
    private javax.swing.JPanel warningPanel;
    // End of variables declaration//GEN-END:variables

    public boolean makeNewTier(){
        java.awt.Dimension dialogSize = this.getPreferredSize();
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(screenSize.width/2 - dialogSize.width/2, screenSize.height/2 - dialogSize.height/2);
        setVisible(true);
        return change;
    }

    private void checkWarnings() {
        String selectedSpeaker = (String) speakerComboBox.getSelectedItem();
        String speakerID = null;
        if (selectedSpeaker!=null && (!("[no speaker]".equals(selectedSpeaker)))){
            //speakerID = selectedSpeaker.substring(selectedSpeaker.lastIndexOf("[")+1, selectedSpeaker.lastIndexOf("]"));            
            speakerID = selectedSpeaker.substring(0, selectedSpeaker.lastIndexOf("[")-1);            
        }
        //System.out.println("Speaker ID : " + speakerID);
        String selectedType = (String) typeComboBox.getSelectedItem();
        //System.out.println(speakerID + " /// " + selectedType);
        if (selectedType.startsWith("T")){
            if (speakerID==null){
                warningLabel.setText("Tiers of type T(ranscription) must be assigned to a speaker!");
                return;
            }
            for (int pos=0; pos<transcription.getBody().getNumberOfTiers(); pos++){
                Tier t = transcription.getBody().getTierAt(pos);
                if (speakerID.equals(t.getSpeaker()) && t.getType().equals("t")){
                    warningLabel.setText("Only one tier of type T(ranscription) per speaker is allowed!");
                    return;                                        
                }
            }
        } else if (selectedType.startsWith("A")){
            if (speakerID==null){
                warningLabel.setText("Tiers of type A(nnotation) must be assigned to a speaker!");
                return;
            }
            boolean thereIsATTierForThisSpeaker = false;
            for (int pos=0; pos<transcription.getBody().getNumberOfTiers(); pos++){
                Tier t = transcription.getBody().getTierAt(pos);
                if (speakerID.equals(t.getSpeaker()) && t.getType().equals("t")){
                    thereIsATTierForThisSpeaker = true;
                }
            }
            if (!thereIsATTierForThisSpeaker){
                warningLabel.setText("For tiers of type A(nnotation) there must be a tier of type T with the same speaker!");
                return;                
            }            
        }
        warningLabel.setText("No warnings.");
    }
}