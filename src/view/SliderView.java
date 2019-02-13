package view;

import controller.SliderController;
import model.LautstaerkeModel;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class SliderView extends JFrame implements Observer {
    // GUI
    private JSlider sliderLautstaerke;
    private JLabel labelLautstaerke;

    // MVC
    private LautstaerkeModel model;
    private SliderController controller;

    public SliderView(LautstaerkeModel model) {
        // MVC
        this.model = model;
        model.setObserver(this);
        controller = new SliderController(model, this);

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
                controller.changeEvent();
            }
        });

        // Fenster anzeigen
        setVisible(true);
    }

    @Override
    public void update() {
        double lautstaerke = model.getLautstaerke();
        labelLautstaerke.setText(String. format("%.1f", lautstaerke));
        sliderLautstaerke.setValue((int)(lautstaerke * 2.0));
    }

    public int getSliderWert(){
        return sliderLautstaerke.getValue();
    }
}
