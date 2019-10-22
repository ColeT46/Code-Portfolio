import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

public class CommonElements {
	
	/**
	 * Gets the common elements of two arrays and returns an Integer array
	 * of elements in common. (Assumes input arrays are sorted)
	 * Time Complexity: O(max(m,n))
	 * Space Complexity: O(m)
	 * @param arr1 
	 * @param arr2
	 * @return retArr - array containing common elements
	 */
	public static int[] getCommonElements1(int[] arr1, int[] arr2) {
		HashSet<Integer> set1 = new HashSet<Integer>();
		ArrayList<Integer> combined = new ArrayList<Integer>();
		int[] retArr;
		// Add contents of arr1 to set
		for (int i = 0; i < arr1.length; i++) {
			set1.add(arr1[i]);
		}
		
		// Iterate through arr2, if arr1 has common element, add to combined
		for (int j = 0; j < arr2.length; j++) {
			if (set1.contains(arr2[j])) {
				combined.add(arr2[j]);
			}
		}
		
		retArr = new int[combined.size()];
		// transform ArrayList to int[] array
		for (int i = 0; i < combined.size(); i++) {
			retArr[i] = combined.get(i);
		}
		
		return retArr;
	}
	
	/**
	 * Alternative approach to getting the elements in common of two arrays.
	 * This method benefits by saving space due to the removal of the Set used
	 * to store one of the arrays. (Assumes input arrays are sorted)
	 * Time Complexity: O(max(m,n))
	 * Space Complexity: O(c) where c is # elements arrays have in common 
	 * @param arr1
	 * @param arr2
	 * @return retArr - array containing common elements
	 */
	public static int[] getCommonElements2(int[] arr1, int[] arr2) {
		ArrayList<Integer> combined = new ArrayList<Integer>();
		int[] retArr;
		int pointer1 = 0;	// Pointer at index in arr1
		int pointer2 = 0;	// Pointer at index in arr2
		
		// While pointers are valid indices, compare array elements
		while (pointer1 < arr1.length && pointer2 < arr2.length) {
			// check if elements are equal, add to combined and increment pointers
			if (arr1[pointer1] == arr2[pointer2]) {
				combined.add(arr1[pointer1]);
				++pointer1;
				++pointer2;
			}
			// else if element at pointer 1 is greater than element at pointer 2
			else if (arr1[pointer1] > arr2[pointer2]) {
				// increment pointer 2
				++pointer2;
			}
			// else element at pointer 1 is less than element at pointer 2
			else {
				++pointer1;
			}
		}

		retArr = new int[combined.size()];
		// transform ArrayList to int[] array
		for (int i = 0; i < combined.size(); i++) {
			retArr[i] = combined.get(i);
		}
		
		return retArr;
	}
	
	/**
	 * Main method used to test getCommonElements method.
	 * @param args - unused
	 */
	public static void main(String[] args) {
		int numTests = 4;
		int numPassed1 = 0;
		int numPassed2 = 0;
		
		// Test Arrays (1)
		int[][] testArr1 = {{1,3,4,6,7,9},
							{1,2,5,7},
							{0},
							{}};
		// Test Arrays (2)
		int[][] testArr2 = {{1,2,4,5,9,10},
							{1,2,3,4},
							{1,2,3,4,5,6,7},
							{1}};
		// Expected outputs
		int[][] expOut = {{1,4,9},
							 {1,2},
						 	 {},
						 	 {}};
		// Actual outputs for method: getCommonElements1
		int[][] actOut1 = new int[numTests][];
		// Actual outputs for method: getCommonElements2
		int[][] actOut2 = new int[numTests][];
		
		// for each test
		for (int i = 0; i < testArr1.length; i++) {
			actOut1[i] = getCommonElements1(testArr1[i], testArr2[i]);
			actOut2[i] = getCommonElements2(testArr1[i], testArr2[i]);
			
			// check if matches expected for method 1
			if (Arrays.equals(actOut1[i], expOut[i])) {
				numPassed1++;
			} else {
				System.out.println("getCommonElements1Test0" + i + "FAILED");
				System.out.println("-Input Arr 1: " + testArr1[i]);
				System.out.println("-Input Arr 2: " + testArr2[i]);
				System.out.println("-Expected Result: " + expOut[i]);
				System.out.println("-Actual Result: " + actOut1[i]);
				
			}
			
			// check if matches expected for method 2
			if (Arrays.equals(actOut2[i], expOut[i])) {
				numPassed2++;
			} else {
				System.out.println("getCommonElements2Test0" + i + "FAILED");
				System.out.println("-Input Arr 1: " + testArr1[i]);
				System.out.println("-Input Arr 2: " + testArr2[i]);
				System.out.println("-Expected Result: " + expOut[i]);
				System.out.println("-Actual Result: " + actOut2[i]);

			}
		}
		
		// Print Results - method 1
		System.out.println("getCommonElements1 Test Results:");
		System.out.println("- # Passed: " + numPassed1);
		System.out.println("- # Tests: " + numTests);
		// Print Results - method 2
		System.out.println("getCommonElements2 Test Results:");
		System.out.println("- # Passed: " + numPassed2);
		System.out.println("- # Tests: " + numTests);

	}
	


}
