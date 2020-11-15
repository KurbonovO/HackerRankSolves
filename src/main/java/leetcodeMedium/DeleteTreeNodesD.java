package leetcodeMedium;

public class DeleteTreeNodesD {

	public int deleteTreeNodes(int n, int[] parent, int[] value) {
		int[] res = new int[n];
		for (int i = n - 1; i > 0; --i) {
			value[parent[i]] += value[i];
			res[parent[i]] += value[i] != 0 ? res[i] + 1 : 0;
		}
		return value[0] != 0 ? res[0] + 1 : 0;
	}

}
