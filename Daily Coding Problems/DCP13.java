import java.util.Arrays;
import java.util.HashSet;

/*
 * Daily Coding Problem #13
 * Source: dailycodingproblem.com
 * Author: Cole Thomson
 * Date: 10/01/2019
 * TTS: 30
 */

// Given an integer k and a string s, find the length of the longest substring
// that contains at most k distinct characters.
//
// For example, given s = "abcba" and k = 2, the longest substring with k 
// distinct characters is "bcb".


/**
 * Main class that contains all fields and methods for solving the proposed
 * problem.
 * @author Cole Thomson
 *
 */
public class DCP13 {
	/**
	 * Main method to test methods that solve problem
	 * @param args - unused
	 */
	public static void main(String[] args) {
		int numTests = 7;
		int method1Passed = 0;				// number tests passed m-1
		int[] testInputKs = new int[numTests];
		int[] expectedResults = new int[numTests];
		int[] actualResults = new int[numTests];
		String[] testInputStrings = new String[numTests];
		
		// Test Cases
		testInputStrings[0] = "abcba";		// T-1
		testInputKs[0] = 2;					// T-1
		
		testInputStrings[1] = "bbbbbbaabb"; // T-2
		testInputKs[1] = 2;					// T-2
		
		testInputStrings[2] = "";			// T-3
		testInputKs[2] = 4;					// T-3
		
		testInputStrings[3] = "abcdd";		// T-4
		testInputKs[3] = 1;					// T-4
		
		testInputStrings[4] = "abcdefghii";	// T-5
		testInputKs[4] = 8;					// T-5
		
		testInputStrings[5] = "aabbcccdddd";// T-6
		testInputKs[5] = 3;					// T-6
		
		testInputStrings[6] = "aabbba";		// T-7
		testInputKs[6] = 1;					// T-7
		
		
		// Expected results for each test
		expectedResults[0] = 3;				// T-1
		expectedResults[1] = 10;			// T-2
		expectedResults[2] = 0;				// T-3
		expectedResults[3] = 2;				// T-4
		expectedResults[4] = 9;				// T-5
		expectedResults[5] = 9;				// T-6
		expectedResults[6] = 3;				// T-7
		
		// Run tests & verify results
		System.out.println("Running " + numTests + " tests on methods: \n" 
				+ "-longestSS \n");
		for (int i = 0; i < numTests; i++) {
			actualResults[i] = longestSS(testInputKs[i], testInputStrings[i]);
			
			// Verify method - longestSS
			if (actualResults[i] != expectedResults[i]) {
				System.out.println("test0" + i + "longestSS FAILED \n"
						+ "-Input String: " + testInputStrings[i] + "\n"
						+ "-Input k: " + testInputKs[i] + "\n"
						+ "-Expected: " + expectedResults[i] + "\n"
						+ "-Actual: " + actualResults[i] + "\n");
			} else {
				method1Passed++;
			}
		}
		
		// Display Results
		System.out.println("Test Results: \n"
				+ "Number of Tests: " + numTests + "\n" 
				+ "longestSS - Passed: " + method1Passed);

	}

	/**
	 * Determines the length of the longest substring that contains at most k
	 * distinct characters. Method uses a brute force approach in that it
	 * starts at the beginning of the string and generates the longest 
	 * substring with k distinct characters from each character in the string.
	 * Method breaks out early if the longest substring already found is longer
	 * than the length of the following substrings to be checked. This allows
	 * for minor speed improvements (better with smaller string length and 
	 * large k and worse with large string length and small k).
	 * Time Complexity:  O(n^2)
	 * Space Complexity: O(k) -> (since HashSet can hold at most k elements)
	 * @param k - number of distinct characters allowed in substring
	 * @param s - string to be examined
	 * @return longestLength - length of longest substring of k distinct chars
	 */
	public static int longestSS(int k, String s) {
		int longestLength = 0;
		int currentLength = 0;
		String currentCharacter = "";
		HashSet<String> charInCurrentSS = new HashSet<String>();
	
		// for each character in the string
		for (int i = 0; i < s.length(); i++) {
			// Breakout early if longest length is longer than remaining str
			if (s.length() - i - longestLength <= 0) return longestLength;
			// find longest substring from the starting character
			for (int j = i; j < s.length(); j++) {
				currentCharacter = s.substring(j,j+1);
				// if the character has already been seen
				if (charInCurrentSS.contains(currentCharacter)) {
					currentLength++;
					longestLength = (currentLength > longestLength)
									? currentLength : longestLength;
				}
				// else if there is 0 to k-1 unique chars in substring
				else if (charInCurrentSS.size() < k) {
					// add character to set of seen characters
					charInCurrentSS.add(currentCharacter);
					currentLength++;
					longestLength = (currentLength > longestLength)
									? currentLength : longestLength;
				}
				// else we have run out of k unique characters
				else {
					// reset temporary variables/objects
					currentLength = 0;
					charInCurrentSS.clear();
					break;
				}
			}
		}	
		return longestLength;
	}
}
