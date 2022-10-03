/**
 * 
 */
package com.babasureshpal.dsa.arrays.problems;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Suresh Pal
 * Refernces: 
 * https://www.youtube.com/watch?v=XKu_SEDAykw
 * 
 * Problem:
 * Given an array of integers and an integer NUM, find the pair from the array of which sum is equal to the given integer Num
 * 
 * Solution:
 * 1. Bruteforce: Using two nested arrays, loop through the array and sum two elements and check if sum is equal to Num
 * 		Time Complexity: O(n^2)
 * 		Space Complexity: O(1)
 * 2. Assumptions:
 * 		If array is not sorted then we need to sort in the first step
 * 		In this case if given array is sorted. Then perform following steps:
 * 		a) Initialize two pointers low = 0, high = arraysize - 1
 * 		b)  Loop through the array
 * 			i)		If the sum of elements at the high and low indices is less than the num, then increment low
 * 			ii)		If the sum of elements at the high and low indices is greater than the num, then increment high
 * 			iii)	If the sum of elements at the high and low indices is qual to the num, then return the {low, high} pair
 * 		c)	Time Complexity: O(nlogn). O(logn) For binary sorting the array. O(n) for looping through sorted array and finding the pair. 
 * 
 * 3. Finding the pair for the sum without sorting array.
 * 		Let's assume the sum to be found is indicated by sum and the array is indicated by data
 * 		a)	Initialize a Hashset 
 * 		b)	Loop through the array and:
 * 			i)		Check if the compliment of the current element (sum-data[i]) is present in the Hashset.
 * 			ii)		If not then insert it to Hashset and go to next element in the loop
 * 			iii)	else we found the pair, we can return boolean. 
 * 			iv)	
 *
 */
public class FindPairForSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FindPairForSum demo = new FindPairForSum();
		int [] data1 = {1, 2, 3, 9};
		PairSumResult result = demo.findPairInSumBySorting(data1, 8);
		if(result.found) {
			System.out.println("With Sorting Pair ==> {" + result.result[0] + ", " + result.result[1] + "}");
		} else {
			System.out.println("With Sorting Not found");
		}
		data1 = new int[]{1, 2, 3, 9};
		result = demo.findPairInSumWithoutSorting(data1, 8);
		if(result.found) {
			System.out.println("Without Sorting Pair ==> {" + result.result[0] + ", " + result.result[1] + "}");
		} else {
			System.out.println("Without Sorting Not found");
		}
		int [] data2 = {1, 2, 4, 4};
		result = demo.findPairInSumBySorting(data2, 8);
		if(result.found) {
			System.out.println("With Sorting Pair ==> {" + result.result[0] + ", " + result.result[1] + "}");
		} else {
			System.out.println("With Sorting Not found");
		}
		data2 = new int[]{1, 2, 4, 4};
		result = demo.findPairInSumWithoutSorting(data2, 8);
		if(result.found) {
			System.out.println("Without Sorting Pair ==> {" + result.result[0] + ", " + result.result[1] + "}");
		} else {
			System.out.println("Without Sorting Not found");
		}
		int [] data3 = {5, 3, 2, 4};
		result = demo.findPairInSumBySorting(data3, 8);
		if(result.found) {
			System.out.println("With Sorting Pair ==> {" + result.result[0] + ", " + result.result[1] + "}");
		} else {
			System.out.println("With Sorting Not found");
		}
		data3 = new int[]{5, 3, 2, 4};
		result = demo.findPairInSumWithoutSorting(data3, 8);
		if(result.found) {
			System.out.println("Without Sorting Pair ==> {" + result.result[0] + ", " + result.result[1] + "}");
		} else {
			System.out.println("Without Sorting Not found");
		}
		int [] data4 = {5, 6, 4, 2};
		result = demo.findPairInSumBySorting(data4, 8);
		if(result.found) {
			System.out.println("With Sorting Pair ==> {" + result.result[0] + ", " + result.result[1] + "}");
		} else {
			System.out.println("With Sorting Not found");
		}
		data4 = new int[]{5, 6, 4, 2};
		result = demo.findPairInSumWithoutSorting(data4, 8);
		if(result.found) {
			System.out.println("Without Sorting Pair ==> {" + result.result[0] + ", " + result.result[1] + "}");
		} else {
			System.out.println("Without Sorting Not found");
		}

	}

	public PairSumResult findPairInSumBySorting(int [] data, int num) {
		// sort the array first
		int [] result = sort(data);
		
		// initialize the array
		int low = 0;
		int high = result.length - 1;
		
		while(low < high) {
			int sum = result[low] + result[high];
			if(sum == num) {
				PairSumResult res = new PairSumResult();
				res.found = true;
				res.result[0] = result[low];
				res.result[1] = result[high];
				return res;
			} else if(sum < num) {
				low++;
			} else {
				high--;
			}
		}
		return new PairSumResult();
	}
	
	private int[] sort(int [] data) {
		Arrays.sort(data);
		return data;
	}
	


	public PairSumResult findPairInSumWithoutSorting(int [] data, int sum) {
		// initialize a hashset. since here we need to return indices, hence we will use a HashMap. The key will be the compliment and the value will be index in the array
		HashMap<Integer, Integer> map = new HashMap<>();
		// 5, 3, 2, 4
		for(int i = 0; i < data.length; i++) {
			if(map.containsKey(sum - data[i])) {
				PairSumResult result = new PairSumResult();
				result.found = true;
				result.result[0] = data[map.get(sum - data[i])];
				result.result[1] = data[i];
				return result;
			}
			map.put(data[i], i);
		}
		
		return new PairSumResult();
	}
	
}

class PairSumResult {
	boolean found;
	int result[] = new int[2];
}
