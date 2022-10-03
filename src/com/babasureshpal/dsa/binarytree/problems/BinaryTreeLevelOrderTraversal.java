/**
 * 
 */
package com.babasureshpal.dsa.binarytree.problems;

import java.util.LinkedList;
import java.util.Queue;

import com.babasureshpal.dsa.binarytree.ds.BinaryTreeNode;

/**
 * @author Baba Suresh Pal
 * 
 * References:
 * 1.	https://www.geeksforgeeks.org/level-order-tree-traversal/
 * 
 * Problem:
 * Given the root of the Binary Tree. The task is to print the Level order traversal of a tree is breadth first traversal for the tree. 
 * Input:	
 * 							1
 * 							/\
 * 						2		3
 * 						/\		
 * 					4		5
 * Output:
 *		1
 * 		2	3
 * 		4	5
 * 
 * Solution:
 *	Approach-1. Using Recursion:
 *		Follow the below steps to Implement the idea:
 *		a)	Run a for loop for counter i, i.e. current height from 1 to h (height of the tree).
 *		b)	Use DFS to traverse the tree and maintain height for the current node.
 *			i)	If the Node is NULL then return;
 *			ii)	If level is 1 print(tree->data);
 *			iii)Else if the level is greater than 1, then
 *				==>	Recursively call to for tree->left, level-1.
 *				==>	Recursively call to for tree->right, level-1.
 *		Time Complexity: 
 *			O(N^2), where N is the number of nodes in the skewed tree. 
 *			So time complexity of printLevelOrder() is O(n) + O(n-1) + O(n-2) + .. + O(1) which is O(N2). 
 *		Auxiliary Space:  
 *			O(N) in the worst case. For a skewed tree, printGivenLevel() uses O(n) space for the call stack. 
 *		For a Balanced tree, the call stack uses O(log n) space, (i.e., the height of the balanced tree). 
 *
 *	Approach-2.	Using Queue:
 *		Follow the below steps to Implement the above idea:
 *		a)	Create an empty queue q and push root in q.
 *		b)	Run While loop until q is not empty. 
 *			i)	Initialize temp_node = q.front() and print temp_node->data.
 *			ii)	Push temp_node’s children i.e. temp_node -> left then temp_node -> right to q
 *			iii)Pop front node from q.
 *		Time Complexity: 
 *			O(N) where n is the number of nodes in the binary tree.
 *		Auxiliary Space: 
 *			O(N) where n is the number of nodes in the binary tree.
 */
public class BinaryTreeLevelOrderTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTreeLevelOrderTraversal demo = new BinaryTreeLevelOrderTraversal();
		
		BinaryTreeNode root = new BinaryTreeNode(1);
		root.left = new BinaryTreeNode(2);
		root.right = new BinaryTreeNode(3);
		root.left.left = new BinaryTreeNode(4); 
		root.left.right = new BinaryTreeNode(5);
		
		demo.traverseLevelOrderUsingRecursion(root);

		demo.traverseLeveOrderUsingQueue(root);
		
		
		System.out.println();

		root = new BinaryTreeNode(20);
		root.left = new BinaryTreeNode(8);
		root.right = new BinaryTreeNode(22);
		root.left.left = new BinaryTreeNode(4); 
		root.left.right = new BinaryTreeNode(12);
		root.left.right.left = new BinaryTreeNode(10); 
		root.left.right.right = new BinaryTreeNode(14);

		demo.traverseLevelOrderUsingRecursion(root);

		demo.traverseLeveOrderUsingQueue(root);
	}
	
	
	/**
	 * Method to find the height of the tree
	 * @param root node of the tree
	 * @return Height of the given tree
	 */
	public int heightOfBinaryTree(BinaryTreeNode root) {
		if(root == null) 
			return 0;
		
		int leftHeight = heightOfBinaryTree(root.left);
		int rightHeight = heightOfBinaryTree(root.right);
		
		return Math.max(leftHeight, rightHeight) + 1;
	}
	
	/**
	 * This function traverse tree level order using recursion
	 * @param root
	 */
	public void traverseLevelOrderUsingRecursion(BinaryTreeNode root) {
		System.out.println("Using Recursion");
		if(root == null) {
			return;
		}
		
		int height = heightOfBinaryTree(root);
		
		for(int i = 1; i <= height; i++) {
			printElementsAtLevel(root, i);
			System.out.println();
		}
		System.out.println();
	}
	
	/**
	 * Recursively traverse and print the tree at each level
	 * @param root
	 * @param level
	 */
	private void printElementsAtLevel(BinaryTreeNode root, int level) {
		if(root == null) 
			return;
		if(level == 1) {
			System.out.print(root.data + "\t");
		} else if(level > 1) {
			printElementsAtLevel(root.left, level - 1);
			printElementsAtLevel(root.right, level - 1);
		}
	}
	
	
	/**
	 * This method traverses each level of trees using queue 
	 * @param root
	 */
	public void traverseLeveOrderUsingQueue(BinaryTreeNode root) {
		System.out.println("Using Queues");
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			BinaryTreeNode tempNode = queue.poll(); // removes the element from the queues
			System.out.println(tempNode.data + "\t");
			
			// enqueue the left child
			if(tempNode.left != null) {
				queue.add(tempNode.left);
			}
			
			// enqueue the right child 
			if(tempNode.right != null) {
				queue.add(tempNode.right);
			}
			
		}
	}

}
