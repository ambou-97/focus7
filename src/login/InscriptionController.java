package login;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;



public class InscriptionController implements Initializable {
	@FXML
	private Button confirm;
	@FXML
	private Button retour;
	@FXML
	private TextField user_id_up;
	@FXML
	private PasswordField user_password1;
	@FXML
	private PasswordField user_password2;
	
	
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pst = null;
	
	
	@FXML
	public void confirmation(ActionEvent event) {
		
		//si l'utilisateur remplit correctement les champs, il va se diriger dans la page login ---->Main.setPane(2)
		//si l'utilisateur commet une erreur sur les mots de passe, alors 
		Main.setPane(9);
	}
	@FXML
	public void retour(ActionEvent event) {
		Main.setPane(6);
	}
	
	@FXML
	public void add_users(ActionEvent event) {
		conn = MysqlConnect.ConnectDb();
		String sql = "insert into app_connexion(login,password) values (?,?)";
		try {
			if(user_password1.getText().equals(user_password2.getText())){
			pst = conn.prepareStatement(sql);
			pst.setString(1, user_id_up.getText());
			pst.setString(2, user_password1.getText());
			//pst.setString(3, user_password2.getText());
			pst.execute();
			JOptionPane.showMessageDialog(null, "saved");
			Main.setPane(8);
			}
			else {
				Main.setPane(9);
		}
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}

