package application;

public class Evenement {
		public int user_id;
		public String titre;
		
		public Evenement(String titre) {
			this.titre=titre;
			//this.description=desc;
		}

		public void SetUser_id(int id) {
			this.user_id=id;
		}
		
		public void SetTitre(String titre) {
			this.titre=titre;
		}
		
		/*public void SetDescription(String desc) {
			this.description=desc;
		}*/
		@Override
		public String toString() {
			return this.titre;
		}
}
