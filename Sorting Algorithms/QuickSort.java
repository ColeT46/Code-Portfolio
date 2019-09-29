import java.util.Arrays;
import java.util.Random;

/**
 * Class has implementation of Quick Sort Algorithm (for array of integers)
 * There are two methods that implements Quick Sort on an array of ints. 
 * One method handles putting the pivot in the correct location, and the 
 * other recursively sorts the elements on both sides of the pivot.
 * The main method tests the algorithm with a few test cases.
 * Date: 09/29/2019
 * @author Cole Thomson
 *
 */
public class QuickSort {
	
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
		quickSort(test1, 0, test1.length-1);
		quickSort(test2, 0, test2.length-1);
		quickSort(test3, 0, test3.length-1);
		quickSort(test4, 0, test4.length-1);
		quickSort(test5, 0, test5.length-1);
		quickSort(test6, 0, test6.length-1);

		// Display results
		System.out.println(Arrays.toString(test1));
		System.out.println(Arrays.toString(test2));
		System.out.println(Arrays.toString(test3));
		System.out.println(Arrays.toString(test4));
		System.out.println(Arrays.toString(test5));
		System.out.println(Arrays.toString(test6));
	}
	
	/**
	 * Implementation of Quick Sort Algorithm (single-pivot). 
	 * The agorithm uses a "divide-and-conqour" strategy in
	 * which an element is selected as a pivot, and elements are
	 * recursively placed on the correct side of the selected pivot.
	 * Time Complexity: O(N*log(N)) - Avg, O(N^2) - W.C.
	 * Space Complexity: O(log(N))
	 * @param arr 	- array to be sorted
	 * @param low 	- starting index of recursive sort (inclusive)
	 * @param high 	- ending index of recursive sort (inclusive)
	 */
	public static void quickSort(int[] arr, int low, int high) {
  		int partitionIn = 0;
  		if (low < high) {
   			partitionIn = partition(arr, low, high);
						
			// recursively sort elements before pivot and after pivot
			quickSort(arr, low, partitionIn-1);
			quickSort(arr, partitionIn+1, high);
		}
			
 	}
	
	/**
	 * Determines the pivot and puts the pivot in the correct location
	 * of the current array subsection. The index of the pivot is returned
	 * from the method.
	 * @param arr 	- array to be sorted
	 * @param low	- starting index of current array section 
	 * @param high	- ending index of current array section
	 * @return 		  the index of the pivot
	 */
	public static int partition(int[] arr, int low, int high) {
		Random rand = new Random(14); // FIXME take out seed
		int firstPivot = (Math.abs(rand.nextInt()) % (high-low)) + low;
		int secondPivot = (Math.abs(rand.nextInt()) % (high-low)) + low;
		int thirdPivot = (Math.abs(rand.nextInt()) % (high-low)) + low;
		int pivotIn;	// pivot index=
		int pivot;
		int smallerIn = low; // index of smaller element
		
		// Determine median value of elements at three pivot indices -> pivot
		if (arr[firstPivot] > arr[secondPivot]) {
			if (arr[firstPivot] > arr[thirdPivot]) {
				if (arr[secondPivot] > arr[thirdPivot]) {
					pivotIn = secondPivot;
				} else {
					pivotIn = thirdPivot;
				}
			} else {
				pivotIn = firstPivot;
			}
		} else if (arr[secondPivot] > arr[thirdPivot]) {
			if (arr[thirdPivot] > arr[firstPivot]) {
				pivotIn = thirdPivot;
			} else {
				pivotIn = firstPivot;
			}
		} else {
			pivotIn = secondPivot;
		}
		
		pivot = arr[pivotIn];
		
		// place the pivot in the correct position in the array
		for (int i = low; i <= high; i++) {
			// if element is smaller than pivot, swap
			if (arr[i] < pivot) {
				// swap arr[smallerIn] and arr[i]
				int temp = arr[smallerIn];
				arr[smallerIn] = arr[i];
				arr[i] = temp;
				
				// if temp is the pivot
				if (temp == pivot) {
					//update pivot index
					pivotIn = i;
				}
				
				smallerIn++;
			}
		}
		
		// Put pivot in the correct place
		int temp = arr[smallerIn];
		arr[smallerIn] = arr[pivotIn];
		arr[pivotIn] = temp;
		
		return smallerIn;
		
	}
	
}
