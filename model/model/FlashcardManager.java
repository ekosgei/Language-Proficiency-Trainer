package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// This Class represents a flashcards manager, that contains a list of all flashcards in a deck.
// It also includes a map of the flashcards, with the difficulty level as the Key and corresponding Flashcards as the value.
public class FlashcardManager {

    private List<Flashcard> flashcards;
    private Map<Difficulty, Flashcard> mapOfFlashcards;

    public FlashcardManager() {
        this.flashcards = new ArrayList<>();
        this.mapOfFlashcards = new HashMap<>();

    }

    /*
     * EFFECTS: Adds flashcard to list and map
     * MODIFIES: List
     * REQUIRES: Flashcard not duplicated
     */
    public void addFlashcard(Flashcard f) {
        if (flashcards.contains(f)) {
            this.flashcards.add(f);
        }
    }

    public void removeflashcard(Flashcard f) {
        this.flashcards.remove(f);
    }

    // /*
    // * EFFECTS: Adds flashcard to Map based on difficulty.
    // * MODIFIES: mapOfFlashcards
    // * REQUIRES: Flashcard not duplicated
    // */

    // public void addFlashcardToMap(Flashcard f) {

    // }

    // return list of flashcards in deck
    public List<Flashcard> getFlashcards() {
        return new ArrayList<Flashcard>();
    }

    // return set of flashcards in deck based on difficulty
    public Set<Flashcard> getSetOfFlashcard(Difficulty d) {
        return new HashSet<Flashcard>();
    }

}
