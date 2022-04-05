package aufgaben_Lambdas_2;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Aufgabe_5_loes {

	public static void main(String[] args) {

		System.out.println(replaceAll_Internal());

	}
	
	private static List<String> replaceAll_Internal() {
		final List<String> names = createNamesList();
		names.replaceAll( s -> s.startsWith("M")
				               ? ">>" + s.toUpperCase() + "<<"
				               : s);
				
		return names;
	}
	
	private static List<String> replaceAll_External_Iteration() {
		final List<String> names = createNamesList();
		final ListIterator<String> it = names.listIterator();
		while (it.hasNext()) {
			final String currentName = it.next();
			if (currentName.startsWith("M")) {
				// set()-Methode aus ListIterator
				it.set(">>" + currentName.toUpperCase() + "<<");
			}
		}
		return names;
	}

	private static List<String> createNamesList() {
		final List<String> names = new ArrayList<>();
		names.add("Michael");
		names.add("Tim");
		names.add("Flo");
		names.add("Merten");
		return names;
	}

}
