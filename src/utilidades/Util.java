package utilidades;

public class Util {
	public static void limpiarPantalla() {
		for(int i = 0;i<10; i++) {
			System.out.println("");
		}
	}
	
	public void printLine(String mensaje) {
		System.out.println(mensaje);
	}
	
	public static void stopAndContinue() {
		timeToWait();
		
		
	}
	

	public static void timeToWait() {
		int timeWait = 10; 
		try {
			for(int i = 0; i <timeWait; i++) {
				Thread.sleep(150);
			}
		}catch (InterruptedException ie) {
			System.out.println("Tiempo de espera interrumpido");
		}
		
	}
}
