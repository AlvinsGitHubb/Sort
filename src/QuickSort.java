public class QuickSort {
	static int comparisons = 0;
	static int movements = 0;

	public static void quickSort(int[] list) {
		quickSort(list, 0, list.length - 1);
		System.out.println("Comparisons: " + comparisons);
		System.out.println("Movements: " + movements);
	}

	public static void quickSort(int[] list, int first, int last) {
		if (last > first) {
			int pivotIndex = partition(list, first, last);
			quickSort(list, first, pivotIndex - 1);
			quickSort(list, pivotIndex + 1, last);
		}
	}

	/** Partition the array list[first..last] */
	public static int partition(int[] list, int first, int last) {
		int pivot = list[(first + last) / 2]; // Choose the first element as the pivot
		int low = first + 1; // Index for forward search
		int high = last; // Index for backward search

		while (high > low) { // while last index is greater than first
			// Search forward from left
			while (low <= high && list[low] <= pivot) { // while the low pointer is lss than high pointer and low doesnt
				low++;
				comparisons++;
			}

			// Search backward from right
			while (low <= high && list[high] > pivot) { // while low doesnt reach high and high doesnt point to a num
				high--;
				comparisons++;
			}

			// Swap two elements in the list
			if (high > low) { //
				comparisons++;
				int temp = list[high];
				list[high] = list[low];
				movements++;
				list[low] = temp;
				movements++;

			}
		}

		while (high > first && list[high] >= pivot) {
			high--;
			comparisons++;
		}

		// Swap pivot with list[high]
		if (pivot > list[high]) {
			comparisons++;
			list[first] = list[high];
			movements++;
			list[high] = pivot;
			movements++;
			return high;
		} else {
			return first;
		}
	}
}
