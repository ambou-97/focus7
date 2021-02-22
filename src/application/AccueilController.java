package application;
	
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;




public class AccueilController implements Initializable{

	@FXML
	private Label utilisateurs;//utilisateurs connectés
	@FXML
	private Label mod;
	@FXML
	private Button param;//aller vers parametres
	@FXML
	private Button cal;//aller vers le calendrier
	@FXML
	private Button today;
	@FXML
	private Button quitter;//aller vers le calendrier
	@FXML
	public void affichercal(ActionEvent event) {
		Main.setPane(2);
	}
	@FXML
	public void aujourdhui(ActionEvent event) {
		Main.setPane(3);
	}
	@FXML
	public void quitter(ActionEvent event) {
		Platform.exit();
	}
	@FXML
	public void button_param(ActionEvent event) {
		Main.setPane(1);
	}
	@FXML
	public void utilisateurC(ActionEvent event) {
		utilisateurs.setText(Main.getUser());
	}
	@Override
	public void initialize(URL arg0, ResourceBundle rb) {
		
		
	}

	
	
}