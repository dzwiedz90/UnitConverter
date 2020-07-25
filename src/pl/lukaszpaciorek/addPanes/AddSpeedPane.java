package pl.lukaszpaciorek.addPanes;

import pl.lukaszpaciorek.convertUnits.ConvertLength;
import pl.lukaszpaciorek.convertUnits.ConvertSpeed;
import pl.lukaszpaciorek.convertUnits.SetConvertedValues;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddSpeedPane implements ActionListener {
    JButton calculateSpeedButton;
    JPanel speedPaneUp;
    JPanel speedPaneDown;

    public AddSpeedPane(JTabbedPane tabbedPane) {
        addSpeedPane(tabbedPane);
    }

    private void addSpeedPane(JTabbedPane tabbedPane) {
        JPanel speedPane = new JPanel();
        speedPaneUp = new JPanel();
        speedPaneDown = new JPanel();

        BorderLayout layout = new BorderLayout();
        speedPane.setLayout(layout);

        String[] speedUnitsArray = {"m/s", "km/s", "km/h", "mi/h", "węzły"};
        calculateSpeedButton = new JButton("Oblicz");
        JTextField speedTextField = new JTextField("0", 5);

        AddItemsToPanes.addItemsToUpPane(this, speedPaneUp, speedUnitsArray, calculateSpeedButton, speedTextField);
        AddItemsToPanes.addItemsToDownPane(speedPaneDown, speedUnitsArray);

        speedPane.add(speedPaneUp, BorderLayout.NORTH);
        speedPane.add(speedPaneDown, BorderLayout.CENTER);

        tabbedPane.add(speedPane, "Prędkość");
    }

    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();

        if (source == calculateSpeedButton) {
            JComboBox box;
            String valueFromUser = "";
            String unitFromUser = "";

            for (Component comp : speedPaneUp.getComponents()) {
                if (comp instanceof JComboBox) {
                    box = (JComboBox) comp;
                    unitFromUser = (String) box.getSelectedItem();
                }
                if (comp instanceof JTextField) {
                    valueFromUser = ((JTextField) comp).getText();
                }
            }

            ConvertSpeed convert = new ConvertSpeed(valueFromUser, unitFromUser);
            SetConvertedValues setValues = new SetConvertedValues(convert.getConvertedSpeed(), speedPaneDown);
        }
    }
}
