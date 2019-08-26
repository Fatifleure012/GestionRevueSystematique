import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

public class ShowArticleController implements Initializable{
	
	
	@FXML
    private Text text_id;

    @FXML
    private Text text_date;

  
    @FXML
    private Text text_titre;

 

    @FXML
    private TextArea text_abstrait;

    @FXML
    private Text text_doi;

    @FXML
    private TextArea text_idee;
    @FXML
    private TextArea text_Drive;
 @FXML
    private Text  text_Mot_clé;
	
	
	 @Override
	public void initialize(URL location, ResourceBundle resources) {
		 	
	}
	 
	 public void setData(Article article) {
		 
		
		 text_id.setText(article.getId()+"");
		 text_abstrait.setText(article.getAbstrait());
		 text_date.setText(article.getDate_publication() + "");
		 text_doi.setText(article.getDoi());
		 text_idee.setText(article.getIdee_principale());
		 text_titre.setText(article.getTitre());
		 text_Mot_clé.setText(article.getMot_cle());
                 text_Drive.setText(article.getDrive());
		
                 text_abstrait.setEditable(false);
		 text_idee.setEditable(false);
                 text_Drive.setEditable(false);
	}

}


