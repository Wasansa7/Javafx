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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author Wasan
 */
public class CardDetailsController implements Initializable {

    ObservableList<Integer> expylist = FXCollections.observableArrayList(2022, 2023, 2024, 2025, 2026, 2027, 2028);
    ObservableList<Integer> expmlist = FXCollections.observableArrayList(01, 02, 03, 04, 05, 06, 07);
    @FXML
    private ComboBox expyBox;
    @FXML
    private ComboBox expmBox;
    @FXML
    private Label label;
    @FXML
    private TextField car;
    @FXML
    public TextField cvv;
    @FXML
    public Button ok;
    @FXML
    private Label errorlabel;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        expyBox.setValue(2022);
        expyBox.setItems(expylist);
        expmBox.setValue(1);
        expmBox.setItems(expmlist);
    }

    @FXML
    public void buttonok(ActionEvent event) throws IOException {
        Window owner = ok.getScene().getWindow();
        int numbercard = car.getLength();
        int numbercvv = cvv.getLength();
        if (numbercard != 8 | numbercvv != 3) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error",
                    "Plese Inter 8 Number for card Number \nPlese Inter 3 Number for cvv Number. ");
        } else if (car.getText().matches("^[a-z]+$") | cvv.getText().matches("^[a-z]+$")) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error",
                    "Plese Enter Number only ");
        } else {
            Parent root = FXMLLoader.load(getClass().getResource("Done.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
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

    public void back(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Ckeckout.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
