package excepcion;

public class AmplificadorUnoException extends RuntimeException {
	public AmplificadorUnoException() {
		super("No es posible amplificar por uno");
	}
}
