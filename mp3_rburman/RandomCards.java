package com.example.mp3_rburman;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class RandomCards extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    Button btn = new Button("Refresh"); //creats the button

    static ArrayList<Integer> numbers = new ArrayList<>();  //creates an arraylist that will have all the numbers
    static ArrayList<Integer> fourNumbers = new ArrayList<>();  //will be used to have the numbers for the four cards

    public void resetFourNumbers() {
        for (int i = 0; i < 4; i++) {  //chooses the 4 numbers that the cards will be the cards
            int random = (int) (Math.random() * numbers.size());
            fourNumbers.add(random);
            numbers.remove(random);
        }
    }

    @Override
    public void start(Stage primaryStage) {

        for (int i = 1; i< 53; i++){  //fills the array with numbers 1-52
            numbers.add(i);
        }

        resetFourNumbers();

        GridPane gridPane = new GridPane();  //formatting
        BorderPane borderPane = new BorderPane();
        borderPane.setBottom(gridPane);
        gridPane.setHgap(30);
        ImageView imageView = new ImageView(new Image("C:\\Users\\rhysb\\MP3_rburman\\src\\main\\java\\com\\example\\mp3_rburman\\card\\b1fh.png")); //imports a photo that looks like a deck of cards
        StackPane topPane = new StackPane(imageView);
        borderPane.setTop(topPane);
        StackPane centerPane = new StackPane(btn);
        borderPane.setCenter(centerPane);

        btn.setOnAction(e -> {  //displays 4 flipped over cards when refresh is displayed
            for(int i = 0; i < 4; i++) {
                gridPane.add(new StackPane(new ImageView(new Image("C:\\Users\\rhysb\\MP3_rburman\\src\\main\\java\\com\\example\\mp3_rburman\\card\\backCard.png"))), i, 0);
                gridPane.setAlignment(Pos.CENTER);
            }
            resetFourNumbers();
        });

        btn.setOnAction(e -> {  //displays 4 flipped over cards when refresh is displayed
            for(int i = 0; i < 4; i++) {
                gridPane.add(new StackPane(new ImageView(new Image("C:\\Users\\rhysb\\MP3_rburman\\src\\main\\java\\com\\example\\mp3_rburman\\card\\backCard.png"))), i, 0);
                gridPane.setAlignment(Pos.CENTER);
            }
            resetFourNumbers();
            System.out.println("this.that");
        });

        gridPane.setOnMousePressed(e -> { //depending on which card is clicked, the card will be flipped over to reveal what the card is
            if (e.getSceneX() > 70.0 && e.getSceneX() < 130.0){  //uses coordinates to determine which card is clicked
                gridPane.add(new ImageView(new Image("C:\\Users\\rhysb\\MP3_rburman\\src\\main\\java\\com\\example\\mp3_rburman\\card\\" + fourNumbers.get(0) + ".png")), 0, 0);
            }
            if (e.getSceneX() > 170.0 && e.getSceneX() < 230.0){
                gridPane.add(new ImageView(new Image("C:\\Users\\rhysb\\MP3_rburman\\src\\main\\java\\com\\example\\mp3_rburman\\card\\" + fourNumbers.get(1) + ".png")), 1, 0);
            }
            if (e.getSceneX() > 270.0 && e.getSceneX() < 330.0){
                gridPane.add(new ImageView(new Image("C:\\Users\\rhysb\\MP3_rburman\\src\\main\\java\\com\\example\\mp3_rburman\\card\\" + fourNumbers.get(2) + ".png")), 2, 0);
            }
            if (e.getSceneX() > 370.0 && e.getSceneX() < 430.0){
                gridPane.add(new ImageView(new Image("C:\\Users\\rhysb\\MP3_rburman\\src\\main\\java\\com\\example\\mp3_rburman\\card\\" + fourNumbers.get(3) + ".png")), 3, 0);
            }
        });

        Scene scn = new Scene(borderPane, 500,500);  //creates the scene
        primaryStage.setScene(scn);
        primaryStage.show();  //displays the scene

    }
}
