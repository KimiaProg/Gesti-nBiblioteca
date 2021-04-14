package gui.viewsandcontrollers.modal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import gui.viewandcontrollers.form.viewmodel.LibroConverter;
import gui.viewandcontrollers.form.viewmodel.LibroViewModel;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Pair;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;
import negocio.model.Genero;
import negocio.model.Libro;

public class ControllerNuevo {

	LibroViewModel viewModel = new LibroViewModel();
	@FXML
	ComboBox<Pair<String, String>> comboGen;
	@FXML
	TextField textTitulo;
	@FXML
	TextField textISBN;
	@FXML
	TextField textAutor;
	@FXML
	TextField textPaginas;

	
	public void initialize() {

		List<Pair<String, String>> opcionesChoiceBox = new ArrayList<>();
		opcionesChoiceBox.add(new Pair(Genero.FICCION.toString(), Genero.FICCION.toString()));
		opcionesChoiceBox.add(new Pair(Genero.NOVELA.toString(), Genero.NOVELA.toString()));
		opcionesChoiceBox.add(new Pair(Genero.POESIA.toString(), Genero.POESIA.toString()));

		comboGen.setConverter(new StringConverter<Pair<String, String>>() {

			@Override
			public String toString(Pair<String, String> pair) {
				return pair.getKey();
			}

			@Override
			public Pair<String, String> fromString(String string) {
				return null;
			}
		});

		comboGen.getItems().addAll(opcionesChoiceBox);

		textTitulo.textProperty().bindBidirectional(viewModel.getTitulo());
		textISBN.textProperty().bindBidirectional(viewModel.getIsbn());
		textAutor.textProperty().bindBidirectional(viewModel.getAutor());
		comboGen.valueProperty().bindBidirectional(viewModel.getGenero());
		Bindings.bindBidirectional(textPaginas.textProperty(), viewModel.getPaginas(), new NumberStringConverter());
	}

	@FXML
	private void aceptarCerrarVentana(ActionEvent event) throws IOException {
		Node source = (Node) event.getSource();
		Stage stage = (Stage) source.getScene().getWindow();

		viewModel.create();

		stage.close();

	}

	@FXML
	private void cancelar(ActionEvent event) throws IOException {
		Node source = (Node) event.getSource();
		Stage stage = (Stage) source.getScene().getWindow();
		stage.close();
	}

}
