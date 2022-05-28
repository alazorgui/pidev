package ativadi.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Banco.BancoSingleton;

public class Excercice {
	private int id ;
	private String excercicename;
	private String excercicetype;
	private String description ;
	private int size ;
	private int courseId ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getExcercicename() {
		return excercicename;
	}
	public void setExcercicename(String excercicename) {
		this.excercicename = excercicename;
	}
	public String getExcercicetype() {
		return excercicetype;
	}
	public void setExcercicetype(String excercicetype) {
		this.excercicetype = excercicetype;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public Excercice(int id, String excercicename, String excercicetype, String description, int size, int courseId) {
		super();
		this.id = id;
		this.excercicename = excercicename;
		this.excercicetype = excercicetype;
		this.description = description;
		this.size = size;
		this.courseId = courseId;
	}
	public Excercice() {
		super();
	}
	public List<Excercice> getAllCourses() throws SQLException, ClassNotFoundException{
	    ResultSet response = null;
	    BancoSingleton banco = BancoSingleton.getInstance();
	    String sql = "SELECT * FROM excercice;";
	    if (banco.getConexao()== null) {
	       
	        banco.conectar();
	    }
	    Statement sessao = banco.getConexao().createStatement();
	    response = sessao.executeQuery(sql);
	    List<Excercice> excercices = new ArrayList<>();
	    while(response.next()){
	    	Excercice exer = new Excercice(response.getInt("id"), response.getString("excercicename"),response.getString("excercicetype"),
	    			response.getString("description"),response.getInt("size"),response.getInt("courseId")
	    			
	    			);
	    	excercices.add(exer);
	    }
	    return excercices;
	}

	
}
