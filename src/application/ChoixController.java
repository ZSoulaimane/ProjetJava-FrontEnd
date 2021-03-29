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

public class ChoixController {
	   @FXML
	    private Button btn_prof;
	   @FXML
	    private Button btn_adm;
	   @FXML
	    private Button btn_elev;
	   @FXML
	    private Button btn_par;
	   @FXML
	    private ImageView Close;
	   private Stage stage;
	    private Scene scene;
	    private Parent root;
	    
	    
	    public void switchToLogin(ActionEvent event) throws IOException {
	     root = FXMLLoader.load(getClass().getResource("Login.fxml"));
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
	    
}
