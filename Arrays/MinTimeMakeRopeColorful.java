package Arrays;

public class MinTimeMakeRopeColorful {
    public int minCost(String colors, int[] cost) {
        int res = 0;
        int sum = 0;
        int max = 0;
        for (int i = 0; i < colors.length(); i++) {
            if (i > 0 && colors.charAt(i) != colors.charAt(i - 1)) {
                res += sum - max;
                max = sum = 0;
            }
            sum += cost[i];
            max = Math.max(max, cost[i]);
        }
        res += sum - max;

        System.out.println(res);
        return res;
    }
}
