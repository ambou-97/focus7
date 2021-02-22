package login;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import application.Emploi_du_temps;
import application.Evenement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;

public class MysqlConnect {
	 Connection conn = null;
	    public static Connection ConnectDb(){
	    
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ugesm","root","");
	            //JOptionPane.showMessageDialog(null, "Connection Established");
	            return conn;
	        } catch (Exception e) {
	            JOptionPane.showMessageDialog(null, e);
	            return null;
	   }
	}
	    public static ObservableList<Evenement> getDataEvenement(){
			Connection conn = ConnectDb();
			String sql = "select titre from evenement";
			ObservableList<Evenement> list = FXCollections.observableArrayList();
			try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					list.add(new Evenement(rs.getString("titre")));
				}
			} catch(Exception e) {
				
			}
			return list;
		}
		
		public static ObservableList<Emploi_du_temps> getDataEmploi_du_temps(){
			Connection conn = ConnectDb();
			String sql = "select horaire, titre from emploi_du_temps";
			ObservableList<Emploi_du_temps> list = FXCollections.observableArrayList();
			try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					list.add(new Emploi_du_temps(rs.getString("horaire"),rs.getString("titre")));
					//System.out.println(rs.getString("titre"));
				}
			} catch(Exception e) {
				
			}
			return list;
		}

}
