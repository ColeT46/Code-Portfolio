import java.util.Arrays;

/**
 * Class has implementation of Insertion Sort Algorithm (for array of integers)
 * There is one method that implements Insertion Sort on an array of ints. 
 * The main method tests the algorithm with a few test cases.
 * Date: 09/28/2019
 * @author Cole Thomson
 *
 */
public class InsertionSort {

	/**
	 * Main method for selectionSort method.
	 * @param args - unused
	 */
	public static void main(String[] args) {
		// Test arrays to sort
		int[] test1 = { 1, 4, 2, 9, 7, 5, 3, 8, 6 };
		int[] test2 = {};
		int[] test3 = { -10, 4, -8, 19, 0, 13 };
		int[] test4 = { 4, 3, 2, 1, 0, -1, -2, 4 };
		int[] test5 = { 1, 1, 1, 1, 0, 1, -1, -1 };
		int[] test6 = { Integer.MAX_VALUE, 1, -1, 0, Integer.MIN_VALUE };

		// Perform selection sort on arrays
		insertionSort(test1);
		insertionSort(test2);
		insertionSort(test3);
		insertionSort(test4);
		insertionSort(test5);
		insertionSort(test6);

		// Display results
		System.out.println(Arrays.toString(test1));
		System.out.println(Arrays.toString(test2));
		System.out.println(Arrays.toString(test3));
		System.out.println(Arrays.toString(test4));
		System.out.println(Arrays.toString(test5));
		System.out.println(Arrays.toString(test6));
	}
	
	/**
	 * Implementation of Insertion Sort Algorithm. Algorithm has a "sorted"
	 * section and an "unsorted" section of the array. Each pass, it swaps the 
	 * first element in the unsorted section with the last element in the 
	 * sorted section until the next element in the sorted section is not 
	 * larger than the element to be inserted. The size of the sorted section
	 * grows by one and the algorithm continues until all unsorted elements are
	 * added to the sorted section of the array.
	 * Time Complexity: 	O(n^2) - Quadratic [O(n) for nearly sorted array]
	 * Space Complexity:	O(1)   - Constant
	 * @param arr - array of integers to be sorted
	 */
	public static void insertionSort(int[] arr) {
 		int elementToInsert = 0; 	// element to insert into correct position in the array
		int j = 0;
		
		// for each element in the array
		for (int i = 1; i < arr.length; i++) {
			elementToInsert = arr[i];	// element to insert in correct location
			j = i - 1;
			// Swap all elements that are greater than the element to insert
			while (j >= 0 && arr[j] > elementToInsert) {
				arr[j+1] = arr[j];
				j--;
			}
			// Put element in correct position
			arr[j+1] = elementToInsert;
		}
	}

}
