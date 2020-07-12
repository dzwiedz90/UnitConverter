package pl.lukaszpaciorek;

import javax.swing.*;
import java.awt.*;

import pl.lukaszpaciorek.addPanes.*;

public class MainWindow extends JFrame {
    protected JFrame mainWindow;
    JTabbedPane tabbedPane;


    public MainWindow() {
        super();
        mainWindow = new JFrame("Unit converter");
        mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainWindow.setSize(500, 600);

        tabbedPane = new JTabbedPane();

        AddLengthPane addLengthPane = new AddLengthPane(tabbedPane);
        AddAreaPane addAreaPane = new AddAreaPane(tabbedPane);
        AddWeightPane addWeightPane = new AddWeightPane(tabbedPane);
        AddTemperaturePane addTemperaturePane = new AddTemperaturePane(tabbedPane);
        AddTimePane addTimePane = new AddTimePane(tabbedPane);
        AddSpeedPane addSpeedPane = new AddSpeedPane(tabbedPane);
        AddPowerPane addPowerPane = new AddPowerPane(tabbedPane);


        mainWindow.add(tabbedPane);
        mainWindow.setVisible(true);
        centerWindowOnScreen();
    }

    private void centerWindowOnScreen() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        mainWindow.setLocation(dim.width / 2 - mainWindow.getSize().width / 2, dim.height / 2 - mainWindow.getSize().height / 2);
    }
}
