package String;

import java.util.ArrayList;
import java.util.List;

public class DecodedStringAtIndex {
    public String decodeAtIndex(String s, int k) {
        List<Character> lc = new ArrayList<>();

        for (int i = 0; i < s.length();) {
            char c = s.charAt(i);
            if (i + 1 == k)
                return String.valueOf(c);

            if (Character.isDigit(c)) {
                int index = (i + (Character.getNumericValue(c) * i));
                if (index > k) {
                    return String.valueOf(lc.get(index));
                } else if (index < k) {
                    i = index;
                } else {
                    return String.valueOf(lc.get(lc.size() - 1));
                }
            } else {
                lc.add(c);
                i++
            }
        }
    }
}
