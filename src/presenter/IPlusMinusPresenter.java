package presenter;

import model.IModel;
import view.IPlusMinusView;

public interface IPlusMinusPresenter {
    void minusEvent();
    void plusEvent();
    void setModel(IModel model);

    void setView(IPlusMinusView view1);
}
