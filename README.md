# observer-pattern-spring-boot
This project gives a step by step explanation about implementing observer pattern, so that when there is one-to-many relationship between objects such as if one object is modified, its dependent objects are to be notified automatically.

# What is Observer Pattern?
The Observer Pattern is a behavioral design pattern that defines a one-to-many dependency between objects so that when one object (the subject) changes state, all its dependents (observers) are notified and updated automatically. This pattern is commonly used to implement distributed event handling systems or to define relationships between objects in a decoupled manner.

# Important
This project is not a direct use template for observer pattern and hence you will have to carefully extract the following files/packages from the project and use them in your project as needed.
1. interfaces>LogObserver : This is the interface that restricts a common functionality for all observers
2. observers> All files : These classes are the actual observers that implement the LogObserver interface and define their own implementation for the common functionality by overriding the common method.
3. context>LogContext : Class that handles the list of observers per instance basis and invoke the methods like addObserver, removeObserver, notifyObserver

Make sure to remove @Service from LogContext before using it in your project if your intention is not to use it as a Bean but a constructed object.

Whenever you need to implement a different set of observers from same classes you will have to manage the objects of LogContext class accordingly as in my template I have forced the project to create a single bean for LogContext and have populated that bean with all the observers present in the system in the startup file ObserverPatternApplication.

In practical use case this will not be the scenario so please be aware of that.

In simpler words,
- Remove the code for populating list of observers in LogContext bean from ObserverPatternApplication
- Remove the @Service from LogContext and @Component from all observers
- Remove the Autowiring code of LogContext from LogController
- Now wherever you need to create a instance of LogContext use "new" keyword to create a object of it and use addObserver and removeObserver method to update the observers of that particular instance object only

# Example use-cases
1. Stock market monitoring
2. Monitoring systems
3. Chat application
4. File system monitoring
5. Weather monitoring system
6. Game development - Input systems, Player/Object state change

# How to use this project?
- Simply setup the environment to support Java 17 (it will work with other versions as well, just change the java version in pom.xml)
- Run the application as it is no configuration is required
- On postman create a POST api for localhost:8080/logs endpoint with any message in request body
- Message is expected to be a direct string with no properties
- You will see the message being logged by all the observers hence verifying that project is properly setup for you