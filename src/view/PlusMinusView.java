package view;

import controller.PlusMinusPresenter;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlusMinusView extends JFrame {
    // GUI
    private JButton buttonMinus;
    private JButton buttonPlus;
    private JLabel labelLautstaerke;

    // MVP
    private PlusMinusPresenter presenter;

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

        // Eventhandler
        buttonMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                presenter.minusEvent();
            }
        });

        buttonPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                presenter.plusEvent();
            }
        });

        setVisible(true);
    }

    // MVP
    public void setPresenter(PlusMinusPresenter presenter) {
        this.presenter = presenter;
    }

    // Darstellung ändern durch Presenter
    public void setLautstaerke(String lautstaerke){
        labelLautstaerke.setText(lautstaerke);
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
