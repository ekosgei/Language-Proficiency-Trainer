public class FlashcardGenerator {

    private FlashcardManager flashcardManager;
    private int points;

    public FlashcardGenerator() {
        this.flashcardManager = new FlashcardManager();
        this.points = 0;
    }

    /*
     * EFFECTS: Prints a word to be translated, selected at random, starting with
     * words marked as easy.
     * Once two easy words (or all available easy words, if fewer than two) have
     * been answered correctly, it moves on to words from the medium category.
     * After four medium words (or all available medium words) have been answered
     * correctly,the method proceeds to the hard category, where all hard words will
     * be asked
     * during the current round.
     * MODIFIES: points;
     * REQUIRES: Deck Have atleast 1 flashcard.
     */

    public String nextFlashCard() {
        return "";
    }

    /*
     * EFFECTS: Tracts the amount of points received. When player answers correctly
     * on the first try
     * they get 3 points, the second time they get 2 points and third time they
     * receive 1 point. Player receives 0 otherwise.
     * MODIFIES: points
     * 
     */
    public void addpoints(int p) {

    }


    
   /* EFFECTS: Check whether the answer provided matched the tranlations of a word
    * 
    */

    public boolean isAnswerCorrect(String a) {
        return false;
    }


}
