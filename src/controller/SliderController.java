package controller;

import model.LautstaerkeModel;
import view.SliderView;

public class SliderController {
    private LautstaerkeModel model;
    private SliderView view;

    public SliderController(LautstaerkeModel model, SliderView view) {
        this.model = model;
        this.view = view;
    }

    public void changeEvent() {
        int sliderwert = view.getSliderWert();
        model.setLautstaerke(sliderwert/2.0);
    }
}
