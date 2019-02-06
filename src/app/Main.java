package app;

import model.LautstaerkeModel;
import view.PlusMinusView;
import view.SliderView;

public class Main {
    public static void main(String[] args) {
        // Model
        LautstaerkeModel model = new LautstaerkeModel();

        // Views
        new PlusMinusView(model);
        new SliderView(model);

        // TODO SliderController

        model.setLautstaerke(7.5);
        model.setLautstaerke(3.5);
    }
}
