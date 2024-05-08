package Backtracking;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BraceExpansionII {

    private String dfs() {

    }

    public List<String> braceExpansionII(String exp) {
        Set<String> set = new HashSet<>();

        dfs(exp, 0, '+', set)
    }
}
