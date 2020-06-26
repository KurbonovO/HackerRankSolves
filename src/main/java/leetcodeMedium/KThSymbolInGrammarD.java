package leetcodeMedium;

public class KThSymbolInGrammarD {

	public int kthGrammar(int N, int K) {
		return Integer.bitCount(K - 1) & 1;
	}
	
}
