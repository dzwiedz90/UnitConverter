package pl.lukaszpaciorek.convertUnits;

public class ConvertPower {
    private double[] convertedValues = new double[6];

    public ConvertPower(String valueFromUserIn, String unitFromUserIn) {
//        {"W", "kW", "MW", "koń mechaniczny"};
        convertedValues[0] = convertWatts(valueFromUserIn, unitFromUserIn);
        convertedValues[1] = convertKiloWatts(convertedValues[0]);
        convertedValues[2] = convertMegaWatts(convertedValues[0]);
        convertedValues[3] = convertHorsepower(convertedValues[0]);
    }

    public double[] getConvertedPower() {
        return convertedValues;
    }

    private double convertWatts(String valueFromUserIn, String unitFromUserIn) {
        switch (unitFromUserIn) {
            case "W":
                return Double.parseDouble(valueFromUserIn);
            case "kW":
                return Double.parseDouble(valueFromUserIn) * 1000;
            case "MW":
                return Double.parseDouble(valueFromUserIn) * 1000000;
            case "koń mechaniczny":
                return Double.parseDouble(valueFromUserIn) * 735.5;
            }
        return 0;
    }

    private double convertKiloWatts(double valueIn) {
        return valueIn / 1000;
    }

    private double convertMegaWatts(double valueIn) {
        return valueIn / 1000000;
    }

    private double convertHorsepower(double valueIn) {
        return valueIn / 735.5;
    }
}
