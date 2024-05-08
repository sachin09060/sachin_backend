package arrayOperations;

public class MergeArray {

	public static void main(String[] args) {
		MergeArray array = new MergeArray();
		array.mergeArray();

	}
	
	public void mergeArray() {
		int[] array1 = {1, 2,1000, 3};
		int[] array2 = {4, 5, 6, 400, 200, 100};
	
		int mergedLength = array1.length + array2.length;
		int[] mergedArray = new int[mergedLength];
	
		for (int i = 0; i < array1.length; i++) {
			mergedArray[i] = array1[i];
		}
	
		for (int i = 0; i < array2.length; i++) {
			mergedArray[array1.length + i] = array2[i];
		}

		System.out.print("Merged Array is sorted now: ");
		for (int num : mergedArray) {
			
		    for (int i = 0; i < mergedArray.length - 1; i++) {
		        for (int j = 0; j < mergedArray.length - i - 1; j++) {
		            if (mergedArray[j] > mergedArray[j + 1]) {
		                int num2 = mergedArray[j];
		                mergedArray[j] = mergedArray[j + 1];
		                mergedArray[j + 1] = num2;
		            }
		        }
		    }
		    
			System.out.print(num + " ");
		}
	}
}
