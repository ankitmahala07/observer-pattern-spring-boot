package com.ankitmahala07.observerpattern.controllers;

import com.ankitmahala07.observerpattern.context.LogContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogController {

    @Autowired
    private LogContext logContext;

    @PostMapping("/logs")
    public void createLog(@RequestBody String logMessage) {
        logContext.log(logMessage);
    }

}
