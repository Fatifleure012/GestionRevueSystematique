

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.mysql.jdbc.PreparedStatement;

import connection.ConnectionUtils;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class HomeController implements Initializable {
	
	@FXML
	private TextField user_name;
	
	@FXML
	private PasswordField password;
	
	private Connection connection = null;

	private PreparedStatement preparedStatement;
	

	@Override
	
	public void initialize(URL location, ResourceBundle resources) {
		if(connection == null) connection = ConnectionUtils.getConnection();
	}
	public void Signup(ActionEvent event) throws SQLException, IOException{
                      Parent home;
          home = FXMLLoader.load(getClass().getResource("/signup.fxml"));
          Scene scene = new Scene(home);
          
          Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
          stage.setScene(scene);
          stage.show();    
        }
            
            
        
	
	public void login(ActionEvent event) throws SQLException, IOException {
		
	
		
		String sql = "select * from utilisateur where nom = ?";
		preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
		
		String name = user_name.getText();
		preparedStatement.setString(1, name);
		
		String passw = password.getText();
		ResultSet resultSet = preparedStatement.executeQuery();
		
		if(!resultSet.next()) {
			System.out.println("no results");
		}else {
			int id 		= resultSet.getInt(1);
			String nom  = resultSet.getString(2);
			String pass = resultSet.getString(3);
			String role = resultSet.getString(4);
			
			if(pass.equals(passw)) {
				
				if(role.equals("utilisateur")) {
					Main.stage.setScene(Main.utilisateurEspaceScene);
					
				}else if(role.equals("auteur")) {
                                        Main.user_id = id;
					Main.stage.setScene(Main.HomeEspaceScene);
					
				}else if(role.equals("admin")) {
					Main.stage.setScene(Main.AdminEspaceScene);
					
				}
			}else {
				System.out.println("error password");
			}
		}
		
	}

}




