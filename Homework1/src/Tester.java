import java.util.Arrays;

public class Tester {
	
	public static void main(String[] args) {
		
		int array[] = {1, 2, 5, 7, 9, 14, 16, 19};
		System.out.println("Using an input array A = " + Arrays.toString(array));
		System.out.println("Performing quickSearch(A, 8) returns " + quickSearch(array, 8) + ", the index of number " + array[quickSearch(array, 8)]);
		System.out.println("Performing quickSearch(A, 19) returns " + quickSearch(array, 19) + ", the index of number " + array[quickSearch(array, 19)]);
		System.out.println("Performing quickSearch(A, 20) returns " + quickSearch(array, 20) + ", indicating there is no such value that is greater than or equal to 20 in array A");
		System.out.println("Performing quickSearch(A, 6) returns " + quickSearch(array, 6) + ", the index of number " + array[quickSearch(array, 6)]);
		System.out.println("Performing quickSearch(A, 8) returns " + quickSearch(array, -1) + ", the index of number " + array[quickSearch(array, -1)]);
	}
	
	public static int quickSearch(int[] array, int value) {
		
		int low = 0, high = array.length - 1, next = -1, mid;
		
		while (low <= high) {
			mid = low + (high-low)/2;
			if (array[mid] == value) {
				return mid;
			}
			if (array[mid] < value) {
				low = mid + 1;
			} else {
				next = mid;
				high = mid - 1;
			}
		}
		
		return next;
	}

}
