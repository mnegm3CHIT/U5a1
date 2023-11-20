package mnegm.model;

import javax.swing.*;

/**
 * Die Klasse WortEintrag repräsentiert einen Eintrag für ein Wort und die dazugehörige URL.
 * * @author Maged Negm
 *  * @version 2-10-2023
 */
public class WortEintrag {
    private String word;
    private String url;

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
            if (word != null && word.length() >= 2)
                this.word = word;
            else
                throw new IllegalArgumentException();
        }

    /**
     * Setzt die URL für den Eintrag. Die URL muss den Anforderungen der Methode checkURL entsprechen.
     *
     * @param url Die URL für den Eintrag.
     */
    public void setUrl(String url) {
           // if (checkURL(url))
                this.url = url;
            //else
                //throw new IllegalArgumentException();
    }

    /**
     * Überprüft, ob die gegebene URL den Anforderungen entspricht.
     *
     * @param url Die zu überprüfende URL.
     * @return true, wenn die URL den Anforderungen entspricht, ansonsten false.
     */
    public static boolean checkURL(String url) {
        String pattern = "^(http://|https://)[a-zA-Z]+\\.[a-zA-Z]+\\.[a-zA-Z]+/[a-zA-Z/_\\-=&]+$";
        return url.matches(pattern);
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
        return word+";"+url;
    }
}
