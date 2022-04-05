/* Umstellung des Codes auf Lambdas.
 * Kann die InterruptedException weitergereicht, sprich geworfen, werden?
 *
 * Zusatzaufgabe (anspruchsvoll):
 * kann mit den neuen Sprachmitteln ein generelles Exception-Wrapping von Checked auf Unchecked realisiert werden?
 * Tip: Funktionales Interface für das Wrapping mit statischer Utility-Methode zur Ausführung
 */



package aufgaben_Lambdas_3_1;

public class ThreadWithException_Zusatzloes {

	public static void main(String[] args) {
		Runnable r = () -> {
			for (int i = 0; i < 5; i++) {
				Executable.execute(() -> Thread.sleep(1000));
				System.out.print(i + " ");
				}				
			 };
			
			
		Thread t = new Thread(r);
		t.start();
		Executable.execute(() -> t.join());
	}
}

@FunctionalInterface
interface Executable<E extends Exception>{
	
	public abstract void wrap() throws Exception;
	
	static void execute(Executable<Exception> executable) {
		try {
			executable.wrap();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}


