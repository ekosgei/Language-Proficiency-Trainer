/*package model;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class FlashcardGenerator extends FlashcardManager {

    // private FlashcardManager flashcardManager;
    private int correctAnswers;
    // private Set<Flashcard> shownCards = new HashSet<>();
    private static int MEDIUM_THRESHOLD = 3;
    private static int HARD_THRESHOLD = 9;

    public FlashcardGenerator() {
        super();
        this.correctAnswers = 0;
    }

    /*
     * EFFECTS: Prints a word to be translated starting with words marked as easy.
     * Once three easy words (or all available easy words, if fewer than three) have
     * been answered correctly, it moves on to words from the medium category.
     * After six medium words (or all available medium words) have been answered
     * correctly,the method proceeds to the hard category, where all hard words will
     * be asked during the current round.
     * Correct answers will be increased once the answer given by user is correct.
     * if There are no more cards in deck, "All cards in Deck have been played"
     * MODIFIES: correctAnswers;
     * REQUIRES: Deck Have atleast 1 flashcard.
     

    public Flashcard nextFlashCard() {
        Difficulty level = getCurrentLevel();
        List<Flashcard> cards = getCardsByDifficulty(level);
        Random rand = new Random();

        cards.get(rand.nextInt(cards.size()));

        return cards.get(rand.nextInt(cards.size()));
    }

    /*
     * EFFECTS: Tracts the amount of correctAnswers received. When player answers
     * correctly
     * on the first try
     * they get 3 correctAnswers, the second time they get 2 correctAnswers and
     * third time they
     * receive 1 point. Player receives 0 otherwise.
     * MODIFIES: correctAnswers
     * 
     
    public void addcorrectAnswers() {
        this.correctAnswers++;
    }

  

    public int getcorrectAnswers() {
        return this.correctAnswers;
    }

   /*
    * EFFECTS: returns the current level of difficulty based on the player's points. 
    If the level does not have any cards, the method returns a level that has cards.
    
    public Difficulty getCurrentLevel() {
        Difficulty level = null;
    
        if (correctAnswers < MEDIUM_THRESHOLD && !getCardsByDifficulty(Difficulty.EASY).isEmpty()) {
            level = Difficulty.EASY;
        } else if (correctAnswers < HARD_THRESHOLD && !getCardsByDifficulty(Difficulty.MEDIUM).isEmpty()) {
            level = Difficulty.MEDIUM;
        } else {
            level = Difficulty.HARD;
        }

        if (getCardsByDifficulty(level).isEmpty()) { 
            List<Flashcard> cards = getCardsByDifficulty(level);  
            for (Difficulty d : Difficulty.values()) { 
                cards = getCardsByDifficulty(d);
                if (!cards.isEmpty()) {
                    return d;
                }
            }
        }
        return level;
    }
}
*/