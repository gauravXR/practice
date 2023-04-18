import java.util.*;
import java.util.stream.Collectors;

public class Stream_To_String {

    public static void main(String[] args) {

        List<Person> persons = Arrays.asList(new Person("mkyong", 30),
                new Person("jack", 20),
                new Person("lawrence", 40));

        String name = persons.stream().filter(x -> "jack".equals(x.getName())).map(Person::getName)                        //convert stream to String
                .findAny().orElse("");

        System.out.println("name : " + name);

        List<String> collect = persons.stream().map(Person::getName).collect(Collectors.toList());

        collect.forEach(System.out::println);


        Map<String, Integer> map = new HashMap<>();
        map.put("John", 20);
        map.put("Mary", 25);
        map.put("Bob", 18);
        map.put("Alice", 22);

        // Sort the map by value using streams
        Map<String, Integer> sortedMap = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new
                ));


    }

}