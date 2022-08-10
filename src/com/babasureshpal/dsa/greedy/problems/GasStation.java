/**
 * 
 */
package com.babasureshpal.dsa.greedy.problems;

/**
 * @author Baba Suresh Pal
 * Problem: Given two integer arrays A and B of size N. 
 * 			There are N gas stations along a circular route, where the amount of gas at station i is A[i].
 * 			You have a car with an unlimited gas tank and it costs B[i] of gas to travel from station i to its next station (i+1). 
 * 			You begin the journey with an empty tank at one of the gas stations.
 * 			Return the minimum starting gas station's index if you can travel around the circuit once, otherwise return -1.
 * 			You can only travel in one direction. i to i+1, i+2, ... n-1, 0, 1, 2.. Completing the circuit means starting at i and ending up at i again.
 * 			Input Format:
 * 				The first argument given is the integer array A. The second argument given is the integer array B.
 * 			Output Format:
 * 				Return the minimum starting gas station's index if you can travel around the circuit once, otherwise return -1.
 * 			Examples:
 * 				1)	Input:
 * 					A = [1, 2] B = [2, 1]
 * 					Output:
 * 					1
 * 					Explanation:
 * 						If you start from index 0, you can fill in A[0] = 1 amount of gas. 
 * 						Now your tank has 1 unit of gas. But you need B[0] = 2 gas to travel to station 1. 
 * 						If you start from index 1, you can fill in A[1] = 2 amount of gas. 
 * 						Now your tank has 2 units of gas. You need B[1] = 1 gas to get to station 0. 
 * 						So, you travel to station 0 and still have 1 unit of gas left over. 
 * 						You fill in A[0] = 1 unit of additional gas, making your current gas = 2. 
 * 						It costs you B[0] = 2 to get to station 1, which you do and complete the circuit.
 * 				2)	Input:
 * 						A[] = [1,2,3,4,5]
 * 						B[] = [3,4,5,1,2]
 * 					Output:
 * 						3
 * 					Explanation:
 * 						Start at station 3 (index 3) and fill up with 4 unit of gas. Gas available in Tank = 0 + 4 = 4
 * 						Travel to station 4.Gas available in tank = 4 - 1 + 5 = 8
 * 						Travel to station 0.Gas available in tank = 8 - 2 + 1 = 7
 * 						Travel to station 1.Gas available in tank = 7 - 3 + 2 = 6
 * 						Travel to station 2.Gas available in tank = 6 - 4 + 3 = 5
 * 						Travel to station 3.The cost is 5.Your gas is just enough to travel back to station 3.Therefore, return 3 as the starting index.
 * 				3)	Input:
 * 						A[] = [2,3,4]
 * 						B[] = [3,4,3]
 * 					Output: 
 * 						-1
 * 					Explanation
 * 						You can't start at station 0 or 1, as there is not enough gas to travel to the next station.
 * 						Let's start at station 2 and fill up with 4 unit of gas. 
 * 						Gas available in tank = 0 + 4 = 4
 * 						Travel to station 0.Gas available in tank = 4 - 3 + 2 = 3
 * 						Travel to station 1.Gas available in tank = 3 - 3 + 3 = 3
 * 						You cannot travel back to station 2, as it requires 4 unit of gas but you only have 3.
 * 						Therefore, you can't travel around the circuit once no matter where you start.
 *	Solution-1: Brute Force:
 *		A Simple Solution is to consider every petrol pumps as a starting point and see if there is a possible tour. 
 *		If we find a starting point with a feasible solution, we return that starting point. 
 *		Time Complexity: O(N^2)
 *		Auxiliary Space: O(1)
 *	Solution-2: Brute Force:
 *		Solution two approaches based on Greedy Algorithm.
 *		In the Brute force case, there are three properties that can be used to modify the algorithm and make the running time smaller.
 *		Property-1: If total gas < total cost, a successful route doesn't exist.
			In this case if the total given gas is less then the total cost of travel, the driver can never cover all the stations.
 *			Hence, if(totalGas < totalCost) return -1;
 *		Property-2: This property says, if a path(#i -> #j) failed, it will also fail if we start with any station between #i and #j.
 *					So in this example:
 * 						A[] = [1,2,3,4,5]
 * 						B[] = [3,4,5,1,2]
 * 						If a path does not exist between index 0, 2, then there will not be any path between  index 1 and 2 also
 *		Property-3: With enough total gas, if there's a successful path(#X -> #last station), starting point #X must be valid (no need to loop back to check).
 *			That's being said, if we find a starting point X that can reach the last station, 
 *			we don't have to loop back to check stations before X. 
 *			The gas will always be enough to cover the rest trip 
 *		
 *
 *	
 */
