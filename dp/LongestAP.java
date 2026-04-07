import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestAP {
	public static void main(String[] args) {
		int[] arr = {3, 1, 4, 6, 2, 8};
		System.out.println(solution(arr));
	}

	public static int solution(int[] arr) {
		int n = arr.length;
		List<Map<Integer, Integer>> dp = new ArrayList<>();
		int maxLen = 2;
		for (int i = 0; i < n; i++) {
			dp.add(new HashMap<>());
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int diff = arr[i] - arr[j];
				int len = dp.get(j).getOrDefault(diff, 1) + 1;
				dp.get(i).put(diff, len);
				maxLen = Math.max(maxLen, len);
			}
		}
		return maxLen;
	}
}
