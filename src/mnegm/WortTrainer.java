package mnegm;

import java.util.Random;

/**
 * Die Klasse WortTrainer ermöglicht das Training von Wörtern aus einer WortListe.
 * @author Maged Negm
 * @version 2-10-2023
 */
public class WortTrainer {
    private WortListe wordlist;
    private WortEintrag cwe;
    private WortStatistik ws;

    /**
     * Konstruktor für die Klasse WortTrainer.
     *
     * @param wordlist   Die Liste von WortEintrag-Objekten für das Training.
     * @param cwe Der aktuelle WortEintrag, der im Training verwendet wird.
     * @param ws Der aktuelle WortEintrag, der im Training verwendet wird.
     */
    public WortTrainer(WortListe wordlist, WortEintrag cwe, WortStatistik ws) {
        this.wordlist = wordlist;
        this.cwe = cwe;
        this.ws = ws;
    }

    /**
     * Wählt zufällig einen WortEintrag aus der Liste aus und gibt ihn zurück.
     *
     * @return Ein zufällig ausgewählter WortEintrag aus der Liste.
     */
    public WortEintrag random() {
        Random r = new Random();
        int index = r.nextInt(wordlist.getLength() - 1);
        this.cwe = wordlist.getEintragAt(index);
        return this.cwe;
    }

    /**
     * Gibt den aktuellen WortEintrag zurück, der im Training verwendet wird.
     *
     * @return Der aktuelle WortEintrag.
     */
    public WortEintrag getWortEintrag() {
        return cwe;
    }

    /**
     * Gibt die aktuelle WortStatistik zurück, der im Training verwendet wird.
     *
     * @return Die aktuelle WortStatistik.
     */
    public WortStatistik getWs() {
        return ws;
    }

    /**
     * Überprüft, ob das gegebene Wort mit dem Wort im aktuellen WortEintrag übereinstimmt (Groß-/Kleinschreibung beachten).
     *
     * @param word Das zu überprüfende Wort.
     * @return true, wenn das Wort korrekt ist, andernfalls false.
     */
    public boolean check(String word) {
        if (word.equals(cwe.getWord())) {
            ws.addR();
            return true;
        }
        ws.addF();
        return false;
    }

    /**
     * Überprüft, ob das gegebene Wort mit dem Wort im aktuellen WortEintrag übereinstimmt (ohne Groß-/Kleinschreibung zu beachten).
     *
     * @param word Das zu überprüfende Wort.
     * @return true, wenn das Wort korrekt ist, andernfalls false.
     */
    public boolean checkIgnoreCase(String word) {
        if (word.toLowerCase().equals(cwe.getWord().toLowerCase())) {
            ws.addR();
            return true;
        }
        ws.addF();
        return false;
    }
    public String toString() {
        return this.wordlist.toString()+ "---\n"+this.ws.toString();
    }
}