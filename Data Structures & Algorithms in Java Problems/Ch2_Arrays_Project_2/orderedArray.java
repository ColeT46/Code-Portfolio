import java.util.Random;

/*
 * Edited By: Cole Thomson
 * Date Edited: 9/8/2019
 * Source: Data Structures & Algorithms In Java - LaFore
 * These are programming projects implemented per the instructions in the 
 * book.
 * - 2.4: 	Modify insert, delete, and find so that they use binarySearch
 * - 2.5: 	Implement noDups method to remove duplicates out of array
 * 			
 * Methods Added/Implemented/Edited by Cole Thomson:
 * > Method: insert - edited
 * > Method: delete - edited
 * > Method: find 	- edited
 */
// orderedArray.java
// demonstrates ordered array class
// to run this program: C>java OrderedApp
////////////////////////////////////////////////////////////////
class OrdArray
   {
   private long[] a;                 // ref to array a
   private int nElems;               // number of data items
   //-----------------------------------------------------------
   public OrdArray(int max)          // constructor
      {
      a = new long[max];             // create array
      nElems = 0;
      }
   //-----------------------------------------------------------
   public int size()
      { return nElems; }
   //-----------------------------------------------------------
   public int find(long searchKey)
      {
      int lowerBound = 0;
      int upperBound = nElems-1;
      int curIn;

      // Find index of value to delete: O(log(n))
      while(true)
         {
         curIn = (lowerBound + upperBound ) / 2;
         if(a[curIn]==searchKey)
            return curIn;              // found it
         else if(lowerBound > upperBound)
            return nElems;             // can't find it
         else                          // divide range
            {
            if(a[curIn] < searchKey)
               lowerBound = curIn + 1; // it's in upper half
            else
               upperBound = curIn - 1; // it's in lower half
            }  // end else divide range
         }  // end while
      }  // end find()
   //-----------------------------------------------------------
   public void insert(long value)    // put element into array
      {
	  int lowerBound = 0;
	  int upperBound = nElems-1;
      int curIn;
      
      // find where it goes (binary search - O(log(n)) - EDITED 
      while(true) {
    	  curIn = (lowerBound + upperBound ) / 2;
    	  
    	  // if lower bound >= upperbound, then it goes before/after element
    	  if (lowerBound >= upperBound) {
    		  // if it goes below this spot
    		  if (value <= a[lowerBound]) {
    			  // if not at the first index
        		  if (curIn != 0) {
        			  curIn = lowerBound;
        			  break;
        		  } else {
        			  break; // set as first element
        		  }
    		  }
    		  // else it goes above this spot
    		  else {
    			  curIn = upperBound + 1;
    			  break;
    		  }
    	  }
    	  
    	  // if the value is smaller than the value at the  current index
    	  if(value < a[curIn]) {            // (binary search)
    		  // if not at the first index
    		  if (curIn != 0) {
    			  upperBound = curIn - 1;
    		  } else {
    			  break; // set as first element
    		  }
    	  } 
    	  // if the value is larger than the value at the current index
    	  else if (value > a [curIn]) {
    		  lowerBound = curIn + 1;
    	  }
    	  // else the values equal each other, put it after this spot
    	  else {
    		  curIn = curIn + 1;
    		  break;
    	  }
      }
      
      // Move elements and insert value: O(n)
      for(int k=nElems; k>curIn; k--)    // move bigger ones up
    	  a[k] = a[k-1];
      a[curIn] = value;                  // insert it
      nElems++;                      // increment size
      }  // end insert()
   //-----------------------------------------------------------
   public boolean delete(long value)
      {
      int j = find(value);			 // find index of element O(log(n))
      if(j==nElems)                  // can't find it
         return false;
      else                           // found it
         {
         for(int k=j; k<nElems; k++) // move bigger ones down O(n)
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
   /**
    * Removes duplicates from the array. Finds the duplicates and replaces
    * them with -1 to flag that the element must be removed. Then all -1
    * flags are removed from the array.
    * Time Complexity: O(kn) where k: # dups, n: # elements
    */
   public void noDups() { 
	   long curNum;			// current element while iterating through array
	   int[] dupIndices = new int[nElems]; 	// stores dup indices for quicker delete
	   int curDupIn = 0; 	// current index in duplicate index array
	   
	   // if the array is capable of duplicates, search for them [TC: O(n)]
	   if (nElems > 1) {
		   curNum = a[0];
		   for (int i = 1; i < nElems - 1; i++) {
			   // if next is a dup, fill with -1
			   if(a[i] == curNum) {
				   a[i] = -1;
				   dupIndices[curDupIn] = i;
				   curDupIn++;
				   continue;
			   }
			   curNum = a[i];
		   } 
	   } else {
		   return;
	   }
	   // delete all -1 flags TC: O(kN)
	   deleteDups(dupIndices, curDupIn);
   }
   //-----------------------------------------------------------
   
   /**
    * Helper method for deleting -1 flags in array where duplicates
    * were.
    * Time Complexity: O(kn) where k: # dups, n: # elements
    * @param dupIndices - array of duplicate locations
    * @param numDups - number of duplicate flags to remove
    */
   // Helper method for deleting -1 dup placeholders
   private void deleteDups(int[] dupIndices, int numDups) {
		for (int i = 0; i < numDups; i++) {
			for(int k=dupIndices[i]-i; k<nElems; k++) // move bigger ones down O(n)
	            a[k] = a[k+1];
	         nElems--;                   // decrement size
		}
   }
   }  // end class OrdArray
////////////////////////////////////////////////////////////////



class OrderedApp
   {
   public static void main(String[] args)
      {
      int maxSize = 100;             // array size
      OrdArray arr;                  // reference to array
      arr = new OrdArray(maxSize);   // create the array

      arr.insert(77);                // insert 10 items
      arr.insert(99);
      arr.insert(44);
      arr.insert(55);
      arr.insert(22);
      arr.insert(88);
      arr.insert(11);
      arr.insert(00);
      arr.insert(66);
      arr.insert(33);

      int searchKey = 55;            // search for item
      if( arr.find(searchKey) != arr.size() )
         System.out.println("Found " + searchKey);
      else
         System.out.println("Can't find " + searchKey);

      arr.display();                 // display items

      arr.delete(00);                // delete 3 items
      arr.delete(55);
      arr.delete(99);

      arr.display();                 // display items again
      
      // Insert some duplicates
      arr.insert(77);
      arr.insert(44);
      arr.insert(44);
      arr.insert(44);

      arr.display();                 // display items again

      arr.noDups();					 // remove dups
      
      arr.display();                 // display items again
      
      }  // end main()
   }  // end class OrderedApp