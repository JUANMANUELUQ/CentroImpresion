package co.uniquindio.centroImpresion.model;

public class ImpresoraTermica extends Impresora {
	
	private int durabilidadCabezaTermica;
	
	/**
	 * Metodo constructor
	 */
	public ImpresoraTermica() {
		
	}
	
	/**
	 * Metodo constructor
	 * @param estado Estado de la impresora
	 * @param nombre Nombre de la impresora
	 * @param marca Marca de la impresora
	 * @param resolucionHorizontal Resolucion horizontal en pixeles por pulgada de la impresora
	 * @param resolucionVertical Resolucion vertical en pixeles por pulgada de la impresora
	 * @param durabilidadCabezaTermica
	 */
	public ImpresoraTermica(Estado estado, String nombre, String marca, int resolucionHorizontal,
			int resolucionVertical, int durabilidadCabezaTermica) {
		super(estado, nombre, marca, resolucionHorizontal, resolucionVertical);
		this.durabilidadCabezaTermica = durabilidadCabezaTermica;
	}

	/**
	 * Metodo que obtiene el numero maximo de impresiones que la cabeza termica de la impresora puede realizar antes de requerir mantenimiento o reemplazo
	 * @return Numero maximo de impresiones que la cabeza termica de la impresora puede realizar antes de requerir mantenimiento o reemplazo
	 */
	public int getDurabilidadCabezaTermica() {
		return durabilidadCabezaTermica;
	}

	/**
	 * Metodo que cambia el numero maximo de impresiones que la cabeza termica de la impresora puede realizar antes de requerir mantenimiento o reemplazo
	 * @param durabilidadCabezaTermica Nuevo numero maximo de impresiones que la cabeza termica de la impresora puede realizar antes de requerir mantenimiento o reemplazo
	 */
	public void setDurabilidadCabezaTermica(int durabilidadCabezaTermica) {
		this.durabilidadCabezaTermica = durabilidadCabezaTermica;
	}

}
