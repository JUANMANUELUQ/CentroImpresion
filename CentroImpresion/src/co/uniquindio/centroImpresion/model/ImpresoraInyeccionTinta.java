package co.uniquindio.centroImpresion.model;

public class ImpresoraInyeccionTinta extends Impresora {

	private int numeroCartuchos;
	
	/**
	 * Metodo constructor
	 */
	public ImpresoraInyeccionTinta() {
		
	}
	
	/**
	 * Metodo constructor
	 * @param estado Estado de la impresora
	 * @param nombre Nombre de la impresora
	 * @param marca Marca de la impresora
	 * @param resolucionHorizontal Resolucion horizontal en pixeles por pulgada de la impresora
	 * @param resolucionVertical Resolucion vertical en pixeles por pulgada de la impresora
	 * @param numeroCartuchos Numero de cartuchos de tinta de la impresora
	 */
	public ImpresoraInyeccionTinta(Estado estado, String nombre, String marca, int resolucionHorizontal,
			int resolucionVertical, int numeroCartuchos) {
		super(estado, nombre, marca, resolucionHorizontal, resolucionVertical);
		this.numeroCartuchos = numeroCartuchos;
	}

	/**
	 * Metodo que obtiene el numero de cartuchos de tinta de la impresora
	 * @return Numero de cartuchos de tinta de la impresora
	 */
	public int getNumeroCartuchos() {
		return numeroCartuchos;
	}

	/**
	 * Metodo que cambia el numero de cartuchos de tinta de la impresora
	 * @param numeroCartuchos Nuevo numero de cartuchos de tinta de la impresora
	 */
	public void setNumeroCartuchos(int numeroCartuchos) {
		this.numeroCartuchos = numeroCartuchos;
	}
	
}
