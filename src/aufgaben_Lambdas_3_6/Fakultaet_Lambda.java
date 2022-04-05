package aufgaben_Lambdas_3_6;

import java.util.function.IntFunction;

public class Fakultaet_Lambda {
	
	public static IntFunction<Integer> 	fact ;
	
	  static { fact = n -> 
	  (n == 1) ? 1 : n * fact.apply(n-1); }
	 
	
	public static int fakrek(int i) {
		if ( i==1) return 1;
		else return i* fakrek(i-1);
	}
	
	public static void main( String[] args ) {
		System.out.println( fact.apply( 5 ) ); // 120
		System.out.println( fakrek( 5 ) );
	}
}
