package view;

import presenter.ISliderPresenter;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class SliderView extends JFrame implements ISliderView {
    // GUI
    private JSlider sliderLautstaerke;
    private JLabel labelLautstaerke;

    // MVP
    private ISliderPresenter presenter;

    public SliderView() {
        // komplettes Fenster
        setTitle("Lautstärke Slider");
        setSize(300, 100);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Gesamtlayout
        JPanel panelGesamt = new JPanel(new BorderLayout());
        labelLautstaerke = new JLabel("TEST");
        labelLautstaerke.setHorizontalAlignment(SwingConstants.CENTER);

        sliderLautstaerke = new JSlider();
        sliderLautstaerke.setMinimum(0);
        sliderLautstaerke.setMaximum(20);
        sliderLautstaerke.setSnapToTicks(true);
        sliderLautstaerke.setPaintTicks(true);
        sliderLautstaerke.setMinorTickSpacing(1);
        sliderLautstaerke.setMajorTickSpacing(20);

        panelGesamt.add(sliderLautstaerke, BorderLayout.NORTH);
        panelGesamt.add(labelLautstaerke, BorderLayout.CENTER);

        getContentPane().add(panelGesamt);

        // Event
        sliderLautstaerke.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                presenter.changeEvent();
            }
        });

        // Fenster anzeigen
        setVisible(true);
    }

    public void setPresenter(ISliderPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public int getSliderWert() {
        return sliderLautstaerke.getValue();
    }

    @Override
    public void setSliderWert(int sliderWert) {
        sliderLautstaerke.setValue(sliderWert);
    }

    @Override
    public void setLautstaerkeText(String lautstaerke) {
        labelLautstaerke.setText(lautstaerke);
    }
}
