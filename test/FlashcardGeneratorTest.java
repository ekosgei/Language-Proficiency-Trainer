package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Difficulty;
import model.Flashcard;
import model.FlashcardGenerator;
import model.FlashcardManager;
import model.PartOfSpeech;

public class FlashcardGeneratorTest {

    private FlashcardGenerator generator;
    private Flashcard f1;
    private Flashcard f2;
    private Flashcard f3;
    private Flashcard f4;
    private Flashcard f5;
    private Flashcard f6;
    private Flashcard f7;
    private Flashcard f8;


     @BeforeEach
    public void runBefore() {

        f1 = new Flashcard("Buch", "book", Difficulty.EASY, PartOfSpeech.NOUN);
        f2 = new Flashcard("Schlüssel", "Keys", Difficulty.EASY, PartOfSpeech.NOUN);
        f3 = new Flashcard("Versicherung", "Insurance", Difficulty.MEDIUM, PartOfSpeech.NOUN);
        f4 = new Flashcard("essen", "to eat", Difficulty.MEDIUM, PartOfSpeech.VERB);
        f5 = new Flashcard("langsam", "slowly", Difficulty.MEDIUM, PartOfSpeech.ADVERB);
        f6 = new Flashcard("ausgezeichnet", "excellent", Difficulty.MEDIUM, PartOfSpeech.ADJECTIVE);
        f7 = new Flashcard("schnell", "fast", Difficulty.HARD, PartOfSpeech.ADVERB);
        f8 = new Flashcard("Rucken", "back", Difficulty.HARD, PartOfSpeech.NOUN);
      
        generator = new FlashcardGenerator();
       
    }

  @Test
    public void testNextFlashcardOneCard() {
        generator.addFlashcard(f1);
        assertEquals(0,generator.getcorrectAnswers());
        assertEquals(Difficulty.EASY,generator.getCurrentLevel());
        assertEquals(f1,generator.nextFlashCard());
    }


    @Test
    public void testNextFlashcardOneMediumCard() {
        generator.addFlashcard(f4);
        assertEquals(0,generator.getcorrectAnswers());
        assertEquals(Difficulty.MEDIUM,generator.getCurrentLevel());
        assertEquals(f4,generator.nextFlashCard());
    }

    @Test
    public void testNextFlashcardOneHardCard() {
        generator.addFlashcard(f8);
        assertEquals(0,generator.getcorrectAnswers());
        assertEquals(Difficulty.HARD,generator.getCurrentLevel());
        assertEquals(f8,generator.nextFlashCard());
    }
 
    @Test
    public void testNextFlashcardOneForEachLevel() {
        generator.addFlashcard(f1);
        generator.addFlashcard(f8);
        generator.addFlashcard(f4);
        assertEquals(f1,generator.nextFlashCard());
        generator.addcorrectAnswers();
        generator.addcorrectAnswers();
        generator.addcorrectAnswers();
        assertEquals(f4,generator.nextFlashCard());   
        generator.addcorrectAnswers();
        generator.addcorrectAnswers();
        generator.addcorrectAnswers();
        generator.addcorrectAnswers();
        generator.addcorrectAnswers();
        generator.addcorrectAnswers();
        assertEquals(f8,generator.nextFlashCard());
    


    }

    @Test 
    public void testGetCurrentLevelOnlyEasy() {
        generator.addFlashcard(f1);
        assertEquals(0,generator.getcorrectAnswers());
        assertEquals(Difficulty.EASY, generator.getCurrentLevel());
    }

    @Test 
    public void testGetCurrentLevelOnlyMedium() {
        generator.addFlashcard(f4);
        assertEquals(0,generator.getcorrectAnswers());
        assertEquals(Difficulty.MEDIUM, generator.getCurrentLevel());
    }
    @Test 
    public void testGetCurrentLevelOnlyHard() {
        generator.addFlashcard(f8);
        assertEquals(0,generator.getcorrectAnswers());
        assertEquals(Difficulty.HARD, generator.getCurrentLevel());
    }

    @Test
    public void testGetCurrentLevelEmptyLevel() {
    generator.addcorrectAnswers();
    generator.addcorrectAnswers();
    generator.addcorrectAnswers();
    generator.addcorrectAnswers();
    generator.addFlashcard(f1);
    generator.addFlashcard(f8);
   
    assertEquals(4, generator.getcorrectAnswers());
    assertEquals(Difficulty.HARD, generator.getCurrentLevel());


}

@Test
public void testisAnswerCorrectTrueSameCase() {
   assertTrue(generator.isAnswerCorrect(f1, "book"));
   assertEquals(1, generator.getcorrectAnswers());
}

@Test 
public void testisAnswerCorrectTrueDifferentCase() {
    assertTrue(generator.isAnswerCorrect(f1, "BooK"));
    assertEquals(1, generator.getcorrectAnswers());    
}

@Test 
public void testisAnswerCorrectFalse() {
    assertFalse(generator.isAnswerCorrect(f1, "Key"));
    assertEquals(0, generator.getcorrectAnswers());    
}

}
