/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ativadi;

import Banco.BancoSingleton;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class AtivaDI extends Application {
    private static Stage stage;
    
    private static Scene turmasTela;
    
    private static Scene coachtable;
    private static Scene coaching;
    
    private static Scene catschene;
    private static Scene criarTurmaTela;
    
    private static Scene  homepage ;
    private static Scene  categories ;
    private static Scene courses;
    private static Scene allformation;
    
    private static Scene formation ;
    @Override
    public void start(Stage primaryStage) throws IOException {
        
        stage = primaryStage;
        primaryStage.setTitle("Gestion de Formation ");
        
        //TELA ABERTURA
        Parent abertura = FXMLLoader.load(getClass().getResource("view/categorytab.fxml"));
        turmasTela = new Scene(abertura,758,564);
        
        
        Parent abertura2 = FXMLLoader.load(getClass().getResource("view/cadastroTurma.fxml"));
        criarTurmaTela = new Scene(abertura2,758,564);
       
        //TELA ABERTURA
        Parent coachd = FXMLLoader.load(getClass().getResource("view/coach.fxml"));
        coaching = new Scene(coachd,758,564);
        
        
        
        Parent coachtab = FXMLLoader.load(getClass().getResource("view/coachtab.fxml"));
        coachtable = new Scene(coachtab,958,564);
        
        Parent formationcf = FXMLLoader.load(getClass().getResource("view/formation2.fxml"));
        formation = new Scene(formationcf,958,564);
        
        Parent formationcfsee = FXMLLoader.load(getClass().getResource("view/allformations.fxml"));
        allformation = new Scene(formationcfsee,958,564);
        
        Parent catd = FXMLLoader.load(getClass().getResource("view/category.fxml"));
        catschene = new Scene(catd,758,564);
        //primaryStage.setScene(turmasTela);
        //primaryStage.setScene(coaching);
        //primaryStage.setScene(catschene);
        
        //categories
        
        Parent categ_ = FXMLLoader.load(getClass().getResource("view/addcourses.fxml"));
        categories = new Scene(categ_,758,564);
        
        Parent cours_ = FXMLLoader.load(getClass().getResource("view/addcourses.fxml"));
        courses = new Scene(cours_,758,564);
        
        Parent home = FXMLLoader.load(getClass().getResource("view/homepage2.fxml"));
        homepage = new Scene(home,958,764);
      //  homepage.getStylesheets().add(getClass().getResource("/application.css").toExternalForm());
        primaryStage.setScene(homepage);
        primaryStage.show();
    }
    
      
    public static void mudaTela(String tela){
        switch(tela){
            case "criarTurma":
                stage.setScene(criarTurmaTela);
                break;
                
                
            case "categories":
                stage.setScene(categories);
                break;
                
            case "home":
                stage.setScene(homepage);
                break;
            case "addformation":
                stage.setScene(formation );
                break;
                
            case "allformation":
                stage.setScene(allformation );
                break;
            case "couchtab":
		
				stage.setScene(catschene);break;
		
            case "coach":
                stage.setScene(turmasTela);
                
            case "coachtab1":
                stage.setScene(coaching);break;
                
                
            case "addcorses":
                stage.setScene(courses);break;
                
            case "categorytab":
                stage.setScene(turmasTela);
                break;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
