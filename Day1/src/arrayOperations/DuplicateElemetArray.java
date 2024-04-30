package arrayOperations;

public class DuplicateElemetArray {
	public static void main(String[] args) {
		DuplicateElemetArray array = new DuplicateElemetArray();
		array.duplicateElemetArray();
	}
	
	public void duplicateElemetArray() {
		int[] array1 = {1, 2, 3, 4, 5, 5, 5, 7, 8, 7, 8};

		System.out.println("Duplicate Elements:");
		
		for (int i = 0; i < array1.length - 1; i++) {
			for (int j = i + 1; j < array1.length; j++) {
				if (array1[i] == array1[j]) {
					System.out.print(array1[i] + " ");
					break;
				}
			}
		}
		System.out.println();
	}
}
