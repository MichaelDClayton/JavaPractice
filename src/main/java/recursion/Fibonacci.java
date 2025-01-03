package recursion;

//0 1 1 2 3 5 8 13 21
        /*
        if n = 6, then our function should return the 6th number in the fibonacci
        sequence.

        the 6th number is 8.
        8 is equal to (n - 1) + (n -2) which is equal to:
        5 + 3 = 8;
         */
public class Fibonacci {
    private static long[] fibonacciCache;

    public static void main(String[] args) {
        int n = 50;
        fibonacciCache = new long[n + 1];

        //System.out.println(fibonacci(n));
        System.out.println(fibonacciWithCache(n));
    }

    private static long fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    private static long fibonacciWithCache(int n) {
        if (n <= 1) {
            return n;
        }
        if (fibonacciCache[n] != 0) {
            return fibonacciCache[n];
        }
        long nthFibonacciNumber = (fibonacciWithCache(n - 1) + fibonacciWithCache(n - 2));
        fibonacciCache[n] = nthFibonacciNumber;
        return nthFibonacciNumber;
    }
}
