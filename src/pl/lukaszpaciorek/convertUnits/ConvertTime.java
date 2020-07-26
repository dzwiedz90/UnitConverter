package pl.lukaszpaciorek.convertUnits;

public class ConvertTime {
    private double[] convertedValues = new double[7];

    public ConvertTime(String valueFromUserIn, String unitFromUserIn) {
        convertedValues[0] = convertSeconds(valueFromUserIn, unitFromUserIn);
        convertedValues[1] = convertMinutes(convertedValues[0]);
        convertedValues[2] = convertHours(convertedValues[0]);
        convertedValues[3] = convertDays(convertedValues[0]);
        convertedValues[4] = convertWeeks(convertedValues[0]);
        convertedValues[5] = convertMonths(convertedValues[0]);
        convertedValues[6] = convertYears(convertedValues[0]);
    }

    public double[] getConvertedTime() {
        return convertedValues;
    }

    private double convertSeconds(String valueFromUserIn, String unitFromUserIn) {
        switch (unitFromUserIn) {
            case "sekunda":
                return Double.parseDouble(valueFromUserIn);
            case "minuta":
                return Double.parseDouble(valueFromUserIn) * 60;
            case "godzina":
                return Double.parseDouble(valueFromUserIn) * 3600;
            case "dzień":
                return Double.parseDouble(valueFromUserIn) * 86400;
            case "tydzień":
                return Double.parseDouble(valueFromUserIn) * 604800;
            case "miesiąc":
                return Double.parseDouble(valueFromUserIn) * 2628000;
            case "rok":
                return Double.parseDouble(valueFromUserIn) * 31536000;
            default:
                return 0;
        }

    }

    private double convertMinutes(double valueIn) {
        return valueIn / 60;
    }

    private double convertHours(double valueIn) {
        return valueIn / 3600;
    }

    private double convertDays(double valueIn) {
        return valueIn / 86400;
    }

    private double convertWeeks(double valueIn) {
        return valueIn / 604800;
    }

    private double convertMonths(double valueIn) {
        return valueIn / 2628000;
    }

    private double convertYears(double valueIn) {
        return valueIn / 31536000;
    }
}
