package pl.lukaszpaciorek.addPanes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import pl.lukaszpaciorek.convertUnits.ConvertTemperature;
import pl.lukaszpaciorek.convertUnits.SetConvertedValues;

public class AddTemperaturePane implements ActionListener {
    JButton calculateTemperatureButton;
    JPanel temperaturePaneUp;
    JPanel temperaturePaneDown;

    public AddTemperaturePane(JTabbedPane tabbedPane) {
        addTemperaturePane(tabbedPane);
    }

    private void addTemperaturePane(JTabbedPane tabbedPane) {
        JPanel temperaturePane = new JPanel();
        temperaturePaneUp = new JPanel();
        temperaturePaneDown = new JPanel();

        BorderLayout layout = new BorderLayout();
        temperaturePane.setLayout(layout);

        String[] temperatureUnitsArray = {"st. C", "st. F", "st. K"};
        calculateTemperatureButton = new JButton("Oblicz");
        JTextField temperatureTextField = new JTextField("1", 5);

        AddItemsToPanes.addItemsToUpPane(this, temperaturePaneUp, temperatureUnitsArray, calculateTemperatureButton, temperatureTextField);
        AddItemsToPanes.addItemsToDownPane(temperaturePaneDown, temperatureUnitsArray);

        temperaturePane.add(temperaturePaneUp, BorderLayout.NORTH);
        temperaturePane.add(temperaturePaneDown, BorderLayout.CENTER);

        tabbedPane.add(temperaturePane, "Temperatura");
    }

    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();

        if (source == calculateTemperatureButton) {
            JComboBox box;
            String valueFromUser = "";
            String unitFromUser = "";

            for (Component comp : temperaturePaneUp.getComponents()) {
                if (comp instanceof JComboBox) {
                    box = (JComboBox) comp;
                    unitFromUser = (String) box.getSelectedItem();
                }
                if (comp instanceof JTextField) {
                    valueFromUser = ((JTextField) comp).getText();
                }
            }

            ConvertTemperature convert = new ConvertTemperature(valueFromUser, unitFromUser);
            SetConvertedValues setValues = new SetConvertedValues(convert.getConvertedTemperature(), temperaturePaneDown);
        }
    }
}
