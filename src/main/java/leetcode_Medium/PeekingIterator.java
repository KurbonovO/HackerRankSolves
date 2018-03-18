package leetcode_Medium;

import java.util.Iterator;
import java.util.NoSuchElementException;

/*284 Given an Iterator class interface with methods: next() and hasNext(), design and implement a
PeekingIterator that support the peek() operation -- it essentially peek() at the element that will 
be returned by the next call to next(). Here is an example. Assume that the iterator is initialized
to the beginning of the list: [1, 2, 3]. Call next() gets you 1, the first element in the list.
Now you call peek() and it returns 2, the next element. Calling next() after that still return 2.
You call next() the final time and it returns 3, the last element. Calling hasNext() after that should
return false.		*/

public class PeekingIterator implements Iterator<Integer> {

	Integer next;
	Iterator<Integer> iter;
	boolean noSuchElement;

	public PeekingIterator(Iterator<Integer> iterator) {
	  
		//initialize any member here.
		iter = iterator;
		advanceIter();
	}

  //Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		// you should confirm with interviewer what to return/throw
		// if there are no more values
		return next;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		
		if (noSuchElement)
			throw new NoSuchElementException();
		Integer res = next;
		advanceIter();
		return res;
	}

	@Override
	public boolean hasNext() {
		return !noSuchElement;
	}

	private void advanceIter() {
		
		if (iter.hasNext()) {
			next = iter.next();
		} else {
			noSuchElement = true;
		}
	}
}