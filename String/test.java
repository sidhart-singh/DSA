package String;

public class test {

    public static void main(String[] args) {
        int target = 3;
        int pos = 0;
        int steps = 1;
        while (pos < Math.abs(target)) {
            if (pos + steps <= target)
                pos += steps++;
            else
                pos -= steps++;
            System.out.println(pos + " : " + (steps - 1));
            // steps++;
        }
        // return steps;
    }
}