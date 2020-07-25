package pl.lukaszpaciorek.convertUnits;

public class ConvertTemperature {
    private double[] convertedValues = new double[6];

    public ConvertTemperature(String valueFromUserIn, String unitFromUserIn) {
        convertedValues[0] = convertCelsius(valueFromUserIn, unitFromUserIn);
        convertedValues[1] = convertFahrenheits(convertedValues[0]);
        convertedValues[2] = convertKelvins(convertedValues[0]);
    }

    public double[] getConvertedLength() {
        return convertedValues;
    }

    private double convertCelsius(String valueFromUserIn, String unitFromUserIn) {
        switch (unitFromUserIn) {
            case "st. C":
                return Double.parseDouble(valueFromUserIn);
            case "st. F":
                return ((Double.parseDouble(valueFromUserIn) - 32) * 5) / 9;
            case "st. K":
                return Double.parseDouble(valueFromUserIn) - 273.15;
            default:
                return 0;
        }
    }

    private double convertFahrenheits(double valueIn) {
        return (valueIn * 9 / 5) + 32;
    }

    private double convertKelvins(double valueIn) {
        return valueIn + 273.15;
    }
}
