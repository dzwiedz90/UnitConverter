package pl.lukaszpaciorek.convertUnits;

public class ConvertLength {
    private double[] convertedValues = new double[6];

    public ConvertLength(String valueFromUserIn, String unitFromUserIn) {
        convertedValues[0] = convertCentimeters(valueFromUserIn, unitFromUserIn);
        convertedValues[1] = convertMeters(convertedValues[0]);
        convertedValues[2] = convertKilometers(convertedValues[0]);
        convertedValues[3] = convertInches(convertedValues[0]);
        convertedValues[4] = convertFeet(convertedValues[0]);
        convertedValues[5] = convertMiles(convertedValues[0]);
    }

    public double[] getConvertedLength() {
        return convertedValues;
    }

    private double convertCentimeters(String valueFromUserIn, String unitFromUserIn) {
        switch (unitFromUserIn) {
            case "centymetr":
                return Double.parseDouble(valueFromUserIn);
            case "metr":
                return Double.parseDouble(valueFromUserIn) * 100;
            case "kilometr":
                return Double.parseDouble(valueFromUserIn) * 100000;
            case "cal":
                return Double.parseDouble(valueFromUserIn) * 2.54;
            case "stopa":
                return Double.parseDouble(valueFromUserIn) * 30.48;
            case "mila":
                return Double.parseDouble(valueFromUserIn) * 160934.4;
            default:
                return 0;
        }
    }

    private double convertMeters(double valueIn) {
        return valueIn / 100;
    }

    private double convertKilometers(double valueIn) {
        return valueIn / 100000;
    }

    private double convertInches(double valueIn) {
        return valueIn / 2.54;
    }

    private double convertFeet(double valueIn) {
        return valueIn / 30.48;
    }

    private double convertMiles(double valueIn) {
        return valueIn / 160934.4;
    }
}
