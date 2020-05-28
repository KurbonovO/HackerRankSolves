package leetcodeMedium;

public class DecodeWays {

	public int decodeWays(String s) {

		int sLenght = s.length();
        int[] dp = new int[sLenght + 1];
        dp[1] = 1;
        dp[2] = s.charAt(0) != '0' ? 1 : 0;
        
        for (int i = 2; i <= sLenght; i++) {
            
        	int first = Integer.valueOf(s.substring(i - 1, i));
            int second = Integer.valueOf(s.substring(i - 2, i));
            
            if (first >= 1 && first <= 9) {
               dp[i] += dp[i-1];  
            }
            if (second >= 10 && second <= 26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[sLenght];
	}

	public static void main(String[] args) {

		DecodeWays decodeWays = new DecodeWays();
		System.out.println(decodeWays.decodeWays("226"));
	}

}
