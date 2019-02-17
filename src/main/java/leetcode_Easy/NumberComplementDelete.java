package leetcode_Easy;

public class NumberComplementDelete {
	public int findComplement(int num) {
		
		return ~num & ((Integer.highestOneBit(num) << 1) - 1);
	}
}
