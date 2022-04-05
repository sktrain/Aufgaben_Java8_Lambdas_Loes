package aufgaben_Lambdas_2;

import java.util.Arrays;
import java.util.function.IntConsumer;

public class Aufgabe_7_loes {

	public static void main(final String[] args) {
		final int[] original = new int[100];
		specialFill(original);
		printRange(original, 0, 100);
		printRangeNeu(original, 0, 100);
		
		modify(original);
		printRange(original, 0, 100);
	}
	
	private static void specialFill(int[] values) {
		Arrays.setAll(values, index -> index % 10);
	}

	//auch printRange lässt sich anders schreiben	
	private static void printRangeNeu(final int[] values, final int startIdx, final int endIdx) {
		Arrays.spliterator(values, startIdx, endIdx)
		       .forEachRemaining((int i) -> System.out.print(i + " "));
		System.out.println();
	}

	private static void printRange(final int[] values, final int startIdx, final int endIdx) {
		for (int i = startIdx; i < endIdx; i++) {
			System.out.print(values[i] + " ");
		}
		System.out.println();
	}
	
	private static void modify(final int[] values) {
		Arrays.setAll(values, i -> i%2==0 ? -i : i*2);
	}
	

}
