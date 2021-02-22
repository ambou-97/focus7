package login;

import javafx.scene.control.TextField;
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

public class LoginController implements Initializable{
	@FXML
	private Button connect;
	@FXML
	private Button retour;
	@FXML
	private TextField txt_login;
	@FXML
	private PasswordField txt_password;
	
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pst = null;
	
	@FXML
	public void connexion(ActionEvent e) {
		//Si les champs sont bien renseignés, alors on va aller directement sur l'application
		//Si les informations sont erronées, alors on aura la page suivante:
		//Main.setPane(10);
		Main.setPane(0);
	}
	@FXML
	public void retour(ActionEvent event) {
		Main.setPane(6);
	}
	
	
	@FXML
	private void Login(ActionEvent event) throws Exception{
		conn = MysqlConnect.ConnectDb();
		String sql = "select * from app_connexion where login = ? and password = ? ";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, txt_login.getText());
			pst.setString(2, txt_password.getText());
			rs = pst.executeQuery();
			
			if(rs.next()) {
				//JOptionPane.showMessageDialog(null, "username and password are correct!");
				String utilisateur=txt_login.getText();
				Main.setUser(utilisateur);
				Main.setPane(0);
			}else
			{
				JOptionPane.showMessageDialog(null, "Invalide");
				Main.setPane(10);
			}
				
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
