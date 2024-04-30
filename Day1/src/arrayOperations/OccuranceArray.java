package arrayOperations;

public class OccuranceArray {

	public static void main(String[] args) {
		OccuranceArray array = new OccuranceArray();
		array.occuranceArray();

	}
	public void occuranceArray() {

		System.out.println("Occurrence of each element:");
	    int[] array = {1, 2, 3, 4, 5, 5, 5, 7, 8, 7, 8};
		
		int current = array[0];
		int count = 1;
	    
	    for (int i = 0; i < array.length - 1; i++) {
	        for (int j = 0; j < array.length - i - 1; j++) {
	            if (array[j] > array[j + 1]) {
	                int temp = array[j];
	                array[j] = array[j + 1];
	                array[j + 1] = temp;
	            }
	        }
	    }
	    
	
		for (int i = 1; i < array.length; i++) {
			if (array[i] == current) {
				count++;
			} else {
				System.out.println(current + " Occurs : " + count+ " times");
				current = array[i];
				count = 1;
			}
		}

		System.out.print(current + " Occurs: " + count + " times");
	}

}
