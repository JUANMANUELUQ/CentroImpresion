 package co.uniquindio.centroImpresion.application;
import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import co.uniquindio.centroImpresion.controllers.EditorDetallesImpresoraController;
import co.uniquindio.centroImpresion.controllers.ImpresionController;
import co.uniquindio.centroImpresion.controllers.VistaImpresorasController;
import co.uniquindio.centroImpresion.model.*;


public class Aplicacion extends Application {
	
	private Stage primaryStage;
	private AnchorPane rootLayout;
	
	private CentroImpresion centroImpresion=new CentroImpresion();
		
	/**
	 * Metodo constructor;
	 */
	public Aplicacion() {
		
	}
	
	/**
	 * Metodo que obtiene la ventana principal
	 * @return Ventana principal
	 */
	public Stage getPrimaryStage() {
		return primaryStage;
	}
	
	/**
	 * Metodo que empieza a ejecutar la aplicacion
	 */
	@Override
	public void start(Stage primaryStage) {
		ImpresoraInyeccionTinta impresora1=new ImpresoraInyeccionTinta(Estado.ACTIVA,"HP LaserJet Pro M404n","HP",4800 ,600 ,1);
		centroImpresion.agregarImpresora(impresora1);
		ImpresoraMatrizPuntos impresora2=new ImpresoraMatrizPuntos(Estado.INACTIVA,"Epson LX-350","Epson",240 ,144 ,9);
		centroImpresion.agregarImpresora(impresora2);
		ImpresoraSublimacionTinta impresora3=new ImpresoraSublimacionTinta(Estado.ACTIVA,"Mitsubishi CP-M15E","Mitsubishi Electric",300,300,200);
		centroImpresion.agregarImpresora(impresora3);
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Centro de impresion");
		initRootLayout();
	}
	
	/**
	 * Inicia la ventana principal
	 */
	public void initRootLayout() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("/co/uniquindio/centroImpresion/view/VistaImpresoras.fxml"));
			rootLayout = (AnchorPane) loader.load();
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
			VistaImpresorasController controller = loader.getController();
			controller.obtenerCentroImpresion(centroImpresion);
			controller.setMainApp(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo que muestra la ventana donde se va a realizar impresiones
	 * @param impresora Impresora que va a realizar la impresion
	 */
	public void mostrarVentanaImpresion(ImpresoraInterfaz impresora) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("/co/uniquindio/centroImpresion/view/Impresion.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Impresion de documentos");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);
			ImpresionController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setImpresoraImprimir(impresora);
			dialogStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	/**
	 * Metodo que abre la ventana donde se editan los detalles de una impresora
	 * @param impresora Impresora la cual se van a cambiar sus detalles
	 * @return Si los detalles de la impresora fueron cambiados o no
	 */
	public boolean mostrarEditorImpresora(ImpresoraInterfaz impresora) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("/co/uniquindio/centroImpresion/view/EditorDetallesImpresora.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Edicion de los detalles de la impresora");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);
			EditorDetallesImpresoraController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setImpresoraGuardar(impresora);
			controller.obtenerCentroImpresion(centroImpresion);
			dialogStage.showAndWait();
			return controller.fueronDatosGuardados();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} 
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	
}