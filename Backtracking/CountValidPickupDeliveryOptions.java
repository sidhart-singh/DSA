package Backtracking;

// NOT WORKING
public class CountValidPickupDeliveryOptions {
    // NOTE:
    /*
     * tp - count of total pickups done
     * cp - count of pickups currently left to deliver
     */
    private void dfs(int n, int level, StringBuilder pd, StringBuilder num, int tp, int cp, int[] res) {
        if (level == n * 2) {
            System.out.println(pd);
            System.out.println(num);
            return;
        }

        if (tp < n && cp < n) {
            pd.append('p');
            num.append(level + 1);

            dfs(n, level + 1, pd, num, tp + 1, cp + 1, res);

            pd.deleteCharAt(pd.length() - 1);
            num.deleteCharAt(num.length() - 1);
        }

        for (int i = 0; i < cp; i++) {
            if (tp > 0 && cp > 0) {
                pd.append('d');
                num.append(i);

                dfs(n, level + 1, pd, num, tp, cp - 1, res);

                pd.deleteCharAt(pd.length() - 1);
                num.deleteCharAt(num.length() - 1);
            }
        }
    }

    public int countOrders(int n) {
        int[] res = { 0 };
        StringBuilder pd = new StringBuilder();
        StringBuilder num = new StringBuilder();

        dfs(n, 0, pd, num, 0, 0, res);

        return;
    }
}
