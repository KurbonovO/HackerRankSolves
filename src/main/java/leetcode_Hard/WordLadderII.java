package leetcode_Hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*126 Given two words (beginWord and endWord), and a dictionary's word list,
find all shortest transformation sequence(s) from beginWord to endWord, such
that: Only one letter can be changed at a time. Each transformed word must
exist in the word list. Note that beginWord is not a transformed word.
Input: beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]
Output:
[
  ["hit","hot","dot","dog","cog"],
  ["hit","hot","lot","log","cog"]
]
Input: beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]
Output: []
The endWord "cog" is not in wordList, therefore no possible transformation.
 */

public class WordLadderII {
	public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {

		List<List<String>> res = new ArrayList<List<String>>();

		if (wordList == null) {
			return res;
		}

		Map<String, Integer> distance = new HashMap<String, Integer>();
		wordList.add(endWord);
		distance.put(beginWord, 1);

		Map<String, Set<String>> neighbours = new HashMap<String, Set<String>>();
		LinkedList<String> queue = new LinkedList<String>();

		queue.add(beginWord);
		boolean foundIt = false;

		/* BFS */
		while (!queue.isEmpty()) {

			int qsize = queue.size();

			for (int i = 0; i < qsize; i++) {
				String curword = queue.poll();

				Set<String> curneighbours = gettheNeibours(curword, wordList);
				Iterator<String> iterator = curneighbours.iterator();

				for (; iterator.hasNext();) {
					String nb = iterator.next();

					if (curword.equals(endWord)) {
						foundIt = true;
					}

					if (!distance.containsKey(nb)) { // visited
						distance.put(nb, distance.get(curword) + 1);
						queue.add(nb);
					} else {
						if (distance.get(nb) != distance.get(curword) + 1)// if not shortest
							iterator.remove(); // remove since not shortest
					}
				}
				neighbours.put(curword, curneighbours);
			} // end for(int i=0;i<qsize;i++){

			if (foundIt)
				break;
		} // end while(!queue.isEmpty()){
			// DFS
		List<String> worklist = new ArrayList<String>();
		dfs(beginWord, endWord, wordList, neighbours, worklist, res);
		return res;
	}

	public void dfs(String curword, String end, Set<String> dict, Map<String, Set<String>> neighbours,
			List<String> worklist, List<List<String>> res) {

		if (curword.equals(end)) {
			worklist.add(curword);
			res.add(new ArrayList<>(worklist));
			worklist.remove(worklist.size() - 1);
			return;
		}

		worklist.add(curword);

		if (neighbours.containsKey(curword)) {
			for (String nb : neighbours.get(curword)) {
				dfs(nb, end, dict, neighbours, worklist, res);
			}
		}
		worklist.remove(worklist.size() - 1);
	}

	public Set<String> gettheNeibours(String curword, Set<String> dict) {

		Set<String> res = new HashSet<String>();

		int len = curword.length();
		char[] chs = curword.toCharArray();

		for (int i = 0; i < len; i++) {
			char old = chs[i];

			for (char c = 'a'; c <= 'z'; c++) {
				chs[i] = c;
				String composStr = String.valueOf(chs);

				if (!composStr.equals(curword) && dict.contains(composStr)) {
					res.add(composStr);
				}
			}
			chs[i] = old;
		}
		return res;
	}
}
