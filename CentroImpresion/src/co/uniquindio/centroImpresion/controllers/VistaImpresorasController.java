package co.uniquindio.centroImpresion.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javax.swing.JOptionPane;

import co.uniquindio.centroImpresion.application.Aplicacion;
import co.uniquindio.centroImpresion.model.*;
import co.uniquindio.centroImpresion.util.ClaseUtilitaria;

public class VistaImpresorasController {
	
	@FXML
	private TableView<ImpresoraInterfaz> tablaImpresora;
	@FXML
	private TableColumn<ImpresoraInterfaz,String> ColumnaNombre;
	@FXML
	private TableColumn<ImpresoraInterfaz,Estado> ColumnaActividad;
	@FXML
	private Label actividad;
	@FXML
	private Label nombre;
	@FXML
	private Label marca;
	@FXML
	private Label resolucion;
	@FXML
	private Label tipoImpresora;
	@FXML
	private Label longitudMaximaEtiquetas;
	@FXML
	private Label numeroCartuchos;
	@FXML
	private Label tecnologiaImpresion;
	@FXML
	private Label numeroAgujas;
	@FXML
	private Label temperaturaImpresion;
	@FXML
	private Label durabilidadCabezaTermica;
	private Aplicacion mainApp;
	private CentroImpresion centroImpresion;
	
	public void obtenerCentroImpresion(CentroImpresion centroImpresion) {
		this.centroImpresion=centroImpresion;
	}
	
	/**
	 * Metodo constructor
	 */
	public VistaImpresorasController() {
		
	}
	
	/**
	 * Metodo que obtiene la direccion de la aplicacion principal
	 * @param mainApp Dereccion de la aplicacion principal
	 */
	public void setMainApp(Aplicacion mainApp) {
		this.mainApp = mainApp;
		tablaImpresora.setItems(centroImpresion.getListaImpresoras());
	}
	
	/**
	 * Metodo que muestra el detalle unico de la respectiva clase de la impresora indicada
	 * @param impresora Impresora indicada
	 */
	public void mostrarDetalleUnico(ImpresoraInterfaz impresora) {
		switch(impresora.obtenerTipoImpresora()) {
			case ETIQUETAS:
				longitudMaximaEtiquetas.setText(""+((ImpresoraEtiquetas)impresora).getLongitudMaximaEtiquetas()+"cm");
				break;
			case INYECCION_TINTA:
				numeroCartuchos.setText(""+((ImpresoraInyeccionTinta)impresora).getNumeroCartuchos());
				break;
			case LASER:
				tecnologiaImpresion.setText(((ImpresoraLaser)impresora).getTecnologiaImpresion());
				break;
			case MATRIZ_PUNTOS:
				numeroAgujas.setText(""+((ImpresoraMatrizPuntos)impresora).getNumeroAgujas());
				break;
			case TERMICA:
				durabilidadCabezaTermica.setText(""+((ImpresoraTermica)impresora).getDurabilidadCabezaTermica());
				break;
			case SUBLIMACION_TINTA:
				temperaturaImpresion.setText(""+((ImpresoraSublimacionTinta)impresora).getTemperaturaImpresion());
				break;
		}
	}
	
