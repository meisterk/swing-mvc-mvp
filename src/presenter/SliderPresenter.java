package presenter;

import model.IModel;
import view.Observer;
import view.ISliderView;

public class SliderPresenter implements Observer, ISliderPresenter {
    // MVP
    private IModel model;
    private ISliderView view;

    // MVP
    public void setModel(IModel model) {
        this.model = model;
        this.model.setObserver(this);
    }

    public void setView(ISliderView view) {
        this.view = view;
    }

    // Events
    @Override
    public void changeEvent() {
        int sliderwert = view.getSliderWert();
        model.setLautstaerke(sliderwert/2.0);
    }

    @Override
    public void update() {
        // Neuen Daten holen
        double neueLautstaerke = model.getLautstaerke();

        // View aktualisieren
        view.setSliderWert((int)(neueLautstaerke * 2.0));
        view.setLautstaerkeText(String.format("%.1f \uD83D\uDD0A", neueLautstaerke));
    }
}
