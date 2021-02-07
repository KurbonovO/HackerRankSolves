package leetcodeHard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RectangleAreaIID {

	public int rectangleArea(int[][] rectangles) {
		int mod = (int) (1e9 + 7);
		Set<Integer> x = new TreeSet<>();
		List<int[]> L = new ArrayList<>();
		for (int[] r : rectangles) {
			x.add(r[0]);
			x.add(r[2]);
			L.add(new int[] { r[1], r[0], r[2], 1 });
			L.add(new int[] { r[3], r[0], r[2], -1 });
		}
		List<Integer> unique = new ArrayList<>(x);
		Map<Integer, Integer> xMap = IntStream.range(0, unique.size()).boxed()
				.collect(Collectors.toMap(unique::get, i -> i));
		int[] cnt = new int[unique.size()];
		Collections.sort(L,
				(a, b) -> a[0] == b[0]
						? a[1] == b[1] ? a[2] == b[2] ? Integer.compare(a[3], b[3]) : Integer.compare(a[2], b[2])
								: Integer.compare(a[1], b[1])
						: Integer.compare(a[0], b[0]));
		long curY = 0;
		long curXSum = 0;
		long area = 0;
		for (int[] l : L) {
			long y = (long) l[0], x1 = (long) l[1], x2 = (long) l[2], sig = (long) l[3];
			area = (area + (y - curY) * curXSum) % mod;
			curY = y;
			for (int i = xMap.get((int) x1); i < xMap.get((int) x2); i++) {
				cnt[i] += (int) sig;
			}
			curXSum = 0;
			for (int i = 0; i < unique.size(); i++) {
				if (cnt[i] > 0) {
					curXSum += unique.get(i + 1) - unique.get(i);
				}
			}
		}
		return (int) area;
	}

}
