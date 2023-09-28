package String;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray())
            set.add(c);

        Character[] cres = new Character[set.size()];
        set.toArray(cres);
        Arrays.sort(cres);
        System.out.println(Arrays.toString(cres));

        char[] res = new char[cres.length];
        for (int i = 0; i < cres.length; i++)
            res[i] = Character.valueOf(cres[i]);

        System.out.println(res);
        return String.valueOf(res)
    }
}
