package controller;

import model.LautstaerkeModel;
import view.Observer;
import view.PlusMinusView;

public class PlusMinusController implements Observer {
    // MVC
    private LautstaerkeModel model;
    private PlusMinusView view;

    public PlusMinusController(LautstaerkeModel model, PlusMinusView view) {
        this.model = model;
        this.view = view;
        this.model.setObserver(this);
    }

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

    @Override
    public void update() {
        double neueLautstaerke = model.getLautstaerke();
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
