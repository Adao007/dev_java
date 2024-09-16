package sudoku_solution_validator;

import java.io.FileReader;
import java.io.IOException;

public class Driver {
	public static void main(String[] args) {
		String file = "placeholder.txt";
		int[][] sGrid = loadGrid(file);	// Load input data into a matrix	
	}

// Function that takes the input file and returns the data in a matrix
	public static int[][] loadGrid(String file) {
		int[][] grid = new int[9][9];
	
		try(BufferedReader buffer = new BufferedReader(new FileReader(file))) {
			String input; 
			int row = 0;
		
			while((line = buffer.readLine()) != null && row < 9) {
				String[] numbers = line.split(",");	// Removes any spaces and commas
			
				for(int i = 0; i < numbers.length && i < 9; i++) {
					grid[row][i] = Integer.parseInt(numbers[i].trim()); // convert string to int and load row
				}
				row++;
			
			}
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
