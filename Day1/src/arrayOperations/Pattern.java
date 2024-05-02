package arrayOperations;

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
		// 1
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
		//2
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
		//3
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
		//4
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
		//5
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

System.out.println("_________________________________________________________");

		int n = 5;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.print(i + "," + j + "  ");
			}
			System.out.println();
		}
		//6
//		Output:	
//	1,1  1,2  1,3  1,4  1,5  
//	2,1  2,2  2,3  2,4  2,5  
//	3,1  3,2  3,3  3,4  3,5  
//	4,1  4,2  4,3  4,4  4,5  
//	5,1  5,2  5,3  5,4  5,5  

System.out.println("_________________________________________________________");


		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 5; j++) {
				if (j % 2 == 0) {
					System.out.print(0);
				} else {
					System.out.print(1);
				}
			}
			System.out.println();
		}
		//6
//	Output:	
//	10101
//	10101
//	10101
//	10101
//	10101


	}
	
	
	
	
	
}
