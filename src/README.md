# Game-Centre
Game Centre is a Java-based console gaming project that includes games such as Word Guess, Number Guess, and Snake Ladder. It follows the SOLID principles of OOP, utilizing interfaces for standardization and modular classes for specific functionalities, to provide a scalable and maintainable framework for game development and extension.



## UML Diagram

![UML Diagram](C:\Users\User\Desktop\Game-Centre-main\src\uml.png)

## SOLID Principles followed in this project
- **Single Responsibility Principle**

>Each class should have a single responsibility.

  Here, all the classes have single responsibility as their name suggests.

- **Open/Closed Principle**

>Software Entities(Classes, Methods,etc) should be open for extension but closed for modification.

  Here, in the project, `IGame` interface uses a method `createGame`() in each Game class  for creating a game itself so that `GameSelector` class don't need to be modified everytime.
  
  The `PlayModule` class uses composition with the `PlayInfo` class to adhere to OCP.

  Followed OCP by making `GameSelector` and `GameOperator` class open for extension. [By implementing IGame in newly created game class]

- **Liskov Substitution Principle**

>Objects in a program should be replaceable with instances of their subtypes without altering the correctness of that program.

  In this project, since all game classes implement the `IGame` interface, they are expected to override the same methods. And all the game classes (`WordGuessGame`, `SnakeLadderGame`, and `NumberGuessGame`) do not have unimplemented methods from IGame. This means any game object can be replaced with another game object without disrupting the functionality of the system. For instance, wherever the system expects an IGame, any of the game implementations can be used interchangeably.

- **Dependency Inversion Principle**
>High-level modules should not depend on low-level modules, rather it should depend on abstracrtion.

   The game operation logic interacts with the `IGame` interface, an abstraction of these details. That is, `GameOperator` class takes `IGame` object having dependency through constructor injection. This means that high-level modules are not dependent on the specifics of each game, but rather on the abstract concept of a game.
 
## Developers
 This project has been created by `@NafNawal04` 