package pl.lukaszpaciorek.addPanes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import pl.lukaszpaciorek.convertUnits.ConvertTime;
import pl.lukaszpaciorek.convertUnits.SetConvertedValues;

public class AddTimePane implements ActionListener {
    JButton calculateTimeButton;
    JPanel timePaneUp;
    JPanel timePaneDown;

    public AddTimePane(JTabbedPane tabbedPane) {
        addTimePane(tabbedPane);
    }

    private void addTimePane(JTabbedPane tabbedPane) {
        JPanel timePane = new JPanel();
        timePaneUp = new JPanel();
        timePaneDown = new JPanel();

        BorderLayout layout = new BorderLayout();
        timePane.setLayout(layout);

        String[] timeUnitsArray = {"sekunda", "minuta", "godzina", "dzień", "tydzień", "miesiąc", "rok"};
        calculateTimeButton = new JButton("Oblicz");
        JTextField timeTextField = new JTextField("1", 5);

        AddItemsToPanes.addItemsToUpPane(this, timePaneUp, timeUnitsArray, calculateTimeButton, timeTextField);
        AddItemsToPanes.addItemsToDownPane(timePaneDown, timeUnitsArray);

        timePane.add(timePaneUp, BorderLayout.NORTH);
        timePane.add(timePaneDown, BorderLayout.CENTER);

        tabbedPane.add(timePane, "Czas");
    }

    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();

        if (source == calculateTimeButton) {
            JComboBox box;
            String valueFromUser = "";
            String unitFromUser = "";

            for (Component comp : timePaneUp.getComponents()) {
                if (comp instanceof JComboBox) {
                    box = (JComboBox) comp;
                    unitFromUser = (String) box.getSelectedItem();
                }
                if (comp instanceof JTextField) {
                    valueFromUser = ((JTextField) comp).getText();
                }
            }

            ConvertTime convert = new ConvertTime(valueFromUser, unitFromUser);
            SetConvertedValues setValues = new SetConvertedValues(convert.getConvertedTime(), timePaneDown);
        }
    }
}
