package model;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// This Class represents a flashcards manager, that contains a list of all flashcards in a deck.
// It also includes a map of the flashcards, with the difficulty level as the Key and corresponding Flashcards as the value.
public class FlashcardManager {

    private List<Flashcard> flashcards;
    private Map<Difficulty, List<Flashcard>> mapOfFlashcards;

    public FlashcardManager() {
        this.flashcards = new ArrayList<>();
        this.mapOfFlashcards = new EnumMap<>(Difficulty.class);
        for (Difficulty d : Difficulty.values()) {
            mapOfFlashcards.put(d,new ArrayList<>());
        }

    }

    /*
     * EFFECTS: Adds flashcard to list and map
     * MODIFIES: List
     * REQUIRES: Flashcard not duplicated
     */
    public void addFlashcard(Flashcard f) {
        if (!flashcards.contains(f)) {
            this.flashcards.add(f);
            List<Flashcard> cards = mapOfFlashcards.get(f.getDifficulty());
            cards.add(f);
            mapOfFlashcards.put(f.getDifficulty(), cards);
        }
        
    }

    public void removeflashcard(Flashcard f) {
        this.flashcards.remove(f);
        List<Flashcard> cards = mapOfFlashcards.get(f.getDifficulty());
        cards.remove(f);
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
        return flashcards;
    }

    // return list of flashcards in deck based on difficulty
    public List<Flashcard> getCardsByDifficulty(Difficulty d) {
        return mapOfFlashcards.get(d);
    }

}
