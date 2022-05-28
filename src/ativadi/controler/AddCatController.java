package ativadi.controler;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import ativadi.AtivaDI;
import ativadi.model.Category;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AddCatController implements Initializable {
	
	
	
	
	
	Category cat =new Category();
	
	
	
	
	
	    @FXML
	    private Button addcat;
	    @FXML
	    private Button home;
	    
	    
		
		@FXML
	    private TextField categoryname;
	    @FXML
	    private TextArea categorydescription;
	    @FXML
	    private TextField categorytitle;
	    @FXML
	    private TextField categorytype;
	    
	   
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	  @FXML
	    private void onaddcat(ActionEvent event) {
		  
		  
		  if(categoryname.getText().toString().equals("")) {
			  JOptionPane.showMessageDialog(null, "data should not null");
		  }
		  
		  else  if(categorydescription.getText().toString().equals("")) {
			  JOptionPane.showMessageDialog(null, "data should not null");
			  
		  }
		  else  if(categorytitle.getText().toString().equals("")) {
			  JOptionPane.showMessageDialog(null, "data should not null");
		  }
		  
		  else  if(categorytype.getText().toString().equals("")) {
			  JOptionPane.showMessageDialog(null, "data should not null");
		  }
		  else  {
			  
			  cat.setCategorydescription(categorydescription.getText().toString());
			  cat.setCategoryname(categoryname.getText().toString());
			  cat.setCategorytype(categorytype.getText().toString());
			  cat.setCategorytitle(categorytitle.getText().toString());
			  
			  cat.createCategory(cat);
		  }
		  
		  
		  
	  }
	  @FXML
	    private void gohome(ActionEvent event) {
		  
		  AtivaDI.mudaTela("home");  
		  
		  
	  }
	  

}
