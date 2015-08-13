/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package corpora.H6_Korpus;

import java.io.*;
import org.exmaralda.partitureditor.jexmaralda.*;
import java.util.*;
import org.jdom.*;

/**
 *
 * @author thomas
 */
public class TextGridParser {

    
    BasicTranscription basicTranscription;
    
    
    org.exmaralda.partitureditor.jexmaralda.convert.PraatConverter
            praatConverter = new org.exmaralda.partitureditor.jexmaralda.convert.PraatConverter();

            
    public TextGridParser() {
    }
    
    public void readTextGrid(File file, String encoding) throws IOException{        
        basicTranscription = praatConverter.readPraatFromFile(file.getAbsolutePath(), encoding);
    }
    
    public Vector<AcousticAnalysisDataSet> parse() throws Exception {
        Vector<AcousticAnalysisDataSet> result = new Vector<AcousticAnalysisDataSet>();
        if (basicTranscription.getBody().getNumberOfTiers()<3){
            throw new Exception("TextGrid has only " + basicTranscription.getBody().getNumberOfTiers() + " tiers.");
        }
        Tier baseFormTier = basicTranscription.getBody().getTierAt(0);
        Tier tier2 = basicTranscription.getBody().getTierAt(1);
        Tier tier3 = basicTranscription.getBody().getTierAt(2);
        for (int pos=0; pos<baseFormTier.getNumberOfEvents(); pos++){
            AcousticAnalysisDataSet aads = new AcousticAnalysisDataSet();
            Event baseFormEvent = baseFormTier.getEventAt(pos);
            
            aads.isRepetition = baseFormEvent.getDescription().startsWith("R ");
            
            int wordStartIndex = 0;
            int wordEndIndex = baseFormEvent.getDescription().indexOf("(");
            if (aads.isRepetition) wordStartIndex = 2;
            if (wordEndIndex<0){
                throw new Exception("No occurence count in event " + Integer.toString(pos) + ". Text is: " + baseFormEvent.getDescription());
                
            }
            String word = baseFormEvent.getDescription().substring(wordStartIndex, wordEndIndex).trim();
            
            aads.baseForm = word;
            
            int countEndIndex = baseFormEvent.getDescription().indexOf(")");
            if ((countEndIndex<0) || (countEndIndex<=wordEndIndex)){                
                throw new Exception("No occurence count in event " + Integer.toString(pos) + ". Text is: " + baseFormEvent.getDescription());                
            }
            
            String count = baseFormEvent.getDescription().substring(wordEndIndex+1, countEndIndex).trim();
            
            try{
                int countNumber = Integer.parseInt(count);
                aads.occurenceCount = countNumber;
            } catch (NumberFormatException nfe){
                throw new Exception("No occurence count in event " + Integer.toString(pos) + ". Text is: " + baseFormEvent.getDescription());                                
            }
            
            Vector<Event> e1 = 
                tier2.getEventsBetween(basicTranscription.getBody().getCommonTimeline(), baseFormEvent.getStart(), baseFormEvent.getEnd());
            if (e1.size()>0){
                for (Event e : e1){
                    aads.transcription1+=e.getDescription();
                    if (e1.indexOf(e)<e1.size()-1){
                        aads.transcription1+="/";
                    }
                }
            }
            
            Vector<Event> e2 = 
                tier3.getEventsBetween(basicTranscription.getBody().getCommonTimeline(), baseFormEvent.getStart(), baseFormEvent.getEnd());
            if (e2.size()>0){
                for (Event e : e2){
                    aads.transcription2+=e.getDescription();
                    if (e2.indexOf(e)<e2.size()-1){
                        aads.transcription2+="/";
                    }
                }
            }

            result.add(aads);
        }
        return result;
    }
    
    public org.jdom.Document fillTargetWordList() throws JDOMException, IOException, Exception{
        java.io.InputStream is = getClass().getResourceAsStream("/corpora/H6_Korpus/targetwords.xml");
        org.jdom.input.SAXBuilder saxBuilder = new org.jdom.input.SAXBuilder();
        org.jdom.Document wordList = saxBuilder.build(is);        
        List targetWords = wordList.getRootElement().getChildren("row");
        
        Vector<AcousticAnalysisDataSet> thisData = parse();
        
        for (Object o : targetWords){
            Element e = (Element)o;
            String word = e.getChild("orthography").getText();
            for (AcousticAnalysisDataSet aads : thisData){
                if (aads.baseForm.equals(word)){
                    Element occurenceElement = new Element("occurence");
                    occurenceElement.setAttribute("count", Integer.toString(aads.occurenceCount));
                    String rep = "no";
                    if (aads.isRepetition) rep="yes";
                    occurenceElement.setAttribute("repetition", rep);
                    Element transcription1Element = new Element("transcription1");
                    transcription1Element.setText(aads.transcription1);
                    Element transcription2Element = new Element("transcription2");
                    transcription2Element.setText(aads.transcription2);
                    occurenceElement.addContent(transcription1Element);
                    occurenceElement.addContent(transcription2Element);
                    e.addContent(occurenceElement);
                }
            }
        }
        
        return wordList;
    }
    
    
    
    

}
