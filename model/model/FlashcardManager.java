package model;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// This Class represents a flashcards manager, that contains a list of all flashcards in a deck.
// It also includes a map of the flashcards, with the difficulty level as the Key and corresponding Flashcards as the value.
public abstract class FlashcardManager {

    protected Set<Flashcard> flashcards;
    protected Map<Gender, Set<Flashcard>> mapOfFlashcards;
    protected int correctAnswers;
    protected List<Flashcard> seenFlashcards;

    public FlashcardManager() {
        this.flashcards = new HashSet<>();
        this.mapOfFlashcards = new EnumMap<>(Gender.class);
        for (Gender g : Gender.values()) {
            mapOfFlashcards.put(g,new HashSet<>());
        }

    }

    /*
     * EFFECTS: Adds flashcard to set 
     * MODIFIES: flashcards set
     * 
     */
    public void addFlashcard(Flashcard f) {
        if (f.getClass() == Germ_Flashcard.class) {
            Gender g = ((Germ_Flashcard) f).getGender(); 
           Set<Flashcard> cards = mapOfFlashcards.get(g);
           cards.add(f);
           mapOfFlashcards.put(g, cards);

        }
            this.flashcards.add(f);
            
        }
        
    

    public void removeflashcard(Flashcard f) {
        if (f.getClass() == Germ_Flashcard.class) {
            Gender g = ((Germ_Flashcard) f).getGender(); 
           Set<Flashcard> cards = mapOfFlashcards.get(g);
           cards.remove(f);
           mapOfFlashcards.put(g, cards);

        }
         this.flashcards.remove(f);
       
    }

    // return list of flashcards in deck
    public Set<Flashcard> getFlashcards() {
        return flashcards;
    }

  
      /*
     * EFFECTS: Check whether the answer provided matched the tranlations of a word
     * 
     */

     public boolean isAnswerCorrect(Flashcard card, String userAnswer) {
        String translation = card.getTranslation();
        if (userAnswer.equalsIgnoreCase(translation)) {
            return true;
        } else {
            return false;
        }
     }

     
    /*
     * EFFECTS: Returns the next Flashcard to be asked from set of Flashcards.
     * MODIFIES: 
     * 
     */protected abstract Flashcard nextFlashCard();
       
    }



