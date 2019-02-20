package view;

import presenter.IPlusMinusPresenter;

public interface IPlusMinusView {
    void setLautstaerke(String lautstaerke);
    void minusButtonAktivieren();
    void minusButtonDeaktivieren();
    void plusButtonAktivieren();
    void plusButtonDeaktivieren();

    void setPresenter(IPlusMinusPresenter presenter1);
}
