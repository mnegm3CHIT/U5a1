package mnegm;

import java.io.*;
import java.nio.file.*;
import java.util.Scanner;

public class WortSL extends IOException {
    private WortTrainer trainer;
    public void speichern(String dataPath, String filename) throws IOException {
        Path path = Paths.get(dataPath);

        if (Files.exists(path)) {
            try (PrintWriter outputStream = new PrintWriter(filename)) {
                outputStream.println(trainer.toString());
            }
        } else {
            System.out.println("DataPath is incorrect!");
        }
    }
    public void speichern() throws IOException {
        speichern("Downloads", "Worttrainer.txt");
    }

    public void laden(String dataPath, String filename) throws IOException{
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
    public void laden(){

    }
}