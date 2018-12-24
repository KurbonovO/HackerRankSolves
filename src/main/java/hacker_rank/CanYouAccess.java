package hacker_rank;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/*You are given a class Solution and an inner class Inner. Private. The main
method of class Solution takes an integer num as input. The power of 2 in class
Inner. Private checks whether a number is a power of 2. You have to call the
method powerof2 of the class Inner. Private from the main method of the class
Solution.
Sample Input: 8		Sample Output: 8 is power of 2
An instance of class: Solution. Inner. Private has been created				 */

public class CanYouAccess {
	public canYouAccess(int num) {
	
	
	if(num<1||num>Math.pow(2,30))
	    throw new Exception();

	Solution.Inner ob=new Solution.Inner();
	Class<?> c = Solution.Inner.class.getDeclaredClasses()[0];
	Constructor<?> constructor = c.getDeclaredConstructor(Solution.Inner.class);
	constructor.setAccessible(true);
	o = constructor.newInstance(ob);
	Method m = c.getDeclaredMethod("powerof2",new Class[]{int.class}) ;
	m.setAccessible(true);         
	String ans = (String) m.invoke(o,num);
	System.out.println(num+" is "+ans);
}
}
