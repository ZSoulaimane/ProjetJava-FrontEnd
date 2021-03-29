package application;

import java.io.IOException;

import classProjet.Admin;
import classProjet.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import projectClientRequest.UserRequests;

public class LoginController {
	
	private UserRequests userRequests = new UserRequests(); 
	
	 @FXML
	 private Button btn_retour;
	 @FXML
	 private Button btn_login;
	  @FXML
	    private Label erreur;

	    @FXML
	    private ImageView Close;
	    @FXML
	    private TextField EmailTextField;
	    @FXML
	    private PasswordField PasswordTextField;
	  
	    private Stage stage;
	    private Scene scene;
	    private Parent root;
	    
	    public void switchToChoix(ActionEvent event) throws IOException {
	     root = FXMLLoader.load(getClass().getResource("/application/Choix.fxml"));
	     stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	     scene = new Scene(root);
	     stage.setScene(scene);
	     stage.show();
	    }
	    @FXML
	    public void Close(MouseEvent mouseEvent) {
	        Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
	        stage.close();
	    }
	    @FXML
	    public void Minus(MouseEvent mouseEvent) {
	        Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
	        stage.setIconified(true);
	    }
	    @FXML
	    void LoginAction(ActionEvent event) throws IOException {
	        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
	        Login(stage);
	 
	    }
	    
	    void Login(Stage primaryStage) throws IOException {
	        String userName = EmailTextField.getText();
	        String pass = PasswordTextField.getText();
	        String role = "admin";
	        
	        User user = new User(userName,pass,"",role);
	        Admin admin = userRequests.getUser(user);
	        
            if(! admin.equals(null)) {
                Parent root = FXMLLoader.load(getClass().getResource("Profiladm.fxml"));
                Scene adminScene = new Scene(root);
                primaryStage.setScene(adminScene);
                primaryStage.getScene().setFill(Color.TRANSPARENT);
            
            } else 
            	erreur.setText("Incorrect Password");
	    }
}
