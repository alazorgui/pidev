package ativadi.controler;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;

import javax.swing.JOptionPane;

import ativadi.AtivaDI;
import ativadi.model.Category;
import ativadi.model.Formation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.css.PseudoClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class AllFormationController implements Initializable {
	
	
	List<Formation> list = new ArrayList<>();
	Formation turma = new Formation();
    ObservableList<Formation> clientes = FXCollections.observableArrayList();
    
    @FXML
    private Button btNovaTurma;
    @FXML
    private TableView<Formation> tableview;
    @FXML
    private TableColumn<Formation, Integer> id;
    @FXML
    private TableColumn<Formation, String> formationame;
    @FXML
    private TableColumn<Formation, String> formationtitle;
    @FXML
    private TableColumn<Formation, String> formationtype;
    @FXML
    private TableColumn<Formation, String> description;
    
    @FXML 
    private TextField search;
    @FXML
    private Button home;
    
    
    @FXML 
    private TextField id_;
    @FXML
    private Button delid;
     
     
    
//	private ObservableList<Formation> items;
//	private FilteredList<Formation> filteredList;
//	private SortedList<Formation> sortedList;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		id.setCellValueFactory(
                new PropertyValueFactory<>("id"));
		formationame.setCellValueFactory(
	                new PropertyValueFactory<>("formationame"));
		formationtitle.setCellValueFactory(
	                new PropertyValueFactory<>("formationtitle"));
		formationtype.setCellValueFactory(
	                new PropertyValueFactory<>("formationtype"));
		description.setCellValueFactory(
	                new PropertyValueFactory<>("description"));
	        
	        
	        try {
				list = turma.getAllForms();
				
				for(Formation cat_ : list)
					
				
				System.out.println(cat_.getFormationname());
				  tableview.setItems(FXCollections.observableArrayList(list));
				  
				//  FilteredList<Formation> filterdata = new FilteredList<>(tableview,p->true);
				//  FilteredList<Formation> filteredData = new FilteredList<>(FXCollections.observableList(list));
				  
				  //tableview.setItems(filteredData);
				  tableview.setRowFactory(tableviewu ->{
					  TableRow<Formation> row = new TableRow<>();
			            row.pseudoClassStateChanged(PseudoClass.getPseudoClass("highlighted"), false);
			            row.itemProperty().addListener((obs, oldOrder, newOrder) -> {
			                boolean assignClass = list.contains(newOrder) &&
			                        (newOrder.getFormationname().equals("JAVA") ||
			                                newOrder.getFormationtitle().equals("informatique"));

			                row.pseudoClassStateChanged(PseudoClass.getPseudoClass("highlighted"), assignClass);
			            });
			            return row;
				  });
				  search.textProperty().addListener((observable, oldValue, newValue) ->
	                tableview.setItems(filterList(list, newValue.toLowerCase()))
	        );
				  tableview.refresh();
				  
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        
		
	}
	 @FXML
	    private void gotohome(ActionEvent event) {
	        AtivaDI.mudaTela("home");   
	    }
	 
	 private Predicate<Formation> createPredicate(String searchText){
	        return order -> {
	            if (searchText == null || searchText.isEmpty()) return true;
	            return searchFindsOrder(order, searchText);
	        };
	    }

	    private ObservableList<Formation> filterList(List<Formation> list, String searchText){
	        List<Formation> filteredList = new ArrayList<>();

	        for (Formation order: list){
	            if(searchFindsOrder(order, searchText)){
	                filteredList.add(order);
	            }
	        }
	        return FXCollections.observableList(filteredList);
	    }

	    private boolean searchFindsOrder(Formation order, String searchText){
	    	
	        return (order.getFormationname().toLowerCase().contains(searchText)) ||
	                (order.getFormationtitle().toLowerCase().contains(searchText)) ||
	                Integer.valueOf(order.getId()).toString().equals(searchText);
	        
	        
	    }
	    
	    @FXML
	    private void deletebyid(ActionEvent event) {
		  
		  if(id_.getText().toString().equals("")) {
			  JOptionPane.showMessageDialog(null, "enter id from list"); 
		  }
		  
		  else  {
			   int myid = Integer.parseInt(id_.getText().toString());
			   turma.deletetform(myid);
			   id_.setText("");
			   try {
				turma.getAllForms();
                                list = 	turma.getAllForms();
                                tableview.setItems(FXCollections.observableArrayList(list));
				tableview.refresh();
                                
				//tableview.setItems(FXCollections.observableArrayList(list));
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   
		  }
		  
		  
	  }


}
