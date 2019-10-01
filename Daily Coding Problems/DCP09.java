import java.util.Arrays;

/*
 * Daily Coding Problem #9
 * Source: dailycodingproblem.com
 * Author: Cole Thomson
 * Date: 09/05/2019
 * TTS: 120
 */

// Given a list of integers, write a function that returns the largest sum of 
// non-adjacent numbers. Numbers can be 0 or negative.
//
// For example, [2, 4, 6, 2, 5] should return 13, since we pick 2, 6, and 5. 
// [5, 1, 1, 5] should return 10, since we pick 5 and 5.
//
// Follow-up: Can you do this in O(N) time and constant space?

/**
 * Main class that contains all fields and methods for solving the proposed
 * problem.
 * @author Cole Thomson
 *
 */
public class DCP9 {
	/**
	 * Main method to test methods that solve problem
	 * @param args - unused
	 */
	public static void main(String[] args) {
		int numTests = 7; 							// number of tests
		int method1Passed = 0;						// number tests passed m-1
		int method2Passed = 0;						// number tests passed m-2
		int[][] testInputs = new int[numTests][];	// test inputs
		int[] expectedResults = new int [numTests];	// expected test results
		int[] actualResults1 = new int[numTests];	// actual test results m-1
		int[] actualResults2 = new int[numTests];	// actual test results m-1

		// Test cases
		testInputs[0] = new int[] {2, 4, 6, 2, 5};
		testInputs[1] = new int[] {5, 1, 1, 5};
		testInputs[2] = new int[] {};
		testInputs[3] = new int[] {1};		
		testInputs[4] = new int[] {-1};
		testInputs[5] = new int[] {-1, -2, -4};
		testInputs[6] = new int[] {1, 5, 0, -3, 8, 2, -10, 11};

		// Expected results for each test
		expectedResults[0] = 13;
		expectedResults[1] = 10;
		expectedResults[2] = 0;
		expectedResults[3] = 1;
		expectedResults[4] = -1;
		expectedResults[5] = -1;
		expectedResults[6] = 24;
		
		// Run tests & verify results
		System.out.println("Running " + numTests + " tests on methods: \n" 
				+ "-largestNonAdjSum1 \n"
				+ "-largestNonAdjSum2");
		
		System.out.println(); // for console format
		
		for (int i = 0; i < numTests; i++) {
			actualResults1[i] = largestNonAdjSum1(testInputs[i]);
			actualResults2[i] = largestNonAdjSum2(testInputs[i]);
			
			// Verify method 1
			if (actualResults1[i] != expectedResults[i]) {
				System.out.println("test0" + i + "largestNonAdjSum1 FAILED \n"
						+ "-Input: " + Arrays.toString(testInputs[i]) + "\n"
						+ "-Expected: " + expectedResults[i] + "\n"
						+ "-Actual: " + actualResults1[i]);
			} else {
				method1Passed++;
			}
			
			// Verify method 2
			if (actualResults2[i] != expectedResults[i]) {
				System.out.println("test0" + i + "largestNonAdjSum2 FAILED \n"
						+ "-Input: " + Arrays.toString(testInputs[i]) + "\n"
						+ "-Expected: " + expectedResults[i] + "\n"
						+ "-Actual: " + actualResults2[i]);
			} else {
				method2Passed++;
			}
		}
		
		System.out.println(); // for console format
		
		// Display Results
		System.out.println("Test Results: \n"
				+ "Number of Tests: " + numTests + "\n" 
				+ "largestNonAdjSum1 - Passed: " + method1Passed + "\n"
				+ "largestNonAdjSum2 - Passed: " + method2Passed);
	
		
	}
	
	/**
	 * Determines the largest sum of non-adjacent integers. Uses a cache of the
	 * largest sum of non-adjacent numbers while iterating through the array
	 * of integers. If the maximum non-adjacent cache sum plus the current
	 * number is greater than the adjacent cache, then the current number is
	 * added to the non-adjacent cache and this sum becomes the largest 
	 * non-adjacent sum found, else the adjacent cache remains the largest
	 * non-adjacent sum found.  
	 * Time Complexity: O(n)
	 * Space Complexity: O(n) 
	 * @param arr - array of integers
	 * @return largest sum of non-adjacent integers in array
	 */
	public static int largestNonAdjSum1(int[] arr) {
		int[] cache = new int[arr.length]; // Cache of largest sum
		int temp; // current number when iterating through array
		
		// If the array is length 0, 1, or 2
		if (arr.length == 0) {
			return 0;
		} else if (arr.length == 1) {
			return arr[0];
		} else if (arr.length == 2) {
			return Integer.max(arr[0], arr[1]);
		}
		
		// Cache first two numbers
		cache[0] = arr[0];
		cache[1] = Integer.max(cache[0], arr[1]);
		
		// Iterate through numbers while caching the largest n-a sum
		for (int i = 2; i < arr.length; i++) {
			temp = arr[i];
			// Cache the max of: 
			// 1. current int plus the non-adjacent cache (sum)
			// 2. the adjacent cache
			cache[i] = Integer.max(temp + cache[i-2], cache[i-1]);
		}
		
		return cache[cache.length-1];
		
	}

	/**
	 * Determines the largest sum of non-adjacent integers. Uses a cache of the
	 * largest sum of non-adjacent numbers while iterating through the array
	 * of integers. If the maximum non-adjacent cache sum plus the current
	 * number is greater than the adjacent cache, then the current number is
	 * added to the non-adjacent cache and this sum becomes the largest 
	 * non-adjacent sum found, else the adjacent cache remains the largest
	 * non-adjacent sum found. NOTE: uses two integer fields for cache since
	 * only the non-adjacent and adjacent caches are needed at any given time. 
	 * This allows us to achieve O(1) Space complexity.
	 * Time Complexity: O(n)
	 * Space Complexity: O(1) 
	 * @param arr - array of integers
	 * @return largest sum of non-adjacent integers in array
	 */
	public static int largestNonAdjSum2(int[] arr) {
		int cache1; // non-adjacent cache
		int cache2; // adjacent cache
		int largestSum = 0; // largest non-adjacent sum 
		
		// If the array is length 0, 1, or 2
		if (arr.length == 0) {
			return 0;
		} else if (arr.length == 1) {
			return arr[0];
		} else if (arr.length == 2) {
			return Integer.max(arr[0], arr[1]);
		}
		
		// Cache first two numbers
		cache1 = arr[0];
		cache2 = Integer.max(cache1, arr[1]);
		
		// Iterate through array of ints O(n) Time
		for (int i = 2; i < arr.length; i++) {
			// Largest sum is the max of:
			// 1. current int plus the non-adjacent cache
			// 2. the adjacent cache
			largestSum = Integer.max(arr[i] + cache1, cache2);
			
			cache1 = cache2; 		// update non-adjacent cache
			cache2 = largestSum;	// update adjacent cache
		}
		
		return largestSum;
		
	}
	
}
