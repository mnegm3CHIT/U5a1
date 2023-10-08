package mnegm;

import java.util.Random;

/**
 * Die Klasse WortTrainer ermöglicht das Training von Wörtern aus einer WortListe.
 * @author Maged Negm
 * @version 2-10-2023
 */
public class WortTrainer {
    private WortListe wordlist;     // Die Liste von WortEintrag-Objekten für das Training.
    private WortEintrag cwe; // Der aktuelle WortEintrag, der im Training verwendet wird.

    /**
     * Konstruktor für die Klasse WortTrainer.
     *
     * @param wordlist   Die Liste von WortEintrag-Objekten für das Training.
     * @param cwe Der aktuelle WortEintrag, der im Training verwendet wird.
     */
    public WortTrainer(WortListe wordlist, WortEintrag cwe) {
        this.wordlist = wordlist;
        this.cwe = cwe;
    }

    /**
     * Wählt zufällig einen WortEintrag aus der Liste aus und gibt ihn zurück.
     *
     * @return Ein zufällig ausgewählter WortEintrag aus der Liste.
     */
    public WortEintrag random() {
        Random r = new Random();
        int index = r.nextInt(wordlist.getLength() - 1);
        return wordlist.getEintragAt(index);
    }

    /**
     * Gibt den aktuellen WortEintrag zurück, der im Training verwendet wird.
     *
     * @return Der aktuelle WortEintrag.
     */
    public WortEintrag getCwe() {
        return cwe;
    }

    /**
     * Überprüft, ob das gegebene Wort mit dem Wort im aktuellen WortEintrag übereinstimmt (Groß-/Kleinschreibung beachten).
     *
     * @param word Das zu überprüfende Wort.
     * @return true, wenn das Wort korrekt ist, andernfalls false.
     */
    public boolean check(String word) {
        if (word.equals(cwe.getWord()))
            return true;
        return false;
    }

    /**
     * Überprüft, ob das gegebene Wort mit dem Wort im aktuellen WortEintrag übereinstimmt (ohne Groß-/Kleinschreibung zu beachten).
     *
     * @param word Das zu überprüfende Wort.
     * @return true, wenn das Wort korrekt ist, andernfalls false.
     */
    public boolean checkIgnoreCase(String word) {
        if (word.toLowerCase().equals(cwe.getWord().toLowerCase()))
            return true;
        return false;
    }
}
