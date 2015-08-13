/*
 * SBCSAEEditor.java
 *
 * Created on 29. Juli 2008, 10:48
 */

package org.exmaralda.sbcsae.editor;

import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ListSelectionEvent;
import javax.swing.text.BadLocationException;
import org.jdom.JDOMException;
import quicktime.QTException;

/**
 *
 * @author  thomas
 */
public class SBCSAEEditor extends javax.swing.JFrame 
        implements javax.swing.event.ListSelectionListener,java.awt.event.MouseListener,
                    org.exmaralda.common.ExmaraldaApplication {

    java.io.File workingDirectory = null;
    java.io.File audioDirectory = null;
    
    org.exmaralda.sbcsae.convertStep1.TRN2XML transcriptionReader = new org.exmaralda.sbcsae.convertStep1.TRN2XML();
    SBCSAETranscriptionTableModel tableModel;
    org.exmaralda.partitureditor.sound.Playable player;
    ErrorsListModel listModel;
    
    int currentTranscriptionNumber;
    
    /** Creates new form SBCSAEEditor */
    public SBCSAEEditor() {
        initComponents();
        
        org.exmaralda.common.Logger.initialiseLogger(this);
        
        transcriptionTable.getSelectionModel().addListSelectionListener(this);
        errorsList.addMouseListener(this);
                
        String wd = java.util.prefs.Preferences.userRoot().node("org.exmaralda.sbcsae").get("WORKING-DIRECTORY", null);        
        if (wd!=null){
            workingDirectoryLabel.setText(wd.substring(Math.max(0, wd.length()-30)));        
            workingDirectory = new java.io.File(wd);
        }
        String ad = java.util.prefs.Preferences.userRoot().node("org.exmaralda.sbcsae").get("AUDIO-DIRECTORY", null);        
        if (ad!=null){
            audioDirectoryLabel.setText(ad.substring(Math.max(0, ad.length()-30)));        
            audioDirectory = new java.io.File(ad);
        }
        
        String message = "Working directory is not set.";
        if (workingDirectory!=null){
                message = "Working directory is: " + workingDirectory.getAbsolutePath();
        }
        javax.swing.JOptionPane.showMessageDialog(this, message);
        
        
        if (System.getProperty("os.name").toUpperCase().startsWith("MAC")){
            try {
                player = new org.exmaralda.partitureditor.sound.QuicktimePlayer();
            } catch (QTException ex) {
                ex.printStackTrace();
                player = new org.exmaralda.partitureditor.sound.JMFPlayer();
            } catch (UnsatisfiedLinkError ex) {
                player = new org.exmaralda.partitureditor.sound.JMFPlayer();
                ex.printStackTrace();
            }
        } else {
            player = new org.exmaralda.partitureditor.sound.JMFPlayer();
        }
    }

    private void checkSave() {
        int ret = javax.swing.JOptionPane.showConfirmDialog(this, "Transcription has been modified. Save?", "Save changes", javax.swing.JOptionPane.YES_NO_OPTION);
        if (ret!=javax.swing.JOptionPane.YES_OPTION) return;
        saveTranscription();
    }

    private void displayError(Exception ex) {
        javax.swing.JOptionPane.showMessageDialog(this, ex.getMessage());
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        transcriptionPanel = new javax.swing.JPanel();
        transcriptionTableScrollPane = new javax.swing.JScrollPane();
        transcriptionTable = new javax.swing.JTable();
        transcriptionButtonPanel = new javax.swing.JPanel();
        textButton = new javax.swing.JButton();
        removeIUButton = new javax.swing.JButton();
        controlsPanel = new javax.swing.JPanel();
        workingDirectoryPanel = new javax.swing.JPanel();
        workingDirectoryLabel = new javax.swing.JLabel();
        changeWorkingDirectoryButton = new javax.swing.JButton();
        audioDirectoryPanel = new javax.swing.JPanel();
        audioDirectoryLabel = new javax.swing.JLabel();
        changeAudioDirectoryButton = new javax.swing.JButton();
        openTranscriptionPanel = new javax.swing.JPanel();
        transcriptionSpinner = new javax.swing.JSpinner();
        openTranscriptionButton = new javax.swing.JButton();
        saveTranscriptionButton = new javax.swing.JButton();
        playerPanel = new javax.swing.JPanel();
        playButton = new javax.swing.JButton();
        errorsPanel = new javax.swing.JPanel();
        errorsListScrollPane = new javax.swing.JScrollPane();
        errorsList = new javax.swing.JList();
        openErrorListButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        errorCountLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SBCSAE Transcription Surfer");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        transcriptionPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        transcriptionPanel.setLayout(new java.awt.BorderLayout());

        transcriptionTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "", "", ""
            }
        ));
        transcriptionTableScrollPane.setViewportView(transcriptionTable);

        transcriptionPanel.add(transcriptionTableScrollPane, java.awt.BorderLayout.CENTER);

        transcriptionButtonPanel.setLayout(new javax.swing.BoxLayout(transcriptionButtonPanel, javax.swing.BoxLayout.Y_AXIS));

        textButton.setText("Text...");
        textButton.setEnabled(false);
        textButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textButtonActionPerformed(evt);
            }
        });
        transcriptionButtonPanel.add(textButton);

        removeIUButton.setText("Remove");
        removeIUButton.setEnabled(false);
        removeIUButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeIUButtonActionPerformed(evt);
            }
        });
        transcriptionButtonPanel.add(removeIUButton);

        transcriptionPanel.add(transcriptionButtonPanel, java.awt.BorderLayout.EAST);

        getContentPane().add(transcriptionPanel, java.awt.BorderLayout.CENTER);

        workingDirectoryPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Working directory"));
        workingDirectoryPanel.setLayout(new javax.swing.BoxLayout(workingDirectoryPanel, javax.swing.BoxLayout.LINE_AXIS));

        workingDirectoryLabel.setText("NOT SET");
        workingDirectoryLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 20));
        workingDirectoryPanel.add(workingDirectoryLabel);

        changeWorkingDirectoryButton.setText("Change...");
        changeWorkingDirectoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeWorkingDirectoryButtonActionPerformed(evt);
            }
        });
        workingDirectoryPanel.add(changeWorkingDirectoryButton);

        controlsPanel.add(workingDirectoryPanel);

        audioDirectoryPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Audio directory"));
        audioDirectoryPanel.setLayout(new javax.swing.BoxLayout(audioDirectoryPanel, javax.swing.BoxLayout.LINE_AXIS));

        audioDirectoryLabel.setText("NOT SET");
        audioDirectoryLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 20));
        audioDirectoryPanel.add(audioDirectoryLabel);

        changeAudioDirectoryButton.setText("Change...");
        changeAudioDirectoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeAudioDirectoryButtonActionPerformed(evt);
            }
        });
        audioDirectoryPanel.add(changeAudioDirectoryButton);

        controlsPanel.add(audioDirectoryPanel);

        openTranscriptionPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Transcription"));
        openTranscriptionPanel.setLayout(new javax.swing.BoxLayout(openTranscriptionPanel, javax.swing.BoxLayout.LINE_AXIS));

        transcriptionSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, 60, 1));
        openTranscriptionPanel.add(transcriptionSpinner);

        openTranscriptionButton.setText("Open");
        openTranscriptionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openTranscriptionButtonActionPerformed(evt);
            }
        });
        openTranscriptionPanel.add(openTranscriptionButton);

        saveTranscriptionButton.setText("Save");
        saveTranscriptionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveTranscriptionButtonActionPerformed(evt);
            }
        });
        openTranscriptionPanel.add(saveTranscriptionButton);

        controlsPanel.add(openTranscriptionPanel);

        playerPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Audio player"));
        playerPanel.setLayout(new javax.swing.BoxLayout(playerPanel, javax.swing.BoxLayout.LINE_AXIS));

        playButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/exmaralda/partitureditor/sound/Start.gif"))); // NOI18N
        playButton.setEnabled(false);
        playButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playButtonActionPerformed(evt);
            }
        });
        playerPanel.add(playButton);

        controlsPanel.add(playerPanel);

        getContentPane().add(controlsPanel, java.awt.BorderLayout.PAGE_START);

        errorsPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        errorsPanel.setLayout(new java.awt.BorderLayout());

        errorsListScrollPane.setMinimumSize(new java.awt.Dimension(250, 23));
        errorsListScrollPane.setPreferredSize(new java.awt.Dimension(250, 130));

        errorsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        errorsListScrollPane.setViewportView(errorsList);

        errorsPanel.add(errorsListScrollPane, java.awt.BorderLayout.CENTER);

        openErrorListButton.setText("Open errors list...");
        openErrorListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openErrorListButtonActionPerformed(evt);
            }
        });
        errorsPanel.add(openErrorListButton, java.awt.BorderLayout.PAGE_START);

        jPanel1.add(errorCountLabel);

        errorsPanel.add(jPanel1, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(errorsPanel, java.awt.BorderLayout.EAST);

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void changeWorkingDirectoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeWorkingDirectoryButtonActionPerformed
        javax.swing.JFileChooser fc = new javax.swing.JFileChooser(workingDirectory);
        fc.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);
        fc.setDialogTitle("Choose working directory containing the transcriptions");
        int ret = fc.showOpenDialog(this);
        if (ret!=javax.swing.JFileChooser.APPROVE_OPTION) return;
        workingDirectory = fc.getSelectedFile();
        String path = workingDirectory.getAbsolutePath();
        workingDirectoryLabel.setText(path.substring(Math.max(0, path.length()-30)));
        java.util.prefs.Preferences.userRoot().node("org.exmaralda.sbcsae").put("WORKING-DIRECTORY", workingDirectory.getAbsolutePath());
}//GEN-LAST:event_changeWorkingDirectoryButtonActionPerformed

