package Arrays;

public class PredictTheWinner {

    private void dfs(int[] nums, int left, int right, boolean onesTurn, int[] scores) {
        if (left > right)
            return;
        int[] choices = new int[] { nums[left], nums[right] };
        for (int index = 0; index < choices.length; index++) {
            // Node
            // update score
            if (onesTurn)
                scores[0] += choices[index];
            else
                scores[1] += choices[index];

            // children
            dfs(nums,
                    (index == 0 ? left + 1 : left),
                    (index == 1 ? right - 1 : right),
                    !onesTurn,
                    scores);

            // update index : index % (size - 1)
            // index = index == 0 ? 1 : 0;

            // undo changes
            // scores[] is passed by reference : so only score need to be undo
            if (onesTurn)
                scores[0] -= choices[index];
            else
                scores[1] -= choices[index];
        }

    }

    public boolean predictTheWinner(int[] nums) {
        int[] scores = { 0, 0 };

        dfs(nums, 0, nums.length - 1, true, scores);

        // return scores[0] >= scores[1];
    }
}
