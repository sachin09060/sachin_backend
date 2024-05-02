package arrayOperations;

public class IntersectionArray {

	public static void main(String[] args) {
		IntersectionArray array = new IntersectionArray();
		array.intersectionArray();

	}
	public void intersectionArray() {
		int[] array1 = {1, 2, 3, 4, 5};
		int[] array2 = {5, 6, 7, 8};
	
		for (int i = 0; i < array1.length - 1; i++) {
			for (int j = 0; j < array1.length - i - 1; j++) {
				if (array1[j] > array1[j + 1]) {
					int temp = array1[j];
					array1[j] = array1[j + 1];
					array1[j + 1] = temp;
				}
			}
		}
	
		for (int i = 0; i < array2.length - 1; i++) {
			for (int j = 0; j < array2.length - i - 1; j++) {
				if (array2[j] > array2[j + 1]) {
					int temp = array2[j];
					array2[j] = array2[j + 1];
					array2[j + 1] = temp;
				}
			}
		}
	
		int maxLength = Math.min(array1.length, array2.length);
		System.out.println("Intersection of arrays:");
		for (int i = 0, j = 0; i < array1.length && j < array2.length;) {
			if (array1[i] == array2[j]) {
				System.out.print(array1[i] + " ");
				i++;
				j++;
			} else if (array1[i] < array2[j]) {
				i++;
			} else {
				j++;
			}
		}
		System.out.println();
	}

}
