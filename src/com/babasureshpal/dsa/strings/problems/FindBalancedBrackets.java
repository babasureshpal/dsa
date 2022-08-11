package com.babasureshpal.dsa.strings.problems;

import java.util.Stack;

/**
 * @author Baba Suresh Pal
 * Problem: Given an expression string exp, write a program to examine 
 * 			whether the pairs and the orders of “{“, “}”, “(“, “)”, “[“, “]” are correct in exp.
 * Example: 
 * 		a)	Input: exp = “[()]{}{[()()]()}” 
 * 			Output: Balanced
 * 		b)	Input: exp = “[(])” 
 * 			Output: Not Balanced 
 * Solutions:
 * 		Steps:
 * 		a)	Declare a character stack S.
 * 		b)	Now traverse the expression string exp. 
 * 			i)	If the current character is a starting bracket (‘(‘ or ‘{‘ or ‘[‘) then push it to stack. 
 * 			ii)	If the current character is a closing bracket (‘)’ or ‘}’ or ‘]’) then pop from stack  
 * 				and if the popped character is the matching starting bracket then fine else brackets are not balanced. 
 * 		c)	After complete traversal, if there is some starting bracket left in stack then “not balanced”
 * 			
 *
 */
public class FindBalancedBrackets {
	public static void main(String[] args) {
		String s = "()";
		System.out.println(s + " is " + isValid(s));
		s = "()[]{}";
		System.out.println(s + " is " + isValid(s));
		s = "(]";
		System.out.println(s + " is " + isValid(s));
		s = "([)]";
		System.out.println(s + " is " + isValid(s));
		s = "{[]}";
		System.out.println(s + " is " + isValid(s));
		
	}
	
	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		
		for(int i = 0; i < s.length(); i++) {
			char x = s.charAt(i);
			if(x == '(' || x =='[' || x == '{') {
				stack.push(x);
			}
			if(s.isEmpty()) {
				return false;
			}
			
			char element;
			
			switch(x) {
				case ')': {
					element = stack.pop();
					if(element != '(') {
						return false;
					}
					break;
				}
				case '}': {
					element = stack.pop();
					if(element != '{') {
						return false;
					}
					break;
				}
				case ']': {
					element = stack.pop();
					if(element != '[') {
						return false;
					}
					break;
					
				}
			}
		}
		
		return stack.isEmpty(); 
	}
}
