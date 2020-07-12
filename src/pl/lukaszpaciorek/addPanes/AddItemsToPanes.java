package pl.lukaszpaciorek.addPanes;

import javax.swing.*;
import java.awt.event.ActionListener;

public class AddItemsToPanes {

    public AddItemsToPanes(Object object, JPanel pane, String[] unitsArray, JButton button, JTextField textField, JPanel paneIn) {
        addItemsToUpPane(object, pane, unitsArray, button, textField);
        addItemsToDownPane(paneIn, unitsArray);
    }

    private void addItemsToUpPane(Object object, JPanel pane, String[] unitsArray, JButton button, JTextField textField) {
        JComboBox unitsBox = new JComboBox(unitsArray);
        button.addActionListener((ActionListener) object);

        pane.add(textField);
        pane.add(unitsBox);
        pane.add(button);
    }

    private void addItemsToDownPane(JPanel paneIn, String[] unitsArray) {
        paneIn.setLayout(new BoxLayout(paneIn, BoxLayout.Y_AXIS));
        for (String unit : unitsArray) {
            JPanel pane = new JPanel();
            JTextField field = new JTextField("0", 5);
            field.setEditable(false);
            JLabel label = new JLabel(unit);
            label.setLabelFor(field);

            pane.add(field);
            pane.add(label);
            paneIn.add(pane);
        }
    }
}
