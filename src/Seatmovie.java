/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectallmyscens;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Seatmovie extends Application {

  public static  Scene sc = null;
  public static Stage appStage;
    Label title;
    Label screen,one,two,three,four,five,six,seven,eight,nine,ten;
    Label f1,f2;
    Label movie,tickets,total,seats,movie_ans,tickets_ans,total_ans,seats_ans,available,sold,selected;
    Button book,b_available,b_sold,b_selected;

    Button E1,E2,E3,E4,E5,E6,E7,E8,E9,E10;
    Button F1,F2,F3,F4,F5,F6,F7,F8,F9,F10,confirmation,cancelbtn;
    

    String grey = "-fx-background-color:#B2BEB5";
    String blue = "-fx-background-color:#70b3f2";

    String[] btn = {"E0","E1","E2","E3","E4","E5","E6","E7","E8","E9","F0","F1","F2","F3","F4","F5","F6","F7","F8","F9"};
    String[] btn_clr = {grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey};
    Button[] all_btn = {E1,E2,E3,E4,E5,E6,E7,E8,E9,E10,F1,F2,F3,F4,F5,F6,F7,F8,F9,F10};
    Button[] selected_btn = new Button[20];

    String seats_val = "";
    int ticket = 0;
    int amount = 0;
    int count = 0;

    String clr;


    public void setDisplay(Button b, int indx){
      
        clr = btn_clr[indx];
        
        if(clr==grey){
            b.setStyle(blue);
            btn_clr[indx] = blue;
            ticket++;
            if(indx<12){
                amount+=12;
                total_ans.setText(": $ "+amount);
            }
          
            else{
                amount+=20;
                total_ans.setText(": $ "+amount);
            }
            tickets_ans.setText(": "+ticket);
            selected_btn[indx] = b;
            seats_val = ": ";
            for(int i=0;i<20;i++){
                if(selected_btn[i]!=null){
                    seats_val+=(btn[i]+" ");
                }
            }
            seats_ans.setText(seats_val);
        }
        else if(clr==blue){
            b.setStyle(grey);
            btn_clr[indx] = grey;
            ticket--;
            if(indx<14){
                amount-=12;
                total_ans.setText(": $ "+amount);
            }
            
            else{
                amount-=20;
                total_ans.setText(": $ "+amount);
            }
            tickets_ans.setText(": "+ticket);
            selected_btn[indx] = null;
            seats_val = ": ";
            for(int i=0;i<20;i++){
                if(selected_btn[i]!=null){
                    seats_val+=(btn[i]+" ");
                }
            }
            seats_ans.setText(seats_val);
        }

    }

    @Override
    public void start(Stage stage) throws Exception {

  
        screen = new Label("SCREEN");
        screen.setStyle("-fx-background-color: #dc559d;");
        screen.setPrefSize(348,35);
        screen.setAlignment(Pos.CENTER);
        screen.setFont(new Font("Verdana",15));
        screen.setTextFill(Color.rgb(255,255,255));
        f1 = new Label("");
        f1.setPrefSize(15,35);
        
        f2 = new Label("");
        f2.setPrefSize(15,35);

        int[] label_btn = {0,1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8,9};

 
        for(int i = 0; i<20; i++){
            all_btn[i] = new Button(label_btn[i]+"");
            all_btn[i].setPrefSize(30,35);
            all_btn[i].setStyle(grey);
            all_btn[i].setTextFill(Color.web("#9e306f"));
        }

        one = new Label("E");
        one.setPrefSize(15,35);
        

        two = new Label("F");
        two.setPrefSize(15,35);

        HBox hb1 = new HBox();
        HBox hb2 = new HBox();
        

       
        hb1.getChildren().addAll(one,all_btn[0],all_btn[1],all_btn[2],all_btn[3],all_btn[4],all_btn[5],all_btn[6],all_btn[7],all_btn[8],all_btn[9]);
        hb1.setSpacing(5);
        hb1.setPadding(new Insets(5,5,5,20));

        hb2.getChildren().addAll(two,all_btn[10],all_btn[11],all_btn[12],all_btn[13],all_btn[14],all_btn[15],all_btn[16],all_btn[17],all_btn[18],all_btn[19]);
        hb2.setSpacing(5);
        hb2.setPadding(new Insets(5,5,5,20));
        
        HBox scn = new HBox();
        scn.getChildren().addAll(f2,screen);
        scn.setSpacing(5);
        scn.setPadding(new Insets(5,10,20,20));
        
        confirmation = new Button();
        confirmation.setText("confirmation");
        confirmation.setTextFill(Color.web("#9e306f"));
        
        cancelbtn = new Button();
        cancelbtn.setText("cancel");
        cancelbtn.setTextFill(Color.web("#9e306f"));
        
        HBox but = new HBox(10);
        but.setAlignment(Pos.TOP_CENTER);
        but.setMinSize(430,0);
        but.getChildren().addAll(cancelbtn,confirmation);
        
        
        VBox vb1 = new VBox();
        vb1.setAlignment(Pos.TOP_CENTER);
        vb1.setMinSize(430,0);
        vb1.getChildren().addAll(scn,hb1,hb2,f1,but);
        
        
        all_btn[0].setOnAction(e->setDisplay(all_btn[0],0));
        all_btn[1].setOnAction(e->setDisplay(all_btn[1],1));
        all_btn[2].setOnAction(e->setDisplay(all_btn[2],2));
        all_btn[3].setOnAction(e->setDisplay(all_btn[3],3));
        all_btn[4].setOnAction(e->setDisplay(all_btn[4],4));
        all_btn[5].setOnAction(e->setDisplay(all_btn[5],5));
        all_btn[6].setOnAction(e->setDisplay(all_btn[6],6));
        all_btn[7].setOnAction(e->setDisplay(all_btn[7],7));
        all_btn[8].setOnAction(e->setDisplay(all_btn[8],8));
        all_btn[9].setOnAction(e->setDisplay(all_btn[9],9));
        all_btn[10].setOnAction(e->setDisplay(all_btn[10],10));
        all_btn[11].setOnAction(e->setDisplay(all_btn[11],11));
        all_btn[12].setOnAction(e->setDisplay(all_btn[12],12));
        all_btn[13].setOnAction(e->setDisplay(all_btn[13],13));
        all_btn[14].setOnAction(e->setDisplay(all_btn[14],14));
        all_btn[15].setOnAction(e->setDisplay(all_btn[15],15));
        all_btn[16].setOnAction(e->setDisplay(all_btn[16],16));
        all_btn[17].setOnAction(e->setDisplay(all_btn[17],17));
        all_btn[18].setOnAction(e->setDisplay(all_btn[18],18));
        all_btn[19].setOnAction(e->setDisplay(all_btn[19],19));


        movie = new Label("Movie");
        movie.setFont(new Font("Verdana",14));
        movie.setTextFill(Color.web("#9e306f"));
        movie.setPrefSize(70,25);

        tickets = new Label("Tickets");
        tickets.setFont(new Font("Verdana",14));
        tickets.setTextFill(Color.web("#9e306f"));
        tickets.setPrefSize(70,25);

        total = new Label("Total");
        total.setFont(new Font("Verdana",14));
        total.setTextFill(Color.web("#9e306f"));
        total.setPrefSize(70,25);

        seats = new Label("Seats");
        seats.setFont(new Font("Verdana",14));
        seats.setTextFill(Color.web("#9e306f"));
        seats.setPrefSize(70,25);

        movie_ans = new Label(": ONE PIECE FILM RED");
        movie_ans.setFont(new Font("Verdana",14));
        movie_ans.setPrefSize(200,25);


        tickets_ans = new Label(": 0");
        tickets_ans.setFont(new Font("Verdana",14));
        tickets_ans.setPrefSize(200,25);

        total_ans = new Label(": $ 0");
        total_ans.setFont(new Font("Verdana",14));
        total_ans.setPrefSize(200,25);

        seats_ans = new Label(": ");
        seats_ans.setFont(new Font("Verdana",14));
        seats_ans.setPrefSize(2200,25);

        
        book = new Button("Choose the seat");
        book.setStyle("-fx-background-color: #9e306f");
        book.setTextFill(Color.rgb(255,255,255));
        book.setFont(new Font("Verdana",14));
        book.setPadding(new Insets(8,8,8,8));
        
        book.setOnAction(e->{
            for(int i=0;i<20;i++){
                if(selected_btn[i]!=null){
                    selected_btn[i].setStyle("-fx-background-color:#EE4B2B");
                    
                    selected_btn[i].setOnAction(f->{});
                }
            }
            tickets_ans.setText(": 0");
            total_ans.setText(": $ 0");
            seats_ans.setText(": ");
            seats_val = ": ";
            count += ticket;
        
            if(count==all_btn.length){
                book.setDisable(true);
            }
            ticket = 0;
            amount = 0;
            Button[] temp_btn = new Button[20];
            selected_btn = temp_btn;
        });

        b_available = new Button();
        b_available.setStyle("-fx-background-color:#B2BEB5");
        b_available.setPrefSize(30,35);

        b_sold = new Button();
        b_sold.setStyle("-fx-background-color:#EE4B2B");
        b_sold.setPrefSize(30,35);

        b_selected = new Button();
        b_selected.setStyle("-fx-background-color:#70b3f2");
        b_selected.setPrefSize(30,35);

        available = new Label("Available");
        available.setFont(new Font("Verdana",14));
        available.setAlignment(Pos.CENTER_LEFT);
        available.setPadding(new Insets(7,50,5,3));

        sold = new Label("Sold");
        sold.setFont(new Font("Verdana",14));
        sold.setAlignment(Pos.CENTER_LEFT);
        sold.setPadding(new Insets(7,50,5,3));

        selected = new Label("Selected");
        selected.setFont(new Font("Verdana",14));
        selected.setAlignment(Pos.CENTER_LEFT);
        selected.setPadding(new Insets(7,50,5,3));
       
        VBox temp1 = new VBox();
        temp1.getChildren().addAll(movie,tickets,total,seats);
        temp1.setMinSize(70,0);

        VBox temp2 = new VBox();
        temp2.getChildren().addAll(movie_ans,tickets_ans,total_ans,seats_ans);
        temp2.setMinSize(70,0);

        HBox h1 = new HBox();
        h1.getChildren().addAll(temp1,temp2);
        h1.setPadding(new Insets(5,5,5,5));
        h1.setSpacing(10);

        HBox h6 = new HBox();
        h6.getChildren().add(book);
        h6.setPadding(new Insets(20,5,20,5));
        h6.setSpacing(10);

        HBox h7 = new HBox();
        h7.getChildren().addAll(b_available,available);
        h7.setPadding(new Insets(5,5,5,5));
        h7.setSpacing(10);

        HBox h8 = new HBox();
        h8.getChildren().addAll(b_sold,sold);
        h8.setPadding(new Insets(5,5,5,5));
        h8.setSpacing(10);

        HBox h9 = new HBox();
        h9.getChildren().addAll(b_selected,selected);
        h9.setPadding(new Insets(5,5,5,5));
        h9.setSpacing(10);

     
        Separator s = new Separator();
        s.setOrientation(Orientation.VERTICAL);
        s.setMinSize(20,0);

        VBox vb2 = new VBox();
        vb2.getChildren().addAll(h1,h6,h7,h8,h9);
        vb2.setMaxSize(2500,2500);

        HBox mainHB = new HBox();
        mainHB.getChildren().addAll(vb1,s,vb2);

        VBox mainVB = new VBox();
        mainVB.setAlignment(Pos.TOP_CENTER);
        mainVB.getChildren().addAll(mainHB);
        
        Image image = new Image("https://c.top4top.io/p_249946m5l1.jpg");
        
        ImageView imageView = new ImageView(image);
        imageView.setX(0);
        imageView.setY(0);
        imageView.setFitHeight(400);
        imageView.setFitWidth(650);
        
        StackPane pane=new StackPane();
        pane.getChildren().addAll(imageView,mainVB);
 
        
       sc = new Scene(pane,650,400);
        stage.setScene(sc);
        stage.show();
        stage.setTitle("cinema seat");
        stage.setMinHeight(200);
        stage.setMinWidth(300);
        appStage=stage;
 

          confirmation.setOnAction(e -> {
           
           System.out.print("here");
           Parent root2;
            try {
                root2 = FXMLLoader.load(getClass().getResource("Ckeckout.fxml"));
                 Scene scene = new Scene(root2);

                stage.setTitle("--");
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(Seatmovie.class.getName()).log(Level.SEVERE, null, ex);
            }        
        });
          
          cancelbtn.setOnAction(e -> {
           
           System.out.print("here");
           Parent root3;
            try {
                root3 = FXMLLoader.load(getClass().getResource("Screen1.fxml"));
                 Scene scene = new Scene(root3);

                stage.setTitle("FXML Welcome");
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(Seatmovie.class.getName()).log(Level.SEVERE, null, ex);
            }        
        });
        
    }
   
    

}
