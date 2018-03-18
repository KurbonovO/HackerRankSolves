package leetcode_Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/*731 Implement a MyCalendarTwo class to store your events. A new event can be added if adding the event will not cause a
triple booking. Your class will have one method, book(int start, int end). Formally, this represents a booking on the half
open interval [start, end), the range of real numbers x such that start <= x < end. A triple booking happens when three
events have some non-empty intersection (ie., there is some time that is common to all 3 events.) For each call to the
method MyCalendar.book, return true if the event can be added to the calendar successfully without causing a triple booking.
Otherwise, return false and do not add the event to the calendar. Your class will be called like this: 
MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end)

MyCalendar();
MyCalendar.book(10, 20); 	// returns true
MyCalendar.book(50, 60); 	// returns true
MyCalendar.book(10, 40); 	// returns true
MyCalendar.book(5, 15); 	// returns false
MyCalendar.book(5, 10); 	// returns true
MyCalendar.book(25, 55); 	// returns true

The first two events can be booked.  The third event can be double booked.
The fourth event (5, 15) can't be booked, because it would result in a triple booking.
The fifth event (5, 10) can be booked, as it does not use time 10 which is already double booked.
The sixth event (25, 55) can be booked, as the time in [25, 40) will be double booked with the third event;
the time [40, 50) will be single booked, and the time [50, 55) will be double booked with the second event.*/

public class MyCalendar_II {

	private List<int[]> list = new ArrayList<>();

	public boolean book(int start, int end) {
		
		MyCalendar newMyCalendar = new MyCalendar();
		
		for (int[] i : list) {
			
			if (i[0] < start && i[1] > start) {
				
				if (!newMyCalendar.book(start, i[1])) {
					return false;
				}
			} else if (i[0] >= start && i[0] < end) {
				
				if (!newMyCalendar.book(i[0], Math.min(i[1], end))) {
					return false;
				}
			}
		}
		list.add(new int[]{start, end});
		return true;
	}

	private class MyCalendar {

		TreeMap<Integer, Integer> treeMapWithTwoInts = new TreeMap<>();

		public boolean book(int start, int end) {
			Integer i = treeMapWithTwoInts.lowerKey(end);
			
			if (i != null && i >= start) {
				return false;
			}
			i = treeMapWithTwoInts.lowerKey(start);
			
			if (i != null && treeMapWithTwoInts.get(i) > start) {
				return false;
			}
			treeMapWithTwoInts.put(start, end);
			return true;
		}
	}
}