package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import model.Flashcard;
import model.Gender;
import model.Germ_Flashcard;
import model.ScoreQuiz;

public class ScoreQuizTest {

    private ScoreQuiz scoreQuiz;
    private Flashcard f1;
    private Flashcard f2;
    private Flashcard f3;
    // private Flashcard f4;
    // private Flashcard f5;
    // private Flashcard f6;
    // private Flashcard f7;
    // private Flashcard f8;


     @BeforeEach
    public void runBefore() {

        f1 = new Germ_Flashcard("Buch", "book", Gender.NEUTER);
        f2 = new Germ_Flashcard("Schlüssel", "Keys",Gender.MASCULINE);
        f3 = new Germ_Flashcard("Versicherung", "Insurance", Gender.FEMININE);
        // f4 = new Flashcard("essen", "to eat", Difficulty.MEDIUM, PartOfSpeech.VERB);
        // f5 = new Flashcard("langsam", "slowly", Difficulty.MEDIUM, PartOfSpeech.ADVERB);
        // f6 = new Flashcard("ausgezeichnet", "excellent", Difficulty.MEDIUM, PartOfSpeech.ADJECTIVE);
        // f7 = new Flashcard("schnell", "fast", Difficulty.HARD, PartOfSpeech.ADVERB);
        // f8 = new Flashcard("Rucken", "back", Difficulty.HARD, PartOfSpeech.NOUN);
      
        scoreQuiz = new ScoreQuiz();
       
    }

  @Test
    public void testnextFlashcardOneCard() {
        scoreQuiz.addFlashcard(f1);
        assertEquals(f1,scoreQuiz.nextFlashcard());
        assertEquals(1, scoreQuiz.getSeenFlashcards().size());
        assertEquals(1, scoreQuiz.getFlashcards().size());

    }


    @Test
    public void testnextFlashcardMultipleCards() {
        scoreQuiz.addFlashcard(f1);
        scoreQuiz.addFlashcard(f2);
        scoreQuiz.addFlashcard(f3);
        assertEquals(3,scoreQuiz.getFlashcards().size());
        scoreQuiz.nextFlashcard();
        assertEquals(1, scoreQuiz.getSeenFlashcards().size());
        scoreQuiz.nextFlashcard();
        assertEquals(2, scoreQuiz.getSeenFlashcards().size());
        scoreQuiz.nextFlashcard();
        assertEquals(3, scoreQuiz.getSeenFlashcards().size());
        assertEquals(3, scoreQuiz.getFlashcards().size());
    }
}

//     @Test
//     public void testnextFlashcardOneHardCard() {
//         generator.addFlashcard(f8);
//         assertEquals(0,generator.getcorrectAnswers());
//         assertEquals(Difficulty.HARD,generator.getCurrentLevel());
//         assertEquals(f8,generator.nextFlashcard());
//     }
 
//     @Test
//     public void testnextFlashcardOneForEachLevel() {
//         generator.addFlashcard(f1);
//         generator.addFlashcard(f8);
//         generator.addFlashcard(f4);
//         assertEquals(f1,generator.nextFlashcard());
//         generator.addcorrectAnswers();
//         generator.addcorrectAnswers();
//         generator.addcorrectAnswers();
//         assertEquals(f4,generator.nextFlashcard());   
//         generator.addcorrectAnswers();
//         generator.addcorrectAnswers();
//         generator.addcorrectAnswers();
//         generator.addcorrectAnswers();
//         generator.addcorrectAnswers();
//         generator.addcorrectAnswers();
//         assertEquals(f8,generator.nextFlashcard());
    


//     }

//     @Test 
//     public void testGetCurrentLevelOnlyEasy() {
//         generator.addFlashcard(f1);
//         assertEquals(0,generator.getcorrectAnswers());
//         assertEquals(Difficulty.EASY, generator.getCurrentLevel());
//     }

//     @Test 
//     public void testGetCurrentLevelOnlyMedium() {
//         generator.addFlashcard(f4);
//         assertEquals(0,generator.getcorrectAnswers());
//         assertEquals(Difficulty.MEDIUM, generator.getCurrentLevel());
//     }
//     @Test 
//     public void testGetCurrentLevelOnlyHard() {
//         generator.addFlashcard(f8);
//         assertEquals(0,generator.getcorrectAnswers());
//         assertEquals(Difficulty.HARD, generator.getCurrentLevel());
//     }

//     @Test
//     public void testGetCurrentLevelEmptyLevel() {
//     generator.addcorrectAnswers();
//     generator.addcorrectAnswers();
//     generator.addcorrectAnswers();
//     generator.addcorrectAnswers();
//     generator.addFlashcard(f1);
//     generator.addFlashcard(f8);
   
//     assertEquals(4, generator.getcorrectAnswers());
//     assertEquals(Difficulty.HARD, generator.getCurrentLevel());


// }

// @Test
// public void testisAnswerCorrectTrueSameCase() {
//    assertTrue(generator.isAnswerCorrect(f1, "book"));
//    assertEquals(1, generator.getcorrectAnswers());
// }

// @Test 
// public void testisAnswerCorrectTrueDifferentCase() {
//     assertTrue(generator.isAnswerCorrect(f1, "BooK"));
//     assertEquals(1, generator.getcorrectAnswers());    
// }

// @Test 
// public void testisAnswerCorrectFalse() {
//     assertFalse(generator.isAnswerCorrect(f1, "Key"));
//     assertEquals(0, generator.getcorrectAnswers());    
// }

// }
