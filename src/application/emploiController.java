package application;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;



public class emploiController {
	  
    private Stage stage;
    private Scene scene;
    private Parent root;
    
	  @FXML
	    private Button brtnr;
	  @FXML
	    private Button btn;

	    @FXML
	    private ImageView clo;
	   
	    @FXML
	    private ImageView emploiView;

	    @FXML
	    private ImageView muns;
	    @FXML
	    private FileChooser fileChooser;
	    private File filePath;
	    private Image image;
	    private  BufferedImage bufferedImage;
	    public Image getImage(){ return this.image; }
	    public void setImage(Image image) { this.image= image; }

	    void initialize() {
	        try {
	            bufferedImage = ImageIO.read(new File("/Images/emploi.png")) ;
	            Image image = SwingFXUtils.toFXImage(bufferedImage,null) ;
	            this.setImage(image);
	            emploiView.setImage(this.getImage());
	        } catch(IOException e){
	            e.printStackTrace();
	        }    }
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
	    void modifyTimeTable(ActionEvent event) {
	        Stage primaryStage = (Stage)((Node) event.getSource()).getScene().getWindow();
	         fileChooser = new FileChooser() ;
	        fileChooser.setTitle("open image") ;
	        //set to user�s directory or go to the default C drive if cannot access
	        File adminDirectory = new File(".") ;
	        fileChooser.setInitialDirectory(adminDirectory) ;
	        this.filePath = fileChooser.showOpenDialog(primaryStage) ;
	        try {
	            FileUtils.copyFile(this.filePath, new File("/Images/emploi.png"));
	            initialize();
	        } catch(IOException e){
	            e.printStackTrace();
	        }
	    }
	    
	    
	    public void switchToAdminEmp(ActionEvent event) throws IOException {
		     root = FXMLLoader.load(getClass().getResource("/application/AdminEmp.fxml"));
		     stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		     scene = new Scene(root);
		     stage.setScene(scene);
		     stage.show();
		    }
	    }
