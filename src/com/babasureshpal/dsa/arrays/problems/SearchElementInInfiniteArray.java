package com.babasureshpal.dsa.arrays.problems;


/**
 * @author Baba Suresh Pal
 * 	Algorithm:
 * 		Since array is sorted, the first thing clicks into mind is binary search, 
 * 		but the problem here is that we don’t know size of array.
 * 		If the array is infinite, that means we don’t have proper bounds to apply binary search. 
 * 		So in order to find position of key, first we find bounds and then apply binary search algorithm.
 * 		Steps:
 * 			a)	Assume 'key' is the element to be searched.
 * 			b)	Assume 'low' is position of 1st element in array and 'high' is position of an arbitrary 2nd element of array.
 * 			c)	Now compare 'key' with 'high' index element, 
 * 				i)	if it is greater than 'high' index element, then copy 'high' index in 'low' index and double the 'high' index.
 * 				ii)	if it is smaller, then apply 'binary search' on 'high' and 'low' indices found.
 *
 *	Time Complexity:
 *		Let p be the position of element to be searched. 
 *		Number of steps for finding high index ‘h’ is O(Log p). 
 *		The value of ‘h’ must be less than 2*p. 
 *		The number of elements between h/2 and h must be O(p). 
 *		Therefore, time complexity of Binary Search step is also O(Log p) and overall time complexity is 2*O(Log p) 
 *		which is O(Log p). 
 * Reference:	https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/
 */

public class SearchElementInInfiniteArray {

	public static void main(String[] args) {
		int items[] = new int[]{3, 5, 7, 9, 10, 90,  
                100, 130, 140, 160, 170};
		SearchElementInInfiniteArray demo = new SearchElementInInfiniteArray();
		int position = demo.search(items, 170);
		System.out.println("170 is " + (position != Integer.MIN_VALUE ? " Found at ==> " + position : " Not found"));
		System.out.println();
		position = demo.search(items, 130); 
		System.out.println("130 is " + (position != Integer.MIN_VALUE ? " Found at ==> " + position : " Not found"));
		System.out.println();
		 
		position = demo.search(items, 200); 
		System.out.println("200 is " + (position != Integer.MIN_VALUE ? " Found at ==> " + position : " Not found"));
		System.out.println();
		 
		position = demo.search(items, 10); 
		System.out.println("10 is " + (position != Integer.MIN_VALUE ? " Found at ==> " + position : " Not found"));
		System.out.println();
	}

	public int search(int [] input, int key) {
		// base case, 
		// if array has only zero element
		if(input.length == 0) {
			throw new IndexOutOfBoundsException("Please enter array with at least one element");
		}
		// if array has only one element
		if(input.length == 1) {
			if(input[0] == key) { // found
				return 0;
			}
			return Integer.MIN_VALUE; // not found
		}
	
		
		return searchInfiniteArray(input, key);
	}
	
	public int searchInfiniteArray(int [] input, int key) { // this method assumes array size is more than 1
		int low = 0;
		int high = 1; // start from index 1
		int value = input[1];
		while(value < key) {
			if(high * 2 >= input.length) { // break the loop
				low = high;
				high = input.length - 1;
				break;
			} else {
				low = high;
				high = high * 2;
				value = input[high];
			}
		}
//		System.out.println("low ==> " + low + " -:- high ==> " + high);
		return binarySearch(input, key, low, high);
	}
	
	public int binarySearch(int [] items, int key, int left, int right) {
		if(right >= left) {
			int middle = left + (right - left) /2;
			if(items[middle] == key) {
				return middle;
			}
			if(items[middle] > key) {
				return binarySearch(items, key, left, middle - 1);
			}
			return binarySearch(items, key, middle + 1, right);
		} 
		return Integer.MIN_VALUE;
	}
}
