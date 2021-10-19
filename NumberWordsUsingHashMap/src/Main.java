import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String list = "Bla bla Bla bla";

        HashMap<String, Integer> map = new HashMap<>();

        Arrays.asList(list.split(" ")).forEach(item -> {
            if (map.containsKey(item)) {
                map.put(item, map.get(item) + 1);
            } else map.put(item, 1);
        });
        System.out.println(map);

        Iterator iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.println("Key: " + entry.getKey()+" Value: "+entry.getValue());
        }

        System.out.println("-----------");

        for (Map.Entry entry: map.entrySet()){
            System.out.println("Key: " + entry.getKey()+" Value: "+entry.getValue());
        }
    }
}
