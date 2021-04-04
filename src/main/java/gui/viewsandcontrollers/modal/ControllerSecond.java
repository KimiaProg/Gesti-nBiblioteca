package gui.viewsandcontrollers.modal;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;

public class ControllerSecond {

	public void initialize() {
		// TODO
	}

	@FXML
	private void cerrarVentana(ActionEvent event) throws IOException {
		Node source = (Node) event.getSource();
	    Stage stage = (Stage) source.getScene().getWindow();
	    stage.close();
	}

}
