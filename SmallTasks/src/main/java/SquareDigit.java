import java.util.Arrays;
import java.util.stream.Collectors;

public class SquareDigit {

    public int squareDigits(int n) {
//        return Integer.parseInt(Arrays.stream(String.valueOf(n).split("")).mapToInt(Integer::parseInt).
//                map(e -> e * e).mapToObj(Integer::toString).collect(Collectors.joining("")));
        return Integer.parseInt(Arrays.stream(String.valueOf(n).split("")).map(e->
            String.valueOf(Integer.parseInt(e)*Integer.parseInt(e))).collect(Collectors.joining("")));
    }

}