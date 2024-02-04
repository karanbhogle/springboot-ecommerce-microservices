package net.karanbhogle.mail.utils;

public class StringParser {

    public static String[] getOrderDetails(String inputString) {
        
        String[] orderDetails = new String[3];
        orderDetails[0] = parseValue(inputString, "OrderId");
        orderDetails[1] = parseValue(inputString, "UserId");
        orderDetails[2] = parseValue(inputString, "UserEmail");
        return orderDetails;
    }

    private static String parseValue(String input, String key) {
        String keyWithDelimiter = key + "?";
        int startIndex = input.indexOf(keyWithDelimiter);

        if (startIndex != -1) {
            startIndex += keyWithDelimiter.length();
            int endIndex = input.indexOf(":::", startIndex);

            if (endIndex != -1) {
                return input.substring(startIndex, endIndex);
            }
        }

        return null; // Return null if key is not found or pattern is not matched
    }
}
