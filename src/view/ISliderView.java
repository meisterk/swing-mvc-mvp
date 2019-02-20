package view;

import presenter.ISliderPresenter;

public interface ISliderView {
    int getSliderWert();
    void setSliderWert(int sliderWert);
    void setLautstaerkeText(String lautstaerke);

    void setPresenter(ISliderPresenter presenter2);
}
