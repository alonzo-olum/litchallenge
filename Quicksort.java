import java.util.Arrays;

class Quicksort {

	private int[] arr;

	public Quicksort (int[] arr) {
		this.arr = arr;
	}

	private int partition(int leftPointer, int rightPointer) {
		int pivotPosition = rightPointer;
		int pivot = this.arr[pivotPosition];

    // starting at the position left to the pivot
		rightPointer--;
		
		while (true) {
			while (leftPointer < this.arr.length && this.arr[leftPointer] < pivot) {
				leftPointer++;
			}

			while (rightPointer >= 0 && this.arr[rightPointer] > pivot) {
				rightPointer--;
			}

			if (leftPointer >= rightPointer) {
				break;
			} else {
				// swap leftPointer value with rightPointer value
				swap(leftPointer, rightPointer);
			}
		}
		// swap leftPointer with pivot respective values as final step
		swap(leftPointer, pivotPosition);
		return leftPointer;
	}

	private void swap(int left, int right) {
		int tempValue = this.arr[left];
		this.arr[left] = this.arr[right];
		this.arr[right] = tempValue;
	}

	public void quicksort(int leftIndex, int rightIndex) {
		// if rightIndex is same (or before) position as leftIndex
		// return arr assume is sorted (or mis-aligned)
		if (rightIndex - leftIndex <= 0) {
			return;
		}

		int pivotPosition = partition(leftIndex, rightIndex);

		quicksort(leftIndex, pivotPosition-1);

		quicksort(pivotPosition+1, rightIndex);
	}

	public int[] sortedArr() { return this.arr; }

	public static void main(String[] args) {
		int[] unsortedArr = { 234, 23, 543, 12, 5, 7, 2, 1, 879, 10, 45, 3};
		int start = 0;
		int end = unsortedArr.length-1;
		Quicksort qs = new Quicksort(unsortedArr);
		qs.quicksort(start, end);
		System.out.println(Arrays.toString(qs.sortedArr()));
	}
} 
