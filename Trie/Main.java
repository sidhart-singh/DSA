package Trie;

public class Main {
    public static void main(String[] args) {
        WordSearchII ws2 = new WordSearchII();
        ws2.findWords(
                new char[][] { { 'o', 'a', 'b', 'n' }, { 'o', 't', 'a', 'e' }, { 'a', 'h', 'k', 'r' },
                        { 'a', 'f', 'l', 'v' } },
                new String[] { "oa", "oaa" });
    }
}
