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

public class Formation {
	
	private int id ;
	private String formationname ;
	private String formationtitle ;
	private String formationtype ;
	private String descform ;
	private BancoSingleton banco = BancoSingleton.getInstance();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFormationname() {
		return formationname;
	}
	public void setFormationname(String formationname) {
		this.formationname = formationname;
	}
	public String getFormationtitle() {
		return formationtitle;
	}
	public void setFormationtitle(String formationtitle) {
		this.formationtitle = formationtitle;
	}
	public String getFormationtype() {
		return formationtype;
	}
	public void setFormationtype(String formationtype) {
		this.formationtype = formationtype;
	}
	public String getDescform() {
		return descform;
	}
	public void setDescform(String descform) {
		this.descform = descform;
	}
	public Formation(int id, String formationname, String formationtitle, String formationtype, String descform) {
		super();
		this.id = id;
		this.formationname = formationname;
		this.formationtitle = formationtitle;
		this.formationtype = formationtype;
		this.descform = descform;
	}
	public Formation() {
		super();
	}
	public Formation(String formationname, String formationtitle, String formationtype, String descform) {
		super();
		this.formationname = formationname;
		this.formationtitle = formationtitle;
		this.formationtype = formationtype;
		this.descform = descform;
	}
	
	
	 public List<Formation> getAllForms() throws SQLException, ClassNotFoundException{
	        ResultSet response = null;
	        BancoSingleton banco = BancoSingleton.getInstance();
	        String sql = "SELECT * FROM formation;";
	        if (banco.getConexao()== null) {
	           
	            banco.conectar();
	        }
	        Statement sessao = banco.getConexao().createStatement();
	        response = sessao.executeQuery(sql);
	        List<Formation> formations = new ArrayList<>();
	        while(response.next()){
	        	Formation  professor = new Formation(response.getInt("id"), response.getString("formationname"),response.getString("formationtitle"),
	        			response.getString("formationtype"),response.getString("descform")
	        			
	        			);
	        	formations.add(professor);
	        }
	        return formations;
	    }
	 
	 
	 public void createForm(Formation frm){
	        String sql = "INSERT INTO formation  (formationname, formationtitle, formationtype, descform)"
	                + " VALUES ('"+frm.getFormationname()+"','"+frm.getFormationtitle()+"','"+frm.getFormationtype()+"','"
	                +frm.getDescform()+"');";
	        try {
	            banco.executarSQL(sql);
	            JOptionPane.showMessageDialog(null, "formation create   craete  success!");
	        } catch (SQLException ex) {
	            JOptionPane.showMessageDialog(null, "Error  !");
	            Logger.getLogger(Turma.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (ClassNotFoundException ex) {
	            JOptionPane.showMessageDialog(null, "Erro!");
	            Logger.getLogger(Turma.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    }
	 
public boolean deletetform(int id)
	 
	 {
	String sql = "DELETE FROM formation WHERE id = '"+id+"'";
      try {
          banco.executarSQL(sql);
          JOptionPane.showMessageDialog(null, "formation delete     success!");
          return true;
      } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Error  !");
          Logger.getLogger(Turma.class.getName()).log(Level.SEVERE, null, ex);
          return false;
      } catch (ClassNotFoundException ex) {
          JOptionPane.showMessageDialog(null, "Erro!");
          Logger.getLogger(Turma.class.getName()).log(Level.SEVERE, null, ex);
          return false ;
      } 
	
	 }
	
	
	

}
