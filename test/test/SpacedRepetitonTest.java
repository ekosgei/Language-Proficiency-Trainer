package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Flashcard;
import model.Gender;
import model.Germ_Flashcard;
import model.SpacedRepetition;

public class SpacedRepetitonTest {

    private Flashcard f1;
    private Flashcard f2;
    private Flashcard f3;

    private SpacedRepetition spacedRepetition;

    @BeforeEach
    public void runBefore() {

        f1 = new Germ_Flashcard("Buch", "book", Gender.NEUTER);
        f2 = new Germ_Flashcard("Schlüssel", "Keys", Gender.MASCULINE);
        f3 = new Germ_Flashcard("Versicherung", "Insurance", Gender.FEMININE);

        spacedRepetition = new SpacedRepetition();

    }

    @Test
    public void testnextFlashcardOneCard() {
        spacedRepetition.addFlashcard(f1);
        assertEquals(f1, spacedRepetition.nextFlashcard());
        assertEquals(1, spacedRepetition.getFlashcards().size());
     

    }

    @Test
    public void testnextFlashcardFailedAttempt() {
        spacedRepetition.addFlashcard(f1);
        assertEquals(f1, spacedRepetition.nextFlashcard());
        spacedRepetition.update(f1, "key");
        assertEquals(0, spacedRepetition.getSeenFlashcards().size());
        assertEquals(f1, spacedRepetition.nextFlashcard());
    }

 /*   @Test (Not able to test user answer/ set)
    public void testnextFlashcardPassedAttempt() {
        assertEquals(null, spacedRepetition.getCurrentFlashcard());
        spacedRepetition.addFlashcard(f1);
        assertEquals(f1, spacedRepetition.nextFlashcard());
        assertEquals(f1, spacedRepetition.getCurrentFlashcard());
        assertEquals(1, spacedRepetition.getSeenFlashcards().size());

    }
*/

  /*  @Test
    public void testnextFlashcardMultipleCards() {
    
        spacedRepetition.addFlashcard(f1);
        spacedRepetition.addFlashcard(f2);
        spacedRepetition.addFlashcard(f3);
            assertEquals(3,spacedRepetition.getFlashcards().size());
            spacedRepetition.nextFlashcard();
            spacedRepetition.nextFlashcard();
            spacedRepetition.nextFlashcard();
            assertEquals(3,spacedRepetition.getSeenFlashcards().size());
        }
*/      
    }


