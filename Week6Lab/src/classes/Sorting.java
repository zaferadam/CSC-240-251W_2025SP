package classes;

public class Sorting {

	public static <T extends Comparable<? super T>> void selectionSort(T[] list) {
		int min;
		T temp;
		
		for(int i=0; i<list.length; i++) {
			min = i;
			for (int scanner = min+1; scanner<list.length; scanner++) {
				int comparator = list[scanner].compareTo(list[min]);
				if (comparator>0) {
					temp = list[min];
					list[min]=list[scanner];
					list[scanner]=temp;
				}
			}
		}
	}
}
