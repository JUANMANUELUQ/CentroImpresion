package co.uniquindio.centroImpresion.model;

import java.io.Serializable;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CentroImpresion implements Serializable {
	
	private ObservableList<ImpresoraInterfaz> listaImpresoras = FXCollections.observableArrayList();
	
	/**
	 * Metodo que agrega una impresora al centro de impresion
	 * @param impresora Impresora a agregar
	 */
	public void agregarImpresora(ImpresoraInterfaz impresora) {
		listaImpresoras.add(impresora);
	}
	
	/**
	 * Metodo que elimina una impresora del centro de impresion
	 * @param impresora Impresora a eliminar
	 */
	public void eliminarImpresora(ImpresoraInterfaz impresora) {
		listaImpresoras.remove(impresora);
	}
	
	/**
	 * Metodo que obtiene la lista de impresoras del centro de impresion
	 * @return Lista de impresoras
	 */
	public ObservableList<ImpresoraInterfaz> getListaImpresoras() {
		return listaImpresoras;
	}

	/**
	 * Metodo que reemplaza una impresora del centro de impresion
	 * @param impresoraAntigua Impresora que se va a reemplazar
	 * @param nuevaImpresora Impresora nueva que va a reemplazar a la anterior
	 */
	public void remplazarImpresora(ImpresoraInterfaz impresoraAntigua, ImpresoraInterfaz nuevaImpresora) {
		int posicion=listaImpresoras.indexOf(impresoraAntigua);
		listaImpresoras.set(posicion, nuevaImpresora);
	}
	
}
