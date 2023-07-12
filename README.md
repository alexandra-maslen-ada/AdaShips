# README

## 1. Challenge outline

I chose to develop Battleships in Java, a strategic board game where players take turns guessing the locations of their opponent’s hidden ships and try to sink them. 
The game involves skillful placement of ships, tactical decision-making, and deduction to outmaneuver the opponent to achieve victory. 

### a. Summary and review of the problem, overall proposed solution.

#####Problems' Definition
This involved several challenges as follows:
•	Designing the game logic,
•	Managing game state transitions,
•	Implementing the user interface,
•	Handling user input,
•	Ensuring efficient data structures for board representation and ship placement validation,
•	Designing and engaging user experience using the command line,
•	Handling the game flow,
•	Implementing game mechanics accurately.

When developing battleships, I focused on these three questions:
1)	How could I structure the game efficiently?
A good approach would involve a Model-View-Controller (MVC) architecture. This separation of concerns would allow modularity, flexibility, and easier maintenance of the codebase. However, in a relatively simple game like Battleship, the additional structure of the MVC model may add unnecessary complexity. 
An alternative would be the Model-View-ViewModel (MVVM) architecture. As the View is separated from direct interaction with the Model unlike with the MVC model, this would also provide a structure approach but with better testability. 

2)	How could I implement its logic correctly?
One programming principle to apply here would be the “Single Responsibility Principle” (SRP) which suggests that a class such as representing the game board should only have one clear responsibility. This would help the codebase to be more maintainable, and easier to test and debug. However, this could also lead to an excessive number of small, specialized classes harder to understand. Therefore, it is important to keep the right balance especially as the complexity of the game increases with added functionality.  

3)	How could I make the user interface intuitive?
It is crucial to create a clear and consistent layout, provide visual feedback and instructions, but also to ensure responsiveness when handling errors or user inputs. To do so, the principle of “user-centered design” should be emphasized. By thinking of what the user wants and needs, or what could be their pain-points, this should result in a more user-friendly experience. Nevertheless, as this would increase development time, this needs to be the right balance. 

#####Overall proposed solution
In the proposed Battleship solution, I would develop in Java a Model-View-Controller (MVC) architecture, ensuring separation of concerns and modularity. As time is restricted and would include mainly manual testing rather than automated one, MVC would be more straightforward. 
This game would feature intuitive user interfaces, to enhance usability and user experience.
The game logic would be implemented using object-oriented programming principles, allowing for scalability and maintainability.  

As mentioned, the solution would also include manual testing to ensure functionality and identify any issues.
Even though UI would be basic, the solution would aim to provide a full and enjoyable Battleship game experience against the computer. 

### b. UML style diagram illustrating initial overall solution 

The overall structure of my program uses a game state management pattern like so...

