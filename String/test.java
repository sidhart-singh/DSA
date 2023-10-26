package String;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String[] inputNumbers = scanner.nextLine().split(" ");
            int q = Integer.MAX_VALUE;

            // Find the smallest number among input numbers
            for (String num : inputNumbers) {
                int currentNum = Integer.parseInt(num);
                if (currentNum < q) {
                    q = currentNum;
                }
            }

            int result = findSmallestPrime(inputNumbers, q);
            if (result != -1) {
                System.out.println(result);
            } else {
                System.out.println("None");
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int findSmallestPrime(String[] inputNumbers, int q) {
        for (int num = q; num < Math.pow(10, 10); num++) {
            boolean isPrime = true;
            for (String strNum : inputNumbers) {
                int currentNum = Integer.parseInt(strNum);
                if (currentNum != q && num % currentNum != q) {
                    isPrime = false;
                    break;
                }
            }
            if (!isPrime && isPrime(num)) {
                return num;
            }
        }
        return -1;
    }
}
