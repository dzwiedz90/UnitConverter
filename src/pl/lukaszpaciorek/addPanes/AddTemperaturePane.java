package pl.lukaszpaciorek.addPanes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddTemperaturePane implements ActionListener {
    JButton calculateTemperatureButton;

    public AddTemperaturePane(JTabbedPane tabbedPane) {
        addTemperaturePane(tabbedPane);
    }

    private void addTemperaturePane(JTabbedPane tabbedPane) {
        JPanel temperaturePane = new JPanel();
        JPanel temperaturePaneUp = new JPanel();
        JPanel temperaturePaneDown = new JPanel();

        BorderLayout layout = new BorderLayout();
        temperaturePane.setLayout(layout);

        String[] temperatureUnitsArray = {"st. C", "st. F", "st. K"};
        calculateTemperatureButton = new JButton("Oblicz");
        JTextField temperatureTextField = new JTextField("1", 5);

        AddItemsToPanes addItems = new AddItemsToPanes(this, temperaturePaneUp, temperatureUnitsArray, calculateTemperatureButton, temperatureTextField, temperaturePaneDown);

        temperaturePane.add(temperaturePaneUp, BorderLayout.NORTH);
        temperaturePane.add(temperaturePaneDown, BorderLayout.CENTER);

        tabbedPane.add(temperaturePane, "Obaszar");
    }

    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();

        if (source == calculateTemperatureButton){
            ;
        }
    }
}
