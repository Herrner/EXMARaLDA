/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package corpora.H6_Korpus;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Vector;
import org.exmaralda.partitureditor.jexmaralda.BasicTranscription;
import org.exmaralda.partitureditor.jexmaralda.Event;
import org.exmaralda.partitureditor.jexmaralda.JexmaraldaException;
import org.exmaralda.partitureditor.jexmaralda.Tier;
import org.exmaralda.partitureditor.jexmaralda.Timeline;

/**
 *
 * @author thomas
 */
public class PVIMaker {

    BasicTranscription basicTranscription;


    org.exmaralda.partitureditor.jexmaralda.convert.PraatConverter
            praatConverter = new org.exmaralda.partitureditor.jexmaralda.convert.PraatConverter();


    public PVIMaker() {
    }

    public void readTextGrid(File file, String encoding) throws IOException{
        basicTranscription = praatConverter.readPraatFromFile(file.getAbsolutePath(), encoding);
    }

    void calculate(String vowels_out, String consonnants_out) throws IOException, JexmaraldaException {
        if (basicTranscription.getBody().getNumberOfTiers()<3){
            throw new IOException("TextGrid has only " + basicTranscription.getBody().getNumberOfTiers() + " tiers.");
        }
        StringBuffer vowels = new StringBuffer();
        StringBuffer consonnants = new StringBuffer();

        Tier vowelTier = basicTranscription.getBody().getTierAt(0);
        Tier consonnantTier = basicTranscription.getBody().getTierAt(1);
        Tier utteranceTier = basicTranscription.getBody().getTierAt(2);
        Timeline tl = basicTranscription.getBody().getCommonTimeline();
        for (int pos=0; pos<utteranceTier.getNumberOfEvents(); pos++){
            Event utteranceEvent = utteranceTier.getEventAt(pos);
            Vector<Event> vowelEvents = vowelTier.getEventsBetween(tl, utteranceEvent.getStart(), utteranceEvent.getEnd());
            Vector<Event> consonnantEvents = consonnantTier.getEventsBetween(tl, utteranceEvent.getStart(), utteranceEvent.getEnd());

            for (Event e : vowelEvents){
                double vowelDuration = tl.getTimelineItemWithID(e.getEnd()).getTime() - tl.getTimelineItemWithID(e.getStart()).getTime();
                vowels.append(Double.toString(vowelDuration).replace('.', ','));
                if (vowelEvents.indexOf(e)<vowelEvents.size()-1){
                    vowels.append("\t");
                }
            }
            vowels.append("\n");

            for (Event e : consonnantEvents){
                double consonnantDuration = tl.getTimelineItemWithID(e.getEnd()).getTime() - tl.getTimelineItemWithID(e.getStart()).getTime();
                consonnants.append(Double.toString(consonnantDuration).replace('.', ','));
                if (consonnantEvents.indexOf(e)<consonnantEvents.size()-1){
                    consonnants.append("\t");
                }
            }
            consonnants.append("\n");
        }

        output(vowels_out,vowels);
        output(consonnants_out,consonnants);
    }

    void output(String filename, StringBuffer sb) throws IOException {
        System.out.println("started writing document...");
        FileOutputStream fos = new FileOutputStream(new File(filename));
        fos.write(sb.toString().getBytes());
        fos.close();
        System.out.println("Document written...");
    }

}
