package mnegm.controller;

import mnegm.model.WortListe;
import mnegm.model.WortSL;
import mnegm.model.WortStatistik;
import mnegm.model.WortTrainer;
import mnegm.view.WortFrame;
import mnegm.view.WortLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class WortController implements ActionListener {
    private WortLayout wLayout;
    private WortFrame wF;
    private WortSL wSL;
    private WortTrainer wT;
    private WortListe wListe;

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

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) throws IOException {
        new WortController();
    }

}
