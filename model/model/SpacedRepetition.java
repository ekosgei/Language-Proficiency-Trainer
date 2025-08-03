package model;

public class SpacedRepetition extends FlashcardManager {

    public SpacedRepetition() {
        super();
    }

    /*
     *
     * EFFECTS: provides the nextflashcard in set of flashcards and takes note of
     * the current flashcard. If user provides an incorrect answer, current flashcard is not added to  
     * seenFlashcardsa
     */
    @Override
    public Flashcard nextFlashcard() {
        Flashcard next = null;

        for (Flashcard card : flashcards) {
            next = card;
            if (!seenFlashcards.contains(card)) {
                break;
            }

        }
       // currentFlashcard = next;
        return next;
    }

    public Flashcard getNextFlashcard() {
        return nextFlashcard();
    }

    /*
     * MODIFIES: SeenFlashCards
     * EFFECTS: If user provides the correct answer, the current flashcard is
     * added to the SeenFlashcards and score increased by 1.
     * 
     */
    @Override
    public void update(Flashcard card, String userAnswer) {
        String translation = card.getTranslation();
        if ((userAnswer).equalsIgnoreCase(translation)) {
            score++;
            seenFlashcards.add(card);
            
        }
    }

}
