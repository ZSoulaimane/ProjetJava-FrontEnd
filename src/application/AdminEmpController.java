package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AdminEmpController {
	  @FXML
	    private Button btn1;

	    @FXML
	    private Button btn2;

	    @FXML
	    private Button btn3;

	    @FXML
	    private Button btn4;

	    @FXML
	    private Button btn5;

	    @FXML
	    private Button btn6;
	  


	    @FXML
	    private ImageView Close;
	    @FXML
	    private Stage stage;
	    private Scene scene;
	    private Parent root;
	    public void logOut(MouseEvent  event) throws IOException {
		     root = FXMLLoader.load(getClass().getResource("Choix.fxml"));
		     stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		     scene = new Scene(root);
		     stage.setScene(scene);
		     stage.show();}
	    
	    public void switchToAccueil(ActionEvent event) throws IOException {
		     root = FXMLLoader.load(getClass().getResource("/application/Profiladm.fxml"));
		     stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		     scene = new Scene(root);
		     stage.setScene(scene);
		     stage.show();
		    }
	    
	
	    public void switchToElev(ActionEvent event) throws IOException {
	        root = FXMLLoader.load(getClass().getResource("/application/AdminElev.fxml"));
	        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	        scene = new Scene(root);
	        stage.setScene(scene);
	        stage.show();
	       }
	    public void switchToClas(ActionEvent event) throws IOException {
	        root = FXMLLoader.load(getClass().getResource("/application/AdminClas.fxml"));
	        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	        scene = new Scene(root);
	        stage.setScene(scene);
	        stage.show();
	       }
	    public void switchToEns(ActionEvent event) throws IOException {
	        root = FXMLLoader.load(getClass().getResource("/application/AdminEns.fxml"));
	        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	        scene = new Scene(root);
	        stage.setScene(scene);
	        stage.show();
	       }
	    public void switchToMssg(ActionEvent event) throws IOException {
	        root = FXMLLoader.load(getClass().getResource("/application/AdminMssg.fxml"));
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
	    public void switchToEmploi(ActionEvent event) throws IOException {
	        root = FXMLLoader.load(getClass().getResource("/application/emploi.fxml"));
	        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	        scene = new Scene(root);
	        stage.setScene(scene);
	        stage.show();

	
}
	    }