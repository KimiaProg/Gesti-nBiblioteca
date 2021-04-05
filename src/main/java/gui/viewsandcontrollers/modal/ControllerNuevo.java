package gui.viewsandcontrollers.modal;

import java.io.IOException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import clasesBiblioteca.*;
import gui.viewsandcontrollers.main.ControllerMain;;

public class ControllerNuevo {

	@FXML
	TextField textTitulo;
	@FXML
	TextField textISBN;
	@FXML
	TextField textAutor;
	@FXML
	TextField textGenero;
	@FXML
	TextField textPaginas;
	
	public void initialize() {
		// TODO
	}

	@FXML
	private void aceptarCerrarVentana(ActionEvent event) throws IOException {
		Node source = (Node) event.getSource();
	    Stage stage = (Stage) source.getScene().getWindow();
	    String titulo = textTitulo.getText();
	    String isbn = textTitulo.getText();
	    String autor = textTitulo.getText();
	    Genero genero = Genero.getGenero(textTitulo.getText());
	    int paginas = Integer.parseInt(textTitulo.getText());
	    Libro nuevoLibro= new Libro(titulo, isbn, genero, autor, paginas);
	    ControllerMain.getCatalogo().add(nuevoLibro);
	    stage.close();
	}

}
