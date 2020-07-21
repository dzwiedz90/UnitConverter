package pl.lukaszpaciorek.convertUnits;

import javax.swing.*;
import java.awt.*;

import pl.lukaszpaciorek.math.MyMath;
import pl.lukaszpaciorek.stringFormatting.StringFormatting;

public class SetConvertedValues {

    public SetConvertedValues(double[] valuesIn, JPanel panel) {
        int i = 0;
        for (Component comp : panel.getComponents()) {
            if (comp instanceof JPanel) {
                for (Component comp2 : ((JPanel) comp).getComponents()) {
                    if (comp2 instanceof JTextField) {
                        ((JTextField) comp2).setText(StringFormatting.buildOutputString(Double.toString(MyMath.round(valuesIn[i], 5))));
                    }
                }
            }
            i++;
        }
    }
}
