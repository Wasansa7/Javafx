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
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.hibernate.Session;
import org.hibernate.Transaction;
import static projectallmyscens.LoginController.showAlert;

/**
 * FXML Controller class
 *
 * @author Wasan
 */
public class SignupController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    ObservableList<String> unamem = FXCollections.observableArrayList();
    ListView username = new ListView(unamem);
    ObservableList<String> upassm = FXCollections.observableArrayList();
    ListView userpass = new ListView(upassm);
    ObservableList<String> uemail = FXCollections.observableArrayList();
    ListView useremail = new ListView(uemail);
    @FXML
    private TextField userName;

    @FXML
    private TextField userPass;

    @FXML
    private TextField userEmail;

    @FXML
    private Button usersave;

    public static void showAlert(Alert.AlertType alertType, Window owner, String title, String mss) {
        Alert al = new Alert(alertType);
        al.setTitle(title);
        al.setHeaderText(null);
        al.setContentText(mss);
        al.initOwner(owner);
        al.show();

    }

    public void usersave(ActionEvent event) throws IOException {
        Window owner = usersave.getScene().getWindow();
        userch ch = new userch();
        if (userName.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error", "Please enter your Username");
        } else if (userPass.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error", "Please enter your Password");
        } else if (userEmail.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error", "Please enter your Email");
        } else {

            Session session2 = HibernateUtil_1.getSessionFactory().openSession();
            Transaction t = session2.beginTransaction();
            String name = userName.getText();
            ch.setUserName(name);
            ch.setUserPass(userPass.getText());
            ch.setUserEmail(userEmail.getText());

            String str = (String) session2.save(ch);
            t.commit();
            session2.close();
            System.out.println("inserted : " + ch.getUserName());

            Parent root = FXMLLoader.load(getClass().getResource("Screen1.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }
    }

    public void back(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Account.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
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
