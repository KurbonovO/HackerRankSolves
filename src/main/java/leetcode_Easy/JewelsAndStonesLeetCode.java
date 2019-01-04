package leetcode_Easy;

public class JewelsAndStonesLeetCode {
	public int jewwlsAndStones(String jewels, String strones) {
	
		return strones.replaceAll("[^" + jewels + "]", "").length();
	}
}
