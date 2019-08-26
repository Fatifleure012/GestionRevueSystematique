/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.jfoenix.controls.JFXButton;
import connection.ConnectionUtils;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
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
public class SignupController implements Initializable {
    @FXML
    private JFXButton chercheur;

    @FXML
    private JFXButton auteur;
    private Connection connection = null;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if(connection == null) connection = ConnectionUtils.getConnection();
        
    }    

    @FXML
    private void auteur(ActionEvent event) throws IOException {
          Parent home;
          home = FXMLLoader.load(getClass().getResource("/signupAuteur.fxml"));
          Scene scene = new Scene(home);
          
          Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
          stage.setScene(scene);
          stage.show();
   
    }
    
@FXML
    void chercheur(ActionEvent event) throws IOException {
          Parent home;
          home = FXMLLoader.load(getClass().getResource("/signupUtilisateur.fxml"));
          Scene scene = new Scene(home);
          
          Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
          stage.setScene(scene);
          stage.show();
    }

}
