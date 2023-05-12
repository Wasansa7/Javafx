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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Wasan
 */
public class ListViewController implements Initializable {

    @FXML
   private ListView<Comment> listView;
    @FXML
    private ImageView backimg;
    @FXML
    private Button ok;
    @FXML
    private Label C;
    @FXML
    private Label movie;
    @FXML
    private ImageView kin;
    @FXML
    private Text textt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       for(int i=0;i< Projectallmyscens.commentList.size();i++){
            listView.getItems().add( Projectallmyscens.commentList.get(i));
        }

        
    }    
    
    @FXML
    public void OK (ActionEvent event) throws IOException{
        Parent ok = FXMLLoader.load(getClass().getResource("Screen1.fxml"));
        Scene  listwi = new Scene(ok);
        Stage win = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        win.setScene(listwi);
        win.show();
    }
    
}