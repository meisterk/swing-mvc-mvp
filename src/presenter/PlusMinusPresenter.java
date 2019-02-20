package presenter;

import model.IModel;
import view.Observer;
import view.IPlusMinusView;

public class PlusMinusPresenter implements Observer, IPlusMinusPresenter {
    // MVP
    private IModel model;
    private IPlusMinusView view;

    // MVP
    public void setView(IPlusMinusView view) {
        this.view = view;
    }

    public void setModel(IModel model) {
        this.model = model;
        this.model.setObserver(this);
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
        // Neue Daten holen
        double neueLautstaerke = model.getLautstaerke();

        // View aktualisieren
        view.setLautstaerke(String.format("%.1f \uD83D\uDD0A", neueLautstaerke));

        // Buttons (de)aktivieren
        if (neueLautstaerke <= 0.0) {
            view.minusButtonDeaktivieren();
            view.plusButtonAktivieren();
        } else {
            if (neueLautstaerke < 10.0) {
                view.minusButtonAktivieren();
                view.plusButtonAktivieren();
            } else {
                view.minusButtonAktivieren();
                view.plusButtonDeaktivieren();
            }
        }
    }
}
