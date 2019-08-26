import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;

import com.mysql.jdbc.PreparedStatement;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
    

import connection.ConnectionUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class UtilisateurController implements Initializable{
	
	

	    @FXML
	    private Button logout;

	    @FXML
	    private ChoiceBox<String> rechercher_par;

	    @FXML
	    private Button chercher;

	    @FXML
	    private TableView<Article> table;

	    @FXML
	    private TableColumn<Article, Integer> id;

	 

	    @FXML
	    private TableColumn<Article, String> titre;

	    @FXML
	    private TableColumn<Article, Date> date_publication;

	    @FXML
	    private TableColumn<Article, String> doi;

	    @FXML
	    private TableColumn<Article, String> abstrait;



	    @FXML
	    private TableColumn<Article, String> idee_principale;

	    @FXML
	    private TableColumn<Article, Integer> id_journal;

	    @FXML
	    private TableColumn<Article, Integer> id_conference;
	     @FXML
	    private TableColumn<Article, String> Drive;
	    
	    
	    @FXML
	    private TextField valeur;

	private Connection connection = null;
	
	private PreparedStatement preparedStatement;
    @FXML
    private AnchorPane root;
 
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
	 
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		


		id.setCellValueFactory(new PropertyValueFactory<Article, Integer>("id"));
	//	num_ordre.setCellValueFactory(new PropertyValueFactory<Article, Integer>("num_ordre"));
		titre.setCellValueFactory(new PropertyValueFactory<Article, String>("titre"));
		date_publication.setCellValueFactory(new PropertyValueFactory<Article, Date>("date_publication"));
		doi.setCellValueFactory(new PropertyValueFactory<Article, String>("doi"));
		abstrait.setCellValueFactory(new PropertyValueFactory<Article, String>("abstrait"));
	//	evaluation_qualite.setCellValueFactory(new PropertyValueFactory<Article, Integer>("evaluation_qualite"));
		idee_principale.setCellValueFactory(new PropertyValueFactory<Article, String>("idee_principale"));
		id_conference.setCellValueFactory(new PropertyValueFactory<Article, Integer>("id_conference"));
		id_journal.setCellValueFactory(new PropertyValueFactory<Article, Integer>("id_journal"));
		Drive.setCellValueFactory(new PropertyValueFactory<Article, String>("Drive"));

		
		rechercher_par.getSelectionModel().select("titre");
                		
             //   rechercher_par.getSelectionModel().select("Mot cle");                            
		
		rechercher_par.getItems().add("titre");
		//rechercher_par.getItems().add("Mot cle");
		if(connection == null) connection = ConnectionUtils.getConnection();
		
		logout.setOnAction(e -> {
			try {
				Main.stage.setScene(Main.loginScene);
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		});
		
		chercher.setOnAction(e -> {
			try {
				String selected = rechercher_par.getSelectionModel().getSelectedItem();
				String value   = valeur.getText();
				if(selected != null && value != null) {
					parTitre(value);
                                       
				}
			} catch (Exception exception) {
				exception.printStackTrace();
			}
               /*   try {
				String selected = rechercher_par.getSelectionModel().getSelectedItem();
				String valu   = valeur.getText();
				if(selected != null && valu != null) {
					ParMot_cle(valu);
                                       
				}
			} catch (Exception exception) {
				exception.printStackTrace();
			}*/
                        
                        
		});
		
		table.setOnMouseClicked(e -> {
			if(e.getClickCount() == 2) {
				Article article = table.getSelectionModel().getSelectedItem();
				if(article != null) {
					try {
						FXMLLoader loader = new FXMLLoader(getClass().getResource("ShowArticle.fxml"));
						Parent loginRoot = loader.load();
						
						ShowArticleController showArticle = loader.getController();
						showArticle.initialize(null,null);
						showArticle.setData(article);
						
						Stage stage = new Stage();
						stage.setScene(new Scene(loginRoot));	
						stage.show();
						
					} catch (IOException e1) {
						e1.printStackTrace();
					}

				}
			}
		});

		
		
	}
	
	
	public void parTitre(String titre) throws SQLException{
		ObservableList<Article> articles = FXCollections.observableArrayList();
		
		String request = "Select * from article where titre = ?";
		preparedStatement = (PreparedStatement) connection.prepareStatement(request);
		preparedStatement.setString(1, titre);
		preparedStatement.executeQuery();
		
		
		
		ResultSet resultSet = preparedStatement.executeQuery();
		while(resultSet.next()) {
			Article article = new Article();

			article.setId(resultSet.getInt(1));
			article.setTitre(resultSet.getString(2));
			article.setDate_publication(resultSet.getDate(3));
			article.setDoi(resultSet.getString(4));
			article.setAbstrait(resultSet.getString(5));
	
			article.setIdee_principale(resultSet.getString(6));
	
			article.setId_journal(resultSet.getInt(7));
			article.setId_conference(resultSet.getInt(8));
			
			
			articles.add(article);
		}
		System.out.println(articles.size());
		table.setItems(articles);
	}
	
        
      
/*

     public void ParMot_cle(String Mot_clé) throws SQLException{
		ObservableList<Article> articles = FXCollections.observableArrayList();
		
		String request = "Select * from article where Mot_clé = ?";
		preparedStatement = (PreparedStatement) connection.prepareStatement(request);
		preparedStatement.setString(1, Mot_clé);
		preparedStatement.executeQuery();
		
		
		
		ResultSet resultSet = preparedStatement.executeQuery();
		while(resultSet.next()) {
			Article article = new Article();

			article.setId(resultSet.getInt(1));
			article.setTitre(resultSet.getString(2));
			article.setDate_publication(resultSet.getDate(3));
			article.setDoi(resultSet.getString(4));
			article.setAbstrait(resultSet.getString(5));
	
			article.setIdee_principale(resultSet.getString(6));
	
			article.setId_journal(resultSet.getInt(7));
			article.setId_conference(resultSet.getInt(8));
			article.setMot_cle(resultSet.getString(9));
			
                        article.setDrive(resultSet.getString(10));
                        
			articles.add(article);
		}
		System.out.println(articles.size());
		table.setItems(articles);
	}
*/
}


