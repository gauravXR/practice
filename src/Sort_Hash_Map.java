import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Sort_Hash_Map {

    public static void main(String[] argv) {

        Map<String, Integer> unsortMap = new HashMap<>();
        unsortMap.put("z", 10);
        unsortMap.put("b", 5);
        unsortMap.put("a", 6);
        unsortMap.put("c", 20);
        unsortMap.put("d", 1);
        unsortMap.put("e", 7);
        unsortMap.put("y", 8);
        unsortMap.put("n", 99);
        unsortMap.put("g", 50);
        unsortMap.put("m", 2);
        unsortMap.put("f", 9);
        unsortMap.put("f", 9);


        System.out.println("Original...");
        System.out.println(unsortMap);

        LinkedHashMap<String,Integer>ss=unsortMap.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (old,newv)->old,
                LinkedHashMap::new
        ));



        // sort by keys, a,b,c..., and return a new LinkedHashMap
        // toMap() will returns HashMap by default, we need LinkedHashMap to keep the order.

     Map<String,Integer> res=unsortMap.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,
             (oldValue, newValue) -> oldValue, LinkedHashMap::new));
//        Map<String, Integer> result = unsortMap.entrySet().stream()
//                .sorted(Map.Entry.comparingByKey())
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
//                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));


        Map<String, Integer> res_value = unsortMap.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toMap(
                Map.Entry::getKey
                , Map.Entry::getValue,
                (oldvalue, newvalue) -> oldvalue,
                LinkedHashMap::new));
//In this case, the merge function (oldValue, newValue) -> oldValue simply returns the oldValue,
// which is the value that was already in the map for the given key. This means that if there
// are duplicate keys in the original Map, the resulting map will keep the value of the first occurrence of
// the key and discard the value of the subsequent occurrences.


        // Not Recommend, but it works.
        //Alternative way to sort a Map by keys, and put it into the "result" map
        Map<String, Integer> result2 = new LinkedHashMap<>();
        unsortMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEachOrdered(x -> result2.put(x.getKey(), x.getValue()));

        System.out.println("Sorted...");
//        System.out.println(result);
        System.out.println(result2);

    }

}