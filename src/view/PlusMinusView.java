package view;

import controller.PlusMinusController;
import model.LautstaerkeModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlusMinusView extends JFrame implements Observer {
    // GUI
    private JButton buttonMinus;
    private JButton buttonPlus;
    private JLabel labelLautstaerke;

    // MVC
    private LautstaerkeModel model;
    private PlusMinusController controller;

    public PlusMinusView(LautstaerkeModel model) {
        // MVC
        this.model = model;
        model.setObserver(this);
        controller = new PlusMinusController(model, this);

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

        // Eventhandler
        buttonMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.minusEvent();
            }
        });

        buttonPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.plusEvent();
            }
        });

        setVisible(true);
    }

    @Override
    public void update() {
        double lautstaerke = model.getLautstaerke();
        labelLautstaerke.setText(String.format("%.1f", lautstaerke));
    }

    public void minusButtonAktivieren() {
        buttonMinus.setEnabled(true);
    }

    public void minusButtonDeaktivieren() {
        buttonMinus.setEnabled(false);
    }

    public void plusButtonAktivieren() {
        buttonPlus.setEnabled(true);
    }

    public void plusButtonDeaktivieren() {
        buttonPlus.setEnabled(false);
    }
}
