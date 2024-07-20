package String;

public class StringCompressionIII {
    public String compressedString(String word) {
        StringBuilder comp = new StringBuilder();
        char[] s = word.toCharArray();

        int count = 1;
        for (int i = 0; i < word.length(); i++) {
            if (i + 1 < s.length && s[i] == s[i + 1])
                count++;
            else {
                int q = count / 9;
                int r = count % 9;
                for (int j = 0; j < q; j++) {
                    comp.append(9).append(s[i]);
                }
                comp.append(r).append(s[i]);
                count = 1;
            }
        }

        System.out.println(comp);
        return comp.toString();
    }
}
