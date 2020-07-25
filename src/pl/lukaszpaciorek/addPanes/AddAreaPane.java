package pl.lukaszpaciorek.addPanes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import pl.lukaszpaciorek.convertUnits.ConvertArea;
import pl.lukaszpaciorek.convertUnits.SetConvertedValues;

public class AddAreaPane implements ActionListener {
    JButton calculateAreaButton;
    JPanel areaPaneUp;
    JPanel areaPaneDown;

    public AddAreaPane(JTabbedPane tabbedPane) {
        addAreaPane(tabbedPane);
    }

    private void addAreaPane(JTabbedPane tabbedPane) {
        JPanel areaPane = new JPanel();
        areaPaneUp = new JPanel();
        areaPaneDown = new JPanel();

        BorderLayout layout = new BorderLayout();
        areaPane.setLayout(layout);

        String[] areaUnitsArray = {"centymetr^2", "metr^2", "kilometr^2", "cal^2", "stopa^2", "mila^2"};
        calculateAreaButton = new JButton("Oblicz");
        JTextField areaTextField = new JTextField("1", 5);

        AddItemsToPanes.addItemsToUpPane(this, areaPaneUp, areaUnitsArray, calculateAreaButton, areaTextField);
        AddItemsToPanes.addItemsToDownPane(areaPaneDown, areaUnitsArray);

        areaPane.add(areaPaneUp, BorderLayout.NORTH);
        areaPane.add(areaPaneDown, BorderLayout.CENTER);

        tabbedPane.add(areaPane, "Obszar");
    }

    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();

        if (source == calculateAreaButton) {
            JComboBox box;
            String valueFromUser = "";
            String unitFromUser = "";

            for (Component comp : areaPaneUp.getComponents()) {
                if (comp instanceof JComboBox) {
                    box = (JComboBox) comp;
                    unitFromUser = (String) box.getSelectedItem();
                }
                if (comp instanceof JTextField) {
                    valueFromUser = ((JTextField) comp).getText();
                }
            }

            ConvertArea convert = new ConvertArea(valueFromUser, unitFromUser);
            SetConvertedValues setValues = new SetConvertedValues(convert.getConvertedArea(), areaPaneDown);
        }
    }
}
