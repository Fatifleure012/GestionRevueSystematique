import java.util.Date;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Button;

public class Article {

	private Integer id;

	private String  titre;
	private Date    date_publication;
	private String doi;
	private String  abstrait;
	
	private String  idee_principale;
	
	private Integer id_journal;
	private Integer id_conference;
        private String Drive;
        private String Mot_cle;
        private Button button;

    public void setMot_cle(String Mot_cle) {
        this.Mot_cle = Mot_cle;
    }

    public String getMot_cle() {
        return Mot_cle;
    }
        
        
        
        
        
      /*      Article (Integer id, String titre, Date date_publication, String doi, String abstrait, String idee_principale,Integer id_journal,Integer id_conference, Button button ) {
				this.id = new SimpleIntegerProperty(id);
				this.titre = new SimpleStringProperty(titre);
				this.titre = new SimpleStringProperty(fxidtitre);
				this.titre = new SimpleStringProperty(fxidtitre);
				this.titre = new SimpleStringProperty(fxidtitre);
				this.titre = new SimpleStringProperty(fxidtitre);
				this.titre = new SimpleStringProperty(fxidtitre);
				this.titre = new SimpleStringProperty(fxidtitre);
				this.titre = new SimpleStringProperty(fxidtitre);
				this.button = new Button("Pdf");
                                
                  }
*/
        
        
        
	
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	public String getTitre() {
		return titre;
	}
	
	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	public Date getDate_publication() {
		return date_publication;
	}
	
	public void setDate_publication(Date date_publication) {
		this.date_publication = date_publication;
	}
	
	public String getDoi() {
		return doi;
	}
	
	public void setDoi(String doi) {
		this.doi = doi;
	}
	
	public String getAbstrait() {
		return abstrait;
	}
	
	public void setAbstrait(String abstrait) {
		this.abstrait = abstrait;
	}
	
	
	
	public String getIdee_principale() {
		return idee_principale;
	}
	
	public void setIdee_principale(String idee_principale) {
		this.idee_principale = idee_principale;
	}
	
	public Integer getId_journal() {
		return id_journal;
	}
	public void setId_journal(Integer id_journal) {
		this.id_journal = id_journal;
	}
	public Integer getId_conference() {
		return id_conference;
	}
	public void setId_conference(Integer id_conference) {
		this.id_conference = id_conference;
	}

      public String getDrive() {
		return Drive;
	}
	
	public void setDrive(String Drive) {
		this.Drive = Drive;
	}
	
	
}


