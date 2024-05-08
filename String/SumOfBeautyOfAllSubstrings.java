package String;

public class SumOfBeautyOfAllSubstrings {
    private int beauty(String s) {

    }

    public int beautySum(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length() + 1; j++) {
                System.out.println(s.substring(i, j));
                res += beauty(s.substring(i, j));
            }
        }

        return res;
    }
}
