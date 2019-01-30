public class LautstaerkeModel {
    private double lautstaerke;

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
    }
}
