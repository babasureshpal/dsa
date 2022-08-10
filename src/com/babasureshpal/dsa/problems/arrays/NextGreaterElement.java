/**
 * 
 */
package com.babasureshpal.dsa.problems.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author Baba Suresh Pal
 * Problem: Given an array, print the Next Greater Element (NGE) for every element. 
 *	 	The Next greater Element for an element x is the first greater element on the right side of x in the array. 
 * 		Elements for which no greater element exists, consider the next greater element as -1.
 * 		e.g.
 * 		a) For any array, the rightmost element always has the next greater element as -1.
 * 		b) For an array which is sorted in decreasing order, all elements have the next greater element as -1.
 * 		c) For the input array [4, 5, 2, 25}, the next greater elements for each element are as follows.
 * 			Element		NGE
 * 			4			5
 * 			5			25
 * 			2			25
 * 			25			-1
 * 		d) For the input array [13, 7, 6, 12}, the next greater elements for each element are as follows:
 * 			Element		NGE
 * 			13			-1
 * 			7			12
 * 			6			12
 * 			12			-1
 *
 *	Solution:
 *	The problem is solved using stack.
 *	Algorithm:
 *		Steps: 
 *			a)	Take two variables, next and current
 *			b)	Push the first element of array to the stack
 *			b)	Pick the rest of the elements one by one and perform following steps:
 *				i)	Mark the current element as next
 *				ii) If stack is not empty, then pop an element from Stack, assign it to current and compare it with next
 *					->> If next is greater than the popped element from Stack, 
 *						then next is the next greater element for the current element (popped element from the stack) 
 *					->> Keep popping from the stack, while the popped (current) element is smaller than next. 
 *						next becomes the next greater element for all such popped elements. 
 *				iii) If next is smaller than the current element, then push the current element back to stack. 

 */
public class NextGreaterElement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int [] example1 = {4,5,2,25};
		int [] example2 = {13,7,6,12};
		int [] example3 = {1,2,20,21};
		int [] example4 = {4,3,2,1};
		
		NextGreaterElement demo = new NextGreaterElement();
		demo.printNGE(example1);
		demo.printNGEHashMap(example1);
		demo.printNGE(example2);
		demo.printNGEHashMap(example2);
		demo.printNGE(example3);
		demo.printNGEHashMap(example3);
		demo.printNGE(example4);
		demo.printNGEHashMap(example4);

	}
	
	public void printNGE(int arr[]) {
		int size = arr.length;
		int i = 0;
		Stack<Integer> stack = new Stack();
		int element, next;

		/* push the first element to stack */
		stack.push(arr[0]);

		// iterate for rest of the elements
		for (i = 1; i < size; i++) {
			next = arr[i];
			if (!stack.isEmpty()) {
				// if stack is not empty, then
				// pop an element from stack
				element = stack.pop();
				/*
				 * If the popped element is smaller than next, then a) print the pair b) keep
				 * popping while elements are smaller and stack is not empty
				 */
				while (element < next) {
					System.out.println(element + " --> " + next);
					if (stack.isEmpty() == true) {
						break;
					}
					element = stack.pop();
				}

				/*
				 * If element is greater than next, then push the element back
				 */
				if (element > next) {
					stack.push(element);
				}
			}

			/*
			 * push next to stack so that we can find next greater for it
			 */
			stack.push(next);
		}

		/*
		 * After iterating over the loop, the remaining elements in stack do not have
		 * the next greater element, so print -1 for them
		 */
		while (stack.isEmpty() == false) {
			element = stack.pop();
			next = -1;
			System.out.println(element + " -- " + next);
		}
	}
	

	
	public void printNGEHashMap(int arr[]) {
		int size = arr.length;
		int i = 0;
		Stack<Integer> stack = new Stack<Integer>();
		HashMap<Integer, Integer> result = new HashMap<Integer, Integer>();
		int element, next;

		/* push the first element to stack */
		stack.push(arr[0]);

		// iterate for rest of the elements
		for (i = 1; i < size; i++) {
			next = arr[i];
			if (!stack.isEmpty()) {
				// if stack is not empty, then
				// pop an element from stack
				element = stack.pop();
				/*
				 * If the popped element is smaller than next, then a) print the pair b) keep
				 * popping while elements are smaller and stack is not empty
				 */
				while (element < next) {
					result.put(element, next);
//					System.out.println(element + " --> " + next);
					if (stack.isEmpty() == true) {
						break;
					}
					element = stack.pop();
				}

				/*
				 * If element is greater than next, then push the element back
				 */
				if (element > next) {
					stack.push(element);
				}
			}

			/*
			 * push next to stack so that we can find next greater for it
			 */
			stack.push(next);
		}

		/*
		 * After iterating over the loop, the remaining elements in stack do not have
		 * the next greater element, so print -1 for them
		 */
		while (stack.isEmpty() == false) {
			element = stack.pop();
			next = -1;

			result.put(element, -1);
		}

		for(Map.Entry<Integer, Integer> mapEntry : result.entrySet()) {
			System.out.println(mapEntry.getKey() + " ->> " + mapEntry.getValue());
		}
	}

}
