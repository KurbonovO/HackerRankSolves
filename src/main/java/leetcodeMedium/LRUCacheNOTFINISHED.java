package leetcodeMedium;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheNOTFINISHED {

	Map<Integer, Integer> cache = null;

	public int get(int key) {

		return cache.get(key);
	}

	public void put(int key, int value) {

		cache.put(key, value);
	}

}
