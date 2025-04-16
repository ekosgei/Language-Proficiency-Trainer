import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

// This Class represents a flashcards manage, that contains a list of all flashcards in a deck.
// It also includes a map of the flashcards, with the new Word as the Key and corresponding Flashcard as the value.
public class FlashcardManager {

    private List<Flashcard> flashcards;
    private Map<Difficulty, Flashcard> mapOfFlashcards;

    public FlashcardManager() {
        this.flashcards = new ArrayList<>();
        this.mapOfFlashcards = new HashMap<>();

    }

    /*
     * EFFECTS: Adds flashcard to list.
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
    
    /*
     * EFFECTS: Adds flashcard to Map based on difficulty.
     * MODIFIES: mapOfFlashcards
     * REQUIRES: Flashcard not duplicated
     */

    public void addFlashcardToMap(Flashcard f) {

    }



}
