/* Umstellung des Codes auf Lambdas.
 * Kann die InterruptedException weitergereicht, sprich geworfen, werden?
 */



package aufgaben_Lambdas_3_1;

public class ThreadWithException_loes {

	public static void main(String[] args) {
		Runnable r = () -> {
			for (int i = 0; i < 5; i++) {
				try {
					Thread.sleep(1000);
					System.out.print(i + " ");
				}
				catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			} };
			
			
		Thread t = new Thread(r);
		t.start();
		try {
			t.join();
		}
		catch (InterruptedException e) {
		}
	}
}


