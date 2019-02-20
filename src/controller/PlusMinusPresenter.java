package controller;

import model.LautstaerkeModel;
import view.Observer;
import view.PlusMinusView;

public class PlusMinusPresenter implements Observer {
    // MVP
    private LautstaerkeModel model;
    private PlusMinusView view;

    // MVP
    public void setView(PlusMinusView view) {
        this.view = view;
    }

    public void setModel(LautstaerkeModel model) {
        this.model = model;
    }

    // Events
    public void minusEvent() {
        double alteLautstaerke = model.getLautstaerke();
        double neueLautstaerke = alteLautstaerke - 0.5;
        model.setLautstaerke(neueLautstaerke);
    }

    public void plusEvent() {
        double alteLautstaerke = model.getLautstaerke();
        double neueLautstaerke = alteLautstaerke + 0.5;
        model.setLautstaerke(neueLautstaerke);
    }

    // Observer
    @Override
    public void update() {
        double neueLautstaerke = model.getLautstaerke();
        // View aktualisieren
        view.setLautstaerke(String.format("%.1f \uD83D\uDD0A", neueLautstaerke));

        // Buttons (de)aktivieren
        if(neueLautstaerke <= 0.0){
            view.minusButtonDeaktivieren();
            view.plusButtonAktivieren();
        }else{
            if(neueLautstaerke < 10.0){
                view.minusButtonAktivieren();
                view.plusButtonAktivieren();
            }else{
                view.minusButtonAktivieren();
                view.plusButtonDeaktivieren();
            }
        }
    }
}
