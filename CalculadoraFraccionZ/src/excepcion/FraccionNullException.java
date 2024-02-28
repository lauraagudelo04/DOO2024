package excepcion;

public class FraccionNullException extends RuntimeException {
	 public FraccionNullException (){
	        super("La fraccion no puede estar vacia");
	    }
}
