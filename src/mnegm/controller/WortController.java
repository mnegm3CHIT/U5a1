package mnegm.controller;

import mnegm.model.WortListe;
import mnegm.model.WortSL;
import mnegm.model.WortStatistik;
import mnegm.model.WortTrainer;
import mnegm.view.WortFrame;
import mnegm.view.WortLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

/**
 * Die Klasse WortController fungiert als Controller im MVC (Model-View-Controller)-Architekturmuster für die WortTrainer-Anwendung.
 * Sie behandelt Benutzereingaben, interagiert mit den Model-Klassen (WortListe, WortTrainer, WortStatistik) und aktualisiert die Ansicht (WortLayout).
 *
 * @author Maged Negm
 * @version 2023-11-19
 */
public class WortController implements ActionListener {
    private WortLayout wLayout;
    private WortFrame wF;
    private WortSL wSL;
    private WortTrainer wT;
    private WortListe wListe;

    /**
     * Konstruktor für die Klasse WortController. Initialisiert die erforderlichen Komponenten und setzt den Anfangszustand.
     *
     * @throws IOException wenn ein E/A-Fehler beim Initialisieren der Komponenten auftritt.
     */
    public WortController() throws IOException {
        wLayout = new WortLayout(this);
        wF = new WortFrame(wLayout);
        wListe = new WortListe(1);
        wT = new WortTrainer(wListe, null, new WortStatistik(0,0));
        wSL = new WortSL(wT);

        wListe.addWord("Hund", "https://img.freepik.com/fotos-kostenlos/lokalisiertes-glueckliches-laechelndes-hundeweisser-hintergrund-portrait-4_1562-693.jpg?w=1060&t=st=1700434653~exp=1700435253~hmac=bafea2bf787ea69da171151aa96d55065be5cf1a90fe3fe0542dc6457234e8cc");
        wListe.addWord("Löwe","https://img.freepik.com/fotos-premium/loewe-auf-weiss-in-einem-studio_191971-5368.jpg?size=626&ext=jpg&ga=GA1.1.1094460550.1695850327&semt=ais");
        wListe.addWord("Hai","https://img.freepik.com/fotos-premium/grosser-weisser-hai-das-beruehmte-raubtier-im-ozean-isoliert-auf-weissem-hintergrund-marine-generative-ki_106651-7909.jpg?size=626&ext=jpg&ga=GA1.1.1094460550.1695850327&semt=ais");
        wListe.addWord("Pizza","https://img.freepik.com/fotos-kostenlos/duenn-geschnittene-peperoni-sind-ein-beliebter-pizzabelag-in-pizzerien-im-amerikanischen-stil-isoliert-auf-weissem-hintergrund-stillleben_639032-229.jpg?size=626&ext=jpg&ga=GA1.1.1094460550.1695850327&semt=ais");
        wListe.addWord("Goat","https://img.freepik.com/fotos-premium/digitale-kunst-des-argentinischen-trikots-von-leonel-messi_485374-3880.jpg?size=626&ext=jpg&ga=GA1.1.1094460550.1695850327&semt=ais");
        wListe.addWord("Hantel","https://img.freepik.com/fotos-premium/hanteln-auf-weissem-hintergrund_105428-4885.jpg?size=626&ext=jpg&ga=GA1.1.1094460550.1695850327&semt=ais");

        wLayout.setPic(wT.random().getUrl());
    }

    /**
     * Behandelt Action-Events, die durch Benutzerinteraktionen ausgelöst werden. Implementiert das ActionListener-Interface.
     *
     * @param e Das ActionEvent-Objekt, das die Aktion des Benutzers repräsentiert.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String ac = e.getActionCommand();
        switch(ac) {
            case "input":
                boolean x = wT.checkIgnoreCase(wLayout.getEingabe());
                wLayout.setW(wT.getR(),wT.getR()+wT.getF(), x);
                wLayout.setReset(true);
                try {
                    this.wLayout.setPic(this.wT.random().getUrl());
                } catch (MalformedURLException ex) {
                    JOptionPane.showMessageDialog(wLayout,"Ungültige URL");
                }
                break;
            case "reset":
                wLayout.reset();
                wT = new WortTrainer(wListe, wT.getWortEintrag(), new WortStatistik(0,0));
                wLayout.setReset(false);
                break;
            case "add":
                wLayout.add();
               // try {
                    wListe.addWord(wLayout.getWort(), wLayout.getUrl());
               // } catch (IllegalArgumentException exc) {
                  //  JOptionPane.showMessageDialog(wLayout, exc.getMessage());
               // }
                break;
            case "save":
                try {
                    wSL.speichern();
                } catch (IOException | IllegalArgumentException exc) {
                    JOptionPane.showMessageDialog(wLayout, exc.getMessage());
                }
                break;
            case "load":
                try {
                    wT = wSL.laden();
                } catch (IOException | IllegalArgumentException exc) {
                    JOptionPane.showMessageDialog(wLayout, exc.getMessage());
                    break;
                }
                wLayout.load(wT.getR(), wT.getR()+wT.getF());
                wLayout.setReset(true);
        }
    }

    public static void main(String[] args) throws IOException {
        new WortController();
    }

}
