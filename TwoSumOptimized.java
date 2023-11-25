/*
 * @author: Fred Olum
 * @title: two sum target optimized
 * @description: given an array and a target,
 * 								find the indices that can be summed to target
 */

import java.lang.Integer;

import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

class TwoSumOptimized {
	private static Map<Integer, Integer> mapOfTargetOperands(int[] array, int target) {
		Map<Integer, Integer> numMap = new HashMap<>();
		for (int num : array) {
			if (numMap.containsKey(target-num)) {
				return new HashMap<Integer, Integer>(){{ put(num, (target-num)); }};
			}
			// numMap does not contain corresponding
			// value for num that sums to target
			numMap.put(num, (target-num));
		}
		throw new IllegalArgumentException("No two Sum Solution!");
	}
	
	public static Map<Integer, Integer> multipleTargetsOperands(int[] array) {
		Map<Integer, Integer> map =  Collections.emptyMap();
		for (int i=0,j=++i; i < array.length && j < array.length; i++,j++) {
			int target = array[i]+array[j];
			map.putAll(mapOfTargetOperands(array, target));
		}
		return map;
	}

	private static Map<Integer, Integer> mapOfTargetOperandsV2(int[] array, int target) {
		HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
		for (int num : array) {
			int other = target-num;
			map.computeIfAbsent(other,
					(unused) -> new HashMap<Integer, Integer>()
					).put(num, other);
			return map.get(other);
		}
		return Collections.emptyMap();
	}

	public static void main(String[] args) {
		int[] array = {2,3,6,4,7,10,9};
		System.out.println(TwoSumOptimized.multipleTargetsOperands(array));
	}
}
