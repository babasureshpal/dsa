/**
 * 
 */
package com.babasureshpal.dsa.others.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

import com.babasureshpal.dsa.others.ds.Interval;

/**
 * @author Baba Suresh Pal 
 * Problem: Merge overlapping intervals(Very well known repeating problem). 
 * 			Given a set of time intervals in any order, merge all overlapping intervals into one 
 * 			and output the result which should have only mutually exclusive intervals. Let the intervals be represented as pairs of integers for simplicity. 
 * 	e.g.: 
 * 			Let the given set of intervals be {{1,3}, {2,4}, {5,7}, {6,8} }. 
 * 			The intervals {1,3} and {2,4} overlap with each other, so they should be merged and become {1, 4}. 
 * 			Similarly {5, 7} and {6, 8} should be merged and become {5, 8} 
 * Solution: 
 * 	Steps: 
 * 			a) Sort the intervals based on increasing order of starting time. 
 * 			b) Push the first interval onto a stack. 
 * 			c) For each interval do the following: 
 * 				i) If the current interval does not overlap with the stack top, push it. 
 * 				ii) If the current interval overlaps with stack top and ending time of current interval is more than that of stack top, 
 * 					update stack top with the ending time of current interval. 
 * 			d) At the end stack contains the merged intervals.
 *	Reference:
 *		https://www.geeksforgeeks.org/amazon-interview-set-109-campus
 *		https://www.geeksforgeeks.org/merging-intervals/
 
 *
 */
public class MergeInterval {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		MergeInterval demo = new MergeInterval();
		List<Interval<Integer>> data = new ArrayList<Interval<Integer>>();
		data.add(new Interval<Integer>(6, 8));
		data.add(new Interval<Integer>(1, 9));
		data.add(new Interval<Integer>(2, 4));
		data.add(new Interval<Integer>(4, 7));

		demo.mergeIntervals(data);

		data.clear();
		data.add(new Interval<Integer>(1, 3));
		data.add(new Interval<Integer>(2, 6));
		data.add(new Interval<Integer>(8, 10));
		data.add(new Interval<Integer>(15, 18));
		demo.mergeIntervals(data);
	}

	public void mergeIntervals(List<Interval<Integer>> data) {
		System.out.println("Before sorting");
		print(data);
		sortIntervalsForStartingPoint(data); // Step a
		System.out.println("After sorting");
		print(data);

		Stack<Interval<Integer>> stack = new Stack<Interval<Integer>>();
		stack.push(data.get(0)); // Step b

		for (int i = 0; i < data.size(); i++) { // step c
			Interval<Integer> top = stack.peek();
			Interval<Integer> current = data.get(i);
			if (top.end < current.start) { // step c(i) // no overlapping // push current to stack
				stack.push(current);
			} else if (top.end < current.end) { // step c(ii) // overlapping
				top.end = current.end;
			}
		}

		System.out.println("After merging");
		print(new ArrayList<Interval<Integer>>(stack));
	}

	public void sortIntervalsForStartingPoint(List<Interval<Integer>> data) {
		Collections.sort(data, new Comparator<Interval<Integer>>() {

			@Override
			public int compare(Interval<Integer> o1, Interval<Integer> o2) {
				return Integer.compare(o1.start, o2.start);
			}
		});
	}

	public void print(List<Interval<Integer>> list) {
		StringBuilder builder = new StringBuilder();
		builder.append("{");
		for (Interval<Integer> item : list) {
			builder.append("{" + item.start + ", " + item.end + "}");
			builder.append(",");
		}
		builder.deleteCharAt(builder.length() - 1); // remove last ,
		builder.append("}");
		System.out.println(builder);
	}
}
