import javax.swing.*;
import java.awt.*;

public class PlusMinusView extends JFrame {
    private JButton buttonMinus;
    private JButton buttonPlus;
    private JLabel labelLautstaerke;

    public PlusMinusView() {
        // komplettes Fenster
        setTitle("Lautstärke");
        setSize(300, 100);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Gesamtlayout
        JPanel panelGesamt = new JPanel(new BorderLayout());
        buttonMinus = new JButton("-");
        buttonPlus = new JButton("+");
        labelLautstaerke = new JLabel("TEST");
        labelLautstaerke.setHorizontalAlignment(SwingConstants.CENTER);

        panelGesamt.add(buttonMinus, BorderLayout.WEST);
        panelGesamt.add(labelLautstaerke, BorderLayout.CENTER);
        panelGesamt.add(buttonPlus, BorderLayout.EAST);

        getContentPane().add(panelGesamt);
        setVisible(true);
    }
}
