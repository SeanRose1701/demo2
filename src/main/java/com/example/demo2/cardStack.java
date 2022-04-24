package com.example.demo2;

import java.util.ArrayList;

public class cardStack extends ArrayList<card> {

    public int currentCard = 0;
    private String stackName;

    public int nextIndex() {
        currentCard++;
        return currentCard;
    }

    public int prevIndex() {
        currentCard--;
        return currentCard;
    }

    public card getCurrentCard() {
        return this.get(currentCard);
    }
}