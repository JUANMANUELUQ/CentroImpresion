package co.uniquindio.centroImpresion.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

import co.uniquindio.centroImpresion.model.ImpresoraEtiquetas;
import co.uniquindio.centroImpresion.model.ImpresoraInterfaz;
import co.uniquindio.centroImpresion.model.ImpresoraInyeccionTinta;
import co.uniquindio.centroImpresion.model.ImpresoraLaser;
import co.uniquindio.centroImpresion.model.ImpresoraMatrizPuntos;
import co.uniquindio.centroImpresion.model.ImpresoraSublimacionTinta;
import co.uniquindio.centroImpresion.model.ImpresoraTermica;
import co.uniquindio.centroImpresion.util.ClaseUtilitaria;

public class ImpresionController {
	
	private Stage ventana;
	private ImpresoraInterfaz impresoraImprimir;
	@FXML
	private Label nombre;
	@FXML
	private Label marca;
	@FXML
	private Label tipoImpresora;
	@FXML
	private Label resolucion;
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
	@FXML
	private TextArea contenidoImpresion;
	
	/**
	 * Metodo constructor
	 */
	public ImpresionController() {
		
	}
	
	/**
	 * Metodo que obtiene la direccion de la ventana donde se realiza las impresiones
	 * @param dialogStage Direccion de la ventana donde se realiza las impresiones
	 */
	public void setDialogStage(Stage dialogStage) {
		this.ventana=dialogStage;
		
	}
	
	/**
	 * Metodo que muestra el detalle unico d ela clase respectiva de la impresora
	 * @param impresora Impresora del que se desea sacar su dato unico
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
	 * Metodo que mustra los detalles de la impresora que va a imprimir
	 * @param impresora Impresora que va a imprimir
	 */
	public void setImpresoraImprimir(ImpresoraInterfaz impresora) {
		impresoraImprimir=impresora;
		nombre.setText(impresoraImprimir.getNombre());
		marca.setText(impresoraImprimir.getMarca());
		tipoImpresora.setText(impresoraImprimir.obtenerTipoImpresoraCadena());
		resolucion.setText(ClaseUtilitaria.organizarResolucion(impresoraImprimir));
		mostrarDetalleUnico(impresoraImprimir);
	}
	
	/**
	 * Metodo que inicializa la clase controlador
	 */
	@FXML
	private void initialize() {
		
	}
	
	/**
	 * Metodo que cierra la ventana donde se realiza las impresiones
	 */
	@FXML
	private void volver() {
		ventana.close();
	}
	
	/**
	 * Metodo que selecciona el archivo de tipo txt y muestra la informacion de su interior
	 */
	@FXML
	private void seleccionarArchivo() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Archivos de texto", "*.txt"));
        File archivo = fileChooser.showOpenDialog(ventana);
        if (!(archivo == null)) {
        	leerArchivo(archivo,contenidoImpresion);
        }

	}
	
	/**
	 * Metodo que permite imprimir el documento si este no esta vacio
	 */
	@FXML
	private void imprimir() {
		if (contenidoImpresion.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "No hay un contenido a imprimir","No hay nada que imprimir",JOptionPane.ERROR_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "El contenido fue impreso","Impresion exitosa",JOptionPane.INFORMATION_MESSAGE);
			ventana.close();
		}
	}
	
	/**
	 * Metodo que lee el archivo y muestra el archivo
	 * @param archivo Archivo que se quiere leer
	 * @param lugarTexto Lugar donde se muestra el texto a imprimir
	 */
	private void leerArchivo(File archivo, TextArea lugarTexto) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(archivo));
	        String linea;
	        lugarTexto.clear();
	        while ((linea = br.readLine()) != null) {
	        	lugarTexto.appendText(linea + "\n");
	        }
		} catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
	}
	
}
