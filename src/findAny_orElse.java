import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class findAny_orElse {


    public static void main(String[] args) {

        List<Person> persons = Arrays.asList(
                new Person("mkyong", 30),
                new Person("jack", 20),
                new Person("lawrence", 40)
        );

        Optional<Person> result1 =
                persons.stream().filter(x -> "jacka".equals(x.getName()))
                        .findAny();
//                        .orElse(new Person("gaurav", 1));

//        Person result1 = persons.stream()                        // Convert to steam
//                .filter(x -> "jack".equals(x.getName()))        // we want "jack" only
//                .findAny()                                      // If 'findAny' then return found
//                .orElse(null);                                  // If not found, return null

//        System.out.println(result1);


        Person xyz = persons.stream()
                .filter(p -> {                //example for multiple condition
                    if ("jack".equals(p.getName()) && 20 == p.getAge()) {
                        return true;
                    }
                    return false;
                }).findAny()
                .orElse(null);

        Person result2 = persons.stream()
                .filter(x -> "ahmook".equals(x.getName()))
                .findAny()
                .orElse(null);

        System.out.println(result2);

    }
}