import java.util.LinkedList;
import java.util.Queue;

/**
 * Class represents a game of Chutes and Ladders. There is one method to compute
 * the minimum number of rolls possible to complete the game while using an 
 * n-sided die. 
 * Date: 09/17/2019
 * @author Cole Thomson
 *
 */
public class ChutesAndLadders2 {
	
	/**
	 * Main method for testing minNumMoves method.
	 * @param args - unused
	 */
	public static void main(String[] args) {
		int[] board = initBoard();
		int nDie1 = 4;
		int nDie2 = 6;
		int nDie3 = 8;
		int nDie4 = 10;
		int nDie5 = 12;
		int nDie6 = 20;
		
		
		System.out.println("Minimum number of moves for a(n) " + nDie1
				+ " sided die is: " + minNumMoves(board,nDie1));
		
		System.out.println("Minimum number of moves for a(n) " + nDie2
				+ " sided die is: " + minNumMoves(board,nDie2));
		
		System.out.println("Minimum number of moves for a(n) " + nDie3
				+ " sided die is: " + minNumMoves(board,nDie3));
		
		System.out.println("Minimum number of moves for a(n) " + nDie4
				+ " sided die is: " + minNumMoves(board,nDie4));
		
		System.out.println("Minimum number of moves for a(n) " + nDie5
				+ " sided die is: " + minNumMoves(board,nDie5));
		
		System.out.println("Minimum number of moves for a(n) " + nDie6
				+ " sided die is: " + minNumMoves(board,nDie6));
		
	}
	
	/**
	 * Computes the minimum number of moves needed to get from start 
	 * (position 0) to finish (position 100) on a standard Chutes and Ladders
	 * board using an n-sided Die.
	 * @param board - array representation of the board. Where the element at 
	 * 				  each index is the final location of landing at that spot
	 * @param nDie  - n-sided die that the game is to be played with
	 * @return
	 */
	public static int minNumMoves(int[] board, int nDie) {
		boolean[] visited = new boolean[board.length];	// visited status
		Queue<Node> frontier = new LinkedList<Node>();	// FIFO queue
		Node node = new Node();				// Current node/spot on board
		int currentVertex = 0;				// Node spot as an integer
		int goal = board[board.length-1];	// Goal location (signals finish)
		
		// set start node
		node.vertex = 0;
		node.distance = 0;
		
		// mark node as visited and add to frontier
		visited[0] = true;
		frontier.add(node);
		
		// Do BFS starting at index 0
		while (!frontier.isEmpty()) {
			node = frontier.poll();
			currentVertex = node.vertex;
			
			// if current vertex is destination, we are done
			if (currentVertex == goal) {
				break;
			}
			
			// Add possible spots after move with n-sided die to frontier 
			// if they do not already exist in frontier and haven't been visited
			for (int i = currentVertex + 1; i < currentVertex + nDie
					&& i < board.length; i++) {
				
				// If spot hasn't been visited, visit it
				if(visited[i] == false) {
					Node child = new Node();
					child.distance = node.distance + 1;
					visited[i] = true;
					
					// Determine location of child on board
					child.vertex = board[i];

					frontier.add(child);
				}
			}
		}
		
		return node.distance;
	}

	/**
	 * Initializes the board to a standard Chutes & Ladders board. The element
	 * at each index represents the final location of landing at that spot.
	 * @return array representing game board.
	 */
	private static int[] initBoard() {
		int n = 101;
		int[] board = new int[n];
		
		// initialize positions (not including chutes and ladders)
		for (int i = 0; i < n; i++) {
			board[i] = i;
		}
		
		// add ladders
		board[1] =  38;
		board[4] =  14;
		board[9] =  31;
		board[21] = 42;
		board[36] = 44;
		board[51] = 67;
		board[71] = 91;
		board[80] = 100;
		
		// add slides
		board[16] = 6;
		board[47] = 26;
		board[49] = 11;
		board[56] = 53;
		board[62] = 19;
		board[64] = 60;
		board[93] = 73;
		board[95] = 75;
		board[98] = 78;
		
		return board;
	}
	
	/*
	 * Node class to hold vertex number (spot on board), and the number
	 * of distance it took to get there (number of rolls).
	 */
	static class Node {
		int vertex; 	// vertex number
		int distance; 	// distance from source
	}
}
