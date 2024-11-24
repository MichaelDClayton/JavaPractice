package math;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimeNumberChecker {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int limit = scanner.nextInt();
        isPrime(limit);
    }

    public static void isPrime(int limit){
        List<Integer> primeNumbers = new ArrayList<>();
        for(int numberToCheck = 2; numberToCheck <= limit; numberToCheck++){
            boolean isPrime = true;
            for(int factor = 2; factor <= numberToCheck/2; factor++){
                //System.out.println("Checking: "+numberToCheck +" with factor: "+factor);
                if(numberToCheck % factor == 0){
                    //System.out.println("Not Prime: "+numberToCheck);
                    isPrime = false;
                    break;
                }
            }
            if(isPrime){
                System.out.println("Is Prime: "+numberToCheck);
                primeNumbers.add(numberToCheck);
            }
        }
        System.out.println("Our Prime Numbers from 2 to "+limit + " Are:");
        for(Integer number: primeNumbers){
            System.out.println(number);
        }
    }
}
