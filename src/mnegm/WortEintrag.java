package mnegm;

import javax.swing.*;
public class WortEintrag {
    private String word;
    private String url;


    public WortEintrag(String word, String url) {
        this.setWord(word);
        this.setUrl(url);
    }

    public void setWord(String word) {
        try {
            if(word != null && word.length() >= 2)
                this.word = word;
            else
                throw new IllegalArgumentException();
        }
        catch (IllegalArgumentException e){
            JOptionPane.showMessageDialog(null, "Ungültiges Wort");
        }
    }

    public void setUrl(String url) {
        try{
            if(checkURL(url))
                this.url = url;
            else
                throw new IllegalArgumentException();
        }
        catch(IllegalArgumentException e){
            JOptionPane.showMessageDialog(null, "Ungültige Url");
        }
    }

    public static boolean checkURL(String url) {
        return ((url.startsWith("https://") || url.startsWith("http://")) && (url.contains("//[a-zA-Z]\\.([a-zA-Z])")));
    }

    public String getWord() {
        return word;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "WortEintrag{" + "word='" + word + '\'' + "; url='" + url + '\'' + '}';
    }
}
