package mnegm.model;

import java.io.*;
import java.util.Scanner;

/**
 * Die Klasse WortSL erweitert die IOException und dient der Speicherung und dem Laden
 * von Daten eines WortTrainers in eine Datei.
 *
 * @author Maged Negm
 * @version 2023-10-20
 */
public class WortSL extends IOException {
    private WortTrainer trainer;
    private final String FILENAME = "C:\\Users\\Maged\\OneDrive\\Schule\\Schuljahr 2022 2024\\SEW\\U5a1\\WortTrainer.txt";

    /**
     * Konstruktor der Klasse WortSL.
     *
     * @param trainer Der übergebene WortTrainer, dessen Daten gespeichert werden sollen.
     */
    public WortSL(WortTrainer trainer) {
        this.trainer = trainer;
    }

    /**
     * Speichert die Daten des WortTrainers in eine Datei mit dem angegebenen Dateinamen.
     *
     * @param filename Der Dateiname, unter dem die Daten gespeichert werden sollen.
     * @throws IOException Wenn ein Fehler beim Schreiben in die Datei auftritt.
     * @throws IllegalArgumentException Wenn die Datei nicht existiert oder nicht beschreibbar ist.
     */
    public void speichern(String filename) throws IOException, IllegalArgumentException {
        String[] liste = trainer.toString().split("\n");
        File file = new File(filename);
        if (!file.exists()) {
            throw new FileNotFoundException("Diese Datei existiert nicht!");
        }
        if (!file.canWrite()) {
            throw new IllegalArgumentException("In diese Datei kann nicht geschrieben werden! - Du hast nicht die Berechtigung!");
        }
        try (PrintWriter ops = new PrintWriter(filename)) {
            for (String e : liste) {
                ops.println(e);
            }
        }
    }

    /**
     * Speichert die Daten des WortTrainers in die vordefinierte Datei.
     *
     * @throws IOException Wenn ein Fehler beim Schreiben in die Datei auftritt.
     */
    public void speichern() throws IOException {
        speichern(FILENAME);
    }

    /**
     * Lädt die Daten eines WortTrainers aus einer Datei mit dem angegebenen Dateinamen.
     *
     * @param filename Der Dateiname, aus dem die Daten geladen werden sollen.
     * @return Der geladene WortTrainer.
     * @throws IOException Wenn ein Fehler beim Lesen aus der Datei auftritt.
     * @throws IllegalArgumentException Wenn die Datei nicht existiert oder nicht lesbar ist.
     */
    public WortTrainer laden(String filename) throws IOException, IllegalArgumentException {
        File file = new File(filename);
        if (!file.exists()) {
            throw new FileNotFoundException("Diese Datei existiert nicht!");
        }
        if (!file.canRead()) {
            throw new IllegalArgumentException("Diese Datei kann nicht gelesen werden! - Du hast nicht die Berechtigung!");
        }
        String text = "";
        try (Scanner s = new Scanner(new BufferedReader(new FileReader(filename)))) {
            while (s.hasNext()) {
                text += s.nextLine() + "\n";
            }
        }

        String[] part = text.split("\n-----\n");
        String[] e = part[0].split("\n");
        String[] s = part[1].split("[a-zA-Z\"\"\n ()]+");

        WortListe wl = new WortListe(1);
        for (String ce : e) {
            String[] teil = ce.split(";");
            if (teil[0].equals("<leer>"))
                wl.addWord(null);
            else
                wl.addWord(teil[0], teil[1]);
        }

        WortStatistik ws = new WortStatistik(Integer.parseInt(s[2]), Integer.parseInt(s[3]));

        return new WortTrainer(wl, trainer.random(), ws);
    }

    /**
     * Lädt die Daten eines WortTrainers aus der vordefinierten Datei.
     *
     * @return Der geladene WortTrainer.
     * @throws IOException Wenn ein Fehler beim Lesen aus der Datei auftritt.
     * @throws IllegalArgumentException Wenn die Datei nicht existiert oder nicht lesbar ist.
     */
    public WortTrainer laden() throws IOException, IllegalArgumentException {
        return this.laden(FILENAME);
    }
}