package Arrays;

public class MergeAlternatively {
    public String mergeAlternately(String word1, String word2) {
        char[] string1 = word1.toCharArray();
        char[] string2 = word2.toCharArray();

        char[] result = new char[string1.length + string2.length];
        int i, j, k;
        for (i = 0, j = 0, k = 0; i < string1.length && j < string2.length;) {
            if (k % 2 == 0)
                result[k++] = string1[i++];
            else
                result[k++] = string2[j++];
        }
        while (i < string1.length)
            result[k++] = string1[i++];
        while (j < string2.length)
            result[k++] = string2[j++];

        System.out.println(result);
        return result.toString();
    }
}
