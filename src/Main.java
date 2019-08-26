import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
    
	public static Stage stage;
	public static Scene loginScene;
	public static Scene utilisateurEspaceScene;
	public static Scene AuteurEspaceScene;
	public static Scene AdminEspaceScene; 
        public static Scene HomeEspaceScene; 
        public static FXMLLoader auteurLoader;
                
	public static final double WIDTH =700;
	public static final double HEIGHT = 560;
        public static int user_id;
        
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;
		primaryStage.setTitle("revue systematique");
		
		loadScenes();
		
		stage.setScene(loginScene);
		stage.show();
	}
	
	
	
	public void loadScenes() throws IOException {
		
                auteurLoader =new FXMLLoader(getClass().getResource("/auteur/AuteurInterface.fxml"));
		Parent loginRoot = FXMLLoader.load(getClass().getResource("LoginDesign.fxml"));
		Parent utilisateurEspaceRoot = FXMLLoader.load(getClass().getResource("/utilisateur/UtilisateurInterface.fxml"));
		Parent HomeEspaceRoot = FXMLLoader.load(getClass().getResource("/auteur/home1.fxml"));
                Parent AuteurEspaceRoot = auteurLoader.load();//
		//Parent AdminEspaceRoot = FXMLLoader.load(getClass().getResource("/admin/AdminInterface.fxml"));
		
		loginScene 			   = new Scene(loginRoot, WIDTH, HEIGHT);
		utilisateurEspaceScene = new Scene(utilisateurEspaceRoot, WIDTH, HEIGHT);
		HomeEspaceScene      = new Scene(HomeEspaceRoot, WIDTH, HEIGHT);//
		//AdminEspaceScene 	   = new Scene(AdminEspaceRoot, WIDTH, HEIGHT);
		AuteurEspaceScene = new Scene(AuteurEspaceRoot, WIDTH, HEIGHT);
		
		loginScene.getStylesheets().add("style.css");
		utilisateurEspaceScene.getStylesheets().add("style.css");
		HomeEspaceScene.getStylesheets().add("style.css");//
		//AdminEspaceScene.getStylesheets().add("style.css");
                AuteurEspaceScene.getStylesheets().add("style.css");
	}
        
        public static void loadSceneAuteur(int id) throws IOException {
            user_id = id;
            Parent AuteurEspaceRoot = auteurLoader.load();
            Home1Controller cont = auteurLoader.getController();                                
            AuteurEspaceScene      = new Scene(AuteurEspaceRoot, WIDTH, HEIGHT);
            AuteurEspaceScene.getStylesheets().add("style.css");
            Main.stage.setScene(Main.AuteurEspaceScene);
        }

}