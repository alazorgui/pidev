package ativadi.controler;

import java.net.URL;
import java.util.ResourceBundle;

import ativadi.AtivaDI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class HomeController implements Initializable {
	
	    @FXML
	    private Button coachscene;
	    @FXML
	    private Button categoryscene;
	    
	    @FXML
	    private Button coursescene;
	    @FXML
	    private Button exercicescene;
	    
	    @FXML
	    private Button formation;
	    
	    @FXML
	    private Button allformation;
	    
	    @FXML 
	    private Button cats;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	

	
	 @FXML
	  private void openscene(ActionEvent event) {
	        AtivaDI.mudaTela("couchtab");   
	    }
	
	 @FXML
	    private void opencat(ActionEvent event) {
	        AtivaDI.mudaTela("criarTurmaTela");   
	    }
	 
	 @FXML
	    private void openexce(ActionEvent event) {
	        AtivaDI.mudaTela("categorytab");   
	    }
	 @FXML
	    private void opencourse(ActionEvent event) {
	        AtivaDI.mudaTela("addcorses");   
	    }
	 @FXML
	    private void formationpage(ActionEvent event) {
	        AtivaDI.mudaTela("addformation");   
	    }
	 
	 @FXML
	    private void onviewform(ActionEvent event) {
	        AtivaDI.mudaTela("allformation");   
	    }
	 
	 @FXML
	    private void opencats(ActionEvent event) {
	        AtivaDI.mudaTela("categories");   
	    }
	 
	 

}
