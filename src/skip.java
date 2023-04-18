import java.util.stream.Stream;

public class skip {
    public static void main(String[] args) {
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .filter(i -> true)
                .skip(2)
                .forEach(i -> System.out.print(i + " "));

        System.out.println("---------------------------------------");

        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .limit(2)
                .forEach(i -> System.out.print(i + " "));

        System.out.println("---------------------------------------");

        Stream.iterate(0, i -> i + 1)
                .limit(5)
                .forEach(System.out::print);

    }


}
