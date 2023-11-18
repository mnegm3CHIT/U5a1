package mnegm;

import java.io.*;
import java.nio.file.*;
import java.util.Scanner;

public class WortSL extends IOException {
    private WortTrainer trainer;
    private final String FILENAME = "WortTrainer.txt";
    private String[] liste;

    public WortSL(WortTrainer trainer) {
        this.trainer = trainer;
        liste = trainer.toString().split("\n");
    }

    public void speichern(String filename) throws IOException, IllegalArgumentException {
        File file = new File(filename);
        if(!file.exists()){
            throw new FileNotFoundException("Diese Datei existiert nicht!");
        }
        if(!file.canWrite()){
            throw new IllegalArgumentException("In diese Datei kann nicht geschrieben werden! - Du hast nicht die Berechtigung!");
        }
        try (PrintWriter ops = new PrintWriter(filename)) {
            for (String e : liste) {
                ops.println(e);
            }
        }
    }

    public void speichern() throws IOException {
        speichern(FILENAME);
    }

    public WortTrainer laden(String filename) throws IOException, IllegalArgumentException {
        File file = new File(filename);
        if(!file.exists()){
            throw new FileNotFoundException("Diese Datei existiert nicht!");
        }
        if(!file.canRead()){
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
        String[] s = part[1].split("^[a-zA-Z0-9 ()]+$");

        WortListe wl = new WortListe(1);
        for(String ce : e) {
            String[] teil = ce.split(";");
            if(teil[0].equals("<leer>"))
                wl.addWord(null);
            else
                wl.addWord(teil[0], teil[1]);
        }

        WortStatistik ws = new WortStatistik(Integer.parseInt(s[1]), Integer.parseInt(s[2]));

        return  new WortTrainer(wl, null, ws);
    }

    public WortTrainer laden() throws IOException, IllegalArgumentException {
        return this.laden(FILENAME);
    }
}