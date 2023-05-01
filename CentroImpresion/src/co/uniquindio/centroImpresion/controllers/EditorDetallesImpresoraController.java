package co.uniquindio.centroImpresion.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.JOptionPane;

import co.uniquindio.centroImpresion.model.*;
import co.uniquindio.centroImpresion.util.ClaseUtilitaria;

public class EditorDetallesImpresoraController {
	
	@FXML
	private TextField nombre;
	@FXML
	private ComboBox estado;
	@FXML
	private TextField marca;
	@FXML
	private TextField resolucionHorizontal;
	@FXML
	private TextField resolucionVertical;
	@FXML
	private ComboBox tipoImpresora;
	@FXML
	private TextField longitudMaximaEtiquetas;
	@FXML
	private TextField numeroCartuchos;
	@FXML
	private TextField tecnologiaImpresion;
	@FXML
	private TextField numeroAgujas;
	@FXML
	private TextField temperaturaImpresion;
	@FXML
	private TextField durabilidadCabezaTermica;
	private Stage ventana;
	private CentroImpresion centroImpresion;
	private ImpresoraInterfaz impresoraGuardar;
	private boolean datosFueronGuardados;
	
	/**
	 * Metodo constructor
	 */
	public EditorDetallesImpresoraController() {
		
	}
	
	/**
	 * Metodo que determina si los cambios realizados en la impresora fue guardados
	 * @return Si los cambios en la impresora fueron guardados o no
	 */
	public boolean fueronDatosGuardados() {
		return datosFueronGuardados;
	}

	/**
	 * Metodo que obtiene la ventana de edicion de los detalles de la impresora
	 * @param dialogStage Direccion de la ventana de edicion
	 */
	public void setDialogStage(Stage dialogStage) {
		this.ventana = dialogStage;
	}
	
	/**
	 * Metodo que obtiene el centro de impresion
	 * @param centroImpresion Centro de impresion
	 */
	public void obtenerCentroImpresion(CentroImpresion centroImpresion) {
		this.centroImpresion=centroImpresion;
	}
	
	/**
	 * Metodo que pone el dato unico del respactivo tipo de la impresora
	 */
	public void ponerDatoUnico() {
		switch(impresoraGuardar.obtenerTipoImpresora()) {
		case ETIQUETAS:
			longitudMaximaEtiquetas.setText(""+((ImpresoraEtiquetas)impresoraGuardar).getLongitudMaximaEtiquetas());
			break;
		case INYECCION_TINTA:
			numeroCartuchos.setText(""+((ImpresoraInyeccionTinta)impresoraGuardar).getNumeroCartuchos());
			break;
		case LASER:
			tecnologiaImpresion.setText(((ImpresoraLaser)impresoraGuardar).getTecnologiaImpresion());
			break;
		case MATRIZ_PUNTOS:
			numeroAgujas.setText(""+((ImpresoraMatrizPuntos)impresoraGuardar).getNumeroAgujas());
			break;
		case TERMICA:
			durabilidadCabezaTermica.setText(""+((ImpresoraTermica)impresoraGuardar).getDurabilidadCabezaTermica());
			break;
		case SUBLIMACION_TINTA:
			temperaturaImpresion.setText(""+((ImpresoraSublimacionTinta)impresoraGuardar).getTemperaturaImpresion());
			break;
		}
	}

	/**
	 * Metodo que pone la informacion de los detalles de la impresora en los campos correspondientes
	 * @param impresora Impresora en la que se va a cambiar sus detalles
	 */
	public void setImpresoraGuardar(ImpresoraInterfaz impresora) {
		this.impresoraGuardar = impresora;
		if (impresora!=null) {
			estado.setValue(ClaseUtilitaria.obtenerEstadoImpresora(impresora));
			nombre.setText(impresora.getNombre());
			marca.setText(impresora.getMarca());
			resolucionHorizontal.setText(Integer.toString(impresora.getResolucionHorizontal()));
			resolucionVertical.setText(Integer.toString(impresora.getResolucionVertical()));
			tipoImpresora.setValue(impresora.obtenerTipoImpresoraCadena());
			organizarDatosTipoImpresora();
			ponerDatoUnico();
		} else {
			estado.setValue("");
			nombre.setText("");
			marca.setText("");
			resolucionHorizontal.setText("");
			resolucionVertical.setText("");
			bloquearEntradasUnicas();
		}
		
	}
	
