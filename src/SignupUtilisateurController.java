/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import connection.ConnectionUtils;
/**
 * FXML Controller class
 *
 * @author Faty
 */
public class SignupUtilisateurController implements Initializable {

    @FXML
    private TextField userName;
    @FXML
    private TextField mdp;

    private Connection connection = null;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       if(connection == null) connection = ConnectionUtils.getConnection();

    }    

    @FXML
    private void signUp(ActionEvent event) throws SQLException {
        String query = " insert into utilisateur (nom, password, role)"
        + " values (?, ?, ?);";

      //create the mysql insert preparedstatement
      PreparedStatement preparedStmt = connection.prepareStatement(query);
      preparedStmt.setString (1, userName.getText());
      preparedStmt.setString(2, mdp.getText());
      preparedStmt.setString (3, "utilisateur");
    
       
      // execute the preparedstatement
      preparedStmt.execute();
    }
    
}
