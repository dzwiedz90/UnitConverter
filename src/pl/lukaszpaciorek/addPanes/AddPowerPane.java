package pl.lukaszpaciorek.addPanes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import pl.lukaszpaciorek.convertUnits.ConvertPower;
import pl.lukaszpaciorek.convertUnits.SetConvertedValues;

public class AddPowerPane implements ActionListener {
    JButton calculatePowerButton;
    JPanel powerPaneUp;
    JPanel powerPaneDown;

    public AddPowerPane(JTabbedPane tabbedPane) {
        addPowerPane(tabbedPane);
    }

    private void addPowerPane(JTabbedPane tabbedPane) {
        JPanel powerPane = new JPanel();
        powerPaneUp = new JPanel();
        powerPaneDown = new JPanel();

        BorderLayout layout = new BorderLayout();
        powerPane.setLayout(layout);

        String[] powerUnitsArray = {"W", "kW", "MW", "koń mechaniczny"};
        calculatePowerButton = new JButton("Oblicz");
        JTextField powerTextField = new JTextField("0", 5);

        AddItemsToPanes.addItemsToUpPane(this, powerPaneUp, powerUnitsArray, calculatePowerButton, powerTextField);
        AddItemsToPanes.addItemsToDownPane(powerPaneDown, powerUnitsArray);

        powerPane.add(powerPaneUp, BorderLayout.NORTH);
        powerPane.add(powerPaneDown, BorderLayout.CENTER);

        tabbedPane.add(powerPane, "Moc");
    }

    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();

        if (source == calculatePowerButton) {
            JComboBox box;
            String valueFromUser = "";
            String unitFromUser = "";

            for (Component comp : powerPaneUp.getComponents()) {
                if (comp instanceof JComboBox) {
                    box = (JComboBox) comp;
                    unitFromUser = (String) box.getSelectedItem();
                }
                if (comp instanceof JTextField) {
                    valueFromUser = ((JTextField) comp).getText();
                }
            }

            ConvertPower convert = new ConvertPower(valueFromUser, unitFromUser);
            SetConvertedValues setValues = new SetConvertedValues(convert.getConvertedPower(), powerPaneDown);
        }
    }
}