	/**
	 * Metodo que bloquea todas las entradas unicas de cada tipo
	 */
	public void bloquearEntradasUnicas() {
		longitudMaximaEtiquetas.setEditable(false);
		longitudMaximaEtiquetas.setStyle("-fx-background-color: #aaaaaa;");
		longitudMaximaEtiquetas.setText("N/A");;
		numeroCartuchos.setEditable(false);
		numeroCartuchos.setStyle("-fx-background-color: #aaaaaa;");
		numeroCartuchos.setText("N/A");
		tecnologiaImpresion.setEditable(false);
		tecnologiaImpresion.setStyle("-fx-background-color: #aaaaaa;");
		tecnologiaImpresion.setText("N/A");
		numeroAgujas.setEditable(false);
		numeroAgujas.setStyle("-fx-background-color: #aaaaaa;");
		numeroAgujas.setText("N/A");
		temperaturaImpresion.setEditable(false);
		temperaturaImpresion.setStyle("-fx-background-color: #aaaaaa;");
		temperaturaImpresion.setText("N/A");
		durabilidadCabezaTermica.setEditable(false);
		durabilidadCabezaTermica.setStyle("-fx-background-color: #aaaaaa;");
		durabilidadCabezaTermica.setText("N/A");
	}
	
	/**
	 * Metodo que verifica si las entradas indicadas son validas
	 * @return Si las entradas son validas o no
	 */
	public boolean sonEntradasValidas() {
		boolean entradasValidas=false;
		String msj="";
		if (estado.getValue()==null || ((String) estado.getValue()).trim().equals("")) {
			msj+="Debe seleccionar un estado";
		}
		if (nombre.getText()==null || ((String) nombre.getText()).trim().equals("")) {
			msj+="\n\nEl nombre no debe estar vacio";
		}
		if (marca.getText()== null || ((String) marca.getText()).trim().equals("")) {
			msj+="\n\nEl nombre no debe estar vacio";
		}
		try {
			if (Integer.parseInt(resolucionHorizontal.getText())==0) {
				throw new Exception("Valor invalido");
			}
			Integer.parseInt(resolucionHorizontal.getText());
		} catch (Exception e) {
			if (resolucionHorizontal.getText().equals("")) {
				msj+="\n\nValor de resolucion horizontal no debe estar vacio";
			} else {
				msj+="\n\nValor de resolucion horizontal no es valido";
			}
		}
		try {
			if (Integer.parseInt(resolucionVertical.getText())==0) {
				throw new Exception("Valor invalido");
			}
		} catch (Exception e) {
			if (resolucionVertical.getText().equals("")) {
				msj+="\n\nValor de resolucion vertical no debe estar vacio";
			} else {
				msj+="\n\nValor de resolucion vertical no es valido";
			}
		}
		if (msj.equals("")) {
			entradasValidas=true;
		} else {
			JOptionPane.showMessageDialog(null, msj,"Entradas no validas",JOptionPane.ERROR_MESSAGE);
		}
		return entradasValidas;
	}
	
