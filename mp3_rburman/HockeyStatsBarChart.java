package com.example.mp3_rburman;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HockeyStatsBarChart extends Application {

    Scanner input;  //creates a scanner to take the input from the txt file

    public static void main(String[] args) {
        launch(args);
    } //launch code

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane; //declares the pane that the bar graph will be in



        try{
            input = new Scanner(new FileInputStream("C:\\Users\\rhysb\\MP3_rburman\\src\\main\\java\\com\\example\\mp3_rburman\\mp3_hockey_stats.txt"));  //connects the scanner to the txt file
            gridPane = new GridPane();
            gridPane.setHgap(15); //declared so there is room between the names and the bar graph
            int i = 0;  //used for formatting each new NHL team in the graph

            while (input.hasNext()){  //repeats while the txt file has more NHL teams

                String name = input.nextLine();  //stores the next line in a String
                int comma = name.indexOf(",");
                int goals = Integer.parseInt(name.substring(comma+1)); //uses the index of the comma to get the number of goals out
                name = name.substring(0, comma); //gets rid of the comma and numbers at the end

                Rectangle rectangle = new Rectangle();  //creates a new bar for the bar graph
                gridPane.add(new Label(name), 0, i);  //adds the names of the team to the grid
                gridPane.add((rectangle), 1, i);    //adds the bar to the grid

                gridPane.widthProperty().addListener(e ->{  //sets the rectangle's width equal to a percentage of the width of the bar graph. In this case it is goals/500 as 500 is the initial width
                    rectangle.setWidth(gridPane.getWidth()*goals/500);
                });
                rectangle.setHeight(10); //sets the height equal to 10 at all times

                i++;
            }


        } catch (FileNotFoundException e) {  //catch statement in case it can't find the txt file
            throw new RuntimeException(e);
        }


        Scene scn = new Scene(gridPane, 500, 500);  //creates a new scene using the grid we have made
        primaryStage.setScene(scn);
        primaryStage.show();  //displays everything
    }
}
