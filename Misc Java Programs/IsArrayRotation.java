import java.util.Arrays;

public class IsArrayRotation {
	
	/**
	 * Determines if one array is a rotation of the other. A rotation denotes 
	 * an array that contains the same elements in the same order, but shifted
	 * by integer value 0..length(array)-1. If shifted by a value k greater than
	 * 0, the k values at the end of the array will be the first k values at the
	 * beginning of the rotated array (arrays are circular). Method assumes that no
	 * duplicates are allowed.
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 * @param arr1
	 * @param arr2
	 * @return true if arr2 is a rotation of arr1, and false otherwise
	 */
	public static boolean isRotation(int[] arr1, int[] arr2) {
		int p2 = -1; // pointer to index in array 2
		
		// if arrays not the same length, return false
		if (arr1.length != arr2.length) return false;
		
		// find first element of first array in second array
		for (int i = 0; i < arr2.length; i++) {
			if(arr2[i] == arr1[0]) {
				p2 = i;
				break;
			}
		}
		// if we did not find the element, but size is >0 , return false
		if (p2 == -1 && arr1.length > 0) return false;
		
		// traverse both arrays to ensure that they match
		for (int i = 0; i < arr1.length; i++) {
			// if they dont match, return false
			if(arr2[(i + p2) % arr1.length] != arr1[i]) return false;
		}
		
		// all matched, return true
		return true;
	}
	
	/**
	 * Main method used to test getCommonElements method.
	 * @param args - unused
	 */
	public static void main(String[] args) {
		int numTests = 6;
		int numPassed = 0;
		
		// Test Arrays (1)
		int[][] testArr1 = {{1,2,3,4,5,6,7},
							{0,2,4,6},
							{0,1},
							{},
							{1,2,3,4},
							{12,3,9,6}};
		// Test Arrays (2)
		int[][] testArr2 = {{4,5,6,7,1,2,3},
							{6,0,2,4},
							{1,0},
							{},
							{1,2,3},
							{3,6,9,12}};
		// Expected outputs
		boolean[] expOut = {true, true, true, true, false, false};
		
		// Actual outputs 
		boolean[] actOut = new boolean[numTests];

		
		// for each test
		for (int i = 0; i < numTests; i++) {
			actOut[i] = isRotation(testArr1[i], testArr2[i]);

			
			// check if matches expected for method 1
			if (expOut[i] == actOut[i]) {
				numPassed++;
			} else {
				System.out.println("isRotationTest0" + i + "FAILED");
				System.out.println("-Input Arr 1: " + Arrays.toString(testArr1[i]));
				System.out.println("-Input Arr 2: " + Arrays.toString(testArr2[i]));
				System.out.println("-Expected Result: " + expOut[i]);
				System.out.println("-Actual Result: " + actOut[i]);
				
			}

		}
		// Print Results - method 
		System.out.println("isRotation Test Results:");
		System.out.println("- # Passed: " + numPassed);
		System.out.println("- # Tests: " + numTests);

	}
	
	

}
