package corpora.E4_Korpus;

import java.io.File;

public class filenametest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new File(
				"S:\\TP-Z2\\DATEN\\E4\\Ueberfuehrung_Juli2010").exists());
		System.out
				.println(new File("S://TP-Z2/DATEN/E4/Ueberfuehrung_Juli2010")
						.exists());
		System.out
				.println(new File(
						"S:\\TP-Z2\\DATEN\\E4\\Korpusstruktur\\sortieren.txt")
						.exists());
		System.out
				.println(new File("S:" + File.separator
						+ "TP-Z2\\DATEN\\E4\\Korpusstruktur\\sortieren.txt")
						.exists());

	}

}
// "" "S:\\TP-Z2\\DATEN\\E4\\Ueberfuehrung_Juli2010" "S:\TP-Z2\DATEN\E4\0.2"
// "S:\\TP-Z2\\DATEN\\E4\\Korpusstruktur\\sortieren.txt"