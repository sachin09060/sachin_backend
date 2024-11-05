package arrayOperations;

public class ReverseArray {

	public static void main(String[] args) {
		

		ReverseArray array = new ReverseArray();
		array.reverseArray();
	}
	
	public void reverseArray() {
		int[] arr = {1,2,3,4,5,6};
		int length = arr.length;
		for (int i = 0; i < length / 2; i++) {
			int arr1 = arr[i];
			arr[i] = arr[length - i - 1];
			arr[length - i - 1] = arr1;
		}
		
		System.out.println("Reversed array: ");
		
		for(int i=0; i < arr.length; i++) {
			int arr1 = arr[i];
			System.out.print(arr1);
		}

	}

}
