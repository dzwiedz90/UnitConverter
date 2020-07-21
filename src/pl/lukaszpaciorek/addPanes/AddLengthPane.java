package pl.lukaszpaciorek.addPanes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import pl.lukaszpaciorek.convertUnits.ConvertLength;
import pl.lukaszpaciorek.convertUnits.SetConvertedValues;

public class AddLengthPane implements ActionListener {
    String[] lengthUnitsArray = {"centymetr", "metr", "kilometr", "cal", "stopa", "mila"};
    JButton calculateLengthButton;
    JPanel lengthPaneUp;
    JPanel lengthPaneDown;

    public AddLengthPane(JTabbedPane tabbedPane) {
        addLengthPane(tabbedPane);
    }

    private void addLengthPane(JTabbedPane tabbedPane) {
        JPanel lengthPane = new JPanel();
        lengthPaneUp = new JPanel();
        lengthPaneDown = new JPanel();

        BorderLayout layout = new BorderLayout();
        lengthPane.setLayout(layout);

        calculateLengthButton = new JButton("Oblicz");
        JTextField lengthTextField = new JTextField("0", 5);

        AddItemsToPanes.addItemsToUpPane(this, lengthPaneUp, lengthUnitsArray, calculateLengthButton, lengthTextField);
        AddItemsToPanes.addItemsToDownPane(lengthPaneDown, lengthUnitsArray);

        lengthPane.add(lengthPaneUp, BorderLayout.NORTH);
        lengthPane.add(lengthPaneDown, BorderLayout.CENTER);

        tabbedPane.add(lengthPane, "Długość");
    }

    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();

        if (source == calculateLengthButton) {
            JComboBox box;
            String valueFromUser = "";
            String unitFromUser = "";

            for (Component comp : lengthPaneUp.getComponents()) {
                if (comp instanceof JComboBox) {
                    box = (JComboBox) comp;
                    unitFromUser = (String) box.getSelectedItem();
                }
                if (comp instanceof JTextField) {
                    valueFromUser = ((JTextField) comp).getText();
                }
            }

            ConvertLength convert = new ConvertLength(valueFromUser, unitFromUser);
            SetConvertedValues setValues = new SetConvertedValues(convert.getConvertedLength(), lengthPaneDown);
        }
    }
}
