/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectallmyscens;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Wasan
 */
public class DoneController implements Initializable {
    
    
    @FXML
    private ImageView imageanimations;
    
    
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        TranslateTransition tt = new TranslateTransition();
        tt.setNode(imageanimations);
        tt.setDuration(Duration.millis(1000));
        tt.setByY(+330);
        tt.play();
        
    }
    
  
   
   

    /**
     * Initializes the controller class.
     */
     
    
}
