package demo;
import java.util.Scanner;

public class SecondClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter array size:");
        int size = scanner.nextInt();

        int[] array = new int[size];

        System.out.println("Enter the elements: ");

        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println("Array created with size " + size + ":");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
    
    }
}
