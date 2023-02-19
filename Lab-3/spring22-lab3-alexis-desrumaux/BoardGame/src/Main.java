/* *********** Pledge of Honor ************************************************ *

I hereby certify that I have completed this lab assignment on my own
without any help from anyone else. I understand that the only sources of authorized
information in this lab assignment are (1) the course textbook, (2) the
materials posted at the course website and (3) any study notes handwritten by myself.
I have not used, accessed or received any information from any other unauthorized
source in taking this lab assignment. The effort in the assignment thus belongs
completely to me.
READ AND SIGN BY WRITING YOUR NAME SURNAME AND STUDENT ID
SIGNATURE: Alexis Desrumaux, 0078296
********************************************************************************/

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		int size = 0;
		String player1Name = "";
		String player2Name = "";

		System.out.println("Let's play the Board Game!\n");
		Scanner scan = new Scanner(System.in);
		System.out.print("Please determine the board dimension:\n");
		size = scan.nextInt();
		System.out.print("Player 1, what is your name? ");
		player1Name = scan.next();
		System.out.println("");
		System.out.print("Player 2, what is your name? ");
		player2Name = scan.next();
		System.out.println("");
		Board board = new Board(size);
		board.drawBoard();




		// Create a variable to represent the size of our game board

		// Create an array that represents our board

		// Create an object of the Board class and fill it with “-1”. (This is your
		// visible board)

		// Create another object of the Board class and initialize it with random
		// integer numbers between 1 and 10. (This is your hidden board)

		// Create a Scanner and ask the players for their names

		// Ask the user for what element they want to choose

		// Check if the row and column are in the board

		System.out.println("\n\n----------------------- Result ---------------------------\n\n");

		// compare the scores and display who is the winner

		// Draw the board at the end of the game

		System.out.println("\n\n\n--- The final status of the visible board is: ---");

		System.out.println("--- The hidden board was: ---");

		// Convert the hidden board to an ArrayList and display it in the requested
		// order.
		// Display the updated list

	}

}
