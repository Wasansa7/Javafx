/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectallmyscens;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import static projectallmyscens.Seatmovie.appStage;
import static projectallmyscens.Seatmovie.sc;

/**
 * FXML Controller class
 *
 * @author Wasan
 */
public class CkeckoutController implements Initializable {

    @FXML
    public Button payeng;

    ObservableList<Integer> timelist = FXCollections.observableArrayList(1, 3, 5, 7, 9);
    @FXML
    private ComboBox timeBox;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        timeBox.setValue(1);
        timeBox.setItems(timelist);
    }

    @FXML
    private void paying(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CardDetails.fxml"));
        Scene paymentScene = new Scene(root);
        Stage stage = (Stage) payeng.getScene().getWindow();
        stage.setScene(paymentScene);

    }

    @FXML
    private void back(ActionEvent event)  {
        appStage.setTitle("FXML Welcome");
        appStage.setScene(sc);
        appStage.show();

    }

}
