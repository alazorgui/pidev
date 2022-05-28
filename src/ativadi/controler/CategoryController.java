package ativadi.controler;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import ativadi.model.Category;
import ativadi.model.Turma;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;

public class CategoryController  implements Initializable {
	
	 List<Category> catlist = new ArrayList<>();
	 Category cat = new Category();
	 ObservableList<Category> clientes = FXCollections.observableArrayList();
	 
	 
	 @FXML
	 private ListView<Category> listview;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		
		try {
			catlist = cat.getAllCategories();
			
			for(Category c :catlist )
				System.out.println(c.getCategorydescription());
			
			listview.setItems(FXCollections.observableArrayList(catlist));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		  
	}

}
