import javax.swing.*;
import java.awt.*;

public class PlusMinusView extends JFrame {
    private JButton buttonMinus;
    private JButton buttonPlus;
    private JLabel labelLautstaerke;

    public PlusMinusView() {
        setTitle("Lautstärke");
        setSize(400, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
