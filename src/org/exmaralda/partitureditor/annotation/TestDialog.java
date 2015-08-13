/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TestDialog.java
 *
 * Created on 14.10.2009, 16:29:08
 */

package org.exmaralda.partitureditor.annotation;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import org.jdom.JDOMException;

/**
 *
 * @author thomas
 */
public class TestDialog extends javax.swing.JDialog implements MouseListener {

    /** Creates new form TestDialog */
    public TestDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        try {
            AnnotationSpecification as = new AnnotationSpecification();
            as.read(new File("C:\\Dokumente und Einstellungen\\thomas\\Desktop\\ANNOTATION\\annotation-specification-hu.xml"));
            Category c = as.getAnnotationSet("ADVsynt");
            AnnotationSetTreeModel astm = new AnnotationSetTreeModel(c, true);
            jTree1.setModel(astm);
            jTree1.setCellRenderer(new CategoryTreeCellRenderer());
            jTree1.addMouseListener(this);
        } catch (JDOMException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jScrollPane1.setViewportView(jTree1);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TestDialog dialog = new TestDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTree jTree1;
    // End of variables declaration//GEN-END:variables

    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount()==2){
            Category c = (Category)jTree1.getLastSelectedPathComponent();
            if (c.getTag()!=null){
                System.out.println("SELECTED: " + c.getTag());
            }
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

}
