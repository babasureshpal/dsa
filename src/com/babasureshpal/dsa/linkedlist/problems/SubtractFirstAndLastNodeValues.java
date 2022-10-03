/**
 * 
 */
package com.babasureshpal.dsa.linkedlist.problems;

import java.util.ArrayList;
import java.util.Stack;

import com.babasureshpal.dsa.linkedlist.ds.SinglyLinkedListNode;

/**
 * @author Baba Suresh Pal
 * 
 * Reference:
 * 1.	https://www.geeksforgeeks.org/amazon-interview-set-109-campus/
 * 2.	https://www.geeksforgeeks.org/modify-contents-linked-list/
 * 
 * Problem: Given a singly LinkedList you have to subtract the value of first node from the last node 
 * 			and so on until you reach the middle node.
 * 			e.g. 
 * 				a) Given the list 10 -> 2 -> 4 -> 5, it should print
 * 					-5, 2, 4, 5
 * 				b) Given the list 10 -> 2 -> 3 -> 4 -> 5, it should print
 * 					-5, 2, 3, 4, 5
 * 			 		
 * Solution:
 *  Steps: 
 *  	a)	First push all the nodes to a stack, during pushing the elements also identify 'size' of the list
 *  	b)	Assign the first node to variable 'current'
 *  	c)	Now loop for the size/2 of the list and perform following operations:
 *  		i) Pop the element from the stack
 *  		ii) assign the difference between the current's value and popped element's value to the current's value
 *  		iii) assign current's next as current 
 * 		d) Print the linked list
 *
 */
public class SubtractFirstAndLastNodeValues {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SubtractFirstAndLastNodeValues demo = new SubtractFirstAndLastNodeValues();
		demo.processFirstList();
		demo.processSecondList();
	}
	
	public void processFirstList() {
		SinglyLinkedListNode<Integer> node1 = new SinglyLinkedListNode<>(10);
		SinglyLinkedListNode<Integer> node2 = new SinglyLinkedListNode<>(2);
		node1.next = node2;
		SinglyLinkedListNode<Integer> node3 = new SinglyLinkedListNode<>(4);
		node2.next = node3;
		SinglyLinkedListNode<Integer> node4 = new SinglyLinkedListNode<>(5);
		node3.next = node4;
		subtract(node1);
	}

	
	public void processSecondList() {
		SinglyLinkedListNode<Integer> node1 = new SinglyLinkedListNode<>(10);
		SinglyLinkedListNode<Integer> node2 = new SinglyLinkedListNode<>(2);
		node1.next = node2;
		SinglyLinkedListNode<Integer> node3 = new SinglyLinkedListNode<>(3);
		node2.next = node3;
		SinglyLinkedListNode<Integer> node4 = new SinglyLinkedListNode<>(4);
		node3.next = node4;
		SinglyLinkedListNode<Integer> node5 = new SinglyLinkedListNode<>(5);
		node4.next = node5;
		subtract(node1);
	}

	public void subtract(SinglyLinkedListNode<Integer> first) {
		System.out.println("Print initial list");
		print(first);
		ArrayList<Integer> list = new ArrayList();
		SinglyLinkedListNode<Integer> current = first;
		Stack<SinglyLinkedListNode<Integer>> stack = new Stack<SinglyLinkedListNode<Integer>>();
		int size = 0;
		while(current != null) { // step a
			size++; 
			stack.push(current);
			current = current.next;
		}
		
		// reinitialize current with first
		current = first;
		for(int i = 0; i < size/2; i++) {
			SinglyLinkedListNode<Integer> popped = stack.pop(); // step C(i)
			current.value = current.value - popped.value;  // step C(ii)
			current = current.next; // step C(iii)
		}
		
		System.out.println("Print list after subtraction");
		print(first);
	}
	
	public void print(SinglyLinkedListNode<Integer> first) {
		SinglyLinkedListNode<Integer> current = first;
		ArrayList<Integer> list = new ArrayList<Integer>();
		while(current != null) {
			list.add(current.value);
			current = current.next;
		}
		System.out.println(list);
	}
	

}
