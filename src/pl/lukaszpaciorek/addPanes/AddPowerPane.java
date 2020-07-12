package pl.lukaszpaciorek.addPanes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddPowerPane implements ActionListener {
    JButton calculatePowerButton;

    public AddPowerPane(JTabbedPane tabbedPane) {
        addPowerPane(tabbedPane);
    }

    private void addPowerPane(JTabbedPane tabbedPane) {
        JPanel powerPane = new JPanel();
        JPanel powerPaneUp = new JPanel();
        JPanel powerPaneDown = new JPanel();

        BorderLayout layout = new BorderLayout();
        powerPane.setLayout(layout);

        String[] powerUnitsArray = {"W", "kW", "MW", "koń mechaniczny"};
        calculatePowerButton = new JButton("Oblicz");
        JTextField powerTextField = new JTextField("0", 5);

        AddItemsToPanes addItems = new AddItemsToPanes(this, powerPaneUp, powerUnitsArray, calculatePowerButton, powerTextField, powerPaneDown);

        powerPane.add(powerPaneUp, BorderLayout.NORTH);
        powerPane.add(powerPaneDown, BorderLayout.CENTER);

        tabbedPane.add(powerPane, "Moc");
    }

    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();

        if (source == calculatePowerButton) {
            ;
        }
    }
}
