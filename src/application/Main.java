package application;
	
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Main extends Application {
	static AnchorPane root;//la fenetre principale
	static List <Pane> grid=new ArrayList<Pane>(); //grid est une pile de type d'objet de type Pane.
	private static int ind_c=0;
	private static String user="pap";
	@Override
	public void start(Stage primaryStage) {
	
		try {
		    root =(AnchorPane) FXMLLoader.load(getClass().getResource("/application/fond.fxml"));
			
			grid.add((Pane) FXMLLoader.load(getClass().getResource("/application/accueil.fxml")));//0
			grid.add((Pane) FXMLLoader.load(getClass().getResource("/application/parametres.fxml")));//1
			grid.add((Pane) FXMLLoader.load(getClass().getResource("/application/calendrier.fxml")));//2
			grid.add((Pane) FXMLLoader.load(getClass().getResource("/application/Evenement.fxml")));//3
			grid.add((Pane) FXMLLoader.load(getClass().getResource("/application/AjouterEvenement.fxml")));//4
			grid.add((Pane) FXMLLoader.load(getClass().getResource("/application/AjouterHoraire.fxml")));//5
		    grid.add((AnchorPane) FXMLLoader.load(getClass().getResource("../login/Accueil.fxml")));//6	
			grid.add((AnchorPane) FXMLLoader.load(getClass().getResource("../login/Inscription.fxml")));//7
			grid.add((AnchorPane) FXMLLoader.load(getClass().getResource("../login/Login.fxml")));//8
			grid.add((AnchorPane) FXMLLoader.load(getClass().getResource("../login/InscriptionError.fxml")));//9
			grid.add((AnchorPane) FXMLLoader.load(getClass().getResource("../login/LoginError.fxml")));//10
			
			root.getChildren().add(grid.get(6));
			Scene scene = new Scene(root,700,700);
			scene.getStylesheets().add(getClass().getResource("application.css" ).toExternalForm());
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("Projet focus");
			//primaryStage.getIcons().add(new Image("/src/resources/images/icon.png"));
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	//La méthode suivante n'est pas utilisée 
	public static Pane getPane(int ind){
		return grid.get(ind);
	}
	public static void setPane(int ind){
		root.getChildren().remove(grid.get(ind_c));
		root.getChildren().add(grid.get(ind));
		ind_c=ind;
	}
	public static String getUser() {
		return user;
	}
	public static void setUser(String u) {
		user = u;
	}
	public static void main(String[] args) {
		launch(args);
	}
	
}
