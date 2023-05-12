/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectallmyscens;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Wasan
 */
public class Seats2Controller implements Initializable {

    private Label label;
    @FXML
    private ImageView img;
    @FXML
    private Text textE;
    @FXML
    private Rectangle bigRec;
    @FXML
    private Text textScreen;
    @FXML
    private Text textF;
    @FXML
    private Text textTickers;
    @FXML
    private Text textStats;
    @FXML
    private Label moviename;
    @FXML
    private Button cancle;
    @FXML
    private Button confirmation;
    @FXML
    private Text textAvail;
    @FXML
    private Text textSelct;
    @FXML
    private Text textSold;
    @FXML
    private Rectangle Rec_Sold;
    @FXML
    private Rectangle Rec_Avail;
    @FXML
    private Rectangle Rec_Select;
    @FXML
    private Text textMovie;
    @FXML
    private Label TOT;
    @FXML
    private Button choose;
    @FXML
    private Button D1;
    @FXML
    private Button D2;
    @FXML
    private Button D3;
    @FXML
    private Button D4;
    @FXML
    private Button C1;
    @FXML
    private Button C2;
    @FXML
    private Button C3;
    @FXML
    private Button C4;
    @FXML
    private Button D5;
    @FXML
    private Button C5;
    @FXML
    private Button B4;
    @FXML
    private Button B5;
    @FXML
    private Button A5;
    @FXML
    private Button A4;
    @FXML
    private Button A2;
    @FXML
    private Button B1;
    @FXML
    private Button B2;
    @FXML
    private Button A3;
    @FXML
    private Button B3;
    @FXML
    private Button A1;
    @FXML
    private Text textE1;
    @FXML
    private Text textE2;

    ArrayList<Button> seats = new ArrayList<>();
    @FXML
    private Label tickets;
    @FXML
    private Label seatsSelected;

    String chosenSeats = "";
    private Stage stage;
    private Scene scene;
    @FXML
    private Label tot;
     int amount = 0;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void chooseSeat(ActionEvent event) {

        chosenSeats = "";
        Button seat = (Button) event.getSource();
        System.out.println(seat.getText());
        if (seats.contains(seat)) {
            seats.remove(seat);
            seat.setStyle("-fx-background-color:#afb4b9");
        } else {
            seats.add(seat);
            seat.setStyle("-fx-background-color:#70b3f2");
        }
        System.out.println(seats.toString());

        for (Button btn : seats) {
            chosenSeats += btn.getText() + ",";
        }
        if (seats.size() > 0) {
            chosenSeats = chosenSeats.substring(0, chosenSeats.length() - 1);
        }
        seatsSelected.setText(chosenSeats);

        tickets.setText(seats.size() + "");
        if(seats.size()>0){
                amount+=25;
                tot.setText(amount+" $ ");
            }
    }

    @FXML
    private void doChooseSeats(ActionEvent event) {

        for (Button btn : seats) {
            btn.setStyle("-fx-background-color:#fc3f3f");
        }
    }

    @FXML
    private void doCancel(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Screen2.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void doConfirmation(ActionEvent event) throws IOException {
        //chosenSeats
        System.out.println(chosenSeats);
        Parent root = FXMLLoader.load(getClass().getResource("Ckeckout.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void mouseMove(MouseEvent event) {
        Button seat = (Button) event.getSource();
        seat.setStyle("-fx-background-color:#ddff");;
    }

    @FXML
    private void mouseExit(MouseEvent event) {
        Button seat = (Button) event.getSource();
        seat.setStyle("-fx-background-color:#dddd");;
    }
}