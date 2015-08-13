/*
 * EditSpeakerPanel.java
 *
 * Created on 21. Mai 2008, 11:21
 */

package org.exmaralda.folker.gui;

import javax.swing.*;
import javax.swing.event.*;
import org.exmaralda.folker.data.EventListTranscription;
import org.exmaralda.folker.data.Speaker;
import org.exmaralda.folker.utilities.FOLKERInternationalizer;

/**
 *
 * @author  thomas
 */
public class EditSpeakerPanel extends javax.swing.JPanel implements ListSelectionListener {
    
    EventListTranscription eventListTranscription;
    SpeakerListModel speakerListModel;
    Speaker currentSpeaker;
    
    /** Creates new form EditSpeakerPanel */
    public EditSpeakerPanel(EventListTranscription elt) {
        eventListTranscription = elt;
        initComponents();
        speakerListModel = new SpeakerListModel(elt.getSpeakerlist());
        speakerList.setModel(speakerListModel);
        speakerList.setCellRenderer(new org.exmaralda.folker.listview.SpeakerListCellRenderer(true));        
        speakerList.addListSelectionListener(this);        
        if (speakerListModel.getSize()>0){
            speakerList.setSelectedIndex(0);
        }
    }

    void validateInput(){
        if (currentSpeaker!=null){
            String id = idTextField.getText();
            String realID = id;
            if (!currentSpeaker.getIdentifier().equals(id)){
                realID = eventListTranscription.getSpeakerlist().getFreeID(id);
                speakerListModel.setSpeakerID(currentSpeaker, realID);
            }
            speakerListModel.setSpeakerName(currentSpeaker, nameTextField.getText());
        }        
    }
    
    public void valueChanged(ListSelectionEvent e) {
        validateInput();
        Speaker s = (Speaker)(speakerList.getSelectedValue());
        idTextField.setEnabled(s!=null);
        nameTextField.setEnabled(s!=null);
        removeSpeakerButton.setEnabled(s!=null);
        if (s!=null){
            currentSpeaker = s;
            idTextField.setText(s.getIdentifier());
            nameTextField.setText(s.getName());
        }
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        speakerListScrollPane = new javax.swing.JScrollPane();
        speakerList = new javax.swing.JList();
        mainPanel = new javax.swing.JPanel();
        idPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        idTextField = new javax.swing.JTextField();
        namePanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        okCancelPanel = new javax.swing.JPanel();
        okButton = new javax.swing.JButton();
        buttonPanel = new javax.swing.JPanel();
        newSpeakerButton = new javax.swing.JButton();
        removeSpeakerButton = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        speakerListScrollPane.setPreferredSize(new java.awt.Dimension(150, 200));

        speakerList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        speakerList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        speakerListScrollPane.setViewportView(speakerList);

        add(speakerListScrollPane, java.awt.BorderLayout.WEST);

        mainPanel.setLayout(new javax.swing.BoxLayout(mainPanel, javax.swing.BoxLayout.Y_AXIS));

        idPanel.setLayout(new javax.swing.BoxLayout(idPanel, javax.swing.BoxLayout.LINE_AXIS));

        jLabel1.setText(" ID: ");
        jLabel1.setMaximumSize(new java.awt.Dimension(50, 14));
        jLabel1.setMinimumSize(new java.awt.Dimension(50, 14));
        jLabel1.setPreferredSize(new java.awt.Dimension(50, 14));
        idPanel.add(jLabel1);

        idTextField.setEnabled(false);
        idTextField.setMaximumSize(new java.awt.Dimension(2147483647, 19));
        idTextField.setPreferredSize(new java.awt.Dimension(100, 19));
        idTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idTextFieldActionPerformed(evt);
            }
        });
        idTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                idTextFieldKeyTyped(evt);
            }
        });
        idPanel.add(idTextField);

        mainPanel.add(idPanel);

        namePanel.setLayout(new javax.swing.BoxLayout(namePanel, javax.swing.BoxLayout.LINE_AXIS));

        jLabel2.setText(FOLKERInternationalizer.getString("dialog.speaker.name"));
        jLabel2.setMaximumSize(new java.awt.Dimension(50, 14));
        jLabel2.setMinimumSize(new java.awt.Dimension(50, 14));
        jLabel2.setPreferredSize(new java.awt.Dimension(50, 14));
        namePanel.add(jLabel2);

        nameTextField.setEnabled(false);
        nameTextField.setMaximumSize(new java.awt.Dimension(2147483647, 19));
        nameTextField.setPreferredSize(new java.awt.Dimension(200, 19));
        nameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextFieldActionPerformed(evt);
            }
        });
        namePanel.add(nameTextField);

        mainPanel.add(namePanel);

        add(mainPanel, java.awt.BorderLayout.CENTER);

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        okCancelPanel.add(okButton);

        add(okCancelPanel, java.awt.BorderLayout.SOUTH);

        newSpeakerButton.setText(FOLKERInternationalizer.getString("dialog.speaker.newspeaker"));
        newSpeakerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newSpeakerButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(newSpeakerButton);

        removeSpeakerButton.setText(FOLKERInternationalizer.getString("dialog.speaker.removespeaker"));
        removeSpeakerButton.setEnabled(false);
        removeSpeakerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeSpeakerButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(removeSpeakerButton);

        add(buttonPanel, java.awt.BorderLayout.NORTH);
    }// </editor-fold>//GEN-END:initComponents

    private void removeSpeakerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeSpeakerButtonActionPerformed
        validateInput();
        Speaker s = (Speaker)(speakerList.getSelectedValue());
        if (s==null) return;
        speakerListModel.removeSpeaker(s);
    }//GEN-LAST:event_removeSpeakerButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        validateInput();
        java.awt.Container c = this.getTopLevelAncestor();
        if (c instanceof JDialog){
            JDialog d = (JDialog)c;
            d.setVisible(false);
            d.dispose();
        }
    }//GEN-LAST:event_okButtonActionPerformed

    private void nameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextFieldActionPerformed
        validateInput();
    }//GEN-LAST:event_nameTextFieldActionPerformed

    private void idTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idTextFieldActionPerformed
        validateInput();
    }//GEN-LAST:event_idTextFieldActionPerformed

    private void newSpeakerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newSpeakerButtonActionPerformed
        speakerListModel.addSpeaker();   
        speakerList.setSelectedIndex(speakerListModel.getSize()-1);
    }//GEN-LAST:event_newSpeakerButtonActionPerformed

    private void idTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idTextFieldKeyTyped
        // this should restrict input to characters, number, the underscore or the dash
        char c = evt.getKeyChar();
        //System.out.println("Caret " + idTextField.getCaretPosition());
        if (!(Character.isLetterOrDigit(c) || c=='_' || c=='-')){
            evt.consume();
        } else if (idTextField.getSelectionStart()==0 && (!Character.isLetter(c))){
            // also make sure that the first letter is a character
            evt.consume();
        }

    }//GEN-LAST:event_idTextFieldKeyTyped
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JPanel idPanel;
    private javax.swing.JTextField idTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel namePanel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JButton newSpeakerButton;
    private javax.swing.JButton okButton;
    private javax.swing.JPanel okCancelPanel;
    private javax.swing.JButton removeSpeakerButton;
    private javax.swing.JList speakerList;
    private javax.swing.JScrollPane speakerListScrollPane;
    // End of variables declaration//GEN-END:variables
    
}