	/**
	 * Metodo que obtiene la impresora resultante de los datos ingresados
	 * @return Impresora resultante de los datos ingresados
	 */
	public ImpresoraInterfaz obtenerImpresora() {
		ImpresoraInterfaz impresora=null;
		switch(ClaseUtilitaria.obtenerTipoImpresora(""+tipoImpresora.getValue())) {
		case ETIQUETAS:
			impresora=new ImpresoraEtiquetas(ClaseUtilitaria.obtenerEstadoImpresora(""+estado.getValue()),nombre.getText(),marca.getText(),
			Integer.parseInt(resolucionHorizontal.getText()),Integer.parseInt(resolucionVertical.getText()),Double.parseDouble(longitudMaximaEtiquetas.getText()));
			break;
		case INYECCION_TINTA:
			impresora=new ImpresoraInyeccionTinta(ClaseUtilitaria.obtenerEstadoImpresora(""+estado.getValue()),nombre.getText(),marca.getText(),
			Integer.parseInt(resolucionHorizontal.getText()),Integer.parseInt(resolucionVertical.getText()),Integer.parseInt(numeroCartuchos.getText()));
			break;
		case LASER:
			impresora=new ImpresoraLaser(ClaseUtilitaria.obtenerEstadoImpresora(""+estado.getValue()),nombre.getText(),marca.getText(),
			Integer.parseInt(resolucionHorizontal.getText()),Integer.parseInt(resolucionVertical.getText()),tecnologiaImpresion.getText());
			break;
		case MATRIZ_PUNTOS:
			impresora=new ImpresoraMatrizPuntos(ClaseUtilitaria.obtenerEstadoImpresora(""+estado.getValue()),nombre.getText(),marca.getText(),
			Integer.parseInt(resolucionHorizontal.getText()),Integer.parseInt(resolucionVertical.getText()),Integer.parseInt(numeroAgujas.getText()));
			break;
		case TERMICA:
			impresora=new ImpresoraTermica(ClaseUtilitaria.obtenerEstadoImpresora(""+estado.getValue()),nombre.getText(),marca.getText(),
			Integer.parseInt(resolucionHorizontal.getText()),Integer.parseInt(resolucionVertical.getText()),Integer.parseInt(durabilidadCabezaTermica.getText()));
			break;
		case SUBLIMACION_TINTA:
			impresora=new ImpresoraSublimacionTinta(ClaseUtilitaria.obtenerEstadoImpresora(""+estado.getValue()),nombre.getText(),marca.getText(),
			Integer.parseInt(resolucionHorizontal.getText()),Integer.parseInt(resolucionVertical.getText()),Double.parseDouble(temperaturaImpresion.getText()));
			break;
		}
		return impresora;
	}
	
	/**
	 * Metodo que verifica si el dato unico del tipo de la impresora indicada es valido
	 * @return Respuesta de que si el dato es valido o no
	 */
	public boolean verificarDatoUnico() {
		boolean datoValido=false;
		String msj="";
		if (tipoImpresora.getValue()==null) {
			msj="Debe indicar el tipo de impresora y indicar el dato unico del respectivo tipo";
		} else {
			switch(ClaseUtilitaria.obtenerTipoImpresora(""+tipoImpresora.getValue())) {
			case ETIQUETAS:
				try {
					if (Double.parseDouble(longitudMaximaEtiquetas.getText())<=0) {
						throw new Exception("Valor invalido");
					}
				} catch (Exception e) {
					if (longitudMaximaEtiquetas.getText().equals("")) {
						msj+="La longitud maxima de las etiquetas no debe estar vacio";
					} else {
						msj+="La longitud maxima de las etiquetas no es valida";
					}
				}
				break;
			case INYECCION_TINTA:
				try {
					if (Integer.parseInt(numeroCartuchos.getText())<0) {
						throw new Exception("Valor invalido");
					}
				} catch (Exception e) {
					if (numeroCartuchos.getText().equals("")) {
						msj+="El numero de cartuchos no debe estar vacio";
					} else {
						msj+="El numero de cartuchos no es valido";
					}
				}
				break;
			case LASER:
				if (tecnologiaImpresion.getText()==null || tecnologiaImpresion.getText().trim().equals("")) {
					msj+="La tecnologia de impresion no debe estar vacia";
				}
				break;
			case MATRIZ_PUNTOS:
				try {
					if (Integer.parseInt(numeroAgujas.getText())<0) {
						throw new Exception("Valor invalido");
					}
				} catch (Exception e) {
					if (numeroAgujas.getText().equals("")) {
						msj+="El numero de agujas no debe estar vacio";
					} else {
						msj+="El numero de agujas no es valido";
					}
				}
				break;
			case TERMICA:
				try {
					if (Integer.parseInt(durabilidadCabezaTermica.getText())<0) {
						throw new Exception("Valor invalido");
					}
				} catch (Exception e) {
					if (durabilidadCabezaTermica.getText().equals("")) {
						msj+="La durabilidad de la cabeza termica (numero maximo de impresiones que la cabeza termica de la impresora puede "
						+"realizar antes de requerir mantenimiento o reemplazo) no debe estar vacia";
					} else {
						msj+="La durabilidad de la cabeza termica (numero maximo de impresiones que la cabeza termica de la impresora puede "
						+"realizar antes de requerir mantenimiento o reemplazo) no es valida";
					}
				}
				break;
			case SUBLIMACION_TINTA:
				try {
					if (Double.parseDouble(temperaturaImpresion.getText())<0) {
						throw new Exception("Valor invalido");
					}
				} catch (Exception e) {
					if (temperaturaImpresion.getText().equals("")) {
						msj+="El numero de reuniones no debe estar vacio";
					} else {
						msj+="El numero de reuniones no es valido";
					}
				}
				break;
			}
		}
		if (msj.equals("")) {
			datoValido=true;
		} else {
			JOptionPane.showMessageDialog(null, msj,"Entrada no valida",JOptionPane.ERROR_MESSAGE);
		}
		return datoValido;
	}
	
