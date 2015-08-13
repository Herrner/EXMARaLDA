/*
 * AbstractCorpusProcessor.java
 *
 * Created on 10. Oktober 2006, 17:11
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package corpora.E4_Korpus;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Vector;

import org.exmaralda.partitureditor.fsm.FSMException;
import org.exmaralda.partitureditor.jexmaralda.BasicTranscription;
import org.exmaralda.partitureditor.jexmaralda.JexmaraldaException;
import org.exmaralda.partitureditor.jexmaralda.SegmentedTranscription;
import org.exmaralda.partitureditor.jexmaralda.Tier;
import org.jdom.transform.XSLTransformException;
import org.xml.sax.SAXException;

/**
 * 
 * @author Kai and Thomas
 */
public class E4_Converter {

	public String currentFilename;
	private String catalogFile;
	private String baseDir;
	private String targetDir;
	private String sorterFile;
	private HashMap<String, String> dirLookupTable = new HashMap<String, String>();
	private String resultString = "";
	private HashMap<String, String> nameLookupTable;
	private boolean doSegmentation;
	private HashMap<String, Boolean> convertedTable;
	private HashMap<String, Vector<String>> metaTable;
	private String[] metaKeys;

	/** Creates a new instance of AbstractCorpusProcessor */
	public E4_Converter(String c, String b, String t, String s, String seg) {
		catalogFile = c;
		baseDir = b;
		targetDir = t;
		sorterFile = s;
		doSegmentation = (seg.equals("true") ? true : false);
	}

	public void doIt() throws IOException, SAXException, JexmaraldaException,
			XSLTransformException, FSMException {
		File baseDirFile = new File(baseDir);
		HashSet<File> inputFiles = new HashSet<File>();
		if (catalogFile.length() == 0) {
			for (File f : baseDirFile.listFiles(new TXTFileFilter())) {
				inputFiles.add(f);
			}
		} else {
			FileReader fr = new FileReader(catalogFile);
			BufferedReader br = new BufferedReader(fr);
			String filename = new String();
			while ((filename = br.readLine()) != null) {
				String fullTranscriptionName = baseDir + "\\" + filename;
				if (new File(fullTranscriptionName).exists())
					inputFiles.add(new File(fullTranscriptionName));
			}
			br.close();

		}
		// dateiname -> ex-dateinamen --> pfadbestandteil -->
		// pfadbestandteil2 --> Gruppe --> Kind --> Kontaktmonat -->
		// Alter1 --> AlterGerundet --> AO --> SSES --> Aufnahmelänge -->
		// Äußerungen --> Interviewerin --> Ort --> Hilfsmittel

		if (sorterFile.length() > 0) {
			metaKeys = new String[] { "Gruppe", "Kind", "Kontaktmonat",
					"Alter", "Alter (gerundet)", "AO", "SSES", "Aufnahmelänge",
					"Äußerungen", "Interviewerin", "Ort", "Hilfsmittel" };
			nameLookupTable = new HashMap<String, String>();
			dirLookupTable = new HashMap<String, String>();
			convertedTable = new HashMap<String, Boolean>();
			metaTable = new HashMap<String, Vector<String>>();
			// System.out.println(metaTable);
			FileReader fr = new FileReader(sorterFile);
			BufferedReader br = new BufferedReader(fr);
			String readLine = "";
			while ((readLine = br.readLine()) != null) {
				System.out.println(">>" + readLine);
				String[] parts = readLine.split("\t");
				nameLookupTable.put(parts[0].trim(), parts[1]);
				convertedTable.put(parts[0].trim(), false);
				String dirString = "";
				if (parts[1].length() > 1) {
					dirString = parts[2] + "/" + parts[3] + "/"
							+ parts[1].substring(0, parts[1].indexOf("_"))
							+ "/" + parts[1].trim() + "/";
				}
				dirLookupTable.put(parts[0].trim(), dirString);
				Vector<String> meta = new Vector<String>();
				for (int i = 4; i < parts.length; i++) {
					meta.add(parts[i]);
				}
				metaTable.put(parts[0].trim(), meta);
			}
			br.close();

		}
		for (File f : inputFiles) {
			System.out.println(">>" + f.getName());
			// E4_Transcription original = E4_Transcription.read(f, "INT");

			E4_Transcription original = E4_Transcription.read(
					f,
					metaTable.get(
							f.getName().substring(0,
									f.getName().indexOf(".txt"))).get(9),
					metaTable.get(
							f.getName().substring(0,
									f.getName().indexOf(".txt"))).get(1));
			currentFilename = f.getPath();
			System.out.println("Converting " + f);
			try {
				convert(original);
			} catch (Exception e) {
				resultString += e.getMessage();
				e.printStackTrace();
			}
		}
		FileWriter out = new FileWriter(new File(targetDir
				+ "/conversionResult.txt"));
		for (String s : convertedTable.keySet()) {
			if (!convertedTable.get(s))
				resultString += "no such file: " + s + ".txt";
		}
		out.write(resultString);
		out.close();
	}

