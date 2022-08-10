/**
 * 
 */
package com.babasureshpal.dsa.linkedlist.ds;

/**
 * @author sures
 *
 */
public class SinglyLinkedListNode<T> {
	public SinglyLinkedListNode<T> next;
	public T value;

	public SinglyLinkedListNode() {	}
	public SinglyLinkedListNode(T val) {
		this.value = val;
	}
}
