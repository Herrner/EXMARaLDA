/*
 * E4_Transcription.java
 *
 * Created on 15. Mai 2007, 09:36
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package corpora.E4_Korpus;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import org.exmaralda.partitureditor.jexmaralda.BasicTranscription;
import org.exmaralda.partitureditor.jexmaralda.JexmaraldaException;
import org.exmaralda.partitureditor.jexmaralda.Tier;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.transform.XSLTransformException;
import org.jdom.transform.XSLTransformer;
import org.xml.sax.SAXException;

/**
 * 
 * @author thomas, kai
 */
public class E4_Transcription {
	String interviewer;
	File inputFile;
	Vector<String[]> head = new Vector<String[]>();
	Vector<String[]> dataSets = new Vector<String[]>();
	Vector<String> excludedMetaKeys = new Vector<String>(
			Arrays.asList(new String[] { "kennziffer", "videoPfad",
					"transkriptPfad", "situation", "geraet", "hilfsmittel",
					"kindVorname", "kindNachName", "kontaktaufnahme",
					"aufnahmedatum", "transkribent" }));
	static String ENCODING = "MacRoman";
	XSLTransformer transformer;
	private String child;
	// private Object out;

	static String E42EXMARALDA_STYLESHEET = "/corpora/E4_Korpus/E42EXMARaLDA.xsl";

	/** Creates a new instance of E4_Transcription */
	public E4_Transcription(String i, String c) throws XSLTransformException {
		interviewer = i;
		child=c;
		InputStream is = getClass()
				.getResourceAsStream(E42EXMARALDA_STYLESHEET);
		transformer = new XSLTransformer(is);
	}

	static E4_Transcription read(File file, String i, String c) throws IOException,
			XSLTransformException {
		E4_Transcription returnValue = new E4_Transcription(i,c);
		FileInputStream fis = new FileInputStream(file);
		InputStreamReader isr = new InputStreamReader(fis, ENCODING);
		BufferedReader br = new BufferedReader(isr);
		String nextLine = new String();
		int lineCount = 0;
		while ((nextLine = br.readLine()) != null) {
			if (lineCount == 0) {
				returnValue.makeHead(nextLine);
				lineCount++;
				continue;
			}
			String[] dataSet = nextLine.split("\\t", 5);
			returnValue.dataSets.addElement(dataSet);
			lineCount++;
		}
		return returnValue;
	}

	public void makeHead(String h) {
		// System.out.println("H:"+h);
		// #transkriptPfad:
		// "Tranaly01:Transkription:Transkripte:EB_01122003_07_07.txt",
		int index1 = h.indexOf('[');
		int index2 = h.indexOf(']');
		String hh = h.substring(index1 + 1, index2);
		String[] items = hh.split("[\\,;] +#");
		for (String item : items) {
			int i = item.indexOf(':');
			String attributeName = item.substring(0, i);
			String attributeValue = item.substring(i + 2);
			attributeValue = attributeValue.replaceAll("\\\"", "");
			if (!excludedMetaKeys.contains(attributeName)) {
				String[] pair = { attributeName, attributeValue };
				head.add(pair);
			}
		}
		head.add(new String[] { "InterviewerIn", interviewer });
		head.add(new String[] {"Child",child});
	}

	public Document toXML() {
		Element rootElement = new Element("e4");
		Document returnValue = new Document(rootElement);
		Element headElement = new Element("head");
		for (String[] pair : head) {
			Element metaElement = null;
			if (pair[0].equals("interviewer") && pair[1].contains("/")) {
				metaElement = new Element("meta");
				metaElement.setAttribute("attribute", "interviewer");
				// hier!!
				// metaElement.setText(pair[1].split("/")[0]);
				metaElement.setText(interviewer);

				headElement.addContent(metaElement);
				metaElement = new Element("meta");
				metaElement.setAttribute("attribute", "child");
				// hier!!
				// metaElement.setText(pair[1].split("/")[0]);
				metaElement.setText(child);
				System.out.println(child);
				headElement.addContent(metaElement);
				metaElement = new Element("meta");
				// metaElement.setAttribute("attribute", "transkribent");
				// metaElement.setText(pair[1].split("/")[1]);

				//
				// for (String interviewer : pair[1].split("/")) {
				// metaElement = new Element("meta");
				// metaElement.setAttribute("attribute", pair[0]);
				// metaElement.setText(lrtrim(interviewer));
				// }
			} else {
				metaElement = new Element("meta");
				metaElement.setAttribute("attribute", pair[0]);
				metaElement.setText(pair[1]);
			}
			headElement.addContent(metaElement);
		}
		// XMLOutputter outputter = new XMLOutputter();
		// try {
		// outputter.output(headElement, System.out);
		// } catch (IOException e) {
		// System.err.println(e);
		// }
		rootElement.addContent(headElement);
		for (String[] dataSet : dataSets) {
			Element datasetElement = new Element("dataset");
			datasetElement.setAttribute("no", dataSet[0]);
			datasetElement.setAttribute("start", dataSet[1]);
			Element utterance = new Element("utterance");
			utterance.setText(dataSet[2]);
			Element comment = new Element("comment");
			if (dataSet.length > 3) {
				comment.setText(dataSet[3].trim());
			}
			Element context = new Element("context");
			if (dataSet.length > 4) {
				context.setText(dataSet[4].trim());
			}
			datasetElement.addContent(utterance);
			datasetElement.addContent(comment);
			datasetElement.addContent(context);
			rootElement.addContent(datasetElement);
		}
		return returnValue;
	}

	public Document toEXMARaLDA() throws XSLTransformException {
		Document d = toXML();
		Document exm = transformer.transform(d);
		return exm;
	}

	public Vector getSegmentationErrors() throws XSLTransformException,
			SAXException, JexmaraldaException {
		Document d = toEXMARaLDA();
		BasicTranscription bt = new BasicTranscription();
		bt.BasicTranscriptionFromJDOMDocument(d);
		for (int pos = 0; pos < bt.getBody().getNumberOfTiers(); pos++) {
			Tier t = bt.getBody().getTierAt(pos);
			// this line is responsible for empty turns being OK
			if (!(t.getSpeaker().equals("CHI"))) {
				t.removeEmptyEvents();
			}
		}
		org.exmaralda.partitureditor.jexmaralda.segment.HIATSegmentation hs = new org.exmaralda.partitureditor.jexmaralda.segment.HIATSegmentation();
		hs.utteranceWordFSM = "/org/exmaralda/partitureditor/fsm/xml/E4_UtteranceWord.xml";
		return hs.getSegmentationErrors(bt);
	}

	public static void main(String[] args) {
		// do nuth'n
	}

	// remove leading whitespace
	public static String ltrim(String source) {
		return source.replaceAll("^\\s+", "");
	}

	// remove trailing whitespace
	public static String rtrim(String source) {
		return source.replaceAll("\\s+$", "");
	}

	public static String lrtrim(String source) {
		return ltrim(rtrim(source));
	}
}
