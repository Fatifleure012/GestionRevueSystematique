/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auteur;

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
public class HomeAuteurController implements Initializable {

    @FXML
    private JFXButton ajouter;
    @FXML
    private JFXButton modifier;
    @FXML
    private JFXButton supprimer;
    @FXML
    private JFXButton logout;
    @FXML
    private JFXButton precedent; 
    @FXML
    private JFXButton voir;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouter(ActionEvent event) throws IOException {

          Parent home;
          home = FXMLLoader.load(getClass().getResource("/auteur/creerArticle.fxml"));
          Scene scene = new Scene(home);
          
          Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
          stage.setScene(scene);
          stage.show();
    }
        
     @FXML
    void voir(ActionEvent event) throws IOException {
          Parent home;
          home = FXMLLoader.load(getClass().getResource("/auteur/AuteurInterface.fxml"));
          Scene scene = new Scene(home);
          
          Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
          stage.setScene(scene);
          stage.show();
    }

    @FXML
    private void modifier(ActionEvent event) throws IOException {
     Parent home;
          home = FXMLLoader.load(getClass().getResource("/auteur/update.fxml"));
          Scene scene = new Scene(home);
          
          Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
          stage.setScene(scene);
          stage.show();
    }

    @FXML
    private void supprimer(ActionEvent event) throws IOException {
        Parent home;
          home = FXMLLoader.load(getClass().getResource("/auteur/delete.fxml"));
          Scene scene = new Scene(home);
          
          Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
          stage.setScene(scene);
          stage.show();
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

    @FXML
    private void precedent(ActionEvent event) throws IOException {
         Parent home;
          home = FXMLLoader.load(getClass().getResource("/auteur/home1.fxml"));
          Scene scene = new Scene(home);
          
          Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
          stage.setScene(scene);
          stage.show();    
    
    }
    
}
