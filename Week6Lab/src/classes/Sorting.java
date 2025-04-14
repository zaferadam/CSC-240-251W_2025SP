package classes;

public class Sorting {

	// Generic selection sort (descending order)
	public static <T extends Comparable<? super T>> void selectionSort(T[] list) {
		int min;
		T temp;

		for (int i = 0; i < list.length; i++) {
			min = i;
			for (int scanner = min + 1; scanner < list.length; scanner++) {
				// Descending sort: select the item that is GREATER
				if (list[scanner].compareTo(list[min]) > 0) {
					// Swap elements
					temp = list[min];
					list[min] = list[scanner];
					list[scanner] = temp;
				}
			}
		}
	}
}