![overall structure](https://github.com/alexandra-maslen-ada/AdaShips/assets/138867091/554bc9b4-2153-4caf-8c64-90ee717b99b7)

* At the beginning the Game class is instantiated. This holds all the logic and data to control the game.
* On every loop, the game updates itself based on the inputs given to it either by the user or the computer player.
* Depending on the gameState value, it will show either the start screen, the setting screen, the playing screen or the game over screen.
* If the user has opted to quit then the loop ends and the program finishes.

The Game class has been modeled like this:

![game model structure](https://github.com/alexandra-maslen-ada/AdaShips/assets/138867091/083bf946-d17a-4ce1-b3c4-a3b80185829c)

### c. Initial working plan, overall approach, development, strategy and approach to quality 

##### Initial Plan
Taking into consideration the principles discussed above, I followed this initial plan:
•	Design the Model component to handle the game logic, including data structures and game state management.
•	Implement the View component to handle user interface rendering and user input handling following the principle of separation of concerns
•	Develop the Controller to mediate communication between the Model and View, ensuring that they remain independent

##### Overall Approach 
My overall approach using the MVC resulted in this: flowchart + UI elements table
 
This allowed me to think of the functionality of the game by defining what data should be contained (Model) but also how it should be displayed (View) and updated (Controller). 
My concern would be that the Model would be responsible for various tasks that could lead to a lack of clear separation of concerns. Additionally, the View could end up mixing the concerns of user input and UI rendering which could lead to less modular design.  I would need to address those to improve the quality of my codebase. Indeed, this could impact on the testability and maintainability when more functionalities would be added.

##### Development Strategy 
This is how I planned to implement all the above:
(original plan)

And this is how it actually worked out:
1.	I re-familiarised myself with Java,                                                                     
2.	I made a little ‘helloworld’ app,                                                                       
3.	I made a simple MVC structure with "hello world",                                           
4.	I improved the MVC structure to take user input and display it,
5.	I made the prototype navigable: start screen, go to playing screen, go back to start screen,
6.	I worked out all the classes I needed,                                                
7.	 I created a setup screen that adds all the data needed for game: player 1 board and ships, player 2 board and ships,
8.	 I added the playing game screen,
9.	I created the end game screen, this also reset data for next game,
10.	I added functionality (randomness) and improved UI (messages, screens).

##### Approach to quality
As time is constricted, this is how I approached quality.
1.	Focus on core functionality. I identified the essential features to make the game playable and enjoyable. This meant that I concentrated on having the main game states working individually first (start, settings, etc.). 

2.	Simplify UI and visuals. I opted to a straightforward user interface that met the basic requirements of the game using the command. I chose not to include animations or graphics that would consume development time. I prioritized functionality over visual appeal.

3.	Implement automated testing. My original plan was to design tests before coding as a test-driven development (TDD) is an effective iterative approach for quality software. However, as it slows development first, I did not have the chance to do this. 

4.	Address major bugs and usability issues. As automated testing was not possible, each unit needed to be tested throughout development to find out and fix bugs. Using IntelliJ’s “Intellisense” (an intelligent code completion and suggestion feature) functionality helped me to quickly navigate around the codebase.   Finally, post-production, an exploratory testing needed to be conducted (to test everything including the UI). 


### d. Analysis and decomposition of the overall problem into key ‘epic’ style tasks. 

##### Decomposition
These were my main 4 epics with their relevant user stories that were used to plan the project. 
Epics 1- 4 graphs
Add pros and cons for each (what went well, what could have been different)

##### Analysis
I used a scrum methodology which meant that I focused on self-organization, and iterative progress. For example, only when the user could enter their own coordinates effectively, I added extra functionality like the possibility of randomness. As this was a short development cycle (3 weeks), each sprint was a week each to help me to test, fix errors and bugs, and improve. 

Overall, the tasks described above were completed but I did not have enough time to develop Epic 5 (added functionality) to add a player 2 instead of the computer.  

Ideally, I would have been able to adapt an approach of extreme programming (XP) that emphasized customer/player involvement, with frequent communication, and continuous testing and integration. This would have improved the quality of the game.
Anything else relevant here?

### e. Initial object-oriented design ideas and planned phased breakdown into smaller tasks.
##### Initial Object-Orientated design
Add State Design Pattern Diagram
Explain what, how, why
Criticism

##### Breakdown of smaller tasks
“Epic 1 - Make a navigable prototype”

* User views game introduction
* User enters ‘Start’ or ‘Quit’
* User is asked to re-enter choice if invalid input
* Prototype is broken up into a MVC architecture

“Epic 2 - Create a setting screen”

* Player can enter the coordinates of each boat
* Player 1 can place 5 ships 
* Players have a board of 10 cells by default
* Player views exactly how long each boat is 
* Player is informed how many ships are placed and how many are still unplaced
* Player 1 can choose to place their ships randomly
* If player 1 does not enter coordinates, the ship is placed randomly
* If coordinates are incorrect, player 1 is informed to try again
* Player 1 can only place ships horizontally, vertically and within the board boundaries
* Player 1 is asked to confirm if happy after each boat is placed or place the boat again
* Player 1 is asked to confirm if happy with the board or start placing ships again

“Epic 3 - Build a playing screen”

* User starts the game with their new boards
* User enters coordinates to fire a torpedo
* User is informed when coordinates are invalid to try again
* User views their boards updated accordingly after each turn
* User can choose not to enter their coordinates (randomly generated)
* Player 1 starts the game and takes turn with player 2 (computer)
* Computer (player 2) fires its torpedo randomly 
* Player 1 is clearly informed if the torpedo was a hit or a missed each time a player has a turn
* Player 1 can view where they have fired a torpedo clearly on their board
* User is allowed to quit the game any time
* Player 1 can view their boards in a user-friendly way

“Epic 4 - Build the game over screen”

* User is informed that the game is over
* User is informed about the winner
* User can either ‘replay’ or ‘quit’
* User goes back to the setting screen to replay
* User is informed when their input is invalid to try again

##### Self-Review of tasks
I could not add the possibility to quit the game whilst playing which could be frustrating for the user. However, the granularity of the tasks above helped me to develop my game efficiently. I also used 'Trello' (a web-based management tool) to help me to track my progress, adding bugs and errors to fix once each feature was developed and tested (at the end of each sprint). 

Add more - 1 or 2 examples of change of plan for tasks and why and how

## 2. Development

### a. Adoption and use of ‘good’ standards'.

##### Good Standards and Examples
These are some of the example of good standards have applied: 

Add other ideas of what else I could have done to contrast points maybe a self review at the end?

1. Simplicity. With the MVC architecture applied, it means that it constantly loops through each game state to show relevant screens. This means that depending on the user’s input, it updates each screen accordingly. It makes the app very simple in logic and flow but also it is easier to maintain or improve.

2. Avoid multipurpose functions and variables. Java is a statically type language, so it naturally forced me to reuse functions and variables. I made sure each function only did one thing. For example, isValidCoordinateToPlaceShip is one liner that is calling two other functions. However, each of them only does one thing (check if the cells are empty, or if coordinates are within the board). It is less confusing and easier to test. 

3. Consistent naming convention. 
When you read the names of the functions, variables, and objects it is clear what they do. For example, even though the board has two methods that do similar but different things, it is obvious by reading their names (isValidCoordinateToPlaceShip and isValidCoordinateToFireTorpedo). By looking at variables such as Booleans (goodCoords, isValid), we understand straight away what they do.

4. Separation of concern. 
With the MVP architecture, it means that the data from the Model (e.g., different game screens like Start, Setting, Playing) is kept separately from how it should be displayed, and user input contained in the View. The Controller deals from controlling the flow of the game and updating it accordingly (see Diagram 1.c.1).  By doing this, each component is developed, tested, and maintained independently. It made it easier to add modifications (e.g., a new screen such as GameOverScreen). This is a simple game though, as the game involves in complexity another architecture such as ECS (Entity-Component-System) might be another option. This might be more flexible when adding or modifying game features to the existing code.  

5. Minimise forced type conversion, coercion or casting. 
I minimized this as much as I could, however I had to do it in one place: the handling of user input for coordinates. This was required as coordinate lookups in my models use integers, but the UI took a letter and an integer. I converted a String (e.g. "A") into an int (e.g. 0) using a Char when creating Coord() object.

6. Test early and often, fail fast and resolve effectively.
At the end of each sprint, I conducted a manual integration test and tested each function at a time while developing. For example, this helped me to improve the quality of the UI by adding relevant messages for the user. When I developed Setting screen, this led to adding the functionality of rendering random coordinates if the user did not enter any. Consequently, I had to change the message to the user to “Press return twice to auto place or enter the coordinates”. This meant that each sprint led to iterations to the UI and core functionality. 

##### Self-Analysis
Add what I could have done differently from the above - 1 example for separation of concern and 1 example for coercion

### b.c.d. Phase developments: tasks, code review and changes.

##### Code Review and Tasks

I asked for a code review at the end of each sprint, this was done by an experienced developer in my team. Unfortunately, I only completed one version of the game (MVP/stage 1) therefore there was only one development phase.  However these code reviews were helpful to generate extra tasks improving the quality and UI of the game. To keep track of them, I added them in my Trello board as follows:

'Epic 1' - Make a Navigable prototype
* User may want to enter lower case or upper case input when choosing the 'Start' or 'Quit' option

'Epic 2' - Create a Setting Screen
* When the user is asked to place a ship, they should know exactly how long it is (message)
* Player 1 might enter "y" or 'yes' instead of "Yes" so all inputs should be valid

'Epic 3' - Build a Playing Screen
* Move validation logic into the model to separate it correctly (see below)
* Change the coordinate data to a better structure (see below)

'Epic 4' - Game Over Screen
* Split the view class into smaller, easier classes to make it easier to work with (see below)
* Reuse the validation methods for player and computer to reduce duplication (see below)

##### Changes from code reviews

* int[] to Coord object
During a code review, I was told that the structure I was using to capture and pass around coordinate data (int[2], e.g., 0,1) could be better as a structured Class with and x and y attribute. Consequently I created a new class called Coords(). This would be the structure easier to comprehend with an improved separation of concerns. Later on when I had to input the coordinate value, I created a .toString() method on the Coords class which changed the coordinates back to a user's understandable format (e.g., 0,0 to A0).

* Moving validation methods out of view and into models
During another code review I was told that validating user input is business logic and should reside within the "model" part of my code base (I had it as a method in the view part).  I moved the validation methods to be part of the board class. This again improved the readability and maintainability of the codebase.

* Reusing validation methods for player and computer
Once I had moved the coords validation method into the model, I then noticed I had the same validation method in another view.  I was able to delete that and reuse the validation method in the model.  This meant I removed duplicated code and reused single methods in the models. 

### e. Ensuring quality through testing and resolving bugs.

##### Testing strategy
As mentioned in 2.a., I tested often manually to catch bugs and errors as early as I could. This meant that I conducted testing as following:

1.	Each time a new function was added, I tested that function on its own. When I added validCoordsForNewShip(), I noticed that it was in fact rendering invalid coordinates. The reason was that it was not taking into consideration if the distance between the ship was the same as the ship length. I consequently added this to fix this error.  

2.	At the end of each sprint (completion of a screen), I tested the new functionality and the previous one together manually (this is as closed to an integration and regression test). For example, when I completed the Setting Screen adding the extra functionality of resetting the board if the user was unhappy, I noticed another error. The board was not clearing the previous coordinates which meant that I needed to add a new function to accomplish this (e.g., clearAllCoordinates()).  Once this was fixed, I tested everything again to make sure this had not impacted on other functionalities such as addShipToBoard(). 

3.	At the end of the 4 sprints (full prototype), I tested the app from the beginning until the end (e.g., end-to-end testing). This allowed me to change some of the UI (e.g., messages) that was unclear. I also made the board visually clearer by adding some spacing where needed. This would help the player to have a more user-friendly experience. 

As mentioned earlier, if time had allowed, I would have ideally implemented automated tests before starting to develop (Test-Driven Approach). This would have improved the quality of the code but also detected errors early. For example, the issue with the playing screen (when it shot at the player's own screen instead of the computer's) could have been discovered earlier (I only found out when completing epic 3.

##### List of Bugs/Errors Found

This is a sample of the list of bugs and errors from my Trello board that I addressed.

‘Epic 1’. Start Screen – Navigable prototype
* Error: when I type ‘Quit’ instead of ‘Start’, it does not let me quit.

‘Epic 2’.  Settings Screen
* Bug: The letters on the board should be inverted with the numbers.   
* Error: When the user enters a blank coordinate, it throws a java error.
* Bug: If the user is not happy with the coordinates, the boards are not printed in the right order.
* Bug: When the user wants to reset ships, it only clears the last ship placed.

‘Epic 3’. Playing Screen
* Error: When player 1 fires a torpedo, they shoot their own board not the computer’s. 

‘Epic 4’. Game Over Screen
* Error: When the game is over, it says the computer is the winner even though the ships are not completely hit. 
* Bug/UI: It is difficult to read the boards as coordinates are too close together.
*Bug/UI:  When you choose to end the game, it does not tell you anything.   

### f. Reflection on key design challenges, innovations and how they were solved (with examples)

##### Challenges

The biggest challenges for me where the following:
1) Knowing where to start. This required to build a full working game which I had never done before. 
2) Keeping track of everything.  As I read the game requirements, I started to realise that if I did not have a clear plan and design strategy, it would become chaotic quickly. 

##### Innovations and how they were solved

* I asked advice from my team on the best design approach to keep track of everything. They suggested to structure the game around screens to help me to break the project into smaller, more doable tasks (see 1.e epics and user stories). This meant that I started by creating in the Model class, different game states. That meant that each epic had a clear goal, from there tasks were easier to define.

* This meant that I used a State Design Pattern (State machine - see 1.e. for flowchart). My program changed its behaviour based upon one attribute, game state (the change of behaviour is the screen it shows). Basically, depending on the user's input, it changes the screens/states. This also meant that it was easier to handle added functionalities and easier to maintain. 

* The use of a MVC pattern helped me to know where I had to put new functionalities therefore it helped me to know where to start (see 1.c diagram).

## 3. Evaluation

### a. Analysis with embedded examples of key code refactoring, reuse, smells.

#### 'Code Refactoring' example

My first version of the "View" section of my code used one giant class. It contained the code for each screen and helper methods...

```
public class View {
  public void startScreen(Model model)
  public void settingsScreen(Model model)
  public void printSingleBoard(Player player1)
  private Coords parseCoordinates(String coordString)
  public void printListOfShips(Ship[] ships)
  public void playingScreen(Model model)
  public void printPlayerBoards(Player player1, Player player2)
}
```
It was instantiated and then used in the controller like this...

```
switch( model.gameState ) {
    case START:
        view.startScreen(model);
        break;
    case ENTER_SETTINGS:
        view.settingsScreen(model);
        break;
    case PLAYING:
        view.playingScreen(model);
        break;
}
```
This was not a good choice for the following reason:
* It was an instantiated object but held no state, all methods called on the object were used to render the output but didn't store anything themselves.
* It was one big class so broke the single responsibility principle.
* As it was one big class it was hard to navigate, I would constantly find myself getting lost in there.

I decided to change this to use a number of static classes that inherited from a super `Screen` class. This super class held a few general use methods - like the header printer.

```
public abstract class Screen { 
  public static void printSingleBoard(Player player1)
  public static Coords parseCoordinates(String coordString)
  public static void printSmallHeader()  
}

public class ScreenGameOver extends Screen {
  public static void render(Game model)
}
```
These new static classes were used in the controller like this:

```
switch( model.gameState ) {
    case START:          ScreenStart.render(model);
                         break;
    case ENTER_SETTINGS: ScreenEnterSettings.render(model);
                         break;
    case PLAYING:        ScreenPlaying.render(model);
                         break;
    case FINISHED:       ScreenGameOver.render(model);
                         break;
```

This was better for the following reasons:
* Statically called classes use less memory
* They hold no state so are simpler
* Single responsibility principle is upheld: printing out each screen is owned by separate classes.
 
#### 'Code Smells' example
This refers to certain patterns in code that could indicate potential design issues. For example, when I designed the printPlayerBoards() (see below), you can see clearly that there are 3 'for' nested loops making these conditionals complex. 

Screenshot Code Smells

Even though it does not lead to a bug or an error, it affects the readability and maintainability. I could have used a single 'for' loop iterating over the rows of the boards and manipulate the row string accordingly. However, I do not think this option would have made a huge improvement. Another better option would have been to encapsulate the logic for formatting and printing a single row of the player boards in a separate method. This way, I could have reused the method for both player1 and player2 without duplicating the code and the use of nested loops. 

#### 'Reuse' example
This refers to the practice of using existing code to build new functionality. The class "Coords" as shown below provides two constructors, one for creating coordinates automatically and another for creating coordinates from user input. By providing multiple ways to create objects, this class allows for flexibility as it can reuse the 'Coords' functionality in different scenarios. Additionally, the 'toString()' method is overridden to provide a readable format for displaying coordinates. This allows for consistent and reusable code when converting "Coords" objects to a string representation.  

Screenshot Reuse

A criticism of the above could be the lack of input validation in the constructors. As the constructor takes a String for the x-coordinate, it assumes that the input is a single character. It would be beneficial to include proper input validation to ensure the correctness of the input values. This could avoid unexpected behavior or errors when added functionality is added. 

### b. Implementation and effective use of ‘advanced’ programming principles(with examples).

####Polymorphism: Ship sub classes being looped through

My game uses a set of classes for each type of ship: a Destroyer class, a Submarine class, etc.  All of these classes extend the base class Ship.

When dealing with the game logic I often had to loop through the collection of ships on the board. I did this using polymorphism, where I created an array of ships and added different Ship sub class objects to it.  
E.g...

```
Ship[] ships = new Ship[5];
ships[0] = new Carrier();
ships[1] = new Battleship();
ships[2] = new Destroyer();
ships[3] = new Submarine();
ships[4] = new PatrolBoat();
```

I would loop over these like so...

```
public static void printListOfShips(Ship[] ships) {
    System.out.println("Ships to place: ");
    for(Ship ship : ships) {
        if(!ship.isPlaced()) { // Only print the ships that are not placed so far by user
            System.out.println(" * " + ship.name + " " + ship.length);
        }
    }
    System.out.print("\n");
}
```

####Extending: Ship sub classes

My game uses a set of classes for each type of Screen: a ScreenStart class, a ScreenGamerOver class, etc.  All of these classes extend the base class Screen.

Despite the screens having different responsibilities and logic within them, they shared some common requirements. One of them was to display a header for the user interface.  This header method printSmallHeader() was defined in the base class but called in the sub classes as if it were part of itself (which it was thanks to extending).

```
public abstract class Screen { 
  public static void printSmallHeader() {
    // code for printing out the header
  }
}

public class ScreenGameOver extends Screen {
  public static void render(Game model) {
    printSmallerHeader();
  }
}
```

####Abstraction: Ship class
My game uses a set of classes for each type of ship: a Destroyer class, a Submarine class, etc.  All of these classes extend the base class Ship.

The class Ship is there to help define the sub classes, it's not to be used itself.  It helps to define all the common attributes with default values for each sub class and to define the methods that will be called on all the ships .  Because of this is defined as being abstract:

```
public abstract class Ship {
  protected int length;
  public String name = "Ship";
  private boolean placed = false;
  public String label = "S";

  public int getSize() {
    return length;
  }

  public boolean isPlaced() {
    return placed;
  }

  public void place() {
    this.placed = true;
  }

  public void unplace() {
    this.placed = false;
  }

  static public Coords[] generateShipCoords(Coords startCoords, Coords endCoords) {}
}

public class PatrolBoat extends Ship {
  PatrolBoat(){
    length = 2;
    name = "Patrol Boat";
    label = "P";
  }
}
```

#### Static code

As described in detail above, I've made use of static classes to render all the screens.

#### MVC pattern

I used the MVC (Model View Controller) pattern for the overall structure of my game program.

This helped me to structure the code in the following ways:
* Model (e.g. Game class, Player class, Board class, Coords class) - These were classes that I used to model the game business logic.  Stored state, validating user input, deciding where the computer shoot and whether someone had won was all calculated and stored in these classes.
* View (e.g. ScreenGameOver class, ScreenPlaying class, ScreenEnterSettings class) - These were classes that were in charge of interacting with the user. For example they were in charge of logic that worked out how to print a player board onto the screen, or capture where the user wanted to place a ship.
* Controller (Controller class) - this was in charge of passing objects around and controlling the overall flow of the application.

#### Method overloading: Two Coord constructors

The Coords class has two ways you can instantiate it. This is because there are two ways coordinates are created: either from the user ("A0") or automatically from the computer (0,0).

Transforming the user "A" row input into a value the program can use to look up a ship on a board is the concern of the Coords class. To do this quickly I create two constructors for the class which took different parameters:

```
  // This is for coords made automatically
  public Coords(int x, int y) {
    this.x = x;
    this.y = y;
  }

  // This is for coords made from a user input
  public Coords(String x, int y) {
    this.x = x.charAt(0) - 'A';
    this.y = y;
  }
```

#### Method overwriting: Coords.toString()

All objects in Java come with a toString() method. This turns the object into a string representation of itself.

To allow the quick and easy rendering of coordinates into the user interface, I overwrote the method for the Coord class like so...

```
public class Coords {
  public String toString() {
    String[] cols = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
    return cols[x] + y;
  }
}

System.out.println("You fired at " + coords.toString() + ": " + torpedoResult);
```

Which produced the output...

```
You fired at H8: Missed
```

### c. Featuresshowcase and embedded innovations(with examples) - opportunity to ‘highlight’ best bits.

#### Controller run method: makes it easy to structure how screens connect.
As mentioned above, this method using a state machine approach, uses a loop to continuously update the game state and rendering the appropriate screen based on the current state. 

Do I need a screenshot?

By separating the rendering logic into different screen classes, the code achieves separation of concerns and promotes maintainability. The use of a boolean flag 'playing' allows for graceful termination of the game loop when the 'Quit' state is reached, providing a clean exit from the game.

However, the code does not include error handling or validation issues during the rendering process. If exceptions were thrown during the rendering of a particular screen, it might produce incorrect behaviour. By adding a default case in the switch statement to handle unexpected game states, this would help with this issue. 

#### Polymorphism and extending of 'Ship' class: made adding new ship types really easy.

Do I need a screenshot or is above already?

One of the best of this is the usage of the 'Ship' class as a base class that provides common functionality for all types of ships. It defines methods such as 'getSize()' to retrieve the length of the ship, 'isPlaced()' to check if the ship is on the board and 'unplace()' to change the placement status. 

Another good bit is the static method: 'generateShipCoords()' within this class. It demonstrates polymorphism by handling different cases for drawing horizontal and vertical ships based on the provided start and end coordinates. It dynamically creates and returns an array of 'Coords' objects representing the ships' coordinates. 

All of this allows code reusability and flexibility, as the 'Ship' class can be extended to create different types of ships while still getting the same functionality defined in the base class.  

However, the responsibility of generating ship coordinates within the 'Ship' class should ideally focus on defining the properties and behavior of a ship, rather than handling the generation of coordinates. A more modular approach would be to add this logic into the Coords class to separate concerns further. 

### Method that converts user input into an int (thanks to chatGPT)

The game has to take coordinate values from the user in this format: A0

But has to plot it to a 2D array which has integer values: 0, 0.

I therefore had to work out how to change an "A" to a number. This is the solution I found:

```
String x = "A";
x.charAt(0) - 'A'; // outputs 0
```

This uses casting to convert the String to a Char, then the Char to an int.

While this was a quick way to do it, it's not very readable.  Although the code is clever, I could have created a simpler array look up like I did later in the toString method. Unfortunately I ran out of time to refactor this.

### d. Improved algorithms

I created the method computerShoots to randomly fire torpedos from the computer's ships at the user's board.

This worked by randomly creating a Coords object (within the boundary of the board's size) and then firing it at the user's board...

```
public Coords createRandomCoords() {
    Random random = new Random();
    int row = random.nextInt(5); // Generate random row index (0-9)
    int col = random.nextInt(5); // Generate random column index (0-9)
    Coords coords = new Coords(row, col);
    return coords;
}

public String computerShoots() {
    Coords coords = createRandomCoords();
    String computerShot = player1.board.fireTorpedo(coords);
    return computerShot;
}
```

The problem with this approach is that over time the likelihood of the computer shooting at a cell on the board that it hasn't already fired at decreases.

I initially thought I'd solve this by recording each shot the computer made, and then checking the next time it shoots, if the randomly generated Coords had already been fired, try making another randomly generated Coords object.

Unfortunately when I did this after a while the time it'd take the computer to decide where to shoot took longer and longer.  Towards the end of the game it became visibily noticeable, and then the game would stop and look like it had crashed.  This is because I still had the same problem - that over time it would become increasingly harder to fire at a cell that hadn't been chosen before.

A programmer in my team helped me with this. He said that instead of just remembering where the computer had shot before, I also needed to decrease the cells that could randomly be chosen. This way the code would never randomly pick a previous cell by mistake.

He also explained to me that for this to work I'd need to convert the 2D array of the board into a flat array to enable the random int generator to work.  I received a lot of help with this, below is an extract of how it worked...

```
public String[] autoFireAt(Player enemy) { 
    // get a flat array of all the available coordinates on the player board
    ArrayList<Coords> availableCoordsList = enemy.board.toListOfAvailableCoords();
    // get an array of all the previous places the computer fired at
    availableCoordsList.removeAll(this.shotHistory);
    // create a "delta", an array of coordinates we can shoot at
    Coords[] availableCoords = availableCoordsList.toArray(new Coords[availableCoordsList.size()]);
    // randomly choose one of those coords to fire at
    Random random = new Random();
    Coords coords = availableCoords[random.nextInt(availableCoords.length)];
    // fire it
    String shotResult = enemy.board.fireTorpedo(coords);
    record where we fired
    addToShotHistory(coords);
    return new String[]{shotResult,coords.toString()};
}
```
 
### e. Reflective review, opportunities to improve and continued professional development.

Throughout the project, I focused on these three questions:
1)	How could I structure the game efficiently? 
2)	How could I implement its logic correctly?
3)	How could I make the user interface intuitive?

