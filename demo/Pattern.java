package demo;

public class Pattern {
	public static void main(String[] args) {
		int num = 5;
		int num2 = 9;
		
		for(int i=1; i<num+1; i++) {
			for(int j=1; j<num+1; j++) {
				System.out.print(j);
			}
			System.out.println( );
		}
		
//      Output:		
//		12345
//		12345
//		12345
//		12345
//		12345
		
		System.out.println("_________________________________________________________");
		
		for(int i=1; i<num+1; i++) {
			for(int j=1; j<num+1; j++) {
				System.out.print(i);
			}
			System.out.println( );
		}
		
//      Output:		
//		11111
//		22222
//		33333
//		44444
//		55555
		
		System.out.println("_________________________________________________________");
		
		for(int i=1; i<=num2; i++) {
			for(int j=1; j<=i; j++) {
				System.out.print(j);
			}
			System.out.println( );		
		}
		
//      Output:
//		1
//		12
//		123
//		1234
//		12345
//		123456
//		1234567
//		12345678
//		123456789
		
		System.out.println("_________________________________________________________");
		
		for(int i=1; i<=num2+1; i++) {
			for(int j=i; j<=num2; j++) {
				System.out.print(j);
			}
			System.out.println( );		
		}
		
//		Output:
//		123456789
//		23456789
//		3456789
//		456789
//		56789
//		6789
//		789
//		89
//		9

		
		System.out.println("_________________________________________________________");
		
		
		for(int i=1; i<=num2; i++) {
			int k = i;
			for(int j=1; j<=i; j++) {
				System.out.print(k++ + " ");
			}
			System.out.println( );		
		}
		
//		Output:		
//		1 
//		2 3 
//		3 4 5 
//		4 5 6 7 
//		5 6 7 8 9 
//		6 7 8 9 10 11 
//		7 8 9 10 11 12 13 
//		8 9 10 11 12 13 14 15 
//		9 10 11 12 13 14 15 16 17 
		
	}
}
