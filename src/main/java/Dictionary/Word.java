package Dictionary;

public class Word {
    private String word;
    private String definition;

    public Word() {

    }

    public Word(String word, String definition) {
        this.word = word;
        this.definition = definition;
    }

    public void reset() {
        word = null;
        definition = null;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }
}
