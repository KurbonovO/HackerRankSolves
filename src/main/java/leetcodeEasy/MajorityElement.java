package leetcodeEasy;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

	public int majorityElement(int[] array) {

		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < array.length; i++) {

			if (!map.containsKey(array[i])) {
				map.put(array[i], 1);
			} else {
				map.put(array[i], map.get(array[i] + 1));
			}

		}

		return 0;
	}

}
