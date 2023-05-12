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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import static projectallmyscens.Seatmovie.appStage;
import static projectallmyscens.Seatmovie.sc;

/**
 * FXML Controller class
 *
 * @author Wasan
 */
public class Screen3Controller implements Initializable {

 @FXML
    private Button Screen1;
    @FXML
    private Button Screen2;
     @FXML
    private Button Screen3;
    @FXML
    private Button Screen4;
    @FXML
    private Button Trailer;
    @FXML
    private Button Seats;
    @FXML
    private Button Predictions;
    
    private Stage stage;
    private Scene scene;
    private Parent root;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

     @FXML
    private void Screen1(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Screen1.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

    }
     @FXML
    private void Screen2(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Screen2.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

    }
     @FXML
    private void Screen3(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Screen3.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

    }
     @FXML
    private void Screen4(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Screen4.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

    }
    @FXML
    private void Trailer(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Trailer3.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

    }
    @FXML
    private void Seats(ActionEvent event) throws IOException  {
         Parent root = FXMLLoader.load(getClass().getResource("Seats3.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

    }
    @FXML
    private void Predictions(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MoviePredictions.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

    }
    public void back(ActionEvent event) throws IOException{
       Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show(); 
    }
   
    
}