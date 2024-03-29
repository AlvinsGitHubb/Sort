
public class InsertionSort {
	/** The method for sorting the numbers */
	public static void insertionSort(int[] list) {
		int movements = 0;
		int comparisons = 0;
		for (int i = 1; i < list.length; i++) {
			/**
			 * Insert list[i] into a sorted sublist list[0..i-1] so that
			 * list[0..i] is sorted
			 */
			int currentElement = list[i];
			int k;
			for (k = i - 1; k >= 0 && list[k] > currentElement; k--) {
				list[k + 1] = list[k];
				movements++;
				comparisons++;
			}

			// insert the current element into list[k + 1]
			list[k + 1] = currentElement;
			comparisons++;

		}
		System.out.println("Comparisons: " + comparisons);
		System.out.println("Movements: " + movements);
	}
}
