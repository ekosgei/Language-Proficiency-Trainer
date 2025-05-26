package model;

import java.util.Locale.Category;

// This class represents a single flashcard containing a word and its translation.
// It also includes the word's difficulty level and  part of speech.
public class Flashcard {

    private String word;
    private String translation;
    private Difficulty difficulty;
    private PartOfSpeech partOfSpeech;

    public Flashcard(String w, String tr, Difficulty dif, PartOfSpeech p) {
        this.word = w;
        this.translation = tr;
        this.difficulty = dif;
        this.partOfSpeech = p;

    }

    public String getWord() {
        return this.word;
    }

    public String getTranslation() {
        return this.translation;
    }

    public Difficulty getDifficulty() {
        return this.difficulty;
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

    public void setDifficulty(Difficulty d) {
        this.difficulty = d;
    }

    public void setPartOfSpeech(PartOfSpeech p) {
        this.partOfSpeech = p;
    }

}
