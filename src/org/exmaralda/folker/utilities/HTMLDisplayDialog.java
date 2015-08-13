/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * HTMLDisplayDialog.java
 *
 * Created on 20.05.2009, 11:36:53
 */

package org.exmaralda.folker.utilities;

import java.io.IOException;
import org.exmaralda.common.jdomutilities.IOUtilities;
import org.jdom.Document;
import org.jdom.JDOMException;

/**
 *
 * @author thomas
 */
public class HTMLDisplayDialog extends javax.swing.JDialog {

    /** Creates new form HTMLDisplayDialog */
    public HTMLDisplayDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        editorPane.setContentType("text/html");
        editorPane.setEditorKit(new javax.swing.text.html.HTMLEditorKit());
    }

    public void loadInternalResource(String path) throws JDOMException, IOException{
        Document doc = new IOUtilities().readDocumentFromResource(path);
        String docString = IOUtilities.documentToString(doc, true);
        editorPane.setText(docString);
        editorPane.setCaretPosition(0);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        editorPane = new javax.swing.JEditorPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        editorPane.setEditable(false);
        jScrollPane1.setViewportView(editorPane);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                HTMLDisplayDialog dialog = new HTMLDisplayDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JEditorPane editorPane;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
