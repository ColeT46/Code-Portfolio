import java.util.Arrays;

/**
 * Class has implementation of Selection Sort Algorithm (for array of integers)
 * There is one method that implements Selection Sort on an array of ints. 
 * The main method tests the algorithm with a few test cases.
 * Date: 09/24/2019
 * @author Cole Thomson
 *
 */
public class SelectionSort {
	
	/**
	 * Main method for selectionSort method.
	 * @param args - unused
	 */
	public static void main(String[] args) {
		// Test arrays to sort
		int[] test1 = {1,4,2,9,7,5,3,8,6};
		int[] test2 = {};
		int[] test3 = {-10,4,-8,19,0,13};
		int[] test4 = {4,3,2,1,0,-1,-2,4};
		int[] test5 = {1,1,1,1,0,1,-1,-1};
		int[] test6 = {Integer.MAX_VALUE,1,-1,0,Integer.MIN_VALUE};
		
		// Perform selection sort on arrays
		selectionSort(test1);
		selectionSort(test2);
		selectionSort(test3);
		selectionSort(test4);
		selectionSort(test5);
		selectionSort(test6);
		
		// Display results
		System.out.println(Arrays.toString(test1));
		System.out.println(Arrays.toString(test2));
		System.out.println(Arrays.toString(test3));
		System.out.println(Arrays.toString(test4));
		System.out.println(Arrays.toString(test5));
		System.out.println(Arrays.toString(test6));

	}
	
	/**
	 * Implementation of Selection Sort Algorithm. Algorithm has a "sorted"
	 * section and an "unsorted" section of the array. Each pass, it finds the
	 * smallest element in the unsorted section and appends it to the end 
	 * of the sorted section - thereby increasing the length of the sorted
	 * section by 1. Once entire array is in the sorted section, sorting is
	 * done. Algoritm allows duplicates in arr.
	 * Time Complexity: 	O(n^2) - Quadratic
	 * Space Complexity:	O(1)   - Constant
	 * @param arr - array of integers to be sorted
	 */
	public static void selectionSort(int[] arr) {
		int tempSmallest;	// temp smallest in "unsorted" section of arr
		int smallestIndex;	// corresponding index to tempSmallest int
		int temp; 			// used for swapping
			
		// for each element in the array
		for(int i = 0; i < arr.length; i++) {
			tempSmallest = arr[i];	// temp smallest in unsorted section
			smallestIndex = i;		// temp smallest index
			
			// find the smallest element in the unsorted section of array
			for (int j = i; j < arr.length; j++) {
				if(arr[j] < tempSmallest) {
					tempSmallest = arr[j];
					smallestIndex = j;
				}				
			}
			
			// Add smallest element of unsorted section to sorted section
			temp = arr[smallestIndex];
			arr[smallestIndex] = arr[i]; 	
			arr[i] = temp;
		}
	}
}
