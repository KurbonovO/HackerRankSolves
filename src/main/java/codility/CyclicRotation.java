package codility;

//each element is shifted right by one index, and the last element of the array is also moved to the first place.
//For example A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7]

public class CyclicRotation {

	public int[] solution(int[] A, int K) {

		int[] B = new int[A.length];
		for (int i = 0; i < A.length; i++) {
			B[(i + K) % A.length] = A[i];
		}
		return B;

	}
}
