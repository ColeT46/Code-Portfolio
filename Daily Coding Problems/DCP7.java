import java.util.HashMap;

/*
 * Daily Coding Problem #7
 * Source: dailycodingproblem.com
 * Author: Cole Thomson
 * Date: 09/01/2019
 * TTS: 90
 */

// Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count 
// the number of ways it can be decoded.
//
// For example, the message '111' would give 3, since it could be decoded as 
// 'aaa', 'ka', and 'ak'.
//
// You can assume that the messages are decodable. For example, '001' is not 
// allowed.

/**
 * Main class that contains all fields and methods for solving the proposed
 * problem.
 * @author Cole Thomson
 *
 */
public class DCP7 {
	
	/**
	 * Main method to test methods that solve problem
	 * @param args - unused
	 */
	public static void main(String[] args) {
		int testsPassed = 0;	// number of tests passed
		int testsComplete = 0; 	// number of tests conducted
		
		// Inputs for testing method
		String testIn1 = "111";		
		String testIn2 = "17235";
		String testIn3 = "1234";
		String testIn4 = "21613";
		String testIn5 = "";
		
		// Expected outputs
		int testExpectedOut1 = 3;
		int testExpectedOut2 = 4;
		int testExpectedOut3 = 3;
		int testExpectedOut4 = 6;
		int testExpectedOut5 = 0;
		
		// Actual outputs resulting from testing the method
		int testOut1;
		int testOut2;
		int testOut3;		
		int testOut4;
		int testOut5;
		
		// Test 1
		testOut1 = recursiveCount(testIn1);
		System.out.println("test01recursiveCount \n" 
				+ "-Input: " + testIn1 + "\n" 
				+ "-Expected: " + testExpectedOut1 + "\n"
				+ "-Actual: " + testOut1 + "\n");
		// Check if test is passed
		testsPassed += (testExpectedOut1 == testOut1) ? 1 : 0;
		testsComplete++;
		
		// Test 2
		testOut2 = recursiveCount(testIn2);
		System.out.println("test02recursiveCount \n" 
				+ "-Input: " + testIn2 + "\n" 
				+ "-Expected: " + testExpectedOut2
				+ "\n" + "-Actual: " + testOut2 + "\n");
		// Check if test is passed
		testsPassed += (testExpectedOut2 == testOut2) ? 1 : 0;
		testsComplete++;
		
		// Test 3
		testOut3 = recursiveCount(testIn3);
		System.out.println("test03recursiveCount \n" 
				+ "-Input: " + testIn3 + "\n" 
				+ "-Expected: " + testExpectedOut3
				+ "\n" + "-Actual: " + testOut3 + "\n");
		// Check if test is passed
		testsPassed += (testExpectedOut3 == testOut3) ? 1 : 0;
		testsComplete++;
		
		// Test 4
		testOut4 = recursiveCount(testIn4);
		System.out.println("test04recursiveCount \n" 
				+ "-Input: " + testIn4 + "\n" 
				+ "-Expected: " + testExpectedOut4
				+ "\n" + "-Actual: " + testOut4 + "\n");
		// Check if test is passed
		testsPassed += (testExpectedOut4 == testOut4) ? 1 : 0;
		testsComplete++;
		
		// Test 5
		testOut5 = recursiveCount(testIn5);
		System.out.println("test05recursiveCount \n" 
				+ "-Input: " + testIn5 + "\n" 
				+ "-Expected: " + testExpectedOut5
				+ "\n" + "-Actual: " + testOut5 + "\n");
		// Check if test is passed
		testsPassed += (testExpectedOut5 == testOut5) ? 1 : 0;
		testsComplete++;

		// Display results
		System.out.println("Number of tests completed: " + testsComplete + "\n"
				+ "Number of tests passed: " + testsPassed);
		
	
	}
	/**
	 * Public handle that calls the recursive method to solve the number of 
	 * possible ways that the message can be decoded given the mapping rules:
	 * a = 1, b = 2, ... z = 26. Method assumes that message can be decoded or 
	 * that it is an empty string.
	 * @param msg - message to be decoded
	 * @return number of unique ways that the message can be decoded
	 */
	public static int recursiveCount(String msg) {
		// Filter out empty strings
		if (msg.length() == 0) {
			return 0;
		}
		return recursiveCount(msg, 0);
	}
	
	/**
	 * Recursive method to solve the number of unique possibilities to decode 
	 * the message. The base case of the method is when the message has a 
	 * length of 0 at which point the entire message has been "decoded". The 
	 * method does not store or return the unique possibilities but only the 
	 * number of possibilities that exist. The recursive case is when the 
	 * next one/two characters in the message fall within the range of encoding 
	 * values. The message is pruned accordingly until all possibilites are
	 * determined. 
	 * @param msg - part of message to be decoded
	 * @param possibilities - number of current unique possibilities to decode 
	 * 						  the current string.
	 * @return number of unique ways that the message can be decoded
	 */
	private static int recursiveCount (String msg, int possibilities) {
		
		// Base case: Message is length 0
		if(msg.length() == 0) {
			++possibilities;
			return possibilities;	
		}
		
		// Message length >= 2, try next two characters
		if(msg.length() >= 2
				&& Integer.parseInt(msg.substring(0, 2)) > 0
				&& Integer.parseInt(msg.substring(0,2)) <= 26) {
			// Valid characters
			possibilities = recursiveCount(msg.substring(2), possibilities);
		} 
		// Try next one character
		if(Integer.parseInt(msg.substring(0, 1)) > 0
				&& Integer.parseInt(msg.substring(0,1)) <= 26) {
			// Valid character
			possibilities = recursiveCount(msg.substring(1), possibilities);
		} 
		
		return possibilities;	
	}
}
