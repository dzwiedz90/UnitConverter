package pl.lukaszpaciorek.convertUnits;

public class ConvertArea {
    private double[] convertedValues = new double[6];

    public ConvertArea(String valueFromUserIn, String unitFromUserIn) {
        convertedValues[0] = convertCentimeters(valueFromUserIn, unitFromUserIn);
        convertedValues[1] = convertMeters(convertedValues[0]);
        convertedValues[2] = convertKilometers(convertedValues[0]);
        convertedValues[3] = convertInches(convertedValues[0]);
        convertedValues[4] = convertFeet(convertedValues[0]);
        convertedValues[5] = convertMiles(convertedValues[0]);
    }

    public double[] getConvertedArea() {
        return convertedValues;
    }
//TODO
    // ADD HEKTAR AR AKR
    private double convertCentimeters(String valueFromUserIn, String unitFromUserIn) {
        switch (unitFromUserIn) {
            case "centymetr^2":
                return Double.parseDouble(valueFromUserIn);
            case "metr^2":
                return Double.parseDouble(valueFromUserIn) * 10000;
            case "kilometr^2":
                return Double.parseDouble(valueFromUserIn) * 10000000000L;
            case "cal^2":
                return Double.parseDouble(valueFromUserIn) * 6.4516;
            case "stopa^2":
                return Double.parseDouble(valueFromUserIn) * 929.0304;
            case "mila^2":
                return 0;
            default:
                return 0;
        }
    }

    private double convertMeters(double valueIn) {
        return valueIn / 10000;
    }

    private double convertKilometers(double valueIn) {
        double km = Math.pow(10, 10);
        return valueIn / km;
    }

    private double convertInches(double valueIn) {
        return valueIn / 6.4516;
    }

    private double convertFeet(double valueIn) {
        return valueIn / 929.0304;
    }

    private double convertMiles(double valueIn) {
        return 0;
    }
}
