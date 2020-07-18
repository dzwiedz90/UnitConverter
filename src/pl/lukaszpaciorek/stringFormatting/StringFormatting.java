package pl.lukaszpaciorek.stringFormatting;

public class StringFormatting {
    public static String buildOutputString(String valueIn) {
        StringBuilder stringBuilder = new StringBuilder();

        String[] splittedInput = splitString(valueIn);

        int counter = 0;
        for (int i = splittedInput.length; i > 0; i--) {
            if (splittedInput[i - 1].equals(".")) {
                stringBuilder.insert(0, ".");
                counter = 0;
                continue;
            }
            if (counter == 3) {
                stringBuilder.insert(0, " ");
                counter = 0;
            }
            stringBuilder.insert(0, splittedInput[i - 1]);
            counter++;
        }

        return stringBuilder.toString();
    }

    private static String[] splitString(String valueIn) {
        String[] splittedInput = new String[valueIn.length()];

        for (int i = 0; i < valueIn.length(); i++) {
            splittedInput[i] = Character.toString(valueIn.charAt(i));
        }

        return splittedInput;
    }
}
