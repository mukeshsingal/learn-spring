package StreamAPIs;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OfNullableMethod {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(10);

        /* If list is null, it will compiler will throw NullPointerException */
        list.stream().forEach(System.out::println);

        /* Instead of using list.stream() use Stream.ofNullable, even if list is null it will returen Stream.empty() */
        Stream.ofNullable(list).forEach(System.out::println);


    }
}
