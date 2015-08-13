/*
 * WordWiseReversedSortAction.java
 *
 * Created on 19. Februar 2007, 13:45
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.exmaralda.exakt.exmaraldaSearch.KWICTableActions;

import java.awt.event.ActionEvent;
import org.exmaralda.exakt.exmaraldaSearch.swing.COMAKWICTable;

/**
 *
 * @author thomas
 */
public class MoreContextAction extends AbstractKWICTableAction {
    
    /** Creates a new instance of WordWiseReversedSortAction */
    public MoreContextAction(COMAKWICTable t, String title) {
        super(t,title);
    }

    public void actionPerformed(ActionEvent e) {
        int newContextSize = table.getWrappedModel().getMaxContextSize()+3;
        table.getWrappedModel().setMaxContextSize(newContextSize);
        table.setCellEditors();
    }
    
}
