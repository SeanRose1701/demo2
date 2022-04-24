package com.example.demo2;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    public ProgressBar deckProgressBar;
    public cardStack planets = new cardStack();
    public TextArea cardDisplay;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        populatePlanets();
        cardDisplay.setText(planets.getCurrentCard().getPrompt());
    }

    @FXML
    protected void onHelloButtonClick() {
        System.out.println("Hello!");
    }

    private void populatePlanets() {
        String[] planetsList = {"venus", "mercury", "earth", "mars", "saturn", "jupiter", "neptune", "uranus"};

        for (int i = 0; i < planetsList.length; i++) {
            int k = i + 1;
            planets.add(new card("what's planet " + k + " called?", planetsList[i]));
        }
    }

    public void nextCard() {
        deckProgressBar.setProgress(deckProgressBar.getProgress() + 0.125);

        planets.nextIndex();
        cardDisplay.setText(planets.getCurrentCard().getPrompt());
    }

    public void prevCard() {
        deckProgressBar.setProgress(deckProgressBar.getProgress() - 0.125);

        planets.prevIndex();
        cardDisplay.setText(planets.getCurrentCard().getPrompt());
    }

    public void flipCard() {
        if (cardDisplay.getText().equals(planets.getCurrentCard().getAnswer())) {
            cardDisplay.setText(planets.getCurrentCard().getPrompt());
        } else {
            cardDisplay.setText(planets.getCurrentCard().getAnswer());
        }
    }

    public void openTimer() {
        Stage stage = new Stage();
        CountdownTimer timer = new CountdownTimer();
        try {
            timer.start(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void openNotepad() {
        Notepad.main();
    }

    public void createTips() {
        Pop_up.display("Tip", tips.ChangeTip());
    }


}