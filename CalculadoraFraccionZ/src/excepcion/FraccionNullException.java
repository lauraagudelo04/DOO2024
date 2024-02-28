package excepcion;

public class FraccionNullException extends RuntimeException {
	public FraccionNullException(int numero) {
		super("La fraccion " + numero + " no puede estar vacia");
	}
}
