package arrayOperations;

public class PrintArray {

	public static void main(String[] args) {
		PrintArray array = new PrintArray();
		array.printArray();
	}
	
	public void printArray() {
    	int[] array = {1, 2, 3, 4, 5, 5, 5, 7, 8, 7, 8};
        System.out.print("Array Elements are: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
	}

}
