/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectallmyscens;

import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import java.io.File;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Wasan
 */
public class Trailer2Controller implements Initializable {
    
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    
   public void back(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Screen2.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();   
    }

    @FXML
    private MediaView mediaView;

    @FXML
    private Button playButton;
    @FXML
    private Button pauseButton;
    @FXML
    private File file;
    @FXML
    private Media media;
    @FXML
    private MediaPlayer mediaPlayer;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        file = new File("C:\\Users\\Wasan\\Downloads\\spiderman.mp4");
        media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);

    }

    @FXML
    public void playMedia() {
        //playButton.
        mediaPlayer.play();
    }

    @FXML
    public void pauseMedia() {
        mediaPlayer.pause();
    }

    @FXML
    public void resetMedia() {
        mediaPlayer.seek(Duration.seconds(0.0));
    }

}
