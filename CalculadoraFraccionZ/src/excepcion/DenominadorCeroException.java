package excepcion;

public class DenominadorCeroException extends RuntimeException {
	public DenominadorCeroException() {
		super("La fraccion no existe, su denominador no puede ser 0");
	}
}
