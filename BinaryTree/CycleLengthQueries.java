package BinaryTree;

public class CycleLengthQueries {

    public int[] cycleLengthQueriesOpt(int n, int[][] queries) {
        int result[] = new int[queries.length];

        for (int i = 0; i < queries.length; ++i) {
            result[i]++;
            int x = queries[i][0], y = queries[i][1];
            while (x != y) {
                if (x > y)
                    x /= 2;
                else
                    y /= 2;
                result[i]++;
            }
        }
        return result;
    }

    public int[] cycleLengthQueries(int n, int[][] queries) {
        /* Find distance between node a and node b */

        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++)
            result[i] = lca(queries[i]);

        return result;
    }

    public int lca(int[] q) {
        int x = q[0];
        int y = q[1];

        int steps = 1;
        while (x != y) {
            if (x > y)
                x /= 2;
            else
                y /= 2;

            steps++;
        }

        return steps;
    }
}
