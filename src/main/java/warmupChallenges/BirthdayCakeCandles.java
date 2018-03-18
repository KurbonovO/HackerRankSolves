package warmupChallenges;

import java.util.Scanner;

/*Colleen is turning n years old! Therefore, she has n candles of various heights on her cake, and candle i has height Heighti.
Because the taller candles tower over the shorter ones, Colleen can only blow out the tallest candles.Given the Heighti for
each individual candle, find and print the number of candles she can successfully blow out*/

public class BirthdayCakeCandles {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
      //the number of candles
        int n = scan.nextInt();
        
      //store the current maximum height of any candle, initialize to the minimum possible height of any candle
        int maxHeight = 1; 
        
      //count the number of candles having the maximum height
        int countMax = 0;
        
        for(int i = 0; i < n; i++) {
            int tmp = scan.nextInt();
            
          //if you read in a value larger than maxHeight, set new maxHeight
            if(tmp > maxHeight) {
                maxHeight = tmp;
                countMax = 1;
            }
          //if you read a value equal to the current value of maxHeight
            else if(tmp == maxHeight) {
              //increment the count of candles having maximum height
                countMax++;
            }
        }
        scan.close();
        
        System.out.println(countMax);
    }
}

/*Sample Input: 
4
3 2 1 3
Sample Output:
2
Explanation: We have one candle of height 1, one candle of height 2, and two candles of height 3. Colleen only blows out the
tallest candles, meaning the candles where height = 3. Because there are 2 such candles, we print 2 on a new line*/
