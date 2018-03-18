package implementationChallenges;

/*There are two kangaroos on a number line ready to jump in the positive direction (i.e, toward positive infinity).
The first kangaroo starts at location x1 and moves at a rate of v1 meters per jump. The second kangaroo starts at
location x2 and moves at a rate of v2 meters per jump. Given the starting locations and movement rates for each kangaroo,
can you determine if they'll ever land at the same location at the same time?
Print YES if they can land on the same location at the same time; otherwise, print NO
We just need to check if a solution exists for the following equation: x1 + t * v1 == x2 + t * v2
This is equivalent to checking if (x2 - x1) % (v1 - v2) == 0*/

public class Kangaroo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

/*Sample Input:
0 3 4 2
Sample Output:
YES
Explanation: The two kangaroos jump through the following sequence of locations:
0 -> 3 -> 6 -> 9 -> 12 
4 -> 6 -> 8 -> 10 -> 12  
Thus, the kangaroos meet after 4 jumps and we print YES.

Sample Input:
0 2 5 3
Sample Output:
NO
Explanation: The second kangaroo has a starting location that is ahead (further to the right) of the first kangaroo's
starting location (i.e., x2>x1 ). Because the second kangaroo moves at a faster rate (meaning v2>v1) and is already
ahead of the first kangaroo, the first kangaroo will never be able to catch up. Thus, we print NO*/
