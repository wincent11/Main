import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

class FindUniq {
    public static int squareSum(int[] n) {
        return Arrays.stream(n).map(e->e*e).sum();
    }
}