package app;

import controller.PlusMinusPresenter;
import controller.SliderPresenter;
import model.LautstaerkeModel;
import view.PlusMinusView;
import view.SliderView;

public class Main {
    public static void main(String[] args) {
        // Instanzen
        LautstaerkeModel model = new LautstaerkeModel();

        PlusMinusPresenter presenter1 = new PlusMinusPresenter();
        PlusMinusView view1 = new PlusMinusView();

        SliderPresenter presenter2 = new SliderPresenter();
        SliderView view2 = new SliderView();

        // Verdrahten
        presenter1.setView(view1);
        presenter1.setModel(model);
        model.setObserver(presenter1);
        view1.setPresenter(presenter1);

        presenter2.setView(view2);
        presenter2.setModel(model);
        model.setObserver(presenter2);
        view1.setPresenter(presenter2);

        model.setLautstaerke(3.5);
    }
}
