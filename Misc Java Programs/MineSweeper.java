/**
 * Class implements a method that builds MineSweeper board given locations of bombs
 * Source: https://www.udemy.com/course/11-essential-coding-interview-questions
 * @author Cole Thomson
 *
 */
public class MineSweeper {
	/**
	 * Main method used to test getCommonElements method.
	 * @param args - unused
	 */
	public static void main(String[] args) {
		// Test 1
		int[][] bombs1 = {{0,0}, {0,1}};
		int numRows1 = 3;
		int numCols1 = 4;
		
		// Test 2
		int[][] bombs2 = {{0,1},{3,2},{4,1},{4,2},{2,0}};
		int numRows2 = 5;
		int numCols2 = 5;
		
		// Run tests and print boards
		System.out.println("Board 1:");
		int[][] board1 = mineSweeper(bombs1, numRows1, numCols1);
		printBoard(board1);
		
		System.out.println();
		System.out.println("Board 2:");
		int[][] board2 = mineSweeper(bombs2, numRows2, numCols2);
		printBoard(board2);
		
	}
	
	/**
	 * Places bombs on MineSweeper board and calculates the numbers of
	 * all other cells on the board. Each non-bomb cell contains the 
	 * number of bomb cells surrounding it (max of 8). Method assumes
	 * that there are no repeated bomb coordinates.
	 * @param bombCoord	- coordinates of bombs to place on board
	 * @param nRows		- number of rows on board
	 * @param nCols     - number of cols on board
	 * @return board 	- 2D array representing the MineSweeper game
	 * 
	 */
	public static int[][] mineSweeper(int[][] bombCoord, int nRows, int nCols) {
		int[][] board = new int[nRows][nCols];
		
		// Place bombs
		for (int i = 0; i < bombCoord.length; i++) {
			board[bombCoord[i][0]][bombCoord[i][1]] = -1;
		}
		
		// Fill in remainder of board
		for (int i = 0; i < nRows; i++) {
			for (int j = 0; j < nCols; j++) {
				// If cell is not a bomb
				if (board[i][j] != -1) {
					// check for number of bombs around it
						for(int k = i-1; k <= i+1; k++) {
							if (k < 0) continue;
							if (k >= nRows) break;
							for(int m = j-1; m <= j+1; m++) {
								if (m < 0) continue;
								if (m >= nCols) break;
								if (board[k][m] == -1) board[i][j]++;
							}
						}
					} 	
				}
			}

		return board;
	}
	
	/**
	 * Method prints MineSweeper board
	 * @param board - 2D array representing the MineSweeper game
	 */
	public static void printBoard(int[][] board) {
		
		// print top row
		System.out.printf("%7d", 0);
		for (int i = 1; i < board[0].length; i++ ) {
			System.out.printf("%3d", i);
		}
		System.out.println();
		for(int i = 0; i < 5 + 3*board[0].length; i++) {
			System.out.print("-");
		}
		System.out.println();
		
		for (int i = 0; i < board.length; i++) {
			System.out.printf("%-3d|", i);
			for (int j = 0; j < board[i].length; j++) {
				System.out.printf("%3d", board[i][j]);
			}
			System.out.println();
		}
	}
}
