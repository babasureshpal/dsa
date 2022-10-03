/**
 * 
 */
package com.babasureshpal.dsa.graph.problems;

/**
 * @author Baba Suresh Pal
 * Problem: Given an array of non-negative numbers and a non-negative number k, 
 * 			find the number of subarrays having sum less than k. 
 * 			We may assume that there is no overflow.
 * Examples:  
 * 		a)	Input: 
 * 				arr[] = {2, 5, 6}
 * 				K = 10
 * 			Output: 
 * 				4
 * 				The subarrays are {2}, {5}, {6} and {2, 5},
 * 		b)	Input: 
 * 				arr[] = {1, 11, 2, 3, 15}
 * 				K = 10
 * 			Output: 
 * 				4
 * 				The subarrays are {1}, {2}, {3} and {2, 3}
 * 
 * Solution:
 * 1. BruteForce: A simple solution will be to generate all subarrays of the array 
 * 					and then count the number of arrays having sum less than K
 * 	Time complexity : O(n^2).
 * 2. Efficient Solution: 
 * 		An efficient solution is based on a sliding window technique that can be used to solve the problem. 
 * 		We use two pointers start and end to represent starting and ending points of the sliding window. 
 * 		(Note that we need to find contiguous parts).
 * 		Initially both start and end point to the beginning of the array, i.e. index 0. 
 * 		Now, let’s try to add a new element X. 
 * 		There are two possible conditions.
 * 		Case 1: 
 * 			If sum is less than k, increment end by one position. 
 * 			So contiguous arrays this step produce are (end – start). 
 * 			We also add X to previous sum. There are as many such arrays as the length of the window.
 * 		Case 2: 
 * 			If sum becomes greater than or equal to k, 
 * 			this means we need to subtract starting element from sum so that the sum again becomes less than k. 
 * 			So we adjust the window’s left border by incrementing start.
 * 		We follow the same procedure until end < array size.
 * 
 * References:
 * 		1.	https://www.geeksforgeeks.org/number-subarrays-sum-less-k/
 * 		
 */
public class CountMinimumSubArrays {

	public static void main(String[] args) {
		CountMinimumSubArrays demo = new CountMinimumSubArrays();
		int array[] = { 1, 11, 2, 3, 15};
		int k = 10;
		int count = demo.bruteForceCountSubArray(array, k);
		System.out.println(count);
		
		count = demo.efficientCountSubArray(array, k);
		System.out.println(count);
	}

	public int efficientCountSubArray(int data[], int k) {
		int start = 0; 
		int end = 0;
		int count = 0;
		int sum = data[0];
		while(start < data.length && end < data.length) {
			if(sum < k) {
				// if sum is less than k, then end is to be incremented by one position. 
				// Also count and sum are to be updated
				end++;
				if(end >= start) {
					count += end - start;
				}
				
				if(end < data.length) {
					sum += data[end];
				}
			} else {
				// If sum is greater than or equal to k, subtract data[start] from sum and
				// decrease sliding window by moving start by one position
				sum -= data[start];
				start++;
			}
		}
		return count;
	}

	public int bruteForceCountSubArray(int[] data, int k) {
		int count = 0;
		for (int i = 0; i < data.length; i++) {
			int sum = 0;
			for (int j = i; j < data.length; j++) {
				if (sum + data[j] < k) {
					sum += data[j];
					count++;
				} else {
					break;
				}
			}
		}
		return count;
	}
}
