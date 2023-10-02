package mnegm;

import java.util.Random;

public class WortTrainer {
    private WortListe wordlist;
    private WortEintrag currentwe;


    public WortTrainer(WortListe wordlist, WortEintrag currentwe) {
        this.wordlist = wordlist;
        this.currentwe = currentwe;
    }


    public WortEintrag random() {
        Random r = new Random();
        int index = r.nextInt(wordlist.getLength() - 1);
        return wordlist.getEintragAt(index);
    }

    public WortEintrag getWortEintrag() {
        return currentwe;
    }

    public boolean check(String wort) {
        if (wort.equals(currentwe.getWord()))
            return true;
        return false;
    }

    public boolean checkIgnoreCase(String wort) {
        if (wort.toLowerCase().equals(currentwe.getWord().toLowerCase()))
            return true;
        return false;
    }
}