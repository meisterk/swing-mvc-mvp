package model;

import view.Observer;

import java.util.ArrayList;
import java.util.List;

public class LautstaerkeModel {
    // Daten
    private double lautstaerke;

    // für MVC
    private List<Observer> observers;

    public LautstaerkeModel() {
        this.observers = new ArrayList<>();
        this.lautstaerke = 3.0;
    }

    // für MVC
    public void setObserver(Observer view) {
        this.observers.add(view);
    }

    public double getLautstaerke() {
        return lautstaerke;
    }

    public void setLautstaerke(double lautstaerke) {
        if (lautstaerke != this.lautstaerke) {
            if (lautstaerke > 10.0) {
                lautstaerke = 10.0;
            }
            if (lautstaerke < 0.0) {
                lautstaerke = 0.0;
            }
            this.lautstaerke = lautstaerke;

            // view.Observer benachrichtigen
            for (Observer observer : observers) {
                observer.update();
            }
        }
    }
}
