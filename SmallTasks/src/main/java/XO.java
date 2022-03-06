import java.util.Arrays;

public class XO {
    public static boolean getXO (String str) {
        return Arrays.stream(str.toLowerCase().split("")).filter(e->e.equals("x")).count() ==
                Arrays.stream(str.toLowerCase().split("")).filter(e->e.equals("o")).count();
    }
}