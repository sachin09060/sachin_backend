package arrayOperations;

public class ZigZagMergeArray {

	public static void main(String[] args) {
		ZigZagMergeArray array = new ZigZagMergeArray();
		array.zigZagMergeArray();

	}
	
	public void zigZagMergeArray() {

        int[] array1 = {1, 2, 3};
        int[] array2 = {4, 5, 6};

        int maxLength = array1.length > array2.length ? array1.length : array2.length;

        int[] mergedArray = new int[array1.length + array2.length];
        int mergedIndex = 0;

        for (int i = 0; i < maxLength; i++) {
            if (i < array1.length) {
                mergedArray[mergedIndex] = array1[i];
                mergedIndex++;
            }

            if (i < array2.length) {
                mergedArray[mergedIndex] = array2[i];
                mergedIndex++;
            }
        }

        System.out.print("Merged Array: ");
        for (int num : mergedArray) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

}
