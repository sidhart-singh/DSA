package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        // Edge Case: endWord not in wordList
        if (!wordList.contains(endWord))
            return 0;

        HashMap<String, List<String>> adj = new HashMap<>();
        for (String word : wordList) {
            // char[] wordc = word.toCharArray();
            for (int i = 0; i < word.length(); i++) {
                String pattern = word.replace(word.charAt(i), '*');

                if (adj.containsKey(pattern)) {
                    adj.get(pattern).add(word);
                } else {
                    adj.put(pattern, new ArrayList<>(Arrays.asList(word)));
                }
            }
        }
        System.out.println(adj);

        // BFS

        // deque implemented using LinkedList to be able to enter 'null' value
        Deque<String> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();

        queue.add(beginWord);
        queue.add(null); // mark end of level
        visited.add(beginWord);
        int result = 1;
        /*
         * while(!queue.isEmpty()){ String word = queue.poll();
         * 
         * // end of a level if(word == null){ // increment count of level : first thing to do
         * result++;
         * 
         * // queue is empty : last level : end the loop if(queue.isEmpty()) break; // queue is not
         * empty : not the last level : add 'null' : mark end of level queue.add(null);
         * 
         * continue; }
         * 
         * if(word == endWord) return result;
         * 
         * for(int i = 0; i < word.length(); i++){ String pattern = word.replace(word.charAt(i),
         * '*'); for(String neiWord : adj.get(pattern)){ if(!visited.contains(neiWord)){
         * queue.add(neiWord); visited.add(neiWord); } } }
         * 
         * }
         */

        while (!queue.isEmpty()) {
            while (!queue.isEmpty()) {
                String word = queue.poll();

                // end of a level
                if (word == null) {
                    // increment count of level : first thing to do
                    result++;

                    // queue is empty : last level : end the loop
                    if (queue.isEmpty())
                        break;
                    // queue is not empty : not the last level : add 'null' : mark end of level
                    queue.add(null);

                    continue;
                }

                if (word == endWord)
                    return result;

                for (int i = 0; i < word.length(); i++) {
                    String pattern = word.replace(word.charAt(i), '*');
                    for (String neiWord : adj.get(pattern)) {
                        if (!visited.contains(neiWord)) {
                            queue.add(neiWord);
                            visited.add(neiWord);
                        }
                    }
                }

            }
            result++;
        }

        return result;
    }
}
