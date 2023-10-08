package mnegm;

/**
 * Die Klasse WortListe repräsentiert eine Liste von WortEintrag-Objekten.
 * * @author Maged Negm
 *  * @version 2-10-2023
 */
public class WortListe {
    private WortEintrag[] woerter;

    /**
     * Konstruktor für die Klasse WortListe. Erzeugt ein Array von WortEintrag-Objekten mit der angegebenen Größe.
     *
     * @param a Die Größe des Arrays für die WortEinträge. Muss größer als 0 sein; falls nicht, wird die Größe auf 2 gesetzt.
     */
    public WortListe(int a) {
        if (a <= 0)
            a = 2;
        this.woerter = new WortEintrag[a];
    }

    /**
     * Fügt ein neues WortEintrag-Objekt zur Liste hinzu.
     *
     * @param word Das Wort für den Eintrag.
     * @param url  Die URL für den Eintrag.
     */
    public void addWord(String word, String url) {
        for (int i = 0; i < woerter.length; i++) {
            if (woerter[i] == null) {
                woerter[i] = new WortEintrag(word, url);
                break;
            }
            if (i == woerter.length - 1) {
                this.enlarge(new WortEintrag(word, url));
                break;
            }
        }
    }

    public void enlarge(WortEintrag we) {
        WortEintrag[] x = new WortEintrag[woerter.length+1];

        for(int i = 0; i < woerter.length; i++) {
            x[i] = woerter[i];
        }
        x[x.length-1] = we;
        woerter = x;
    }

    /**
     * Gibt den WortEintrag an der angegebenen Position in der Liste zurück.
     *
     * @param index Der Index des gewünschten WortEintrag-Objekts.
     * @return Das WortEintrag-Objekt an der angegebenen Position.
     * @throws IndexOutOfBoundsException Wenn der Index außerhalb des gültigen Bereichs liegt.
     */
    public WortEintrag getEintragAt(int index) {
        if (!(woerter.length > index)) throw new IndexOutOfBoundsException("Index out of bounds");
        return woerter[index];
    }

    /**
     * Gibt die Anzahl der Einträge in der Liste zurück.
     *
     * @return Die Anzahl der Einträge in der Liste.
     */
    public int getLength() {
        return woerter.length;
    }

    /**
     * Löscht ein Wort aus der Liste.
     *
     * @param word Das zu löschende Wort.
     * @return true, wenn das Wort erfolgreich gelöscht wurde, andernfalls false.
     */
    public boolean deleteWord(String word) {
        for (int i = 0; i < woerter.length; i++) {
            if (woerter[i] != null && woerter[i].getWord().equals(word)) {
                woerter[i] = null;
                return true;
            }
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        String text = "";
        for (int i = 0; i < woerter.length; i++) {
            if (woerter[i] == null)
                text += "<leer>\n";
            else
                text += woerter[i].toString() + "\n";
        }
        return text;
    }
}
