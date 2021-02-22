package application;

import java.net.URL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import com.sun.jdi.connect.spi.Connection;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import login.MysqlConnect;

public class EvenementController implements Initializable {
	@FXML
	Label date;
	@FXML
	ObservableList<Evenement> listE;
	@FXML
	ObservableList<Emploi_du_temps> listEmploi;
	@FXML
	private ListView<Evenement> col_evenement;
	@FXML
	private TableView<Emploi_du_temps> table_horaire;
	@FXML
	private TableColumn<Emploi_du_temps,String> col_horaire;
	@FXML
	private TableColumn<Emploi_du_temps,String> col_titre;
	@FXML
	private TableColumn<Emploi_du_temps,String> col_statut;
	@FXML
	private Button accueil_button;
	@FXML
	private Button add_evenement_button;
	@FXML
	private Button add_horaire_button;
	@FXML
	private HBox footer;
	@FXML
	private Label label2;
	@FXML
	public void nouveauEvenement(ActionEvent event) {
		Main.setPane(4);
	}
	@FXML
	public void nouveauHoraire(ActionEvent event) {
		Main.setPane(5);
	}
	@FXML
	public void retour(ActionEvent event) {
		Main.setPane(0);
	}
	
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pst = null;
	
	@Override
	public void initialize(URL arg0, ResourceBundle rb) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		date.setText(dtf.format(now));
		col_horaire.setCellValueFactory(new PropertyValueFactory<Emploi_du_temps,String>("horaire"));
		col_titre.setCellValueFactory(new PropertyValueFactory<Emploi_du_temps,String>("titre"));
		listEmploi = MysqlConnect.getDataEmploi_du_temps();
		table_horaire.setItems(listEmploi);
		
		listE = MysqlConnect.getDataEvenement();
		col_evenement.setItems(listE);
		
	}
	
	public void updateTable() {
		URL arg=null;
		ResourceBundle rb=null;
		initialize(arg, rb);
	}
}
