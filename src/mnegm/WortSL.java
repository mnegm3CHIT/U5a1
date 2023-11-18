package mnegm;

import java.io.*;
import java.nio.file.*;
import java.util.Scanner;

public class WortSL extends IOException {
    private WortTrainer trainer;
    private String filename = "WortTrainer.txt";
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
        speichern(this.filename);
    }

    public WortTrainer laden(String filename) {

    }
}