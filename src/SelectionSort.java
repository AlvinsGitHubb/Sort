
public class SelectionSort {
	/** The method for sorting the numbers */
	public static void selectionSort(int[] list) { // int[] list?
		int movements = 0;
		int comparisons = 0;
		for (int i = 0; i < list.length - 1; i++) {
			// Find the minimum in the list[i..list.length-1]
			int currentMin = list[i];
			int currentMinIndex = i;

			for (int j = i + 1; j < list.length; j++) {
				comparisons++;
				if (currentMin > list[j]) {
					currentMin = list[j];
					currentMinIndex = j;
					movements++;
				}
			}

			// Swap list[i] wiht list[currentMinIndex[ if necessary
			if (currentMinIndex != i) {
				list[currentMinIndex] = list[i];
				list[i] = currentMin;
				movements++;
				comparisons++;
			}
		}
		System.out.println("Comparisons: " + comparisons);
		System.out.println("Movements: " + movements);
	}
}
