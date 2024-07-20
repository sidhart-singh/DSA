package SlidingWindow;

public class AlternatingColors {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int i = 1;
        int j = 0;
        int n = colors.length;
        int prev = 0;
        int res = 0;
        while (j < n) {
            // not checking with colors[(i % n) - 1] :
            // at (i == n) => colors[(i % n) - 1] = colors[-1] : ERROR
            if (colors[i % n] != colors[prev]) {
                if (i - j + 1 == k) {
                    res++;
                    j++;
                }
            } else {
                // when alternating fails and i(start of window) is behind j(end of window) :
                // rotating
                // then j shouldn't be set to i
                // otherwise infinite loop
                if (i < j) {
                    break;
                }
                j = i;
            }

            prev = i % n;
            i++;
        }

        return res;
    }
}
