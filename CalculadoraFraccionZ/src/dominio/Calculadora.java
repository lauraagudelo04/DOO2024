package dominio;

import excepcion.FraccionNullException;
import excepcion.NoAmplificaException;

public class Calculadora {
	
	 private Calculadora(){
	        super();
	    }

	    private static long calcularMaximoComunDivisor(long a, long b){
	        if (b==0){
	            return a;
	        }
	        return (calcularMaximoComunDivisor(b, a%b));
	    }
	    
	    /*private static void notificarNulos (Fraccion fraccion1, Fraccion fraccion2){
	    	 if (fraccion1 == null){
	             
	         }
	         if (fraccion2 == null){
	            
	         }
	    }*/
	    
	    public static Fraccion simplificar(Fraccion fraccion){
	        long comunDivisor = calcularMaximoComunDivisor(fraccion.getNumerador(), fraccion.getDenominador());
	        return Fraccion.crear(fraccion.getNumerador()/comunDivisor,
	                fraccion.getDenominador()/comunDivisor);
	    }

	    public static Fraccion sumar(Fraccion fraccion1, Fraccion fraccion2){
	        //notificarNulos(fraccion1, fraccion2);
	        long resultadoNumerador = (fraccion1.getDenominador()* fraccion2.getNumerador())
	                + (fraccion1.getNumerador()* fraccion2.getDenominador());
	        long resultadoDenominador = (fraccion1.getDenominador()* fraccion2.getDenominador());

	        return simplificar(Fraccion.crear(resultadoNumerador,resultadoDenominador));
	    }

	    public static Fraccion restar(Fraccion fraccion1, Fraccion fraccion2){
	        //notificarNulos(fraccion1, fraccion2);
	        long resultadoNumerador = (fraccion1.getDenominador()* fraccion2.getNumerador())
	                - (fraccion1.getNumerador()* fraccion2.getDenominador());
	        long resultadoDenominador = (fraccion1.getDenominador()* fraccion2.getDenominador());

	        return simplificar(Fraccion.crear(resultadoNumerador,resultadoDenominador));
	    }

	    public static Fraccion multiplicar(Fraccion fraccion1, Fraccion fraccion2){
	       // notificarNulos(fraccion1, fraccion2);
	        long resultadoNumerador = (fraccion1.getNumerador()* fraccion2.getNumerador());
	        long resultadoDenominador = (fraccion1.getDenominador()* fraccion2.getDenominador());

	        return simplificar(Fraccion.crear(resultadoNumerador, resultadoDenominador));
	    }

	    public static Fraccion dividir(Fraccion fraccion1, Fraccion fraccion2){
	        //notificarNulos(fraccion1, fraccion2);
	        long resultadoNumerador = (fraccion1.getNumerador()* fraccion2.getDenominador());
	        long resultadoDenominador = (fraccion1.getDenominador()* fraccion2.getNumerador());

	        return simplificar(Fraccion.crear(resultadoNumerador, resultadoDenominador));
	    }

	    public static Fraccion amplificar(long numeroAmplificador, Fraccion fracccion){
	    	 if (fracccion == null){
	             throw new FraccionNullException();
	         }
	    	 if (numeroAmplificador == 0){
	            throw new NoAmplificaException();
	         }
	    	 long resultadoNumerador = fracccion.getNumerador()* numeroAmplificador;
	         long resultadoDenominador = fracccion.getDenominador()* numeroAmplificador;
	         return Fraccion.crear(resultadoNumerador, resultadoDenominador);
	    }
	    
	    public static Fraccion convertirMixto(FraccionMixta fraccionMixto){
	        if (fraccionMixto == null){
	            throw new FraccionNullException();
	        }
	        long resultadoNumerador = (fraccionMixto.getParteEntera()*fraccionMixto.getDenominador())
	                +  fraccionMixto.getNumerador();
	        long resultadoDenominador = fraccionMixto.getDenominador();
	        return Fraccion.crear(resultadoNumerador, resultadoDenominador);
	    }

	    public static FraccionMixta convertirFraccion (Fraccion fraccion){
	        if (fraccion == null){
	            throw new FraccionNullException();
	        }
	        if (fraccion.isPropiaImpropia(fraccion)){
	            return FraccionMixta.crear(0,fraccion.getNumerador(), fraccion.getDenominador());
	        }
	        long parteEntera = fraccion.getNumerador()/ fraccion.getDenominador();
	        long nuevoNumerador = fraccion.getNumerador() % fraccion.getDenominador();

	        return FraccionMixta.crear(parteEntera, nuevoNumerador, fraccion.getDenominador());
	    }

	    public static FraccionMixta sumar (FraccionMixta mixto1, FraccionMixta mixto2){
	        Fraccion fraccion1 = convertirMixto(mixto1);
	        Fraccion fraccion2 = convertirMixto(mixto2);
	        Fraccion resultado = sumar(fraccion1, fraccion2);
	        return convertirFraccion(resultado);
	    }

	    public static FraccionMixta restar(FraccionMixta mixto1, FraccionMixta mixto2){
	        Fraccion fraccion1 = convertirMixto(mixto1);
	        Fraccion fraccion2 = convertirMixto(mixto2);
	        Fraccion resultado = restar(fraccion1, fraccion2);
	        return convertirFraccion(resultado);
	    }

	    public static FraccionMixta multiplicar (FraccionMixta mixto1, FraccionMixta mixto2){
	        Fraccion fraccion1 = convertirMixto(mixto1);
	        Fraccion fraccion2 = convertirMixto(mixto2);
	        Fraccion resultado = multiplicar(fraccion1, fraccion2);
	        return convertirFraccion(resultado);
	    }

	    public static FraccionMixta dividir(FraccionMixta mixto1, FraccionMixta mixto2){
	        Fraccion fraccion1 = convertirMixto(mixto1);
	        Fraccion fraccion2 = convertirMixto(mixto2);
	        Fraccion resultado = dividir(fraccion1, fraccion2);
	        return convertirFraccion(resultado);
	    }

	    public static FraccionMixta amplificar(long numeroAmplificador, FraccionMixta mixto1){
	        Fraccion fraccion1 = convertirMixto(mixto1);
	        Fraccion resultado = amplificar(numeroAmplificador, fraccion1);
	        return convertirFraccion(resultado);
	    }

	    public static FraccionMixta simplificar(FraccionMixta mixto1){
	        Fraccion fraccion1 = convertirMixto(mixto1);
	        Fraccion resultado = simplificar(fraccion1);
	        return convertirFraccion(resultado);
	    }    	  
}
