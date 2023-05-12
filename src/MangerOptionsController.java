/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectallmyscens;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Wasan
 */
public class MangerOptionsController implements Initializable {
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    public void showScreens(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Screen1.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();   
    }
    public void addScreen(ActionEvent event) throws IOException{
       Parent root = FXMLLoader.load(getClass().getResource("MangerAddScreen.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show(); 
    }
    
    public void back(ActionEvent event) throws IOException{
       Parent root = FXMLLoader.load(getClass().getResource("LoginManger.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show(); 
    }
  

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
