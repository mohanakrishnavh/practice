package concurrency.prime;

public class PrimeNumberUtil {
    // Inefficient program to calculate prime number
    public static int calculatePrime(int n) {
        int number;
        int numberOfPrimesFound;
        int i;
        number = 1;
        numberOfPrimesFound = 0;

        while (numberOfPrimesFound < n) {
            number++;
            for (i = 2; i <= number && number % i != 0; i++) {
            }
            if (i == number) {
                numberOfPrimesFound++;
            }
        }

        return number;
    }
}
