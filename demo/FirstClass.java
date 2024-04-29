package demo;

class FirstClass {
    int[] numbers = new int[10];
    int[] values = {1, 2, 3, 4, 5};

    public static void main(String[] args) {
        FirstClass array1 = new FirstClass();

        System.out.println("Numbers array:");
        for (int num : array1.numbers) {
            System.out.print(num + " ");
        }
        System.out.println(); 

        System.out.println("Values array:");
        for (int val : array1.values) {
            System.out.print(val + " ");
        }
    }
}
