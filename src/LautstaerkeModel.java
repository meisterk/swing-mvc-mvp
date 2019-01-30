public class LautstaerkeModel {
    private double lautstaerke;
    private Observer view;

    public LautstaerkeModel() {
        this.lautstaerke = 3.0;
    }

    public void setView(Observer view) {
        this.view = view;
    }

    public double getLautstaerke() {
        return lautstaerke;
    }

    public void setLautstaerke(double lautstaerke) {
        if(lautstaerke > 10.0){
            lautstaerke = 10.0;
        }
        if(lautstaerke < 0.0){
            lautstaerke = 0.0;
        }
        this.lautstaerke = lautstaerke;

        // Observer benachrichtigen
        view.update();
    }
}
