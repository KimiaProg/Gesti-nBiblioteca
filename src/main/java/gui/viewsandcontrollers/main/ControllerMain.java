package gui.viewsandcontrollers.main;
import java.io.IOException;
import java.util.ArrayList;
import clasesBiblioteca.Libro;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
public class ControllerMain {
	
	private static ArrayList<Libro> catalogo = new ArrayList<Libro>();
	
    public void initialize() {
        // TODO
    }

    @FXML
    private void nuevo(ActionEvent event) throws IOException {
    	Node source = (Node) event.getSource();
	    Stage parent = (Stage) source.getScene().getWindow();
    	
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
    	
    }
   
    public static ArrayList<Libro> getCatalogo(){
    	return catalogo;
    }
}