#### Reflection Review
I learnt the importance of modular design patterns such as the MVC architecture (with a clear separation of components). This helped me to structure and organize my project efficiently. 

The use of a state machine design approach (as my game changed its behavior depending on the game state/screen) supported the implementation of a clear logic. 

I tried to follow the single responsibility principle (SRP) to keep each function simple, but it became difficult to follow as the game became more complex. I realised the importance of object-orientated principles not only of modularity but also reusability, encapsulation, and inheritance which I tried to incorporate in my codebase. 

##### Opportunities
As I worked iteratively, I realized that although I tried to develop an intuitive interface, there was still a lot more I could do to deal with error handling and user input validation. 

Even though I tried to adhere to coding standards as much as I could, it was a steep learning curve. There is much more I could do to avoid ‘code smells’ such as duplicates (nested loops). 

From the beginning, I realized that despite my best intentions to include automatic testing, I would run out of time. I still believe a test-driven approach would have helped me to fix some of the bugs I found early. 

##### Continuous Professional Development
I would like to do the following:

•	Improving this game prototype further taking into considerations the weaknesses I mentioned above, 

•	Continuing to learn Java at an intermediate course, but this time completing a coding challenge ideally a week, 

•	Improving the other Java project created for my previous team where the user could search for missing field in the database more user-friendly. This time, I would research and apply new architectural design patterns. 
