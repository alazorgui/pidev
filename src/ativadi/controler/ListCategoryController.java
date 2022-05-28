/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ativadi.controler;

import Banco.BancoSingleton;
import ativadi.AtivaDI;
import ativadi.model.Category;
import ativadi.model.Turma;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class ListCategoryController implements Initializable {

    List<Category> list = new ArrayList<>();
    Category turma = new Category();
    ObservableList<Category> clientes = FXCollections.observableArrayList();
    
    @FXML
    private Button btNovaTurma;
    @FXML
    private TableView<Category> tableview;
    @FXML
    private TableColumn<Category, String> col_codigo;
    @FXML
    private TableColumn<Category, String> col_professor;
    @FXML
    private TableColumn<Category, String> col_ano;
    @FXML
    private TableColumn<Category, String> col_semestre;
    @FXML
    private TableColumn<Category, String> col_escolaridade;
    
    @FXML
    private Button home;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        col_codigo.setCellValueFactory(
                new PropertyValueFactory<>("categoryname"));
        col_professor.setCellValueFactory(
                new PropertyValueFactory<>("categorytype"));
        col_ano.setCellValueFactory(
                new PropertyValueFactory<>("categorytitle"));
        col_semestre.setCellValueFactory(
                new PropertyValueFactory<>("categorydescription"));
        
        
        try {
			list = turma.getAllCategories();
			
			for(Category cat_ : list)
				
			
			System.out.println(cat_.getCategoryname());
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
    private void cadastrarTurma(ActionEvent event) {
        AtivaDI.mudaTela("criarTurma");   
    }
    @FXML
    private void gohome(ActionEvent event) {
        AtivaDI.mudaTela("home");   
    }
}
