package mnegm;

public class WortListe {
    private WortEintrag[] woerter;

    public WortListe(int a) {
        if(a <= 0)
            a = 2;
        this.woerter = new WortEintrag[a];
    }

    public void addWord(String word,String url) {
        for (int i = 0; i < woerter.length; i++){
            if(woerter[i].getWord() == null && woerter[i].getUrl() == null){
                woerter[i].setWord(word);
                woerter[i].setUrl(url);
            }
        }
    }
    public WortEintrag getEintragAt(int index){
        if(!(woerter.length > index)) throw new IndexOutOfBoundsException("Index out of bounds");
        return woerter[index];
    }
    public int getLength() {
        return woerter.length;
    }

    public boolean deleteWord(String word){
        for (int i = 0; i < woerter.length; i++){
            if(woerter[i].getWord().equals(word)){
                woerter[i] = null;
                woerter[i] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String text = "";
        for (int i = 0; i < woerter.length; i++){
            if(woerter[i] == null)
                text += "<leer>\n";
            else
                text+= woerter[i].toString() + "\n";
        }
        return text;
    }
}
