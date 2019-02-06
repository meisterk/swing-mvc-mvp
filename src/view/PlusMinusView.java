package view;

import model.LautstaerkeModel;

import javax.swing.*;
import java.awt.*;

public class PlusMinusView extends JFrame implements Observer {
    // GUI
    private JButton buttonMinus;
    private JButton buttonPlus;
    private JLabel labelLautstaerke;

    // MVC
    private LautstaerkeModel model;

    public PlusMinusView(LautstaerkeModel model) {
        // MVC
        this.model = model;
        model.setView(this);

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

    @Override
    public void update() {
        double lautstaerke = model.getLautstaerke();
        labelLautstaerke.setText(String. format("%.1f", lautstaerke));
    }
}