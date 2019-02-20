package presenter;

import model.IModel;
import view.ISliderView;

public interface ISliderPresenter {
    void changeEvent();

    void setView(ISliderView view2);

    void setModel(IModel model);
}
