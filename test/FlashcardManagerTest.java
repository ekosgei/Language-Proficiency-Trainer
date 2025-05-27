package test;

import model.Flashcard;
import model.FlashcardManager;
import model.PartOfSpeech;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Difficulty; // If you're using the enum in the test

public class FlashcardManagerTest {

    private Flashcard f1;
    private Flashcard f2;
    private Flashcard f3;
    private Flashcard f4;
    private Flashcard f5;
    private Flashcard f6;

    private FlashcardManager manager;

    @BeforeEach
    public void runBefore() {

        f1 = new Flashcard("Buch", "book", Difficulty.EASY, PartOfSpeech.NOUN);
        f2 = new Flashcard("Schlüssel", "Keys", Difficulty.MEDIUM, PartOfSpeech.NOUN);
        f3 = new Flashcard("Versicherung", "Insurance", Difficulty.HARD, PartOfSpeech.NOUN);
        f4 = new Flashcard("essen", "to eat", Difficulty.EASY, PartOfSpeech.VERB);
        f5 = new Flashcard("langsam", "slowly", Difficulty.MEDIUM, PartOfSpeech.ADVERB);
        f6 = new Flashcard("ausgezeichnet", "excellent", Difficulty.HARD, PartOfSpeech.ADJECTIVE);
        manager = new FlashcardManager();
    }

    @Test
    public void testAddOneFlashcard() {
        manager.addFlashcard(f1);
        List<Flashcard> flashcards = manager.getFlashcards();
        assertEquals(flashcards.size(), 1);
        assertEquals(f1, flashcards.get(0));
        List<Flashcard> cardsByDiificulty = manager.getCardsByDifficulty(Difficulty.EASY);
        assertEquals(1, cardsByDiificulty.size());
        cardsByDiificulty = manager.getCardsByDifficulty(Difficulty.MEDIUM);
        assertEquals(0, cardsByDiificulty.size());

    }

    public void testAddMultipleFlashcards() {

        manager.addFlashcard(f1);
        manager.addFlashcard(f2);
        manager.addFlashcard(f3);
        manager.addFlashcard(f4);
        manager.addFlashcard(f5);
        manager.addFlashcard(f6);

        List<Flashcard> flashcards = manager.getFlashcards();
        assertEquals(flashcards.size(), 6);
        List<Flashcard> cardsByDiificulty = manager.getCardsByDifficulty(Difficulty.EASY);
        assertEquals(2, cardsByDiificulty.size());
        cardsByDiificulty = manager.getCardsByDifficulty(Difficulty.MEDIUM);
        assertEquals(2, cardsByDiificulty.size());
        cardsByDiificulty = manager.getCardsByDifficulty(Difficulty.HARD);
        assertEquals(2, cardsByDiificulty.size());

    }

    @Test
    public void testAddDuplicates() {
        manager.addFlashcard(f1);
        manager.addFlashcard(f1);
        List<Flashcard> flashcards = manager.getFlashcards();
        assertEquals(flashcards.size(), 1);
        assertEquals(f1, flashcards.get(0));
        List<Flashcard> cardsByDiificulty = manager.getCardsByDifficulty(Difficulty.EASY);
        assertEquals(1, cardsByDiificulty.size());
    }

    @Test
    public void testRemoveFlashcard() {
        manager.addFlashcard(f6);
        manager.removeflashcard(f6);
        List<Flashcard> flashcards = manager.getFlashcards();
        assertEquals(flashcards.size(), 0);
        List<Flashcard> cardsByDiificulty = manager.getCardsByDifficulty(Difficulty.EASY);
        assertEquals(0, cardsByDiificulty.size());
    }
}
