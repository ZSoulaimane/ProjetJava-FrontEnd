package application;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;

import classProjet.Etudiant;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;
import projectClientRequest.EtudiantRequests;

public class AdminElevController {
	
	private EtudiantRequests etudiantRequests = new EtudiantRequests();
	
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
	    private Button btn7;
	    
	    @FXML
	    private Button btn8;

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
	    
	    public void switchToAddE(ActionEvent event) throws IOException {
		     root = FXMLLoader.load(getClass().getResource("AddEleve.fxml"));
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
	    
	    public void switchToEns(ActionEvent event) throws IOException {
	     root = FXMLLoader.load(getClass().getResource("AdminEns.fxml"));
	     stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	     scene = new Scene(root);
	     stage.setScene(scene);
	     stage.show();
	    }
	    public void switchToClas(ActionEvent event) throws IOException {
	        root = FXMLLoader.load(getClass().getResource("AdminClas.fxml"));
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
	    private TableView<Etudiant> tableView;

	    @FXML
	    private TableColumn<Etudiant, Integer> IdEColumn;

	    @FXML
	    private TableColumn<Etudiant, String> NomColumn;

	    @FXML
	    private TableColumn<Etudiant, String> PrenomColumn;

	    @FXML
	    private TableColumn<Etudiant, LocalDate> DateDeNaissanceColumn;

	    @FXML
	    private TableColumn<Etudiant, String> EmailColumn;

	    @FXML
	    private TableColumn<Etudiant, Integer> NombreAbsColumn;

	    @FXML
	    private TableColumn<Etudiant, Double> NoteS1Column;

	    @FXML
	    private TableColumn<Etudiant, Double> NoteS2Column;

	    @FXML
	    private TableColumn<Etudiant, Double> NoteTotaleColumn;
	    
	    public void initialize() {
	    	//set up the columns in the table
	    	IdEColumn.setCellValueFactory(new PropertyValueFactory<Etudiant,Integer>("idE"));
	    	NomColumn.setCellValueFactory(new PropertyValueFactory<Etudiant,String>("nom"));
	    	PrenomColumn.setCellValueFactory(new PropertyValueFactory<Etudiant,String>("prenom"));
	    	DateDeNaissanceColumn.setCellValueFactory(new PropertyValueFactory<Etudiant,LocalDate>("dateDeNaissance"));
	    	EmailColumn.setCellValueFactory(new PropertyValueFactory<Etudiant,String>("email"));
	    	NombreAbsColumn.setCellValueFactory(new PropertyValueFactory<Etudiant,Integer>("nombreAbs"));
	    	NoteS1Column.setCellValueFactory(new PropertyValueFactory<Etudiant,Double>("noteS1"));
	    	NoteS2Column.setCellValueFactory(new PropertyValueFactory<Etudiant,Double>("noteS2"));
	    	NoteTotaleColumn.setCellValueFactory(new PropertyValueFactory<Etudiant,Double>("noteTotale"));
	    	//load some data
	    	tableView.setItems(getEleves());
	    	
	    	tableView.setEditable(true);
	    	NombreAbsColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
	    	NoteS1Column.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
	    	NoteS2Column.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
	    	NoteTotaleColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
	    	
	    	tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

	    }
	    
	    
	    public void delete() {
	    	ObservableList<Etudiant> selectedRows, allEleve;
	    	allEleve = tableView.getItems();
	    	selectedRows = tableView.getSelectionModel().getSelectedItems();
	    	
	    	for (Etudiant eleve:selectedRows ) {
	    		allEleve.remove(eleve);
	    		etudiantRequests.deleteEtudiant(eleve.getId());
	    	}
	    	
	    }
	    
	    public ObservableList<Etudiant> getEleves(){
			
	    	return etudiantRequests.getEtudiants();
	    }
	    
	    public void changeNbrAbsCellEvent(CellEditEvent edditedCell) {
	    	Etudiant eleveSelected = tableView.getSelectionModel().getSelectedItem();
            eleveSelected.setNbrAbs(Integer.valueOf(edditedCell.getNewValue().toString()));		
            
            etudiantRequests.putEtudiant(eleveSelected);
	    }
	    
	    public void changeNoteS1CellEvent(CellEditEvent edditedCell) {
	    	Etudiant eleveSelected = tableView.getSelectionModel().getSelectedItem();
            eleveSelected.setNoteS1(Double.valueOf(edditedCell.getNewValue().toString()));		
            
            etudiantRequests.putEtudiant(eleveSelected);  	
	    }
	    public void changeNoteS2CellEvent(CellEditEvent edditedCell) {
	    	Etudiant eleveSelected = tableView.getSelectionModel().getSelectedItem();
            eleveSelected.setNoteS2(Double.valueOf(edditedCell.getNewValue().toString()));		
            
            etudiantRequests.putEtudiant(eleveSelected); 	
	    }
	    public void changeNoteTotaleCellEvent(CellEditEvent edditedCell) {
	    	Etudiant eleveSelected = tableView.getSelectionModel().getSelectedItem();
            eleveSelected.setNoteTotal(Double.valueOf(edditedCell.getNewValue().toString()));		
            
            etudiantRequests.putEtudiant(eleveSelected); 	
	    }
	    
	    
	    
	    
	    
	    
}
