package mnegm;

/**
 * Testet die Methoden der Klassen.
 * @author Maged Negm
 * @version 2023-10-08
 */
public class WortTest {
    public static void main(String[] args) {
        // Testen der Klasse WortEintrag
        WortEintrag eintrag1 = new WortEintrag("Hund", "https://www.beispiel.de/hund");
        System.out.println("WortEintrag 1: " + eintrag1);

        // Testen der Klasse WortListe
        WortListe wortListe = new WortListe(2);
        wortListe.addWord("Katze", "https://www.beispiel.at/katze");

        System.out.println("WortListe:");
        System.out.println(wortListe);

        WortEintrag eintrag2 = wortListe.getEintragAt(0);
        System.out.println("WortEintrag 2: " + eintrag2);

        boolean deleted = wortListe.deleteWord("Haus");
        if (deleted) {
            System.out.println("Wort 'Haus' wurde gelöscht.");
        } else {
            System.out.println("Wort 'Haus' wurde nicht gefunden.");
        }
        System.out.println("Aktuelle WortListe:");
        System.out.println(wortListe);

        // Testen der Klasse WortTrainer
        WortTrainer trainer = new WortTrainer(wortListe, eintrag2, new WortStatistik(0,0));
        WortEintrag randomEintrag = trainer.random();
        System.out.println("Zufälliger WortEintrag: " + randomEintrag);

        boolean isCorrect = trainer.check("katze");
        if (isCorrect) {
            System.out.println("Richtiges Wort eingegeben.");
        } else {
            System.out.println("Falsches Wort eingegeben.");
        }

        boolean isCorrectIgnoreCase = trainer.checkIgnoreCase("KAtze");
        if (isCorrectIgnoreCase) {
            System.out.println("Richtiges Wort (ohne Groß-/Kleinschreibung) eingegeben.");
        } else {
            System.out.println("Falsches Wort (ohne Groß-/Kleinschreibung) eingegeben.");
        }
        System.out.println(trainer.getWs().toString());
    }
}
