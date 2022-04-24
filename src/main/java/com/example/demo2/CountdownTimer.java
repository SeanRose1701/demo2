package com.example.demo2;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.text.DecimalFormat;
import java.util.Timer;


/**
 * This class creates a pomodoro timer
 */
public class CountdownTimer extends Application {


    // declare variables
    Timer timer;
    Label countdownLabel;
    Button startButton;

    // holds state of user (working,resting)
    boolean isWorking;

    // holds the time a user works in a complete work period
    int initSec;
    int initMin;

    // holds values for timer updates
    int second;
    String ddSecond;
    int minute;
    String ddMinute;
    DecimalFormat dFormat = new DecimalFormat("00");

    // holds work periods remaining,time in rest period
    int workRemaining;
    int restPeriodTime;


    final Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1),ev-> {
        reduceSecond();
    }));

    // sliders
    Slider workPeriodsRemainingSlider;
    Slider restTimeSlider;



    @Override
    public void start(Stage stage) throws Exception {

        // set cycle count for timeline
        timeline.setCycleCount(Animation.INDEFINITE);

        // set title
        stage.setTitle("Pomodoro Timer");

        // create text object
        Text title = new Text();

        // set title text,font
        title.setText("Pomodoro Timer");
        title.setFont(new Font(40));

        // create text field for seconds; set prompt text
        TextField second_field = new TextField();
        second_field.setPromptText("Enter Seconds");

        // create text field for minutes; set prompt text
        TextField minute_field = new TextField();
        minute_field.setPromptText("Enter Minutes");

        // create slider label
        Label workSliderLabel = new Label();

        // create slider for number of time periods to work
        workPeriodsRemainingSlider = new Slider(1,5,1);
        workPeriodsRemainingSlider.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(
                    ObservableValue<? extends Number> observableValue,
                    Number oldValue,
                    Number newValue) {
                workSliderLabel.textProperty().setValue(
                        "Work Periods: "+String.valueOf(newValue.intValue()));
            }
        });

        // set slider label text
        workSliderLabel.setText("Work Periods: "+String.valueOf(workPeriodsRemainingSlider.getValue()));

        // create slider label
        Label restTimeSliderLabel = new Label();

        // create slider for number of time periods to work
        restTimeSlider = new Slider(5,15,5);
        restTimeSlider.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(
                    ObservableValue<? extends Number> observableValue,
                    Number oldValue,
                    Number newValue) {
                restTimeSliderLabel.textProperty().setValue(
                        "Rest Times: "+String.valueOf(newValue.intValue()));
            }
        });

        // set slider label text
        restTimeSliderLabel.setText("Rest Times: "+String.valueOf(workPeriodsRemainingSlider.getValue()));

        // create start button
        startButton = new Button();
        startButton.setText("Start");
        startButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent actionEvent) {
                try
                {
                    startButton.setDisable(true);
                    workPeriodsRemainingSlider.disableProperty().setValue(true);
                    restTimeSlider.disableProperty().setValue(true);
                    isWorking = true;
                    workRemaining = (int) workPeriodsRemainingSlider.getValue();
                    restPeriodTime = (int) restTimeSlider.getValue();
                    second = Integer.parseInt(second_field.getText());
                    minute = Integer.parseInt(minute_field.getText());
                    initSec = second;
                    initMin = minute;
                    timeline.play();
                }
                catch(NumberFormatException e)
                {
                    System.out.println("Error");
                }
            }
        });

        Button resetButton = new Button();
        resetButton.setText("Reset");
        resetButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                timeline.pause();
                isWorking = false;
                workPeriodsRemainingSlider.disableProperty().setValue(false);
                startButton.setDisable(false);
                countdownLabel.setText("00:00");


            }
        });

        countdownLabel = new Label();
        countdownLabel.setText("00:00");
        countdownLabel.setFont(new Font("Arial",200));


        // text-fields, slider
        HBox fieldBoxes = new HBox(minute_field,second_field);
        fieldBoxes.setSpacing(10);
        fieldBoxes.setPadding(new Insets(0,0,0,80));


        // buttons
        HBox buttonsBoxes = new HBox(startButton,resetButton);
        buttonsBoxes.setSpacing(20);
        buttonsBoxes.setPadding(new Insets(0,0,0,200));

        HBox slidersBoxes = new HBox(workSliderLabel,workPeriodsRemainingSlider,restTimeSliderLabel,restTimeSlider);
        slidersBoxes.setSpacing(20);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);


        grid.add(title,16,1);
        GridPane.setHalignment(title,HPos.CENTER);

        grid.add(fieldBoxes,16,5);
        GridPane.setHalignment(fieldBoxes,HPos.CENTER);
        GridPane.setValignment(fieldBoxes,VPos.CENTER);
        GridPane.setFillWidth(fieldBoxes,true);

        grid.add(slidersBoxes,16,6);
        GridPane.setHalignment(slidersBoxes,HPos.CENTER);
        GridPane.setValignment(slidersBoxes,VPos.CENTER);
        GridPane.setFillWidth(slidersBoxes,true);



        grid.add(countdownLabel,16,8);
        GridPane.setHalignment(countdownLabel, HPos.CENTER);
        GridPane.setValignment(countdownLabel, VPos.CENTER);
        GridPane.setFillWidth(countdownLabel,true);

        grid.add(buttonsBoxes,16,15);
        GridPane.setHalignment(buttonsBoxes,HPos.CENTER);
        GridPane.setValignment(buttonsBoxes,VPos.CENTER);
        GridPane.setFillWidth(buttonsBoxes,true);


        Scene scene = new Scene(grid,800,500);


        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }


    public void reduceSecond() {

        second--;
        ddSecond = dFormat.format(second);
        ddMinute = dFormat.format(minute);
        countdownLabel.setText(ddMinute + ":" + ddSecond);

        if(second==-1) {
            second = 59;
            minute--;
            ddSecond = dFormat.format(second);
            ddMinute = dFormat.format(minute);
            countdownLabel.setText(ddMinute + ":" + ddSecond);
        }

        if(minute==0 && second==0) {

            // finished work period,all work done: end timer
            if (isWorking && workRemaining == 0)
            {
                workPeriodsRemainingSlider.setDisable(false);
                startButton.setDisable(false);
                isWorking = false;
                timeline.pause();
            }

            // finished work period, more work to do: init rest period
            else if(isWorking && workRemaining > 0)
            {
                workRemaining--;
                isWorking = false;
                minute = (int) restPeriodTime;
                second = 0;
            }

            // finished rest period
            else if(!isWorking && workRemaining > 0)
            {
                minute = initMin;
                second = initSec;
                isWorking = true;
            }
        }
    }


    public static void main() {
        launch();
    }



}