private void changeAudioDirectoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeAudioDirectoryButtonActionPerformed
        javax.swing.JFileChooser fc = new javax.swing.JFileChooser(audioDirectory);
        fc.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);
        fc.setDialogTitle("Choose directory containing the audio files");
        int ret = fc.showOpenDialog(this);
        if (ret!=javax.swing.JFileChooser.APPROVE_OPTION) return;
        audioDirectory = fc.getSelectedFile();
        String path = audioDirectory.getAbsolutePath();
        audioDirectoryLabel.setText(path.substring(Math.max(0, path.length()-30)));
        java.util.prefs.Preferences.userRoot().node("org.exmaralda.sbcsae").put("AUDIO-DIRECTORY", audioDirectory.getAbsolutePath());

}//GEN-LAST:event_changeAudioDirectoryButtonActionPerformed

private void openTranscriptionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openTranscriptionButtonActionPerformed
        int transcriptionNumber = ((Integer) (transcriptionSpinner.getValue())).intValue();
        openTranscription(transcriptionNumber);//GEN-LAST:event_openTranscriptionButtonActionPerformed
}

private void playButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playButtonActionPerformed
        player.startPlayback();
}//GEN-LAST:event_playButtonActionPerformed

private void openErrorListButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openErrorListButtonActionPerformed
        try {
            javax.swing.JFileChooser fc = new javax.swing.JFileChooser(workingDirectory);
            int ret = fc.showOpenDialog(this);
            if (ret!=javax.swing.JFileChooser.APPROVE_OPTION) return;
            org.jdom.Document ed = org.exmaralda.exakt.utilities.FileIO.readDocumentFromLocalFile(fc.getSelectedFile());
            listModel = new ErrorsListModel(ed);
            errorsList.setModel(listModel);
            errorCountLabel.setText(Integer.toString(listModel.getSize()) + " errors.");
            errorsList.setCellRenderer(new ErrorListCellRenderer());//GEN-LAST:event_openErrorListButtonActionPerformed
        } catch (JDOMException ex) {
            Logger.getLogger(SBCSAEEditor.class.getName()).log(Level.SEVERE, null, ex);
            displayError(ex);
        } catch (IOException ex) {
            Logger.getLogger(SBCSAEEditor.class.getName()).log(Level.SEVERE, null, ex);
            displayError(ex);
        }
}

