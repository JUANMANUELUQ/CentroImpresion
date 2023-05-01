package co.uniquindio.centroImpresion.model;

public class ImpresoraMatrizPuntos extends Impresora {
	
	private int numeroAgujas;
	
	/**
	 * Metodo constructor
	 */
	public ImpresoraMatrizPuntos() {
		
	}
	
	/**
	 * Metodo constructor
	 * @param estado Estado de la impresora
	 * @param nombre Nombre de la impresora
	 * @param marca Marca de la impresora
	 * @param resolucionHorizontal Resolucion horizontal en pixeles por pulgada de la impresora
	 * @param resolucionVertical Resolucion vertical en pixeles por pulgada de la impresora
	 * @param numeroAgujas Numero de agujas de la impresora
	 */
	public ImpresoraMatrizPuntos(Estado estado, String nombre, String marca, int resolucionHorizontal,
			int resolucionVertical, int numeroAgujas) {
		super(estado, nombre, marca, resolucionHorizontal, resolucionVertical);
		this.numeroAgujas = numeroAgujas;
	}

	/**
	 * Metodo que obtiene el numero de agujas de la impresora
	 * @return Nuevo numero de agujas de la impresora
	 */
	public int getNumeroAgujas() {
		return numeroAgujas;
	}

	/**
	 * Metodo que cambia el numero de agujas de la impresora
	 * @param numeroAgujas Nuevo numero de agujas de la impresora
	 */
	public void setNumeroAgujas(int numeroAgujas) {
		this.numeroAgujas = numeroAgujas;
	}

}
