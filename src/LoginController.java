/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectallmyscens;

import java.io.IOException;
import java.net.URL;
import java.util.List;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Wasan
 */
public class LoginController implements Initializable {

    @FXML
    private Button loginuser;

    @FXML
    private TextField userName;

    @FXML
    private PasswordField userPass;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void loginuser(ActionEvent event) throws IOException {
        Window owner = loginuser.getScene().getWindow();

        if (userName.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error", "Please enter your Username");
        } else if (userPass.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error", "Please enter your Password");
        } else {

            Session session2 = HibernateUtil_1.getSessionFactory().openSession();
            Transaction t = session2.beginTransaction();
            List<userch> ulist = null;
            String queryStr = "from userch";
            Query query = session2.createQuery(queryStr);
            boolean s = false;
            ulist = query.list();
            session2.close();
            for (userch u : ulist) {
                if (userName.getText().equals(u.getUserName())) {
                    if (userPass.getText().equals(u.getUserPass())) {
                        s = true;
                    }
                    System.out.println("user list sizq: " + ulist.size());

                    System.out.println(u.getUserName() + " " + u.getUserPass());

                    Parent root = FXMLLoader.load(getClass().getResource("Screen1.fxml"));
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();

                }

            }
        }
    }

    public void back(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Account.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void showAlert(Alert.AlertType alertType, Window owner, String title, String mss) {
        Alert al = new Alert(alertType);
        al.setTitle(title);
        al.setHeaderText(null);
        al.setContentText(mss);
        al.initOwner(owner);
        al.show();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
// }

