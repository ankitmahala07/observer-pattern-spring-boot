package com.ankitmahala07.observerpattern;

import com.ankitmahala07.observerpattern.context.LogContext;
import com.ankitmahala07.observerpattern.interfaces.LogObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ObserverPatternApplication {

	public static void main(String[] args) {
		SpringApplication.run(ObserverPatternApplication.class, args);
	}

	@Autowired
	private List<LogObserver> logObservers;

	//Injecting values directly in the bean via constructor
	@Bean
	public LogContext logContext() {
		return new LogContext(logObservers);
	}

}
