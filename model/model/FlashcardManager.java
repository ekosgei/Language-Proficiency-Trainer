package model;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// This Class represents a flashcards manager, that contains a list of all flashcards in a deck.
// It also includes a map of the flashcards, with the gender level as the Key and corresponding Flashcards as the value, 
// in cases of non-gendered languages or words that are not nouns, the Gender is NA
public abstract class FlashcardManager extends Observer {

    protected Set<Flashcard> flashcards;
    protected Map<Gender, Set<Flashcard>> mapOfFlashcards;
    protected int score;
    protected List<Flashcard> seenFlashcards;



    public FlashcardManager() {
        this.flashcards = new HashSet<>();
        this.mapOfFlashcards = new EnumMap<>(Gender.class);
        for (Gender g : Gender.values()) {
            mapOfFlashcards.put(g, new HashSet<>());
        }
        this.seenFlashcards = new ArrayList<>();
        score = 0;
    }

    /*
     * EFFECTS: Adds flashcard to flashcards (Set) and mapOfFlashcards.(map <Gender, Set<Flashcard>>>)
     * MODIFIES: flashcards and mapOfFlashcards
     * 
     */
    public void addFlashcard(Flashcard f) {
        if (f.getClass() == Germ_Flashcard.class) {
            Gender g = ((Germ_Flashcard) f).getGender();
            Set<Flashcard> cards = mapOfFlashcards.get(g);
            cards.add(f);
            mapOfFlashcards.put(g, cards);

        }
        this.flashcards.add(f);

    }
/*
     * EFFECTS: removes given flashcard from  flashcards  and mapOfFlashcards
     * MODIFIES: flashcards, mapOfFlashcards
     * 
     */
    public void removeflashcard(Flashcard f) {
        if (f.getClass() == Germ_Flashcard.class) {
            Gender g = ((Germ_Flashcard) f).getGender();
            Set<Flashcard> cards = mapOfFlashcards.get(g);
            cards.remove(f);
            mapOfFlashcards.put(g, cards);

        }
        this.flashcards.remove(f);

    }

    // return list of flashcards in deck
    public Set<Flashcard> getFlashcards() {
        return this.flashcards;
    }

    public List<Flashcard> getSeenFlashcards() {
        return  this.seenFlashcards;
     }

    /*REQUIRES: card provided is not null
     * EFFECTS: If answer provided is correct, then the score is increased by 1.
     * 
     */

    public void update (Flashcard card, String userAnswer) {
        String translation = card.getTranslation();
        if ((userAnswer).equalsIgnoreCase(translation)) {
            score++;           
        }
        seenFlashcards.add(card);
    }
    

    /*
     * EFFECTS: Returns the next Flashcard to be asked from set of Flashcards.
     * MODIFIES: seenFlashcards
     * 
     */protected abstract Flashcard nextFlashcard();

     public int getScore() {
        return this.score;
     }


    

    /*
     * EFFECTS: resets quiz by removing all cards from seenFlashcards and setting the score to 0
     * MODIFIES: seenFlashcards
     */

     public void resetDeck() {
       this.seenFlashcards.clear();
       this.score = 0;
     }



    
}
