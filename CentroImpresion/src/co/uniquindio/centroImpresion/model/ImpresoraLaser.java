package co.uniquindio.centroImpresion.model;

public class ImpresoraLaser extends Impresora {
	
	private String tecnologiaImpresion;
	
	/**
	 * Metodo constructor
	 */
	public ImpresoraLaser() {
		
	}
	
	
	/**
	 * Metodo constructor
	 * @param estado Estado de la impresora
	 * @param nombre Nombre de la impresora
	 * @param marca Marca de la impresora
	 * @param resolucionHorizontal Resolucion horizontal en pixeles por pulgada de la impresora
	 * @param resolucionVertical Resolucion vertical en pixeles por pulgada de la impresora
	 * @param tecnologiaImpresion Tecnologia de impresion de la immpresora laser
	 */
	public ImpresoraLaser(Estado estado, String nombre, String marca, int resolucionHorizontal, int resolucionVertical,
			String tecnologiaImpresion) {
		super(estado, nombre, marca, resolucionHorizontal, resolucionVertical);
		this.tecnologiaImpresion = tecnologiaImpresion;
	}

	/**
	 * Metodo que obtiene la tecnologia de impresion de la impresora laser
	 * @return Tecnologia de impresion de la impresora laser
	 */
	public String getTecnologiaImpresion() {
		return tecnologiaImpresion;
	}

	/**
	 * Metodo que cambia la tecnologia de impresion de la impresora laser
	 * @param tecnologiaImpresion Nueva tecnologia de impresion de la impresora laser
	 */
	public void setTecnologiaImpresion(String tecnologiaImpresion) {
		this.tecnologiaImpresion = tecnologiaImpresion;
	}

}
