package ativadi.controler;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import ativadi.AtivaDI;
import ativadi.model.Category;
import ativadi.model.Coach;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class CoachTableController implements Initializable {
	
	
	
	
	
	
	
	
	
	/*
	 * 
	 * 
	 * private String coachname ;
	private String email ;
	private String coachPassword ;
	private String description ;
	private int Identifiant;
	 */
	
	 List<Coach> list = new ArrayList<>();
	 Coach turma = new Coach();
	    ObservableList<Coach> clientes = FXCollections.observableArrayList();
	    
	    @FXML
	    private Button btNovaTurma;
	    @FXML
	    private TableView<Coach> tableview;
	    @FXML
	    private TableColumn<Coach, String> coachname;
	    @FXML
	    private TableColumn<Coach, String> email;
	    @FXML
	    private TableColumn<Coach, String> coachPassword;
	    @FXML
	    private TableColumn<Coach, String> description;
	    @FXML
	    private TableColumn<Coach, Integer> Identifiant;
	    
	    
	    @FXML
	    private Button addcoach;
	    @FXML
	    private Button home;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		coachname.setCellValueFactory(
	                new PropertyValueFactory<>("coachname"));
		email.setCellValueFactory(
	                new PropertyValueFactory<>("email"));
		coachPassword.setCellValueFactory(
	                new PropertyValueFactory<>("coachPassword"));
		description.setCellValueFactory(
	                new PropertyValueFactory<>("description"));
		
		Identifiant.setCellValueFactory(new PropertyValueFactory<>("Identifiant"));
	        
	        
	        try {
				list = turma.getAllCoaches();
				
				for(Coach cat_ : list)
					
				
				System.out.println(cat_.getCoachid());
				  tableview.setItems(FXCollections.observableArrayList(list));
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	 @FXML
	  private void home(ActionEvent event) {
	        AtivaDI.mudaTela("home");   
	    }
	
	 @FXML
	    private void addcoach(ActionEvent event) {
	        AtivaDI.mudaTela("criarTurmaTela");   
	    }

}
