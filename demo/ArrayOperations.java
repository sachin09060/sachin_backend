package demo;
import java.util.Scanner;

public class ArrayOperations {
	public static void main(String[] args) {
		ArrayOperations array = new ArrayOperations();
		array.createArray();
		array.printArray();
		array.reverseArray(array);
		array.sortArray();
		array.mergeArray();
		array.zigZagMergeArray();
		array.maxElement();
		array.minElement();
		array.unionArray();
		array.intersection();
		array.occurance();
        array.removeDuplicatesArray();
        array.duplicateElemetArray();
        array.countPrimeImplecants();
	}

//	creating array method

	public int[] createArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the length of the array: ");
        int length = scanner.nextInt();

        array = new int[length];

        for (int i = 0; i < length; i++) {
            int element = scanner.nextInt();
            array[i] = element;
        }

        return array;
    }

//	printing array method

    public void printArray(int[] array) {
        System.out.print("Array: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
	
//	reversing array from previous return method

	public int[] reverseArray(int[] array) {
		int length = array.length;
		for (int i = 0; i < length / 2; i++) {
			int array2 = array[i];
			array[i] = array[length - i - 1];
			array[length - i - 1] = array2;
		}
		return array;
	}
	
//	sorting array method

public void sorting() {
    int[] array = {1, 2, 3, 4, 5, 5, 5, 7, 8, 7, 8};
    System.out.println("Sorted Array:");
    
    for (int i = 0; i < array.length - 1; i++) {
        for (int j = 0; j < array.length - i - 1; j++) {
            if (array[j] > array[j + 1]) {
                int temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
            }
        }
    }
    
    for (int num : array) {
        System.out.print(num + " ");
    }
    System.out.println();
}

// merging array method

	public void mergeArray() {
		int[] array1 = {1, 2, 3};
		int[] array2 = {4, 5, 6};
	
		int mergedLength = array1.length + array2.length;
		int[] mergedArray = new int[mergedLength];
	
		for (int i = 0; i < array1.length; i++) {
			mergedArray[i] = array1[i];
		}
	
		for (int i = 0; i < array2.length; i++) {
			mergedArray[array1.length + i] = array2[i];
		}

		System.out.print("Merged Array: ");
		for (int num : mergedArray) {
			System.out.print(num + " ");
		}
		System.out.println();
	}
	
//	zigzag array method
	
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

// maximum element array method

    public int maxElement() {
        int[] array1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        if (array1.length == 0) {
            return -1;
        }

        int max = array1[0];
        for (int i = 1; i < array1.length; i++) {
            if (array1[i] > max) {
                max = array1[i];
            }
        }
        return max;
    }

// minimum element array method

    public int minElement() {
        int[] array1 = {1, 2, 3, 4, 5, 6, 7, 8, 9}; 
        if (array1.length == 0) {
            return -1;
        }

        int min = array1[0];
        for (int i = 1; i < array1.length; i++) {
            if (array1[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

// union array method
	
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

		System.out.println("Union Array:");
		for (int l = 0; l < k; l++) {
			System.out.println(array3[l]);
		}
		int[] unionArray = Arrays.copyOf(array3, k);

		return unionArray;
	}

//	intersection array method

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
	
// occurance array method
	
	public void occurance() {
		int[] array1 = {1, 2, 3, 4, 5, 5, 5, 7, 8, 7, 8};
		System.out.println("Occurrence of each element:");
		Arrays.sort(array1);
		int current = array1[0];
		int count = 1;
	
		for (int i = 1; i < array1.length; i++) {
			if (array1[i] == current) {
				count++;
			} else {
				System.out.println(current + ": " + count);
				current = array1[i];
				count = 1;
			}
		}

		System.out.println(current + ": " + count);
	}

// remove duplicate array mmethod

	public void removeDuplicatesArray() {
		int[] array1 = {1, 2, 3, 4, 5, 5, 5, 7, 8, 7, 8};
		System.out.println("Array after removing duplicates:");
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
	
		for (int i = 0; i < length; i++) {
			System.out.print(array1[i] + " ");
		}
		System.out.println();
	}

// print duplicate vale array method

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

//	count prime array method

	public void countPrimeImplecants() {
		int[] array1 = {1, 2, 3, 4, 5, 5, 5, 7, 8, 7, 8};
		System.out.println("Prime Elements:");
		for (int num : array1) {
			if (isPrime(num)) {
				System.out.print(num + " ");
			}
		}
		System.out.println();
	}
		
	
}
