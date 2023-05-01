package co.uniquindio.centroImpresion.model;

public class ImpresoraEtiquetas extends Impresora {
	
	private double longitudMaximaEtiquetas;
	
	/**
	 * Metodo constructor
	 */
	public ImpresoraEtiquetas() {
		
	}
	
	/**
	 * Metodo constructor
	 * @param estado Estado de la impresora
	 * @param nombre Nombre de la impresora
	 * @param marca Marca de la impresora
	 * @param resolucionHorizontal Resolucion horizontal en pixeles por pulgada de la impresora
	 * @param resolucionVertical Resolucion vertical en pixeles por pulgada de la impresora
	 * @param longitudMaximaEtiquetas Longitud maxima de las etiquetas en cm
	 */
	public ImpresoraEtiquetas(Estado estado, String nombre, String marca, int resolucionHorizontal,
			int resolucionVertical, double longitudMaximaEtiquetas) {
		super(estado, nombre, marca, resolucionHorizontal, resolucionVertical);
		this.longitudMaximaEtiquetas = longitudMaximaEtiquetas;
	}

	/**
	 * Metodo para obtener la longitud maxima de las etiquetas
	 * @return Longitud maxima de las etiquetas
	 */
	public double getLongitudMaximaEtiquetas() {
		return longitudMaximaEtiquetas;
	}

	/**
	 * Metodo que cambia la longitud maxima de las etiquetas
	 * @param longitudMaximaEtiquetas Nueva longitud maxima de las etiquetas
	 */
	public void setLongitudMaximaEtiquetas(double longitudMaximaEtiquetas) {
		this.longitudMaximaEtiquetas = longitudMaximaEtiquetas;
	}

}
