/*
 * FileReader.java
 *
 * Created on 27. Mai 2005, 11:23
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package corpora.E4_Korpus;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Content;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;
import java.io.File;
import java.io.IOException;
import java.io.FileOutputStream;
import java.util.List;
import java.util.HashMap;

/**
 *
 * @author thomas
 */
public class FileIO {
    
    public static Document readDocumentFromLocalFile(String pathToDocument) throws JDOMException, IOException {
        if (pathToDocument.startsWith("http")){
            return readDocumentFromURL(pathToDocument);
        }
        SAXBuilder builder = new SAXBuilder();
        File file = new File(pathToDocument);
        Document document =  builder.build(file);
        return document;
    }
    
    public static Document readAndValidateDocument(String pathToDocument) throws JDOMException, IOException {
        SAXBuilder builder = new SAXBuilder();
        builder.setValidation(true);
        File file = new File(pathToDocument);
        Document document =  builder.build(file);
        return document;
    }

    public static Document readDocumentFromString(String documentString) throws JDOMException, IOException  {
        SAXBuilder builder = new SAXBuilder();
        java.io.StringReader stringReader = new java.io.StringReader(documentString);
        Document document = builder.build(stringReader);
        return document;
    }
    
    public static Document readDocumentFromURL(String url) throws JDOMException, IOException {
        SAXBuilder builder = new SAXBuilder();
        Document document =  builder.build(new java.net.URL(url));   
        return document;
    }
    
    public static void writeDocumentToLocalFile(File file, Document document) throws IOException{
        XMLOutputter xmlOutputter = new XMLOutputter();
        //String docString = xmlOutputter.outputString(document);
        File dir = file.getParentFile();
        // create parent dirs
        new File(file.getParent()).mkdirs();
        FileOutputStream fos = new FileOutputStream(file);        
        xmlOutputter.setFormat(org.jdom.output.Format.getCompactFormat());
        xmlOutputter.output(document,fos);
        //fos.write(docString.getBytes("UTF-8"));
        fos.close();    }
    
    public static String getPlainTextFromLocalFile(String pathToDocument) throws JDOMException, IOException {
        Document doc = readDocumentFromLocalFile(pathToDocument);
        Element body = doc.getRootElement().getChild("text");
        return getPlainText(body);
    }
    
    public static String getPlainText(Content c){
        if (c instanceof org.jdom.Text){
            return ((org.jdom.Text)c).getText();
        } else if (c instanceof org.jdom.CDATA){
            return (((org.jdom.CDATA)c).getText());                
        } else {
            StringBuffer sb = new StringBuffer();
            Element e = (Element)c;
            if (e.getName().equals("p") || e.getName().equals("head")){
                sb.append(System.getProperty("line.separator"));
            }
            List children = e.getContent();
            for (int pos=0; pos<children.size(); pos++){
                Object o = children.get(pos);
                Content content = (Content)o;
                sb.append(getPlainText(content));
            }
            if (e.getName().equals("p") || e.getName().equals("head")){
                sb.append(System.getProperty("line.separator"));
            }
            return sb.toString();
        }
        
    }
    
    public static void assignStylesheet(String pathToStylesheet, Document doc){
          HashMap piMap = new HashMap( 2 );
          piMap.put( "type", "text/xsl" );
          piMap.put( "href", pathToStylesheet );
          org.jdom.ProcessingInstruction pi = new org.jdom.ProcessingInstruction( "xml-stylesheet", piMap );
          doc.getContent().add( 0, pi );                
    }
}
