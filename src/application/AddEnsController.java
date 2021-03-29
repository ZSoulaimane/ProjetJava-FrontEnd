package application;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;

import classProjet.Enseignant;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import projectClientRequest.EnseignantRequests;

public class AddEnsController {
	
	private EnseignantRequests enseignantRequests;

    @FXML
    private Button sel;
	  private FileChooser fileChooser;
	    private File filePath;
	    private Image image;
	    private  BufferedImage bufferedImage;
	    public Image getImage(){ return this.image; }
	    public void setImage(Image image) { this.image= image; }
	    @FXML
	    private ImageView ensView;
	
	    @FXML
	    private TextField NomTextField;

	    @FXML
	    private TextField PrenomTextField;

	    @FXML
	    private TextField EmailTextField;

	    @FXML
	    private TextField DateDeNaiTextField;
	    
	    @FXML
	    private ChoiceBox<String> choiceBox;


	    @FXML
	    private ImageView Close;
	    
	    @FXML
	    private Button btn1;
	    
	    @FXML 
	    private Stage stage;
	    private Scene scene;
	    private Parent root;
	    @FXML
	    void initialize() {

	        choiceBox.getItems().add("Francais");
	        choiceBox.getItems().add("Arabe");
	        choiceBox.getItems().add("Mathematique");
	        choiceBox.getItems().add("Sport");
	        choiceBox.getItems().add("Indications islamiques");
	        
	    }

	    @FXML
	    void Close(MouseEvent mouseEvent) {
	    	Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
	        stage.close();

	    }

	    @FXML
	    void Minus(MouseEvent mouseEvent) {
	    	Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
	        stage.setIconified(true);

	    }
	    @FXML
	    void AddAction(ActionEvent event) throws IOException {
	    	
	    	enseignantRequests = new EnseignantRequests();
	        Enseignant ens = new Enseignant(NomTextField.getText(),
	        		PrenomTextField.getText(), EmailTextField.getText(),
	        		choiceBox.getValue(),
	        		LocalDate.parse(DateDeNaiTextField.getText()),0,0);
	        enseignantRequests.addEnseignant(ens);
	       // connexion avec base de donnees
	       switchToAdminEns(event);
	    }

	    
	    @FXML
	    public void switchToAdminEns(ActionEvent event) throws IOException {
	        root = FXMLLoader.load(getClass().getResource("/application/AdminEns.fxml"));
	        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	        scene = new Scene(root);
	        stage.setScene(scene);
	        stage.show();
	       }

	 

	    void Initialize() {
	        try {
	            bufferedImage = ImageIO.read(new File("/Images/JJe.jpg")) ;
	            Image image = SwingFXUtils.toFXImage(bufferedImage,null) ;
	            this.setImage(image);
	            ensView.setImage(this.getImage());
	        } catch(IOException e){
	            e.printStackTrace();
	        } 
	        }
	    @FXML
	    void SelectionnerImage(ActionEvent event) {
	        Stage primaryStage = (Stage)((Node) event.getSource()).getScene().getWindow();
	        fileChooser = new FileChooser() ;
	        fileChooser.setTitle("open image") ;
	        //set to user�s directory or go to the default C drive if cannot access
	        File adminDirectory = new File(".") ;
	        fileChooser.setInitialDirectory(adminDirectory) ;
	        this.filePath = fileChooser.showOpenDialog(primaryStage) ;
	        try {
	            FileUtils.copyFile(this.filePath, new File("/Images/JJe.jpg"));
	            Initialize();
	        } catch(IOException e){
	            e.printStackTrace();
	        }
	    }
	}

