import java.util.Arrays;

public class Kata {
    public static int[] digitize(long n) {
        return Arrays.stream(new StringBuilder(String.valueOf(n)).reverse().toString().split("")).mapToInt(Integer::parseInt).toArray();
    }

    public static int[] invert(int[] array) {

        return Arrays.stream(array).map(e->-e).toArray();
    }
}