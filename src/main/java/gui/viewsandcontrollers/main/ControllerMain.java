package gui.viewsandcontrollers.main;

import java.io.IOException;
import java.util.ArrayList;

import clasesBiblioteca.Genero;
import clasesBiblioteca.Libro;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

public class ControllerMain {

	private static ObservableList<Libro> catalogo = FXCollections.observableArrayList();

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

		/*titulo.setCellValueFactory(cellData -> cellData.getValue().getTitulo());
		isbn.setCellValueFactory(cellData -> cellData.getValue().getIsbn());
		autor.setCellValueFactory(cellData -> cellData.getValue().getAutor());
		genero.setCellValueFactory(cellData -> cellData.getValue().getGenero());
		//paginas.setCellValueFactory(cellData -> cellData.getValue().getPaginas());*/
	}

	@FXML
	private void nuevo(ActionEvent event) throws IOException {

		Node source = (Node) event.getSource();
		Stage parent = (Stage) source.getScene().getWindow();

		titulo.setCellValueFactory(new PropertyValueFactory<Libro, String>("titulo"));
		isbn.setCellValueFactory(new PropertyValueFactory<Libro, String>("isbn"));
		autor.setCellValueFactory(new PropertyValueFactory<Libro, String>("autor"));
		genero.setCellValueFactory(new PropertyValueFactory<Libro, Genero>("genero"));
		paginas.setCellValueFactory(new PropertyValueFactory<Libro, Integer>("paginas"));
		
		table.getColumns().addAll(titulo, isbn, autor, genero,paginas);
		
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../modal/NuevoFXML.fxml"));
		Parent root1 = (Parent) fxmlLoader.load();
		Stage dialog = new Stage();
		dialog.setScene(new Scene(root1));
		dialog.initOwner(parent);
		dialog.initModality(Modality.APPLICATION_MODAL);
		dialog.showAndWait();

		
	}

	@FXML
	private void editar(ActionEvent event) throws IOException {

	}

	@FXML
	private void eliminar(ActionEvent event) throws IOException {

	}

	@FXML
	private void salvar(ActionEvent event) throws IOException {

	}

	@FXML
	private void cargar(ActionEvent event) throws IOException {
		table.setItems(catalogo);
		// table.getItems().addAll(catalogo);

	}

	public static ObservableList<Libro> getCatalogo() {
		return catalogo;
	}
}
