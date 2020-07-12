package pl.lukaszpaciorek.addPanes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddLengthPane implements ActionListener {
    JButton calculateLengthButton;

    public AddLengthPane(JTabbedPane tabbedPane) {
        addLengthPane(tabbedPane);
    }

    private void addLengthPane(JTabbedPane tabbedPane) {
        JPanel lengthPane = new JPanel();
        JPanel lengthPaneUp = new JPanel();
        JPanel lengthPaneDown = new JPanel();

        BorderLayout layout = new BorderLayout();
        lengthPane.setLayout(layout);

        String[] lengthUnitsArray = {"centymetr", "metr", "kilometr", "cal", "stopa", "mila"};
        calculateLengthButton = new JButton("Oblicz");
        JTextField lengthTextField = new JTextField("0", 5);

        AddItemsToPanes addItems = new AddItemsToPanes(this, lengthPaneUp, lengthUnitsArray, calculateLengthButton, lengthTextField, lengthPaneDown);

        lengthPane.add(lengthPaneUp, BorderLayout.NORTH);
        lengthPane.add(lengthPaneDown, BorderLayout.CENTER);

        tabbedPane.add(lengthPane, "Długość");
    }

    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();

        if (source == calculateLengthButton){
            ;
        }
    }
}
