package app;
import dominio.Calculadora;
import dominio.Fraccion;
import dominio.FraccionMixta;

public class main {
	 public static void main(String[] args) {
	        Fraccion fraccion1 = Fraccion.crear(8,2);
	        Fraccion fraccion2 = Fraccion.crear(5,2);
	        FraccionMixta fraccionMixta1 = FraccionMixta.crear(5,2,7);
	        FraccionMixta fraccionMixta2 = FraccionMixta.crear(3,2,3);
	        System.out.println(Calculadora.sumar(fraccion1, fraccion2) + "\n");
	        System.out.println(Calculadora.restar(fraccion1, fraccion2)+ "\n");
	        System.out.println(Calculadora.multiplicar(fraccion1, fraccion2)+ "\n");
	        System.out.println(Calculadora.dividir(fraccion1, fraccion2)+ "\n");
	        System.out.println(Calculadora.amplificar(2, fraccion2)+ "\n");
	        System.out.println(Calculadora.convertirFraccion(fraccion1)+ "\n");
	        System.out.println(Calculadora.convertirMixto(fraccionMixta1)+ "\n");
	        System.out.println(Calculadora.simplificar(fraccion1)+ "\n");
	        System.out.println(Calculadora.sumar(fraccionMixta1, fraccionMixta2) + "\n");
	        System.out.println(Calculadora.restar(fraccionMixta1, fraccionMixta2)+ "\n");
	        System.out.println(Calculadora.multiplicar(fraccionMixta1, fraccionMixta2)+ "\n");
	        System.out.println(Calculadora.dividir(fraccionMixta1, fraccionMixta2)+ "\n");
	        System.out.println(Calculadora.amplificar(2,fraccionMixta1)+ "\n");
	        System.out.println(Calculadora.simplificar(fraccionMixta2)+ "\n");

	    }
}
