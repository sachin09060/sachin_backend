package arrayOperations;

public class SortingArray {

	public static void main(String[] args) {
		SortingArray array = new SortingArray();
		array.sorting();
	}
	
	public void sorting() {
	    int[] array = {1, 2, 3, 4, 5, 5, 5, 7, 8, 7, 8};
	    System.out.println("Sorted Array:");
	    
	    for (int i = 0; i < array.length - 1; i++) {
	        for (int j = 0; j < array.length - i - 1; j++) {
	            if (array[j] > array[j + 1]) {
	                int temp = array[j];
	                array[j] = array[j + 1];
	                array[j + 1] = temp;
	            }
	        }
	    }
	    
	    for (int num : array) {
	        System.out.print(num + " ");
	    }
	    System.out.println();
	}

}