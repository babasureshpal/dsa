/**
 * 
 */
package com.babasureshpal.dsa.arrays.problems;

/**
 * @author Baba Suresh Pal
 * Problem:	In a town, there are n people labeled from 1 to n. 
 * 			There is a rumor that one of these people is secretly the town judge.
 * 			If the town judge exists, then:
 * 			a)	The town judge trusts nobody.
 * 			b)	Everybody (except for the town judge) trusts the town judge.
 * 			c)	There is exactly one person that satisfies properties 1 and 2.
 * 			You are given an array trust where trust[i] = [ai, bi] representing 
 * 
 * 			that the person labeled ai trusts the person labeled bi.
 * 			Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.
 *	Examples 
 *		1)	Input: 
 *				n = 2, trust = [[1,2]]
 *			Output: 
 *				2
 *		2)	Input: 
 *				n = 3, trust = [[1,3],[2,3]]
 *			Output: 
 *				3
 *		3)	Input: 
 *				n = 3, trust = [[1,3],[2,3],[3,1]]
 *			Output: 
 *				-1
 *	Solution:	Let’s treat the given scenario as a directed graph in which an edge from person a to b shows that a trusts b.
 *				A town judge does not trust anybody thus, town judge has no outgoing edge. 
 *				All other n-1 persons trust town judge thus, total n-1 incoming edge towards town judge from all other person.
 *				We can further understand that difference between number of incoming edges and number of outgoing edges is n-1 for town judge only.
 *				If we talk about a simple person then he will surely trust town judge 
 *				thus min(outgoing edges)=1 and in best case even if all other person trust him
 *				(of course town judge won’t trust him) thus max(incoming edges)= n-2.
 *				The maximum difference between incoming and outgoing edges for this person is n-2-(1) = n-3.
 *				Also if there is no town judge then no person can achieve the n-1 difference between number of incoming and outgoing edges.
 *				Now, our main task is to calculate the difference i.e. (number of incoming edges – number of outgoing edges) for each person. 
 *				We will do so by traversing the trust array row-wise.
 *				In any row, there are two elements. Left element is who trusts and right element is whom the left element trusts.
 *				Thus left element has outgoing edge to right element. 
 *				Hence, difference value for left element will decrease by 1 and for right element, increase by 1.
 *				In our code, we have used netTrustGains array for this task. Each index i of this array shows the difference value for ith person.
 *				After traversing trust array, we will run a loop for each person from 1 to n and check if any person has the difference value = n-1.
 *				If such a person is found then we will return him else we will return -1.
 *	References:
 *	https://www.tutorialcup.com/leetcode-solutions/find-the-town-judge-leetcode-solution.htm#:~:text=3%5D%5D%203-,Approach,judge%20from%20all%20other%20person.
 *	https://medium.com/algorithm-and-datastructure/find-the-town-judge-3ab34761969a
 *	https://walkccc.me/LeetCode/problems/0997/
 */
public class TownJudge {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TownJudge demo = new TownJudge();
		
		int [][] data = new int[][]{{1, 2}};
		int size = 2; 
		System.out.println(demo.findJudge(data, size));
		System.out.println(demo.findJudgeUsingTwoDArray(data, size));
		System.out.println("----------------------");
		data = new int[][]{{1, 3}, {2, 3}};
		size = 3; 
		System.out.println(demo.findJudge(data, size));
		System.out.println(demo.findJudgeUsingTwoDArray(data, size));
		System.out.println("----------------------");
		
		data = new int[][]{{1, 3}, {2, 3}, {3, 1}};
		size = 3; 
		System.out.println(demo.findJudge(data, size));
		System.out.println(demo.findJudgeUsingTwoDArray(data, size));
		System.out.println("----------------------");
		
		data = new int[][]{{1, 2}, {1, 3}, {2, 1}, {2, 3}, {1, 4}, {4, 3}, {4, 1}};
		size = 4; 
		System.out.println(demo.findJudge(data, size));
		System.out.println(demo.findJudgeUsingTwoDArray(data, size));
		System.out.println("----------------------");
	}
	
	public int findJudge(int [][] trust, int n) {
		int [] trustCount = new int[n + 1]; // keep size one extra as index starts from 1 for the trusts and persons
		for(int [] item : trust) {
			--trustCount[item[0]]; // reduce the trust count with one for the person at index 0 of trust pair
			++trustCount[item[1]]; // increase the trust count with one for the person at index 1 of trust pair
		}
		
		for(int i = 1; i <= n; i++) {
			if(trustCount[i] == n - 1) {
				return i;
			}
		}
		return -1;
	}
	
	public int findJudgeUsingTwoDArray(int [][] trust, int n) {
		int [][] trustCount = new int[n + 1][2]; // keep size one extra as index starts from 1 for the trusts and persons
		for(int i = 0; i< trust.length; i++) {
			trustCount[trust[i][0]][0] += 1; 
			trustCount[trust[i][1]][1] += 1; 
		}
		
		for(int i = 1; i <=n; i++) {
			if(trustCount[i][0] == 0 && trustCount[i][1] == (n - 1)) {
				return i;
			}
		}
		return -1;
	}

}
