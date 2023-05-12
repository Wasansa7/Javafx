/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectallmyscens;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import static projectallmyscens.Projectallmyscens.commentList;


/**
 * FXML Controller class
 *
 * @author Wasan
 */
public class MoviePredictionsController implements Initializable {
    


    
    @FXML
    private Rectangle req;
    @FXML
    private TextArea area;
    @FXML
    private RadioButton r1;
    @FXML
    private ToggleGroup rate;
    @FXML
    private RadioButton r2;
    @FXML
    private RadioButton r3;
    @FXML
    private RadioButton r4;
    @FXML
    private RadioButton r5;
    @FXML
    private ImageView backimag;
    @FXML
    private Text texttop;
    @FXML
    private Text textr;
    @FXML
    private Button submite;
    @FXML
    private Button butback;
    @FXML
    private Label c;
    @FXML
    private Label mo;
    @FXML
    private ImageView kin;

    /**
     * Initializes the controller class.
     */
    @FXML
  public void ching (ActionEvent event) throws IOException{
        
           
        RadioButton selectedRadioButton = (RadioButton) rate.getSelectedToggle();
        String rate = selectedRadioButton.getText();
        // create a alert
        Alert alert = new Alert(Alert.AlertType.ERROR);
        if(selectedRadioButton == null ){
            alert.setTitle("Error");
            alert.setContentText("You must select Rate");
            alert.showAndWait();
            return ;
        }
        if (area.getText().isEmpty()){
             alert.setTitle("Error");
            alert.setContentText("You must write comment");
            alert.showAndWait();
            return;
        }
 
        Comment comment=new Comment( Integer.parseInt(rate),area.getText() );
        commentList.add(comment);
        Parent list = FXMLLoader.load(getClass().getResource("ListView.fxml"));
        Scene  listwi = new Scene(list);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(listwi);
        window.show();
    }
          
       
    @FXML
    public void back (ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Screen1.fxml"));
        Scene  listwi = new Scene(root);
        Stage win = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        win.setScene(listwi);
        win.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
}
   

    

    