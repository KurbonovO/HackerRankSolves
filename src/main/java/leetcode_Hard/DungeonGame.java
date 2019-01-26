package leetcode_Hard;

public class DungeonGame {

	int[][] mem;

	private int helper(int[][] dungeon, int i, int j) {

		if (i >= dungeon.length || j >= dungeon[0].length)
			return Integer.MAX_VALUE;

		if (mem[i][j] > 0)
			return mem[i][j];

		int health = Integer.MAX_VALUE;
		health = Math.min(health, helper(dungeon, i + 1, j));
		health = Math.min(health, helper(dungeon, i, j + 1));
		health = health == Integer.MAX_VALUE ? 1 : health;
		int ret = health > dungeon[i][j] ? (health - dungeon[i][j]) : 1;
		mem[i][j] = ret;
		return ret;
	}

	public int calculateMinimumHP(int[][] dungeon) {

		if (dungeon.length == 0)
			return 0;

		mem = new int[dungeon.length][dungeon[0].length];
		return helper(dungeon, 0, 0);
	}
}
