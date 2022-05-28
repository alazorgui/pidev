package ativadi.controler;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import ativadi.AtivaDI;
import ativadi.model.Category;
import ativadi.model.Formation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FormationController  implements Initializable  {
	
	Formation form = new Formation();
	
	@FXML
    private TextField formationame;
    @FXML
    private TextField formationtitle;
    @FXML
    private TextField formationtype;
    @FXML
    private TextField descform;
    
    
    @FXML
    private Button addformation;
    @FXML
    private Button home;
    @FXML
    private Button viewformation;


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	@FXML
    private void addformation(ActionEvent event) {
		
		if("".equals(formationame.getText().toString()))
		{
			JOptionPane.showMessageDialog(null, "data should not null");
		}
		
		else if("".equals(descform.getText().toString()))
		{
			JOptionPane.showMessageDialog(null, "data should not null");
		}
		
		
		else if("".equals(formationtitle.getText().toString()))
		{
			JOptionPane.showMessageDialog(null, "data should not null");
		}
		else if("".equals(formationtype.getText().toString()))
		{
			JOptionPane.showMessageDialog(null, "data should not null");
		}
	
		else {
			
			form.setFormationname(formationame.getText().toString());
			form.setFormationtitle(formationtitle.getText().toString());
			form.setFormationtype(formationtype.getText().toString());
			form.setDescform(descform.getText().toString());
			
			
			 
			 form.createForm(form);
			 
		}
	  
		
	}
	
	@FXML
    private void backhome(ActionEvent event) {
		  AtivaDI.mudaTela("home");  
		
	}
	
	@FXML
    private void onseeformation(ActionEvent event) {
		  AtivaDI.mudaTela("allformation");  
		
	}
	
	//onseeformation

}
