package pl.lukaszpaciorek.addPanes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import pl.lukaszpaciorek.convertUnits.ConvertWeight;
import pl.lukaszpaciorek.convertUnits.SetConvertedValues;

public class AddWeightPane implements ActionListener {
    JButton calculateWeightButton;
    JPanel weightPaneUp;
    JPanel weightPaneDown;

    public AddWeightPane(JTabbedPane tabbedPane) {
        addWeightPane(tabbedPane);
    }

    private void addWeightPane(JTabbedPane tabbedPane) {
        JPanel weightPane = new JPanel();
        weightPaneUp = new JPanel();
        weightPaneDown = new JPanel();

        BorderLayout layout = new BorderLayout();
        weightPane.setLayout(layout);

        String[] weightUnitsArray = {"gram", "dag", "kilogram", "lb(pound)", "tona"};
        calculateWeightButton = new JButton("Oblicz");
        JTextField weightTextField = new JTextField("1", 5);

        AddItemsToPanes.addItemsToUpPane(this, weightPaneUp, weightUnitsArray, calculateWeightButton, weightTextField);
        AddItemsToPanes.addItemsToDownPane(weightPaneDown, weightUnitsArray);

        weightPane.add(weightPaneUp, BorderLayout.NORTH);
        weightPane.add(weightPaneDown, BorderLayout.CENTER);

        tabbedPane.add(weightPane, "Waga");
    }

    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();

        if (source == calculateWeightButton) {
            JComboBox box;
            String valueFromUser = "";
            String unitFromUser = "";

            for (Component comp : weightPaneUp.getComponents()) {
                if (comp instanceof JComboBox) {
                    box = (JComboBox) comp;
                    unitFromUser = (String) box.getSelectedItem();
                }
                if (comp instanceof JTextField) {
                    valueFromUser = ((JTextField) comp).getText();
                }
            }

            ConvertWeight convert = new ConvertWeight(valueFromUser, unitFromUser);
            SetConvertedValues setValues = new SetConvertedValues(convert.getConvertedWeight(), weightPaneDown);
        }
    }
}
