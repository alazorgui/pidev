package ativadi.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import Banco.BancoSingleton;

public class Category {
  private int id ;
  private String categoryname ;
  private String categorytype ;
  private String categorytitle ;
  private String categorydescription;
  private BancoSingleton banco = BancoSingleton.getInstance();
public Category(int id, String categoryname, String categorytype, String categorytitle, String categorydescription) {
	super();
	this.id = id;
	this.categoryname = categoryname;
	this.categorytype = categorytype;
	this.categorytitle = categorytitle;
	this.categorydescription = categorydescription;
}



public void createCategory(Category cat){
    String sql = "INSERT INTO category (categoryname, categorytype, categorytitle, categorydescription)"
            + " VALUES ('"+cat.getCategoryname()+"','"+cat.getCategorytype()+"','"+cat.getCategorytitle()+"','"
            +cat.getCategorydescription()+"');";
    try {
        banco.executarSQL(sql);
        JOptionPane.showMessageDialog(null, "cat   craete  success!");
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error category not craeted  !");
        Logger.getLogger(Turma.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException ex) {
        JOptionPane.showMessageDialog(null, "Erro!");
        Logger.getLogger(Turma.class.getName()).log(Level.SEVERE, null, ex);
    }
}
public List<Category> getAllCategories() throws SQLException, ClassNotFoundException{
    ResultSet response = null;
    BancoSingleton banco = BancoSingleton.getInstance();
    String sql = "SELECT * FROM category;";
    if (banco.getConexao()== null) {
       
        banco.conectar();
    }
    Statement sessao = banco.getConexao().createStatement();
    response = sessao.executeQuery(sql);
    List<Category> categories = new ArrayList<>();
    while(response.next()){
    	Category cat = new Category(response.getInt("id"), response.getString("categoryname"),response.getString("categorytype"),
    			response.getString("categorytitle"),response.getString("categorydescription")
    			
    			);
    	categories.add(cat);
    }
    return categories;
}


public List<Integer> getCategoriesId() throws SQLException, ClassNotFoundException  {
	
	ResultSet response = null;
    BancoSingleton banco = BancoSingleton.getInstance();
    List<Integer> ids = new ArrayList<>();
    String sql = "SELECT id  FROM courses;";
    if (banco.getConexao()== null) {
       
        banco.conectar();
    }
    Statement sessao = banco.getConexao().createStatement();
    response = sessao.executeQuery(sql);
    List<Category> categories = new ArrayList<>();
    while(response.next()){
    	
    	ids.add(response.getInt("id"));
    	
    }
    return ids;
	
	
}



public Category() {
	super();
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getCategoryname() {
	return categoryname;
}
public void setCategoryname(String categoryname) {
	this.categoryname = categoryname;
}
public String getCategorytype() {
	return categorytype;
}
public void setCategorytype(String categorytype) {
	this.categorytype = categorytype;
}
public String getCategorytitle() {
	return categorytitle;
}
public void setCategorytitle(String categorytitle) {
	this.categorytitle = categorytitle;
}
public String getCategorydescription() {
	return categorydescription;
}
public void setCategorydescription(String categorydescription) {
	this.categorydescription = categorydescription;
}
  
}
