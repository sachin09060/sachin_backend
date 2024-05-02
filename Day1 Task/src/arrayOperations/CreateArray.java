package arrayOperations;

import java.util.Scanner;

public class CreateArray {

	public static void main(String[] args) {
		CreateArray array = new CreateArray();
		array.createArray();
	}
	
	public void createArray() {
		int[] array = {};
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the length of the array: ");
        int length = scanner.nextInt();

        array = new int[length];

        for (int i = 0; i < length; i++) {
            int element = scanner.nextInt();
            array[i] = element;
        }
        System.out.println("Array created with size: "+ length );
        System.out.print("This is the array Object address: ");
        System.out.println(array);
    }

}
