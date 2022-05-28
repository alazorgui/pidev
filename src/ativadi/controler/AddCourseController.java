package ativadi.controler;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import ativadi.AtivaDI;
import ativadi.model.Category;
import ativadi.model.Courses;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AddCourseController  implements Initializable{
	
	
	 Category cat = new Category();
	 List<Category> ids ;
	 
	 Courses course = new Courses();
	
	
	
	
	@FXML
    private TextField coursename;
    @FXML
    private TextArea coursedescription;
    @FXML
    private TextField coursetype;
    @FXML
    private TextField coursetitle;
    @FXML
    private ComboBox<Integer> catid;
    
    @FXML
    private Button home ;
  
    
    @FXML
    private Button addcourse;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		
	     try {
	    	 ids = cat.getAllCategories();
           for(Category p : ids){
        	   catid.getItems().add(p.getId());
           }
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro no BD!");
           Logger.getLogger(AddCourseController.class.getName()).log(Level.SEVERE, null, ex);
       } catch (ClassNotFoundException ex) {
           JOptionPane.showMessageDialog(null, "Erro ao carregar professores!");
           Logger.getLogger(AddCourseController.class.getName()).log(Level.SEVERE, null, ex);
       }
	}
	
	
	
	
	
	@FXML
    private void addcourses(ActionEvent event) {
		
		if("".equals(coursename.getText().toString()))
		{
			JOptionPane.showMessageDialog(null, "data should not null");
		}
		
		else if("".equals(coursedescription.getText().toString()))
		{
			JOptionPane.showMessageDialog(null, "data should not null");
		}
		
		else  if("".equals(coursename.getText().toString()))
		{
			JOptionPane.showMessageDialog(null, "data should not null");
		}
		else if("".equals(coursetype.getText().toString()))
		{
			JOptionPane.showMessageDialog(null, "data should not null");
		}
		else if("".equals(coursetitle.getText().toString()))
		{
			JOptionPane.showMessageDialog(null, "data should not null");
		}
		  else if (catid.getSelectionModel().getSelectedItem() == null){
        JOptionPane.showMessageDialog(null, "Sselected a categoryid!"); 
      }
		else {
			
			course.setCoursedescription(coursedescription.getText().toString());
			course.setCoursename(coursename.getText().toString());
			course.setCoursetitile(coursetitle.getText().toString());
			course.setCoursetype(coursetype.getText().toString());
			
			 int cv_id = catid.getSelectionModel().getSelectedIndex()+1;
			 
			 System.out.println(cv_id);
			 for(Category c : ids ) {
				 if(c.getId()==cv_id)
					 cat =c ;
			 }
			 course.setCategory(cat);
			 
			 course.createCcourses(course);
		}
	  
		
	}
	@FXML
    private void gohome(ActionEvent event) {
		
		 AtivaDI.mudaTela("home");  
		

	}

}
