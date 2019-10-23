/**
 * Class implements a method to determine if two strings are "off by one" or not.
 * Source: https://www.udemy.com/course/11-essential-coding-interview-questions
 * @author Cole Thomson
 *
 */
public class OneAwayStrings {
	
	/**
	 * Computes if two strings are "one away from each other". One away is defined by
	 * the following transformations from one string to another:
	 * 1) Change: string1 and string2 are identical (have identical characters at
	 *            each index in string) with up to one character that differs 
	 *            between the two strings: ex: "abc" and "zbc"
	 * 2) Delete: string1 and string2 are identical except one character in string1
	 * 			  can be deleted to obtain string2: ex: "abc" and "bc"
	 * 3) Add:	  string1 and string2 are identical except one character can be added
	 * 			  to string1 to obtain string2 (opposite of delete). ex: "bc" and "abc"
	 * If strings are off by one, method returns true, otherwise it returns false.
	 * Time Complexity:  O(n)
	 * Space Complexity: O(1)
	 * @param str1
	 * @param str2
	 * @return true if strings are off by one; and false otherwise
	 */
	public static boolean oneAway(String str1, String str2) {
		
		// If lengths make impossible to be one away
		if (Math.abs(str1.length()-str2.length()) > 1) return false;
		
		// if length of one of the strings is 0 (meaning other is 1 and
		// there by statisfies the one away add/delete edits
		if(str1.length() == 0 || str2.length() == 0) return true;
		
		// If strings are identical, return true
		if (str1.equals(str2)) return true;
		
		// Else determine if these strings are one away
		
		// check for one away by change: O(n)
		if(str1.length() == str2.length()) {
			int numDiff = 0;
			// for each character in string 1
			for (int i = 0; i < str1.length(); i++) {
				// check for equality by index
				if (str1.charAt(i) != str2.charAt(i)) ++numDiff;
				// If exceeded 1 difference, return false
				if (numDiff > 1) return false;
			}
			// There was 1 difference, strings are off by one
			return true;
		}
		
		// check for off by one by delete: O(n)
		else if(str1.length() > str2.length()) {
			int p2 = 0; // pointer for string 2
			int numDiff = 0;
			
			for (int i = 0; i < str1.length(); i++) {
				if (str2.charAt(p2) != str1.charAt(i)) {
					++numDiff;
				} else {
					++p2;
				}
				// If exceeded 1 difference, return false
				if (numDiff > 1) return false;
			}
			// There was 1 difference, strings are off by one
			return true;
		}
		
		// check for off by one by addition O(n)
		else {
			int p1 = 0; // pointer for string 1
			int numDiff = 0;
			for (int i = 0; i < str2.length(); i++) {
				if (str1.charAt(p1) != str2.charAt(i)) {
					++numDiff;
				} else {
					++p1;
				}
				// If exceeded 1 difference, return false
				if (numDiff > 1) return false;
			}
			// There was 1 difference, strings are off by one
			return true;
		}
		
	}
	
	/**
	 * Main method used to test getCommonElements method.
	 * @param args - unused
	 */
	public static void main(String[] args) {
		int numTests = 5;
		int numPassed = 0;
		
		// Test Inputs
		String[] testInputs1 = {"abcde",
							   "abcde",
							   "xyz",
							   "a",
							   "aaabc"};
		
		String[] testInputs2 = {"abfde",
				   				"abde",
				   				"xyaz",
				   				"",
				   				"aabb"};
	

		// Expected outputs
		boolean[] expOut = {true, true, true, true, false};
		
		// Actual outputs 
		boolean[] actOut = new boolean[numTests];

		
		// for each test (1-3)
		for (int i = 0; i < numTests; i++) {
			
			actOut[i] = oneAway(testInputs1[i], testInputs2[i]);
				
			// check if matches expected for method 1
			if (expOut[i] == actOut[i]) {
				numPassed++;
			} else {
				System.out.println("oneAwayTest0" + i + "FAILED");
				System.out.println("-Input String1: " + testInputs1[i]);
				System.out.println("-Input String2: " + testInputs2[i]);
				System.out.println("-Expected Result: " + expOut[i]);
				System.out.println("-Actual Result: " + actOut[i]);
					
				}
			}
		
		// Print Results - method 
		System.out.println("oneAway Test Results:");
		System.out.println("- # Passed: " + numPassed);
		System.out.println("- # Tests: " + numTests);

	
	}
	


}