	public void convert(E4_Transcription o) throws XSLTransformException,
			IOException, SAXException, JexmaraldaException, FSMException {
		File curFile = new File(currentFilename);
		String outFileName = curFile.getName();
		outFileName = outFileName.substring(0, outFileName.lastIndexOf(".txt"));
		resultString += curFile.getAbsolutePath() + "\t";
		String outname;
		outname = targetDir
				+ File.separator
				+ ((dirLookupTable.containsKey(outFileName)) ? dirLookupTable
						.get(outFileName) : "")
				+ ((nameLookupTable.containsKey(outFileName)) ? nameLookupTable
						.get(outFileName) + ".exb" : outFileName + ".exb");
		int index1 = currentFilename.lastIndexOf("\\");
		int index2 = currentFilename.lastIndexOf(".");
		String orgTransName = currentFilename.substring(index1 + 1, index2);
		String transName = (nameLookupTable.containsKey(outFileName)) ? nameLookupTable
				.get(outFileName) : orgTransName;
		FileIO.writeDocumentToLocalFile(new File(outname), o.toEXMARaLDA());
		BasicTranscription bt = new BasicTranscription(outname);
		bt.getHead().getMetaInformation().setTranscriptionName(transName);
		if (metaTable.containsKey(outFileName)) {
			for (int i = 0; i < metaTable.get(outFileName).size(); i++) {
				// System.out.println(metaTable.get(outFileName).size());
				if (metaTable.get(outFileName).get(i) != null) {
					bt.getHead()
							.getMetaInformation()
							.getUDMetaInformation()
							.setAttribute(metaKeys[i],
									metaTable.get(outFileName).get(i));
				}
			}
		}
		for (int pos = 0; pos < bt.getBody().getNumberOfTiers(); pos++) {
			Tier t = bt.getBody().getTierAt(pos);
			t.removeEmptyEvents();
		}
		// System.out.println(curFile.getName() + "-->"
		// + dirLookupTable.containsKey(outFileName) + "-->"
		// + nameLookupTable.containsKey(outFileName) + "-->" + outname);
		File file = new File(outname);

		bt.writeXMLToFile(outname, "none");
		resultString += file.getAbsolutePath() + "\t";
		convertedTable.put(outFileName, true);
		if (doSegmentation) {
			// SegmentedTranscription st = bt.toSegmentedTranscription();
			org.exmaralda.partitureditor.jexmaralda.segment.HIATSegmentation hs = new org.exmaralda.partitureditor.jexmaralda.segment.HIATSegmentation();
			hs.utteranceWordFSM = "/org/exmaralda/partitureditor/fsm/xml/E4_UtteranceWord.xml";
			try {
				SegmentedTranscription st = hs.BasicToSegmented(bt);
				String outname2 = outname.replace(".exb", "_s.exs");
				st.writeXMLToFile(outname2, "none");
				resultString += new File(outname2).getAbsolutePath() + "\t";
			} catch (Exception e) {
				resultString += "\tsegmentation failed!" + e.getMessage();
			}
		}
		resultString += (dirLookupTable.containsKey(outFileName) ? ""
				: " <-- not in sorter file!");
		resultString += "\n";
	}

	public static void main(String[] args) {
		E4_Converter c = new E4_Converter(args[0], args[1], args[2], args[3],
				args[4]);
		try {
			c.doIt();
		} catch (XSLTransformException ex) {
			ex.printStackTrace();
		} catch (JexmaraldaException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (SAXException ex) {
			ex.printStackTrace();
		} catch (FSMException ex) {
			ex.printStackTrace();
		}
		System.out.println("done.");
	}

	class TXTFileFilter implements FileFilter {

		public boolean accept(File pathname) {

			if (pathname.getName().endsWith(".txt"))
				return true;
			return false;
		}
	}
}
