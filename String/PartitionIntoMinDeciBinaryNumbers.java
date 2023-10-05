package String;

public class PartitionIntoMinDeciBinaryNumbers {

    // Optimal Solution:
    public int minPartitions(String n) {
        int max = 0;
        for (int i = 0; i < n.length(); i++) {
            if (n.charAt(i) - '0' == 9)
                return 9;
            max = Math.max(max, (n.charAt(i) - '0'));
        }
        return max;
    }

    // Brute Force:
    // public int minPartitions(String s) {
    // long num = Long.parseLong(s);
    // StringBuilder n = new StringBuilder(s);

    // int res = 0; // #(DeciBinary Numbers)
    // while (!n.isEmpty()) {
    // while (!n.isEmpty() && n.charAt(0) == '0')
    // n.deleteCharAt(0);

    // for (int i = 0; i < n.length(); i++) {
    // if (n.charAt(i) != '0')
    // n.setCharAt(i, (char) ((Character.getNumericValue(n.charAt(i)) - 1) + '0'));
    // }

    // // increment count
    // res++;
    // }

    // System.out.println(res);
    // return res - 1;
    // }
}
