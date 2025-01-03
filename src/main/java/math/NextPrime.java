package math;

import java.util.Scanner;

public class NextPrime {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        int nextPrime = findNextPrime(number);
        System.out.println("The next prime number after " + number + " is " + nextPrime);
    }

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {

            if (num % i == 0) {
                System.out.println(num + " is not prime!");
                return false;
            }
        }
        return true;
    }

    public static int findNextPrime(int num) {
        int next = num + 1;
        while (!isPrime(next)) {
            next++;
        }
        return next;
    }


}