package controller;

import model.LautstaerkeModel;
import view.Observer;
import view.SliderView;

public class SliderPresenter implements Observer {
    // MVP
    private LautstaerkeModel model;
    private SliderView view;

    // MVP
    public void setModel(LautstaerkeModel model) {
        this.model = model;
    }

    public void setView(SliderView view) {
        this.view = view;
    }

    // Events
    public void changeEvent() {
        int sliderwert = view.getSliderWert();
        model.setLautstaerke(sliderwert/2.0);
    }

    @Override
    public void update() {

    }
}
