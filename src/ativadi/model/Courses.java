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

public class Courses {
	
	private int id ;
	private String coursename ;
	private String coursetype ;
	private String coursetitile ;
	private String coursedescription;
	private Category category ;
	private BancoSingleton banco = BancoSingleton.getInstance();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public String getCoursetype() {
		return coursetype;
	}
	public void setCoursetype(String coursetype) {
		this.coursetype = coursetype;
	}
	public String getCoursetitile() {
		return coursetitile;
	}
	public void setCoursetitile(String coursetitile) {
		this.coursetitile = coursetitile;
	}
	public String getCoursedescription() {
		return coursedescription;
	}
	public void setCoursedescription(String coursedescription) {
		this.coursedescription = coursedescription;
	}
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Courses() {
		super();
	}
	
	public Courses(int id, String coursename, String coursetype, String coursetitile, String coursedescription,
			Category category) {
		super();
		this.id = id;
		this.coursename = coursename;
		this.coursetype = coursetype;
		this.coursetitile = coursetitile;
		this.coursedescription = coursedescription;
		this.category = category;
		this.banco = banco;
	}
	
	
	public Courses(int id, String coursename, String coursetype, String coursetitile, String coursedescription) {
		super();
		this.id = id;
		this.coursename = coursename;
		this.coursetype = coursetype;
		this.coursetitile = coursetitile;
		this.coursedescription = coursedescription;
		this.banco = banco;
	}
	public List<Courses> getAllCourses() throws SQLException, ClassNotFoundException{
	    ResultSet response = null;
	    BancoSingleton banco = BancoSingleton.getInstance();
	    String sql = "SELECT * FROM courses;";
	    if (banco.getConexao()== null) {
	       
	        banco.conectar();
	    }
	    Statement sessao = banco.getConexao().createStatement();
	    response = sessao.executeQuery(sql);
	    List<Courses> courses = new ArrayList<>();
	    while(response.next()){
	    	Courses course = new Courses(response.getInt("id"), response.getString("coursename"),response.getString("coursetype"),
	    			response.getString("coursetitile"),response.getString("coursedescription")
	    			
	    			);
	    	courses.add(course);
	    }
	    return courses;
	}

	public void createCcourses(Courses course){
		System.out.println(course.getCategory().getId());
        String sql = "INSERT INTO courses (coursename, coursetype, coursetitle, coursedescription, categoryId)"
                + " VALUES ('"+course.getCoursename()+"','"+course.getCoursetype()+"','"+course.getCoursetitile()+"','"
                +course.getCoursedescription()+"','"+course.getCategory().getId()+"');";
        try {
            banco.executarSQL(sql);
            JOptionPane.showMessageDialog(null, "courses  craete  success!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error  !");
            Logger.getLogger(Turma.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro!");
            Logger.getLogger(Turma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
	
	

}
