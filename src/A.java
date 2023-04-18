import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class A {
    public static void main(String arg[]) {

        Map<String, Integer> mp = new HashMap<>();
        mp.put("B", 2);
        mp.put("A", 1);
        mp.put("C", 10);
        mp.put("D", 9);
        LinkedHashMap<String, Integer> sortedMap1 = mp.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> b,
                        LinkedHashMap::new
                ));

    }
}