	/**
	 * Metodo que inicializa la clase controlador
	 */
	@FXML
	private void initialize() {
		ObservableList<String> estados=FXCollections.observableArrayList();
		estados.add("Activo");
		estados.add("Inactivo");
		estado.setItems(estados);
		ObservableList<String> tipoImpresoras=FXCollections.observableArrayList();
		tipoImpresoras.add("Etiquetas");
		tipoImpresoras.add("Inyeccion de tinta");
		tipoImpresoras.add("Laser");
		tipoImpresoras.add("Matriz de puntos");
		tipoImpresoras.add("Sublimacion de tinta");
		tipoImpresoras.add("Termica");
		tipoImpresora.setItems(tipoImpresoras);
	}
	
	/**
	 * Metodo que cierra la ventana de edicion de los detalles de la impresora
	 */
	@FXML
	private void volver() {
		ventana.close();
	}
	
	/**
	 * Metodo que guarda los datos indicados de la impresora
	 */
	@FXML
	private void guardarDatos() {
		if (sonEntradasValidas() && verificarDatoUnico()) {
			if (impresoraGuardar!=null) {
				if (impresoraGuardar.getEstado()==ClaseUtilitaria.obtenerEstadoImpresora(""+tipoImpresora.getValue())) {
					impresoraGuardar.setEstado(ClaseUtilitaria.obtenerEstadoImpresora(""+estado.getValue()));
					impresoraGuardar.setNombre(nombre.getText());
					impresoraGuardar.setMarca(marca.getText());
					impresoraGuardar.setResolucionHorizontal(Integer.parseInt(resolucionHorizontal.getText()));
					impresoraGuardar.setResolucionVertical(Integer.parseInt(resolucionVertical.getText()));
					datosFueronGuardados = true;
				} else{
					ImpresoraInterfaz impresora=obtenerImpresora();
					centroImpresion.remplazarImpresora(impresoraGuardar,impresora);
					datosFueronGuardados = true;
				}
				
			} else{
				ImpresoraInterfaz impresora=obtenerImpresora();
				centroImpresion.agregarImpresora(impresora);
				datosFueronGuardados = true;
			}
			ventana.close();
		}
		
	}
	
	/**
	 * Metodo que organiza los datos del tipo de impresora indicado
	 */
	@FXML
	private void organizarDatosTipoImpresora() {
		bloquearEntradasUnicas();
		TipoImpresora tipoSeleccionado=ClaseUtilitaria.obtenerTipoImpresora(""+tipoImpresora.getValue());
		switch(tipoSeleccionado) {
			case ETIQUETAS:
				longitudMaximaEtiquetas.setEditable(true);
				longitudMaximaEtiquetas.setStyle(null);
				longitudMaximaEtiquetas.setText("");
				break;
			case INYECCION_TINTA:
				numeroCartuchos.setEditable(true);
				numeroCartuchos.setStyle(null);
				numeroCartuchos.setText("");
				break;
			case LASER:
				tecnologiaImpresion.setEditable(true);
				tecnologiaImpresion.setStyle(null);
				tecnologiaImpresion.setText("");
				break;
			case MATRIZ_PUNTOS:
				numeroAgujas.setEditable(true);
				numeroAgujas.setStyle(null);
				numeroAgujas.setText("");
				break;
			case TERMICA:
				durabilidadCabezaTermica.setEditable(true);
				durabilidadCabezaTermica.setStyle(null);
				durabilidadCabezaTermica.setText("");
				break;
			case SUBLIMACION_TINTA:
				temperaturaImpresion.setEditable(true);
				temperaturaImpresion.setStyle(null);
				temperaturaImpresion.setText("");
				break;
		}
	}
	
}
