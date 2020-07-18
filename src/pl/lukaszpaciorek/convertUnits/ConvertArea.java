package pl.lukaszpaciorek.convertUnits;

public class ConvertArea {

    public ConvertArea(String valueFromUserIn, String unitFromUserIn, String[] areaUnitsArrayIn) {
//        {"centymetr^2", "metr^2", "kilometr^2", "cal^2", "stopa^2", "mila^2"}
        double valueConvertedToCentimeters = convertCentimeters(valueFromUserIn, unitFromUserIn);


    }

    private double convertCentimeters(String valueFromUserIn, String unitFromUserIn) {
        switch (valueFromUserIn) {
            case "centymetr^2":
                return Double.parseDouble(unitFromUserIn);
            case "metr^2":
                return 2.2;
            case "kilometr^2":
                return 2.2;
            case "cal^2":
                return 2.2;
            case "stopa^2":
                return 2.2;
            case "mila^2":
                return 2.2;
        }
        return 0;
    }

    private void convertMeters() {

    }

    private void convertKilimeters() {

    }

    private void convertInches() {

    }

    private void convertFeet() {

    }

    private void convertMiles() {

    }
}