	/**
	 * Metodo que muestra los detalles de la impresora seleccionada
	 * @param impresora Impresora que se desea mostrar sus detalles
	 */
	private void mostrarDetallesImpresora(ImpresoraInterfaz impresora) {
		if (impresora != null) {
			actividad.setText(ClaseUtilitaria.obtenerEstadoImpresora(impresora));
			nombre.setText(impresora.getNombre());
			marca.setText(impresora.getMarca());
			tipoImpresora.setText(impresora.obtenerTipoImpresoraCadena());
			resolucion.setText(ClaseUtilitaria.organizarResolucion(impresora));
			tipoImpresora.setText(impresora.obtenerTipoImpresoraCadena());
			longitudMaximaEtiquetas.setText("N/A");
			numeroCartuchos.setText("N/A");
			tecnologiaImpresion.setText("N/A");
			numeroAgujas.setText("N/A");
			temperaturaImpresion.setText("N/A");
			durabilidadCabezaTermica.setText("N/A");
			mostrarDetalleUnico(impresora);
		} else {
			actividad.setText("");
			nombre.setText("");
			marca.setText("");
			tipoImpresora.setText("");
			resolucion.setText("");
			tipoImpresora.setText("");
			longitudMaximaEtiquetas.setText("");
			numeroCartuchos.setText("");
			tecnologiaImpresion.setText("");
			numeroAgujas.setText("");
			temperaturaImpresion.setText("");
			durabilidadCabezaTermica.setText("");
		}
	}
	
	/**
	 * Metodo que inicializa la clase controlador
	 */
	@FXML
	private void initialize() {
			ColumnaNombre.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
			ColumnaActividad.setCellValueFactory(cellData -> cellData.getValue().estadoProperty());
				mostrarDetallesImpresora(null);
				tablaImpresora.getSelectionModel().selectedItemProperty().addListener(
						(observable, valorAntiguo, nuevoValor) -> mostrarDetallesImpresora(nuevoValor));
	}
	
	/**
	 * Metodo que elimina el registro de la impresora seleccionada
	 */
	@FXML
	private void eliminar() {
		int selectedIndex = tablaImpresora.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			tablaImpresora.getItems().remove(selectedIndex);
		} else {
			JOptionPane.showMessageDialog(null,"Elija una impresora","No hay una impresora seleccionada",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Metodo que abre la ventana de edicion para editar los detalles de la impresora seleccionada
	 */
	@FXML
	private void editar() {
		ImpresoraInterfaz impresoraSeleccionada = tablaImpresora.getSelectionModel().getSelectedItem();
		int posicionSeleccionada = tablaImpresora.getSelectionModel().getSelectedIndex();
		if (impresoraSeleccionada != null) {
			boolean fueGuardado = mainApp.mostrarEditorImpresora(impresoraSeleccionada);
			if (fueGuardado) {
				tablaImpresora.getSelectionModel().select(posicionSeleccionada);
				impresoraSeleccionada = tablaImpresora.getSelectionModel().getSelectedItem();
				mostrarDetallesImpresora(impresoraSeleccionada);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Elija una impresora","No hay una impresora seleccionada",JOptionPane.WARNING_MESSAGE);
		} 
	}
	
	/**
	 * Metodo que abre la ventana de edicion para agregar una nueva impresora
	 */
	@FXML
	private void agregar() {
		if(mainApp.mostrarEditorImpresora(null)) {
			tablaImpresora.getSelectionModel().select(tablaImpresora.getItems().size() - 1);
			ImpresoraInterfaz impresoraSeleccionada = tablaImpresora.getSelectionModel().getSelectedItem();
			mostrarDetallesImpresora(impresoraSeleccionada);
		}
	}
	
	/**
	 * Metodo que abre la ventana donde se realizan impresiones si esta seleccionada una impresora activa
	 */
	@FXML
	private void imprimirDocumento() {
		int posicionSeleccionada = tablaImpresora.getSelectionModel().getSelectedIndex();
		if (posicionSeleccionada >= 0) {
			ImpresoraInterfaz impresoraSeleccionada=tablaImpresora.getSelectionModel().getSelectedItem();
			if (impresoraSeleccionada.estaActiva()) {
				mainApp.mostrarVentanaImpresion(impresoraSeleccionada);
			} else {
				JOptionPane.showMessageDialog(null,"La impresora no puede imprimir porque esta inactiva","Impresora inactiva",JOptionPane.WARNING_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null,"Elija una impresora","No hay una impresora seleccionada",JOptionPane.ERROR_MESSAGE);
		}
	}

}
