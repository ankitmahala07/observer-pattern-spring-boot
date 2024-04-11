package com.ankitmahala07.observerpattern.context;

import com.ankitmahala07.observerpattern.interfaces.LogObserver;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LogContext {
    /*
          Note: Observers are pre-populated in ObserverPatternApplication.java (startup class) so that we can directly
          inject the observers in the LogContext Bean, but it's not necessary to do in the same manner as in practical
          scenario you will require more control over the observer register/un-register process hence a manual object
          creation and alteration is advised.
     */

    private List<LogObserver> observers = new ArrayList<>();

    public LogContext(List<LogObserver> observers) {
        this.observers = observers;
    }

    public void addObserver(LogObserver observer) {
        //Note: Method to add observer manually just in case
        observers.add(observer);
    }

    public void removeObserver(LogObserver observer) {
        //Note: Method to remove observer manually just in case
        observers.remove(observer);
    }

    public void log(String logMessage) {
        System.out.println("Creating log: " + logMessage);
        notifyObservers(logMessage);
    }

    private void notifyObservers(String logMessage) {
        for (LogObserver observer : observers) {
            observer.update(logMessage);
        }
    }
}
