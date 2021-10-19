import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(fibonacciSeries(500));

    }

    static ArrayList<BigInteger> fibonacciSeries(Integer number) {
        BigInteger a = new BigInteger("0");
        BigInteger b = new BigInteger("1");
        ArrayList<BigInteger> fNumbers = new ArrayList<>(Arrays.asList(a, b));
        int count = 2;
        while (count < number) {
            b = a.add(b);
            a = b.subtract(a);
            fNumbers.add(b);
            count++;
        }
        return fNumbers;
    }
}
