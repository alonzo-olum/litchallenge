/*
 * @author: Fred Olum
 * @title: MaxInBitonicArray
 */
class MaxInBitonicArray {
	public static int findMaxValueInBitonicArray(int[] arr) {
		int start=0;
		int end=arr.length-1;
		while (start<=end) {
			int mid=start + (end-start)/2;
			if (arr[mid]<arr[mid+1]) {
				// we are dealing with an ascending sorted array
				start=mid+1;
			} else {
				// we are dealing with a descending sorted array
				end=mid;
			}
		}
		// at this point 'start==end'
		return arr[start];
	}

	public static void main(String[] args) {
		System.out.println(MaxInBitonicArray.findMaxValueInBitonicArray(new int[]{ 1, 3, 6, 12, 8, 4, 2}));
	}
}
