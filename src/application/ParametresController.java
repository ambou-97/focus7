package application;
	
import javafx.event.ActionEvent;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;




public class ParametresController implements Initializable{

	
	@FXML
	private Button retour;//aller vers le menu
	@FXML
	public void retour(ActionEvent event) {
		Main.setPane(0);
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

	
	
}