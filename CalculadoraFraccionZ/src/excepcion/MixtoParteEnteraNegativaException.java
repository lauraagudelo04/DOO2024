package excepcion;

public class MixtoParteEnteraNegativaException extends RuntimeException {
	public MixtoParteEnteraNegativaException() {
		super("No es posible crear un numero mixto con la parte entera negativa");
	}
}
