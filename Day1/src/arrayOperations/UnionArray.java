package arrayOperations;
import java.util.Arrays;

public class UnionArray {

	public static void main(String[] args) {
		UnionArray array = new UnionArray();
		array.unionArray();

	}
	
	public int[] unionArray() {
	System.out.println();
	System.out.println("From Union");

	int[] array1 = {1, 2, 3, 4, 5};
	int[] array2 = {5, 6, 7, 8};
	int[] array3 = new int[array1.length + array2.length];

	int i = 0, j = 0, k = 0;

	while (i < array1.length && j < array2.length) {
		if (array1[i] < array2[j]) {
			array3[k++] = array1[i++];
		} else if (array1[i] > array2[j]) {
			array3[k++] = array2[j++];
		} else {
			array3[k++] = array1[i++];
			j++;
		}
	}

	while (i < array1.length) {
		array3[k++] = array1[i++];
	}

	while (j < array2.length) {
		array3[k++] = array2[j++];
	}

	for (int l = 0; l < k; l++) {
		System.out.print(array3[l]);
	}
	int[] unionArray = Arrays.copyOf(array3, k);

	return unionArray;
}

}
