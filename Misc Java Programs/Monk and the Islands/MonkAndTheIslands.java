import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Class represents a player named "Monk" trying to get find the shortest path
 * to the last "island" (node) given a set of bi-directional "bridges" (arcs) from
 * pairs of islands. 
 * @author Cole Thomson
 *
 */
public class MonkAndTheIslands {
	/**
	 * Main method for testing minNumMoves method.
	 * @param args - unused
	 */
	public static void main(String[] args) {
		String inputFile = "inputData03.txt";
		Graph islands = initGraph(inputFile);
		int n = 8;
		System.out.println(getMinBridges(islands.getIsland(1),n));

	}
	
	/**
	 * Computes the minimum number of moves needed to get from starting island
	 * (island 1) to ending island (or goal). Method uses a Breadth-First Search 
	 * approach since it is assumed that all distances between islands are the
	 * same. 
	 * @param start - starting island to begin search
	 * @param goal - goal island number 
	 * @return minimum number of moves to get from start island to goal island
	 */
	public static int getMinBridges(Island start, int goal) {
	
		Queue<Island> frontier = new LinkedList<Island>();	// FIFO queue
		HashSet<Integer> visited = new HashSet<Integer>();	// visited islands
		Island current = start;				// current island
		current.distance = 0;				// distance from start
		
		// Add start node to frontier and visit node
		frontier.add(current);			
		visited.add(current.islandNum);
		
		// While the frontier is not empty, expand the next node
		while(!frontier.isEmpty()) {
			current = frontier.poll();
			
			// Goal state condition
			if (current.islandNum == goal) {
				return current.distance;
			}
			
			// for each successor of the current node, add and visit
			for (Island neighbor : current.neighbors) {
				if (!visited.contains(neighbor.islandNum)) {
					neighbor.distance = current.distance + 1;
					frontier.add(neighbor);
					visited.add(neighbor.islandNum);
				}	
			}
		}
		return -1; // Failure
	}
	
	/**
	 * Initializes group of islands (graph) using a file of 
	 * bridges (arcs) between islands (nodes). 
	 * 
	 * @param fileName - name of .txt file to read arc data from
	 * @return islands - graph of islands in island network
	 */
	private static Graph initGraph(String fileName) {
		Graph islands = new Graph();	// Graph object to be built/returned
		FileInputStream inFile = null;	// FIStream using fileName
		Scanner input = null;			// Scanner of input data
		Island island1 = null;			// Island 1 of new arc (from)
		Island island2 = null;			// Island 2 of new arc (to)
		
		try {
			inFile = new FileInputStream(fileName);
			input = new Scanner(inFile);
			
			// While there is more graph data, add new arc to graph
			while(input.hasNextLine()) {
				String[] lineParts = input.nextLine().split(" ");
				int i1 = Integer.parseInt(lineParts[0]);
				int i2 = Integer.parseInt(lineParts[1]);
				
				// Create island 1, or get it from graph
				if(!islands.contains(i1)) {
					island1 = new Island(i1);
					islands.islands.add(island1);
				} else {
					island1 = islands.getIsland(i1); 
				}
				
				// Create island 2, or get it from graph
				if(!islands.contains(i2)) {
					island2 = new Island(i2);
					islands.islands.add(island2);
				} else {
					island2 = islands.getIsland(i2); 
				}
				
				// Add as neighbors to each other (undirected bridge)
				island1.neighbors.add(island2);
				island2.neighbors.add(island1);
				
			}
			
			input.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return islands;
	}

}


/**
 * Class represents an Island object. An Island contains its closest distance
 * from the start island in the network of islands as well as its identifying
 * island number. The Island also contains its neighbors, or Islands that it can
 * get to from itself (via bi-directional bridges).
 * @author Cole Thomson
 *
 */
class Island {
	ArrayList<Island> neighbors;
	int distance;
	int islandNum;
	Island(int islandNum) {
		this.neighbors = new ArrayList<Island>();
		this.islandNum = islandNum;
	}
}

/**
 * Class represents a Graph object. A Graph is a network or collection of Islands 
 * connected to each other with bi-directional bridges. The Graph contains the 
 * collection of Islands, as well as methods to check if Graph contains a specific
 * Island and a method that retrieves an Island instance from the Graph.
 * @author Big Green Watermelon
 *
 */
class Graph {
	ArrayList<Island> islands;
	
	Graph() {
		this.islands = new ArrayList<Island>();
	}
	
	boolean contains(int islandNum) {
		for (Island current : islands) {
			if (current.islandNum == islandNum) return true;
		}
		return false;
	}
	
	Island getIsland(int islandNum) {
		for(Island current : islands) {
			if (current.islandNum == islandNum) return current;
		}
		return null;
	}
}
