package co.uniquindio.centroImpresion.model;

import java.io.Serializable;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public abstract class Impresora implements ImpresoraInterfaz,Serializable {

	private ObjectProperty<Estado> estado;
	private StringProperty nombre;
	private String marca;
	private int resolucionHorizontal;
	private int resolucionVertical;
	
	/**
	 * Metodo constructor
	 */
	public Impresora() {
		
	}
	
	/**
	 * Metodo constructor
	 * @param estado Estado de la impresora
	 * @param nombre Nombre de la impresora
	 * @param marca Marca de la impresora
	 * @param resolucionHorizontal Resolucion horizontal de la impresora
	 * @param resolucionVertical Resolucion vertical de la impresora
	 */
	public Impresora(Estado estado, String nombre, String marca, int resolucionHorizontal,
			int resolucionVertical) {
		super();
		this.estado = new SimpleObjectProperty<>(estado);
		this.nombre = new SimpleStringProperty(nombre);
		this.marca = marca;
		this.resolucionHorizontal = resolucionHorizontal;
		this.resolucionVertical = resolucionVertical;
	}

	/**
	 * Metodo que obtenga el estado de la impresora organizada en una cadena
	 */
	@Override
	public String obtenerEstadoCadena() {
		String categoriaCadena="";
		switch(estado.get()) {
			case ACTIVA: categoriaCadena="Activa"; break;
			case INACTIVA: categoriaCadena="Inactiva"; break;
		}
		return categoriaCadena;
	}

	/**
	 * Metodo que obtiene el tipo de la impresora
	 */
	@Override
	public TipoImpresora obtenerTipoImpresora() {
		TipoImpresora tipo=null;
		if (this instanceof ImpresoraEtiquetas) {
			tipo=TipoImpresora.ETIQUETAS;
		}
		if (this instanceof ImpresoraInyeccionTinta) {
			tipo=TipoImpresora.INYECCION_TINTA;
		}
		if (this instanceof ImpresoraLaser) {
			tipo=TipoImpresora.LASER;
		}
		if (this instanceof ImpresoraMatrizPuntos) {
			tipo=TipoImpresora.MATRIZ_PUNTOS;
		}
		if (this instanceof ImpresoraSublimacionTinta) {
			tipo=TipoImpresora.SUBLIMACION_TINTA;
		}
		if (this instanceof ImpresoraTermica) {
			tipo=TipoImpresora.TERMICA;
		}
		return tipo;
	}
	
	/**
	 * Metodo que obtiene el tipo de la impresora organizada en forma de cadena
	 */
	public String obtenerTipoImpresoraCadena() {
		String tipoImpresoraCadena="";
		switch(obtenerTipoImpresora()) {
			case INYECCION_TINTA: tipoImpresoraCadena="Inyeccion de tinta"; break;
			case LASER: tipoImpresoraCadena="Laser"; break;
			case MATRIZ_PUNTOS: tipoImpresoraCadena="Matriz de puntos"; break;
			case TERMICA: tipoImpresoraCadena="Termica"; break;
			case SUBLIMACION_TINTA: tipoImpresoraCadena="Sublimacion de tinta"; break;
			case ETIQUETAS: tipoImpresoraCadena="Etiquetas"; break;
		}
		return tipoImpresoraCadena;
	}

	/**
	 * Metodo que indica si la impresoraa esta activa
	 * @return Respuesta de que si esta activa o no
	 */
	@Override
	public boolean estaActiva() {
		boolean estaActica=false;
		if (estado.get()==Estado.ACTIVA) {
			estaActica=true;
		}
		return estaActica;
	}
	
	/**
	 * Metodo que obtiene el estado como unObjectProperty
	 * @return Estado como unObjectProperty
	 */
	@Override
	public ObjectProperty<Estado> estadoProperty() {
		return estado;
	}

	/**
	 * Metodo que obtiene el estado de la impresora
	 * @return Estado de la impresora
	 */
	@Override
	public Estado getEstado() {
		return estado.get();
	}
	
	/**
	 * Metodo que obtiene el nombre como un StringProperty
	 * @return Nombre como un StringProperty
	 */
	@Override
	public StringProperty nombreProperty() {
		return nombre;
	}

	/**
	 * Metodo que obtiene el nombre de la impresora
	 * @return Nombre de la impresora
	 */
	@Override
	public String getNombre() {
		return nombre.get();
	}

	/**
	 * Metodo que obtiene la marca de la impresora
	 * @return Marca de la impresora
	 */
	@Override
	public String getMarca() {
		return marca;
	}

	/**
	 * Metodo que obtiene la resolucion horizontal de la impresora en pixeles por pulgada
	 * @return Resolucion horizontal de la impresora en pixeles por pulgada
	 */
	@Override
	public int getResolucionHorizontal() {
		return resolucionHorizontal;
	}

	/**
	 * Metodo que obtiene resolucion vertical de la impresora en pixeles por pulgada
	 * @return Resolucion vertical de la impresora en pixeles por pulgada
	 */
	@Override
	public int getResolucionVertical() {
		return resolucionVertical;
	}

	/**
	 * Metodo que cambia el estado de la impresora
	 * @return Estado de la impresora
	 */
	@Override
	public void setEstado(Estado estado) {
		this.estado.set(estado);
	}

	/**
	 * Metodo que cambia el nombre de la impresora
	 * @return Nuevo nombre de la impresora 
	 */
	@Override
	public void setNombre(String nombre) {
		this.nombre.set(nombre);
	}

	/**
	 * Metodo que cambia la marca de la impresora
	 * @return Nueva marca de la impresora
	 */
	@Override
	public void setMarca(String marca) {
		this.marca=marca;
	}

	/**
	 * Metodo que cambia la resolucion horizontal de la impresora en pixeles por pulgada
	 * @return Nueva resolucion horizontal de la impresora en pixeles por pulgada
	 */
	@Override
	public void setResolucionHorizontal(int resolucionHorizontal) {
		this.resolucionHorizontal=resolucionHorizontal;
	}

	/**
	 * Metodo que cambia la resolucion vertical de la impresora en pixeles por pulgada
	 * @return Nueva resolucion vertical de la impresora en pixeles por pulgada
	 */
	@Override
	public void setResolucionVertical(int resolucionVertical) {
		this.resolucionVertical=resolucionVertical;
	}

}
