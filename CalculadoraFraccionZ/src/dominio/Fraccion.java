package dominio;

import excepcion.FraccionInexistenteException;

public class Fraccion {
	
	private long numerador;
    private long denominador;

    protected Fraccion(long numerador, long denominador) {
        setNumerador(numerador);
        setDenominador(denominador);
    }

    public static Fraccion crear (long numerador, long denominador){
        return new Fraccion(numerador, denominador);
    }

    public boolean isPropiaImpropia(Fraccion fraccion){
        if (fraccion.getNumerador() < fraccion.getDenominador()){
            System.out.println("Es propia");
            return true;
        }
        else if(fraccion.getNumerador() > fraccion.getDenominador()){
            System.out.println("Es impropia");
            return false;
        }
        return false;
    }

    public long getNumerador() {
        return numerador;
    }

    public long getDenominador() {
        return denominador;
    }

    private void setNumerador(long numerador) {
        this.numerador = numerador;
    }

    private void setDenominador(long denominador) {
        this.denominador = denominador;

        if (denominador==0){
            throw new FraccionInexistenteException();
        }
    }

    @Override
    public String toString(){
        return getNumerador() + "/" + getDenominador();
    }
}
