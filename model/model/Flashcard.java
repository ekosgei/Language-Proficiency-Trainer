package model;

// This abstract class represents a general flashcard containing a word and its translation.
// It also includes the word's GENDER level and  part of speech.
public abstract class Flashcard {

    protected String word;
    protected String translation;
    protected PartOfSpeech partOfSpeech;


    public Flashcard(String w, String tr) {
        this.word = w;
        this.translation = tr;
        this.partOfSpeech = PartOfSpeech.NOUN;

    }

    public String getWord() {
        return this.word;
    }

    public String getTranslation() {
        return this.translation;
    }

  

    public PartOfSpeech getPartOfSpeech() {
        return this.partOfSpeech;
    }

    public void setWord(String w) {
        this.word = w;
    }

    public void setTranslation(String s) {
        this.translation = s;
    }

   
    public void setPartOfSpeech(PartOfSpeech p) {
        this.partOfSpeech = p;
    }

}
