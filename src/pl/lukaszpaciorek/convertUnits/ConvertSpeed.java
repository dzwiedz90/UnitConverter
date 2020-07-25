package pl.lukaszpaciorek.convertUnits;

public class ConvertSpeed {
    private double[] convertedValues = new double[6];

    public ConvertSpeed(String valueFromUserIn, String unitFromUserIn) {
//        {"m/s", "km/s", "km/h", "mi/h", "węzły"}
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
        }
        return 0;
    }

    private double convertKilometersOnSecond(double valueIn) {
        return valueIn / 100000;
    }

    private double convertKilometersOnHour(double valueIn) {
        return valueIn / 100000;
    }

    private double convertMilesOnHour(double valueIn) {
        return valueIn / 2.54;
    }

    private double convertKnots(double valueIn) {
        return valueIn / 160934.4;
    }
}
