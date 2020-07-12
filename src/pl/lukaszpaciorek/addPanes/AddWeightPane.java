package pl.lukaszpaciorek.addPanes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddWeightPane implements ActionListener {
    JButton calculateWeightButton;

    public AddWeightPane(JTabbedPane tabbedPane) {
        addWeightPane(tabbedPane);
    }

    private void addWeightPane(JTabbedPane tabbedPane) {
        JPanel weightPane = new JPanel();
        JPanel weightPaneUp = new JPanel();
        JPanel weightPaneDown = new JPanel();

        BorderLayout layout = new BorderLayout();
        weightPane.setLayout(layout);

        String[] weightUnitsArray = {"gram", "dag", "kilogram", "lb(pound)", "tona"};
        calculateWeightButton = new JButton("Oblicz");
        JTextField weightTextField = new JTextField("0", 5);

        AddItemsToPanes addItems = new AddItemsToPanes(this, weightPaneUp, weightUnitsArray, calculateWeightButton, weightTextField, weightPaneDown);

        weightPane.add(weightPaneUp, BorderLayout.NORTH);
        weightPane.add(weightPaneDown, BorderLayout.CENTER);

        tabbedPane.add(weightPane, "Waga");
    }

    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();

        if (source == calculateWeightButton){
            ;
        }
    }
}
