package pl.lukaszpaciorek.addPanes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddSpeedPane implements ActionListener {
    JButton calculateSpeedButton;

    public AddSpeedPane(JTabbedPane tabbedPane) {
        addSpeedPane(tabbedPane);
    }

    private void addSpeedPane(JTabbedPane tabbedPane) {
        JPanel speedPane = new JPanel();
        JPanel speedPaneUp = new JPanel();
        JPanel speedPaneDown = new JPanel();

        BorderLayout layout = new BorderLayout();
        speedPane.setLayout(layout);

        String[] speedUnitsArray = {"m/s", "km/s", "km/h", "mi/h", "węzły"};
        calculateSpeedButton = new JButton("Oblicz");
        JTextField speedTextField = new JTextField("0", 5);

        AddItemsToPanes addItems = new AddItemsToPanes(this, speedPaneUp, speedUnitsArray, calculateSpeedButton, speedTextField, speedPaneDown);

        speedPane.add(speedPaneUp, BorderLayout.NORTH);
        speedPane.add(speedPaneDown, BorderLayout.CENTER);

        tabbedPane.add(speedPane, "Prędkość");
    }

    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();

        if (source == calculateSpeedButton){
            ;
        }
    }
}