private void saveTranscriptionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveTranscriptionButtonActionPerformed
            saveTranscription();
}//GEN-LAST:event_saveTranscriptionButtonActionPerformed

private void removeIUButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeIUButtonActionPerformed
    int selectedRow = transcriptionTable.getSelectedRow();
    if (selectedRow<0) return;
    int ret = javax.swing.JOptionPane.showConfirmDialog(this, "Are you sure you want to remove this IU?");
    if (ret!=javax.swing.JOptionPane.OK_OPTION) return;
    tableModel.remove(selectedRow);
    removeIUButton.setEnabled(false);
}//GEN-LAST:event_removeIUButtonActionPerformed

private void textButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textButtonActionPerformed
        try {
            javax.swing.JTextArea textArea = new javax.swing.JTextArea(transcriptionReader.writeTRN(tableModel.getTranscription()));
            javax.swing.JScrollPane scrollPane = new javax.swing.JScrollPane(textArea);
            javax.swing.JDialog dialog = new javax.swing.JDialog(this, true);//GEN-LAST:event_textButtonActionPerformed
            dialog.getContentPane().setLayout(new java.awt.BorderLayout());
            dialog.getContentPane().add(scrollPane, java.awt.BorderLayout.CENTER);
                        
            dialog.setPreferredSize(transcriptionTable.getVisibleRect().getSize());
            dialog.setTitle("Transcript " + currentTranscriptionNumber);
            dialog.setLocationRelativeTo(this);
            
            
            textArea.setLineWrap(false);            
            
            int selectedRow = transcriptionTable.getSelectedRow();
            if (selectedRow>=0){
                try {
                    textArea.setCaretPosition(textArea.getLineStartOffset(selectedRow));
                    textArea.setSelectionStart(textArea.getLineStartOffset(selectedRow));
                    textArea.setSelectionEnd(textArea.getLineEndOffset(selectedRow));
                } catch (BadLocationException ex) {
                    Logger.getLogger(SBCSAEEditor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                    
            dialog.pack();
            dialog.setVisible(true);
            
            String modifiedText = textArea.getText();            
            org.jdom.Document modifiedDocument  = transcriptionReader.readTRN(modifiedText);
            
            tableModel = new SBCSAETranscriptionTableModel(modifiedDocument);
            transcriptionTable.setModel(tableModel);
            formatTable();

            
            try {
                 final int selectedRow2 = textArea.getLineOfOffset(textArea.getCaretPosition());
                 javax.swing.SwingUtilities.invokeLater(new Runnable(){

                    public void run() {
                        transcriptionTable.getSelectionModel().setSelectionInterval(selectedRow2, selectedRow2);
                        java.awt.Rectangle rect = transcriptionTable.getCellRect(selectedRow2, 0, true);
                        transcriptionTable.scrollRectToVisible(rect);
                        //System.out.println("selected maybe " + line);
                    }
                 });
                
            } catch (BadLocationException ex) {
                Logger.getLogger(SBCSAEEditor.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(SBCSAEEditor.class.getName()).log(Level.SEVERE, null, ex);
            this.displayError(ex);
        } catch (JDOMException ex) {
            Logger.getLogger(SBCSAEEditor.class.getName()).log(Level.SEVERE, null, ex);
            this.displayError(ex);
        }
}

private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
// TODO add your handling code here:
}//GEN-LAST:event_formWindowClosed

private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if ((tableModel!=null) && (tableModel.modified)){
            checkSave();
        }
}//GEN-LAST:event_formWindowClosing

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SBCSAEEditor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(SBCSAEEditor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(SBCSAEEditor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(SBCSAEEditor.class.getName()).log(Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SBCSAEEditor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel audioDirectoryLabel;
    private javax.swing.JPanel audioDirectoryPanel;
    private javax.swing.JButton changeAudioDirectoryButton;
    private javax.swing.JButton changeWorkingDirectoryButton;
    private javax.swing.JPanel controlsPanel;
    private javax.swing.JLabel errorCountLabel;
    private javax.swing.JList errorsList;
    private javax.swing.JScrollPane errorsListScrollPane;
    private javax.swing.JPanel errorsPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton openErrorListButton;
    private javax.swing.JButton openTranscriptionButton;
    private javax.swing.JPanel openTranscriptionPanel;
    private javax.swing.JButton playButton;
    private javax.swing.JPanel playerPanel;
    private javax.swing.JButton removeIUButton;
    private javax.swing.JButton saveTranscriptionButton;
    private javax.swing.JButton textButton;
    private javax.swing.JPanel transcriptionButtonPanel;
    private javax.swing.JPanel transcriptionPanel;
    private javax.swing.JSpinner transcriptionSpinner;
    private javax.swing.JTable transcriptionTable;
    private javax.swing.JScrollPane transcriptionTableScrollPane;
    private javax.swing.JLabel workingDirectoryLabel;
    private javax.swing.JPanel workingDirectoryPanel;
    // End of variables declaration//GEN-END:variables

    public void valueChanged(ListSelectionEvent e) {
        int selectedRow = transcriptionTable.getSelectedRow();
        if (selectedRow<0) {
            playButton.setEnabled(false);
            return;
        }
        double start = tableModel.getStartTime(selectedRow);
        int lastSelectedRow = transcriptionTable.getSelectedRows()[transcriptionTable.getSelectedRows().length-1];
        double end = tableModel.getEndTime(lastSelectedRow);
        player.setStartTime(start);
        player.setEndTime(end);
        playButton.setEnabled(true);
        if (selectedRow==lastSelectedRow){
            removeIUButton.setEnabled(true);            
        }
    }
    
    void formatTable(){
        transcriptionTable.setFont(getFont().deriveFont(13.0f));        
        
        javax.swing.table.TableColumnModel cmodel = transcriptionTable.getColumnModel();                

        cmodel.getColumn(0).setPreferredWidth(100);
        cmodel.getColumn(1).setPreferredWidth(200);
        cmodel.getColumn(2).setPreferredWidth(200);
        cmodel.getColumn(3).setPreferredWidth(200);
        cmodel.getColumn(4).setPreferredWidth(2000);
        
        cmodel.getColumn(0).setHeaderValue("Count");
        cmodel.getColumn(1).setHeaderValue("Start");
        cmodel.getColumn(2).setHeaderValue("End");
        cmodel.getColumn(3).setHeaderValue("Speaker");
        cmodel.getColumn(4).setHeaderValue("Transcription");        
        
        javax.swing.table.DefaultTableCellRenderer dtcr0 = new javax.swing.table.DefaultTableCellRenderer();
        dtcr0.setForeground(java.awt.Color.BLACK);
        dtcr0.setBackground(java.awt.Color.LIGHT_GRAY); 
        cmodel.getColumn(0).setCellRenderer(dtcr0);

        javax.swing.table.DefaultTableCellRenderer dtcr1 = new javax.swing.table.DefaultTableCellRenderer();
        dtcr1.setForeground(java.awt.Color.BLUE);
        cmodel.getColumn(1).setCellRenderer(dtcr1);
        cmodel.getColumn(2).setCellRenderer(dtcr1);
    
        javax.swing.table.DefaultTableCellRenderer dtcr2 = new javax.swing.table.DefaultTableCellRenderer();
        dtcr2.setFont(dtcr2.getFont().deriveFont(java.awt.Font.BOLD));
        dtcr2.setForeground(java.awt.Color.WHITE);        
        dtcr2.setBackground(java.awt.Color.GRAY);        
        cmodel.getColumn(3).setCellRenderer(dtcr2);
    
    }

    public void mouseClicked(MouseEvent e) {
        if(e.getClickCount() == 2){
             Object item = errorsList.getSelectedValue();
             System.out.println("Double clicked on " + item);
             org.jdom.Element error = (org.jdom.Element)item;
             error.setAttribute("done", "yes");
             int transcriptionNumber = Integer.parseInt(error.getAttributeValue("transcription"));
             final int line = Integer.parseInt(error.getAttributeValue("iu_no"));
             
             openTranscription(transcriptionNumber);
             
             javax.swing.SwingUtilities.invokeLater(new Runnable(){

                public void run() {
                    transcriptionTable.getSelectionModel().setSelectionInterval(line-1, line-1);
                    java.awt.Rectangle rect = transcriptionTable.getCellRect(line-1, 0, true);
                    transcriptionTable.scrollRectToVisible(rect);
                    //System.out.println("selected maybe " + line);
                }
                 
             });
             
         }        
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }
    
    String makeTranscriptionName(int transcriptionNumber){
        String filename = workingDirectory.getAbsolutePath();
        filename += System.getProperty("file.separator");
        filename += "SBC0";
        if (transcriptionNumber < 10) {
            filename += "0";
        }
        filename += Integer.toString(transcriptionNumber);
        filename += ".TRN";
        return filename;
        
    }
    
    void openTranscription(int transcriptionNumber){
        try {
            if ((tableModel!=null) && (tableModel.modified)){
                checkSave();
            }
            String filename = makeTranscriptionName(transcriptionNumber);
            System.out.println("Opening " + filename);
            org.jdom.Document d = transcriptionReader.readTRN(new java.io.File(filename));
            tableModel = new SBCSAETranscriptionTableModel(d);
            transcriptionTable.setModel(tableModel);
            formatTable();

            String audioname = audioDirectory.getAbsolutePath();
            audioname += System.getProperty("file.separator");
            audioname+="SBC0";
            if (transcriptionNumber < 10) {
                audioname += "0";
            }
            audioname += Integer.toString(transcriptionNumber);
            audioname += ".wav";
            player.setSoundFile(audioname);
            
            transcriptionSpinner.setValue(new Integer(transcriptionNumber));
            currentTranscriptionNumber = transcriptionNumber;
            
            textButton.setEnabled(true);
            
        } catch (JDOMException ex) {
            Logger.getLogger(SBCSAEEditor.class.getName()).log(Level.SEVERE, null, ex);
            displayError(ex);            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SBCSAEEditor.class.getName()).log(Level.SEVERE, null, ex);
            displayError(ex);            
        } catch (IOException ex) {
            Logger.getLogger(SBCSAEEditor.class.getName()).log(Level.SEVERE, null, ex);
            displayError(ex);            
        }
        
    }
    
    void saveTranscription(){
        {
            java.io.FileOutputStream fos = null;
            try {
                String filename = makeTranscriptionName(currentTranscriptionNumber);
                System.out.println("Saving " + filename);
                String textTranscription = transcriptionReader.writeTRN(tableModel.getTranscription());
                System.out.println("started writing document...");
                fos = new java.io.FileOutputStream(new java.io.File(filename));
                fos.write(textTranscription.getBytes("UTF-8"));
                fos.close();
                System.out.println("document written.");
            } catch (IOException ex) {
                Logger.getLogger(SBCSAEEditor.class.getName()).log(Level.SEVERE, null, ex);
                displayError(ex);                
            } catch (JDOMException ex) {
                Logger.getLogger(SBCSAEEditor.class.getName()).log(Level.SEVERE, null, ex);
                displayError(ex);
            }

        }
            
            
        
    }

    public String getVersion() {
        return org.exmaralda.common.EXMARaLDAConstants.SURFER_VERSION;
    }

    public String getApplicationName() {
        return "SBCSAE Transcription Surfer";
    }

    public String getPreferencesNode() {
        return "org.exmaralda.sbcsae";
    }

    public ImageIcon getWelcomeScreen() {
        return null;
    }

}
