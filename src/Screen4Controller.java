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
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Wasan
 */
public class Screen4Controller implements Initializable {

    @FXML
    private Button Screen1;
    @FXML
    private Button Screen2;
    @FXML
    private Button Screen3;
    @FXML
    private Button Screen4;

    @FXML
    private Button back;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    ImageView imageaddmanger;

    @FXML
    Text textdesmange;

    public void displayimg(Image im) {
        imageaddmanger.setImage(im);

    }

    public void displaytextarea(String string) {
        textdesmange.setText(string);
    }



    @FXML
    public void Screen4(ActionEvent event) throws IOException {
        passing.text = textdesmange.getText();
        passing.image = imageaddmanger.getImage();
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
    public void back(ActionEvent event) throws IOException{
       Parent root = FXMLLoader.load(getClass().getResource("MangerOptions.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show(); 
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (passing.text.equals("")) {
            textdesmange.setText("");
        } else {
            textdesmange.setText(passing.text);
            imageaddmanger.setImage(passing.image);

            // TODO
        }

    }
}
