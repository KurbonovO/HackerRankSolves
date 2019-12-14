package leetcodeMedium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

public class ReconstructItinerary {

	public List<String> findItinerary(String[][] tickets) {
		Map<String, PriorityQueue<String>> targets = new HashMap<>();
		for (String[] ticket : tickets)
			targets.computeIfAbsent(ticket[0], k -> new PriorityQueue<>()).add(ticket[1]);
		List<String> route = new LinkedList<>();
		Stack<String> stack = new Stack<>();
		stack.push("JFK");
		while (!stack.empty()) {
			while (targets.containsKey(stack.peek()) && !targets.get(stack.peek()).isEmpty())
				stack.push(targets.get(stack.peek()).poll());
			route.add(0, stack.pop());
		}
		return route;
	}

}
