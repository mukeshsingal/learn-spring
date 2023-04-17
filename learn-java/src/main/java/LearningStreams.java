import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LearningStreams {
    public static void main(String[] args) {
        Arrays.asList("Mukesh", "Singal").stream()
                .sorted()
                .findFirst()
                .ifPresent(System.out::println);

        Stream.of("Apple", "Mango", "orangle")
                .sorted()
                .findFirst()
                .ifPresent(System.out::println);

        Stream.of("Apple", "Mango", "orangle")
                .filter(fruit -> {
                    return fruit.startsWith("f");
                })
                .forEach(fruit -> System.out.println(fruit));

        List<String> fruits = Stream.of("Apple", "Mango", "orangle")
                .map(fruit -> fruit.toUpperCase())
                .collect(Collectors.toList());

        System.out.println(fruits.toString());


        IntStream.range(1, 4).forEach(System.out::println);

        Arrays.stream(new int[] {1, 2}).
                map(n -> n *n)
                .average()
                .ifPresent(System.out::println);

        Arrays.stream(new int[] {1, 2}).
                mapToDouble(n -> n *n)
                .average()
                .ifPresent(System.out::println);



    }
}
