import java.util.HashMap;
import java.util.Map;

/* Date: 05/11/2020
 * author: Fred Olum
 *
 * Algorithm: Two Sum
 * Given an array of integers n and a target integer t
 * Return indices of integers returning their sum as t
 */

class TwoSum {

	private int[] nums;
	private int t;

	public TwoSum(int[] nums, int t) {
		this.nums = nums;
		this.t = t;
	}

	public int[] twoSum(){
		Map<Integer, Integer> map = new HashMap<>();
		for (int i=0; i<nums.length; i++) {
			if (map.containsKey(t-nums[i])) {
				return new int[] {
					map.get(t-nums[i]), i };
			}
			map.put(nums[i], i);
		}
		throw new IllegalArgumentException("No two Sum Solution!");
	}

	public static void main(String[] args) {
		System.out.println("Target value " + new TwoSum(new int[] { 23, 2, 3, 17, 14 }, 19).twoSum()[0]);
	}
}
