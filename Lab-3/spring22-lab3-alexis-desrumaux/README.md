# IMPORTANT NOTE 1:
For each lab assignment, **you must include and sign (by writing your name and student id number) the following Pledge of Honor statement at the beginning of your main method source code file. After including this statement, make sure that you do the commit and push operation on GitHub. Otherwise, your lab solution will not be graded.**
```
/* *********** Pledge of Honor ************************************************ *

I hereby certify that I have completed this lab assignment on my own
without any help from anyone else. I understand that the only sources of authorized
information in this lab assignment are (1) the course textbook, (2) the
materials posted at the course website and (3) any study notes handwritten by myself.
I have not used, accessed or received any information from any other unauthorized
source in taking this lab assignment. The effort in the assignment thus belongs
completely to me.
READ AND SIGN BY WRITING YOUR NAME SURNAME AND STUDENT ID
SIGNATURE: <Name Surname, Student id>
********************************************************************************/
```

## IMPORTANT NOTE 2: After you complete the task, do not forget to commit your changes and push them to your repository on Github.

## IMPORTANT NOTE 3: This README.md file only contains the instructions for PRELAB. You will also have INLAB questions.

# Lab-3 Prelab: Board Game

In this prelab, you will practice working with two-dimensional arrays, and details of classes and objects in Java. For this purpose, you are expected to implement a Board Game using the concepts that you learned so far. For implementing the game you need to follow the instructions described below:

In this Board Game, your program will start by asking the user the dimension of the square board. For example, if the user inputs n, then your program will create a nxn matrix with the elements randomly initialized to numbers between 1 and 10. This board will be hidden from the players however, and the players will see a separate (visible) board where all entries are initialized to -1. Every turn, the two players will consecutively pick a row and column from the visible board and the picked element will be replaced with 0. Once the visible board contains all zeros, the board game will finish. The numbers from the positions that each player picked in the hidden board will be added together and the player with more points wins the game. You can check the sample execution below as an example.


## You should use a 2D array for creating a board.


To implement the described game, you need to use the provided template, named BoardGame. The project has two classes, including Board class, and Main class, which are described in the following.
# Board class 
has a 2D array instance variable which contains integer elements. You should name the variable as nameLastname (e.g. johnSmith).

```Java
> Write a constructor public Board (int a), that determines the size of our game board. 
> Write getter and setter methods.
> Implement public void drawBoard() method, which draws and displays the game board.
> Implement public boolean boardIsFull() method to check whether the board elements are all zero or not.
> Implement public void makeArrayList() method, which converts the hidden board to an ArrayList. The conversion should be implemented in an order based on columns. For example, first column's items, then second column's items and so on. The ArrayList should be displayed. Then, after removing the elements of ArrayList with values less than 5, the updated ArrayList should be displayed. See the sample output.
```


# Main class 
is the class including the main method. In this class, first, you need to get the size of the game board from the user. Then, 

```Java
> Create an object of the Board class and fill it with “-1”. (This is your visible board).
> Create another object of the Board class and initialize it with random integer numbers between 1 and 10. (This is your hidden board).
> Determine two players and get their names from the user.
```
Player1 will start the game and will choose an element by determining the row and column indexes. Your program should control the array indexes to be inside the board. Otherwise, the application should display a message "This position is out of the bounds of the board! Please try again." and do not change the player's turn until choosing a feasible and non-zero position on the board. If the corresponding element of the chosen position is zero in the visible board, the player's turn will not also be changed and should display the message "Choose another position! Try again.".

If the player chooses a feasible position (inside the board and non-zero), the corresponding value of the hidden board will be added to the player’s score and the corresponding position on the visible board will turn to zero. Then, the other player should choose a position. This process will continue until all the positions in the visible board turn to zero.
In the end, the score of players should be compared and the player with a large value score will win.

```Java
> Display the modified visible board and the hidden board at the end. 
> By using your makeArrayList() method, display the column ordered elements of the hidden board as the ArrayList items. Then, display the updated ArrayList that contains elements with values greater than 5.
```

See the sample output.

```Java
Let's play the Board Game!
Please determine the board dimension: 
2
Player 1, what is your name? Alice
Player 2, what is your name? Bob
Board:
 -1  -1 
 -1  -1 
Alice's Turn:
Enter a row number: 0
Enter a column number: 0
Board:
 0  -1 
-1  -1 
Bob's Turn:
Enter a row number: 1
Enter a column number: 1
Board:
 0  -1 
 -1  0 
Alice's Turn:
Enter a row number: 0
Enter a column number: 3
This position is out of the bounds of the board! please Try again.

Enter a row number: 1
Enter a column number: 0
Board:
 0  -1 
 0  0 
Bob's Turn:
Enter a row number: 0
Enter a column number: 1

Board Game Finished
----------------------- Result ---------------------------
The player Alice has the score of 11 and the player Bob has the score of 16.
Bob is the winner!

--- The final status of the visible board is: ---
Board:
 0  0 
 0  0 
--- The hidden board was: ---
Board:
 9  7 
 2  9 
 
The generated ArrayList is: [9, 2, 7, 9]
The updated ArrayList is: [9, 7, 9]

```

