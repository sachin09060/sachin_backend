package arrayOperations;

public class MinElement {

	public static void main(String[] args) {
		MinElement array = new MinElement();
		array.minElement();
	}
	
    public void minElement() {
        int[] array1 = { 2, 3, 4, 5, 6, 7, 8, 9}; 

        int min = array1[0];
        for (int i = 1; i < array1.length; i++) {
            if (array1[i] < min) {
                min = array1[i];
            }
        }
        System.out.println(min);
    }

}
