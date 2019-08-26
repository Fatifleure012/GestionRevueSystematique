/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Faty
 */
public class Home1Controller implements Initializable {

    @FXML
    private JFXButton chercher;
    @FXML
    private JFXButton ome;
    @FXML
    private JFXButton logout;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void chercher(ActionEvent event)  throws IOException {

        Parent home;
        home = FXMLLoader.load(getClass().getResource("/utilisateur/UtilisateurInterface.fxml"));
          Scene scene = new Scene(home);
          
          Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
          stage.setScene(scene);
          stage.show();
    
    }

    @FXML
    private void ome(ActionEvent event)  throws IOException {

        Parent home;
        home = FXMLLoader.load(getClass().getResource("/auteur/homeAuteur.fxml"));
          Scene scene = new Scene(home);
          
          Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
          stage.setScene(scene);
          stage.show();
         // Main.stage.setScene(Main.AuteurEspaceScene);
          
    }
    
    

    @FXML
    private void logout(ActionEvent event) throws IOException {
  
          Parent home;
          home = FXMLLoader.load(getClass().getResource("/LoginDesign.fxml"));
          Scene scene = new Scene(home);
          
          Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
          stage.setScene(scene);
          stage.show();    
    
    }
    
}
