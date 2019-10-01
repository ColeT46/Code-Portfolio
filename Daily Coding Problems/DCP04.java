
/*
 * Daily Coding Problem #4 8/17/2019
 * Source: dailycodingproblem.com
 * Author: Cole Thomson
 * Date: 08/29/2019
 * TTS: 60
 */

// Problem: 
// Given an array of integers, find the first missing positive integer in 
// linear time and constant space. In other words, find the lowest positive 
// integer that does not exist in the array. The array can contain duplicates 
// and negative numbers as well.
//
// For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] 
// should give 3.
//
// You can modify the input array in-place.

public class DCP4 {

	public static void main(String[] args) {
		// Test cases for method
		int[] test1Input = {3, 4, -1, 1};
		int[] test2Input = {1,2,0};
		int[] test3Input = {-1,0,1};
		int[] test4Input = {1,1,1,1};
		int[] test5Input = {-1,-5,0,10,-1,1,2,3,9};
		int[] test6Input = {0,1,2,3,4,5,6,7};
		
		// Test results for method
		int test1Result;
		int test2Result;
		int test3Result;
		int test4Result;
		int test5Result;
		int test6Result;
	
		// Obtain results
		test1Result = missingNum(test1Input);
		test2Result = missingNum(test2Input);
		test3Result = missingNum(test3Input);
		test4Result = missingNum(test4Input);
		test5Result = missingNum(test5Input);
		test6Result = missingNum(test6Input);

		
		// Display results
		System.out.println("Test 1 missingNum: \n"
				+ "-Expected: 2 \n"
				+ "-Actual: " + test1Result + "\n");
		System.out.println("Test 2 missingNum: \n" 
				+ "-Expected: 3 \n"
				+ "-Actual: " + test2Result + "\n");
		System.out.println("Test 3 missingNum: \n" 
				+ "-Expected: 2 \n" 
				+ "-Actual: " + test3Result + "\n");
		System.out.println("Test 4 missingNum: \n" 
				+ "-Expected: 2 \n"
				+ "-Actual: " + test4Result + "\n");
		System.out.println("Test 5 missingNum: \n" 
				+ "-Expected: 4 \n"
				+ "-Actual: " + test5Result + "\n");
		System.out.println("Test 6 missingNum: \n" 
				+ "-Expected: 8 \n"
				+ "-Actual: " + test6Result + "\n");
		
	}

	/**
	 * Determines the first missing positive integer in the array of integers.
	 * (i.e. Finds the lowest positive integer that does not exist in the 
	 * array). Method visits each index of the array and swaps the value at 
	 * the index to its corresponding index of the array (value: k does to 
	 * arr[k]). If the corresponding index does not exist or the value in the 
	 * current index is correct, then the next index is visited. Then, the 
	 * modified array is traversed until a value at an index does not match
	 * that index, in which case that index is returned; otherwise, all values
	 * are in corresponding indices and the smallest missing integer is equal to
	 * the length of the array. Each number in the array is swapped at most 1 
	 * time yielding O(n) time complexity. No additional space is needed since 
	 * array is being modified in-place yielding O(n) space complexity. 
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 * @param arr - array of integers 
	 * @return smallest missing positive integer of the values in the array
	 */
	static int missingNum(int[] arr) {
		int temp = 0; // temporary value for swapping ints in array
		
		// Step 1: Put all positive values in their respective indices O(n)
		for (int i = 0; i < arr.length; i++) {
			// While not the correct value at this index
			while (arr[i] > 0 && arr[i] < arr.length && i != arr[i]) {
				// swap to correct spot
				temp = arr[i];			// number to replace
				arr[i] = arr[temp];		// put number in correct spot
				arr[temp] = temp;			// put replaced number in this spot
				
				// If duplicates, break
				if (arr[i] == arr[temp]) {
					break;
				}
			}
		}
		
		// Iterate through modified array to find first index/value mismatch
		for (int j = 1; j < arr.length; j++) {
			if (arr[j] != j) {
				return j;
			}
		}
		
		// smallest missing int is one bigger than all indices in array
		return arr.length; 
		
	}
}
