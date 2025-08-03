package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable {

    private List<Observer> observers;

    public Observable () {
        observers = new ArrayList<>();
    }
    public void addObservers (Observer o) {
        if(!observers.contains(o)) {
            observers.add(o);
        }
    }

    public void removeObserver(Observer o) {
        if(observers.contains(o)) {
            observers.remove(o);
        }
    }

    public void notifyObservers (Flashcard card, String userAnswer) {
        for (Observer observer: observers) {
          observer.update(card, userAnswer);  
        }
    }
 

}
