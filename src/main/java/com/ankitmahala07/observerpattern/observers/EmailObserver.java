package com.ankitmahala07.observerpattern.observers;

import com.ankitmahala07.observerpattern.interfaces.LogObserver;
import org.springframework.stereotype.Component;

@Component
public class EmailObserver implements LogObserver {

    @Override
    public void update(String logMessage) {
        System.out.println("Sending email notification: "+logMessage);
    }
}