public class GasStation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GasStation demo = new GasStation();
		int [] gas = new int[] {1, 2};
		int [] cost = new int[] {2, 1};
		System.out.println("Gas ==> ");
		demo.print(gas);
		System.out.println("Cost ==> ");
		demo.print(cost);
		System.out.println("BruteForce ==> " + demo.bruteForceGasStartIndex(gas,  cost));
		System.out.println("Greedy ==> " + demo.greedyGasStartIndex(gas,  cost));

		gas = new int[] {1,2,3,4,5};
		cost = new int[] {3,4,5,1,2};
		System.out.println("Gas ==> ");
		demo.print(gas);
		System.out.println("Cost ==> ");
		demo.print(cost);
		System.out.println("BruteForce ==> " + demo.bruteForceGasStartIndex(gas,  cost));
		System.out.println("Greedy ==> " + demo.greedyGasStartIndex(gas,  cost));

		gas = new int[] {2,3,4};
		cost = new int[] {3,4,3};
		System.out.println("Gas ==> ");
		demo.print(gas);
		System.out.println("Cost ==> ");
		demo.print(cost);
		System.out.println("BruteForce ==> " + demo.bruteForceGasStartIndex(gas,  cost));
		System.out.println("Greedy ==> " + demo.greedyGasStartIndex(gas,  cost));
	}
	
	public int bruteForceGasStartIndex(int [] gas, int[] cost) {
		int n = gas.length;
		
		for(int i = 0; i < n; i++) {
			int remainingFuel = 0; 
			boolean isSuccess = true;
			for(int j = i; j < (n + i); j++) {
				 int current = (j + n) % n;
				 remainingFuel += gas[current] - cost[current]; // to go to the next index
				 if(remainingFuel < 0) { // out of fuel, go to the next station
					 isSuccess = false;
					 break;
				 }
			}
			if(isSuccess) { // successfully covered all stations
				return i;
			}
		}
		return -1;
	}
	
	public int greedyGasStartIndex(int [] gas, int [] cost) {
		int n = gas.length;
		// Property-1 - Check if the total gas is less than total cost
		int totalFuel = 0;
		int totalCost = 0;
		for(int i = 0; i < n; i++) {
			totalFuel += gas[i];
			totalCost += cost[i];
		}
		
		if(totalFuel < totalCost) {
			return -1;
		}
		
		// now loop through the gas
		int remainingFuel = 0;
		int start = 0;
		
		
		for(int i = 0; i < n; i++) { // Property-3 Loop ensures that the already visited stations are not revsited
			remainingFuel += gas[i] - cost[i];
			if(remainingFuel < 0) { // Property-2 If the remaining fuel is negative, it means no path exists for this index, hence go to next one
				start = i + 1;
				remainingFuel = 0;
			}
		}
		
		return start;
	}
	
	public void print(int [] data) {
		StringBuilder builder = new StringBuilder();
		builder.append("{");
		for(int i = 0; i < data.length; i++) {
			builder.append(data[i] + ",");
		}
		builder.deleteCharAt(builder.length() - 1);
		builder.append("}");
		System.out.println(builder.toString());

	}

}
