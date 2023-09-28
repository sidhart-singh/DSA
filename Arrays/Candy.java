package Arrays;

import java.util.Arrays;

public class Candy {
    public int candy(int[] ratings) {
        int[] candy = new int[ratings.length];
        int res = 0; // minimum candy required

        // 1,3,4,5,2
        candy[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1])
                candy[i] = candy[i - 1] + 1;
            else
                candy[i] = 1;
        }

        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && candy[i] <= candy[i + 1]) {
                candy[i] = candy[i + 1] + 1;
            }
        }

        for (int c : candy)
            res += c;

        // System.out.println(Arrays.toString(candy));
        return res;
    }
}
