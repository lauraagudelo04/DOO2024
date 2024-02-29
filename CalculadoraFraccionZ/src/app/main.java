package app;

import dominio.Calculadora;
import dominio.Fraccion;
import dominio.FraccionMixta;

public class main {
	public static void main(String[] args) {
		Fraccion fraccionUno = Fraccion.crear(1, 2);
		Fraccion fraccionDos = Fraccion.crear(5, 2);
		Fraccion fraccionTres=null;
		FraccionMixta fraccionMixtaUno = FraccionMixta.crear(5, 2, 7);
		FraccionMixta fraccionMixtaDos = FraccionMixta.crear(3, 2, 3);
		

		/*System.out.println(Calculadora.sumar(fraccionUno, fraccionDos) + "\n");
		System.out.println(Calculadora.restar(fraccionUno, fraccionDos) + "\n");
		System.out.println(Calculadora.multiplicar(fraccionUno, fraccionDos) + "\n");
		System.out.println(Calculadora.dividir(fraccionUno, fraccionDos) + "\n");
		System.out.println(Calculadora.amplificar(2, fraccionDos) + "\n");
		System.out.println(Calculadora.convertirFraccionAMixto(fraccionUno) + "\n");
		System.out.println(Calculadora.convertirMixtoAFraccion(fraccionMixtaUno) + "\n");
		System.out.println(Calculadora.simplificar(fraccionUno) + "\n");
		System.out.println(Calculadora.sumar(fraccionMixtaUno, fraccionMixtaDos) + "\n");
		System.out.println(Calculadora.restar(fraccionMixtaUno, fraccionMixtaDos) + "\n");
		System.out.println(Calculadora.multiplicar(fraccionMixtaUno, fraccionMixtaDos) + "\n");
		System.out.println(Calculadora.dividir(fraccionMixtaUno, fraccionMixtaDos) + "\n");
		System.out.println(Calculadora.amplificar(2, fraccionMixtaUno) + "\n");
		System.out.println(Calculadora.simplificar(fraccionMixtaDos) + "\n");
*/ 
		//System.out.println(Calculadora.isPropia(fraccionUno));
		//System.out.println(Calculadora.dividir(fraccionUno, fraccionDos));
		System.out.println(Calculadora.sumar(fraccionUno, fraccionTres));
	}
}





