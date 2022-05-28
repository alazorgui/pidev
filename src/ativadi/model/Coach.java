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

public class Coach {
	
	private int coachid ;
	private String coachname ;
	private String email ;
	private String coachPassword ;
	private String description ;
	private int Identifiant;
	private BancoSingleton banco = BancoSingleton.getInstance();
	public int getCoachid() {
		return coachid;
	}
	public void setCoachid(int coachid) {
		this.coachid = coachid;
	}
	public String getCoachname() {
		return coachname;
	}
	public void setCoachname(String coachname) {
		this.coachname = coachname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCoachPassword() {
		return coachPassword;
	}
	public void setCoachPassword(String coachPassword) {
		this.coachPassword = coachPassword;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getIdentifiant() {
		return Identifiant;
	}
	public void setIdentifiant(int identifiant) {
		Identifiant = identifiant;
	}
	public Coach(int coachid, String coachname, String email, String coachPassword, String description,
			int identifiant) {
		super();
		this.coachid = coachid;
		this.coachname = coachname;
		this.email = email;
		this.coachPassword = coachPassword;
		this.description = description;
		Identifiant = identifiant;
	}
	public Coach() {
		super();
	}
	public Coach(String coachname, String email, String coachPassword, String description, int identifiant) {
		super();
		this.coachname = coachname;
		this.email = email;
		this.coachPassword = coachPassword;
		this.description = description;
		Identifiant = identifiant;
	}
	
	
	 public List<Coach> getAllCoaches() throws SQLException, ClassNotFoundException{
	        ResultSet response = null;
	        BancoSingleton banco = BancoSingleton.getInstance();
	        String sql = "SELECT * FROM coach;";
	        if (banco.getConexao()== null) {
	           
	            banco.conectar();
	        }
	        Statement sessao = banco.getConexao().createStatement();
	        response = sessao.executeQuery(sql);
	        List<Coach> coaches = new ArrayList<>();
	        while(response.next()){
	        	Coach professor = new Coach(response.getInt("coachid"), response.getString("coachname"),response.getString("email"),
	        			response.getString("coachpassword"),response.getString("description"),response.getInt("identifiant")
	        			
	        			);
	            coaches.add(professor);
	        }
	        return coaches;
	    }
	 
	 
	 public void createCoach(Coach coach){
	        String sql = "INSERT INTO coach (coachname, email, coachpassword, description, Identifiant)"
	                + " VALUES ('"+coach.getCoachname()+"','"+coach.getEmail()+"','"+coach.getCoachPassword()+"','"
	                +coach.getDescription()+"','"+coach.getIdentifiant()+"');";
	        try {
	            banco.executarSQL(sql);
	            JOptionPane.showMessageDialog(null, "coach  craete  success!");
	        } catch (SQLException ex) {
	            JOptionPane.showMessageDialog(null, "Error  !");
	            Logger.getLogger(Turma.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (ClassNotFoundException ex) {
	            JOptionPane.showMessageDialog(null, "Erro!");
	            Logger.getLogger(Turma.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    }
	

}
