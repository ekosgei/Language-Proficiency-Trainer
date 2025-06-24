package ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.sound.midi.Track;

import org.junit.After;

import model.Difficulty;
import model.Flashcard;
import model.FlashcardGenerator;
import model.FlashcardManager;
import model.PartOfSpeech;

public class LanguageProficiencyTrainerApp {

    /*
     * As a user I want to be able to:
     * 1. Add and remove Words from a deck
     * 2. Categorize my deck into parts of speech such as Nouns and Adjectives
     * 3. Categorize my deck into level of difficulty such as Easy and Hard
     * 4. Track my engagement with the material
     * 5. Have difficulty increase based on correctness
     * 6. After three tries of answering, have the correct answer shown to me
     */

    /*
     * EFFECTS: Allows user to add and remove words from Deck
     * MODIFIES: listofFlashcard, mapofFlashcards
     */

    /*
     * EFFECTS: Displays a word to be translated
     * 
     */

    /*
     * EFFECTS: Allows user to proved translation of given word
     * 
     */

    // Bank teller application

    private FlashcardGenerator cardGenerator;
    // private sav;
    private Scanner input;
    private List<Flashcard> viewedFlashcards;

    // EFFECTS: runs the teller application
    public LanguageProficiencyTrainerApp() {
        runLanguageApp();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runLanguageApp() {
        boolean keepGoing = true;
        String command = null;

        init();

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }

        System.out.println("\nGoodbye!");
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("a")) {
            doAddFlashcard();
        } else if (command.equals("r")) {
            doRemoveFlashcard();
        } else if (command.equals("s")) {
            doStartQuiz();
            // } else if (command.equals("e")) {
            // doEndQuiz();
        } else if (command.equals("v")) {
            doViewVocabularyList();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    // MODIFIES: this
    // EFFECTS: initializes accounts
    private void init() {
        cardGenerator = new FlashcardGenerator();
        viewedFlashcards = new ArrayList<>();
        input = new Scanner(System.in);
        input.useDelimiter("\r?\n|\r");
    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\ta -> add new word to deck ");
        System.out.println("\tr -> remove word from deck ");
        System.out.println("\ts -> Start Quiz");
        System.out.println("\tv -> View Vocabulary List");
        // System.out.println("\te -> End Quiz");
        System.out.println("\tq -> quit");
    }

    // MODIFIES: this
    // EFFECTS: conducts a deposit transaction
    private void doAddFlashcard() {
        System.out.println("Provide new word: ");
        String word = input.next();

        System.out.println("Provide its translation: ");
        String translation = input.next();

        System.out.println("How difficult is the word? (Easy, Medium, Hard): ");
        Difficulty difficulty = Difficulty.valueOf(input.next().toUpperCase());

        System.out.println("To which Part of Speech does the word belong to? (Noun,Verb,Adjective or Adverb)");
        PartOfSpeech partOfSpeech = PartOfSpeech.valueOf(input.next().toUpperCase());

        Flashcard card = new Flashcard(word, translation, difficulty, partOfSpeech);
        cardGenerator.addFlashcard(card);
    }

    // MODIFIES: this
    // EFFECTS: conducts a withdraw transaction
    private void doRemoveFlashcard() {
        System.out.print("Enter word you wish to remove from deck: ");
        String card = input.nextLine();
        List<Flashcard> cards = cardGenerator.getFlashcards();
        Boolean isThere = false;

        for (Flashcard f : cards) {
            if (card.equals(f)) {
                cardGenerator.removeflashcard(f);
                isThere = true;
            }

            if (!isThere)
                System.out.println("Error: Word not found in deck");
        }

    }

    // MODIFIES: this
    // EFFECTS: conducts a transfer transaction
    private void doStartQuiz() {
        while (!allWordsInDeckAsked()) {
            Flashcard card = cardGenerator.nextFlashCard();
            viewedFlashcards.add(card);
            System.out.println("Translate " + card.getWord());
            String translation = input.next();
            Boolean score = cardGenerator.isAnswerCorrect(card, translation);


            if (score) {
                System.out.println("Correct!");
            } else {
                System.out.println("Close! The correct translation is " + card.getTranslation());
            }

        }
    }
/*
 * EFFECTS: Helper method that returns true when all words in the deck have been asked during the quiz
 * 
 */
    private Boolean allWordsInDeckAsked() {
        List<Flashcard> cards = cardGenerator.getFlashcards();
      return viewedFlashcards.size()> 1 && viewedFlashcards.size() == cards.size();
       
    }


    /*
     * Effects : Displays a list of all new words in the deck and their translation
     */
    private void doViewVocabularyList() {
        List<Flashcard> cards = cardGenerator.getFlashcards();
        System.out.println("Vocabulary List (Word + Translation");
        for (Flashcard card : cards) {
            System.out.println(card.getWord() + "- " + card.getTranslation());
        }

    }

    // Changed return of NextFlashcard to flashcard making this helper methos
    // irrelevant for now.
    // private Flashcard getFlashcard(String word) {
    // List<Flashcard> cards = cardGenerator.getFlashcards();
    // for (Flashcard card : cards) {
    // if (card.getWord().equalsIgnoreCase(word)) {
    // return card;
    // }
    // }
    // return null;

}

/*
 * private void doEndQuiz() {
 * 
 * }
 */
