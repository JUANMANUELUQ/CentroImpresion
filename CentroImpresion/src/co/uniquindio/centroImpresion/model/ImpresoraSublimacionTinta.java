package co.uniquindio.centroImpresion.model;

public class ImpresoraSublimacionTinta extends Impresora {
	
	private double temperaturaImpresion;
	
	/**
	 * Metodo constructor
	 */
	public ImpresoraSublimacionTinta() {
		
	}
	
	/**
	 * Metodo constructor
	 * @param estado Estado de la impresora
	 * @param nombre Nombre de la impresora
	 * @param marca Marca de la impresora
	 * @param resolucionHorizontal Resolucion horizontal en pixeles por pulgada de la impresora
	 * @param resolucionVertical Resolucion vertical en pixeles por pulgada de la impresora
	 * @param temperaturaImpresion Temperatura a la que la impresora debe calentar la tinta para que se sublimine correctamente para la impresion
	 */
	public ImpresoraSublimacionTinta(Estado estado, String nombre, String marca, int resolucionHorizontal,
			int resolucionVertical, double temperaturaImpresion) {
		super(estado, nombre, marca, resolucionHorizontal, resolucionVertical);
		this.temperaturaImpresion = temperaturaImpresion;
	}

	/**
	 * Metodo que obtiene la temperatura a la que la impresora debe calentar la tinta para que se sublimine correctamente para la impresion
	 * @return Temperatura a la que la impresora debe calentar la tinta para que se sublimine correctamente para la impresion
	 */
	public double getTemperaturaImpresion() {
		return temperaturaImpresion;
	}

	/**
	 * Metodo que cambia la temperatura a la que la impresora debe calentar la tinta para que se sublimine correctamente para la impresion
	 * @param temperaturaImpresion Nueva temperatura a la que la impresora debe calentar la tinta para que se sublimine correctamente para la impresion
	 */
	public void setTemperaturaImpresion(double temperaturaImpresion) {
		this.temperaturaImpresion = temperaturaImpresion;
	}

}
