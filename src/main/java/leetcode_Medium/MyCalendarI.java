package leetcode_Medium;

import java.util.TreeMap;

public class MyCalendarI {
	TreeMap<Integer, Integer> calendar;

	public MyCalendarI() {
		calendar = new TreeMap<>();
	}

	public boolean book(int start, int end) {
		Integer floorKey = calendar.floorKey(start);
		if (floorKey != null && calendar.get(floorKey) > start)
			return false;
		Integer ceilingKey = calendar.ceilingKey(start);
		if (ceilingKey != null && ceilingKey < end)
			return false;

		calendar.put(start, end);
		return true;
	}
}
