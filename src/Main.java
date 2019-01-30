public class Main {
    public static void main(String[] args) {
        LautstaerkeModel model = new LautstaerkeModel();
        new PlusMinusView(model);

        model.setLautstaerke(7.5);
        model.setLautstaerke(3.5);
    }
}
