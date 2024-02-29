package excepcion;

public class AmplificadorCeroException extends RuntimeException {
	public AmplificadorCeroException() {
		super("No es posible amplificar por cero");
	}
}
