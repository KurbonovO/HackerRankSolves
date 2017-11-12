package leetcode;

/*338 Given a non negative integer number num. For every numbers i in the range 0 <_ i <_ num calculate the
number of 1's in their binary representation and return them as an array. For num = 5 you should return [0,1,1,2,1,2]*/

public class CountingBits {

	public int[] countBits(int num) {
		
		int[] answer = new int[num + 1];
		
		int offset = 1;
		
		for (int i = 1; i < answer.length; i++) {
			if (offset * 2 == i)
				offset *= 2;
			answer[i] = 1 + answer[i - offset];
		}
		return answer;
	}
}