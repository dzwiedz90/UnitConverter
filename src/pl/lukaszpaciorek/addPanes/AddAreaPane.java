package pl.lukaszpaciorek.addPanes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddAreaPane implements ActionListener {
    JButton calculateAreaButton;

    public AddAreaPane(JTabbedPane tabbedPane) {
        addAreaPane(tabbedPane);
    }

    private void addAreaPane(JTabbedPane tabbedPane) {
        JPanel areaPane = new JPanel();
        JPanel areaPaneUp = new JPanel();
        JPanel areaPaneDown = new JPanel();

        BorderLayout layout = new BorderLayout();
        areaPane.setLayout(layout);

        String[] areaUnitsArray = {"centymetr^2", "metr^2", "kilometr^2", "cal^2", "stopa^2", "mila^2"};
        calculateAreaButton = new JButton("Oblicz");
        JTextField areaTextField = new JTextField("0", 5);

        AddItemsToPanes addItems = new AddItemsToPanes(this, areaPaneUp, areaUnitsArray, calculateAreaButton, areaTextField, areaPaneDown);

        areaPane.add(areaPaneUp, BorderLayout.NORTH);
        areaPane.add(areaPaneDown, BorderLayout.CENTER);

        tabbedPane.add(areaPane, "Obaszar");
    }

    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();

        if (source == calculateAreaButton){
            ;
        }
    }
}
