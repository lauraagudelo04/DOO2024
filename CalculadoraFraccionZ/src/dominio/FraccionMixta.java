package dominio;

import excepcion.MixtoParteEnteraNegativaException;

public class FraccionMixta extends Fraccion {
	private long parteEntera;

	protected FraccionMixta(long parteEntera, long numerador, long denominador) {
		super(numerador, denominador);
		setParteEntera(parteEntera);
	}

	public static FraccionMixta crear(long parteEntera, long numerador, long denominador) {
		return new FraccionMixta(parteEntera, numerador, denominador);
	}

	public long getParteEntera() {
		return parteEntera;
	}

	private void setParteEntera(long parteEntera) {
		this.parteEntera = parteEntera;

		if (parteEntera < 0) {
			throw new MixtoParteEnteraNegativaException();
		}
	}

	@Override
	public String toString() {
		return "(" + getParteEntera() + ")" + super.toString();
	}

}
