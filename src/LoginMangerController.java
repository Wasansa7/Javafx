/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectallmyscens;

//import static com.mysql.cj.conf.PropertyKey.logger;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.hibernate.Query;
import org.hibernate.Transaction;

/**
 * FXML Controller class
 *
 * @author Wasan
 */
public class LoginMangerController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button loginmangee;

    @FXML
    private TextField userManger;

    @FXML
    private TextField passManger;

    public void loginmangee(ActionEvent event) throws IOException {
        Window owner = loginmangee.getScene().getWindow();
        if (userManger.getText().isEmpty() || passManger.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error",
                    "Plese Inter pass,user Name. ");
        } else {
            org.hibernate.Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            List<mangerch> mlist = null;
            String queryStr = "from mangerch";
            Query query = session.createQuery(queryStr);
            boolean s = false;
            mlist = query.list();
            session.close();
            for (mangerch m : mlist) {
                if (userManger.getText().equals(m.getUserName())) {
                    if (passManger.getText().equals(m.getPassWord())) {
                        s = true;
                    }
                    System.out.println("manger list sizq: " + mlist.size());

                    System.out.println(m.getUserName() + " " + m.getPassWord());

                    Parent root = FXMLLoader.load(getClass().getResource("MangerOptions.fxml"));
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb
    ) {
        // TODO
    }

    public static void showAlert(Alert.AlertType alertType, Window owner, String title, String mss) {
        Alert al = new Alert(alertType);
        al.setTitle(title);
        al.setHeaderText(null);
        al.setContentText(mss);
        al.initOwner(owner);
        al.show();

    }

}
