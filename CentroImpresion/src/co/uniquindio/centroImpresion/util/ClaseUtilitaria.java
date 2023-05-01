package co.uniquindio.centroImpresion.util;

import co.uniquindio.centroImpresion.model.*;

public class ClaseUtilitaria {
	
	/**
	 * Metodo que organiza la resolucion de una impresora
	 * @param impresora Impresora de la cual se desea obtener su resolucion organizada
	 * @return Resolucion organizada
	 */
	public static String organizarResolucion(ImpresoraInterfaz impresora) {
		String resolucion;
		resolucion=""+impresora.getResolucionHorizontal()+"x"+impresora.getResolucionVertical();
		return resolucion;
	}
	
	/**
	 * Metodo que obtiene el estado de la impresora apartir de una cadena
	 * @param estado Estado en forma de cadena
	 * @return Estado en forma de la clase EStado
	 */
	public static Estado obtenerEstadoImpresora(String estado) {
		Estado estadoImpresora=null;
		switch(estado) {
			case "Activo": estadoImpresora=Estado.ACTIVA; break;
			case "Inactivo": estadoImpresora=Estado.INACTIVA; break;
		}
		return estadoImpresora;
	}
	
	/**
	 * Metodo que obtiene el estado de la impresora en forma de cadena
	 * @param impresora Impresora d ela cual se desea obtener su estado
	 * @return Estado de la impresora en forma de cadena
	 */
	public static String obtenerEstadoImpresora(ImpresoraInterfaz impresora) {
		String estadoImpresora="";
		if (impresora.getEstado()==null) {
			return "";
		}
		switch(impresora.getEstado()) {
			case ACTIVA: estadoImpresora="Activo"; break;
			case INACTIVA: estadoImpresora="Inactivo"; break;
		}
		return estadoImpresora;
	}
	
	/**
	 * Metodo que  obtiene el tipo de la impresora a partir de una cadena
	 * @param tipo Tipo de la impresora en forma de cadena
	 * @return Tipo d ela impresora en forma de la clase TipoImpresora
	 */
	public static TipoImpresora obtenerTipoImpresora(String tipo) {
		TipoImpresora tipoImpresora=null;
		switch(tipo) {
			case "Inyeccion de tinta": tipoImpresora=TipoImpresora.INYECCION_TINTA; break;
			case "Laser": tipoImpresora=TipoImpresora.LASER; break;
			case "Matriz de puntos": tipoImpresora=TipoImpresora.MATRIZ_PUNTOS; break;
			case "Termica": tipoImpresora=TipoImpresora.TERMICA; break;
			case "Sublimacion de tinta": tipoImpresora=TipoImpresora.SUBLIMACION_TINTA; break;
			case "Etiquetas": tipoImpresora=TipoImpresora.ETIQUETAS; 
		}
		return tipoImpresora;
	}

}
