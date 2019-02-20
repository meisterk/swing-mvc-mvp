package model;

import view.Observer;

public interface IModel {
    double getLautstaerke();
    void setLautstaerke(double lautstaerke);

    void setObserver(Observer presenter);
}
