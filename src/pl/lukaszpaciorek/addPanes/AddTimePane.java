package pl.lukaszpaciorek.addPanes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddTimePane implements ActionListener {
    JButton calculateTimeButton;

    public AddTimePane(JTabbedPane tabbedPane) {
        addTimePane(tabbedPane);
    }

    private void addTimePane(JTabbedPane tabbedPane) {
        JPanel timePane = new JPanel();
        JPanel timePaneUp = new JPanel();
        JPanel timePaneDown = new JPanel();

        BorderLayout layout = new BorderLayout();
        timePane.setLayout(layout);

        String[] timeUnitsArray = {"sekunda", "minuta", "godzina", "dzień", "tydzień", "miesiąc", "rok"};
        calculateTimeButton = new JButton("Oblicz");
        JTextField timeTextField = new JTextField("1", 5);

        AddItemsToPanes addItems = new AddItemsToPanes(this, timePaneUp, timeUnitsArray, calculateTimeButton, timeTextField, timePaneDown);

        timePane.add(timePaneUp, BorderLayout.NORTH);
        timePane.add(timePaneDown, BorderLayout.CENTER);

        tabbedPane.add(timePane, "Czas");
    }

    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();

        if (source == calculateTimeButton){
            ;
        }
    }
}
