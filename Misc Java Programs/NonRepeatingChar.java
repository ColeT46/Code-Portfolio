import java.util.Hashtable;
/**
 * Class implements a method to determine first non-repeating character in a
 * string.
 * Source: https://www.udemy.com/course/11-essential-coding-interview-questions
 * @author Cole Thomson
 *
 */
public class NonRepeatingChar {
	
	/**
	 * Determines the first character in string that only occurs once in string 
	 * (if exists). If no unique character exists or string is empty, an
	 * IllegalStateException is thrown. Method uses a Hashtable to map each 
	 * character to the number of occurrences in the given string. The first
	 * character with 1 occurrence is returned from the method.\
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 * @param str
	 * @return first unique character in string (if one exists)
	 * @throws IllegalStateException if string is empty or a unique character
	 * 								 does not exist.
	 */
	public static char nonRepeatingChar(String str) throws IllegalStateException {
		Hashtable<String, Integer> occurances = new Hashtable<String, Integer>();
		
		// Iterate through string and add chars to HT
		for (int i = 0; i < str.length(); i++) {
			if (occurances.containsKey(str.substring(i, i+1))) {
				occurances.replace(str.substring(i, i+1), 
						occurances.get(str.substring(i, i+1)) + 1);
				
			} else {
				occurances.put(str.substring(i,i+1), 1);
			}
		}
		
		// iterate through string again and return char with first instance of 1 char
		for (int j = 0; j < str.length(); j++) {
			if(occurances.get(str.substring(j, j+1)) == 1) {
				return str.charAt(j);
			}
		}
		
		// did not find an occurrence throw IllegalStateException
		throw new IllegalStateException();
		
	}
	
	/**
	 * Main method used to test getCommonElements method.
	 * @param args - unused
	 */
	public static void main(String[] args) {
		int numTests = 5;
		int numPassed = 0;
		
		// Test Inputs
		String[] testInputs = {"aabcb",
							   "xxyz",
							   "abcdefga",
							   "",
							   "aabb"};
	

		// Expected outputs
		char[] expOut = {'c','y','b'};
		
		// Actual outputs 
		char[] actOut = new char[5];

		
		// for each test (1-3)
		for (int i = 0; i < 3; i++) {
			
			try {
				actOut[i] = nonRepeatingChar(testInputs[i]);
				
				// check if matches expected for method 1
				if (expOut[i] == actOut[i]) {
					numPassed++;
				} else {
					System.out.println("nonRepeatingCharTest0" + i + "FAILED");
					System.out.println("-Input String: " + testInputs[i]);
					System.out.println("-Expected Result: " + expOut[i]);
					System.out.println("-Actual Result: " + actOut[i]);
					
				}
			} catch (IllegalStateException e) {
				System.out.println("nonRepeatingCharTest0" + i + "FAILED");
				System.out.println("Incorrectly threw IllegalStateException");
				System.out.println("-Input String: " + testInputs[i]);
				System.out.println("-Expected Result: " + expOut[i]);
			}

		}
		
		// for tests expected to throw IllegalStateException
		for (int j = 3; j < 5; j++) {
			try {
				actOut[j] = nonRepeatingChar(testInputs[j]);
				
				System.out.println("nonRepeatingCharTest0" + j + "FAILED");
				System.out.println("Did not throw IllegalStateException but one was expected");
				System.out.println("-Input String: " + testInputs[j]);
				System.out.println("-Actual Result: " + actOut[j]);
	
			} catch (IllegalStateException e) {
				// correctly caught exception
				numPassed++;
			}
		}
		// Print Results - method 
		System.out.println("nonRepeatingChar Test Results:");
		System.out.println("- # Passed: " + numPassed);
		System.out.println("- # Tests: " + numTests);

	}

}
