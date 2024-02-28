package excepcion;

public class ParteEnteraException extends RuntimeException {
	public ParteEnteraException() {
		super("No es posible crear un numero mixto con la parte entera negativa");
	}
}
