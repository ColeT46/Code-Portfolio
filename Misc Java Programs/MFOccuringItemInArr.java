import java.util.Hashtable;

public class MFOccuringItemInArr {

	/**
	 * Determines the most frequently occurring item in an array. If there
	 * is a tie of most frequent items, returns one that occurs earliest.
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 * @param arr - array to parse for most occurring value
	 * @return mostOccuringItem - most frequent item in array
	 * @throws IllegalStateException if array is empty
	 */
	public static int mFreqItem(int[] arr) throws IllegalStateException {
		Hashtable<Integer, Integer> ht = new Hashtable<Integer,Integer>();
		int mostOccuringItem = 0;
		int mostFreq = 0;
				
		// if array is empty, throw IllegalStateException
		if(arr.length == 0) {
			throw new IllegalStateException("Array Is Empty!");
		}
		
		// Iterate through each element in the array
		for (int i = 0; i < arr.length; i++) {
			// if item is already in ht
			if (ht.get(arr[i]) != null) {
				// update with new count
				ht.replace(arr[i], ht.get(arr[i]) + 1);
			} else {
				// add element to ht
				ht.put(arr[i], 1);
			}
			// If now the most occuring item, update as new max
			if (ht.get(arr[i]) > mostFreq) {
				mostOccuringItem = arr[i];
				mostFreq = ht.get(arr[i]);
			}
		}
		
		return mostOccuringItem;
	}
	
	/**
	 * Main method for testing mFreqItem method.
	 * @param args - unused
	 */
	public static void main(String[] args) {
		int numPassed = 0;
		int numTests = 6;
		
		// Test Inputs
		int[] test1 = {};
		int[] test2 = {0};
		int[] test3 = {0,1,1};
		int[] test4 = {-10,1,0,10,-2,3,1,-1};
		int[] test5 = {3, 2, 2, 4, 1, 4, 3};
		int[] test6 = {Integer.MAX_VALUE, Integer.MIN_VALUE, 0, 1, -1};
		
		// Expected Test Outputs
		//  expOut1 = IllegalStateException
		int expOut2 = 0;
		int expOut3 = 1;
		int expOut4 = 1;
		int expOut5 = 2;
		int expOut6 = Integer.MAX_VALUE;
		
		// Actual Test Outputs
		int actOut1;
		int actOut2;
		int actOut3;
		int actOut4;
		int actOut5;
		int actOut6;
		
		// Run Tests
		
		// Test1
		try {
			actOut1 = mFreqItem(test1);
			System.out.println("test1FAIL: mFreqItem did not throw "
					+ "IllegalStateException on empty array");
		} catch (IllegalStateException e) {
			numPassed++; //correctly caught
		}
		
		// Test2
		try {
			actOut2 = mFreqItem(test2);
			if (actOut2 != expOut2) {
				System.out.println("test2FAIL: mFreqItem returned: " + actOut2
						+ " but expected to return: " + expOut2);
			} else {
				numPassed++;
			}
		} catch (IllegalStateException e) {
			System.out.println("test2FAIL: mFreqItem incorrectly threw " +
					"IllegalStateException");
		}
		
		// Test3
		try {
			actOut3 = mFreqItem(test3);
			if (actOut3 != expOut3) {
				System.out.println("test3FAIL: mFreqItem returned: " + actOut3
						+ " but expected to return: " + expOut3);
			} else {
				numPassed++;
			}
		} catch (IllegalStateException e) {
			System.out.println("test3FAIL: mFreqItem incorrectly threw " +
					"IllegalStateException");
		}
		
		// Test4
		try {
			actOut4 = mFreqItem(test4);
			if (actOut4 != expOut4) {
				System.out.println("test4FAIL: mFreqItem returned: " + actOut4
						+ " but expected to return: " + expOut4);
			} else {
				numPassed++;
			}
		} catch (IllegalStateException e) {
			System.out.println("test4FAIL: mFreqItem incorrectly threw " +
					"IllegalStateException");
		}
			
		// Test5
		try {
			actOut5 = mFreqItem(test5);
			if (actOut5 != expOut5) {
				System.out.println("test5FAIL: mFreqItem returned: " + actOut5
						+ " but expected to return: " + expOut5);
			} else {
				numPassed++;
			}
		} catch (IllegalStateException e) {
			System.out.println("test5FAIL: mFreqItem incorrectly threw " +
					"IllegalStateException");
		}
		
		// Test6
		try {
			actOut6 = mFreqItem(test6);
			if (actOut6 != expOut6) {
				System.out.println("test6FAIL: mFreqItem returned: " + actOut6
						+ " but expected to return: " + expOut6);
			} else {
				numPassed++;
			}
		} catch (IllegalStateException e) {
			System.out.println("test6FAIL: mFreqItem incorrectly threw " +
					"IllegalStateException");
		}
		
		// Print Results
		System.out.println("Method: mFreqItem \n" 
				+ "-Tests Passed: " + numPassed + "\n"
				+ "-Total Tests: " + numTests);
		
		
		

	}
	
	

}
