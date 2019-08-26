import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.mysql.jdbc.PreparedStatement;

import connection.ConnectionUtils;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
/**
 * FXML Controller class
 *
 * @author Faty
 */
public class CreerArticleController implements Initializable {

    @FXML
    private JFXTextField field_titre;
    @FXML
    private JFXTextField field_date_pub;
    @FXML
    private JFXTextField field_doi;
    @FXML
    private JFXTextField field_idee_principale;
    @FXML
    private JFXTextField field_id_journal;
    @FXML
    private JFXTextField field_id_conference;
    @FXML
    private JFXTextField field_abstrait;
     @FXML
    private JFXTextField field_url;
@FXML
    private JFXTextField field_Mot_Clé;
    @FXML
    private Text new_article;
    @FXML
    private Button save;
    @FXML
    private JFXButton logout;

     
    @FXML
    private JFXButton precedent;
    
    @FXML
    void precedent(ActionEvent event) throws IOException {
          Parent home;
          home = FXMLLoader.load(getClass().getResource("/auteur/homeAuteur.fxml"));
          Scene scene = new Scene(home);
          
          Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
          stage.setScene(scene);
          stage.show();
    }
    
     private Connection connection = null;

	 
	 private ObservableList<Article> articles;
		
	 private PreparedStatement preparedStatement;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        	if(connection == null) connection = ConnectionUtils.getConnection();
		
		

        
        save.setOnAction(e -> {
			try {
				
				saveArticle(readFields());
				
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		});
        
        logout.setOnAction(e -> {
			try {
				Main.stage.setScene(Main.loginScene);
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		});
		
        
    }  
    
public void saveArticle(Article article) throws SQLException {
    

		String request = "insert into article (titre ,date_publication ,doi , abstrait ,idee_principale ,id_journal ,id_conference,Mot_clé ,Drive) "
				+ "values (?, ?, ?, ?, ?, ?, ?, ? ,?);";
		preparedStatement = (PreparedStatement) connection.prepareStatement(request);
		
		java.sql.Date date = new java.sql.Date(article.getDate_publication().getTime());
	
		preparedStatement.setString(1, article.getTitre());
		preparedStatement.setDate(2, date);
		preparedStatement.setString(3, article.getDoi());
		preparedStatement.setString(4, article.getAbstrait());
	
		preparedStatement.setString(5, article.getIdee_principale());

		preparedStatement.setInt(6, article.getId_journal());
		
                preparedStatement.setInt(7, article.getId_conference());
                  preparedStatement.setString(8, article.getMot_cle());
                preparedStatement.setString(9, article.getDrive());
		preparedStatement.executeUpdate();
		
		
	
Connection con;
    java.sql.PreparedStatement ps;
    ResultSet rs;    

     
        try {
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sms","root","");
            JOptionPane.showMessageDialog(null,"article bien ajouté");
        } catch  (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex);
            Logger.getLogger(CreerArticleController.class.getName()).log(Level.SEVERE, null, ex);
             
             
            
        }
   
    

}

public Article readFields() {
		Article article = new Article();
		
		article.setAbstrait(field_abstrait.getText());
		article.setDate_publication(new Date(field_date_pub.getText()));
		article.setDoi(field_doi.getText());
	
		article.setId_conference(Integer.parseInt(field_id_conference.getText()));
		article.setIdee_principale(field_idee_principale.getText());

		article.setTitre(field_titre.getText());
		article.setId_journal(Integer.parseInt(field_id_journal.getText()));
		article.setDrive(field_url.getText());
                article.setMot_cle(field_Mot_Clé.getText());
		return article;
	}

   


}
