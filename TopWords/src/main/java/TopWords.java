import java.util.*;
import java.util.stream.Collectors;

public class TopWords {
    public static List<String> top3(String s) {
        List<String> sSplit = Arrays.stream(s.toLowerCase().replaceAll("\\s'+", "").split("[^\\w\']|_")).
                filter(i -> !i.isEmpty()).
                collect(Collectors.toList());

        return new HashSet<>(sSplit).
                stream().
                collect(Collectors.toMap(k -> k, v -> sSplit.stream().filter(e -> e.equals(v)).count())).
                entrySet().
                stream().
                sorted(Collections.reverseOrder(Comparator.comparingLong(Map.Entry::getValue))).
                map(Map.Entry::getKey).
                limit(3).
                collect(Collectors.toList());
    }
}