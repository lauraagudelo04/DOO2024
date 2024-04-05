package dominio;

import excepcion.FraccionNullException;
import excepcion.AmplificadorCeroException;
import excepcion.AmplificadorUnoException;

public class Calculadora {

	private Calculadora() {
        super();
    }

    private static long calcularMaximoComunDivisor(long numerador, long denominador) {
        if (denominador == 0) {
            return numerador;
        }
        return (calcularMaximoComunDivisor(denominador, numerador % denominador));
    }

    private static void notificarNulo(Fraccion fraccionUno, Fraccion fraccionDos) {
        if (fraccionUno == null || fraccionDos==null) {
            throw new FraccionNullException();
        }
    }

    private static void notificarNulo(FraccionMixta fraccionMixtaUno, FraccionMixta fraccionMixtaDos) {
        if (fraccionMixtaUno == null || fraccionMixtaDos == null) {
            throw new FraccionNullException();
        }
    }

    public static boolean isPropia(Fraccion fraccion) {
        if (fraccion==null) {
            throw new FraccionNullException();
        }
        return (fraccion.getNumerador() < fraccion.getDenominador());
    }

    public static Fraccion simplificar(Fraccion fraccion) {
        long maximoComunDivisor = calcularMaximoComunDivisor(fraccion.getNumerador(), fraccion.getDenominador());
        return Fraccion.crear(fraccion.getNumerador() / maximoComunDivisor, fraccion.getDenominador() / maximoComunDivisor);
    }

    public static Fraccion sumar(Fraccion fraccionUno, Fraccion fraccionDos) {
        notificarNulo(fraccionUno, fraccionDos);
        long resultadoNumerador = (fraccionUno.getDenominador() * fraccionDos.getNumerador())
                + (fraccionUno.getNumerador() * fraccionDos.getDenominador());
        long resultadoDenominador = (fraccionUno.getDenominador() * fraccionDos.getDenominador());
        return simplificar(Fraccion.crear(resultadoNumerador, resultadoDenominador));
    }

    public static Fraccion restar(Fraccion fraccionUno, Fraccion fraccionDos) {
        notificarNulo(fraccionUno, fraccionDos);
        Fraccion fraccionDosNegativa = Fraccion.crear(-fraccionDos.getNumerador(), fraccionDos.getDenominador());
        return sumar(fraccionUno,fraccionDosNegativa);
    }

    public static Fraccion multiplicar(Fraccion fraccionUno, Fraccion fraccionDos) {
        notificarNulo(fraccionUno, fraccionDos);
        long resultadoNumerador = (fraccionUno.getNumerador() * fraccionDos.getNumerador());
        long resultadoDenominador = (fraccionUno.getDenominador() * fraccionDos.getDenominador());
        return simplificar(Fraccion.crear(resultadoNumerador, resultadoDenominador));
    }

    public static Fraccion dividir(Fraccion fraccionUno, Fraccion fraccionDos) {
        notificarNulo(fraccionUno, fraccionDos);
        Fraccion fraccionDosInversa = Fraccion.crear(fraccionDos.getDenominador(),fraccionDos.getNumerador());
        return multiplicar(fraccionUno, fraccionDosInversa);
    }

    public static Fraccion amplificar(long numeroAmplificador, Fraccion fracccion) {
        if (fracccion == null) {
            throw new FraccionNullException();
        }
        if (numeroAmplificador == 0) {
            throw new AmplificadorCeroException();
        }
        if (numeroAmplificador==1) {
            throw new AmplificadorUnoException();
        }
        long resultadoNumerador = fracccion.getNumerador() * numeroAmplificador;
        long resultadoDenominador = fracccion.getDenominador() * numeroAmplificador;
        return Fraccion.crear(resultadoNumerador, resultadoDenominador);
    }

    public static Fraccion convertirMixtoAFraccion(FraccionMixta fraccionMixta) {
        if (fraccionMixta == null) {
            throw new FraccionNullException();
        }
        long resultadoNumerador = (fraccionMixta.getParteEntera() * fraccionMixta.getDenominador())
                + fraccionMixta.getNumerador();
        long resultadoDenominador = fraccionMixta.getDenominador();
        return Fraccion.crear(resultadoNumerador, resultadoDenominador);
    }

    public static FraccionMixta convertirFraccionAMixto(Fraccion fraccion) {
        if (fraccion == null) {
            throw new FraccionNullException();
        }
        long parteEntera = fraccion.getNumerador() / fraccion.getDenominador();
        long nuevoNumerador = fraccion.getNumerador() % fraccion.getDenominador();

        return FraccionMixta.crear(parteEntera, nuevoNumerador, fraccion.getDenominador());
    }

    public static FraccionMixta sumar(FraccionMixta mixtoUno, FraccionMixta mixtoDos) {
        notificarNulo(mixtoUno, mixtoDos);
        Fraccion fraccionUno = convertirMixtoAFraccion(mixtoUno);
        Fraccion fraccionDos = convertirMixtoAFraccion(mixtoDos);
        Fraccion resultado = sumar(fraccionUno, fraccionDos);
        return convertirFraccionAMixto(resultado);
    }

    public static FraccionMixta restar(FraccionMixta mixtoUno, FraccionMixta mixtoDos) {
        notificarNulo(mixtoUno, mixtoDos);
        Fraccion fraccionUno = convertirMixtoAFraccion(mixtoUno);
        Fraccion fraccionDos = convertirMixtoAFraccion(mixtoDos);
        Fraccion resultado = restar(fraccionUno, fraccionDos);
        return convertirFraccionAMixto(resultado);
    }

    public static FraccionMixta multiplicar(FraccionMixta mixtoUno, FraccionMixta mixtoDos) {
        notificarNulo(mixtoUno, mixtoDos);
        Fraccion fraccionUno = convertirMixtoAFraccion(mixtoUno);
        Fraccion fraccionDos = convertirMixtoAFraccion(mixtoDos);
        Fraccion resultado = multiplicar(fraccionUno, fraccionDos);
        return convertirFraccionAMixto(resultado);
    }

    public static FraccionMixta dividir(FraccionMixta mixtoUno, FraccionMixta mixtoDos) {
        notificarNulo(mixtoUno, mixtoDos);
        Fraccion fraccionUno = convertirMixtoAFraccion(mixtoUno);
        Fraccion fraccionDos = convertirMixtoAFraccion(mixtoDos);
        Fraccion resultado = dividir(fraccionUno, fraccionDos);
        return convertirFraccionAMixto(resultado);
    }

    public static FraccionMixta amplificar(long numeroAmplificador, FraccionMixta fraccionMixta) {
        if ( fraccionMixta== null) {
            throw new FraccionNullException();
        }
        if (numeroAmplificador == 0) {
            throw new AmplificadorCeroException();
        }
        if (numeroAmplificador==1) {
            throw new AmplificadorUnoException();
        }
        Fraccion fraccionUno = convertirMixtoAFraccion(fraccionMixta);
        Fraccion resultado = amplificar(numeroAmplificador, fraccionUno);
        return convertirFraccionAMixto(resultado);
    }

    public static FraccionMixta simplificar(FraccionMixta mixtoUno) {

        Fraccion fraccionUno = convertirMixtoAFraccion(mixtoUno);
        Fraccion resultado = simplificar(fraccionUno);
        return convertirFraccionAMixto(resultado);
    }
}
