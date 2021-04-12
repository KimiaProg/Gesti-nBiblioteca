package gui.viewsandcontrollers.modal;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import negocio.Negocio;
import negocio.model.Genero;
import negocio.model.Libro;

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
	}

	@FXML
	private void aceptarCerrarVentana(ActionEvent event) throws IOException {
		Node source = (Node) event.getSource();
		Stage stage = (Stage) source.getScene().getWindow();
		String titulo = textTitulo.getText();
		String isbn = textISBN.getText();
		String autor = textAutor.getText();
		Genero genero = Genero.getGenero(textGenero.getText());
		int paginas = Integer.parseInt(textPaginas.getText());
		Libro nuevoLibro = new Libro(titulo, isbn, genero, autor, paginas);
		stage.close();
		Negocio.add(nuevoLibro);
	}

	@FXML
	private void cancelar(ActionEvent event) throws IOException {
		Node source = (Node) event.getSource();
		Stage stage = (Stage) source.getScene().getWindow();
		stage.close();
	}

}
