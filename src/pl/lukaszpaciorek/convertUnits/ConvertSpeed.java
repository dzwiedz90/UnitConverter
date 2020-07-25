package pl.lukaszpaciorek.convertUnits;

public class ConvertSpeed {
    private double[] convertedValues = new double[6];

    public ConvertSpeed(String valueFromUserIn, String unitFromUserIn) {
        convertedValues[0] = convertMetersOnSecond(valueFromUserIn, unitFromUserIn);
        convertedValues[1] = convertKilometersOnSecond(convertedValues[0]);
        convertedValues[2] = convertKilometersOnHour(convertedValues[0]);
        convertedValues[3] = convertMilesOnHour(convertedValues[0]);
        convertedValues[4] = convertKnots(convertedValues[0]);
    }

    public double[] getConvertedSpeed() {
        return convertedValues;
    }

    private double convertMetersOnSecond(String valueFromUserIn, String unitFromUserIn) {
        switch (unitFromUserIn) {
            case "m/s":
                return Double.parseDouble(valueFromUserIn);
            case "km/s":
                return Double.parseDouble(valueFromUserIn) * 1000;
            case "km/h":
                return Double.parseDouble(valueFromUserIn) * 0.277778;
            case "mi/h":
                return Double.parseDouble(valueFromUserIn) * 0.44704;
            case "węzły":
                return Double.parseDouble(valueFromUserIn) * 0.514444;
            default:
                return 0;
        }
    }

    private double convertKilometersOnSecond(double valueIn) {
        return valueIn / 1000;
    }

    private double convertKilometersOnHour(double valueIn) {
        return valueIn / 0.277778;
    }

    private double convertMilesOnHour(double valueIn) {
        return valueIn / 0.44704;
    }

    private double convertKnots(double valueIn) {
        return valueIn / 0.514444;
    }
}
