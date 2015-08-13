/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package corpora.H6_Korpus;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;

/**
 *
 * @author thomas
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       new Test().doit();
    }
    
    public void doit(){
        try {
            TextGridParser tgd = new TextGridParser();
            tgd.readTextGrid(new java.io.File("T:\\TP-Z2\\DATEN\\H6\\02_vtr_Sus.TextGrid"), "UTF-8");
            Vector<AcousticAnalysisDataSet> result = tgd.parse();
            for (AcousticAnalysisDataSet aads : result){
                System.out.println(aads.baseForm + " *** " + aads.occurenceCount + " *** " + aads.transcription1 + " *** " + aads.transcription2);
            }
            org.jdom.Document d = tgd.fillTargetWordList();
            org.exmaralda.common.jdomutilities.IOUtilities.writeDocumentToLocalFile("T:\\TP-Z2\\DATEN\\H6\\02_vtr_Sus.xml", d);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
