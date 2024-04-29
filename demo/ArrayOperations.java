package demo;
import java.util.Scanner;

public class ArrayOperations {
	public static void main(String[] args) {
		ArrayOperations array = new ArrayOperations();
		ArrayOperations arr = new ArrayOperations();
		arr.createArray();
		arr.printArray();
		arr.reverseArray();
		arr.sortArray();
		arr.mergeArray();
		arr.zigZagMergeArray();
		arr.maxElement();
		arr.minElement();
		arr.unionArray();
		arr.intersection();
	}
	
	public int[] createArray() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("From Create Array Method");

        System.out.println("Enter array size:");
        int size = scanner.nextInt();

        int[] array = new int[size];

        System.out.println("Enter the elements: ");

        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println("Array created with size " + size + ":");
        for (int i = 0; i < size; i++) {
        	String array1 = array[i] + " ";
        }
		int[] array1 = {};
		return array1 ;
		
	}
	
	public void printArray() {
		
		System.out.println();
		
        System.out.println("From Create Array Method");
		
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
	
	public void reverseArray() {
		
		System.out.println();
        System.out.println("From Reverse Array Method");
		
        int[] array = {1,2,3,4,5,6};
        int[] reversedArray = {};
        
//        for(int i = 0; i < array.length; i++) {
//        	reversedArray = reversedArray +  array[i];
//        }

	}
	
	public int[] sortArray() {
		return null;	
	}
	
	public int[] mergeArray() {
		return null;
	}
	
	public int[] zigZagMergeArray() {
		return null;
	}
	
	public int[] maxElement() {
		return null;
	}
	
	public int[] minElement() {
		return null;
	}
	
	public int[] unionArray() {
		
		System.out.println();
		System.out.println("From Union");
		
		int[] array = {1,2,3,4,5};
		int[] array2 = {5,6,7,8};
		int[] array3 = new int[array.length + array2.length];
		
		int i = 0, j = 0, k = 0;
		
		while(i< array.length && j< array2.length) {
			if(array[i] == array2[j]) {
				array3[k++] = array[i++];
				j++;
				
			}else if(array[i]<array2[j]) {
				array3[k++]=array2[j++];
			}
			
		}
		while(i<array.length) {
			array3[k++] = array[i++];
		}
		
		while(j<array2.length) {
			array3[k++] = array2[j++];
		}
		
		for(int value: array3) {
			if(i!=0) {
				System.out.println(value);
			}
		}
		
		return array3;
	}
	
	public int[] intersection() {
		return null;
	}
	
}
