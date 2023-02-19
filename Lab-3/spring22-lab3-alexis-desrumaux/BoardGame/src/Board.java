import java.util.ArrayList;
import java.util.Random;

public class Board {
	
	private ArrayList<ArrayList<Integer>> myboard;
	//Declare the variable 
	
	public Board(int a) {
		this.myboard = new ArrayList<ArrayList<Integer>>();

		for (int row = 0; row != a; row += 1) {
			ArrayList<Integer> newRow = new ArrayList<Integer>();
			for (int column = 0; column != a; column += 1) {
				newRow.add(-1);
			}
			this.myboard.add(newRow);
		}
		//ToDo
	}
	
	
	public void initAsHiddenBoard() {
		Random rand = new Random();
		int upperBound = 11;

		for (int row = 0; row != this.myboard.size(); row += 1) {
			for (int column = 0; column != this.myboard.get(row).size(); column += 1) {
				ArrayList<Integer> aColumnArray = this.myboard.get(row);
				aColumnArray.set(column, rand.nextInt(upperBound));
			}
		}

	} 
	// getter setter
	
	
	
	//This method draws the game board
	public void drawBoard() {
		for (int row = 0; row != this.myboard.size(); row += 1) {
			for (int column = 0; column != this.myboard.get(row).size(); column += 1) {
				System.out.printf("%d ", this.myboard.get(row).get(column));
			}
			System.out.println("");
		}
	}
	
	//This method checks if all of the positions on the board have been filled with 0
	public boolean boardIsFull() {
		boolean check = true;

		for (int row = 0; row != this.myboard.size(); row += 1) {
			for (int column = 0; column != this.myboard.get(row).size(); column += 1) {
				if (this.myboard.get(row).get(column) != 0) {
					check = false;
					break;
				}
			}
		}
		return check;
	}
	
	
	// This method Converts the hidden board to an ArrayList and displays it in the requested order		
	public void makeArrayList () {
				
		//ToDo	
				
				
			}
	
	

}
