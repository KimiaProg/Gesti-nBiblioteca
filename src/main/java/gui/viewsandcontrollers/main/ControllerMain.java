package gui.viewsandcontrollers.main;

import java.io.IOException;
import java.util.Optional;

import gui.viewandcontrollers.form.viewmodel.Notifications;
import gui.viewsandcontrollers.modal.ControllerNuevo;
import negocio.Negocio;
import negocio.model.*;
import negocio.model.Libro;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ControllerMain {

	private static ObservableList<Libro> catalogo = FXCollections.observableArrayList();

	private Negocio negocio = Negocio.getInstance();

	@FXML
	TableView<Libro> table;

	@FXML
	Button botonEliminar;
	@FXML
	Button botonEditar;

	@FXML
	TableColumn<Libro, String> titulo;
	@FXML
	TableColumn<Libro, String> isbn;
	@FXML
	TableColumn<Libro, String> autor;
	@FXML
	TableColumn<Libro, Genero> genero;
	@FXML
	TableColumn<Libro, Integer> paginas;

	@FXML
	public void initialize() {
		titulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
		isbn.setCellValueFactory(new PropertyValueFactory<>("isbn"));
		autor.setCellValueFactory(new PropertyValueFactory<>("autor"));
		genero.setCellValueFactory(new PropertyValueFactory<>("genero"));
		paginas.setCellValueFactory(new PropertyValueFactory<>("paginas"));

		botonEditar.disableProperty().bind(table.getSelectionModel().selectedItemProperty().isNull());
		botonEliminar.disableProperty().bind(table.getSelectionModel().selectedItemProperty().isNull());

		Notifications.subscribe(Notifications.CATALOGO_UPDATED, this, this::update);
	}

	@FXML
	private void nuevo(ActionEvent event) throws IOException {
		formLibro(event, null);
	}

	private void formLibro(ActionEvent event, Libro libro) throws IOException {
		Stage stage = new Stage();
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../modal/NuevoFXML.fxml"));

		ControllerNuevo nuevo;
		if (libro == null) {
			nuevo = new ControllerNuevo();
		} else {
			nuevo = new ControllerNuevo(libro);
		}
		fxmlLoader.setController(nuevo);
		Parent root1 = fxmlLoader.load();
		stage.setScene(new Scene(root1));
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(((Node) event.getSource()).getScene().getWindow());
		stage.showAndWait();

	}

	@FXML
	private void editar(ActionEvent event) throws IOException {
		Libro libroAEditar = table.getSelectionModel().getSelectedItem();
		formLibro(event,libroAEditar);

		/*
		 * Libro ultimo =
		 * negocio.getCatalogoNegocio().get(negocio.getCatalogoNegocio().size() - 1);
		 * int indiceOflibroEdit = catalogo.indexOf(libroAEditar);
		 * 
		 * negocio.delete(ultimo); negocio.getCatalogoNegocio().set(indiceOflibroEdit,
		 * ultimo);
		 * 
		 * table.getItems().removeAll(catalogo); catalogo.removeAll(catalogo);
		 * catalogo.addAll(negocio.getCatalogoNegocio());
		 * table.getItems().addAll(catalogo);
		 */
	}

	@FXML
	private void eliminar(ActionEvent event) throws IOException {
		Alert warning= new Alert(Alert.AlertType.CONFIRMATION);
		
		//warning.setHeaderText("Está seguro de eliminar este registro?");
		warning.setTitle("Warning");
		warning.setContentText("Está seguro de eliminar este registro?");
		
		Optional<ButtonType> botonRes=  warning.showAndWait();
		
		if(botonRes.get()== ButtonType.OK) {
			negocio.delete(table.getSelectionModel().getSelectedItem());
			update(Notifications.CATALOGO_UPDATED);
		}
	}

	@FXML
	private void salvar(ActionEvent event) throws IOException {

	}

	@FXML
	private void cargar(ActionEvent event) throws IOException {

	}

	private void update(String event) {
		catalogo = FXCollections.observableArrayList(negocio.getCatalogoNegocio());
		table.setItems(catalogo);
		table.refresh();
	}

	public static ObservableList<Libro> getCatalogo() {
		return catalogo;
	}
}
