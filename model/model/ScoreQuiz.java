package model;

public class ScoreQuiz extends FlashcardManager {

    /*
     * EFFECTS: A random flashcard is returned, and added to the seenFalshcards. 
     * When all flashcards are seen then null is returned. 
     * 
     */

   
    public ScoreQuiz () {
        super();

    }
    @Override
    public Flashcard nextFlashcard() {

        Flashcard next = null;

        for (Flashcard card : flashcards) {
            next = card;
            if (!seenFlashcards.contains(card)) {
                seenFlashcards.add(next);
                break;
            }

        }
        return next;

    }

    public Flashcard getNextFlashcard() {
        return nextFlashcard();
    }

}
