package mnegm.model;

/**
 * Die Klasse WortStatistik repräsentiert eine einfache Wortstatistik, die die Anzahl der richtigen (r)
 * und falschen (f) Abfragen sowie die Gesamtanzahl der Abfragen (total) speichert.
 * @author Maged Negm
 * @version 08-10-2023
 */
public class WortStatistik {
    private int r;
    private int f;
    private int total;

    /**
     * Konstruktor für die Klasse WortStatistik. Initialisiert die Anzahl der richtigen (r) und
     * falschen (f) Abfragen mit den gegebenen Werten und berechnet die Gesamtanzahl (total).
     *
     * @param r Die Anzahl der richtigen Abfragen. Nicht kleiner als 0.
     * @param f Die Anzahl der falschen Abfragen. Nicht kleiner als 0.
     */
    public WortStatistik(int r, int f) {
        this.r = Math.max(r, 0);
        this.f = Math.max(f, 0);
        this.total = this.r + this.f;
    }

    /**
     * Erhöht die Anzahl der richtigen Abfragen (r) um 1 und aktualisiert die Gesamtanzahl (total).
     */
    public void addR() {
        this.r += 1;
        this.total += 1;
    }

    /**
     * Erhöht die Anzahl der falschen Abfragen (f) um 1 und aktualisiert die Gesamtanzahl (total).
     */
    public void addF() {
        this.f += 1;
        this.total += 1;
    }

    /**
     * Gibt die Anzahl der richtigen Abfragen (r) zurück.
     *
     * @return Die Anzahl der richtigen Abfragen.
     */
    public int getR() {
        return r;
    }

    /**
     * Gibt die Anzahl der falschen Abfragen (f) zurück.
     *
     * @return Die Anzahl der falschen Abfragen.
     */
    public int getF() {
        return f;
    }

    /**
     * Gibt die Gesamtanzahl der Abfragen (total) zurück.
     *
     * @return Die Gesamtanzahl der Abfragen.
     */
    public int getTotal() {
        return total;
    }

    /**
     * Gibt eine textuelle Darstellung der Wortstatistik zurück, die die Gesamtanzahl der Abfragen, die Anzahl
     * der richtigen Abfragen und die Anzahl der falschen Abfragen enthält.
     *
     * @return Eine textuelle Darstellung der Wortstatistik.
     */
    @Override
    public String toString() {
        return "Von " + this.total + " Abfrage(n) sind " + this.r + " richtig und " + this.f + " falsch";
    }
}
