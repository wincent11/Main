import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindOdd {
    public static int findIt(int[] a) {
        return IntStream.of(a).boxed().collect(Collectors.toSet()).stream().filter(e-> Arrays.stream(a).
                filter(e::equals).count()%2!=0).findFirst().get();
    }
}