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

        public void speichern(String filename) throws IOException {
            try (PrintWriter ops = new PrintWriter(filename)) {
                for (String e : liste) {
                    ops.println(e);
                }
            }
        }

        public void speichern() throws IOException {
            speichern(this.filename);
        }

        public void laden(String dataPath, String filename) throws IOException {
            Path path = Paths.get(dataPath);

            if (Files.exists(path)) {
                try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(filename)))) {
                    while (scanner.hasNext()) {
                    }
                }
            } else {
                System.out.println("DataPath is incorrect!");
            }
        }
    }