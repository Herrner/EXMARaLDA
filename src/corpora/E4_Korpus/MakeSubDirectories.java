/*
 * MakeSubDirectories.java
 *
 * Created on 21. November 2006, 15:44
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package corpora.E4_Korpus;

import org.exmaralda.partitureditor.jexmaralda.BasicTranscription;
import java.io.*;
import org.exmaralda.partitureditor.jexmaralda.SegmentedTranscription;

/**
 *
 * @author thomas
 */
public class MakeSubDirectories extends AbstractCorpusProcessor {
    
    /** Creates a new instance of MakeSubDirectories */
    public MakeSubDirectories() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       MakeSubDirectories msd = new MakeSubDirectories();
        try {
            msd.doIt(false);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void processTranscription(BasicTranscription bt) {
        File f = new File(this.currentFilename);
        new File(f.getParentFile(), "export").mkdir();
        new File(f.getParentFile(), "presentation").mkdir();
    }

    @Override
    public void processTranscription(SegmentedTranscription st) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
