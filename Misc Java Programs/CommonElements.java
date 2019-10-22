import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

public class CommonElements {
	
	/**
	 * Gets the common elements of two arrays and returns an Integer array
	 * of elements in common. (Assumes input arrays are sorted)
	 * Time Complexity: O(n)
	 * @param arr1 
	 * @param arr2
	 * @return retArr - array containing common elements
	 */
	public static int[] getCommonElements(int[] arr1, int[] arr2) {
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
	 * Main method used to test getCommonElements method.
	 * @param args - unused
	 */
	public static void main(String[] args) {
		int numTests = 4;
		int numPassed = 0;
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
		// Actual outputs
		int[][] actOut = new int[4][];
		
		// for each test
		for (int i = 0; i < testArr1.length; i++) {
			actOut[i] = getCommonElements(testArr1[i], testArr2[i]);
			// check if matches expected
			if (Arrays.equals(actOut[i], expOut[i])) {
				numPassed++;
			} else {
				System.out.println("getCommonElementsTest0" + i + "FAILED");
				System.out.println("-Input Arr 1: " + testArr1[i]);
				System.out.println("-Input Arr 2: " + testArr2[i]);
				System.out.println("-Expected Result: " + actOut[i]);
				System.out.println("-Actual Result: " + expOut[i]);
				
			}
		}
		
		// Print Results
		System.out.println("getCommonElements Test Results:");
		System.out.println("- # Passed: " + numPassed);
		System.out.println("- # Tests: " + numTests);

	}
	


}
