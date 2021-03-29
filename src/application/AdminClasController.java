package application;

import java.io.IOException;

import classProjet.Classe;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;
import projectClientRequest.ClasseRequests;

public class AdminClasController {
	
	private ClasseRequests classeRequests = new ClasseRequests();
	
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
	    @FXML private Stage stage;
	    private Scene scene;
	    private Parent root;
	    public void logOut(MouseEvent  event) throws IOException {
		     root = FXMLLoader.load(getClass().getResource("Choix.fxml"));
		     stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		     scene = new Scene(root);
		     stage.setScene(scene);
		     stage.show();
	    }
	    public void switchToAccueil(ActionEvent event) throws IOException {
		     root = FXMLLoader.load(getClass().getResource("Profiladm.fxml"));
		     stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		     scene = new Scene(root);
		     stage.setScene(scene);
		     stage.show();
		    }
	    
	
	    public void switchToElev(ActionEvent event) throws IOException {
	        root = FXMLLoader.load(getClass().getResource("AdminElev.fxml"));
	        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	        scene = new Scene(root);
	        stage.setScene(scene);
	        stage.show();
	       }
	    public void switchToEns(ActionEvent event) throws IOException {
	        root = FXMLLoader.load(getClass().getResource("AdminEns.fxml"));
	        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	        scene = new Scene(root);
	        stage.setScene(scene);
	        stage.show();
	       }
	    public void switchToEmp(ActionEvent event) throws IOException {
	        root = FXMLLoader.load(getClass().getResource("AdminEmp.fxml"));
	        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	        scene = new Scene(root);
	        stage.setScene(scene);
	        stage.show();
	       }
	    public void switchToMssg(ActionEvent event) throws IOException {
	        root = FXMLLoader.load(getClass().getResource("AdminMssg.fxml"));
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
	    private TableView<Classe> tableView;

		@FXML
	    private TableColumn<Classe, Integer> IdClasseColumn;
	    @FXML
	    private TableColumn<Classe, String> NomClasseColumn;
	    @FXML
	    private TableColumn<Classe, String> NiveauColumn;
	    @FXML
	    private TableColumn<Classe, Double> MoyenneColumn;
	    
	    
	    public void initialize() {
	    	//set up the columns in the table
	    	IdClasseColumn.setCellValueFactory(new PropertyValueFactory<Classe,Integer>("idC"));
	    	NomClasseColumn.setCellValueFactory(new PropertyValueFactory<Classe,String>("nomC"));
	    	NiveauColumn.setCellValueFactory(new PropertyValueFactory<Classe,String>("niveau"));
	    	MoyenneColumn.setCellValueFactory(new PropertyValueFactory<Classe,Double>("moyenne"));
	    	
	    	//load some data
	    	tableView.setItems(getClasses());
	    	
	    	tableView.setEditable(true);
	    	MoyenneColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
	    }
	    
	    public ObservableList<Classe> getClasses(){
			
	    	return classeRequests.getClasses();
	    }
	    
	    public void changeMoyenneCellEvent(CellEditEvent edditedCell) {
	    	Classe classe = tableView.getSelectionModel().getSelectedItem();
            classe.setSalle(edditedCell.getNewValue().toString());    	
            
            classeRequests.putClasse(classe);
	    }
	   
	
	
}
