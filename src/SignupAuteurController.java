/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import connection.ConnectionUtils;
import java.sql.Statement;
/**
 * FXML Controller class
 *
 * @author Faty
 */
public class SignupAuteurController implements Initializable {

    @FXML
    private TextField prenom;
    @FXML
    private TextField nom;
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
      PreparedStatement preparedStmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
      preparedStmt.setString (1, nom.getText());
      preparedStmt.setString(2, mdp.getText());
      preparedStmt.setString (3, "auteur");
    
      // execute the preparedstatement
      preparedStmt.executeUpdate();
      
      
      ResultSet rs = preparedStmt.getGeneratedKeys();
      if(rs.next()){
      long id = rs.getLong(1);

      
      String query1 = " insert into auteur (nom, prenom, id_utilisateur)"
        + " values (?, ?, ?);";

      //create the mysql insert preparedstatement
      PreparedStatement preparedStmt1 = connection.prepareStatement(query1);
      preparedStmt1.setString (1, nom.getText());
      preparedStmt1.setString(2, prenom.getText());
      preparedStmt1.setInt (3, (int)id);
    
       
      // execute the preparedstatement
      preparedStmt1.execute();
      }
    }
}
    

    
  
