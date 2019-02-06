package model;

import view.Observer;

import java.util.ArrayList;
import java.util.List;

public class LautstaerkeModel {
    // Daten
    private double lautstaerke;

    // für MVC
    private List<Observer> views;

    public LautstaerkeModel() {
        this.views = new ArrayList<>();
        this.lautstaerke = 3.0;
    }

    // für MVC
    public void setView(Observer view) {
        this.views.add(view);
    }

    public double getLautstaerke() {
        return lautstaerke;
    }

    public void setLautstaerke(double lautstaerke) {
        if(lautstaerke > 10.0){
            lautstaerke = 10.0;
        }
        if(lautstaerke < 0.0){
            lautstaerke = 0.0;
        }
        this.lautstaerke = lautstaerke;

        // view.Observer benachrichtigen
        for (Observer view : views) {
            view.update();
        }
    }
}
