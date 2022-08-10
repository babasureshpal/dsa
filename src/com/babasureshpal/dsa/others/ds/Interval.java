/**
 * 
 */
package com.babasureshpal.dsa.others.ds;

/**
 * @author Baba Suresh Pal
 * A Generic class representing an interval between the values
 *
 */
public class Interval<T> {
	public T start;
	public T end;
	
	public Interval() {
		
	}
	
	public Interval(T start, T end) {
		this.start = start;
		this.end = end;
	}
}
