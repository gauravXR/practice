import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class B {
    public static void loopListJava8() {

        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add(null);
        list.add("D");
        list.add("E");

        // lambda
        // list.forEach(x -> System.out.println(x));

        // method reference
//        list.forEach(System.out::println);


        list.stream().filter(Objects::nonNull).forEach(System.out::println);


    }

    public static void main(String arg[]) {
//        loopListJava8();

//        The forEach does not guarantee the stream’s encounter order,
//        regardless of whether the stream is sequential or parallel.
//        The result is obvious when run in a parallel mode.


        Stream<String> s = Stream.of("a", "b", "c", "1", "2", "3");
        s.parallel().forEach(x -> System.out.println(x));//noOrder

//        5.2 The forEachOrdered guarantees the stream’s encounter order;
//        thus, it sacrifices the benefit of parallelism.

        Stream<String> st = Stream.of("a", "b", "c", "1", "2", "3","d");
        // keep order, it is always a,b,c,1,2,3
        st.parallel().forEachOrdered(x -> System.out.println(x));//parallel() can be removed


    }

}
