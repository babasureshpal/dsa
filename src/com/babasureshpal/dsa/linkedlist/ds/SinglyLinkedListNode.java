/**
 * 
 */
package com.babasureshpal.dsa.linkedlist.ds;

/**
 * @author Baba Suresh Pal
 * A Generic class representing the node for a singly linked list
 */
public class SinglyLinkedListNode<T> {
	public SinglyLinkedListNode<T> next;
	public T value;

	public SinglyLinkedListNode() {	}
	public SinglyLinkedListNode(T val) {
		this.value = val;
	}
}
