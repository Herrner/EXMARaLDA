/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ProgressBarDialog.java
 *
 * Created on 07.10.2009, 16:14:47
 */

package org.exmaralda.common.dialogs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.exmaralda.exakt.search.SearchEvent;
import org.exmaralda.folker.utilities.TimeStringFormatter;

/**
 *
 * @author thomas
 */
public class ProgressBarDialog extends javax.swing.JDialog implements org.exmaralda.exakt.search.SearchListenerInterface,
                                                                      org.exmaralda.folker.matchlist.MatchListListener {

    javax.swing.Timer timer;
    private int currentProgress;
    private String progressString;
    boolean estimateTime = false;
    long startTime;

    /** Creates new form ProgressBarDialog */
    public ProgressBarDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        estimatePanel.setVisible(false);
        pack();
        timer = new javax.swing.Timer(100, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                progressBar.setValue(currentProgress);
                progressBar.setString(progressString);
            }
        });
        timer.start();
    }
    
    public void enableTimeEstimate(boolean enable){
        estimateTime = enable;
        estimatePanel.setVisible(enable);        
        pack();
        if (enable){
            startTime = System.currentTimeMillis();
        }
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
        progressBar = new javax.swing.JProgressBar();
        estimatePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        elapsedTimeLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        remainingTimeLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));

        progressBar.setMaximumSize(new java.awt.Dimension(400, 19));
        progressBar.setPreferredSize(new java.awt.Dimension(400, 19));
        progressBar.setStringPainted(true);
        jPanel1.add(progressBar);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jLabel1.setText("Elapsed time: ");
        estimatePanel.add(jLabel1);

        elapsedTimeLabel.setForeground(java.awt.Color.blue);
        elapsedTimeLabel.setText("jLabel2");
        estimatePanel.add(elapsedTimeLabel);

        jLabel2.setText("Estimated remaining time: ");
        estimatePanel.add(jLabel2);

        remainingTimeLabel.setForeground(java.awt.Color.blue);
        remainingTimeLabel.setText("jLabel3");
        estimatePanel.add(remainingTimeLabel);

        getContentPane().add(estimatePanel, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ProgressBarDialog dialog = new ProgressBarDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel elapsedTimeLabel;
    private javax.swing.JPanel estimatePanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JProgressBar progressBar;
    private javax.swing.JLabel remainingTimeLabel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void processSearchEvent(SearchEvent se) {        
        progressString = (String)(se.getData());
        progressString = progressString.substring(Math.max(0,progressString.length()-40));
        currentProgress = (int)Math.round(se.getProgress()*100);
        if (estimateTime){
            updateTimeEstimate();
        }
         if (currentProgress>99){
            this.setVisible(false);
        } 
    }

    private void updateTimeEstimate() {
        long currentTime = System.currentTimeMillis();
        long elapsedTime = currentTime - startTime;
        String elT = TimeStringFormatter.formatMiliseconds(elapsedTime, 2);
        String reT = "???";
        if (currentProgress>0){
            long remainingTime = (100 - currentProgress) * (elapsedTime / currentProgress);
            reT = TimeStringFormatter.formatMiliseconds(remainingTime, 2);
        }
        elapsedTimeLabel.setText(elT);
        remainingTimeLabel.setText(reT);
        
    }

    @Override
    public void processMatchListEvent(String description, double progress) {
        progressString = description;
        currentProgress = (int)Math.round(progress*100);
    }

}
