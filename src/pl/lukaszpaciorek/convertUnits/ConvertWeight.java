package pl.lukaszpaciorek.convertUnits;

public class ConvertWeight {
    private double[] convertedValues = new double[6];

    public ConvertWeight(String valueFromUserIn, String unitFromUserIn) {
//        {"gram", "dag", "kilogram", "lb(pound)", "tona"
        convertedValues[0] = convertGrams(valueFromUserIn, unitFromUserIn);
        convertedValues[1] = convertDag(convertedValues[0]);
        convertedValues[2] = convertKilogram(convertedValues[0]);
        convertedValues[3] = convertPound(convertedValues[0]);
        convertedValues[4] = convertTon(convertedValues[0]);
    }

    public double[] getConvertedWeight() {
        return convertedValues;
    }

    private double convertGrams(String valueFromUserIn, String unitFromUserIn) {
        switch (unitFromUserIn) {
            case "gram":
                return Double.parseDouble(valueFromUserIn);
            case "dag":
                return Double.parseDouble(valueFromUserIn) * 10;
            case "kilogram":
                return Double.parseDouble(valueFromUserIn) * 1000;
            case "lb(pound)":
                return Double.parseDouble(valueFromUserIn) * 453.59237;
            case "tona":
                return Double.parseDouble(valueFromUserIn) * 1000000;
            default:
                return 0;
        }
    }

    private double convertDag(double valueIn) {
        return valueIn / 10;
    }

    private double convertKilogram(double valueIn) {
        return valueIn / 1000;
    }

    private double convertPound(double valueIn) {
        return valueIn / 453.59237;
    }

    private double convertTon(double valueIn) {
        return valueIn / 1000000;
    }
}
