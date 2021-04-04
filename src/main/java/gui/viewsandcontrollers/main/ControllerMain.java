package gui.viewsandcontrollers.main;
import java.io.IOException;
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
	
	@FXML
	private TextField text;
	
	@FXML
	private Window root;
    public void initialize() {
        // TODO
    }

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
    	Node source = (Node) event.getSource();
	    Stage parent = (Stage) source.getScene().getWindow();
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../modal/SecondFXML.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage dialog = new Stage();
        dialog.setScene(new Scene(root1)); 
        dialog.setTitle(text.getText());
        dialog.initOwner(parent);
        dialog.initModality(Modality.APPLICATION_MODAL); 
        dialog.showAndWait();
    }
   
}
