package mnegm;

import javax.swing.*;

/**
 * Die Klasse WortEintrag repräsentiert einen Eintrag für ein Wort und die dazugehörige URL.
 * * @author Maged Negm
 *  * @version 2-10-2023
 */
public class WortEintrag {
    private String word; // Das Wort
    private String url;  // Die URL

    /**
     * Konstruktor für die Klasse WortEintrag.
     *
     * @param word Das Wort für den Eintrag.
     * @param url  Die URL für den Eintrag.
     */
    public WortEintrag(String word, String url) {
        this.setWord(word);
        this.setUrl(url);
    }

    /**
     * Setzt das Wort für den Eintrag. Das Wort muss mindestens 2 Zeichen lang sein.
     *
     * @param word Das Wort für den Eintrag.
     */
    public void setWord(String word) {
        try {
            if (word != null && word.length() >= 2)
                this.word = word;
            else
                throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Ungültiges Wort");
        }
    }

    /**
     * Setzt die URL für den Eintrag. Die URL muss den Anforderungen der Methode checkURL entsprechen.
     *
     * @param url Die URL für den Eintrag.
     */
    public void setUrl(String url) {
        try {
            if (checkURL(url))
                this.url = url;
            else
                throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Ungültige Url");
        }
    }

    /**
     * Überprüft, ob die gegebene URL den Anforderungen entspricht.
     *
     * @param url Die zu überprüfende URL.
     * @return true, wenn die URL den Anforderungen entspricht, ansonsten false.
     */
    public static boolean checkURL(String url) {
        return ((url.startsWith("https://") || url.startsWith("http://")) && (url.contains("//[a-zA-Z]\\.([a-zA-Z])")));
    }

    /**
     * Gibt das Wort für den Eintrag zurück.
     *
     * @return Das Wort für den Eintrag.
     */
    public String getWord() {
        return word;
    }

    /**
     * Gibt die URL für den Eintrag zurück.
     *
     * @return Die URL für den Eintrag.
     */
    public String getUrl() {
        return url;
    }

    /**
     * Macht es zum String
     * @return das String
     */
    @Override
    public String toString() {
        return "WortEintrag{" + "word='" + word + '\'' + "; url='" + url + '\'' + '}';
    }
}
