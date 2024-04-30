package arrayOperations;

public class RemoveDuplicatesArray {

	public static void main(String[] args) {
		RemoveDuplicatesArray array = new RemoveDuplicatesArray();
		array.removeDuplicatesArray();

	}
	public void removeDuplicatesArray() {
		int[] array1 = {1, 2, 3, 4, 5, 5, 5, 7, 8, 7, 8};

		int length = array1.length;
	
		for (int i = 0; i < length - 1; i++) {
			for (int j = i + 1; j < length; j++) {
				if (array1[i] == array1[j]) {
					for (int k = j; k < length - 1; k++) {
						array1[k] = array1[k + 1];
					}
					length--;
					j--;
				}
			}
		}
		
		System.out.println("Array after removing duplicates:");
		
		for (int i = 0; i < length; i++) {
			System.out.print(array1[i] + " ");
		}
		System.out.println();
	}

}
