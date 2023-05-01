module CentroImpresion {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.base;
	requires java.desktop;
	requires javafx.graphics;
	
	exports co.uniquindio.centroImpresion.application;
	opens co.uniquindio.centroImpresion.application to javafx.fxml,org.controlsfx;

	opens co.uniquindio.centroImpresion.controllers to javafx.fxml;
}
