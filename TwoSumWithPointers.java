class TwoSumWithPointers {
	public static int[] search(int[] arr, int target) {
		int left = 0, right = arr.length-1;
		while (left < right) {
			int diff = target - arr[left];
			if (diff == arr[right])
				return new int[] { left, right };
			
			if (diff > arr[right])
				left++;
			else
				right--;
		}
			return new int[] { -1, -1 };
	}

	public static void main(String[] args) {
		System.out.println("First val index: " + TwoSumWithPointers.search(new int[] { 12, 11, 1, 7, 8, 10, 15 }, 21)[0]);
	}
}
