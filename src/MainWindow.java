import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame implements ActionListener {
    protected JFrame mainWindow;
    JTabbedPane tabbedPane;

    public MainWindow() {
        super();
        mainWindow = new JFrame("Unit converter");
        mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainWindow.setSize(500, 600);

        tabbedPane = new JTabbedPane();
        addLengthPane();
        addAreaPane();
        addWeightPane();
        addTemperaturePane();
        addTimePane();
        addSpeedPane();
        addPowerPane();

        mainWindow.add(tabbedPane);
        mainWindow.setVisible(true);
        centerWindowOnScreen();
    }

    private void centerWindowOnScreen() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        mainWindow.setLocation(dim.width / 2 - mainWindow.getSize().width / 2, dim.height / 2 - mainWindow.getSize().height / 2);
    }

    private void addLengthPane() {
        JPanel lengthPane = new JPanel();
        JPanel lengthPaneUp = new JPanel();
        JPanel lengthPaneDown = new JPanel();

        BorderLayout layout = new BorderLayout();
        lengthPane.setLayout(layout);

        String[] lengthUnitsArray = {"centymetr", "metr", "kilometr", "cal", "stopa", "mila"};
        JButton calculateLengthButton = new JButton("Oblicz");
        JTextField lengthTextField = new JTextField("0", 5);

        addItemsToUpPane(lengthPaneUp, lengthUnitsArray, calculateLengthButton, lengthTextField);
        addItemsToDownPane(lengthPaneDown, lengthUnitsArray);

        lengthPane.add(lengthPaneUp, BorderLayout.NORTH);
        lengthPane.add(lengthPaneDown, BorderLayout.CENTER);

        tabbedPane.add(lengthPane, "Długość");
    }

    private void addAreaPane() {
        JPanel areaPane = new JPanel();
        JPanel areaPaneUp = new JPanel();
        JPanel areaPaneDown = new JPanel();

        BorderLayout layout = new BorderLayout();
        areaPane.setLayout(layout);

        String[] areaUnitsArray = {"centymetr^2", "metr^2", "kilometr^2", "cal^2", "stopa^2", "mila^2"};
        JButton calculateAreaButton = new JButton("Oblicz");
        JTextField areaTextField = new JTextField("0", 5);

        addItemsToUpPane(areaPaneUp, areaUnitsArray, calculateAreaButton, areaTextField);
        addItemsToDownPane(areaPaneDown, areaUnitsArray);

        areaPane.add(areaPaneUp, BorderLayout.NORTH);
        areaPane.add(areaPaneDown, BorderLayout.CENTER);

        tabbedPane.add(areaPane, "Obaszar");
    }

    private void addWeightPane() {
        JPanel weightPane = new JPanel();
        JPanel weightPaneUp = new JPanel();
        JPanel weightPaneDown = new JPanel();

        BorderLayout layout = new BorderLayout();
        weightPane.setLayout(layout);

        String[] weightUnitsArray = {"gram", "dag", "kilogram", "lb(pound)", "tona"};
        JButton calculateWeightButton = new JButton("Oblicz");
        JTextField weightTextField = new JTextField("0", 5);

        addItemsToUpPane(weightPaneUp, weightUnitsArray, calculateWeightButton, weightTextField);
        addItemsToDownPane(weightPaneDown, weightUnitsArray);

        weightPane.add(weightPaneUp, BorderLayout.NORTH);
        weightPane.add(weightPaneDown, BorderLayout.CENTER);

        tabbedPane.add(weightPane, "Waga");
    }

    private void addTemperaturePane() {
        JPanel temperaturePane = new JPanel();
        JPanel temperaturePaneUp = new JPanel();
        JPanel temperaturePaneDown = new JPanel();

        BorderLayout layout = new BorderLayout();
        temperaturePane.setLayout(layout);

        String[] temperatureUnitsArray = {"st. C", "st. F", "st. K"};
        JButton calculateTemperatureButton = new JButton("Oblicz");
        JTextField temperatureTextField = new JTextField("0", 5);

        addItemsToUpPane(temperaturePaneUp, temperatureUnitsArray, calculateTemperatureButton, temperatureTextField);
        addItemsToDownPane(temperaturePaneDown, temperatureUnitsArray);

        temperaturePane.add(temperaturePaneUp, BorderLayout.NORTH);
        temperaturePane.add(temperaturePaneDown, BorderLayout.CENTER);

        tabbedPane.add(temperaturePane, "Obaszar");
    }

    private void addTimePane() {
        JPanel timePane = new JPanel();
        JPanel timePaneUp = new JPanel();
        JPanel timePaneDown = new JPanel();

        BorderLayout layout = new BorderLayout();
        timePane.setLayout(layout);

        String[] timeUnitsArray = {"sekunda", "minuta", "godzina", "dzień", "tydzień", "miesiąc", "rok"};
        JButton calculateTimeButton = new JButton("Oblicz");
        JTextField timeTextField = new JTextField("0", 5);

        addItemsToUpPane(timePaneUp, timeUnitsArray, calculateTimeButton, timeTextField);
        addItemsToDownPane(timePaneDown, timeUnitsArray);

        timePane.add(timePaneUp, BorderLayout.NORTH);
        timePane.add(timePaneDown, BorderLayout.CENTER);

        tabbedPane.add(timePane, "Czas");
    }

    private void addSpeedPane() {
        JPanel speedPane = new JPanel();
        JPanel speedPaneUp = new JPanel();
        JPanel speedPaneDown = new JPanel();

        BorderLayout layout = new BorderLayout();
        speedPane.setLayout(layout);

        String[] speedUnitsArray = {"m/s", "km/s", "km/h", "mi/h", "węzły"};
        JButton calculateSpeedButton = new JButton("Oblicz");
        JTextField speedTextField = new JTextField("0", 5);

        addItemsToUpPane(speedPaneUp, speedUnitsArray, calculateSpeedButton, speedTextField);
        addItemsToDownPane(speedPaneDown, speedUnitsArray);

        speedPane.add(speedPaneUp, BorderLayout.NORTH);
        speedPane.add(speedPaneDown, BorderLayout.CENTER);

        tabbedPane.add(speedPane, "Prędkość");
    }

    private void addPowerPane() {
        JPanel powerPane = new JPanel();
        JPanel powerPaneUp = new JPanel();
        JPanel powerPaneDown = new JPanel();

        BorderLayout layout = new BorderLayout();
        powerPane.setLayout(layout);

        String[] powerUnitsArray = {"W", "kW", "MW", "koń mechaniczny"};
        JButton calculatePowerButton = new JButton("Oblicz");
        JTextField powerTextField = new JTextField("0", 5);

        addItemsToUpPane(powerPaneUp, powerUnitsArray, calculatePowerButton, powerTextField);
        addItemsToDownPane(powerPaneDown, powerUnitsArray);

        powerPane.add(powerPaneUp, BorderLayout.NORTH);
        powerPane.add(powerPaneDown, BorderLayout.CENTER);

        tabbedPane.add(powerPane, "Moc");
    }

    private void addItemsToUpPane(JPanel pane, String[] unitsArray, JButton button, JTextField textField) {
        JComboBox unitsBox = new JComboBox(unitsArray);
        button.addActionListener(this);

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

    public void actionPerformed(ActionEvent event) {

    }
}
