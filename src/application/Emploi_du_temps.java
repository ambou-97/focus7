package application;

public class Emploi_du_temps {
	public int user_id;
	public String horaire, titre;
	
	public Emploi_du_temps(String horaire, String titre) {
		this.horaire=horaire;
		this.titre=titre;
	}

	public void setUser_id(int id) {
		this.user_id=id;
	}
	
	public void SetHoraire(String horaire) {
		this.horaire=horaire;
	}
	
	public void SetTitre(String titre) {
		this.titre=titre;
	}
	
	public String getHoraire() {
		return this.horaire;
	}
	
	public String getTitre() {
		return this.titre;
	}
	
	

}
