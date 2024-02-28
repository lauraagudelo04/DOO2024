package excepcion;

public class FraccionInexistenteException extends RuntimeException {
	public FraccionInexistenteException() {
		super("La fraccion no existe, su denominador no puede ser 0");
	}
}
