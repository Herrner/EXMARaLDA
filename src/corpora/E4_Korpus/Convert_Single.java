/*
 * Convert_Single.java
 *
 * Created on 6. M�rz 2008, 12:41
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package corpora.E4_Korpus;

import java.io.IOException;
import org.exmaralda.partitureditor.jexmaralda.*;
import org.jdom.*;
import java.io.*;
import org.jdom.transform.XSLTransformException;

/**
 *
 * @author thomas
 */
public class Convert_Single {
    
    static String FILENAME = "T:\\TP-Z2\\DATEN\\E4\\AB_04092006_18_04.txt";
    static String OUTNAME = "T:\\TP-Z2\\DATEN\\E4\\AB_04092006_18_04.xml";
    
    /** Creates a new instance of Convert_Single */
    public Convert_Single() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            E4_Transcription original = E4_Transcription.read(new File(FILENAME),"NA","NA");
            Document d = original.toEXMARaLDA();
  //          FileIO.writeDocumentToLocalFile(OUTNAME,d);
            
        } catch (XSLTransformException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
    
}
