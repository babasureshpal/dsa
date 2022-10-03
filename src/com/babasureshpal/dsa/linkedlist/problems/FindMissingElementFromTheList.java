/**
 * 
 */
package com.babasureshpal.dsa.linkedlist.problems;

/**
 * @author Baba Suresh Pal
 * References:
 * 1.	https://cs.stackexchange.com/questions/90131/finding-missing-number-in-an-unsorted-array
 * 2.	https://www.geeksforgeeks.org/find-the-missing-number/
 *  
 * Problem:
 * You are given a list of n-1 integers and these integers are in the range of 1 to n. 
 * There are no duplicates in list. 
 * One of the integers is missing in the list. Write an efficient code to find the missing integer.
 * 
 * Solution:
 * Approach-1:	
 *		a)	Get the sum of numbers using arithmetic progression sum formulae
 *				sum = (n / 2) (2 * a + (n - 1) / d)
 *				where 
 *					n == total number of elements
 *					a == first element
 *					d == difference between two elements in this case it should be 1
 *			OR
 *				sum = 	( n / 2) * (a + l) 
 *				where
 *					a == first element
 *					l == last element
 *				
 *		b)	Subtract all the numbers from sum and it will give the missing number.
 *	
 *		Time Complexity: O(n) to scan array to find out sum of elements		
 *
 *	Approach-2:	
 *		Using XOR operations
 *		a)	XOR all the array elements, let the result of XOR be X1.
 *		b)	XOR all numbers from 1 to n, let XOR be X2.
 *		c)	XOR of X1 and X2 gives the missing number.
 *
 */
public class FindMissingElementFromTheList {
	public static void main(String[] args) {
		FindMissingElementFromTheList demo = new FindMissingElementFromTheList();
		int data[] = {1,2,4,5,6}; 		
		int missingMethod1 = demo.findMissingNumberUsingSumFormula(data, 1, 6, 6);
		System.out.println("Missing by method1 is ==> " + missingMethod1);
		int missingMethod2 = demo.findMissingNumberUsingXOROperation(data, 1, 6, 6);
		System.out.println("Missing by method2 is ==> " + missingMethod2);
		

		data = new int[] {4, 5, 6, 7, 8}; 		
		missingMethod1 = demo.findMissingNumberUsingSumFormula(data, 4, 9, 6);
		System.out.println("Missing by method1 is ==> " + missingMethod1);
		missingMethod2 = demo.findMissingNumberUsingXOROperation(data, 4, 9, 6);
		System.out.println("Missing by method2 is ==> " + missingMethod2);
	}
	
	public int findMissingNumberUsingSumFormula(int [] data, int rangeStart, int rangeEnd, int totalElements) {
		int expectedSum = (totalElements / 2) * (rangeStart + rangeEnd);
		int actualSum = 0;
		for(int i = 0; i < data.length; i++) {
			actualSum += data[i];
		}
		
		return expectedSum - actualSum;
	}
	
	public int findMissingNumberUsingXOROperation(int [] data, int rangeStart, int rangeEnd, int totalElements) {
		int xor1 = rangeStart; // to hold expected xor including missing element
		for(int i = rangeStart + 1; i <= rangeEnd; i++) {
			xor1 = xor1 ^ i;
		}
		
		int xor2 = data[0]; // to hold actual xor of elements in array i.e. excluding missing element
		for(int i = 1; i < data.length; i++) {
			xor2 = xor2 ^ data[i];
		}
		
		
		return xor1 ^ xor2;
	}
}
