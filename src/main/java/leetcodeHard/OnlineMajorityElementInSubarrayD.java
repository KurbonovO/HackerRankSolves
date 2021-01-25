package leetcodeHard;

public class OnlineMajorityElementInSubarrayD {

	int[] arr;

	public OnlineMajorityElementInSubarrayD(int[] arr) {
        this.arr = arr;
    }

	public int query(int left, int right, int threshold) {
		int vote = -1;
		int cnt = 0;
		for (int i = left; i <= right; i++) {
			if (cnt == 0) {
				vote = arr[i];
			}
			if (vote == arr[i]) {
				cnt++;
			} else {
				cnt--;
			}
		}
		cnt = 0;
		for (int i = left; i <= right; i++) {
			if (arr[i] == vote) {
				cnt++;
			}
		}
		return cnt >= threshold ? vote : -1;
	}

}
