package ativadi.controler;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import ativadi.model.Coach;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CoachController  implements Initializable {
	
	Coach coach = new Coach();
	List<Coach> coaches = new ArrayList<>();
	
	
	
	@FXML
    private TextField coachName;
    @FXML
    private TextArea description;
    @FXML
    private TextField email;
    @FXML
    private TextField coachPassword;
    
    @FXML
    private TextField Identifiant;
    
    
    
    @FXML
    private Button createcoach;
    @FXML
    private Button volte;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	

}
