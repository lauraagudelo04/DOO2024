package excepcion;

public class NoAmplificaException extends RuntimeException{
	 public NoAmplificaException (){
	        super("No es posible amplificar por este numero");
	    }
}
