package Arrays;

public class FlipStringToMonotoneIncreasing {

    String s = "00110";

    public int minFlipsMonoIncr(){

        int countOne = 0;
        int result = 0;

        for(int i = 0; i < s.length(); i++){
            if(Character.getNumericValue(s.charAt(i)) == 1){
                countOne++;
            } else {
                result = Math.min(result + 1, countOne);
            }
        }

        return result;
    }
}