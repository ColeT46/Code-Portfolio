import java.util.ArrayList;

/*
 * Daily Coding Problem #9
 * Source: dailycodingproblem.com
 * Author: Cole Thomson
 * Date: 09/21/2019
 * TTS: 20
 */

// Implement an autocomplete system. That is, given a query string s and a set 
// of all possible query strings, return all strings in the set that have s as 
// a prefix.

// For example, given the query string de and the set of strings:
// [dog, deer, deal], return [deer, deal].
/**
 * Main class that contains all fields and methods for solving the proposed
 * problem.
 * @author Cole Thomson
 *
 */
public class DCP11 {
	/**
	 * Main method to test methods that solve problem
	 * @param args - unused
	 */
	public static void main(String[] args) {
		// Test Inputs
		String[] testInSet1 = new String[] {"dog", "deer", "deal"};
		String testQuery1 = "de";
		
		String[] testInSet2 = new String[] {"hippo", "hits", "hipster"};
		String testQuery2 = "hip";
		
		String[] testInSet3 = new String[] {};
		String testQuery3 = "dog";
		
		String[] testInSet4 = new String[] {"Green Bay", "Chicago", "Detroit",
											"Minnesota", "Madison"};
		String testQuery4 = "M";
		
		// Get Results
		ArrayList<String> testOut1 = queryStrings(testInSet1, testQuery1);
		ArrayList<String> testOut2 = queryStrings(testInSet2, testQuery2);
		ArrayList<String> testOut3 = queryStrings(testInSet3, testQuery3);
		ArrayList<String> testOut4 = queryStrings(testInSet4, testQuery4);
		
		// Display Results
		System.out.println("Test Output 1: " + testOut1);
		System.out.println("Test Output 2: " + testOut2);
		System.out.println("Test Output 3: " + testOut3);
		System.out.println("Test Output 4: " + testOut4);

	}
	
	/**
	 * Returns query strings based on a prefix and a set of strings. For each
	 * string in the set of strings, if the prefix with the same number 
	 * of characters as the desired prefix have the same value (prefixes match)
	 * then that string is added to the ArrayList of queries to be returned.
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 * @param 	stringSet 	- set of strings to search
	 * @param 	query		- prefix to search for in set of strings
	 * @return 	queries 	- strings that have the matching query provided
	 */
	public static ArrayList<String> queryStrings(String[] stringSet, String query) {
		ArrayList<String> queries = new ArrayList<String>();
		
		// for each string in the given set, check if prefix matches query
		for (int i = 0; i < stringSet.length; i++ ) {
			if(stringSet[i].substring(0, query.length()).equals(query)) {
				// prefix matches, add to return list of queries
				queries.add(stringSet[i]);
			}
		}
		return queries;
	}

}
