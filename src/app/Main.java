package app;

import presenter.IPlusMinusPresenter;
import presenter.PlusMinusPresenter;
import presenter.ISliderPresenter;
import presenter.SliderPresenter;
import model.IModel;
import model.LautstaerkeModel;
import view.PlusMinusView;
import view.IPlusMinusView;
import view.ISliderView;
import view.SliderView;

public class Main {
    public static void main(String[] args) {
        // Instanzen
        IModel model = new LautstaerkeModel();

        IPlusMinusPresenter presenter1 = new PlusMinusPresenter();
        IPlusMinusView view1 = new PlusMinusView();

        ISliderPresenter presenter2 = new SliderPresenter();
        ISliderView view2 = new SliderView();

        // Verdrahten
        presenter1.setView(view1);
        presenter1.setModel(model);
        view1.setPresenter(presenter1);

        presenter2.setView(view2);
        presenter2.setModel(model);
        view2.setPresenter(presenter2);

        // Anfangswert
        model.setLautstaerke(3.5);
    }
}
