package Stack;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        AsteroidCollision ac = new AsteroidCollision();
        System.out.println(Arrays.toString(ac.asteroidCollision(new int[]{10, 2, -5})));
    }
}
