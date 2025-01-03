package math;

public class ReduceIntegerToSingleDigit {

    public static int reduce(int n) {
        if (n < 10) return n;
        while (n > 10) {
            n = n / 10 + n % 10;
        }
        return n;
    }

    public static int reduceRecursion(int n) {
        if (n < 10) return n;
        n = n / 10 + n % 10;
        return reduceRecursion(n);

    }

}
