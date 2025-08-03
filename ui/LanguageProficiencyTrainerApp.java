package ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import model.Flashcard;

import model.FlashcardManager;
import model.Gender;
import model.Germ_Flashcard;
import model.Observable;
import model.Observer;
import model.ScoreQuiz;
import model.SpacedRepetition;

public class LanguageProficiencyTrainerApp extends Observable {

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

    private ScoreQuiz scoreQuiz;
    // private SpacedRepetition spacedRepetitionQuiz;
    private SpacedRepetition spacedRepetition;
    private List<Observer> observers;
    private Map<String, Runnable> commandMap;
    // private sav;
    private Scanner input;
    private Flashcard currentCard;

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
    private void initializeCommands() {
        commandMap = new HashMap<>();
        commandMap.put("a", this::doAddFlashcard);
        commandMap.put("r", this::doRemoveFlashcard);
        commandMap.put("s", this::doStartQuiz);
        commandMap.put("v", this::doViewVocabularyList);
        commandMap.put("q", this::quitApp);

    }

    /*
     * EFFECTS: checks if command is in map. If found, runs the corresponding method
     * associated with it. If it doesn't
     * it runs handleInvalidCommand() instead.
     */
    private void processCommand(String command) {
        commandMap.getOrDefault(command, this::handleInvalidCommand).run();
    }

    /*
     * EFFECTS: Prints error message when user input is invalid.
     */
    private void handleInvalidCommand() {
        System.out.println("Selection not valid...");
    }

    private void quitApp() {
        System.out.println("Quitting app...");
        System.exit(0);
    }

    // MODIFIES: this
    // EFFECTS: initializes accounts
    private void init() {
        observers = new ArrayList<>();
        spacedRepetition = new SpacedRepetition();
        scoreQuiz = new ScoreQuiz();
        addObservers(spacedRepetition);
        addObservers(scoreQuiz);
        currentCard = null;
        input = new Scanner(System.in);
        input.useDelimiter("\r?\n|\r");
        initializeCommands();

    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\ta -> Add new word to deck ");
        System.out.println("\tr -> Remove word from deck ");
        System.out.println("\ts -> Start Quiz");
        System.out.println("\tv -> View Vocabulary List");
        // System.out.println("\te -> End Quiz");
        System.out.println("\tq -> Quit");
    }

    // MODIFIES: this
    // EFFECTS: conducts a deposit transaction
    private void doAddFlashcard() {
        System.out.println("Enter new word: ");
        String word = input.next();

        System.out.println("Enter its translation: ");
        String translation = input.next();

        System.out.println("Select the language to which the word belongs");
        System.out.println("\t1 -> English");
        System.out.println("\t2 -> German");

        String language = input.next();

        Flashcard card;
        switch (language) {
            case "1":
                card = new Flashcard(word, translation);
                scoreQuiz.addFlashcard(card);
                spacedRepetition.addFlashcard(card);
                System.out.println("Add Successful!");
                break;

            case "2":
                System.out.println("Enter the gender of word. MASCULINE, FEMININE, NEUTER or NA if not applicable");
                Gender gender = Gender.valueOf(input.next());
                card = new Germ_Flashcard(word, translation, gender);
                scoreQuiz.addFlashcard(card);
                spacedRepetition.addFlashcard(card);
                System.out.println("Add Successful!");
                break;
        }

    }

    // MODIFIES: this
    // EFFECTS: removed card from listofflashcards if word is found as either the translation or word itself.
    private void doRemoveFlashcard() {
        System.out.print("Enter word you wish to remove from deck: \n");
        String word = input.next();

        Set<Flashcard> cards = scoreQuiz.getFlashcards();
        Boolean isThere = false;

        for (Flashcard f : cards) {
            if (word.equals(f.getWord()) || word.equals(f.getTranslation())) {
                isThere = true;
                scoreQuiz.removeflashcard(f);
                System.out.println("Action Successful!");
               
            }
           
        }
            if (!isThere)
                System.out.println("Error: Word not found in deck");
        }

    

    /*
     * EFFECTS: prompts user to choose between SpacedRepetitionQuiz, ScoreQuiz
     * REQUIRES: Response to be either SpacedRepetitionQuiz or ScoreQuiz
     */
    private void doStartQuiz() {
        System.out.println("Select the Type of Quiz");
        System.out.println("\ta -> Score Quiz");
        System.out.println("\tb -> SpacedRepetition");

        String quizType = input.next();

        switch (quizType) {

            case "a":
                doScoreQuiz();
                break;

            case "b":
                doSpacedRepetition();
                break;

        }
    }

    /*
     * EFFECTS:
     * questions are asked in a random order.
     * when user provides a wrong answer the answer will be repeated at some point
     * in the quiz.
     * 
     */
    private void doSpacedRepetition() {
       int seenCardsSize = spacedRepetition.getSeenFlashcards().size();
        int deckSize = spacedRepetition.getFlashcards().size();
        if (deckSize > 0) {
            System.out.println("Translate the following words");
            while (deckSize > seenCardsSize) {
                currentCard = spacedRepetition.getNextFlashcard();
                System.out.println(currentCard.getWord());
                String answer = input.next();
                notifyObservers(currentCard, answer);
                seenCardsSize = spacedRepetition.getSeenFlashcards().size();
            }
            System.out.println("Congrats! You have translated all the " + deckSize + " words in Deck correctly.");
            spacedRepetition.resetDeck();
        } else {
            System.out.println("Error: There are no cards in deck");

        }
    }

    private void doScoreQuiz() {
        int seenCardsSize = scoreQuiz.getSeenFlashcards().size();
        int deckSize = scoreQuiz.getFlashcards().size();

        if (deckSize > 0) {
            System.out.println("Translate the following words: ");

            while (deckSize >= seenCardsSize) {
                currentCard = scoreQuiz.getNextFlashcard();
                System.out.println(currentCard.getWord());
                String answer = input.next();
                notifyObservers(currentCard, answer);
                 seenCardsSize = scoreQuiz.getSeenFlashcards().size();
            }

            System.out.println("Congrats! Your Final Score is " + scoreQuiz.getScore() + "/"  +  deckSize);
            scoreQuiz.resetDeck();

        } else {
            System.out.println("Error: There are no cards in deck");
        }
    }

    /*
     * EFFECTS: Helper method that returns true when all words in the deck have been
     * asked during the quiz
     * 
     */
    // private Boolean allWordsInDeckAsked() {
    // Set <Flashcard> cards = scoreQuiz.getFlashcards();
    // return viewedFlashcards.size() > 1 && viewedFlashcards.size() ==
    // cards.size();

    // }

    /*
     * Effects : Displays a list of all new words in the deck and their translation
     */
    private void doViewVocabularyList() {
        Set<Flashcard> cards = scoreQuiz.getFlashcards();
        System.out.println("Vocabulary List (Word + Translation)");
        for (Flashcard card : cards) {
            System.out.println(card.getWord() + "- " + card.getTranslation());
        }

    }

    @Override
    public void notifyObservers(Flashcard card, String s) {

        for (Observer o : observers) {
            if (o != null) {
                o.update(currentCard, s);
            }
        }
    }

    @Override
    public void addObservers(Observer o) {
        if (!observers.contains(o)) {
            observers.add(o);
        }
    }

    @Override
    public void removeObserver(Observer o) {
        if (observers.contains(o)) {
            observers.remove(o);
        }
    }

}

/*
 * private void doEndQuiz() {
 * 
 * }
 */
