package sudoku_solution_validator;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class sudoku2 {
	// Struct for threads to check data
	public static class SudokuGrid {
		private int[][] grid; 		// variable to hold grid from input.
		private boolean[] checks;	// array of checks for rows, columns, and subsquares 
		private static final int STARTLIMIT = 3;
		private static final int MIDLIMIT = 6;
		private static final int ENDLIMIT = 9; 
		private static final int VALIDTOTAL = 45; 
		
		// constructor 
		public SudokuGrid (int [][] grid) {
			this.grid = grid;
			this.checks = new boolean[11];	// 11 Checks are required to validate sudoku grid
		}
		
		public void printGrid() {
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					System.out.print(this.grid[i][j]);
					if(j == 8) {System.out.println();}
				}
			}
		}
		
		// Thread for checking rows: CHECK #0
		class RChecker implements Runnable {

			@Override
			public void run() {
				int sum = 0; 					// Valid row sum should be 45
				boolean validity = true; 
				
				for(int row = 0; row < grid.length; row++) {
					for(int i = 0; i < grid.length; i++) {
						sum += grid[row][i]; 	// Add each number of the row into sum
					}
					if (sum != VALIDTOTAL) {	// If sum of row does not equal 45
						validity = false; 	// Set validity to false
						break;			
					} 
					else { sum = 0; } 			// Reset sum for next loop
				}
				checks[0] = validity; 	
			}
		
		}
		
		// Thread for checking columns: CHECK# 1
		class CChecker implements Runnable {

			@Override
			public void run() {
				int sum = 0; 					// Valid row sum should be 45
				boolean validity = true; 
				
				for(int col = 0; col < grid.length; col++) {
					for(int i = 0; i < grid.length; i++) {
						sum += grid[i][col]; 	// Add each number of the row into sum
					}
					if (sum != VALIDTOTAL) {	// If sum of row does not equal 45
						validity = false; 	// Set validity to false
						break;			
					} 
					else { sum = 0; } 			// Reset sum for next loop
				}
				checks[1] = validity; 	
			}
			
		}
		
		// Threads for checking Sub-Squares
		
		// CHECK #2
		class TLChecker implements Runnable {	// Top Left Subsquare(rows: 1-3, columns: 1-3)

			@Override
			public void run() {
				int sum = 0; 
				boolean validity = true; 
				for(int row = 0; row < STARTLIMIT; row++) {
					for(int col = 0; col < STARTLIMIT; col++) {
						sum += grid[row][col]; 
					}
				}
				if(sum != VALIDTOTAL) {
					validity = false;
				}
				
				checks[2] = validity; 
			}
			
		}
		
		// CHECK #3
		class TMChecker implements Runnable {	// Top Middle Subsquare(rows: 1-3, columns: 4-6)

			@Override
			public void run() {
				int sum = 0; 
				boolean validity = true; 
				for(int row = 0; row < STARTLIMIT; row++) {
					for(int col = STARTLIMIT; col < MIDLIMIT; col++) {
						sum += grid[row][col]; 
					}
				}
				if(sum != VALIDTOTAL) {
					validity = false;
				}
				
				checks[3] = validity; 
			}
			
		}
		
		// CHECK #4
		class TRChecker implements Runnable {	// Top Right Subsquare(rows: 1-3, columns: 7-9)

			@Override
			public void run() {
				int sum = 0; 
				boolean validity = true; 
				for(int row = 0; row < STARTLIMIT; row++) {
					for(int col = 6; col < ENDLIMIT; col++) {
						sum += grid[row][col]; 
					}
				}
				if(sum != VALIDTOTAL) {
					validity = false;
				}
				
				checks[4] = validity; 
			}
			
		}
		
		// CHECK #5
		class MLChecker implements Runnable {	// Middle Left Subsquare(rows: 4-6, columns: 1-3)

			@Override
			public void run() {
				int sum = 0; 
				boolean validity = true; 
				for(int row = STARTLIMIT; row < MIDLIMIT; row++) {
					for(int col = 0; col < STARTLIMIT; col++) {
						sum += grid[row][col]; 
					}
				}
				if(sum != VALIDTOTAL) {
					validity = false;
				}
				
				checks[5] = validity; 
			}
			
		}
		
		// CHECK #6
		class MMChecker implements Runnable {	// Mid Middle Subsquare(rows: 4-6, columns: 4-6)

			@Override
			public void run() {
				int sum = 0; 
				boolean validity = true; 
				
				
				for(int row = STARTLIMIT; row < MIDLIMIT; row++) {
					for(int col = STARTLIMIT; col < MIDLIMIT; col++) {
						sum += grid[row][col]; 
					}
				}
				if(sum != VALIDTOTAL) {
					validity = false;
				}
				
				checks[6] = validity; 
			}
			
		}
		
		// CHECK #7
		class MRChecker implements Runnable {	// Middle Right Subsquare(rows: 4-6, columns: 7-9)

			@Override
			public void run(){
				int sum = 0; 
				boolean validity = true; 
				
				
				for(int row = STARTLIMIT; row < MIDLIMIT; row++) {
					for(int col = MIDLIMIT; col < ENDLIMIT; col++) {
						sum += grid[row][col]; 
					}
				}
				if(sum != VALIDTOTAL) {
					validity = false;
				}
				
				checks[7] = validity; 
			}
			
		}
		
		// CHECK #8
		class BLChecker implements Runnable {	// Bottom Left Subsquare(rows: 7-9, columns: 1-3)

			@Override
			public void run() {
				int sum = 0; 
				boolean validity = true; 
				
				
				for(int row = MIDLIMIT; row < ENDLIMIT; row++) {
					for(int col = 0; col < STARTLIMIT; col++) {
						sum += grid[row][col]; 
					}
				}
				if(sum != VALIDTOTAL) {
					validity = false;
				}
				
				checks[8] = validity; 
			}
			
		}
	
		// CHECK #9
		class BMChecker implements Runnable {	// Bottom Middle Subsquare(rows: 7-9, columns: 4-6)

			@Override
			public void run() {
				int sum = 0; 
				boolean validity = true; 
				
				
				for(int row = MIDLIMIT; row < ENDLIMIT; row++) {
					for(int col = STARTLIMIT; col < MIDLIMIT; col++) {
						sum += grid[row][col]; 
					}
				}
				if(sum != VALIDTOTAL) {
					validity = false;
				}
				
				checks[9] = validity; 
			}
			
		}
		
		// CHECK #10
		class BRChecker implements Runnable {	// Bottom Right Subsquare(rows: 7-9, columns: 7-9)

			@Override
			public void run() {
				int sum = 0; 
				boolean validity = true; 
				
				
				for(int row = MIDLIMIT; row < ENDLIMIT; row++) {
					for(int col = MIDLIMIT; col < ENDLIMIT; col++) {
						sum += grid[row][col]; 
					}
				}
				if(sum != VALIDTOTAL) {
					validity = false;
				}
				
				checks[10] = validity; 
			}
			
		}
		
		// Function to run threads 
		public void validate() {
			Thread rows = new Thread(new RChecker()); 
			Thread columns = new Thread(new CChecker()); 
			Thread topleftSquare = new Thread(new TLChecker());
			Thread topmiddleSquare = new Thread(new TMChecker()); 
			Thread toprightSquare = new Thread(new TRChecker()); 
			Thread midleftSquare = new Thread(new MLChecker()); 
			Thread midmiddleSquare = new Thread(new MMChecker());
			Thread midrightSquare = new Thread(new MRChecker()); 
			Thread botleftSquare = new Thread(new BLChecker());
			Thread botmiddleSquare = new Thread(new BMChecker());
			Thread botrightSquare = new Thread(new BRChecker()); 
			
			// RUN THREADS 
			rows.start(); columns.start(); 
			topleftSquare.start(); topmiddleSquare.start(); toprightSquare.start(); 
			midleftSquare.start(); midmiddleSquare.start(); midrightSquare.start(); 
			botleftSquare.start(); botmiddleSquare.start(); botrightSquare.start(); 
			
			// JOIN THREADS
			try {
				rows.join(); columns.join();
				topleftSquare.join(); topmiddleSquare.join(); toprightSquare.join();
				midleftSquare.join(); midmiddleSquare.join(); midrightSquare.join(); 
				botleftSquare.join(); botmiddleSquare.join(); botrightSquare.join(); 
			} catch (InterruptedException e) {
				e.printStackTrace(); 
			}
			
			validatorCheck(); 
		}

		// increment thru the checks array: VALID == ALL TRUE
		private void validatorCheck() {
			boolean message = true;
			for(int i = 0; i < checks.length; i++) {
				if(checks[i] != true) {
					message = false;
					System.out.println("Check Error: " + i); 
				}	
			}
			
			if(message == true) { validMessage(); }
			else { invalidMessage(); }
		}
		
		private void invalidMessage() {
			System.out.println("Sudoku Grid is invalid!!!"); 
		}
		
		private void validMessage() {
			System.out.println("Sudoku Grid is valid!!!"); 
		}
		
	}
	
	// Function that takes the input file and returns the data in a matrix
	public static int[][] loadGrid(String file) {
		int[][] grid = new int[9][9];
		
		try(BufferedReader buffer = new BufferedReader(new FileReader(file))) {
			String line; 
			int row = 0;
			
			while((line = buffer.readLine()) != null && row < 9) {
				String[] numbers = line.split("[,\\s]+");	// regex for spliting line for spaces and commas
				
				for(int i = 0; i < numbers.length && i < 9; i++) {
					grid[row][i] = Integer.parseInt(numbers[i].trim()); // convert string to int and load row
				}
				row++;
				
			}
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
		return grid; 
	}
	
	public static String getUserInput() {
		Scanner scanner = new Scanner(System.in); 
		System.out.print("Enter the name of the file: "); 
		String file = scanner.nextLine();
		return file; 
	}
	
	// MAIN DRIVER FUNCTION
	public static void main(String[] args) {
		String file = getUserInput();
		SudokuGrid sGrid = new SudokuGrid(loadGrid(file));					// Load input data into struct	
		sGrid.validate(); 									// Runs checker threads and outputs validity
		sGrid.printGrid();									// Outputs the Sudoku Grid
	}
}


