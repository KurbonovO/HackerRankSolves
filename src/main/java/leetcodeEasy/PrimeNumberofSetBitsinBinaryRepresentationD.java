package leetcodeEasy;

import java.util.stream.IntStream;

public class PrimeNumberofSetBitsinBinaryRepresentationD {

	public int countPrimeSetBits(int L, int R) {
		
		return IntStream.range(L, R + 1).map(i -> 665772 >> Integer.bitCount(i) & 1).sum();
	}

}
