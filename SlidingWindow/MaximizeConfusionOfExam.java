package SlidingWindow;

public class MaximizeConfusionOfExam {

    private int maxConsecutiveChar(String ak, int k, char c) {
        int i = 0;
        int j = 0;
        int count = 0;
        int maxLength = 0;

        while (j < ak.length()) {

            // calculation for j-th element
            if (ak.charAt(j) == c) {
                count++;
            }

            // window -> valid
            // if(count <= k){
            // }

            // window -> invalid
            if (count > k) {
                // remove calculation for i-th element
                while (count > k) {
                    if (ak.charAt(i) == c)
                        count--;

                    // shrink window
                    i++;
                }
            }

            maxLength = Math.max(maxLength, (j - i + 1));
            j++;
        }

        return maxLength;
    }

    public int maxConsecutiveAnswers(String ak, int k) {
        int maxT = maxConsecutiveChar(ak, k, 'T');
        int maxF = maxConsecutiveChar(ak, k, 'F');

        System.out.println(Math.max(maxT, maxF));

        return Math.max(maxT, maxF);
    }
}