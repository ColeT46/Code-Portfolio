import java.util.Arrays;

/*
 * Daily Coding Problem #3 8/17/2019
 * Source: dailycodingproblem.com
 * Author: Cole Thomson
 * Date: 08/20/2019
 */

// Problem: 
// Given an array of integers, return a new array such that each element at 
// index i of the new array is the product of all the numbers in the original 
// array except the one at i.
//
// For example, if our input was [1, 2, 3, 4, 5], the expected output would be 
// [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would 
// be [2, 3, 6].
//
// Follow-up: what if you can't use division?

public class Main3 {
	
	/**
	 * Main method to test methods that solve problem
	 * @param args - unused
	 */
	public static void main(String[] args) {
		int[] testInput1 = {1,2,3,4,5}; // input from example 1 in problem
		int[] testInput2 = {3,2,1};		// input from example 2 in problem
		int[] testOutput11;				// result of Test 1.1
		int[] testOutput12;				// result of Test 1.2
		int[] testOutput21;				// result of Test 2.1
		int[] testOutput22;				// result of Test 2.
		
		// Tests: modifiedArrayWithDivision 
		System.out.println("Tests: modifiedArrayWithDivision");
		
		// Test 1.1 (Case: example 1 in problem statement)
		testOutput11 = modifiedArrayWithDivision(testInput1);
		System.out.println("-Test 1.1 Input: " + Arrays.toString(testInput1));
		System.out.println("-Test 1.1 Output: " + Arrays.toString(testOutput11));
		System.out.println();
		
		// Test 1.2 (Case: example 2 in problem statement)
		testOutput12 = modifiedArrayWithDivision(testInput2);
		System.out.println("-Test 1.2 Input: " + Arrays.toString(testInput2));
		System.out.println("-Test 1.2 Output: " + Arrays.toString(testOutput12));
		System.out.println();
		
		// Tests: modifiedArrayWithoutDivision 
		System.out.println("Tests: modifiedArrayWithoutDivision");
		
		// Test 2.1 (Case: example 1 in problem statement)
		testOutput21 = modifiedArrayWithoutDivision(testInput1);
		System.out.println("-Test 2.1 Input: " + Arrays.toString(testInput1));
		System.out.println("-Test 2.1 Output: " + Arrays.toString(testOutput21));
		System.out.println();
		
		// Test 2.2 (Case: example 2 in problem statement)
		testOutput22 = modifiedArrayWithoutDivision(testInput2);
		System.out.println("-Test 2.2 Input: " + Arrays.toString(testInput2));
		System.out.println("-Test 2.2 Output: " + Arrays.toString(testOutput22));
		
	}
	
	/**
	 * Multiplies all of the numbers in the original array to get total product.
	 * Then, at each index the total product is divided by the number at that 
	 * index in the original array to determine result at index for array to be
	 * returned.
	 * Time Complexity: O(n)
	 * @param original - original array to use as basis for calculations
	 * @return newArr - array where each index is the product of numbers at all
	 * 				    indices except its own from original array.
	 */
	static int[] modifiedArrayWithDivision(int[] original) {
		int[] newArr = new int[original.length];
		int totalProduct = 1;
		
		// Get the product of all numbers in array
		for (int i = 0; i < original.length; i++) {
			totalProduct *= original[i];
		}
		
		// Divide product by int at index to determine final array
		for (int i = 0; i < newArr.length; i++) {
			newArr[i] = totalProduct / original[i];
		}
		
		return newArr;
	}
	
	/**
	 * Multiplies all numbers in original array except for the number in the 
	 * corresponding index from the new array, and then saves that product
	 * to that index of the new array. 
	 * Time Complexity: O(n^2)
	 * @param original - original array to use as basis for calculations
	 * @return newArr - array where each index is the product of numbers at all
	 * 				    indices except its own from original array.
	 */
	static int[] modifiedArrayWithoutDivision(int[] original) {
		int[] newArr = new int[original.length];
		int tempProduct = 1;
		
		// For each index in new array
		for (int i = 0; i < newArr.length; i++) {
			// For each int in original array
			for (int j = 0; j < original.length; j++) {
				// If not the current index, multiply number by tempProduct
				if (j != i) {
					tempProduct *= original[j];
				}
			}
			newArr[i] = tempProduct; // Store product in current array index
			tempProduct = 1; // Reset product
		}
		return newArr;
	}
}
