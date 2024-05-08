package Arrays;

import java.util.HashMap;
import java.util.Map;

public class test {
    public void removeDuplicate() {
        int[] a = { 1, 2, 2, 1, 12, 4, 1 };
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (a[i] == a[j] && i == j)
                    break;
            }
            System.out.println(a[i]);
        }
    }
}
