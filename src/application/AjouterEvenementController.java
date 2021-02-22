package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import login.MysqlConnect;

public class AjouterEvenementController implements Initializable {
	@FXML
	private Button enregistrer;
	@FXML
	private Button retour;
	@FXML
	private TextField txt_titre;
	@FXML
	private TextField txt_description;
	@FXML
	private TextField date;
	@FXML
	private TextField heure;
	@FXML
	public void enregistrer(ActionEvent event) {
		addEvenement();
		//Ici le code pour enregistrer le titre de l'évenement 
		//et la description dans la base de données
		Main.setPane(3);//On retourne dans la page Evenement
	}
	@FXML
	public void retour(ActionEvent event) {
		Main.setPane(3);
	}
	
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pst = null;
	
	public void addEvenement() {
		
		conn = MysqlConnect.ConnectDb();
		String sql = "insert into evenement(titre,description,date,heure,utilisateur) values (?,?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, txt_titre.getText());
			pst.setString(2, txt_description.getText());
			pst.setString(3, date.getText());
			pst.setString(4, heure.getText());
			pst.setString(5,Main.getUser() );
			pst.execute();
			EvenementController e= new EvenementController();
			e.updateTable();
			JOptionPane.showMessageDialog(null, "Evenement ajouté avec succès!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
