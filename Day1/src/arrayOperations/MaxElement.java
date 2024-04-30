package arrayOperations;

public class MaxElement {

	public static void main(String[] args) {
		MaxElement array = new MaxElement();
		array.maxElement();

	}
	
    public void maxElement() {
        int[] array1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        int max = array1[0];
        for (int i = 1; i < array1.length; i++) {
        	
            if (array1[i] > max) {
                max = array1[i];
            }
        }
        System.out.println(max);
        
    }

}
