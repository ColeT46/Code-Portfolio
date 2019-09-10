/*
 * Edited By: Cole Thomson
 * Date Edited: 9/8/2019
 * Source: Data Structures & Algorithms In Java - LaFore
 * These are programming projects implemented per the instructions in the 
 * book.
 * - 2.1: 	Implement getMax
 * - 2.2:	Implement removeMax
 * - 2.3: 	develop sorting scheme in main method of HighArrayApp Class to
 * 			get a inversely sorted array
 * 
 * Methods Added/Implemented/Edited by Cole Thomson:
 * > Method: getMax 	- implemented
 * > Method: removeMax	- implemented
 * > Method: main 		- edited
 */

// highArray.java - provided
// demonstrates array class with high-level interface
// to run this program: C>java HighArrayApp
////////////////////////////////////////////////////////////////
class HighArray
   {
   private long[] a;                 // ref to array a
   private int nElems;               // number of data items
   //-----------------------------------------------------------
   public HighArray(int max)         // constructor
      {
      a = new long[max];                 // create the array
      nElems = 0;                        // no items yet
      }
   //-----------------------------------------------------------
   public boolean find(long searchKey)
      {                              // find specified value
      int j;
      for(j=0; j<nElems; j++)            // for each element,
         if(a[j] == searchKey)           // found item?
            break;                       // exit loop before end
      if(j == nElems)                    // gone to end?
         return false;                   // yes, can't find it
      else
         return true;                    // no, found it
      }  // end find()
   //-----------------------------------------------------------
   public void insert(long value)    // put element into array
      {
      a[nElems] = value;             // insert it
      nElems++;                      // increment size
      }
   //-----------------------------------------------------------
   public boolean delete(long value)
      {
      int j;
      for(j=0; j<nElems; j++)        // look for it
         if( value == a[j] )
            break;
      if(j==nElems)                  // can't find it
         return false;
      else                           // found it
         {
         for(int k=j; k<nElems; k++) // move higher ones down
            a[k] = a[k+1];
         nElems--;                   // decrement size
         return true;
         }
      }  // end delete()
   //-----------------------------------------------------------
   public void display()             // displays array contents
      {
      for(int j=0; j<nElems; j++)       // for each element,
         System.out.print(a[j] + " ");  // display it
      System.out.println("");
      }
   //-----------------------------------------------------------
   
   /**
    * Get the maximum element in the array. If the array is empty, return -1.
    * Time Complexity: O(n)
    * @author Cole Thomson
    * @return maximum element in array
    */
   public long getMax() {
	   long tempMax;			// Currently the max element
	   
	   // If array is empty, return -1
	   if (nElems == 0) {
		   return -1;
	   }
	   
	   tempMax = a[0];		// initialize the temporary max 
	   
	   // Find the maximum element - Time Complexity O(n) 
	   for (int i = 1; i < nElems; i++) {
		   // Determine if current element is now maximum found
		   tempMax = (a[i] > tempMax ? a[i] : tempMax);
	   }
	   
	   return tempMax;
   }
  //-----------------------------------------------------------
 
   /**
    * Remove the maximum element in the array and return it from the method. 
    * If there are multiple instances of the maximum element, the first one is
    * removed. If the array is empty, return -1.
    * Time Complexity: O(n)
    * @author Cole Thomson
    * @return maximum element in array
    */
   public long removeMax() {
	  long maxElem = getMax();	// Get max element: O(n)
	  
	  // If a valid max element, delete it from the array: O(n)
	  if (maxElem != -1) {
		  delete(maxElem);
	  }
	  
	   return maxElem;
   }
  //-----------------------------------------------------------
   
   }  // end class HighArray
////////////////////////////////////////////////////////////////
class HighArrayApp
   {
   public static void main(String[] args)
      {
      int maxSize = 100;            // array size
      HighArray arr;                // reference to array
      arr = new HighArray(maxSize); // create the array

      HighArray sortedArr = new HighArray(maxSize); // sorted array (p. 2.3)
      long tempElem;				// temp element in array
      
      arr.insert(77);               // insert 10 items
      arr.insert(99);
      arr.insert(44);
      arr.insert(55);
      arr.insert(22);
      arr.insert(88);
      arr.insert(11);
      arr.insert(00);
      arr.insert(66);
      arr.insert(33);

      arr.display();                // display items

      int searchKey = 35;           // search for item
      if( arr.find(searchKey) )
         System.out.println("Found " + searchKey);
      else
         System.out.println("Can't find " + searchKey);

      arr.delete(00);               // delete 3 items
      arr.delete(55);
      arr.delete(99);

      arr.display();                // display items again
      
      tempElem = arr.removeMax();		// get first max
      
      // make a sorted array array (p. 2.3)
      while (tempElem != -1) {
    	  sortedArr.insert(tempElem); 
    	  tempElem = arr.removeMax();  
      }
      
      // Display sorted array
      System.out.print("Sorted Array: ");
      sortedArr.display();
      
      }  // end main()
   }  // end class HighArrayApp