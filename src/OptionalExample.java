import java.util.Optional;

public class OptionalExample {

    public static void main(String[] args) {
        // Creating an empty Optional
        Optional<String> emptyOptional = Optional.empty();
        System.out.println(emptyOptional);

        // Creating an Optional from a non-null value
        Optional<Integer> optionalInteger = Optional.of(42);

        // Creating an Optional from a potentially null value
        Optional<String> optionalString = Optional.ofNullable("Hello, world!");

        // Checking if an Optional contains a value
        boolean isPresent = optionalInteger.isPresent();
        System.out.println("Is optionalInteger present? " + isPresent);

        // Retrieving the value from an Optional, or a default value if it's empty
        String value = optionalString.orElse("default value");
        System.out.println("Value of optionalString: " + value);

        // Retrieving the value from an Optional, or throwing an exception if it's empty
        String value2 = optionalString.orElseThrow(() -> new RuntimeException("Optional is empty!"));
        System.out.println("Value of optionalString: " + value2);

        // Transforming the value of an Optional using a Function
        Optional<String> upperCaseString = optionalString.map(s -> s.toUpperCase());
        System.out.println("Value of upperCaseString: " + upperCaseString.get());

        // Performing an action on the value of an Optional using a Consumer
        optionalString.ifPresent(s -> System.out.println("Value is present: " + s));

        // Using flatMap() to transform an Optional of one type into an Optional of another type
        Optional<Integer> optionalLength = optionalString.flatMap(s -> Optional.ofNullable(s.length()));
        System.out.println("Length of optionalString: " + optionalLength.get());

        // Chaining map() and flatMap() to perform a sequence of transformations on an Optional
        Optional<String> optional = Optional.of("hello, world");
        Optional<Integer> result = optional.map(s -> s.length()).flatMap(length -> Optional.of(length * 2));
        System.out.println("Result of chaining map() and flatMap(): " + result.get());
    }
}
