package model;

/*
 * A class representing a Flashcard with a German Word and its English Transaltion
 * It has the addition of the gender of the noun.
 */
public class Germ_Flashcard extends Flashcard {

    private Gender gender;

    public Germ_Flashcard(String w, String tr, Gender g) {
        super(w, tr);
        this.gender = g;

    }

    public Gender getGender() {
        return this.gender;
    }

    public void setGender(Gender g) {
        this.gender = g;
    }

}
