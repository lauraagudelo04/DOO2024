package dominio;

import excepcion.FraccionNullException;
import excepcion.NoAmplificaException;

public class Calculadora {

	private Calculadora() {
		super();
	}

	private static long calcularMaximoComunDivisor(long a, long b) {
		if (b == 0) {
			return a;
		}
		return (calcularMaximoComunDivisor(b, a % b));
	}

	private static void notificarNulos(Fraccion fraccionUno, Fraccion fraccionDos) {
		if (fraccionUno == null) {
			throw new FraccionNullException(1);
		}
		if (fraccionDos == null) {
			throw new FraccionNullException(2);
		}
	}

	public static Fraccion simplificar(Fraccion fraccion) {
		long comunDivisor = calcularMaximoComunDivisor(fraccion.getNumerador(), fraccion.getDenominador());
		return Fraccion.crear(fraccion.getNumerador() / comunDivisor, fraccion.getDenominador() / comunDivisor);
	}

	public static Fraccion sumar(Fraccion fraccionUno, Fraccion fraccionDos) {
		notificarNulos(fraccionUno, fraccionDos);
		long resultadoNumerador = (fraccionUno.getDenominador() * fraccionDos.getNumerador())
				+ (fraccionUno.getNumerador() * fraccionDos.getDenominador());
		long resultadoDenominador = (fraccionUno.getDenominador() * fraccionDos.getDenominador());

		return simplificar(Fraccion.crear(resultadoNumerador, resultadoDenominador));
	}

	public static Fraccion restar(Fraccion fraccionUno, Fraccion fraccionDos) {
		notificarNulos(fraccionUno, fraccionDos);
		long resultadoNumerador = (fraccionUno.getDenominador() * fraccionDos.getNumerador())
				- (fraccionUno.getNumerador() * fraccionDos.getDenominador());
		long resultadoDenominador = (fraccionUno.getDenominador() * fraccionDos.getDenominador());

		return simplificar(Fraccion.crear(resultadoNumerador, resultadoDenominador));
	}

	public static Fraccion multiplicar(Fraccion fraccionUno, Fraccion fraccionDos) {
		notificarNulos(fraccionUno, fraccionDos);
		long resultadoNumerador = (fraccionUno.getNumerador() * fraccionDos.getNumerador());
		long resultadoDenominador = (fraccionUno.getDenominador() * fraccionDos.getDenominador());

		return simplificar(Fraccion.crear(resultadoNumerador, resultadoDenominador));
	}

	public static Fraccion dividir(Fraccion fraccionUno, Fraccion fraccionDos) {
		notificarNulos(fraccionUno, fraccionDos);
		long resultadoNumerador = (fraccionUno.getNumerador() * fraccionDos.getDenominador());
		long resultadoDenominador = (fraccionUno.getDenominador() * fraccionDos.getNumerador());

		return simplificar(Fraccion.crear(resultadoNumerador, resultadoDenominador));
	}

	public static Fraccion amplificar(long numeroAmplificador, Fraccion fracccion) {
		if (fracccion == null) {
			throw new FraccionNullException(1);
		}
		if (numeroAmplificador == 0) {
			throw new NoAmplificaException();
		}
		long resultadoNumerador = fracccion.getNumerador() * numeroAmplificador;
		long resultadoDenominador = fracccion.getDenominador() * numeroAmplificador;
		return Fraccion.crear(resultadoNumerador, resultadoDenominador);
	}

	public static Fraccion convertirMixto(FraccionMixta fraccionMixto) {
		if (fraccionMixto == null) {
			throw new FraccionNullException(1);
		}
		long resultadoNumerador = (fraccionMixto.getParteEntera() * fraccionMixto.getDenominador())
				+ fraccionMixto.getNumerador();
		long resultadoDenominador = fraccionMixto.getDenominador();
		return Fraccion.crear(resultadoNumerador, resultadoDenominador);
	}

	public static FraccionMixta convertirFraccion(Fraccion fraccion) {
		if (fraccion == null) {
			throw new FraccionNullException(1);
		}
		if (fraccion.isPropiaImpropia(fraccion)) {
			return FraccionMixta.crear(0, fraccion.getNumerador(), fraccion.getDenominador());
		}
		long parteEntera = fraccion.getNumerador() / fraccion.getDenominador();
		long nuevoNumerador = fraccion.getNumerador() % fraccion.getDenominador();

		return FraccionMixta.crear(parteEntera, nuevoNumerador, fraccion.getDenominador());
	}

	public static FraccionMixta sumar(FraccionMixta mixto1, FraccionMixta mixto2) {
		Fraccion fraccionUno = convertirMixto(mixto1);
		Fraccion fraccion2 = convertirMixto(mixto2);
		Fraccion resultado = sumar(fraccionUno, fraccion2);
		return convertirFraccion(resultado);
	}

	public static FraccionMixta restar(FraccionMixta mixto1, FraccionMixta mixto2) {
		Fraccion fraccionUno = convertirMixto(mixto1);
		Fraccion fraccionDos = convertirMixto(mixto2);
		Fraccion resultado = restar(fraccionUno, fraccionDos);
		return convertirFraccion(resultado);
	}

	public static FraccionMixta multiplicar(FraccionMixta mixtoUno, FraccionMixta mixtoDos) {
		Fraccion fraccionUno = convertirMixto(mixtoUno);
		Fraccion fraccionDos = convertirMixto(mixtoDos);
		Fraccion resultado = multiplicar(fraccionUno, fraccionDos);
		return convertirFraccion(resultado);
	}

	public static FraccionMixta dividir(FraccionMixta mixtoUno, FraccionMixta mixtoDos) {
		Fraccion fraccionUno = convertirMixto(mixtoUno);
		Fraccion fraccionDos = convertirMixto(mixtoDos);
		Fraccion resultado = dividir(fraccionUno, fraccionDos);
		return convertirFraccion(resultado);
	}

	public static FraccionMixta amplificar(long numeroAmplificador, FraccionMixta mixtoUno) {
		Fraccion fraccionUno = convertirMixto(mixtoUno);
		Fraccion resultado = amplificar(numeroAmplificador, fraccionUno);
		return convertirFraccion(resultado);
	}

	public static FraccionMixta simplificar(FraccionMixta mixtoUno) {
		Fraccion fraccionUno = convertirMixto(mixtoUno);
		Fraccion resultado = simplificar(fraccionUno);
		return convertirFraccion(resultado);
	}
}
