/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AddSpeakersDialog.java
 *
 * Created on 24.08.2010, 10:32:33
 */

package org.exmaralda.common.corpusbuild.comafunctions;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.exmaralda.coma.root.Coma;
import org.exmaralda.coma.root.Ui;
import org.exmaralda.partitureditor.jexmaraldaswing.fileFilters.ParameterFileFilter;
import org.jdom.JDOMException;

/**
 * 
 * @author thomas
 */
public class AddSpeakersDialog extends javax.swing.JDialog {

	DefaultListModel listModel;
	Coma coma;
	SpeakersChecker checker;
	/** Creates new form AddSpeakersDialog */
	public AddSpeakersDialog(java.awt.Frame parent, boolean modal,
			SpeakersChecker ch, Coma c) {
		super(parent, modal);
		coma = c;
		checker = ch;
		initComponents();
		listModel = new DefaultListModel();
		for (String sigle : checker.undefinedSpeakersSigles) {
			listModel.addElement(sigle);
		}
		sigleList.setModel(listModel);
		String text = Integer.toString(listModel.size())
				+ Ui.getText("result.nrUndefinedSpeakersFound");
		messageLabel.setText(text);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed"
	// desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jScrollPane1 = new javax.swing.JScrollPane();
		sigleList = new javax.swing.JList();
		jPanel1 = new javax.swing.JPanel();
		removeButton = new javax.swing.JButton();
		jPanel2 = new javax.swing.JPanel();
		addInComaButton = new javax.swing.JButton();
		saveErrorListButton = new javax.swing.JButton();
		closeButton = new javax.swing.JButton();
		jPanel3 = new javax.swing.JPanel();
		messageLabel = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
//		setTitle("Speaker check result");

		sigleList.setModel(new javax.swing.AbstractListModel() {
			String[] strings = {"Item 1", "Item 2", "Item 3", "Item 4",
					"Item 5"};
			public int getSize() {
				return strings.length;
			}
			public Object getElementAt(int i) {
				return strings[i];
			}
		});
		jScrollPane1.setViewportView(sigleList);

		getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

		removeButton
				.setIcon(new javax.swing.ImageIcon(
						getClass()
								.getResource(
										"/org/exmaralda/folker/tangoicons/tango-icon-theme-0.8.1/22x22/actions/list-remove.png"))); // NOI18N
		removeButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				removeButtonActionPerformed(evt);
			}
		});
		jPanel1.add(removeButton);

		getContentPane().add(jPanel1, java.awt.BorderLayout.EAST);

		addInComaButton.setText(Ui.getText("cmd.addInComa"));
		addInComaButton.setEnabled(false);
		addInComaButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				addInComaButtonActionPerformed(evt);
			}
		});
		jPanel2.add(addInComaButton);

		saveErrorListButton.setText(Ui.getText("prompt.saveErrorList") + "...");
		saveErrorListButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						saveErrorListButtonActionPerformed(evt);
					}
				});
		jPanel2.add(saveErrorListButton);

		closeButton.setText(Ui.getText("cancel"));
		closeButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				closeButtonActionPerformed(evt);
			}
		});
		jPanel2.add(closeButton);

		getContentPane().add(jPanel2, java.awt.BorderLayout.SOUTH);

		messageLabel.setText("jLabel1");
		jPanel3.add(messageLabel);

		getContentPane().add(jPanel3, java.awt.BorderLayout.PAGE_START);

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void saveErrorListButtonActionPerformed(
			java.awt.event.ActionEvent evt) {// GEN-FIRST:event_saveErrorListButtonActionPerformed
		JFileChooser fc = new JFileChooser();
		fc.setCurrentDirectory(coma.getData().getOpenFile());
		fc.setFileFilter(new ParameterFileFilter("xml", "XML files"));
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		boolean goon = false;
		while (!goon) {
			int ret = fc.showSaveDialog(coma);
			if (ret == JFileChooser.APPROVE_OPTION) {
				try {
					String filename = fc.getSelectedFile().getAbsolutePath();
					if (fc.getSelectedFile().getName().indexOf(".") < 0) {
						filename += ".xml";
					}
					if (new File(filename).exists()) {
						int ret2 = JOptionPane.showConfirmDialog(coma, filename
								+ "\n" + Ui.getText("msg.overwriteWarning"),
								"", JOptionPane.YES_NO_OPTION);

						if (ret2 == JOptionPane.NO_OPTION)
							continue;
					}
					System.out.println("Writing error list to " + filename);
					// org.exmaralda.common.jdomutilities.IOUtilities.writeDocumentToLocalFile(fc.getSelectedFile().getAbsolutePath(),
					// checker.getErrorsDocoument());
					checker.output(filename);
					goon = true;
				} catch (JDOMException ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(coma,
							ex.getLocalizedMessage());
				} catch (URISyntaxException ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(coma,
							ex.getLocalizedMessage());
				} catch (IOException ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(coma,
							ex.getLocalizedMessage());
				}
			} else {
				goon = true;
			}
		}
	}// GEN-LAST:event_saveErrorListButtonActionPerformed

	private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_removeButtonActionPerformed
		listModel.remove(sigleList.getSelectedIndex());
	}// GEN-LAST:event_removeButtonActionPerformed

	private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_closeButtonActionPerformed
		this.dispose();
	}// GEN-LAST:event_closeButtonActionPerformed

	private void addInComaButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_addInComaButtonActionPerformed
		// TODO add your handling code here:
		String[] sigles = new String[listModel.size()];
		listModel.copyInto(sigles);
		// this here function is yet to be written by the COMA man
		// coma.addSpeaker(sigles);
	}// GEN-LAST:event_addInComaButtonActionPerformed

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				AddSpeakersDialog dialog = new AddSpeakersDialog(
						new javax.swing.JFrame(), true, null, null);
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
	private javax.swing.JButton addInComaButton;
	private javax.swing.JButton closeButton;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JLabel messageLabel;
	private javax.swing.JButton removeButton;
	private javax.swing.JButton saveErrorListButton;
	private javax.swing.JList sigleList;
	// End of variables declaration//GEN-END:variables

}
