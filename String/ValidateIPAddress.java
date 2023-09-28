package String;

import java.util.Arrays;

public class ValidateIPAddress {
    String IP = "0.0.0.0.";

    public boolean isValid() {

        // This is because the dot character (".") is a special character in regular
        // expressions, and when using the split method with a regular expression,
        // we need to escape the dot with two backslashes ("\").
        String[] tokens = IP.split("\\.");
        System.out.println(Arrays.toString(tokens));
        // System.out.println(Integer.parseInt(tokens[0]));

        // check for correct structure
        if (IP.length() == 0)
            return false;

        int segment = 0;
        for (int i = 0; i < IP.length(); i++) {
            if (!Character.isLetterOrDigit(IP.charAt(i)))
                return false;
            while (Character.isLetterOrDigit(IP.charAt(i))) {
                i++;
                continue;
            }
            if (IP.charAt(i) != '.')
                return false;

            segment++;
            if (segment > 3)
                return false;
        }

        // check number of tokens
        if (tokens.length != 4)
            return false;

        for (String token : tokens) {

            // check for empty tokens
            // must check before parseInt()
            if (token.length() == 0)
                return false;

            int intToken = Integer.parseInt(token);

            // check for leading zeroes
            if (token.length() != Integer.toString(intToken).length())
                return false;

            if (0 <= intToken && intToken < 256)
                continue;
            return false;
        }

        return true;

    }

    public boolean isValidIPv4(String ip) {
        if (ip.length() < 7)
            return false;
        if (ip.charAt(0) == '.' || ip.charAt(ip.length() - 1) == '.') {
            return false;
        }
        String[] tokens = ip.split("\\.");
        if (tokens.length != 4)
            return false;
        for (String token : tokens) {
            if (!isValidIPv4Token(token))
                return false;
        }
        return true;
    }

    public boolean isValidIPv4Token(String token) {
        if (token.length() == 0) {
            return false;
        }
        if (token.startsWith("0") && token.length() > 1)
            return false;
        try {
            int parsedInt = Integer.parseInt(token);
            if (parsedInt < 0 || parsedInt > 255)
                return false;
            if (parsedInt == 0 && token.charAt(0) != '0')
                return false;// "0.0.0.-0"
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
