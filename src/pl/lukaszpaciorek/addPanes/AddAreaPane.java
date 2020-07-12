package pl.lukaszpaciorek.addPanes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddAreaPane implements ActionListener {
    JButton calculateAreaButton;
    JPanel areaPaneDown;

    public AddAreaPane(JTabbedPane tabbedPane) {
        addAreaPane(tabbedPane);
    }

    private void addAreaPane(JTabbedPane tabbedPane) {
        JPanel areaPane = new JPanel();
        JPanel areaPaneUp = new JPanel();
        areaPaneDown = new JPanel();

        BorderLayout layout = new BorderLayout();
        areaPane.setLayout(layout);

        String[] areaUnitsArray = {"centymetr^2", "metr^2", "kilometr^2", "cal^2", "stopa^2", "mila^2"};
        calculateAreaButton = new JButton("Oblicz");
        JTextField areaTextField = new JTextField("0", 5);

        AddItemsToPanes.addItemsToUpPane(this, areaPaneUp, areaUnitsArray, calculateAreaButton, areaTextField);

        AddItemsToPanes.addItemsToDownPane(areaPaneDown, areaUnitsArray);

        areaPane.add(areaPaneUp, BorderLayout.NORTH);
        areaPane.add(areaPaneDown, BorderLayout.CENTER);

        tabbedPane.add(areaPane, "Obszar");
    }

    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();

        if (source == calculateAreaButton) {
            System.out.println("dupa");
            for (Component jc : areaPaneDown.getComponents()) {
                if (jc instanceof JLabel) {
                    JLabel label = (JLabel) jc;
                    System.out.println(label.getText());
                }
                if (jc instanceof JTextField) {
//                    JTextField field = (JTextField) jc;
                    String getValue = ((JTextField) jc).getText();
                    System.out.println(getValue);
                }
                if (jc instanceof JPanel){
                    System.out.println("dupa2");
                }
            }
        }
    }
}
