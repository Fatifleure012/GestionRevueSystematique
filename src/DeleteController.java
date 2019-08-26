import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetImpl;

import connection.ConnectionUtils;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class DeleteController implements Initializable{

	@FXML
	private TableView<Article> table;																																																																																																																																												
	@FXML 
	private TableColumn<Article, Integer> id;
	
	@FXML 
	private TableColumn<Article, Date> date_publication;
	@FXML 
	private TableColumn<Article, String> titre;
	
	@FXML 
	private TableColumn<Article, String> idee_principale;
	@FXML 
	private TableColumn<Article, Integer> id_journal;
	@FXML 
        private TableColumn<Article, Integer> id_conference;
	
        @FXML 
	private TableColumn<Article, String> doi;
        @FXML 
	private TableColumn<Article, String> abstrait;
        @FXML
        private TableColumn<Article, String> Drive;
@FXML
        private TableColumn<Article, String> Mot_clé;
        
   
	    
	 @FXML
	 private JFXButton logout;
	   @FXML
           private JFXButton precedent ;
           
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
    @FXML
    private AnchorPane root;
        @FXML
    private JFXButton delete;
   
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		if(connection == null) connection = ConnectionUtils.getConnection();
		
		
		
		

		id.setCellValueFactory(new PropertyValueFactory<Article, Integer>("id"));
		
		titre.setCellValueFactory(new PropertyValueFactory<Article, String>("titre"));
		date_publication.setCellValueFactory(new PropertyValueFactory<Article, Date>("date_publication"));
		doi.setCellValueFactory(new PropertyValueFactory<Article, String>("doi"));
		abstrait.setCellValueFactory(new PropertyValueFactory<Article, String>("abstrait"));
		
		idee_principale.setCellValueFactory(new PropertyValueFactory<Article, String>("idee_principale"));
		id_conference.setCellValueFactory(new PropertyValueFactory<Article, Integer>("id_conference"));
		id_journal.setCellValueFactory(new PropertyValueFactory<Article, Integer>("id_journal"));
		Drive.setCellValueFactory(new PropertyValueFactory<Article, String>("Drive"));
		Mot_clé.setCellValueFactory(new PropertyValueFactory<Article, String>("Mot_clé"));
			
		//table.setItems(articles);
		try {
			loadArticles();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		delete.setOnAction(e -> {
			try {
				Integer id = table.getSelectionModel().getSelectedItem().getId();
				deleteArticle(id);
				loadArticles();
			}catch (Exception exception) {
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
	
	
	
	public void deleteArticle(Integer id) throws SQLException {
                String request = "delete from article_auteur where id_article = ?";
		preparedStatement = (PreparedStatement) connection.prepareStatement(request);
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();
            
	
	}
        
         @FXML
    void logout(ActionEvent event) {

    }
        @FXML
        void delete(ActionEvent event) {

    }
        

	
	
	public void loadArticles() throws SQLException {
		ObservableList<Article> articles = FXCollections.observableArrayList();
		
		
		String request = "select a.* from article a, article_auteur, auteur aut where a.id = id_article and id_auteur = aut.id and id_utilisateur = ? " ;
                preparedStatement = (PreparedStatement) connection.prepareStatement(request);
		preparedStatement.setInt(1, Main.user_id);
		
		ResultSet resultSet = preparedStatement.executeQuery();
		while(resultSet.next()) {
			Article article = new Article();

			article.setId(resultSet.getInt(1));
			//article.setNum_ordre(resultSet.getInt(2));
			article.setTitre(resultSet.getString(2));
			article.setDate_publication(resultSet.getDate(3));
			article.setDoi(resultSet.getString(4));
			article.setAbstrait(resultSet.getString(5));
			//article.setEvaluation_qualite(resultSet.getInt(7));
			article.setIdee_principale(resultSet.getString(6));
		//	article.setSolution(resultSet.getString(9));
			article.setId_journal(resultSet.getInt(7));
			article.setId_conference(resultSet.getInt(8));
			article.setDrive(resultSet.getString(9));
			article.setMot_cle(resultSet.getString(9));
                        
                        System.out.println(article.getId());
			articles.add(article);
		}
		
		table.setItems(articles);
	}
	
	

}