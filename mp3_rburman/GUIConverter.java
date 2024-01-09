package com.example.mp3_rburman;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GUIConverter extends Application {
    TextField fahrenheitField = new TextField();  //creates a textfield for the Fahrenheit temp
    TextField celsiusField = new TextField();  //creates a textfield for the Celsius temp
    Button btn = new Button("Convert");  //adds a button with label convert

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();  //creates a grid pane
        grid.add(new Label("Fahrenheit"), 0, 0);
        grid.add(this.fahrenheitField, 1, 0); //adds the fahrenheit textfield
        grid.add(new Label("Celsius"), 0, 1);
        grid.add(this.celsiusField, 1, 1);  //adds the celsius textfield
        grid.add(this.btn, 0, 2);
        this.btn.setOnAction((e) -> {  //sets what should happen when the button is pressed
            double finalT; //creates a double for the temperature to be outputted

            if (this.fahrenheitField.getText().isEmpty() && this.celsiusField.getText().isEmpty()){}  //if both are empty and the button is pressed, nothing happens

            else if (this.fahrenheitField.getText().isEmpty()) {  //if fahrenheit is empty then we want to calculate the fahrenheit temperature
                finalT = Double.parseDouble(this.celsiusField.getText());  //takes in the celsius temp
                finalT = (finalT* 1.8 + 32.0); //converts using a linear equation
                this.fahrenheitField.setText(String.format("%.2f", finalT));  //displays in the fahrenheit box and rounds to two decimal places
            }

            else if (this.celsiusField.getText().isEmpty()) {  //same as above but calculates celsius
                finalT = Double.parseDouble(this.fahrenheitField.getText());
                finalT = ((finalT-32)/1.8);
                this.celsiusField.setText(String.format("%.2f", finalT));
            }

        });
        Scene scn = new Scene(grid, 500.0, 500.0); //sets the scene
        primaryStage.setScene(scn);
        primaryStage.show(); //displays the scene
    }
}
