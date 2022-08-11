/**
 * 
 */
package com.babasureshpal.dsa.graph.problems;

/**
 * @author Baba Suresh Pal Problem: Given an array of non-negative integers and
 *         a sum. We have to find sum of the subarray having a maximum sum less
 *         than or equal to the given sum in the array. (Note: Given array
 *         contains only non-negative integers.) Examples: 1. Input: arr[] = {
 *         1, 2, 3, 4, 5 } sum = 11 Output: 10 Subarray having maximum sum is {
 *         1, 2, 3, 4 } 2. Input: arr[] = { 2, 4, 6, 8, 10 } sum = 7 Output: 6
 *         Subarray having maximum sum is { 2, 4 } or { 6 }
 * 
 *         Solution: 1. Naive Approach: We can find the maximum sum of the
 *         subarray by running two loops. But the time complexity will be
 *         O(N*N). 2. Efficient Approach: The subarray having maximum sum can be
 *         found by using a sliding window. If currentSum is less than sum
 *         include array elements to it. If it becomes greater than sum removes
 *         elements from start in curr_sum. (This will work only in the case of
 *         non-negative elements.) Time Complexity: O(N*log(N)) Auxiliary Space:
 *         O(1)
 * 
 *         References: 1.
 *         https://www.geeksforgeeks.org/maximum-sum-subarray-sum-less-equal-given-sum/
 * 
 *
 */
public class MaximumSubArray {
	public static void main(String[] args) {
		MaximumSubArray demo = new MaximumSubArray();
		int array[] = { 34, 23, 1, 24, 75, 33, 54, 8 };
		int k = 60;
		int count = demo.findMaxSubarraySum(array, k);
		System.out.println(count);
	}
	public int findMaxSubarraySum(int data[], int key) {
		int currentSum = data[0];
		int maxSum = 0;
		int start = 0;

		for (int i = 1; i < data.length; i++) {
			if (currentSum <= key) {
				// Update maxSum if it becomes
				// greater than currentSum
				maxSum = Math.max(maxSum, currentSum);
			}
			// If currentSum becomes greater than key subtract starting elements of array
			while (currentSum + data[i] > key && start < i) {
				currentSum = currentSum - data[start];
				start++;
			}

			// Add elements to currentSum
			currentSum += data[i];
		}

		// Adding an extra check for last subarray
		if (currentSum <= key) {
			maxSum = Math.max(maxSum, currentSum);
		}
		return maxSum;
	}
}
