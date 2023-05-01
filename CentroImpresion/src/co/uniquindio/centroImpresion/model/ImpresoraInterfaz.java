package co.uniquindio.centroImpresion.model;

import java.io.Serializable;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;

public interface ImpresoraInterfaz {
	
	public String obtenerEstadoCadena();
	
	public TipoImpresora obtenerTipoImpresora();
	
	public String obtenerTipoImpresoraCadena();
	
	public boolean estaActiva();
	
	public ObjectProperty<Estado> estadoProperty();
	
	public Estado getEstado();
	
	public StringProperty nombreProperty();
	
	public String getNombre();
	
	public String getMarca();
	
	public int getResolucionHorizontal();
	
	public int getResolucionVertical();
	
	public void setEstado(Estado estado);
	
	public void setNombre(String nombre);
	
	public void setMarca(String nombre);
	
	public void setResolucionHorizontal(int resolucionHorizontal);
	
	public void setResolucionVertical(int resolucionVertical);

}
