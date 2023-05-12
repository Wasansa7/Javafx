/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectallmyscens;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import javafx.scene.image.Image;
import java.net.URL;
import java.util.ResourceBundle;
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
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;


/**
 * FXML Controller class
 *
 * @author Wasan
 */
public class MangerAddScreenController implements Initializable {

    @FXML
    private TextArea textdes;
    
   
    @FXML
    private Button addbutton;
    
    @FXML
    private ImageView imageadd;
    
    @FXML
    private Button chooseimage;
    
    final FileChooser fc=new FileChooser();
    
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private void handleButtonAction(ActionEvent event) throws MalformedURLException {
        fc.setTitle("My fille chooser");
        fc.setInitialDirectory(new File(System.getProperty("user.home")));
    
        fc.getExtensionFilters().clear();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files","*.png","*.jpg","*.gif"));
        
        File file=fc.showOpenDialog(null);
        
        if(file != null){
            imageadd.setImage(new Image(file.toURL().toString()));
        }else{
             Window owner = addbutton.getScene().getWindow();
              showAlert(Alert.AlertType.ERROR, owner, "Form Error",
                    "A FILE IS INVALID. ");
        }
    }  
    public static void showAlert(Alert.AlertType alertType, Window owner, String title, String mss) {
        Alert al = new Alert(alertType);
        al.setTitle(title);
        al.setHeaderText(null);
        al.setContentText(mss);
        al.initOwner(owner);
        al.show();
    } 
    
    @FXML
     private void addaction(ActionEvent event) throws IOException {
         Image imgadd=imageadd.getImage();
         FXMLLoader lod=new FXMLLoader(getClass().getResource("Screen4.fxml"));
         Parent root=lod.load();
         Screen4Controller mangerController=lod.getController();
         mangerController.displayimg(imgadd);

          String sarea=textdes.getText();

         mangerController.displaytextarea(sarea);
         
         Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
         Scene scene= new Scene(root);
         s.setScene(scene);
         s.show();
         
     }
     
     public void back(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("MangerOptions.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();   
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
