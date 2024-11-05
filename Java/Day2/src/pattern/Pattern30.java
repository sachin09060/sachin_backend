package pattern;

public class Pattern30 {
	
	public void pattern30() {
		int n = 5;
		for(int rows = 1; rows <= n; rows++) {
			
			for(int col=1; col<=n-rows; col++) {
				System.out.print("  ");
			}
			
			for(int col=1; col<= rows; col++) {
				System.out.print(col + " ");
				if(col<rows) {
					System.out.print("*"+ " ");
				}
			}
			System.out.println();
		}

		
	}

	public static void main(String[] args) {
		Pattern30 p = new Pattern30();
		p.pattern30();

	}
	
//	output:
//        1 
//      1 * 2 
//    1 * 2 * 3 
//  1 * 2 * 3 * 4 
//1 * 2 * 3 * 4 * 5 

}
