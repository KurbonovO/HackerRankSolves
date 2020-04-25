package leetcodeMedium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GetWatchedVideosByYourFriendsD {
	public List<String> watchedVideosByFriends2(List<List<String>> watchedVideos, int[][] friends, int id, int level) {

		int N = friends.length;
		boolean[] visited = new boolean[N]; // keeping list of visited frnds
		visited[id] = true;// i'm my own frnd

		ArrayList<Integer> q = new ArrayList<>();
		q.add(id);

		for (int k = 0; k < level; k++) {// depth less than level
			ArrayList<Integer> newQ = new ArrayList<>();
			for (int v : q) {
				for (int w : friends[v]) {// this is frnds of frnds
					if (!visited[w]) {
						visited[w] = true;
						newQ.add(w);
					}
				}
			}
			q = newQ;// change the list to own frnd of frnd
		}

		HashMap<String, Integer> freq = new HashMap<>();

		for (int person : q) {
			for (String v : watchedVideos.get(person)) {
				freq.put(v, 1 + freq.getOrDefault(v, 0));
			}
		}

		List<String> ans = new ArrayList<>(freq.keySet());

		ans.sort((a, b) -> {// custom sort
			int fa = freq.get(a);
			int fb = freq.get(b);
			if (fa != fb) {
				return fa - fb;
			} else {
				return a.compareTo(b);
			}
		});

		return ans;
	}
}
